package com.monograph.railway.railwayreservationmysql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User {
    @Id
    private long id;
    private String password;
    private String fname;
    private long lname;
    private String email;
    private String location;
    private String phone;

}
