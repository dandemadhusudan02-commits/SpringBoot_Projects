/**
 * 
 */
package com.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.model.Book;

import com.library.repository.LibraryRepository;

/**
 * 
 */
@Service
public class LibraryService {

	private final LibraryRepository libraryRepository;

	public LibraryService(LibraryRepository libraryRepository) {
		super();
		this.libraryRepository = libraryRepository;
	}
	
	//create book
	public Book saveBook(Book book) {
		return libraryRepository.save(book);
	}
	
	//create multiple books
	public List<Book> saveAllBooks(List<Book> book){
		return (List<Book>) libraryRepository.saveAll(book);
	}
	
	//get book by id
	public Book getBookById(Long bookId) {
		return libraryRepository.findById(bookId).orElse(null);
	}
	
	//get multiple books
	public List<Book> getMultipleBooks(){
		return libraryRepository.findAll();
	}
	
	//get book by name
	public Book getBookByName(String bookName) {
		return libraryRepository.findBybookName(bookName);
	}
	
	//get book by price
	public Book getBookByPrice(double bookPrice) {
		return libraryRepository.findBybookPrice(bookPrice);
	}
	
	//get book by author
	public Book getBookByAuthor(String bookAuthor) {
		return libraryRepository.findBybookAuthor(bookAuthor);
	}
	
	//delete book  by id
	public String deleteBookById(Long bookId) {
		 libraryRepository.deleteById(bookId);
		 return "Book Deleted By Id Succesfully";
	}
	
	//delete book  by name
	
	public String deleteBookByName(String bookName) {
		libraryRepository.deleteBybookName(bookName);
		return "Book Deleted By Name Successfully ";
	}
	
	//delete book by price
	public String deleteBookByPrice(double bookPrice) {
		libraryRepository.deleteBybookPrice(bookPrice);
		return "Book Deleted By Price SUccessfully";
	}
	
	//delete book by author
	public String deleteBookByAuthor(String bookAuthor) {
		libraryRepository.deleteBybookAuthor(bookAuthor);
		return "Book Deleted By Author Successfully";
	}
	
	//update book price
	public Book updateBookPrice(Long bookId,Book book) {
		return libraryRepository.findById(bookId).
				map(a->{
					if(book.getBookPrice()!=0) a.setBookPrice(book.getBookPrice());
					return libraryRepository.save(a);
				}).orElseThrow(()->new RuntimeException("Book Id not found"+bookId));
	}
}
