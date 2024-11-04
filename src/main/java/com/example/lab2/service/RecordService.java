package com.example.lab2.service;

import com.example.lab2.dto.record.RecordCreateDto;
import com.example.lab2.entity.Record;

import java.util.List;

public interface RecordService {
    Record getRecordById(int id);
    void deleteRecordById(int id);
    Record createRecord(RecordCreateDto recordCreateDto);
    List<Record> getRecords(Integer userId, Integer categoryId);
}
