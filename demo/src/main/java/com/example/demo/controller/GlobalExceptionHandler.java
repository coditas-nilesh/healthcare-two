package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle DemoException specifically
    @ExceptionHandler(DemoException.class)
    public ResponseEntity<String> handleDemoException(DemoException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // You can return an appropriate status code
                .body(ex.getMessage()); // Returns the exception message to the client
    }

    // Generic Exception Handler (optional)
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred: " + ex.getMessage());
    }
}