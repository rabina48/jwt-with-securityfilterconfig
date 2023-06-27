package com.example.springjwt.controller;

import com.example.springjwt.dtos.request.RegisterRequest;
import com.example.springjwt.dtos.response.AuthenticationResponse;
import com.example.springjwt.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Rabina Shrestha
 * @Date : 27/06/2023
 * @email : rabina.shrestha@codehimalaya.tech
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class AuthController {

    private  final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
