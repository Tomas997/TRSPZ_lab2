package com.example.lab2.controller;

import com.example.lab2.dto.exception.MyValidationException;
import com.example.lab2.dto.user.UserCreateDto;
import com.example.lab2.dto.user.UserResponseDto;
import com.example.lab2.entity.User;
import com.example.lab2.mapper.UserMapper;
import com.example.lab2.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private UserMapper userMapper;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("userId") int userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        UserResponseDto responseDto = userMapper.categoryToCategoryResponseDto(user);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("userId") int userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid UserCreateDto userCreateDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            Map<String, String> errors = bindingResult.getFieldErrors().stream()
                    .collect(Collectors.toMap(
                            FieldError::getField,
                            FieldError::getDefaultMessage
                    ));

            throw new MyValidationException(errors);
        }
        User user = userService.createUser(userCreateDto);
        UserResponseDto responseDto = userMapper.categoryToCategoryResponseDto(user);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserResponseDto> userResponseDtos = userMapper.categoryListToCategoryResponseDtoList(users);
        return ResponseEntity.ok(userResponseDtos);
    }
}
