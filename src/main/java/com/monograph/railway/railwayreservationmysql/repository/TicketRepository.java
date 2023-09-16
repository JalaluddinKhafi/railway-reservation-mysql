package com.monograph.railway.railwayreservationmysql.repository;

import com.monograph.railway.railwayreservationmysql.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
