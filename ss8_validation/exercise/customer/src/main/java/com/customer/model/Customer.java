package com.customer.model;

import javax.persistence.*;

@Entity
@Table(name = "customer_validate")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    private String age;
    private String email;

    public Customer() {
    }

    public Customer(int id, String name, String phone, String age, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
