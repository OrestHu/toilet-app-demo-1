package com.example.toiletapps.map.repository;

import com.example.toiletapps.map.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagsRepository extends JpaRepository<Tags, Integer> {
    Tags findByName(String name);
}
