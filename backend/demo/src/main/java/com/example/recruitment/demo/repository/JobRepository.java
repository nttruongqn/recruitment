package com.example.recruitment.demo.repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.recruitment.demo.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, UUID> {

    @Query(value = "SELECT * FROM Job j WHERE j.id IN :ids", nativeQuery = true)
    List<Job> findByIds(@Param("ids") Collection<UUID> ids);

    @Query(value = "select * from Job j where j.name like %:keyword% ", nativeQuery = true)
    Page<Job> findByKeyword(Pageable pageable, @Param("keyword") String keyword);    
}
