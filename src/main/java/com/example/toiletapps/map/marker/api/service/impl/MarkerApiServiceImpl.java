package com.example.toiletapps.map.marker.api.service.impl;

import com.example.toiletapps.map.marker.api.service.MarkerApiService;
import com.example.toiletapps.map.marker.model.Marker;
import com.example.toiletapps.map.marker.service.MarkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MarkerApiServiceImpl implements MarkerApiService {
    private final MarkerService markerService;
    @Override
    public Marker findMarkerByApi(Integer id) {
        return markerService.getMarkerById(id)
                .orElseThrow(() ->
                        new RuntimeException(String.format("Marker not fount by this id %s", id))
                );
    }
}
