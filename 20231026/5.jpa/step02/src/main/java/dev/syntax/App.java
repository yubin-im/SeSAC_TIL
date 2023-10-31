package dev.syntax;

import dev.syntax.model.Major;
import dev.syntax.model.Student;

public class App {

    public static void main(String[] args) {

        // 학생 2명 인스턴스 생성
        Student jo = new Student(1, "솔하");
        Student kang = new Student(2, "유신");

        // CS 전공 인스턴스 생성
        Major major = new Major(1, "CS");

        // 두 학생에게 CS 전공을 추가


    }

}
