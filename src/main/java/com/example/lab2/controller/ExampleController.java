package com.example.lab2.controller;

import com.example.lab2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {
    private final UserService service;

    @GetMapping
    public String example() {
        return "Hello, world!";
    }
}