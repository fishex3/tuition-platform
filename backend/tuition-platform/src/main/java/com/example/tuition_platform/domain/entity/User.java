package com.example.tuition_platform.domain.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@NullMarked
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private @Nullable LocalDateTime createdAt;

    @Column(name = "is_tutor", nullable = false)
    private boolean isTutor = false;

    @Column(name = "is_tutee", nullable = false)
    private boolean isTutee = false;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    protected User() {}


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return a list of roles that specific user can have
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (isTutor) {
            authorities.add(new SimpleGrantedAuthority("ROLE_TUTOR"));
        }
        if (isTutee) {
            authorities.add(new SimpleGrantedAuthority("ROLE_TUTEE"));
        }
        return authorities;
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }

    @Override
    public @Nullable String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public UUID getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.createdAt = timestamp;
    }

    public boolean isTutor() {
        return isTutor;
    }

    public void setTutor(boolean tutor) {
        isTutor = tutor;
    }

    public boolean isTutee() {
        return isTutee;
    }

    public void setTutee(boolean tutee) {
        isTutee = tutee;
    }
}
