package com.iyb;

import java.util.Objects;

public class Employee {
    private String id;
    private String pwd;
    private String name;
    private String email;
    private String phone;
    private String jumin;

    public Employee(String id, String pwd, String name, String email, String phone, String jumin) {
        super();
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.jumin = jumin;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJumin() {
        return jumin;
    }

    public void setJumin(String jumin) {
        this.jumin = jumin;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", jumin='" + jumin + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(pwd, employee.pwd) && Objects.equals(name, employee.name) && Objects.equals(email, employee.email) && Objects.equals(phone, employee.phone) && Objects.equals(jumin, employee.jumin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pwd, name, email, phone, jumin);
    }

    public String getId() {
        return this.id;
    }

}
