package dev.syntax;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.syntax.model.Book;

public class Step04UpdateEntity {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");

        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();

        try {
            Book book = manager.find(Book.class, 3);  // id가 3인 Book 데이터 조회

            // Book 데이터 수정
            tx.begin();  // 실제 쿼리로 치면 BEGIN;
            book.updateBookName("컴퓨터 과학이 여는 세계");
            manager.persist(book);
            tx.commit();

            System.out.println(book);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            manager.close();
            factory.close();

        }
    }

}
