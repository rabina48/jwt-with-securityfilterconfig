package com.example.springjwt.component;

import com.example.springjwt.dtos.request.UserRequest;
import com.example.springjwt.dtos.response.UserResponse;
import com.example.springjwt.entity.Roles;
import com.example.springjwt.entity.User;
import com.example.springjwt.repository.RolesRepo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : Rabina Shrestha
 * @Date : 28/06/2023
 * @email : rabina.shrestha@codehimalaya.tech
 */

@Component

public class UserResResConvertor {

    private final RolesRepo rolesRepo;

    public UserResResConvertor(RolesRepo rolesRepo) {
        this.rolesRepo = rolesRepo;
    }


    public User toUser(UserRequest userRequest) {
        return User.builder()
                .fullName(userRequest.getFullName())
                .email(userRequest.getEmail())
                .roles(rolesRepo.findRole(userRequest.getRoles()))
                .build();

    }

    public UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .fullName(user.getFullName())
                .email(user.getEmail())
                .roles(user.getRoles())
                .id(user.getId())
                .build();
    }


//    public UserResponse toUserUpdate(User user, User){
//        return UserResponse.builder()
//                .fullName(user.getFullName())
//                .email(user.getEmail())
//                .roles(user.getRoles())
//                .build();
//    }

}
