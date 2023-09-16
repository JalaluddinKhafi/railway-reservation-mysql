package com.monograph.railway.railwayreservationmysql.ServiceImpl;

import com.monograph.railway.railwayreservationmysql.model.Ticket;
import com.monograph.railway.railwayreservationmysql.repository.TicketRepository;
import com.monograph.railway.railwayreservationmysql.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
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
}
