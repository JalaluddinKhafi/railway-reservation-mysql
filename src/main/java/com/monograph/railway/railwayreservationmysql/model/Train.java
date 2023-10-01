package com.monograph.railway.railwayreservationmysql.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "trains")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_id")
    private Long id;

    @Column(name = "train_name",nullable = false)
    private String name;

    @Column(name = "train_total_seats", nullable = false)
    private Integer totalSeats;

    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy = "train")
    private TrainStatus trainStatus;


    // Getters and setters
}


