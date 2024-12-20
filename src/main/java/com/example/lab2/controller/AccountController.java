package com.example.lab2.controller;

import com.example.lab2.entity.Account;
import com.example.lab2.service.impl.AccountServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountServiceImpl accountService;

    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{userId}")
    public Account getAccountByUserId(@PathVariable int userId) {
        return accountService.getOrCreateAccount(userId);
    }

    @PostMapping("/add/{userId}")
    public Account addMoney(@PathVariable int userId, @RequestParam double amount) {
        accountService.addMoney(userId, amount);
        return accountService.getOrCreateAccount(userId);
    }

    @PostMapping("/withdraw/{userId}")
    public Account withdrawMoney(@PathVariable int userId, @RequestParam double amount) {
        accountService.withdrawMoney(userId, amount);
        return accountService.getOrCreateAccount(userId);
    }
}
