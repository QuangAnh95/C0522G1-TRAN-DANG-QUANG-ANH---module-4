package com.library.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "back_book_table")
public class BackBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idBook;
    private String bookCode;

    @OneToMany(mappedBy = "backBook")
    private Set<Book> books;

    public BackBook() {
    }

    public BackBook(int idBook, String bookCode) {
        this.idBook = idBook;
        this.bookCode = bookCode;
    }

    public BackBook(int id, int idBook, String bookCode) {
        this.id = id;
        this.idBook = idBook;
        this.bookCode = bookCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }
}
