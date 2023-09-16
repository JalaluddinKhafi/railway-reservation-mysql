package com.monograph.railway.railwayreservationmysql.ServiceImpl;

import com.monograph.railway.railwayreservationmysql.model.Train;
import com.monograph.railway.railwayreservationmysql.repository.TrainRepository;
import com.monograph.railway.railwayreservationmysql.service.TrainService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {
    private final TrainRepository trainRepository;

    public TrainServiceImpl(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    @Override
    public Train saveTrain(Train train) {
        return trainRepository.save(train);
    }

    @Override
    public Train getTrainById(Long id) {
        return trainRepository.findById(id).orElse(null);
    }

    @Override
    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    @Override
    public void deleteTrain(Long id) {
        trainRepository.deleteById(id);
    }
}

