package com.example.lab2.controller;

import com.example.lab2.dto.category.CategoryCreateDto;
import com.example.lab2.dto.category.CategoryResponseDto;
import com.example.lab2.dto.exception.MyValidationException;
import com.example.lab2.entity.Category;
import com.example.lab2.mapper.CategoryMapper;
import com.example.lab2.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        List<CategoryResponseDto> categoryResponseDtos = categoryMapper.categoryListToCategoryResponseDtoList(categories);
        return ResponseEntity.ok(categoryResponseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable int id) {
        Category categories = categoryService.getCategoryById(id);
        CategoryResponseDto categoryResponseDtos = categoryMapper.categoryToCategoryResponseDto(categories);
        return ResponseEntity.ok(categoryResponseDtos);
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody @Valid CategoryCreateDto categoryCreateDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            Map<String, String> errors = bindingResult.getFieldErrors().stream()
                    .collect(Collectors.toMap(
                            FieldError::getField,
                            FieldError::getDefaultMessage
                    ));

            throw new MyValidationException(errors);
        }
        Category category = categoryService.createCategory(categoryCreateDto);
        CategoryResponseDto responseDto = categoryMapper.categoryToCategoryResponseDto(category);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("categoryId") int categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.noContent().build();
    }
}

