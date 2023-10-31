package dev.syntax;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import dev.syntax.model.Book;

class Step06PCLifeCycleTest {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");

    EntityManager manager = factory.createEntityManager();

    EntityTransaction tx = manager.getTransaction();

    @Test
    public void testPersist를_수행할_경우_엔티티가_영속화되고_commit이_수행될_경우_DB에_저장된다() {
        tx.begin();

        Book jpaBook = new Book("JPA", "무명", new Date()); // util.date로 import
        manager.persist(jpaBook);

        tx.commit();

        Book foundBook = manager.find(Book.class, jpaBook.getId());
        System.out.println(jpaBook == foundBook);
        assertEquals(jpaBook, foundBook);
    }

    @Test
    void 한번_영속화된_엔티티는_다시_조회시_DB가_아닌_영속성컨텍스트에서_조회된다() {
        int id = 5;

        Book foundBook = manager.find(Book.class, id);
        System.out.println(foundBook);

        Book foundBookTwice = manager.find(Book.class, id);
        // 한 번 조회 후 다시 조회할 경우 한 번 더 SEELCT를 날리지 않음(왜?)
        assertEquals(foundBook, foundBookTwice);
    }

    @Test
    void 엔티티의_값을_수정하고_commit하면_변경감지가_발생되어_UPDATE쿼리가_수행된다() {
        int id = 5;
        tx.begin();
        Book foundBook = manager.find(Book.class, id);

        foundBook.updateBookName("ABC"); // foundBook 엔티티의 도서 이름 변경
//		manager.persist(foundBook);

        tx.commit(); // flush() 수행 전 변경 감지(Dirty Checking)
    }

    @Test
    void 만약_엔티티를_detach할경우_필드의_값을_변경해도_UPDATE쿼리가_수행되지_않는다() {
        int id = 5;

        tx.begin();
        Book foundBook = manager.find(Book.class, id);

        foundBook.updateBookName("XYZ");

        manager.detach(foundBook); // foundBook 엔티티를 영속성 컨텍스트에서 분리(Detach)

        tx.commit();// UPDATE 쿼리가 수행되지 않은 것 확인

        Book foundBookTwice = manager.find(Book.class, id); // PC에서 제거되었기 때문에 다시 SELECT가 수행됨
        System.out.println(foundBook == foundBookTwice);

        assertNotEquals(foundBook, foundBookTwice);
    }

    @Test
    void remove를_수행할_경우_PC와_DB에서_데이터가_제거된다() {
        int id = 9;
        tx.begin();

        Book foundBook = manager.find(Book.class, id);
        manager.remove(foundBook);

        tx.commit();

        // DB에서 제거될 경우, PC에서도 제거되는지
        // PC에 없기 떄문에 SELECT를 한 번 더 수정했지만 레코드가 없기 때문에 jpaBook은 null이 된다.
        assertThrows(NullPointerException.class, () -> {
            Book jpaBook = manager.find(Book.class, foundBook.getId());
            jpaBook.updateBookName("Effective Unit Testing");

            // PC에 남아있으면 SELECT를 수행하지 않기 떄문에 기존에 있던 엔티티랑 비교시 true가 나올 것
            assertFalse(foundBook == jpaBook);  // Assert.assertFalse로 import
            assertNull(jpaBook);
        });
    }

    @Test
    void 영속성컨텍스트를_초기화할경우_모든_엔티티가_제거됨() {
        int id = 8;

        Book foundBook = manager.find(Book.class, id);

        manager.clear();
        Book jpaBook = manager.find(Book.class, id);

        assertEquals(foundBook, jpaBook);


    }

    @Test
    void 엔티티매니저가_제거됨() {
        manager.close();
        EntityManager manager2 = factory.createEntityManager();
        assertEquals(manager, manager2);
    }

    @Test
    void 저장된_엔티티를_조회할_수_있는지_테스트() {
        tx.begin();

        Book newBook = new Book("새로운 책", "작가", new Date());
        manager.persist(newBook);

        tx.commit();

        int id = newBook.getId();
        Book foundBook = manager.find(Book.class, id);

        assertNotNull(foundBook); // 엔티티가 정상적으로 저장되어 조회되었는지 확인
        assertEquals("새로운 책", foundBook.getBookName()); // 엔티티의 필드 값 확인
    }


}
