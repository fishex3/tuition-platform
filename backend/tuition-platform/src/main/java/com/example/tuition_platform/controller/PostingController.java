package com.example.tuition_platform.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/posts")
public class PostingController {

    // 1. Endpoint for creating a TUTOR listing
    @PostMapping("/tutor")
    public ResponseEntity<String> createTutorListing(@RequestBody Map<String, Object> listingData) {
        // Right now, this just accepts the JSON from the frontend and prints it to your
        // terminal
        System.out.println("Received new Tutor Listing: " + listingData);

        // Later, we will connect this to the database. For now, we return a success
        // message!
        return ResponseEntity.ok("Tutor listing endpoint hit successfully! Data received.");
    }

    // 2. Endpoint for creating a TUTEE listing
    @PostMapping("/tutee")
    public ResponseEntity<String> createTuteeListing(@RequestBody Map<String, Object> listingData) {

        System.out.println("Received new Tutee Listing: " + listingData);

        return ResponseEntity.ok("Tutee listing endpoint hit successfully! Data received.");
    }
}