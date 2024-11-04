package com.example.lab2.service;

import com.example.lab2.dto.category.CategoryCreateDto;
import com.example.lab2.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category createCategory(CategoryCreateDto categoryCreateDto);
    void deleteCategory(int categoryId);
}
