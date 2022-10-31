package com.blogservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String categoryName;

    @OneToMany(mappedBy = "category")
    @JsonBackReference//tạo vòng lặp vô hạng để khử đệ quy
    private Set<Blog> blogs;

    public Category() {
    }

    public Category(String categoryName, Set<Blog> blogs) {
        this.categoryName = categoryName;
        this.blogs = blogs;
    }

    public Category(int id, String categoryName, Set<Blog> blogs) {
        this.id = id;
        this.categoryName = categoryName;
        this.blogs = blogs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}
