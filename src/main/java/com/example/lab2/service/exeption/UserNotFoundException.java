package com.example.lab2.service.exeption;


public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(long id) {
        super(String.format("User with id %s not found", id));
    }
    public UserNotFoundException(String userName) {
        super(String.format("User with userName %s not found", userName));
    }
}