package com.practice12.model;

import javax.persistence.*;

@Entity
@Table(name = "smartPhone")
public class SmartPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String produce;
    private String model;
    private double price;

    public SmartPhone() {
    }

    public SmartPhone(String produce, String model, double price) {
        this.produce = produce;
        this.model = model;
        this.price = price;
    }

    public SmartPhone(long id, String produce, String model, double price) {
        this.id = id;
        this.produce = produce;
        this.model = model;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
