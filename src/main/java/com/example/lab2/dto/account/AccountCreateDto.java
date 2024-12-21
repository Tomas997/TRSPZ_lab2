package com.example.lab2.dto.account;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountCreateDto {
    @NotBlank(message = "UserId is mandatory")
    private int userId;
    @NotBlank(message = "Balance is mandatory")
    private double balance;
}



