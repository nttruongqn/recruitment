package com.example.recruitment.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.recruitment.demo.entity.Position;
import com.example.recruitment.demo.request.PositionRequest;

public interface PositionService {
    ResponseEntity<List<Position>> getAll();

    ResponseEntity<Position> getById(UUID id);

    ResponseEntity<Position> create(PositionRequest positionRequest);

    ResponseEntity<Position> update(UUID id, PositionRequest positionRequest);

    ResponseEntity<HttpStatus> remove(UUID id);

    List<Position> getByIds(List<UUID> ids);
}
