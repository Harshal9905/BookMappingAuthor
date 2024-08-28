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

import com.mapping.StudentMapping.Entity.Author;
import com.mapping.StudentMapping.Services.AuthorService;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@PostMapping
	public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
		return authorService.saveAuthor(author);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Author>> getAllAuthor() {
		return authorService.getAllAuthor();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable("id") Long authorId) {
		return authorService.findById(authorId);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAuthorById(@PathVariable("id") Long authorId) {
		return authorService.deleteAuthorById(authorId);
	}
	
	@GetMapping("/findByBook/{bookId}")
	public ResponseEntity<Author> getByBookId(@PathVariable("bookId") Long bookId) {
		return authorService.getByBookId(bookId);
	}

}
