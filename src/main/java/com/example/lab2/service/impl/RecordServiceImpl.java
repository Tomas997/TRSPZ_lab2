package com.example.lab2.service.impl;

import com.example.lab2.dto.record.RecordCreateDto;
import com.example.lab2.entity.Record;
import com.example.lab2.repository.RecordRepository;
import com.example.lab2.service.RecordService;
import com.example.lab2.service.exeption.RecordNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecordServiceImpl implements RecordService {
    private RecordRepository recordRepository;

    @Override
    public Record getRecordById(int id) {
        return recordRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(String.valueOf(id)));
    }

    @Override
    public void deleteRecordById(int id) {
        recordRepository.deleteById(id);
    }

    @Override
    public Record createRecord(RecordCreateDto recordCreateDto) {
        Record record = Record.builder()
                .userId(recordCreateDto.getUserId())
                .categoryId(recordCreateDto.getCategoryId())
                .timeCreationRecord(LocalDateTime.now())
                .sumOfSpent(recordCreateDto.getSumOfSpent())
                .build();
        return recordRepository.save(record);

    }

    @Override
    public List<Record> getRecords(Integer userId, Integer categoryId) {
        if (userId == null && categoryId == null) {
            throw new IllegalArgumentException("Параметри userId або categoryId мають бути вказані");
        }

        return recordRepository.findAll().stream()
                .filter(record -> (userId == null || record.getUserId() == userId) &&
                        (categoryId == null || record.getCategoryId() == categoryId))
                .collect(Collectors.toList());
    }
}

