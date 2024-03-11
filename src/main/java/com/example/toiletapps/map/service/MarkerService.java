package com.example.toiletapps.map.service;

import com.example.toiletapps.map.model.Marker;

import java.util.List;

public interface MarkerService {
    void addMarker(Marker marker);
    List<Marker> getAllMarkersWithVisibilityTrue();
    List<Marker> getAllMarkersWithVisibilityFalse();
}
