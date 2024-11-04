package com.example.lab2.service;

import com.example.lab2.dto.record.RecordCreateDto;
import com.example.lab2.entity.Record;

public interface RecordService {
    Record getRecordById(int id);
    void deleteRecordById(int id);
    Record createRecord(RecordCreateDto recordCreateDto);

}
