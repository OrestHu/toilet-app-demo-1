package com.example.toiletapps.map.marker.repository;

import com.example.toiletapps.map.marker.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<Tags, Integer> {
    Tags findByName(String name);
}
