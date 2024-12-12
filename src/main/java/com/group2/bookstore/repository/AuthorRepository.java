package com.group2.bookstore.repository;

import com.group2.bookstore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    Optional<Author> findByAuthorName(String authorName);

    boolean existsByAuthorName(String authorName);
}
