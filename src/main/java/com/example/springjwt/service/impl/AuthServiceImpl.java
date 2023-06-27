package com.example.springjwt.service.impl;

import com.example.springjwt.config.JwtService;
import com.example.springjwt.dtos.request.RegisterRequest;
import com.example.springjwt.dtos.response.AuthenticationResponse;
import com.example.springjwt.entity.Role;
import com.example.springjwt.entity.User;
import com.example.springjwt.repository.UserServiceRepo;
import com.example.springjwt.service.AuthService;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.patterns.IToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author : Rabina Shrestha
 * @Date : 27/06/2023
 * @email : rabina.shrestha@codehimalaya.tech
 */

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserServiceRepo userServiceRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Role.USER)
                .build();
        userServiceRepo.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(RegisterRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userServiceRepo.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
