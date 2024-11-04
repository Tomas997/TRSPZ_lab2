package com.example.lab2.mapper;


import com.example.lab2.dto.user.UserResponseDto;
import com.example.lab2.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto categoryToCategoryResponseDto(User user);
    List<UserResponseDto> categoryListToCategoryResponseDtoList(List<User> UserList);
}