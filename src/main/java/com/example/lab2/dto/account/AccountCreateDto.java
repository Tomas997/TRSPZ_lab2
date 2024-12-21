package com.example.lab2.dto.account;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountCreateDto {
    @NotNull
    private Integer userId;
    @NotNull(message = "Balance is mandatory")
    @Min(value = 0, message = "Balance is mandatory")
    private Double balance;

}



