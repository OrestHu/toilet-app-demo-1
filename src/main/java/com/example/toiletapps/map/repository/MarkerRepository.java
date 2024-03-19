package com.example.toiletapps.map.repository;

import com.example.toiletapps.map.model.Marker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkerRepository extends JpaRepository<Marker, Integer> {
    boolean existsByName(String name);
    List<Marker> getAllByVisibilityIsTrue();
    List<Marker> getAllByVisibilityIsFalse();
    Marker findByName(String name);
}
