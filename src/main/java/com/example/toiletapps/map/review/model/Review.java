package com.example.toiletapps.map.review.model;

import com.example.toiletapps.map.marker.model.Marker;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(schema = "toilet", name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String review;
    @Column(nullable = false)
    private Integer rating;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false, updatable = false)
    private Instant createdTimestamp;
    @ManyToOne
    @JoinColumn(name = "marker_id", referencedColumnName = "id")
    private Marker marker;
}
