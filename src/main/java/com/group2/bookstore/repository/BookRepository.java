package com.group2.bookstore.repository;

import com.group2.bookstore.entity.Author;
import com.group2.bookstore.entity.Book;
import com.group2.bookstore.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByBookTitle(String bookTitle);

    Page<Book> findAllByBookTitleContainingIgnoreCase(String bookTitle, Pageable pageable);

    @Query("SELECT b FROM Book b WHERE b.author.authorId =:authorId")
    Page<Book> findAllByAuthorId(Long authorId, Pageable pageable);

    Page<Book> findAllByCategories(Category category, Pageable pageable);

    boolean existsByBookTitle(String bookTitle);

    Page<Book> findAllByAuthor(Author author, Pageable pageable);
}
