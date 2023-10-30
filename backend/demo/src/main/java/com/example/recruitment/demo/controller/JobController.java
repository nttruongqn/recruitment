package com.example.recruitment.demo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.recruitment.demo.controller.api.JobApi;
import com.example.recruitment.demo.dto.JobDto;
import com.example.recruitment.demo.entity.Job;
import com.example.recruitment.demo.service.JobService;

@RestController
public class JobController implements JobApi {
    @Autowired
    JobService jobService;

    @Override
    public ResponseEntity<Job> save(JobDto jobDto) {
        return jobService.save(jobDto);
    }

    @Override
    public ResponseEntity<Job> findById(UUID id) {
        return jobService.findById(id);
    }

    @Override
    public ResponseEntity<Page<Job>> findAll(int currentPage, int pageSize, String[] sortAndOrder, String keyword) {
        return jobService.findAll(currentPage, pageSize, sortAndOrder, keyword);
    }

    @Override
    public ResponseEntity<HttpStatus> update(UUID id, JobDto jobDto) {
        return jobService.update(id, jobDto);
    }

    @Override
    public ResponseEntity<HttpStatus> delete(UUID id) {
        return jobService.delete(id);
    }
}
