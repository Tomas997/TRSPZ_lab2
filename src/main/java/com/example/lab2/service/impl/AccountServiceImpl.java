package com.example.lab2.service.impl;

import com.example.lab2.entity.Account;
import com.example.lab2.repository.AccountRepository;
import com.example.lab2.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account getOrCreateAccount(int userId) {
        return accountRepository.findByUserId(userId)
                .orElseGet(() -> {
                    Account account = new Account();
                    account.setUserId(userId);
                    account.setBalance(0);
                    return accountRepository.save(account);
                });
    }

    @Override
    public void addMoney(int userId, double amount) {
        Account account = getOrCreateAccount(userId);
        account.addMoney(amount);
        accountRepository.save(account);
    }

    @Override
    public void withdrawMoney(int userId, double amount) {
        Account account = getOrCreateAccount(userId);
        account.withdrawMoney(amount);
        accountRepository.save(account);
    }
}
