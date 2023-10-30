package com.example.recruitment.demo.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobPosition extends BaseEntity {
    @ManyToOne
    @JoinColumn(name="position_id")
    private Position position;
    
    @ManyToOne
    @JoinColumn(name="job_id")
    private Post job;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
}
