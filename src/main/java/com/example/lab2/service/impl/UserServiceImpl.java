package com.example.lab2.service.impl;

import com.example.lab2.dto.user.UserCreateDto;
import com.example.lab2.entity.User;
import com.example.lab2.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceImpl implements UserService {

    private final Map<Integer, User> users = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User getUserById(int id) {
        return users.get(id);
    }

    @Override
    public User createUser(UserCreateDto userCreateDto) {
        int newId = idCounter.getAndIncrement();
        User user = User.builder()
                .id(newId)
                .name(userCreateDto.getName())
                .build();
        users.put(newId, user);
        return user;
    }

    @Override
    public void deleteUserById(int id) {
        users.remove(id);
    }
}

