package dev.syntax.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    // 하나의 전공(1)은 여러 명의 학생(N)을 포함할 수 있다.
    // 여러 명의 학생(N)은 하나의 전공(1)에 속할 수 있다.
    @ManyToOne
    private Major major;


    // 기본 생성자는 public이 아닌 protected로
    protected Student() {
        super();
        System.out.println("Default Constructor book() called");
    }

    public Student(String studentName) {
        super();
        this.studentName = studentName;
    }

    public Student(int id, String studentName) {
        super();
        this.id = id;
        this.studentName = studentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", studentName=" + studentName + "]";
    }

}
