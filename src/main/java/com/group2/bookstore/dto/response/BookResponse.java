package com.group2.bookstore.dto.request;

import com.group2.bookstore.entity.Author;
import com.group2.bookstore.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private Long bookId;
    private String bookTitle;
    private String bookDescription;
    private Long unitPrice;
    private Long boughtAmount;
    private Set<Category> categories;
    private Author author;
}
