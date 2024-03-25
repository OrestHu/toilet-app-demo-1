package com.example.toiletapps.map.marker.controller;

import com.example.toiletapps.map.marker.model.Marker;
import com.example.toiletapps.map.marker.model.MarkerResponse;
import com.example.toiletapps.map.marker.model.Tags;
import com.example.toiletapps.map.marker.model.req.MarkerRequest;
import com.example.toiletapps.map.marker.usecase.MarkerUseCase;
import com.example.toiletapps.map.marker.usecase.TagsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/markers")
@RequiredArgsConstructor
public class MarkerController {
    private final MarkerUseCase markerUseCase;
    private final TagsUseCase tagsUseCase;

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

    @GetMapping("/tags")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Tags> findTags(){
        return tagsUseCase.findTags();
    }

    @DeleteMapping("/deleteMarker/{marker_id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteMarker(@PathVariable("marker_id") Integer marker_id){
        markerUseCase.deleteMarker(marker_id);
    }
}