package com.bookDeatils.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookDeatils.model.Book;
import com.bookDeatils.repo.BookRepo;

/**
 * BookController Class
 * ---------------------
 * This class handles all REST API requests related to Book entity.
 * 
 * Provides endpoints to perform CRUD operations:
 * - Create a single book or multiple books
 * - Read all books or specific books by ID, name, author, or price
 * - Delete books by ID or by name
 * 
 * Uses Spring's @RestController annotation to handle HTTP requests and
 * injects BookRepo to interact with the database.
 * 
 * Author: Madhusudan
 */
@RestController
public class BookController {

    // Inject BookRepo to access database operations
    @Autowired
    BookRepo repo;

    // Save a single book record
    @PostMapping("/saveBook")
    public String saveBook(@RequestBody Book book) {
        repo.save(book);
        return "Book Saved Successfully";
    }

    // Save multiple book records at once
    @PostMapping("/saveAllBooks")
    public String saveMultipleBooks(@RequestBody List<Book> book) {
        repo.saveAll(book);
        return "All Books Saved Successfully";
    }

    // Retrieve all books from the database
    @GetMapping("/viewAllBooks")
    public List<Book> getAllBooks() {
        return (List<Book>) repo.findAll();
    }

    // Retrieve a book by its ID
    @GetMapping("/viewBookById/{id}")
    public Optional<Book> getBookById(@PathVariable("id") Integer bookId) {
        return repo.findById(bookId);
    }

    // Retrieve books by book name
    @GetMapping("/viewBookByName/{name}")
    public List<Book> getBookByName(@PathVariable("name") String bookName) {
        return repo.findBybookName(bookName);
    }

    // Retrieve books by author's name
    @GetMapping("/viewBookByAuthorName/{author}")
    public List<Book> getBookByAuthorName(@PathVariable("author") String authorName) {
        return repo.findByauthorName(authorName);
    }

    // Retrieve books by price
    @GetMapping("/viewBookByPrice/{price}")
    public List<Book> getBookByPrice(@PathVariable("price") Long bookPrice) {
        return repo.findBybookPrice(bookPrice);
    }

    // Delete a book by its ID
    @DeleteMapping("/deleteBookById/{id}")
    public String deleteBookById(@PathVariable("id") Integer id) {
        repo.deleteById(id);
        return "Book Has Been Deleted";
    }

    // Delete a book by its name
    @DeleteMapping("/deleteBookByName/{name}")
    public String deleteByBookName(@PathVariable("name") String bookName) {
        repo.deleteBybookName(bookName);
        return "Book Has Been Deleted By Using Book Name";
    }
}
