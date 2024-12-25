package com.example.lab2.service.impl;

import com.example.lab2.dto.user.UserSignUp;
import com.example.lab2.dto.user.UserResponseDto;
import com.example.lab2.entity.User;
import com.example.lab2.mapper.UserMapper;
import com.example.lab2.repository.UserRepository;
import com.example.lab2.service.UserService;
import com.example.lab2.service.exeption.UserAlreadyExistsException;
import com.example.lab2.service.exeption.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponseDto> getAllUsers() {

        return userMapper.userListToUserResponseDtoList(userRepository.findAll());
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

    }

    @Override
    public User createUser(User userSignUp) {
        if (userRepository.existsByUsername(userSignUp.getUsername())) {
            throw new UserAlreadyExistsException(userSignUp.getUsername());
        }
        return userRepository.save(userSignUp);
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
    }

    @Override
    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    @Override
    public User getCurrentUser() {
        //getting userName from the context of Spring Security
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }
}

