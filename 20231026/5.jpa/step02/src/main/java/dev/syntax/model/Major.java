package dev.syntax.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Major")
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "major_name", nullable = false)
    private String majorName;

    // 기본 생성자는 public이 아닌 protected로
    protected Major() {
        super();
        System.out.println("Default Constructor Major() called");
    }

    public Major(String majorName) {
        super();
        this.majorName = majorName;
    }

    public Major(int id, String majorName) {
        super();
        this.id = id;
        this.majorName = majorName;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getMajorName() {
        return majorName;
    }


    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    @Override
    public String toString() {
        return "Major [id=" + id + ", majorName=" + majorName + "]";
    }


}
