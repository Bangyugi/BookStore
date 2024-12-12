package com.group2.bookstore.service;

import com.group2.bookstore.dto.request.BookRequest;
import com.group2.bookstore.dto.response.BookResponse;
import com.group2.bookstore.dto.response.PageCustom;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookResponse createBook(BookRequest bookRequest);

    BookResponse getBook(Long bookId);

    BookResponse updateBook(Long bookId, BookRequest bookRequest);


    String deleteBook(Long bookId);

    PageCustom<BookResponse> getBookByTitle(String bookTitle, Pageable pageable);

    PageCustom<BookResponse> getAllBook(Pageable pageable);

    PageCustom<BookResponse> getAllBookByAuthorId(String authorName, Pageable pageable);

    PageCustom<BookResponse> getAllBookByCategory(String categoryName, Pageable pageable);
}
