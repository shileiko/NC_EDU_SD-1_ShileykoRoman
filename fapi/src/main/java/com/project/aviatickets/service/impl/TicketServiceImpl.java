package com.project.aviatickets.service.impl;

import com.project.aviatickets.models.Ticket;
import com.project.aviatickets.service.TicketService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public Ticket save(Ticket ticket) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/v1/ticketsba/", ticket, Ticket.class).getBody();
    }

    @Override
    public List<Ticket> getTicketsByFlightId(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        Ticket[] ticketResponse = restTemplate.getForObject(backendServerUrl + "/api/v1/ticketsba/flight/" + id, Ticket[].class);
        return ticketResponse == null ? Collections.emptyList() : Arrays.asList(ticketResponse);
    }

    @Override
    public List<Ticket> getTicketsByUserUsername(String username) {
        RestTemplate restTemplate = new RestTemplate();
        Ticket[] ticketResponse = restTemplate.getForObject(backendServerUrl + "/api/v1/ticketsba/user/" + username, Ticket[].class);
        return ticketResponse == null ? Collections.emptyList() : Arrays.asList(ticketResponse);
    }
}
