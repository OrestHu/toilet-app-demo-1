package com.example.toiletapps.map.marker.model.req;

import jakarta.validation.constraints.*;

import java.util.List;

public record MarkerRequest(
        @NotBlank(message = "Name must be not blank")
        @Size(min = 5, message = "Name must have at least {min} characters")
        @Size(max = 25, message = "Name must have at most {max} characters")
        String name,
        @NotBlank(message = "Coordinates must be not blank") String coordinates,
        @NotEmpty(message = "Tags list must not be empty")
        List<String> tags
        ) {
}
