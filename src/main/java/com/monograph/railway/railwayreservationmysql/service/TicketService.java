package com.monograph.railway.railwayreservationmysql.service;
import com.monograph.railway.railwayreservationmysql.model.Ticket;

import java.util.List;

public interface TicketService {
    Ticket saveTicket(Ticket ticket);
    Ticket getTicketById(Long id);
    List<Ticket> getAllTickets();
    void deleteTicket(Long id);
}
