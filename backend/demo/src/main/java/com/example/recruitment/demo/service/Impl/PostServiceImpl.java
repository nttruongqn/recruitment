// package com.example.recruitment.demo.service.impl;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;
// import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Component;

// import com.example.recruitment.demo.entity.Job;
// import com.example.recruitment.demo.entity.Position;
// import com.example.recruitment.demo.entity.Post;
// import com.example.recruitment.demo.repository.PostRepository;
// import com.example.recruitment.demo.request.PostRequest;
// import com.example.recruitment.demo.service.JobService;
// import com.example.recruitment.demo.service.PositionService;
// import com.example.recruitment.demo.service.PostService;

// @Component
// public class PostServiceImpl implements PostService {
//     @Autowired
//     PostRepository postRepository;

//     @Autowired
//     PositionService positionService;

//     @Autowired
//     JobService jobService;

//     @Override
//     public ResponseEntity<List<Post>> getAll() {
//         try {
//             List<Post> posts = new ArrayList<Post>();
//             postRepository.findAll().forEach(posts::add);
//             if (posts.isEmpty()) {
//                 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//             }
//             return new ResponseEntity<>(posts, HttpStatus.OK);

//             // return new ResponseEntity<>(posts, HttpStatus.OK);
//         } catch (Exception e) {
//             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//         }
//     }

//     @Override
//     public ResponseEntity<Post> getById(UUID id) {
//         Optional<Post> Post = postRepository.findById(id);
//         if (Post.isPresent()) {
//             return new ResponseEntity<>(Post.get(), HttpStatus.OK);
//         } else {
//             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//         }
//     }

//     private List<Position> getPositionListByIds(List<UUID> positionIds) {
//         List<Position> positions = new ArrayList<>();
//         if (positionIds != null && !positionIds.isEmpty()) {
//             positions = positionService.getByIds(positionIds);
//         }
//         return positions;
//     }

//     private List<Job> getJobListByIds(List<UUID> jobIds) {
//         List<Job> jobs = new ArrayList<>();
//         if (jobIds != null && !jobIds.isEmpty()) {
//             jobs = jobService.getByIds(jobIds);
//         }
//         return jobs;
//     }

//     @Override
//     public ResponseEntity<Post> create(PostRequest postRequest) {
//         var positions = getPositionListByIds(postRequest.getPositionIds());
//         var jobs = getJobListByIds(postRequest.getJobIds());
//         try {
//             var post = Post.builder()
//                     .name(postRequest.getName())
//                     .content(postRequest.getContent())
//                     .amount(postRequest.getAmount())
//                     .expireDayNumber(postRequest.getExpireDayNumber())
//                     .positions(positions.isEmpty() ? null : positions)
//                     .jobs(jobs.isEmpty() ? null : jobs)
//                     .build();
//             postRepository.save(post);
//             return new ResponseEntity<>(post, HttpStatus.CREATED);
//         } catch (Exception e) {
//             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//         }
//     }

//     @Override
//     public ResponseEntity<Post> update(UUID id, PostRequest postRequest) {
//         Optional<Post> post = postRepository.findById(id);
//         var positions = getPositionListByIds(postRequest.getPositionIds());
//         var jobs = getJobListByIds(postRequest.getJobIds());
//         if (post.isPresent()) {
//             Post postPayload = post.get();
//             postPayload.setName(postRequest.getName());
//             postPayload.setContent(postRequest.getContent());
//             postPayload.setAmount(postRequest.getAmount());
//             postPayload.setPositions(positions);
//             postPayload.setJobs(jobs);
//             postPayload.setExpireDayNumber(postRequest.getExpireDayNumber());
//             return new ResponseEntity<>(postRepository.save(postPayload), HttpStatus.NO_CONTENT);
//         } else {
//             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//         }
//     }

//     @Override
//     public ResponseEntity<HttpStatus> remove(UUID id) {
//         try {
//             postRepository.deleteById(id);
//             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//         } catch (Exception e) {
//             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//         }
//     }

// }
