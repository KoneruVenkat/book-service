package com.tr;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
@RestController
public class BookController {

	
	private static final Book allbooks[]= {
		new Book(1, "Java Book", "Joshua Bloch", 800),
		new Book(2, "Head First Java", "Kathy Sierra", 1000),
		new Book(3, "Spring in Action", "Craig Walls", 2000),
		
	};
	
	@GetMapping("/books")
	public Book[] getAllBooks() {
		return allbooks;
	}
	
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		for (Book book : allbooks) {
			
			if(book.getId()==id) {
				return book;
			}
			
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not available");
	}
}
