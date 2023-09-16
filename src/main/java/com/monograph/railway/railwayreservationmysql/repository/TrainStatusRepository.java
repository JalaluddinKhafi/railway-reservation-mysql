package com.monograph.railway.railwayreservationmysql.repository;

import com.monograph.railway.railwayreservationmysql.model.TrainStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainStatusRepository extends JpaRepository<TrainStatus,Long> {
}
