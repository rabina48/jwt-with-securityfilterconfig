package com.example.springjwt.exception;

import org.springframework.http.HttpStatus;

/**
 * @author : Rabina Shrestha
 * @Date : 26/06/2023
 * @email : rabina.shrestha@codehimalaya.tech
 */

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}