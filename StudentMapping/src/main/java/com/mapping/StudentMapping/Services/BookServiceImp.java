package com.mapping.StudentMapping.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mapping.StudentMapping.Entity.Book;
import com.mapping.StudentMapping.Repository.BookRepository;
@Service
public class BookServiceImp implements BookServices{
	@Autowired
	private BookRepository bookRepository;

	@Override
	public ResponseEntity<Book> saveBook(Book book) {
		try {
			if(book == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				
			}
			Book savedBook = bookRepository.save(book);
			return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<List<Book>> getAllBooksByAuthorId(Long authorId) {
		try {
			List<Book> book = bookRepository.findAllByAuthor_AuthorId(authorId);
			if(book.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else{
				return new ResponseEntity<>(book, HttpStatus.OK);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<Book> getBookbyId(Long bookId) {
		try {
			Optional<Book> book = bookRepository.findById(bookId);
			if (book.isPresent()) {
				return new ResponseEntity<>(book.get(), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<Void> deleteBook(Long bookId) {
		try {
			if(bookRepository.existsById(bookId)) {
				bookRepository.deleteById(bookId);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		bookRepository.deleteById(bookId);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<List<Book>> getAllBooks() {
		try {
			List<Book> bookList = bookRepository.findAll();
			if(bookList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else {
				return new ResponseEntity<>(bookList, HttpStatus.OK);
			}
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
