package com.monograph.railway.railwayreservationmysql.service;

import com.monograph.railway.railwayreservationmysql.model.TrainStatus;
import jakarta.transaction.Transactional;

import java.util.List;


public interface TrainStatusService {
    void saveTrainStatus(TrainStatus trainStatus);
    TrainStatus getTrainStatusByTrainId(Long trainId);
    List<TrainStatus> getAllTrainStatuses();
    @Transactional
    void deleteTrainStatus(Long trainId);
   // public List<Object[]> getTrainDetails();
   boolean existsByTrainId(Long id);

}

