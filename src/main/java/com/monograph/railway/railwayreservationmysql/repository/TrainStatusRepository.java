package com.monograph.railway.railwayreservationmysql.repository;

import com.monograph.railway.railwayreservationmysql.model.TrainStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainStatusRepository extends JpaRepository<TrainStatus,Long> {
//    @Query(value = "SELECT t.train_id, t.train_name, ts.st_available_seat, ts.st_booked_seat, ts.st_departure_time, r.r_source, r.r_destination " +
//            "FROM trains t " +
//            "JOIN train_status ts ON t.train_id = ts.train_id " +
//            "JOIN routes r ON ts.route_id = r.r_id", nativeQuery = true)
//    List<Object[]> getTrainDetails();
    boolean existsByTrainId(Long id);
}
