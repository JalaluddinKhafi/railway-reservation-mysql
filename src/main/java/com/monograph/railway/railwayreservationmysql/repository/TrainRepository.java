package com.monograph.railway.railwayreservationmysql.repository;

import com.monograph.railway.railwayreservationmysql.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train,Long> {
}
