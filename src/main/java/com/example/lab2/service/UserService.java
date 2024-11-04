package com.example.lab2.service;

import com.example.lab2.dto.user.UserCreateDto;
import com.example.lab2.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    User createUser(UserCreateDto userCreateDto);
    void deleteUserById(int id);

}
