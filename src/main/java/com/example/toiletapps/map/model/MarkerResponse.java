package com.example.toiletapps.map.model;

import java.util.Collection;
import java.util.List;

public record MarkerResponse(String name,
                             String coordinates,
                             boolean visibility,
                             Collection<Tags> tags) {
}
