package com.example.toiletapps.map.mapper.impl;

import com.example.toiletapps.map.mapper.MarkerToMarkerResponseMapper;
import com.example.toiletapps.map.model.Marker;
import com.example.toiletapps.map.model.MarkerResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MarkerToMarkerResponseMapperImpl implements MarkerToMarkerResponseMapper {
    @Override
    public MarkerResponse map(@NotNull Marker source) {
        MarkerResponse response = new MarkerResponse(
                source.getName(),
                source.getCoordinates(),
                source.isVisibility(),
                source.getTags()
        );
        return response;
    }
}
