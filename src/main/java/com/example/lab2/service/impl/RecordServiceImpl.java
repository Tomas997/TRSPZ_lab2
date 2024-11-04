package com.example.lab2.service.impl;

import com.example.lab2.dto.record.RecordCreateDto;
import com.example.lab2.entity.Record;
import com.example.lab2.service.RecordService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class RecordServiceImpl implements RecordService {

    private final Map<Integer, Record> records = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    @Override
    public Record getRecordById(int id) {
        return records.get(id);
    }

    @Override
    public void deleteRecordById(int id) {
        records.remove(id);
    }

    @Override
    public Record createRecord(RecordCreateDto recordCreateDto) {
        int newId = idCounter.getAndIncrement();
        Record record = Record.builder()
                .id(newId)
                .userId(recordCreateDto.getUserId())
                .categoryId(recordCreateDto.getCategoryId())
                .timeCreationRecord(LocalDateTime.now())
                .sumOfSpent(recordCreateDto.getSumOfSpent())
                .build();
        records.put(newId, record);
        return record;
    }

    @Override
    public List<Record> getRecords(Integer userId, Integer categoryId) {
        if (userId == null && categoryId == null) {
            throw new IllegalArgumentException("Параметри userId або categoryId мають бути вказані");
        }

        return records.values().stream()
                .filter(record -> (userId == null || record.getUserId() == userId) &&
                        (categoryId == null || record.getCategoryId() == categoryId))
                .collect(Collectors.toList());
    }
}

