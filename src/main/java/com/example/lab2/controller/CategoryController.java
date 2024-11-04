package com.example.lab2.controller;

import com.example.lab2.dto.category.CategoryCreateDto;
import com.example.lab2.dto.category.CategoryResponseDto;
import com.example.lab2.entity.Category;
import com.example.lab2.mapper.CategoryMapper;
import com.example.lab2.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;
    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        List<CategoryResponseDto> categoryResponseDtos = categoryMapper.categoryListToCategoryResponseDtoList(categories);
        return ResponseEntity.ok(categoryResponseDtos);
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CategoryCreateDto categoryCreateDto) {
        Category category = categoryService.createCategory(categoryCreateDto);
        CategoryResponseDto responseDto = categoryMapper.categoryToCategoryResponseDto(category);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("categoryId") int categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.noContent().build();
    }
}

