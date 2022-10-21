package com.blog.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategory;
    private String nameCategory;

    @OneToMany(mappedBy = "category")
    private Set<Blog> blogs;

    public Category() {
    }

    public Category(String nameCategory, Set<Blog> blogs) {
        this.nameCategory = nameCategory;
        this.blogs = blogs;
    }

    public Category(int idCategory, String nameCategory, Set<Blog> blogs) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.blogs = blogs;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}
