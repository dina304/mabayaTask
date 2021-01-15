package com.mabaya.task.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class CustomExceptionHadler {
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity handleException(DataNotFoundException ex) {
        ResponseEntity entity = new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        return entity;
    }
}
