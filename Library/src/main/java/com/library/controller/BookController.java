/**
 * 
 */
package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.Book;
import com.library.service.LibraryService;

/**
 * 
 */
@RestController
@RequestMapping("/library")
public class BookController {

	@Autowired
	private LibraryService libraryService;
	
	//save book
	@PostMapping("/saveBook")
	public Book saveBook(@RequestBody Book book) {
		return libraryService.saveBook(book);
	}
	
	//save multiple books
	@PostMapping("/saveAll")
	public List<Book> saveAllBooks(@RequestBody List<Book> book){
		return libraryService.saveAllBooks(book);
	}
	
	//get book by id
	@GetMapping("/viewBookById/{id}")
	public Book getBookById(@PathVariable ("id") Long bookId) {
		return libraryService.getBookById(bookId);
	}
	
	//get multiple books
	@GetMapping("/viewAll")
	public List<Book> getAllBooks(){
		return libraryService.getMultipleBooks();
	}
	
	//get book by name
	@GetMapping("/viewBookByName/{name}")
	public Book getBookByName(@PathVariable ("name") String bookName) {
		return libraryService.getBookByName(bookName);
	}
	
	//get book by price
	@GetMapping("viewBookByPrice/{price}")
	public Book getBookByPrice(@PathVariable ("price") double bookPrice) {
		return libraryService.getBookByPrice(bookPrice);
	}
	
	//get book by author
	@GetMapping("/viewBookByAuthor/{auhtor}")
	public Book getBookByAuthor(@PathVariable ("auhtor") String bookAuthor) {
		return libraryService.getBookByAuthor(bookAuthor);
	}
	
	//delete book by id
	@DeleteMapping("deleteBookById/{id}")
	public String deleteBookById(@PathVariable ("id") Long bookId) {
		return libraryService.deleteBookById(bookId);
	}
	
	//delete book  by name
	@DeleteMapping("deleteBookByName/{name}")
	public String deleteBookByName(@PathVariable ("name") String bookName) {
		return libraryService.deleteBookByName(bookName);
		}
		
	//delete book by price
	@DeleteMapping("/deleteBookByPrice/{price}")
	public String deleteBookByPrice(@PathVariable ("price") double bookPrice) { 
		return libraryService.deleteBookByPrice(bookPrice);
		}
		
	//delete book by author
	@DeleteMapping("/deleteBookByAuthor/{author}")
	public String deleteBookByAuthor(@PathVariable ("author") String bookAuthor) {
			return libraryService.deleteBookByAuthor(bookAuthor);
		}
	
	//update book price
	@PutMapping("/updateBookPrice/{id}")
	public Book updateBookPrice(@PathVariable ("id") Long bookId,@RequestBody Book book) {
		return libraryService.updateBookPrice(bookId, book);
	}
	
}
