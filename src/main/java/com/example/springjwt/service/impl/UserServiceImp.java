package com.example.springjwt.service.impl;

import com.example.springjwt.entity.User;
import com.example.springjwt.repository.UserServiceRepo;
import com.example.springjwt.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImp implements UserService {

    private final UserServiceRepo userServiceRepo;

    public UserServiceImp(UserServiceRepo userServiceRepo) {
        this.userServiceRepo = userServiceRepo;
    }


    @Override
    public List<User> getAllStudent() {
        return userServiceRepo.findAll();
    }

    @Override
    public User updateAllStudent(User profile) {
        User student = new User();
        student.setId(profile.getId());
        return userServiceRepo.save(student);
    }
}

