package com.example.tuition_platform.controller;

import com.example.tuition_platform.domain.dto.UserResponse;
import com.example.tuition_platform.domain.entity.User;
import com.example.tuition_platform.service.UserService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<String> getHomePage() {
        return ResponseEntity.ok("connected");
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> getCurrentUser(
            @AuthenticationPrincipal @NotNull User user
    ) {
        UserResponse userResponse = userService.getMe(user);
        return ResponseEntity.ok(userResponse);
    }
}
