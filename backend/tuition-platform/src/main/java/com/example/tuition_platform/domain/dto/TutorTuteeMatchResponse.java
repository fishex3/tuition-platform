package com.example.tuition_platform.domain.dto;

import com.example.tuition_platform.domain.entity.Status;

import java.time.LocalDateTime;
import java.util.UUID;

public record TutorTuteeMatchResponse(
        UUID id,
        UUID tutorId,
        UUID tuteeId,
        int matchScore,
        Status status,
        LocalDateTime createdAt
) {
}
