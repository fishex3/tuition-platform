package com.example.tuition_platform.controller;

import com.example.tuition_platform.domain.dto.TutorPostingRequest;
import com.example.tuition_platform.domain.dto.TutorPostingResponse;
import com.example.tuition_platform.domain.entity.User;
import com.example.tuition_platform.service.TutorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/tutors")
@RestController
public class TutorController {
    private final TutorService tutorService;
    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping("")
    public ResponseEntity<List<TutorPostingResponse>> getAllPostings() {
        List<TutorPostingResponse> tutorPostings = tutorService.getAllPostings();
        return new ResponseEntity<>(tutorPostings, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<TutorPostingResponse> createPostings(
            @AuthenticationPrincipal @NotNull User user,
            @Valid @RequestBody TutorPostingRequest tutorPostingRequest
    ) {
        TutorPostingResponse response = tutorService.createPosting(user, tutorPostingRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{tutorPostingId}")
    public ResponseEntity<TutorPostingResponse> getPostingById(
            @PathVariable UUID tutorPostingId) {
        TutorPostingResponse response = tutorService.getPostingById(tutorPostingId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
