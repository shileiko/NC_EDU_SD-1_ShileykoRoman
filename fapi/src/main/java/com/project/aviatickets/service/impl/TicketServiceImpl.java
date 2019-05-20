package com.project.aviatickets.service.impl;

import com.project.aviatickets.models.Flight;
import com.project.aviatickets.models.Ticket;
import com.project.aviatickets.models.User;
import com.project.aviatickets.service.TicketService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TicketServiceImpl implements TicketService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public void buyTicket(User user, Ticket ticket) {
    }

    @Override
    public Ticket save(Ticket ticket) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/v1/ticketsba/", ticket, Ticket.class).getBody();
    }
}
