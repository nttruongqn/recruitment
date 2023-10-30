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

// import com.example.recruitment.demo.entity.Position;
// import com.example.recruitment.demo.request.PositionRequest;
// import com.example.recruitment.demo.service.PositionService;

// @RestController
// @RequestMapping("/api/v1/admin/position")
// public class PositionController {
//      @Autowired
//     PositionService positionService;

//       @GetMapping()
//     public ResponseEntity<List<Position>> getAllPosition() {
//         return positionService.getAll();
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Position> getById(@PathVariable("id") UUID positionId) {
//         return positionService.getById(positionId);
//     }

//     @PostMapping()
//     public ResponseEntity<Position> create(@RequestBody PositionRequest positionRequest) {
//         return positionService.create(positionRequest);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Position> update(@PathVariable("id") UUID positionId, @RequestBody PositionRequest positionRequest) {
//         return positionService.update(positionId, positionRequest);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<HttpStatus> update(@PathVariable("id") UUID positionId) {
//         return positionService.remove(positionId);
//     }
// }
