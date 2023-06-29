package com.example.springjwt.dtos.request;

import com.example.springjwt.entity.Roles;
import lombok.*;

import java.util.List;

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
    private List<Integer> roles;


}
