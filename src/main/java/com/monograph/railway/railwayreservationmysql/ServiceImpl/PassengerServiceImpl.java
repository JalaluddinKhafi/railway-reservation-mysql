package com.monograph.railway.railwayreservationmysql.ServiceImpl;

import com.monograph.railway.railwayreservationmysql.model.Passenger;
import com.monograph.railway.railwayreservationmysql.repository.PassengerRepository;
import com.monograph.railway.railwayreservationmysql.service.PassengerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;

    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}
