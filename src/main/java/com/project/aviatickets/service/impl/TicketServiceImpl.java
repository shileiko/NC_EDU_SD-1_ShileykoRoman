package com.project.aviatickets.service.impl;

import com.project.aviatickets.model.Ticket;
import com.project.aviatickets.repository.TicketRepository;
import com.project.aviatickets.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket getById(Integer id) {
        return ticketRepository.findTicketById(id);
    }

    @Override
    public void save(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public void delete(Integer id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }
}
