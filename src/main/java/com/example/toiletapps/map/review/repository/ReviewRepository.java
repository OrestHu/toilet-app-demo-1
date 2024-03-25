package com.example.toiletapps.map.review.repository;

import com.example.toiletapps.map.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
