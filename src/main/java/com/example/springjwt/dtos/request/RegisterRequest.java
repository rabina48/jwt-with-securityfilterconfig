package com.example.springjwt.dtos.request;

import lombok.*;

/**
 * @author : Rabina Shrestha
 * @Date : 27/06/2023
 * @email : rabina.shrestha@codehimalaya.tech
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String fullName;

    private String email;

    private String password;

}
