package com.mapping.StudentMapping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.StudentMapping.Entity.Book;
import com.mapping.StudentMapping.Services.BookServices;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@Autowired
	private BookServices bookService;
	
	
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllbooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookbyId(@PathVariable("id") Long bookId) {
		return bookService.getBookbyId(bookId);
	}
	
	@GetMapping("/findByAuthor/{authorId}")
	public ResponseEntity<List<Book>> getAllByAuthorId(@PathVariable("authorId")Long AuthorId){
		return bookService.getAllBooksByAuthorId(AuthorId);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") Long bookId) {
		return bookService.deleteBook(bookId);
	}
	
	
}
