package com.example.tuition_platform.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record TutorPostingResponse(
        UUID id,
        UUID postedBy,
        String subject,
        String content,
        String educationLevel,
        int rates,
        int location,
        LocalDateTime createdAt
) {
}
