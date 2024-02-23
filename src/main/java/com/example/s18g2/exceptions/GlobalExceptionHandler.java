package com.example.s18g2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(PlantException exception){
        log.error("PlantException", exception);
        PlantErrorResponse response = new PlantErrorResponse (exception.getMessage(), exception.getHttpStatus().value(), System.currentTimeMillis());
        return new ResponseEntity<>(response, exception.getHttpStatus());

    }

    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(Exception exception){
        log.error("Exception", exception);
        PlantErrorResponse response = new PlantErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
