package com.mapping.StudentMapping.Services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.mapping.StudentMapping.Entity.Book;


public interface BookServices {
	
	public ResponseEntity<Book> saveBook(Book book);
	
	public ResponseEntity<List<Book>> getAllBooksByAuthorId(Long authorId);
	
	public ResponseEntity<Book> getBookbyId(Long bookId);
	
	public ResponseEntity<Void> deleteBook(Long bookId);

	public ResponseEntity<List<Book>> getAllBooks();
	
	
	
	
}
