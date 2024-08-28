package com.mapping.StudentMapping.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.mapping.StudentMapping.Entity.Author;
import com.mapping.StudentMapping.Repository.AuthorRepository;

@Service
public class AuthorServiceImp implements AuthorService{
	
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public ResponseEntity<Author> saveAuthor(Author author) {
		try {
			if (author == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			Author savedAuthor = authorRepository.save(author);
			return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<Author> getByBookId(Long bookId) {
		try {
			Author author = authorRepository.findAllByBook_BookId(bookId);
			if (author != null) {
				return new ResponseEntity<>(author, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<List<Author>> getAllAuthor() {
		try {
			List<Author> authors = authorRepository.findAll();
			if (authors.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(authors, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<Void> deleteAuthorById(Long authorId) {
		try {
			if(authorRepository.existsById(authorId)) {
				authorRepository.deleteById(authorId);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<Author> findById(Long authorId) {
		try {
			Optional<Author> author = authorRepository.findById(authorId);
			if (author.isPresent()) {
				return new ResponseEntity<>(author.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	

}
