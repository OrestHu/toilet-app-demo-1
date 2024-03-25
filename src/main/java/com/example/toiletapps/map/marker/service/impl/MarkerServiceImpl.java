package com.example.toiletapps.map.marker.service.impl;

import com.example.toiletapps.map.marker.model.Marker;
import com.example.toiletapps.map.marker.repository.MarkerRepository;
import com.example.toiletapps.map.marker.service.MarkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Marker> getMarkerById(Integer id) {
        return markerRepository.findById(id);
    }

    @Override
    public void deleteMarker(Integer id) {
        markerRepository.deleteById(id);
    }
}
