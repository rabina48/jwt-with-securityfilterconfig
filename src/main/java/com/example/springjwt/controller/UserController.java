package com.example.springjwt.controller;

import com.example.springjwt.constant.ApiUrl;
import com.example.springjwt.dtos.request.RegisterRequest;
import com.example.springjwt.dtos.request.UserRequest;
import com.example.springjwt.dtos.response.AuthenticationResponse;
import com.example.springjwt.dtos.response.SuccessResponse;
import com.example.springjwt.dtos.response.UserResponse;
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
    public List<UserResponse> getAllAppointment() {
        return userService.getAllStudent();
    }

    @PutMapping(ApiUrl.UPDATE)
    public UserResponse updateAppointment(@PathVariable Integer id, @RequestBody UserRequest userRequest) {
        return userService.updateAllStudent(id, userRequest);
    }

    @PostMapping(ApiUrl.SAVE)
    public UserResponse saveUser( @RequestBody UserRequest registerRequest) {
        return userService.saveStudent( registerRequest);
    }

    @GetMapping(ApiUrl.REGISTER)
    public ResponseEntity<List<UserResponse>> getAllUser(){
        return ResponseEntity.ok(userService.getAllStudent());
    }

    @GetMapping(ApiUrl.BY_ID)
    public UserResponse getSubAsset(@PathVariable Integer id){
        return userService.userById(id);
    }

    @DeleteMapping(ApiUrl.BY_ID)
    public void deleteSubAsset(@PathVariable Integer id){
        userService.deleteUser(id);
    }

//    @PutMapping(ApiUrl.BY_ID)
//    public VendorAssetRes editSubAsset(@PathVariable Long id,
//                                       @RequestBody VendorAssetReq vendorAssetReq){
//        return vendorAssetsService.editVendorBy(id, vendorAssetReq);
//    }


}
