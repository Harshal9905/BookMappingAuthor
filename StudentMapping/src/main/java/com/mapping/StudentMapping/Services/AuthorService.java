package com.mapping.StudentMapping.Services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mapping.StudentMapping.Entity.Author;

public interface AuthorService {
	
	
	public ResponseEntity<Author> saveAuthor(Author author);
	
	public ResponseEntity<List<Author>> getAllAuthor();
	
	public ResponseEntity<Void> deleteAuthorById(Long authorId);
	
	public ResponseEntity<Author> findById(Long authorId);
	
	public ResponseEntity<Author> getByBookId(Long bookId);
}
