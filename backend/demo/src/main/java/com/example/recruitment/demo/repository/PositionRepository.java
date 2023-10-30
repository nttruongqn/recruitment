package com.example.recruitment.demo.repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.recruitment.demo.entity.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, UUID> {
    
    @Query(value = "SELECT * FROM Position p WHERE p.id IN :ids", nativeQuery = true)
    List<Position> findByIds(@Param("ids") Collection<UUID> ids);
    

    // // @Query(value = "SELECT * FROM Position p WHERE p.id IN :ids")
    // public Optional<Position> findByIds(@Param("id") UUID id);
}