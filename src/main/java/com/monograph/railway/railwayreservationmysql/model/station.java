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
public class station {

    @Id
    private long id;
    private String name;
    private long address;
}
