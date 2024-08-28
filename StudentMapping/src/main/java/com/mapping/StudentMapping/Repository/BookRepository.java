package com.mapping.StudentMapping.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.StudentMapping.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	List<Book> findAllByAuthor_AuthorId(Long authorId);


}
