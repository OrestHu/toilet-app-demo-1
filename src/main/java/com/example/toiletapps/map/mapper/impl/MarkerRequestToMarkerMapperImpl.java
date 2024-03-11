package com.example.toiletapps.map.mapper.impl;

import com.example.toiletapps.map.mapper.MarkerRequestToMarkerMapper;
import com.example.toiletapps.map.model.Marker;
import com.example.toiletapps.map.model.Tags;
import com.example.toiletapps.map.model.req.MarkerRequest;
import com.example.toiletapps.map.repository.TagsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
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
        marker.setCoordinates(source.coordinates());
        marker.setCreatedTimestamp(Instant.now());

        List<Tags> tagObjects = new ArrayList<>();
        for (String tagName : source.tags()) {
            Tags tag = tagsRepository.findByName(tagName);
            tagObjects.add(tag);
        }

        marker.setTags(tagObjects);
        return marker;
    }
}
