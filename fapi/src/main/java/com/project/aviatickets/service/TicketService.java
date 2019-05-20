package com.project.aviatickets.service;

import com.project.aviatickets.models.Ticket;
import com.project.aviatickets.models.User;

public interface TicketService {
    void buyTicket(User user, Ticket ticket);
    Ticket save(Ticket ticket);
}
