package com.example.springjwt.controller;

import com.example.springjwt.constant.ApiUrl;
import com.example.springjwt.dtos.request.RegisterRequest;
import com.example.springjwt.dtos.response.AuthenticationResponse;
import com.example.springjwt.entity.User;
import com.example.springjwt.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(ApiUrl.STUDENT)
    public List<User> getAllAppointment() {
        return userService.getAllStudent();
    }

    @PostMapping("update")
    public User updateAppointment(@RequestBody User profile) {
        return userService.updateAllStudent( profile);
    }

    @GetMapping("/register")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Hello from Authorized end");
    }
}
