package com.example.toiletapps.map.marker.mapper.impl;

import com.example.toiletapps.map.marker.mapper.MarkerRequestToMarkerMapper;
import com.example.toiletapps.map.marker.model.Marker;
import com.example.toiletapps.map.marker.model.Tags;
import com.example.toiletapps.map.marker.model.req.MarkerRequest;
import com.example.toiletapps.map.marker.repository.TagsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MarkerRequestToMarkerMapperImpl implements MarkerRequestToMarkerMapper {
    private final TagsRepository tagsRepository;
    @Override
    public Marker map(MarkerRequest source) {
        Marker marker = new Marker();

        marker.setName(source.name());
        marker.setCreatedTimestampString(LocalDateTime.now());
        marker.setCoordinates(source.coordinates());

        List<Tags> tagObjects = new ArrayList<>();
        for (String tagName : source.tags()) {
            Tags tag = tagsRepository.findByName(tagName);
            tagObjects.add(tag);
        }
        if(source.tags().contains("PAID") && source.tags().contains("FREE")){
            throw new RuntimeException("Tags list cannot contain both PAID and FREE at the same time");
        }


        marker.setTags(tagObjects);
        return marker;
    }
}
