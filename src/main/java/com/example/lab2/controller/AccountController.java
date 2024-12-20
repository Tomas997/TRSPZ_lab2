package com.example.lab2.controller;

import com.example.lab2.entity.Account;
import com.example.lab2.service.impl.AccountServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountServiceImpl accountService;


    @GetMapping("/{userId}")
    public Account getAccountByUserId(@PathVariable int userId) {
        return accountService.getAccount(userId);
    }

    @PostMapping("/add/{userId}")
    public Account addMoney(@PathVariable int userId, @RequestParam double amount) {
        accountService.addMoney(userId, amount);
        return accountService.getAccount(userId);
    }

    @PostMapping("/withdraw/{userId}")
    public Account withdrawMoney(@PathVariable int userId, @RequestParam double amount) {
        accountService.withdrawMoney(userId, amount);
        return accountService.getAccount(userId);
    }
}
