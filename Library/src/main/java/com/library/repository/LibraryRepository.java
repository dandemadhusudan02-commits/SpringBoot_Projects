/**
 * 
 */
package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.model.Book;

import jakarta.transaction.Transactional;


/**
 * 
 */
public interface LibraryRepository extends JpaRepository<Book, Long>{

	public Book findBybookName(String bookName);
	public Book findBybookPrice(double bookPrice);
	public Book findBybookAuthor(String bookAuthor);
	@Transactional
	public String deleteBybookName(String bookName);
	@Transactional
	public String deleteBybookAuthor(String bookAuthor);
	@Transactional
	public String deleteBybookPrice(double bookPrice);
}
