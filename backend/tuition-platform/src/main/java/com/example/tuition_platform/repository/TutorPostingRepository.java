package com.example.tuition_platform.repository;

import com.example.tuition_platform.domain.entity.TutorPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TutorPostingRepository extends JpaRepository<TutorPosting, UUID> {
    Optional<TutorPosting> findByPostedBy(UUID postingId);
}
