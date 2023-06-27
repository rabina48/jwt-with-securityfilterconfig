package com.example.springjwt.service;

import com.example.springjwt.dtos.request.RegisterRequest;
import com.example.springjwt.dtos.response.AuthenticationResponse;
import org.springframework.stereotype.Service;

/**
 * @author : Rabina Shrestha
 * @Date : 27/06/2023
 * @email : rabina.shrestha@codehimalaya.tech
 */
@Service
public interface AuthService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(RegisterRequest request);
}
