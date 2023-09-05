package com.monograph.railway.railwayreservationmysql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ticket {
    @Id
    private long id;
    private String fname;
    private long lname;
    private String email;
}
