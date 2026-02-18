package com.example.tuition_platform.service;

import com.example.tuition_platform.domain.dto.UserLoginRequest;
import com.example.tuition_platform.domain.dto.UserLoginResponse;
import com.example.tuition_platform.domain.dto.UserRegisterRequest;
import com.example.tuition_platform.domain.entity.User;
import com.example.tuition_platform.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signup(UserRegisterRequest input) {
        User user = new User(
                input.username(),
                input.email(),
                Objects.requireNonNull(passwordEncoder.encode(input.password()))
                );
        return userRepository.save(user);
    }

    public User authenticate(UserLoginRequest userLoginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLoginRequest.username(),
                        userLoginRequest.password()
                )
        );
        return userRepository.findByUsername(userLoginRequest.username())
                .orElseThrow();
    }
}
