package com.example.lab2.dto.record;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecordCreateDto {
    @NotBlank(message = "UserId is mandatory")
    private int userId;
    @NotBlank(message = "CategoryId is mandatory")
    private int categoryId;
    @NotBlank(message = "SumOfSpent is mandatory")
    double sumOfSpent;
}
