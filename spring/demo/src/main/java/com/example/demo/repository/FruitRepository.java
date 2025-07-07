package com.example.demo.repository;

import com.example.demo.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    Optional<Fruit> findByName(String name);
}
