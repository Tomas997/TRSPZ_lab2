package com.example.lab2.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {
    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;
}
