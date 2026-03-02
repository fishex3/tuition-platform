package com.example.tuition_platform.service;

import com.example.tuition_platform.domain.dto.TutorPostingRequest;
import com.example.tuition_platform.domain.dto.TutorPostingResponse;
import com.example.tuition_platform.domain.entity.TutorPosting;
import com.example.tuition_platform.domain.entity.User;
import com.example.tuition_platform.mapper.TutorMapper;
import com.example.tuition_platform.repository.TutorPostingRepository;
import com.example.tuition_platform.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TutorService {
    private final TutorPostingRepository tutorPostingRepository;
    private final UserRepository userRepository;
    private final TutorMapper tutorMapper;

    public TutorService(
            TutorPostingRepository tutorPostingRepository,
            UserRepository userRepository,
            TutorMapper tutorMapper
    ) {
        this.tutorPostingRepository = tutorPostingRepository;
        this.tutorMapper = tutorMapper;
        this.userRepository = userRepository;

    }

    public TutorPostingResponse createPosting(
            User user,
            TutorPostingRequest tutorPostingRequest
    ) {
        TutorPosting tutorPosting = tutorMapper.fromDto(tutorPostingRequest);
        tutorPosting = tutorPostingRepository.save(tutorPosting);
        user.setTutor(true);
        userRepository.save(user);
        return tutorMapper.toDto(tutorPosting);
    }

    public List<TutorPostingResponse> getAllPostings() {
        List<TutorPostingResponse> tutorPostingResponseList = new ArrayList<>();
        List<TutorPosting> tutorPostings = tutorPostingRepository.findAll();
        return tutorPostings
                .stream()
                .map(tutorMapper::toDto)
                .toList();
    }

    public TutorPostingResponse getPostingById(UUID id) {
        TutorPosting tutorPosting = tutorPostingRepository
                .findByPostedBy(id)
                .orElseThrow(() -> new RuntimeException("Tutee posting with id " + id + " not found"));
        return tutorMapper.toDto(tutorPosting);
    }
}
