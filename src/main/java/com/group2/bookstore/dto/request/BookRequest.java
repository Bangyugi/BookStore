package com.group2.bookstore.dto.request;

import com.group2.bookstore.entity.Author;
import com.group2.bookstore.entity.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    @NotNull(message = "Book title is required")
    @NotBlank(message = "Book title is required")
    @NotEmpty(message = "Book title is required")
    private String bookTitle;

    private String bookDescription;
    @Min(value = 1, message = "Unit price must be greater than 0")
    private Long unitPrice;
    private Long boughtAmount;
    private Set<String> categoryNames;

    @NotNull(message = "Author name is required")
    @NotBlank(message = "Author name is required")
    @NotEmpty(message = "Author name is required")
    private String authorName;
}
