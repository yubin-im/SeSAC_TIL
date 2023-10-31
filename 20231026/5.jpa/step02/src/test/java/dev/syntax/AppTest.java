package dev.syntax;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import dev.syntax.model.Major;
import dev.syntax.model.Student;

public class AppTest {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("step02");
    EntityManager manager = factory.createEntityManager();
    EntityTransaction tx = manager.getTransaction();

    @Test
    void testSave() {
        tx.begin();

        // 컴퓨터 공학과 저장
        Major major = new Major("컴퓨터공학과");
        manager.persist(major);

        // 학생 2명 생성 및 저장
        Student student1 = new Student("임유빈");
        student1.setMajor(major);
        manager.persist(student1);

        Student student2 = new Student("김수한무");
        student2.setMajor(major);
        manager.persist(student2);

        tx.commit();
    }

    @Test
    void testRead() {

        // id가 6인 학생 엔티티 조회
        int id = 6;
        Student findStudent = manager.find(Student.class, id);
        System.out.println("id가 " + id + "인 학생: " + findStudent);

        // 해당 학생의 전공 조회
        Major findMajor = manager.find(Major.class, findStudent.getMajor().getId());
        System.out.println("id가 " + id + "인 학생의 전공: " + findMajor);

    }

    @Test
    void updateRelation() {

        // 한 명의 학생 조회 후 해당 학생의 전공을 다른 학과로 변경
        int id = 6;

        tx.begin();

        Student findStudent = manager.find(Student.class, id);

        // 전공 생성
        Major newMajor = new Major("경영학과");
        manager.persist(newMajor);

        // 학생 전공 변경
        findStudent.setMajor(newMajor);
        manager.persist(findStudent);
        tx.commit();

    }

    @Test
    void deleteEntity() {

        // 한 명의 학생 조회 후 해당 학생의 전공을 제거
        int id = 7;

        tx.begin();

        Student findStudent = manager.find(Student.class, id);
        findStudent.setMajor(null);

        Major major = manager.find(Major.class, 2);
        manager.remove(major);

        tx.commit();

    }

}
