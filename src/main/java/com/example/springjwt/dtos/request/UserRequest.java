package com.example.springjwt.dtos.request;

import com.example.springjwt.entity.Roles;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author : Rabina Shrestha
 * @Date : 28/06/2023
 * @email : rabina.shrestha@codehimalaya.tech
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String fullName;

    private String email;
    private String password;

    private List<Integer> roles;


}
