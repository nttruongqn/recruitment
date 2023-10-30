package com.example.recruitment.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.recruitment.demo.dto.JobDto;
import com.example.recruitment.demo.entity.Job;
import com.example.recruitment.demo.entity.JobPosition;
import com.example.recruitment.demo.exception.EntityNotFoundException;
import com.example.recruitment.demo.exception.ErrorCodes;
import com.example.recruitment.demo.exception.InvalidEntityException;
import com.example.recruitment.demo.repository.JobRepository;
import com.example.recruitment.demo.service.JobService;
import com.example.recruitment.demo.validator.JobValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;

    @Override
    public ResponseEntity<Job> save(JobDto jobDto) {
        List<String> errors = JobValidator.validate(jobDto);
        if (!errors.isEmpty()) {
            log.error("Job is not invalid {}", jobDto);
            throw new InvalidEntityException("Invalid", ErrorCodes.JOB_NOT_VALID, errors);
        }

        Job job = jobRepository.save(JobDto.toEntity(jobDto));
        return new ResponseEntity<>(job, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Job> findById(UUID id) {
        if (id == null) {
            log.error("Job id is null");
            return null;
        }

        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can not find id " + id, ErrorCodes.JOB_NOT_FOUND));
        return new ResponseEntity<>(job, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Page<Job>> findAll(int currentPage, int pageSize, String[] sortAndOrder, String keyword) {
        try {
            final List<Order> orders = Arrays.stream(sortAndOrder)
            .filter(s -> s.contains("#"))
            .map(s->s.split("#")).map(arr-> new Order(
                Direction.fromString(arr[1]), arr[0]))
                .collect(Collectors.toList());
            final Pageable paging = PageRequest.of(currentPage, pageSize, Sort.by(orders));
            return new ResponseEntity<>(keyword.isBlank() ? jobRepository.findAll(paging) : jobRepository.findByKeyword(paging, keyword), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> update(UUID id, JobDto jobDto) {
        if (id == null) {
            log.error("Job id is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Job> job = jobRepository.findById(id);
        if (job.isEmpty()) {
            throw new EntityNotFoundException("Can not find id " + id, ErrorCodes.JOB_NOT_FOUND);
        }
        Job jobExisted = job.get();
        jobExisted.setName(jobDto.getName());
        jobRepository.save(jobExisted);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<HttpStatus> delete(UUID id) {
        if (id == null) {
            log.error("Job id is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Job> job = jobRepository.findById(id);
        if (job.isEmpty()) {
            throw new EntityNotFoundException("Can not find id " + id, ErrorCodes.JOB_NOT_FOUND);
        }
        jobRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
