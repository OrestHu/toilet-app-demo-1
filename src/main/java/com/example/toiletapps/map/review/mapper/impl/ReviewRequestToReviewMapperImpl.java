package com.example.toiletapps.map.review.mapper.impl;

import com.example.toiletapps.map.marker.api.service.MarkerApiService;
import com.example.toiletapps.map.marker.model.Marker;
import com.example.toiletapps.map.review.mapper.ReviewRequestToReviewMapper;
import com.example.toiletapps.map.review.model.Review;
import com.example.toiletapps.map.review.model.req.ReviewRequest;
import com.example.toiletapps.security.api.model.CurrentUserApiModel;
import com.example.toiletapps.security.api.service.IdentityApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class ReviewRequestToReviewMapperImpl implements ReviewRequestToReviewMapper {
    private final IdentityApiService identityApiService;
    private final MarkerApiService markerApiService;
    @Override
    public Review map(ReviewRequest source) {
        CurrentUserApiModel currUserAccount = identityApiService.currentUserAccount()
                .orElseThrow(
                        () -> new RuntimeException(
                                String.format("Your session expired or you are not loh in")
                        )
                );
        Marker marker = markerApiService.findMarkerByApi(source.markerId());
        Review review = new Review();
        review.setReview(source.review());
        review.setUsername(identityApiService.currentUserAccountUsername(currUserAccount.currenUserId()));
        review.setCreatedTimestamp(Instant.now());
        review.setRating(source.rating());
        review.setMarker(marker);
        return review;
    }
}
