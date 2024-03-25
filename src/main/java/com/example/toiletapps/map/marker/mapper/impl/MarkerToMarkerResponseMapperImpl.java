package com.example.toiletapps.map.marker.mapper.impl;

import com.example.toiletapps.map.marker.mapper.MarkerToMarkerResponseMapper;
import com.example.toiletapps.map.marker.model.Marker;
import com.example.toiletapps.map.marker.model.MarkerResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MarkerToMarkerResponseMapperImpl implements MarkerToMarkerResponseMapper {
    @Override
    public MarkerResponse map(@NotNull Marker source) {
        MarkerResponse response = new MarkerResponse(
                source.getId(),
                source.getName(),
                source.getCoordinates(),
                source.isVisibility(),
                source.getTags()
        );
        return response;
    }
}
