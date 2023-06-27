package com.example.springjwt.service;


import com.example.springjwt.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

     List<User> getAllStudent();
     User updateAllStudent(User profile);


}
