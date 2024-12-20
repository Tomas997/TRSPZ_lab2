package com.example.lab2.service;

import com.example.lab2.entity.Account;

public interface AccountService {

    Account getAccount(int userId);

    void addMoney(int userId, double amount);

    void withdrawMoney(int userId, double amount);
}
