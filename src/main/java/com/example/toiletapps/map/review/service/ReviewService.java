package com.example.toiletapps.map.review.service;

import com.example.toiletapps.map.review.model.Review;

import java.util.List;

public interface ReviewService {
    void addReview(Review request);
    List<Review> findAll();
    Review findById(Integer id);
    void deleteReview(Integer id);
}
