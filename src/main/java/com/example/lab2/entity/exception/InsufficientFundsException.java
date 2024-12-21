package com.example.lab2.entity.exception;

public class InsufficientFundsException extends RuntimeException {

    public InsufficientFundsException(double amount, double balance) {
        super(String.format("Insufficient funds: tried to withdraw %.2f, but only %.2f available.", amount, balance));
    }
}
