package com.oguzhan.demoticket.repository;

import com.oguzhan.demoticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    public Optional<Ticket> findByPnr(String pnr);

}
