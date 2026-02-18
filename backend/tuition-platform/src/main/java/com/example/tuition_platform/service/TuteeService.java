package com.example.tuition_platform.service;

import com.example.tuition_platform.domain.dto.TuteePostingRequest;
import com.example.tuition_platform.domain.dto.TuteePostingResponse;
import com.example.tuition_platform.domain.entity.TuteePosting;
import com.example.tuition_platform.domain.entity.User;
import com.example.tuition_platform.mapper.TuteeMapper;
import com.example.tuition_platform.repository.TuteePostingRepository;
import com.example.tuition_platform.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TuteeService {
    private final TuteePostingRepository tuteePostingRepository;
    private final UserRepository userRepository;
    private final TuteeMapper tuteeMapper;

    public TuteeService(
            TuteePostingRepository tuteePostingRepository,
            UserRepository userRepository,
            TuteeMapper tuteeMapper) {
        this.tuteePostingRepository = tuteePostingRepository;
        this.tuteeMapper = tuteeMapper;
        this.userRepository = userRepository;

    }

    public TuteePostingResponse createPosting(
            User user,
            TuteePostingRequest tuteePostingRequest) {
        TuteePosting tuteePosting = tuteeMapper.fromDto(tuteePostingRequest);
        tuteePosting = tuteePostingRepository.save(tuteePosting);
        user.setTutee(true);
        userRepository.save(user);
        return tuteeMapper.toDto(tuteePosting);
    }

    public List<TuteePostingResponse> getAllPostings() {
        List<TuteePostingResponse> tuteePostingResponseList = new ArrayList<>();
        List<TuteePosting> tuteePostings = tuteePostingRepository.findAll();
        return tuteePostings
                .stream()
                .map(tuteeMapper::toDto)
                .toList();
    }

    public TuteePostingResponse getPostingById(UUID id) {
        TuteePosting tuteePosting = tuteePostingRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Tutee posting with id " + id + " not found"));
        return tuteeMapper.toDto(tuteePosting);
    }
}
