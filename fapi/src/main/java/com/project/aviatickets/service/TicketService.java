package com.project.aviatickets.service;

import com.project.aviatickets.models.Ticket;

import java.util.List;

public interface TicketService {
    Ticket save(Ticket ticket);
    Ticket buyTicket(Ticket ticket);
    List<Ticket> getTicketsByFlightId(Integer id);
    List<Ticket> getTicketsByUserUsername(String username);
}
