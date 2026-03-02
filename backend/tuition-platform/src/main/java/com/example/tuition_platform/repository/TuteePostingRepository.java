package com.example.tuition_platform.repository;

import com.example.tuition_platform.domain.entity.TuteePosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TuteePostingRepository extends JpaRepository<TuteePosting, UUID> {
    Optional<TuteePosting> findByPostedBy(UUID id);
}
