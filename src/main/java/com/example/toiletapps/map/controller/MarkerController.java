package com.example.toiletapps.map.controller;

import com.example.toiletapps.map.model.Marker;
import com.example.toiletapps.map.model.MarkerResponse;
import com.example.toiletapps.map.model.req.MarkerRequest;
import com.example.toiletapps.map.usecase.MarkerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/markers")
@RequiredArgsConstructor
public class MarkerController {
    private final MarkerUseCase markerUseCase;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMarker(@RequestBody MarkerRequest request) {
        markerUseCase.addMarker(request);
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<MarkerResponse> getAllMarkerWhereVisibilityTrue(){
        return markerUseCase.getAllMarkerWhereVisibilityTrue();
    }

    @GetMapping("/findAllEqualsFalse")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Marker> getAllMarkerWhereVisibilityFalse(){
        return markerUseCase.getAllMarkerWhereVisibilityFalse();
    }

    @GetMapping("/findByName/{marker_name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MarkerResponse findByName(@PathVariable("marker_name") String name){
        return markerUseCase.findByName(name);
    }

}