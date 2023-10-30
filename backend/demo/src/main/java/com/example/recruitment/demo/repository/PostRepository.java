package com.example.recruitment.demo.repository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.recruitment.demo.entity.Post;

@Repository
public interface PostRepository  extends JpaRepository<Post, UUID> {
}