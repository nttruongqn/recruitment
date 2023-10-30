package com.example.recruitment.demo.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


public class JobResponse {
    private UUID id;
    private String name;
    private int amount;
    private String content;
    private int expireDayNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
