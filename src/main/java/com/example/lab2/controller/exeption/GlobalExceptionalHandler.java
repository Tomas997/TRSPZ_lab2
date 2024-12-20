package com.example.lab2.controller.exeption;


import com.example.lab2.dto.exception.MyValidationException;
import com.example.lab2.service.exeption.CategoryNotFoundException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ProblemDetail.forStatusAndDetail;


@RestControllerAdvice
public class GlobalExceptionalHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CategoryNotFoundException.class)
    public ProblemDetail handleCategoryNotFoundException(CategoryNotFoundException ex) {
        ProblemDetail problemDetail = forStatusAndDetail(NOT_FOUND, ex.getMessage());
        problemDetail.setType(URI.create("category-not-found"));
        problemDetail.setTitle("Category Not Found");
        return problemDetail;
    }

    @ExceptionHandler(MyValidationException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MyValidationException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", ex.getMessage());
        response.put("errors", ex.getValidationErrors());
        response.put("timestamp", LocalDateTime.now());

        return ResponseEntity.badRequest().body(response);
    }
}

