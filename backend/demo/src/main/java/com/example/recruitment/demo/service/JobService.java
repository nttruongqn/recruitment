package com.example.recruitment.demo.service;

import com.example.recruitment.demo.dto.JobDto;
import com.example.recruitment.demo.entity.Job;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface JobService {
    ResponseEntity<Job> save(JobDto dto);

    ResponseEntity<Job> findById(UUID id);

    ResponseEntity<Page<Job>> findAll(int currentPage, int pageSize, String[] sortAndOrder, String keyword);

    ResponseEntity<HttpStatus> update(UUID id, JobDto jobDto);

    ResponseEntity<HttpStatus> delete(UUID id);
}
