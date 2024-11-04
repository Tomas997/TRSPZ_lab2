package com.example.lab2.controller;

import com.example.lab2.dto.user.UserCreateDto;
import com.example.lab2.dto.user.UserResponseDto;
import com.example.lab2.entity.User;
import com.example.lab2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    // GET /user/<user_id>
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("userId") int userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        UserResponseDto responseDto = UserResponseDto.builder()
                .name(user.getName())
                .build();
        return ResponseEntity.ok(responseDto);
    }

    // DELETE /user/<user_id>
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("userId") int userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }

    // POST /user
    @PostMapping("/user")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserCreateDto userCreateDto) {
        User user = userService.createUser(userCreateDto);
        UserResponseDto responseDto = UserResponseDto.builder()
                .name(user.getName())
                .build();
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    // GET /users
    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> users = userService.getAllUsers().stream()
                .map(user -> UserResponseDto.builder().name(user.getName()).build())
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }
}
