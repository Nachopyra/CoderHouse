package com.entegable.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {
    public ResponseEntity<?> clientNotFoundException(){

        return null;
    }
}
