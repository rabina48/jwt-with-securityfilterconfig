package com.example.springjwt.dtos.response;

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
public class AuthenticationResponse {

    private String token;
}
