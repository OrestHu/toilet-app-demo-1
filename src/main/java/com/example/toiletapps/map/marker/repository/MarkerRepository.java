package com.example.toiletapps.map.marker.repository;

import com.example.toiletapps.map.marker.model.Marker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MarkerRepository extends JpaRepository<Marker, Integer> {
    boolean existsByName(String name);
    List<Marker> getAllByVisibilityIsTrue();
    List<Marker> getAllByVisibilityIsFalse();
    Optional<Marker> findByName(String name);

}
