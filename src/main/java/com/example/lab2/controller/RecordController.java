package com.example.lab2.controller;

import com.example.lab2.dto.record.RecordCreateDto;
import com.example.lab2.dto.record.RecordResponseDto;
import com.example.lab2.entity.Record;
import com.example.lab2.mapper.RecordMapper;
import com.example.lab2.service.RecordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record")
@AllArgsConstructor
public class RecordController {

    private RecordService recordService;
    private RecordMapper recordMapper;


    @GetMapping("/{record_id}")
    public ResponseEntity<RecordResponseDto> getRecordById(@PathVariable("record_id") int recordId) {
        Record record = recordService.getRecordById(recordId);
        if (record == null) {
            return ResponseEntity.notFound().build();
        }
        RecordResponseDto responseDto = recordMapper.categoryToCategoryResponseDto(record);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{record_id}")
    public ResponseEntity<Void> deleteRecordById(@PathVariable("record_id") int recordId) {
        recordService.deleteRecordById(recordId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<RecordResponseDto> createRecord(@RequestBody RecordCreateDto recordCreateDto) {
        Record record = recordService.createRecord(recordCreateDto);
        RecordResponseDto responseDto = recordMapper.categoryToCategoryResponseDto(record);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RecordResponseDto>> getRecords(
            @RequestParam(value = "user_id", required = false) Integer userId,
            @RequestParam(value = "category_id", required = false) Integer categoryId) {
        if (userId == null && categoryId == null) {
            return ResponseEntity.badRequest().body(null);
        }
        List<Record> records = recordService.getRecords(userId, categoryId);
        List<RecordResponseDto> responseDtos = recordMapper.categoryListToCategoryResponseDtoList(records);
        return ResponseEntity.ok(responseDtos);
    }
}
