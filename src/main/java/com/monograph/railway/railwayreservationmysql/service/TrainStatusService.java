package com.monograph.railway.railwayreservationmysql.service;

import com.monograph.railway.railwayreservationmysql.model.TrainStatus;
import com.monograph.railway.railwayreservationmysql.repository.TrainStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TrainStatusService {
    TrainStatus saveTrainStatus(TrainStatus trainStatus);
    TrainStatus getTrainStatusByTrainId(Long trainId);
    List<TrainStatus> getAllTrainStatuses();
    void deleteTrainStatus(Long trainId);
}

