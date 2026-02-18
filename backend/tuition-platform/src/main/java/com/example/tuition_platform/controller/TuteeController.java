package com.example.tuition_platform.controller;

import com.example.tuition_platform.domain.dto.TuteePostingRequest;
import com.example.tuition_platform.domain.dto.TuteePostingResponse;
import com.example.tuition_platform.domain.entity.User;
import com.example.tuition_platform.service.TuteeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/tutees")
@RestController
public class TuteeController {
    private final TuteeService tuteeService;
    public TuteeController(TuteeService tuteeService) {
        this.tuteeService = tuteeService;
    }

    @GetMapping("")
    public ResponseEntity<List<TuteePostingResponse>> getAllPostings() {
        List<TuteePostingResponse> tuteePostings = tuteeService.getAllPostings();
        return new ResponseEntity<>(tuteePostings, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<TuteePostingResponse> createPostings(
            @AuthenticationPrincipal @NotNull User user,
            @Valid @RequestBody TuteePostingRequest tuteePostingRequest
    ) {
        TuteePostingResponse response = tuteeService.createPosting(user, tuteePostingRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{tuteePostingId}")
    public ResponseEntity<TuteePostingResponse> getPostingById(
            @PathVariable UUID tuteePostingId) {
        TuteePostingResponse response = tuteeService.getPostingById(tuteePostingId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
