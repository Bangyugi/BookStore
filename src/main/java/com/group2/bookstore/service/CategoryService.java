package com.group2.bookstore.service;

import com.group2.bookstore.dto.request.CategoryRequest;
import com.group2.bookstore.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse addCategory(CategoryRequest categoryRequest);

    CategoryResponse updateCategory(Long categoryId, CategoryRequest categoryRequest);

    CategoryResponse getCategoryById(Long categoryId);

    List<CategoryResponse> getAllCategory();

    String deleteCategory(Long categoryId);

    CategoryResponse getCategoryByCategoryName(String categoryName);
}
