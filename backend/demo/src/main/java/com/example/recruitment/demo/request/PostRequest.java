package com.example.recruitment.demo.request;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.example.recruitment.demo.entity.Job;
import com.example.recruitment.demo.entity.Position;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private String name;
    private int amount;
    private String content;
    private int expireDayNumber;
    private List<UUID> jobIds;
    private List<UUID> positionIds;
}
