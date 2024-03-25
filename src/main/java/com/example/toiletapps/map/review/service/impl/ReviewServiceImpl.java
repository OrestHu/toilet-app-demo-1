package com.example.toiletapps.map.review.service.impl;

import com.example.toiletapps.map.marker.api.service.MarkerApiService;
import com.example.toiletapps.map.marker.model.Marker;
import com.example.toiletapps.map.review.model.Review;
import com.example.toiletapps.map.review.repository.ReviewRepository;
import com.example.toiletapps.map.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final MarkerApiService markerApiService;
    @Override
    public void addReview(Review request) {
        reviewRepository.save(request);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(Integer id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Review not found by this id %s", id)));
    }

    @Override
    public void deleteReview(Integer id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<Review> findAllReviewByMarkerId(Integer id) {
        Marker marker = markerApiService.findMarkerByApi(id);
        return reviewRepository.findAllByMarker(marker);
    }
}
