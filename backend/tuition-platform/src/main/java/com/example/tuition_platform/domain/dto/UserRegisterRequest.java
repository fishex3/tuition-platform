package com.example.tuition_platform.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public record UserRegisterRequest(
        @NotBlank(message = "${user.username.length}")
        String username,
        String email,
        @NotBlank(message = "${user.password.lenth}")
        String password
) {
}
