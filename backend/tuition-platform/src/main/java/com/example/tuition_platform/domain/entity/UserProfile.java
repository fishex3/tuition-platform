package com.example.tuition_platform.domain.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "user_profile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "content")
    private String content;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "points")
    private int points;

    public UserProfile(String content, Integer rating, UUID userId, int points) {
        this.content = content;
        this.rating = rating;
        this.userId = userId;
        this.points = points;
    }

    protected UserProfile() {

    }

    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
