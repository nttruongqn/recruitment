package com.example.recruitment.demo.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"user\"")  
public class User extends BaseEntity {
    private String name;
    
    private String email;
    
    private String address;
    
    private String phone;
    
    @Lob
    private byte[] data;

    @OneToOne
    @JoinColumn(name="job_position_id")
    private JobPosition jobPosition; 
}
