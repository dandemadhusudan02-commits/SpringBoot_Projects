package com.bookDeatils.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Book Entity Class
 * ------------------
 * Represents a book record in the "BookDetails" table of the database.
 * 
 * This class is a JPA entity that maps to a database table with fields:
 * - bookId       : Primary key, auto-generated
 * - bookName     : Name of the book
 * - authorName   : Name of the author
 * - bookPrice    : Price of the book
 * 
 * Includes default constructor, parameterized constructor, getters & setters, 
 * and overridden toString() for easy object representation.
 * 
 * Author: Madhusudan
 */
@Entity
@Table(name = "BookDetails")
public class Book {

    // Primary key, auto-generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;

    // Name of the book
    private String bookName;

    // Name of the author
    private String authorName;

    // Price of the book
    private long bookPrice;

    // Default constructor
    public Book() {
        super();
    }

    // Parameterized constructor to create Book object with all fields
    public Book(int bookId, String bookName, String authorName, long bookPrice) {
        super();
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookPrice = bookPrice;
    }

    // Getter and Setter methods

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public long getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(long bookPrice) {
        this.bookPrice = bookPrice;
    }

    // Overridden toString method for easy display of Book object
    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", bookPrice="
                + bookPrice + "]";
    }
}
