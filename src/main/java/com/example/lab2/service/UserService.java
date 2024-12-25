package com.example.lab2.service;

import com.example.lab2.dto.user.UserCreateDto;
import com.example.lab2.dto.user.UserResponseDto;
import com.example.lab2.entity.User;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    User getUserById(int id);
    UserResponseDto createUser(UserCreateDto userCreateDto);
    void deleteUserById(int id);
    User getUserByUsername(String username);
}
