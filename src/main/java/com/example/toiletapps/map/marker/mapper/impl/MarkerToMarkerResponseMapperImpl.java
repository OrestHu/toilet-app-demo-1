package com.example.toiletapps.map.marker.mapper.impl;

import com.example.toiletapps.map.marker.mapper.MarkerToMarkerResponseMapper;
import com.example.toiletapps.map.marker.model.Marker;
import com.example.toiletapps.map.marker.model.MarkerResponse;
import com.example.toiletapps.map.review.api.service.ReviewApiService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MarkerToMarkerResponseMapperImpl implements MarkerToMarkerResponseMapper {
    private final ReviewApiService reviewApiService;
    @Override
    public MarkerResponse map(@NotNull Marker source) {
        Double averageRating = reviewApiService.reviewAverageRating(source.getId());
        MarkerResponse response = new MarkerResponse(
                source.getId(),
                source.getName(),
                source.getCoordinates(),
                source.isVisibility(),
                averageRating,
                source.getTags()
        );
        return response;
    }
}
