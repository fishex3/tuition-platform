package com.example.tuition_platform.repository;

import com.example.tuition_platform.domain.entity.TutorTuteeMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TutorTuteeMatchRepository extends JpaRepository<TutorTuteeMatch, UUID> {
    Optional<TutorTuteeMatch> findByTuteePosting(UUID id);
    Optional<TutorTuteeMatch> findByTutorPosting(UUID id);

}
