package com.monograph.railway.railwayreservationmysql.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private Long id;

    @Column(name = "r_source",nullable = false)
    private String source;

    @Column(name = "r_destination",nullable = false)
    private String destination;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "route")
    private List<TrainStatus> trainStatuse;

    // Getters and setters
}
