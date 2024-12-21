package com.example.lab2.service.impl;

import com.example.lab2.dto.account.AccountCreateDto;
import com.example.lab2.entity.Account;
import com.example.lab2.repository.AccountRepository;
import com.example.lab2.service.AccountService;
import com.example.lab2.service.exeption.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account getAccount(int userId) {
        return accountRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException(String.valueOf(userId)));
    }

    @Override
    public Account getOrCreateAccount(AccountCreateDto accountCreateDto) {
        return accountRepository.findByUserId(accountCreateDto.getUserId())
                .orElseGet(() -> {
                    Account account = new Account();
                    account.setUserId(accountCreateDto.getUserId());
                    account.setBalance(accountCreateDto.getBalance());
                    return accountRepository.save(account);
                });
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    @Override
    public void addMoney(int userId, double amount) {
        Account account = getAccount(userId);
        account.addMoney(amount);
        accountRepository.save(account);
    }

    @Override
    public void withdrawMoney(int userId, double amount) {
        Account account = getAccount(userId);
        account.withdrawMoney(amount);
        accountRepository.save(account);
    }
}
