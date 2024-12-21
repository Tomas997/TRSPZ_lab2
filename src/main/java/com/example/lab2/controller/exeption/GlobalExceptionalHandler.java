package com.example.lab2.controller.exeption;


import com.example.lab2.dto.exception.MyValidationException;
import com.example.lab2.entity.exception.InsufficientFundsException;
import com.example.lab2.service.exeption.CategoryNotFoundException;
import com.example.lab2.service.exeption.RecordNotFoundException;
import com.example.lab2.service.exeption.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
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

    @ExceptionHandler(RecordNotFoundException.class)
    public ProblemDetail handleRecordNotFoundException(RecordNotFoundException ex) {
        ProblemDetail problemDetail = forStatusAndDetail(NOT_FOUND, ex.getMessage());
        problemDetail.setType(URI.create("record-not-found"));
        problemDetail.setTitle("Record Not Found");
        return problemDetail;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ProblemDetail handleUserNotFoundException(UserNotFoundException ex) {
        ProblemDetail problemDetail = forStatusAndDetail(NOT_FOUND, ex.getMessage());
        problemDetail.setType(URI.create("user-not-found"));
        problemDetail.setTitle("User Not Found");
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

    @ExceptionHandler(InsufficientFundsException.class)
    public ProblemDetail handleInsufficientFundsException(InsufficientFundsException ex) {
        ProblemDetail problemDetail = forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        problemDetail.setType(URI.create("insufficient-funds"));
        problemDetail.setTitle("Insufficient Funds");
        return problemDetail;
    }

}

