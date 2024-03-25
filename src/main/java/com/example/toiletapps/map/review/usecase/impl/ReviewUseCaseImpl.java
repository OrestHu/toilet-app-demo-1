package com.example.toiletapps.map.review.usecase.impl;

import com.example.toiletapps.map.review.mapper.ReviewRequestToReviewMapper;
import com.example.toiletapps.map.review.model.Review;
import com.example.toiletapps.map.review.model.req.ReviewRequest;
import com.example.toiletapps.map.review.service.ReviewService;
import com.example.toiletapps.map.review.usecase.ReviewUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewUseCaseImpl implements ReviewUseCase {
    private final ReviewRequestToReviewMapper reviewRequestToReviewMapper;
    private final ReviewService reviewService;

    @Override
    public void addReview(ReviewRequest request) {
        Review review = reviewRequestToReviewMapper.map(request);
        reviewService.addReview(review);
    }
    @Override
    public List<Review> findAll() {
        return reviewService.findAll();
    }
    @Override
    public Review findByReviewId(Integer id) {
        return reviewService.findById(id);
    }

    @Override
    public void deleteReview(Integer id) {
        reviewService.deleteReview(id);
    }
}
