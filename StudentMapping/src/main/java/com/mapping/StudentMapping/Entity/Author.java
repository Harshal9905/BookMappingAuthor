package com.mapping.StudentMapping.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Author {
	
	@Id
	private long authorId;
	
	private String authorName;
	
	@OneToMany(mappedBy = "author")
	@JsonIgnore 
	private List<Book> book;

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", book=" + book + "]";
	}

	public Author(long authorId, String authorName, List<Book> book) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.book = book;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
