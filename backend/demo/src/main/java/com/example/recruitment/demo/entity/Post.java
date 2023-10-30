package com.example.recruitment.demo.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post extends BaseEntity {
    private String name;

    private String content;

    private int amount;

    private int expireDayNumber;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToMany(mappedBy = "job")
    private List<JobPosition> jobPositions;

    @ManyToMany
    @JoinTable(
        name = "posts_jobs",
        joinColumns = { @JoinColumn(name="post_id") },
        inverseJoinColumns = { @JoinColumn(name="job_id") }
    )
    public List<Job> jobs;

    
    @ManyToMany
    @JoinTable(
        name = "posts_positions",
        joinColumns = { @JoinColumn(name="post_id") },
        inverseJoinColumns = { @JoinColumn(name="position_id") }
    )
    public List<Position> positions;
}
