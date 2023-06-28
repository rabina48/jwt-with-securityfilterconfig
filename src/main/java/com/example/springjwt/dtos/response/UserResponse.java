package com.example.springjwt.dtos.response;

import com.example.springjwt.entity.Roles;
import lombok.*;

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
public class UserResponse {

    private Integer id;

    private String fullName;

    private String email;

    private List<Roles> roles;

}
