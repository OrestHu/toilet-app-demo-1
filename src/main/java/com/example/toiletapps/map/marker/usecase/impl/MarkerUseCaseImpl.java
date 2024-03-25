package com.example.toiletapps.map.marker.usecase.impl;

import com.example.toiletapps.map.marker.exceptions.MarkerExistsException;
import com.example.toiletapps.map.marker.mapper.MarkerRequestToMarkerMapper;
import com.example.toiletapps.map.marker.mapper.MarkerToMarkerResponseMapper;
import com.example.toiletapps.map.marker.service.impl.MarkerServiceImpl;
import com.example.toiletapps.map.marker.usecase.MarkerUseCase;
import com.example.toiletapps.map.marker.model.Marker;
import com.example.toiletapps.map.marker.model.MarkerResponse;
import com.example.toiletapps.map.marker.model.req.MarkerRequest;
import com.example.toiletapps.map.marker.repository.MarkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MarkerUseCaseImpl implements MarkerUseCase {
    private final MarkerRequestToMarkerMapper markerRequestToMarkerMapper;
    private final MarkerToMarkerResponseMapper markerToMarkerResponseMapper;
    private final MarkerServiceImpl markerService;
    private final MarkerRepository markerRepository;
    @Override
    public void addMarker(MarkerRequest request) {
        Marker marker = markerRequestToMarkerMapper.map(request);
        if(markerRepository.existsByName(marker.getName())){
            throw new MarkerExistsException(
                    String.format("A marker with the name %s already exists.", marker.getName()),
                    HttpStatus.CONFLICT
            );
        }
        markerService.addMarker(marker);
    }

    @Override
    public List<MarkerResponse> getAllMarkerWhereVisibilityTrue() {
        List<Marker> markers = markerService.getAllMarkersWithVisibilityTrue();
        return markers
                .stream()
                .map(markerToMarkerResponseMapper::map)
                .toList();
    }

    @Override
    public List<Marker> getAllMarkerWhereVisibilityFalse() {
        return markerService.getAllMarkersWithVisibilityFalse();
    }

    @Override
    public MarkerResponse findByName(String name) {
        Marker marker = markerRepository
                .findByName(name)
                .orElseThrow(() ->
                        new RuntimeException(
                                String.format("Marker with name '%s' not found", name)
                        )
                );
        return markerToMarkerResponseMapper.map(marker);
    }

    @Override
    public void deleteMarker(Integer id) {
        markerService.deleteMarker(id);
    }
}
