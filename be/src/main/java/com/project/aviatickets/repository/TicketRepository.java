package com.project.aviatickets.repository;

import com.project.aviatickets.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Ticket findTicketById(Integer id);
    List<Ticket> findTicketsByFlightId(Integer id);
    List<Ticket> findTicketByUserIsNull();
    List<Ticket> findTicketsByUser_Username(String username);
}
