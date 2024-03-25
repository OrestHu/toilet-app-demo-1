package com.example.toiletapps.map.marker.service;

import com.example.toiletapps.map.marker.model.Marker;

import java.util.List;
import java.util.Optional;

public interface MarkerService {
    void addMarker(Marker marker);
    List<Marker> getAllMarkersWithVisibilityTrue();
    List<Marker> getAllMarkersWithVisibilityFalse();
    Optional<Marker> getMarkerById(Integer id);
    void deleteMarker(Integer id);
}
