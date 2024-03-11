package com.example.toiletapps.map.usecase.impl;

import com.example.toiletapps.map.mapper.MarkerRequestToMarkerMapper;
import com.example.toiletapps.map.model.Marker;
import com.example.toiletapps.map.model.req.MarkerRequest;
import com.example.toiletapps.map.repository.MarkerRepository;
import com.example.toiletapps.map.service.impl.MarkerServiceImpl;
import com.example.toiletapps.map.usecase.MarkerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class markerUseCaseImpl implements MarkerUseCase {
    private final MarkerRequestToMarkerMapper markerRequestToMarkerMapper;
    private final MarkerServiceImpl markerService;
    private final MarkerRepository markerRepository;
    @Override
    public void addMarker(MarkerRequest request) {
        Marker marker = markerRequestToMarkerMapper.map(request);
        if(markerRepository.existsByName(marker.getName())){
            throw new RuntimeException(
                    String.format("Marker already exist with this name %s", marker.getName())
            );
        }
        markerService.addMarker(marker);
    }

    @Override
    public List<Marker> getAllMarkerWhereVisibilityTrue() {
        return markerService.getAllMarkersWithVisibilityTrue();
    }

    @Override
    public List<Marker> getAllMarkerWhereVisibilityFalse() {
        return markerService.getAllMarkersWithVisibilityFalse();
    }
}
