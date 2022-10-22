package com.blog.model;
import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private String content;
    private String date;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "idCategory")
    private Category category;


    public Blog() {
    }

    public Blog(String title, String author, String content, String date) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.date = date;
    }

    public Blog(int id, String title, String author, String content, String date) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.date = date;
    }

    public Blog(int id, String title, String author, String content, String date, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.date = date;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
