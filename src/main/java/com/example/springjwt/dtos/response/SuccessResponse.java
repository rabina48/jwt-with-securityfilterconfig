package com.example.springjwt.dtos.response;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

/**
 * @author : Rabina Shrestha
 * @Date : 27/06/2023
 * @email : rabina.shrestha@codehimalaya.tech
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponse <T>{

    private String message;
    private T data;

    public  SuccessResponse(String messageNew){
        this.message =  messageNew;

    }

}
