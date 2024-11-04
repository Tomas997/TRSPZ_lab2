package com.example.lab2.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Record {
    private int id;
    private int userId;
    private int categoryId;
    LocalDateTime timeCreationRecord;
    double sumOfSpent;
}
