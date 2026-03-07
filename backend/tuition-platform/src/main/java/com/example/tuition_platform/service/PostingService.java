package com.example.tuition_platform.service;

import com.example.tuition_platform.domain.entity.TutorPosting;
import com.example.tuition_platform.domain.entity.TuteePosting;
import com.example.tuition_platform.repository.TutorPostingRepository;
import com.example.tuition_platform.repository.TuteePostingRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.List;

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
        // 1. Extract the data from your React website
        String subject = (String) data.get("subject");
        String educationLevel = (String) data.get("level"); // React sends this as "level"

        // Convert the rate safely to an Integer to match the 1st guy's code
        Integer rates = 0;
        if (data.get("hourlyRate") != null) {
            rates = Integer.valueOf(data.get("hourlyRate").toString());
        }

        // 2. Set defaults for things your React form doesn't have yet
        String content = "No description provided";
        int location = 0;

        // 3. Create a fake User ID since we bypassed the login screen for testing
        UUID dummyUserId = UUID.randomUUID();

        // 4. Use your teammate's exact constructor to build the object
        TutorPosting posting = new TutorPosting(dummyUserId, subject, content, educationLevel, rates, location);

        // 5. Save it permanently to MongoDB!
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

    // This grabs ALL tutor postings from the database
    public List<TutorPosting> getAllTutorPostings() {
        return tutorPostingRepository.findAll();
    }
}
