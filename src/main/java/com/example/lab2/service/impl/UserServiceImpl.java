package com.example.lab2.service.impl;

import com.example.lab2.dto.user.UserCreateDto;
import com.example.lab2.dto.user.UserResponseDto;
import com.example.lab2.entity.User;
import com.example.lab2.mapper.UserMapper;
import com.example.lab2.repository.UserRepository;
import com.example.lab2.service.UserService;
import com.example.lab2.service.exeption.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public List<UserResponseDto> getAllUsers() {

        return userMapper.userListToUserResponseDtoList(userRepository.findAll());
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public UserResponseDto createUser(UserCreateDto userCreateDto) {
        User user = new User();
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        return userMapper.userToUserResponseDto(userRepository.save(user));
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
    }
}

