package com.library.model;

import javax.persistence.*;

@Entity
@Table(name = "back_book_table")
public class BackBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int bookId;
    private String bookCode;

    public BackBook() {
    }

    public BackBook(int bookId, String bookCode) {
        this.bookId = bookId;
        this.bookCode = bookCode;
    }

    public BackBook(int id, int bookId, String bookCode) {
        this.id = id;
        this.bookId = bookId;
        this.bookCode = bookCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }
}
