package com.exeptions.examples.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManejoErrores {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handlerArithmeticException(ArithmeticException e) {
        return new ResponseEntity<>("División por cero no permitida", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<String> handlerNumberFormatException(NumberFormatException e) {
        return new ResponseEntity<>("Error: valor ingresado no es númerico", HttpStatus.BAD_REQUEST);
    }
}
