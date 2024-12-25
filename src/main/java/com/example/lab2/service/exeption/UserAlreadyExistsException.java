package com.example.lab2.service.exeption;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String userName) {
        super(String.format("User with userName %s already exists", userName));
    }
}