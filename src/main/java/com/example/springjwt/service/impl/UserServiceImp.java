package com.example.springjwt.service.impl;

import com.example.springjwt.constant.MessageConstant;
import com.example.springjwt.component.UserResResConvertor;
import com.example.springjwt.dtos.request.RegisterRequest;
import com.example.springjwt.dtos.request.UserRequest;
import com.example.springjwt.dtos.response.UserResponse;
import com.example.springjwt.entity.Roles;
import com.example.springjwt.entity.User;
import com.example.springjwt.exception.ResourceNotFoundException;
import com.example.springjwt.repository.RolesRepo;
import com.example.springjwt.repository.UserServiceRepo;
import com.example.springjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserServiceRepo userServiceRepo;
    private final UserResResConvertor userResResConvertor;
    private final RolesRepo rolesRepo;

    @Override
    public List<UserResponse> getAllStudent() {
        List<User> user = userServiceRepo.findAll();
        return user.stream().map(userResResConvertor::toUserResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse updateAllStudent(Integer id, UserRequest userRequest) {

        User user = userServiceRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Vendor with id " + id + MessageConstant.NOT_FOUND));
        user.setEmail(userRequest.getEmail());
        user.setFullName(userRequest.getFullName());


//        List<Roles> rolesList = new ArrayList<>();
//        rolesList.add(role);
        user.setRoles( rolesRepo.findRole(userRequest.getRoles()));

        userServiceRepo.save(user);
        UserResponse updatedUser = userResResConvertor.toUserResponse(user);
        return updatedUser;

    }

    @Override
    public UserResponse userById(Integer id) {
        User user = userServiceRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Vendor with id " + id + MessageConstant.NOT_FOUND));
        return userResResConvertor.toUserResponse(user);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = userServiceRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Vendor with id " + id + MessageConstant.NOT_FOUND));
        userServiceRepo.deleteById(id);
    }

    @Override
    public UserResponse saveStudent(UserRequest registerRequest) {
        User user = userResResConvertor.toUser(registerRequest);
        userServiceRepo.save(user);
        UserResponse userResponse = userResResConvertor.toUserResponse(user);
        return userResponse;
    }
}

