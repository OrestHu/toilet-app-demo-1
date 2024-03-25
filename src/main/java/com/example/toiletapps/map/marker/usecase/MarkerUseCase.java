package com.example.toiletapps.map.marker.usecase;

import com.example.toiletapps.map.marker.model.Marker;
import com.example.toiletapps.map.marker.model.MarkerResponse;
import com.example.toiletapps.map.marker.model.req.MarkerRequest;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Validated
public interface MarkerUseCase {
    void addMarker(@Valid MarkerRequest request);
    List<MarkerResponse> getAllMarkerWhereVisibilityTrue();
    List<Marker> getAllMarkerWhereVisibilityFalse();
    MarkerResponse findByName(String name);
    void deleteMarker(Integer id);
}
