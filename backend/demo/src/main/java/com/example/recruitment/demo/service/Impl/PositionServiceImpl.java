// package com.example.recruitment.demo.service.impl;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;
// import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Component;

// import com.example.recruitment.demo.entity.Position;
// import com.example.recruitment.demo.repository.PositionRepository;
// import com.example.recruitment.demo.request.PositionRequest;
// import com.example.recruitment.demo.service.PositionService;

// @Component
// public class PositionServiceImpl implements PositionService {
//     @Autowired
//     PositionRepository positionRepository;

//     @Override
//     public ResponseEntity<List<Position>> getAll() {
//         try {
//             List<Position> positions = new ArrayList<Position>();
//             positionRepository.findAll().forEach(positions::add);
//             if (positions.isEmpty()) {
//                 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//             }
//             return new ResponseEntity<>(positions, HttpStatus.OK);
//         } catch (Exception e) {
//             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//         }
//     }

//     @Override
//     public ResponseEntity<Position> getById(UUID id) {
//         Optional<Position> position = positionRepository.findById(id);
//         if (position.isPresent()) {
//             return new ResponseEntity<>(position.get(), HttpStatus.OK);
//         } else {
//             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//         }
//     }

//     @Override
//     public ResponseEntity<Position> create(PositionRequest positionRequest) {
//         try {
//             var position = Position.builder()
//                     .name(positionRequest.getName()).build();
//             positionRepository.save(position);
//             return new ResponseEntity<>(position, HttpStatus.CREATED);
//         } catch (Exception e) {
//             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//         }
//     }

//     @Override
//     public ResponseEntity<Position> update(UUID id, PositionRequest positionRequest) {
//         Optional<Position> position = positionRepository.findById(id);
//         if (position.isPresent()) {
//             Position positionPayload = position.get();
//             positionPayload.setName(positionRequest.getName());
//             return new ResponseEntity<>(positionRepository.save(positionPayload), HttpStatus.NO_CONTENT);
//         } else {
//             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//         }
//     }

//     @Override
//     public ResponseEntity<HttpStatus> remove(UUID id) {
//         try {
//             positionRepository.deleteById(id);
//             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//         } catch (Exception e) {
//             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//         }
//     }

//     @Override
//     public List<Position> getByIds(List<UUID> ids) {
//         List<Position> positions = positionRepository.findByIds(ids); 
//         return positions;
//     }

// }
