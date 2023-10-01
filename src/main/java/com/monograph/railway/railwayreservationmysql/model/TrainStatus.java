package com.monograph.railway.railwayreservationmysql.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "train_status")
public class TrainStatus {
    @Id
    @Column(name = "st_id")
    private Long statusId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "train_id")
    private Train train;

    @Column(name = "st_available_seat")
    private Integer availableSeat;

    @Column(name = "st_booked_seat")
    private Integer bookedSeat;

    @Column(name = "st_departure_time")
    private LocalDateTime departureTime;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;



    // Getters and setters
}
