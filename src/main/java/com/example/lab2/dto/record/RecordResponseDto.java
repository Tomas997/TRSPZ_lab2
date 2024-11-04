package com.example.lab2.dto.record;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class RecordResponseDto {
    private int id;
    private int userId;
    private int categoryId;
    LocalDateTime timeCreationRecord;
    double sumOfSpent;
}
