package com.example.lab2.service.exeption;

public class RecordNotFoundException extends RuntimeException {
    private static final String ORDER_NOT_FOUND_MESSAGE = "Record With ID - %s Not Found";

    public RecordNotFoundException(String id) {
        super(String.format(ORDER_NOT_FOUND_MESSAGE, id));
    }
}
