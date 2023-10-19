package com.monograph.railway.railwayreservationmysql.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "passengers")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Long id;

    @Column(name = "p_Fname",nullable = false)
    private String firstName;

    @Column(name = "p_Lname")
    private String lastName;

    @Column(name = "p_email",nullable = false)
    private String email;

    @Column(name = "p_phone",nullable = false)
    private String phone;

    @Column(name = "p_gender")
    private String gender;
    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "passenger")
    private List<Ticket> tickets;

    // Getters and setters
}


