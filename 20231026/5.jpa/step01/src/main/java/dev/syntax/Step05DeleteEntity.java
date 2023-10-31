package dev.syntax;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.syntax.model.Book;

public class Step05DeleteEntity {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");

        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();

        try {
            Book book = manager.find(Book.class, 3);  // id가 3인 Book 데이터 조회

            // Book 데이터 삭제
            tx.begin();  // 실제 쿼리로 치면 BEGIN;
            manager.remove(book);
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
