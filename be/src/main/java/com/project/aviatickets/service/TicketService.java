package com.project.aviatickets.service;

import com.project.aviatickets.model.Ticket;

import java.util.List;

public interface TicketService {
    public Ticket getById(Integer id);

    public void save(Ticket tickets);

    public void delete(Integer id);

    public List<Ticket> getAll();

    List<Ticket> findTicketsByFlightId(Integer id);

    void buyTicket(Ticket ticket);

    List<Ticket> findTicketsByUserUsername(String username);

}
