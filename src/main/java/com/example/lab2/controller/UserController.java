package com.example.lab2.controller;

import com.example.lab2.dto.user.UserCreateDto;
import com.example.lab2.dto.user.UserResponseDto;
import com.example.lab2.entity.User;
import com.example.lab2.mapper.UserMapper;
import com.example.lab2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private UserMapper userMapper;


    @GetMapping("/user/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("userId") int userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        UserResponseDto responseDto = userMapper.categoryToCategoryResponseDto(user);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("userId") int userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserCreateDto userCreateDto) {
        User user = userService.createUser(userCreateDto);
        UserResponseDto responseDto = userMapper.categoryToCategoryResponseDto(user);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserResponseDto> userResponseDtos = userMapper.categoryListToCategoryResponseDtoList(users);
        return ResponseEntity.ok(userResponseDtos);
    }
}
