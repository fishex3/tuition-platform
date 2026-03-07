package com.example.tuition_platform.controller;

import com.example.tuition_platform.service.PostingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;
import com.example.tuition_platform.domain.entity.TutorPosting;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:3001" })
public class PostingController {

    private final PostingService postingService;

    // This connects your controller to your new service
    public PostingController(PostingService postingService) {
        this.postingService = postingService;
    }

    @PostMapping("/tutor")
    public ResponseEntity<String> createTutorListing(@RequestBody Map<String, Object> listingData) {
        System.out.println("Saving Tutor Listing to Database: " + listingData);

        // Hands the data to the service to be saved
        postingService.createTutorPosting(listingData);

        return ResponseEntity.ok("Tutor listing saved to database successfully!");
    }

    @PostMapping("/tutee")
    public ResponseEntity<String> createTuteeListing(@RequestBody Map<String, Object> listingData) {
        System.out.println("Saving Tutee Listing to Database: " + listingData);

        postingService.createTuteePosting(listingData);

        return ResponseEntity.ok("Tutee listing saved to database successfully!");
    }

    // optional endpoint for fetching all tutor postings
    @GetMapping("/tutor")
    public ResponseEntity<List<TutorPosting>> getAllTutorListings() {
        System.out.println("Fetching all tutor listings from the database...");
        List<TutorPosting> allPostings = postingService.getAllTutorPostings();
        return ResponseEntity.ok(allPostings);
    }
}
