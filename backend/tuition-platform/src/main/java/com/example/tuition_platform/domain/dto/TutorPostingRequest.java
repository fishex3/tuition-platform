package com.example.tuition_platform.domain.dto;

import java.util.UUID;

public record TutorPostingRequest(
        UUID postedBy,
        String subject,
        String content,
        String educationLevel,
        int rates,
        int location
)
{
}
