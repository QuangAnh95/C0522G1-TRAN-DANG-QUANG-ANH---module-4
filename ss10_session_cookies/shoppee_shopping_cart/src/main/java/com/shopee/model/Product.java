package com.shopee.model;

import javax.persistence.*;

@Entity
@Table(name = "product_table")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String image;

    @Column(columnDefinition = "TEXT")
    private String describe1;

    private double price;

    private short discount;

    public Product() {
    }

    public Product(String name, String image, String describe1, double price, short discount) {
        this.name = name;
        this.image = image;
        this.describe1 = describe1;
        this.price = price;
        this.discount = discount;
    }

    public Product(int id, String name, String image, String describe1, double price, short discount) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.describe1 = describe1;
        this.price = price;
        this.discount = discount;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescribe1() {
        return describe1;
    }

    public void setDescribe1(String describe1) {
        this.describe1 = describe1;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public short getDiscount() {
        return discount;
    }

    public void setDiscount(short discount) {
        this.discount = discount;
    }
}
