package com.example.tuition_platform.domain.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.stat.internal.StatsHelper;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tutor_tutee_match")
public class TutorTuteeMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "tutor_posting", updatable = false)
    private UUID tutorPosting;

    @Column(name = "tutee_posting", updatable = false)
    private UUID tuteePosting;

    private int matchScore;

    private Status status;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    public TutorTuteeMatch(UUID tuteePosting, UUID tutorPosting, int matchScore, Status status) {
        this.tuteePosting = tuteePosting;
        this.tutorPosting = tutorPosting;
        this.matchScore = matchScore;
        this.status = status;
    }

    protected TutorTuteeMatch() {}

    public UUID getId() {return id;}
    public UUID getTutorPosting() {return tutorPosting;}
    public UUID getTuteePosting() {return tuteePosting;}
    public int getMatchScore() {return matchScore;}
    public Status getStatus() {return status;}
    public void setStatus(Status status) {this.status = status;}
    public void setMatchScore(int matchScore) {this.matchScore = matchScore;}
}
