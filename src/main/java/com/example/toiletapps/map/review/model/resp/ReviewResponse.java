package com.example.toiletapps.map.review.model.resp;

import com.example.toiletapps.map.review.model.Review;

import java.util.List;

public record ReviewResponse(
        List<Review> review,
        Double averageRating
) {
}
