package com.monograph.railway.railwayreservationmysql.service;

import com.monograph.railway.railwayreservationmysql.model.Train;


import java.util.List;


public interface TrainService {
        Train saveTrain(Train train);
        Train getTrainById(Long id);
        List<Train> getAllTrains();
        void deleteTrain(Long id);


}
