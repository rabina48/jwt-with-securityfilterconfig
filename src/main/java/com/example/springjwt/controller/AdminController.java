package com.example.springjwt.controller;

import com.example.springjwt.constant.ApiUrl;
import com.example.springjwt.dtos.request.UserRequest;
import com.example.springjwt.dtos.response.UserResponse;
import com.example.springjwt.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(ApiUrl.STUDENT)
    public List<UserResponse> getAllUser() {
        return userService.getAllStudent();
    }

    @PutMapping(ApiUrl.UPDATE)
    public UserResponse updateUser(@PathVariable Integer id, @RequestBody UserRequest userRequest) {
        return userService.updateAllStudent(id, userRequest);
    }

    @PostMapping(ApiUrl.SAVE)
    public UserResponse saveUser(@RequestBody UserRequest registerRequest) {
        return userService.saveStudent(registerRequest);
    }

    @GetMapping(ApiUrl.BY_ID)
    public UserResponse getUser(@PathVariable Integer id) {
        return userService.userById(id);
    }

    @DeleteMapping(ApiUrl.BY_ID)
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

//    @PutMapping(ApiUrl.BY_ID)
//    public VendorAssetRes editSubAsset(@PathVariable Long id,
//                                       @RequestBody VendorAssetReq vendorAssetReq){
//        return vendorAssetsService.editVendorBy(id, vendorAssetReq);
//    }


}
