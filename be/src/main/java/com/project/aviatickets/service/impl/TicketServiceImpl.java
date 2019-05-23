package com.project.aviatickets.service.impl;

import com.project.aviatickets.model.Ticket;
import com.project.aviatickets.repository.FlightRepository;
import com.project.aviatickets.repository.TicketRepository;
import com.project.aviatickets.repository.UserRepository;
import com.project.aviatickets.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlightRepository flightRepository;

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

    @Override
    public List<Ticket> findTicketsByFlightId(Integer id) {
        return ticketRepository.findTicketsByFlightId(id);
    }

    @Override
    public String buyTicket(Ticket ticket) {
        return "OK";
    }

    @Override
    public List<Ticket> findTicketsByUserUsername(String username) {
        return ticketRepository.findTicketsByUser_Username(username);
    }
}
