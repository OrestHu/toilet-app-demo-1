package com.example.toiletapps.map.controller;

import com.example.toiletapps.map.model.Marker;
import com.example.toiletapps.map.model.req.MarkerRequest;
import com.example.toiletapps.map.usecase.MarkerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/markers")
@RequiredArgsConstructor
public class MarkerController {
    private final MarkerUseCase markerUseCase;

    @PostMapping("/create")
    public void addMarker(@RequestBody MarkerRequest request) {
        markerUseCase.addMarker(request);
    }

    @GetMapping("/findAll")
    public List<Marker> getAllMarkerWhereVisibilityTrue(){
        return markerUseCase.getAllMarkerWhereVisibilityTrue();
    }

    @GetMapping("/findAllEqualsFalse")
    public List<Marker> getAllMarkerWhereVisibilityFalse(){
        return markerUseCase.getAllMarkerWhereVisibilityFalse();
    }
}