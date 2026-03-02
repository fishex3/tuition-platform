package com.example.tuition_platform.domain.dto;

public record UserLoginRequest(
        String username,
        String password
) {
}
