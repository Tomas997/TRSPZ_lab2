package com.example.lab2.service.exeption;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String id) {
        super(String.format("Category With ID - %s Not Found", id));
    }
}
