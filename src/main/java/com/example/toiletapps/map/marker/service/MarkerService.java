package com.example.toiletapps.map.marker.service;

import com.example.toiletapps.map.marker.model.Marker;

import java.util.List;

public interface MarkerService {
    void addMarker(Marker marker);
    List<Marker> getAllMarkersWithVisibilityTrue();
    List<Marker> getAllMarkersWithVisibilityFalse();
}
