package com.example.springjwt.service.impl;

import com.example.springjwt.config.JwtService;
import com.example.springjwt.dtos.request.AuthenticationRequest;
import com.example.springjwt.dtos.request.RegisterRequest;
import com.example.springjwt.dtos.response.AuthenticationResponse;
import com.example.springjwt.entity.Roles;
import com.example.springjwt.entity.User;
import com.example.springjwt.exception.CredentialMismatchException;
import com.example.springjwt.repository.RolesRepo;
import com.example.springjwt.repository.UserServiceRepo;
import com.example.springjwt.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private final RolesRepo rolesRepo;
    private AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        if (userServiceRepo.findByEmail(request.getEmail()) != null) {
            throw new CredentialMismatchException("Email already Exist!");
        }
        var user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(rolesRepo.findRole(request.getRoles()))
                .build();
        userServiceRepo.save(user);
//        var jwtToken = jwtService.generateToken(user.getEmail(), roleName, user.getId());
        return AuthenticationResponse.builder()
                .message("Register Success!")
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        User user = userServiceRepo.findByEmail(request.getEmail());
        if (user == null) {
            throw new CredentialMismatchException("Email did not match!");
        }
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new CredentialMismatchException("Password did not match");
        }
        //validate Email id and password to generate token
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
//        var user = userServiceRepo.findByEmail(request.getEmail())
//                .orElseThrow();
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        List<String> roleName = new ArrayList<>();
        user.getRoles().forEach(role -> roleName.add(role.getRoleName()));
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", roleName);
        claims.put("userId", user.getId());

        var jwtToken = jwtService.generateToken(user.getEmail(), roleName, user.getId());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
