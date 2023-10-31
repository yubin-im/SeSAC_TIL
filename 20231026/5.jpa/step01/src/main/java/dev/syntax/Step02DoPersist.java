package dev.syntax;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.syntax.model.Book;

public class Step02DoPersist {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            Book book = new Book("JPA", "무명", new Date());
            manager.persist(book);  // 영속성 컨텍스트에 엔티티, INSERT 쿼리 보관
            transaction.commit();  // DB INSERT 쿼리 수행
        } catch (Exception e) {

        }

    }

}
