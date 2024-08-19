package com.ust.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleBookNotFound(BookNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateBookException.class)
    public ResponseEntity<String> handleDuplicateBook(DuplicateBookException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}