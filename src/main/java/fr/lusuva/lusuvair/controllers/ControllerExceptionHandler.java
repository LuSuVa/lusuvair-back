package fr.lusuva.lusuvair.controllers;

import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    /**
     * Exception Handler for IllegalArgument
     * 
     * @param illegalArgumentException exception
     * @return Bad Requestion response entity
     */
    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<String> illegalArgumentExceptionHandler(IllegalArgumentException illegalArgumentException) {
        return ResponseEntity.badRequest().body(illegalArgumentException.getMessage());
    }

    /**
     * Exception Handler for NoSuchElement
     * 
     * @param noSuchElementException exception
     * @return Bad Requestion response entity
     */
    @ExceptionHandler(NoSuchElementException.class)
    private ResponseEntity<String> noSuchElementExceptionHandler(NoSuchElementException noSuchElementException) {
        return ResponseEntity.badRequest().body(noSuchElementException.getMessage());
    }
}
