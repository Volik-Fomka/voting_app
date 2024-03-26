package com.example.votingservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String selection;

    @CreationTimestamp
    private LocalDateTime timestamp;

    // No-argument constructor for JPA
    public Vote() {
        // Required by JPA
    }

    public Vote(String selection) {
        this.selection = selection;
        // The timestamp is now automatically set by Hibernate, no need to set it manually
    }
    
    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // No need to manually set the timestamp, so the setter can be removed if not used elsewhere
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
