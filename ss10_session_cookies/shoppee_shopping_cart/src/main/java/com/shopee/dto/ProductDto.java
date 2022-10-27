package com.shopee.dto;

import javax.persistence.Column;
import java.util.Objects;

public class ProductDto {
    private int id;

    private String name;

    private String image;

    private String describe;

    private double price;

    private short discount;

    public ProductDto() {
    }

    public ProductDto(String name, String image, String describe, double price, short discount) {
        this.name = name;
        this.image = image;
        this.describe = describe;
        this.price = price;
        this.discount = discount;
    }

    public ProductDto(int id, String name, String image, String describe, double price, short discount) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.describe = describe;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image, describe, price, discount);
    }

}
