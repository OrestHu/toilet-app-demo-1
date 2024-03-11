package com.example.toiletapps.map.service.impl;

import com.example.toiletapps.map.model.Marker;
import com.example.toiletapps.map.repository.MarkerRepository;
import com.example.toiletapps.map.service.MarkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarkerServiceImpl implements MarkerService {
    private final MarkerRepository markerRepository;
    @Override
    public void addMarker(Marker marker) {
        markerRepository.save(marker);
    }

    @Override
    public List<Marker> getAllMarkersWithVisibilityTrue() {
        return markerRepository.getAllByVisibilityIsTrue();
    }

    @Override
    public List<Marker> getAllMarkersWithVisibilityFalse() {
        return markerRepository.getAllByVisibilityIsFalse();
    }
}
