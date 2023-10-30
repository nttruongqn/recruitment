package com.example.recruitment.demo.request;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class UpdateJobRequest {
    private UUID id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
