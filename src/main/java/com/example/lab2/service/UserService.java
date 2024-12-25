package com.example.lab2.service;

import com.example.lab2.dto.user.UserResponseDto;
import com.example.lab2.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    User getUserById(int id);
    User createUser(User userSignUp);
    void deleteUserById(int id);
    User getUserByUsername(String username);
    UserDetailsService userDetailsService();
    User getCurrentUser();
}
