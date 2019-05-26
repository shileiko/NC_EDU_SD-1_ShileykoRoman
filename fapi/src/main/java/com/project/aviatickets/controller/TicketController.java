package com.project.aviatickets.controller;

import com.project.aviatickets.models.Ticket;
import com.project.aviatickets.models.User;
import com.project.aviatickets.security.TokenProvider;
import com.project.aviatickets.service.TicketService;
import com.project.aviatickets.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @Autowired
    TokenProvider tokenProvider;

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/buyticket")
    public ResponseEntity<Ticket> buyTicket(@RequestBody Ticket ticket,
                            @RequestHeader("Authorization") String token){
        String usernameFromToken = tokenProvider.getUsernameFromToken(token);
        User user = userService.findByUsername(usernameFromToken);
        ticket.setUser(user);
        this.ticketService.buyTicket(ticket);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PostMapping("/cancel")
    public ResponseEntity<Ticket> cancelTicket(@RequestBody Ticket ticket){
        ticket.setUser(null);
        this.ticketService.buyTicket(ticket);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<List<Ticket>> getTicketsByUserUsername(@RequestHeader("Authorization") String token,
                                                                 @PathVariable String username){
        List<Ticket> tickets = this.ticketService.getTicketsByUserUsername(username);
        return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
    }

    @RequestMapping(value = "/flight/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Ticket>> getTicketsByFlightId(@PathVariable Integer id){
        List<Ticket> tickets = this.ticketService.getTicketsByFlightId(id);
        return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Ticket> saveTicket(@RequestBody @Valid Ticket ticket){
        this.ticketService.save(ticket);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }

}
