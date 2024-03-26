package com.example.toiletapps.map.review.api.service.impl;

import com.example.toiletapps.map.review.api.service.ReviewApiService;
import com.example.toiletapps.map.review.model.resp.ReviewResponse;
import com.example.toiletapps.map.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewApiServiceImpl implements ReviewApiService {
    private final ReviewService reviewService;
    @Override
    public Double reviewAverageRating(Integer id) {
        ReviewResponse allReviewByMarkerId = reviewService.findAllReviewByMarkerId(id);
        return allReviewByMarkerId.averageRating();
    }
}
