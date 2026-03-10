package com.example.tuition_platform.service;

import com.example.tuition_platform.domain.entity.TutorPosting;
import com.example.tuition_platform.domain.entity.TuteePosting;
import com.example.tuition_platform.repository.TutorPostingRepository;
import com.example.tuition_platform.repository.TuteePostingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PostingService {

    private final TutorPostingRepository tutorPostingRepository;
    private final TuteePostingRepository tuteePostingRepository;

    public PostingService(TutorPostingRepository tutorPostingRepository,
            TuteePostingRepository tuteePostingRepository) {
        this.tutorPostingRepository = tutorPostingRepository;
        this.tuteePostingRepository = tuteePostingRepository;
    }

    public TutorPosting createTutorPosting(Map<String, Object> data) {
        String subject = (String) data.get("subject");
        String educationLevel = (String) data.get("level");
        Integer rates = 0;
        if (data.get("hourlyRate") != null) {
            rates = Integer.valueOf(data.get("hourlyRate").toString());
        }
        String content = "No description provided";
        int location = 0;
        UUID dummyUserId = UUID.randomUUID();

        TutorPosting posting = new TutorPosting(dummyUserId, subject, content, educationLevel, rates, location);
        return tutorPostingRepository.save(posting);
    }

    public TuteePosting createTuteePosting(Map<String, Object> data) {
        String subject = (String) data.get("subject");
        String educationLevel = (String) data.get("level");
        Integer rates = 0;
        if (data.get("hourlyRate") != null) {
            rates = Integer.valueOf(data.get("hourlyRate").toString());
        }
        String content = "No description provided";
        int location = 0;
        UUID dummyUserId = UUID.randomUUID();

        TuteePosting posting = new TuteePosting(dummyUserId, subject, content, educationLevel, rates, location);
        return tuteePostingRepository.save(posting);
    }

    public List<TutorPosting> getAllTutorPostings() {
        return tutorPostingRepository.findAll();
    }

    public List<TuteePosting> getAllTuteePostings() {
        return tuteePostingRepository.findAll();
    }
}
