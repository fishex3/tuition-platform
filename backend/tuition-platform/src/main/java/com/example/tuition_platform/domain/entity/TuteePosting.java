package com.example.tuition_platform.domain.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tutee_posting")
public class TuteePosting {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "posted_by", nullable = false)
    private UUID postedBy;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "content")
    private String content;

    @Column(name = "education_level", nullable = false)
    private String educationLevel;

    @Column(name = "rates")
    private Integer rates;

    @Column(name = "location")
    private int location;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public TuteePosting(UUID postedBy, String subject, String content, String educationLevel, Integer rates, int location) {
        this.postedBy = postedBy;
        this.subject = subject;
        this.content = content;
        this.educationLevel = educationLevel;
        this.rates = rates;
        this.location = location;
    }

    protected TuteePosting() {

    }

    public UUID getId() {
        return id;
    }
    public UUID getPostedBy() {return postedBy;}
    public String getSubject() {return subject;}
    public String getContent() {return content;}
    public String getEducationLevel() {return educationLevel;}
    public Integer getRates() {return rates;}
    public int getLocation() {return location;}
    public LocalDateTime getCreatedAt() {return createdAt;}

    public void setSubject(String subject) {this.subject = subject;}
    public void setContent(String description) {this.content = description;}


}
