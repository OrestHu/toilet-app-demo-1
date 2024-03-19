package com.example.toiletapps.map.usecase;

import com.example.toiletapps.map.model.Marker;
import com.example.toiletapps.map.model.MarkerResponse;
import com.example.toiletapps.map.model.req.MarkerRequest;

import java.util.List;

public interface MarkerUseCase {
    void addMarker(MarkerRequest request);
    List<MarkerResponse> getAllMarkerWhereVisibilityTrue();
    List<Marker> getAllMarkerWhereVisibilityFalse();
    MarkerResponse findByName(String name);
}
