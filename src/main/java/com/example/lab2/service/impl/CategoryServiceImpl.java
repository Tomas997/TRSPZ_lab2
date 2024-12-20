package com.example.lab2.service.impl;

import com.example.lab2.dto.category.CategoryCreateDto;
import com.example.lab2.entity.Category;
import com.example.lab2.repository.CategoryRepository;
import com.example.lab2.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return new ArrayList<>(categoryRepository.findAll());
    }

    @Override
    public Category createCategory(CategoryCreateDto categoryCreateDto) {
        Category category = Category.builder()
                .name(categoryCreateDto.getName())
                .build();
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}


