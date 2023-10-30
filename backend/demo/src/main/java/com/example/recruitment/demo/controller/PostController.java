// package com.example.recruitment.demo.controller;

// import java.util.List;
// import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.recruitment.demo.entity.Post;
// import com.example.recruitment.demo.request.PostRequest;
// import com.example.recruitment.demo.service.PostService;

// @RestController
// @RequestMapping("/api/v1/admin/post")
// public class PostController {
//     @Autowired
//     PostService postService;

//     @GetMapping()
//     public ResponseEntity<List<Post>> getAllPost() {
//         return postService.getAll();
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Post> getById(@PathVariable("id") UUID jobId) {
//         return postService.getById(jobId);
//     }

//     @PostMapping()
//     public ResponseEntity<Post> create(@RequestBody PostRequest jobRequest) {
//         return postService.create(jobRequest);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Post> update(@PathVariable("id") UUID jobId, @RequestBody PostRequest jobRequest) {
//         return postService.update(jobId, jobRequest);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<HttpStatus> update(@PathVariable("id") UUID jobId) {
//         return postService.remove(jobId);
//     }
                                            
// }
