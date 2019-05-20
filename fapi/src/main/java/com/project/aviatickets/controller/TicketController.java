package com.project.aviatickets.controller;

import com.project.aviatickets.models.Ticket;
import com.project.aviatickets.models.User;
import com.project.aviatickets.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping("/buyticket/{ticket}")
    public String buyTicket(@AuthenticationPrincipal User user,
                            @PathVariable Ticket ticket){
        ticketService.buyTicket(user, ticket);
        return "ok";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Ticket> saveTicket(@RequestBody @Valid Ticket ticket){
        this.ticketService.save(ticket);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }
}
