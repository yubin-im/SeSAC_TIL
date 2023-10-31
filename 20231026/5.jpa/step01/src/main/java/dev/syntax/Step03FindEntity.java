package dev.syntax;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dev.syntax.model.Book;

public class Step03FindEntity {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");

        EntityManager manager = factory.createEntityManager();

        try {
            Book book = manager.find(Book.class, 5);
            System.out.println(book);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
            factory.close();
        }

    }

}
