package com.monograph.railway.railwayreservationmysql.ServiceImpl;

import com.monograph.railway.railwayreservationmysql.model.TrainStatus;
import com.monograph.railway.railwayreservationmysql.repository.TrainStatusRepository;
import com.monograph.railway.railwayreservationmysql.service.TrainStatusService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainStatusServiceImpl implements TrainStatusService {
    private final TrainStatusRepository trainStatusRepository;

    public TrainStatusServiceImpl(TrainStatusRepository trainStatusRepository) {
        this.trainStatusRepository = trainStatusRepository;
    }

    @Override
    public void saveTrainStatus(TrainStatus trainStatus) {
        trainStatusRepository.save(trainStatus);
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
    @Transactional
    public void deleteTrainStatus(Long trainId) {
        try {
            trainStatusRepository.deleteById(trainId);
            System.out.println("Train Status deleted by ID: "+trainId);
        } catch (Exception e) {
            System.out.println("Error deleting Train Status with ID: {} " +trainId+" "+ e);
            // Handle the exception as needed.
        }
    }

//    @Override
//    public List<Object[]> getTrainDetails() {
//        return trainStatusRepository.getTrainDetails();
//    }
}

