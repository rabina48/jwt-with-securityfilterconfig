package com.example.springjwt.service;


import com.example.springjwt.dtos.request.RegisterRequest;
import com.example.springjwt.dtos.request.UserRequest;
import com.example.springjwt.dtos.response.UserResponse;
import com.example.springjwt.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

     List<UserResponse> getAllStudent();
     UserResponse updateAllStudent(Integer id, UserRequest userRequest);
     UserResponse userById(Integer id);
     void deleteUser(Integer id);
    UserResponse saveStudent(UserRequest registerRequest);
}
