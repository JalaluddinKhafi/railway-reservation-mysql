package com.monograph.railway.railwayreservationmysql.service;

import com.monograph.railway.railwayreservationmysql.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PassengerService {

    Passenger savePassenger(Passenger passenger);
    Passenger getPassengerById(Long id);
    List<Passenger> getAllPassengers();
    void deletePassenger(Long id);
    public double getTotalPricesOfAllPassengers();
    public int getTotalPassengerCount();



}
