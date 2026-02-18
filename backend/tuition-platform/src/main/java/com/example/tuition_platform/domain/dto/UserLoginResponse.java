package com.example.tuition_platform.domain.dto;

public record UserLoginResponse(
    String token,
    long expiresIn
) {
}
