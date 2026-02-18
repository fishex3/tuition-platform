package com.example.tuition_platform.mapper;

import com.example.tuition_platform.domain.dto.UserResponse;
import com.example.tuition_platform.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserResponse toDto(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt(),
                user.isTutor(),
                user.isTutee()
        );
    }
}
