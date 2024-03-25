package com.example.toiletapps.map.marker.usecase.impl;

import com.example.toiletapps.map.marker.model.Tags;
import com.example.toiletapps.map.marker.repository.TagsRepository;
import com.example.toiletapps.map.marker.usecase.TagsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TagsUseCaseImpl implements TagsUseCase {
    private final  TagsRepository tagsRepository;
    @Override
    public List<Tags> findTags() {
        return tagsRepository.findAll();
    }
}
