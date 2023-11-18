package com.monograph.railway.railwayreservationmysql.ServiceImpl;

import com.monograph.railway.railwayreservationmysql.model.Passenger;
import com.monograph.railway.railwayreservationmysql.model.Ticket;
import com.monograph.railway.railwayreservationmysql.model.Train;
import com.monograph.railway.railwayreservationmysql.model.TrainStatus;
import com.monograph.railway.railwayreservationmysql.repository.TicketRepository;
import com.monograph.railway.railwayreservationmysql.service.PassengerService;
import com.monograph.railway.railwayreservationmysql.service.TicketService;
import com.monograph.railway.railwayreservationmysql.service.TrainStatusService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TrainStatusService trainService;
    private final PassengerService passengerService;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, TrainStatusService trainService, PassengerService passengerService) {
        this.ticketRepository = ticketRepository;
        this.trainService = trainService;
        this.passengerService = passengerService;
    }

    // ... other methods ...

    @Override
    @Transactional
    public void bookTicket(Ticket ticket) {
        TrainStatus trainStatus = ticket.getTrain().getTrainStatus();
        Train train = ticket.getTrain();
        int numberOfSeats = ticket.getPassenger().getNumberOfSeat();

        // Ensure that bookedSeat and availableSeat are not null
        int currentBookedSeats = trainStatus.getBookedSeat() != null ? trainStatus.getBookedSeat() : 0;
        int currentAvailableSeats = trainStatus.getAvailableSeat() != null ? trainStatus.getAvailableSeat() : 0;

        // Check if there are enough available seats
        if (currentAvailableSeats < numberOfSeats) {
            System.out.println("Not enough available seats for booking.");
        }else {

            // Calculate the total price based on the number of seats and price per seat
            double pricePerSeat = train.getPrice() != null ? train.getPrice() : 0.0;
            double totalPrice = numberOfSeats * pricePerSeat;

            // Update booked seats and available seats in TrainStatus
            trainStatus.setBookedSeat(currentBookedSeats + numberOfSeats);
            trainStatus.setAvailableSeat(currentAvailableSeats - numberOfSeats);

            // Save the modified TrainStatus
            trainService.saveTrainStatus(trainStatus);

            // Save passenger information with calculated total price
            Passenger passenger = ticket.getPassenger();
            passenger.setTotalPrice(totalPrice);
            passengerService.savePassenger(passenger);

            // Save the ticket
            ticketRepository.save(ticket);
        }
    }
    @Override
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void cancelTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new RuntimeException("Ticket not found"));

        TrainStatus trainStatus = ticket.getTrain().getTrainStatus();
        int numberOfSeats = ticket.getPassenger().getNumberOfSeat();

        // Update booked seats and available seats in TrainStatus
        trainStatus.setBookedSeat(trainStatus.getBookedSeat() - numberOfSeats);
        trainStatus.setAvailableSeat(trainStatus.getAvailableSeat() + numberOfSeats);

        // Save the modified TrainStatus
        trainService.saveTrainStatus(trainStatus);

        // Remove passenger information
        Passenger passenger = ticket.getPassenger();
        passengerService.deletePassenger(passenger.getId());

        // Delete the ticket
        // You might have a TicketRepository, delete the ticket accordingly
        ticketRepository.delete(ticket);
    }




}
