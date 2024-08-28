package com.mapping.StudentMapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.StudentMapping.Entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

	Author findAllByBook_BookId(Long bookId);

}
