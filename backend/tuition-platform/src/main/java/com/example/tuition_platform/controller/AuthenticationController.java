package com.example.tuition_platform.controller;

import com.example.tuition_platform.domain.dto.UserLoginRequest;
import com.example.tuition_platform.domain.dto.UserLoginResponse;
import com.example.tuition_platform.domain.dto.UserRegisterRequest;
import com.example.tuition_platform.domain.entity.User;
import com.example.tuition_platform.security.JwtService;
import com.example.tuition_platform.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody UserRegisterRequest userRegisterRequest) {
        User registeredUser = authenticationService.signup(userRegisterRequest);

        return  ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> authenticate(@RequestBody UserLoginRequest userLoginRequest) {
        User authenticatedUser = authenticationService.authenticate(userLoginRequest);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        UserLoginResponse loginResponse = new UserLoginResponse(jwtToken, jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }
}