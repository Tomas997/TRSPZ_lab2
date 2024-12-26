package com.example.lab2.service.exeption;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(long id) {
        super(String.format("User with id %s not found", id));
    }
}
