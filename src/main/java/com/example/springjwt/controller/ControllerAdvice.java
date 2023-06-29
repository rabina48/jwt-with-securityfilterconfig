package com.example.springjwt.controller;

import com.example.springjwt.dtos.response.ExceptionMessage;
import com.example.springjwt.exception.CredentialMismatchException;
import com.example.springjwt.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : Rabina Shrestha
 * @Date : 29/06/2023
 * @email : rabina.shrestha@codehimalaya.tech
 */
@RestControllerAdvice

public class ControllerAdvice {

    @ExceptionHandler(value = CredentialMismatchException.class)
    private ResponseEntity<?> handleCredentialMismatchException(CredentialMismatchException e ){
        return new ResponseEntity<>(new ExceptionMessage(e.getMessage(),HttpStatus.UNAUTHORIZED),HttpStatus.UNAUTHORIZED);

    }



}
