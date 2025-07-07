package com.example.demo.repository;

import com.example.demo.entity.SamplePost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SamplePostRepository extends JpaRepository<SamplePost, Long> {
}
