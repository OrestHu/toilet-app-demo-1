package com.example.toiletapps.map.marker.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@Entity
@ToString
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
    private LocalDateTime createdTimestampString;

    @Column(name = "visibility", nullable = false)
    private boolean visibility;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            schema = "toilet",
            name = "marker_tags",
            joinColumns = {@JoinColumn(name = "marker_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id", referencedColumnName = "id")}
    )
    private Collection<Tags> tags;
}