package com.example.lab2.service.impl;

import com.example.lab2.dto.user.UserCreateDto;
import com.example.lab2.entity.User;
import com.example.lab2.repository.UserRepository;
import com.example.lab2.service.UserService;
import com.example.lab2.service.exeption.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(String.valueOf(id)));
    }

    @Override
    public User createUser(UserCreateDto userCreateDto) {
        User user = User.builder()
                .name(userCreateDto.getName())
                .build();
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}

