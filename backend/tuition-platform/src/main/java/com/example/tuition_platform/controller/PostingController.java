package com.example.tuition_platform.controller;

import com.example.tuition_platform.domain.entity.TutorPosting;
import com.example.tuition_platform.domain.entity.TuteePosting;
import com.example.tuition_platform.service.PostingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:3000")
public class PostingController {

    private final PostingService postingService;

    public PostingController(PostingService postingService) {
        this.postingService = postingService;
    }

    @PostMapping("/tutor")
    public ResponseEntity<String> createTutorListing(@RequestBody Map<String, Object> listingData) {
        postingService.createTutorPosting(listingData);
        return ResponseEntity.ok("Tutor listing saved to database successfully!");
    }

    @PostMapping("/tutee")
    public ResponseEntity<String> createTuteeListing(@RequestBody Map<String, Object> listingData) {
        postingService.createTuteePosting(listingData);
        return ResponseEntity.ok("Tutee listing saved to database successfully!");
    }

    @GetMapping("/tutor")
    public ResponseEntity<List<TutorPosting>> getAllTutorListings() {
        List<TutorPosting> allPostings = postingService.getAllTutorPostings();
        return ResponseEntity.ok(allPostings);
    }

    @GetMapping("/tutee")
    public ResponseEntity<List<TuteePosting>> getAllTuteeListings() {
        List<TuteePosting> allPostings = postingService.getAllTuteePostings();
        return ResponseEntity.ok(allPostings);
    }
}
