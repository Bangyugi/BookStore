package com.group2.bookstore.service;

import com.group2.bookstore.dto.request.AuthorRequest;
import com.group2.bookstore.dto.response.AuthorResponse;

import java.util.List;

public interface AuthorService {
    AuthorResponse createAuthor(AuthorRequest authorRequest);

    AuthorResponse getAuthor(Long authorId);

    String deleteAuthor(Long authorId);

    AuthorResponse updateAuthor(Long authorId, AuthorRequest authorRequest);

    List<AuthorResponse> getAllAuthors();
}
