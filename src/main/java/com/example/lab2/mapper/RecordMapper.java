package com.example.lab2.mapper;

import com.example.lab2.dto.record.RecordResponseDto;
import com.example.lab2.entity.Record;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecordMapper {
    RecordResponseDto categoryToCategoryResponseDto(Record category);
    List<RecordResponseDto> categoryListToCategoryResponseDtoList(List<Record> categoryList);
}