package com.example.recruitment.demo.controller.api;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.recruitment.demo.dto.JobDto;
import com.example.recruitment.demo.entity.Job;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import static com.example.recruitment.demo.utils.Constants.ADMIN_API;

public interface JobApi {
        @PostMapping(value = ADMIN_API
                        + "/jobs/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        @Operation(summary = "Create job", description = "Created job")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Create job success") })
        ResponseEntity<Job> save(@RequestBody JobDto jobDto);

        @Operation(summary = "Find job by id", description = "Find job by id")
        @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Find job success"),
        // @ApiResponse(responseCode = "400", description = "Invalid id"),
        // @ApiResponse(responseCode = "404", description = "Job not found")
        })
        @GetMapping(value = ADMIN_API + "/jobs/{jobId}", produces = MediaType.APPLICATION_JSON_VALUE)
        ResponseEntity<Job> findById(@PathVariable("jobId") UUID id);

        @Operation(summary = "Find all jobs", description = "Find all jobs")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Find all jobs success"),
        // @ApiResponse(responseCode = "204", description = "Empty job"),
        // @ApiResponse(responseCode = "500", description = "Internal server error")
        })
        @GetMapping(value = ADMIN_API + "/jobs/all", produces = MediaType.APPLICATION_JSON_VALUE)
        ResponseEntity<Page<Job>> findAll(
                        @RequestParam(required = false, defaultValue = "0") int currentPage,
                        @RequestParam(required = false, defaultValue = "4") int pageSize,
                        @RequestParam(required = false, defaultValue = "id#desc") String[] sortAndOrder,
                        @RequestParam(required = false, defaultValue = "") String keyword);

        @PutMapping(value = ADMIN_API
                        + "/jobs/update/{jobId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        @Operation(summary = "Update job", description = "Update job")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "204", description = "Update job success"),
        // @ApiResponse(responseCode = "404", description = "Job not found"),
        // @ApiResponse(responseCode = "500", description = "Internal server error")
        })
        ResponseEntity<HttpStatus> update(@PathVariable("jobId") UUID id, @RequestBody JobDto jobDto);

        @DeleteMapping(value = ADMIN_API + "/jobs/delete/{jobId}")
        @Operation(summary = "Delete job", description = "Delete job")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "204", description = "Delete job success"),
        // @ApiResponse(responseCode = "404", description = "Job not found"),
        })
        ResponseEntity<HttpStatus> delete(@PathVariable("jobId") UUID id);

}
