package com.example.tuition_platform.mapper;

import com.example.tuition_platform.domain.dto.TutorPostingRequest;
import com.example.tuition_platform.domain.dto.TutorPostingResponse;
import com.example.tuition_platform.domain.entity.TutorPosting;
import org.springframework.stereotype.Service;

@Service
public class TutorMapper {
    public TutorPostingResponse toDto(TutorPosting tutorPosting) {
        return new TutorPostingResponse(
                tutorPosting.getId(),
                tutorPosting.getPostedBy(),
                tutorPosting.getSubject(),
                tutorPosting.getContent(),
                tutorPosting.getEducationLevel(),
                tutorPosting.getRates(),
                tutorPosting.getLocation(),
                tutorPosting.getCreatedAt()
        );
    }
    public TutorPosting fromDto(TutorPostingRequest tutorPostingRequest) {
        return new TutorPosting(
                tutorPostingRequest.postedBy(),
                tutorPostingRequest.subject(),
                tutorPostingRequest.content(),
                tutorPostingRequest.educationLevel(),
                tutorPostingRequest.rates(),
                tutorPostingRequest.location()
        );
    }
}
