package com.bookDeatils.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookDeatils.model.Book;

import jakarta.transaction.Transactional;

/**
 * BookRepo Interface
 * -------------------
 * This interface extends JpaRepository to provide CRUD operations for the Book entity.
 * 
 * In addition to standard CRUD methods provided by JpaRepository, this interface 
 * defines custom query methods based on Spring Data JPA naming conventions.
 * 
 * Examples:
 * - findBybookName       → Find books by their name
 * - findByauthorName     → Find books by author's name
 * - findBybookPrice      → Find books by price
 * - deleteBybookName     → Delete books by their name
 * 
 * Transactional annotation is used for delete operation to ensure database consistency.
 * 
 * Author: Madhusudan
 */
public interface BookRepo extends JpaRepository<Book, Integer> {

    // Fetch all books with the given book name
    List<Book> findBybookName(String bookName);

    // Fetch all books written by the given author
    List<Book> findByauthorName(String authorName);

    // Fetch all books that have the specified price
    List<Book> findBybookPrice(long bookPrice);

    // Delete books by book name (Transactional ensures database consistency)
    @Transactional
    String deleteBybookName(String bookName);
}
