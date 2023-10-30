package com.example.recruitment.demo.dto;
import com.example.recruitment.demo.entity.Job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {
    private String name;

    public static JobDto fromEntity(Job job) {
        if (job == null) {
            return null;
        }
        return JobDto.builder()
                .name(job.getName())
                .build();
    }

    public static Job toEntity(JobDto jobDto) {
        if (jobDto == null) {
            return null;
        }

        Job job = new Job();
        job.setName(jobDto.getName());
        return job;
    }
}
