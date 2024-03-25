package com.example.toiletapps.map.marker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(schema = "toilet", name = "markers")
public class Marker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "coordinates", nullable = false)
    private String coordinates;
    @Column(name = "createdTimestamp", nullable = false, updatable = false)
    private Instant createdTimestamp;
    @Column(name = "visibility", nullable = false)
    private boolean visibility;
    @ManyToMany
    @JoinTable(
            schema = "toilet",
            name = "marker_tags",
            joinColumns = {@JoinColumn(name = "marker_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id", referencedColumnName = "id")}
    )
    private Collection<Tags> tags;
}
