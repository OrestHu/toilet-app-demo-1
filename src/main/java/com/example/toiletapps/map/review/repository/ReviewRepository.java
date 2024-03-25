package com.example.toiletapps.map.review.repository;

import com.example.toiletapps.map.marker.model.Marker;
import com.example.toiletapps.map.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findAllByMarker(Marker marker);
}
