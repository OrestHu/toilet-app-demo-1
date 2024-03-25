package com.example.toiletapps.map.review.usecase;

import com.example.toiletapps.map.review.model.Review;
import com.example.toiletapps.map.review.model.req.ReviewRequest;


import java.util.List;

public interface ReviewUseCase {
    void addReview(ReviewRequest request);
    List<Review> findAll();
    Review findByReviewId(Integer id);
    void deleteReview(Integer id);
}
