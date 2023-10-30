package com.example.recruitment.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.recruitment.demo.entity.Post;
import com.example.recruitment.demo.request.PostRequest;

@Service
public interface PostService {
    ResponseEntity<List<Post>> getAll();
    ResponseEntity<Post> getById(UUID id);
    ResponseEntity<Post> create(PostRequest jobRequest);
    ResponseEntity<Post> update(UUID id, PostRequest jobRequest);
    ResponseEntity<HttpStatus> remove(UUID id);
}
