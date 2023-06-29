package com.example.springjwt.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author : Rabina Shrestha
 * @Date : 29/06/2023
 * @email : rabina.shrestha@codehimalaya.tech
 */
@Data
@AllArgsConstructor
public class ExceptionMessage {
    private String message;
    private HttpStatus status;
}
