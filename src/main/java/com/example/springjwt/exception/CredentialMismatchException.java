package com.example.springjwt.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @author : Rabina Shrestha
 * @Date : 29/06/2023
 * @email : rabina.shrestha@codehimalaya.tech
 */
@Data
@AllArgsConstructor
public class CredentialMismatchException extends Exception {
    private String message;


}