package com.example.springjwt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Rabina Shrestha
 * @Date : 29/06/2023
 * @email : rabina.shrestha@codehimalaya.tech
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    @GetMapping("/hello")
    public  String hello(){
        return "HELLO This is user Dashboard!";
    }
}
