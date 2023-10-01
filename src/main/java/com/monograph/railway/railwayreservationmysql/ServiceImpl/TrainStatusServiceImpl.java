package com.monograph.railway.railwayreservationmysql.ServiceImpl;

import com.monograph.railway.railwayreservationmysql.model.TrainStatus;
import com.monograph.railway.railwayreservationmysql.repository.TrainStatusRepository;
import com.monograph.railway.railwayreservationmysql.service.TrainStatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainStatusServiceImpl implements TrainStatusService {
    private final TrainStatusRepository trainStatusRepository;

    public TrainStatusServiceImpl(TrainStatusRepository trainStatusRepository) {
        this.trainStatusRepository = trainStatusRepository;
    }

    @Override
    public TrainStatus saveTrainStatus(TrainStatus trainStatus) {
        return trainStatusRepository.save(trainStatus);
    }

    @Override
    public TrainStatus getTrainStatusByTrainId(Long trainId) {
        return trainStatusRepository.findById(trainId).orElse(null);
    }

    @Override
    public List<TrainStatus> getAllTrainStatuses() {
        return trainStatusRepository.findAll();
    }

    @Override
    public void deleteTrainStatus(Long trainId) {
        trainStatusRepository.deleteById(trainId);
    }

    @Override
    public List<Object[]> getTrainDetails() {
        return trainStatusRepository.getTrainDetails();
    }
}

