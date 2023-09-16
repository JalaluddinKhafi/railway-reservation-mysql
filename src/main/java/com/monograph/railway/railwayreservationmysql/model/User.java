package com.monograph.railway.railwayreservationmysql.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private Long id;

    @Column(name = "u_Fname")
    private String firstName;

    @Column(name = "u_Lname")
    private String lastName;

    @Column(name = "u_email")
    private String email;

    @Column(name = "u_username")
    private String username;

    @Column(name = "u_password")
    private String password;

    @Column(name = "u_picture")
    @Lob
    private byte[] image;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "user")
    private List<Ticket> tickets;

    // Getters and setters
}
