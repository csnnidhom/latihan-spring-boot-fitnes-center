package com.endpoints.fitnescenter.controller;

import com.endpoints.fitnescenter.Model.request.ForgotPasswordRequest;
import com.endpoints.fitnescenter.Model.request.RegisterUserRequest;
import com.endpoints.fitnescenter.Model.request.SetPasswordRequest;
import com.endpoints.fitnescenter.Model.request.UpdateUserRequest;
import com.endpoints.fitnescenter.Model.response.UpdateUserResponse;
import com.endpoints.fitnescenter.Model.response.UserResponse;
import com.endpoints.fitnescenter.Model.response.WebResponseSuccess;
import com.endpoints.fitnescenter.entity.User;
import com.endpoints.fitnescenter.service.AuthService;
import com.endpoints.fitnescenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(
            path = "/api/users/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponseSuccess<String> register(@RequestBody RegisterUserRequest request){
        userService.register(request);
        return WebResponseSuccess.<String>builder().data("Registration Success check your email for verification (Verify account within 1 minute)").build();
    }

    @PutMapping(
            path = "/api/users/verify-account"
    )
    public ResponseEntity<String> verify_account(
            @RequestParam String email,
            @RequestParam String otp
            ){
        userService.verifyAccount(email, otp);
        return new ResponseEntity<>(userService.verifyAccount(email, otp), HttpStatus.OK);
    }

    @PutMapping(
            path = "api/users/regenerate-otp"
    )
    public ResponseEntity<String> regenerateOtp(@RequestParam String email){
        userService.regenerateOtp(email);
        return new ResponseEntity<>(userService.regenerateOtp(email), HttpStatus.OK);
    }

    @GetMapping(
            path = "/api/users/get-status"
    )public ResponseEntity<String> getStatusAccount(@RequestParam String email){
        userService.getStatusAccount(email);
        return new ResponseEntity<>(userService.getStatusAccount(email), HttpStatus.OK);
    }

    @GetMapping(
            path = "/api/users/profile",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponseSuccess<UserResponse> get(User user){
        UserResponse response = userService.get(user);
        return WebResponseSuccess.<UserResponse>builder().data(response).build();
    }

    @PatchMapping(
            path = "/api/users/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponseSuccess<UpdateUserResponse> update(User user,@RequestBody UpdateUserRequest request){
        UpdateUserResponse userResponse = userService.update(user,request);
        return WebResponseSuccess.<UpdateUserResponse>builder().data(userResponse).build();
    }

    @PutMapping(
            path = "/api/users/forgot-password"
    )
    public WebResponseSuccess<String> forgotPassword(@RequestBody ForgotPasswordRequest request){
        userService.forgotPassword(request);
        return WebResponseSuccess.<String>builder().data("Otp send to email success for forgot password").build();
    }

    @PutMapping(
            path = "/api/users/set-password"
    )
    public ResponseEntity<String> setPassword(@RequestBody SetPasswordRequest request){
        userService.setPassword(request);
        return new ResponseEntity<>(userService.setPassword(request), HttpStatus.OK);
    }
}
