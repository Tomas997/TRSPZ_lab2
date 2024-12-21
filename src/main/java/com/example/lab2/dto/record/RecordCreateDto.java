package com.example.lab2.dto.record;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecordCreateDto {
    @NotNull(message = "UserId is mandatory")
    private Integer userId;
    @NotNull(message = "CategoryId is mandatory")
    private Integer categoryId;
    @NotNull(message = "SumOfSpent is mandatory")
    @Min(value = 0, message = "SumOfSpent is mandatory")
    Double sumOfSpent;
}
