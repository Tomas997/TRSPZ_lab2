package com.example.lab2.mapper;

import com.example.lab2.dto.category.CategoryResponseDto;
import com.example.lab2.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponseDto categoryToCategoryResponseDto(Category category);
    List<CategoryResponseDto> categoryListToCategoryResponseDtoList(List<Category> categoryList);
}