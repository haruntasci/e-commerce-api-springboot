package com.allianz.example.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.security.sasl.AuthenticationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {


//    @ExceptionHandler(AuthenticationException.class)
//    public ResponseEntity<Object> handleAuthentication(AuthenticationException exception, WebRequest request) {
//        Map<String, Object> exceptionBody = new HashMap<>();
//        exceptionBody.put("timestamp", LocalDateTime.now());
//        exceptionBody.put("message", "Authentication hatası aldın");
//        return new ResponseEntity<>(exceptionBody, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointer(NullPointerException exception, WebRequest request) {
        Map<String, Object> exceptionBody = new HashMap<>();
        exceptionBody.put("timestamp", LocalDateTime.now());
        exceptionBody.put("message", "Null pointer aldın");
        return new ResponseEntity<>(exceptionBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
