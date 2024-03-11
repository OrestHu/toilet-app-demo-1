package com.example.toiletapps.map.model.req;

import com.example.toiletapps.map.model.Tags;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record MarkerRequest(
        String name,
        String coordinates,
        List<String> tags
        ) {
}
