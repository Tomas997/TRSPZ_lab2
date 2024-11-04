package com.example.lab2.service.impl;

import com.example.lab2.dto.category.CategoryCreateDto;
import com.example.lab2.entity.Category;
import com.example.lab2.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final Map<Integer, Category> categories = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    @Override
    public List<Category> getAllCategories() {
        return new ArrayList<>(categories.values());
    }

    @Override
    public Category createCategory(CategoryCreateDto categoryCreateDto) {
        int newId = idCounter.getAndIncrement();
        Category category = new Category(newId, categoryCreateDto.getName());
        categories.put(newId, category);
        return category;
    }

    @Override
    public void deleteCategory(int categoryId) {
        categories.remove(categoryId);
    }
}


