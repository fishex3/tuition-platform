package com.example.tuition_platform.service;

import com.example.tuition_platform.domain.dto.UserResponse;
import com.example.tuition_platform.domain.entity.User;
import com.example.tuition_platform.mapper.UserMapper;
import com.example.tuition_platform.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(
            UserRepository userRepository,
            UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse getMe(User user) {
        return userMapper.toDto(user);
    }
}
