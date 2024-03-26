package com.example.toiletapps.map.marker.model;

import java.util.Collection;

public record MarkerResponse(Integer id,
                             String name,
                             String coordinates,
                             boolean visibility,
                             Double averageRating,
                             Collection<Tags> tags) {
}
