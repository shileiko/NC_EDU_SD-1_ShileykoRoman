package com.project.aviatickets.service;

import com.project.aviatickets.model.Flight;
import com.project.aviatickets.model.Ticket;

import java.util.List;

public interface TicketService {
    public Ticket getById(Integer id);

    public void save(Ticket ticket);

    public void delete(Integer id);

    public List<Ticket> getAll();
}
