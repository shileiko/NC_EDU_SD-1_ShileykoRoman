package com.project.aviatickets.controller;

import com.project.aviatickets.model.Ticket;
import com.project.aviatickets.model.User;
import com.project.aviatickets.service.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ticketsba/")
public class TicketController {
    @Autowired
    private TicketServiceImpl ticketService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Ticket> getTicket(@PathVariable("id") Integer ticketId){
        Ticket ticket = this.ticketService.getById(ticketId);

        if (ticket == null){
            return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
    }

    @RequestMapping(value = "flight/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Ticket>> getTicketsByFlightId(@PathVariable("id") Integer flightId){
        List<Ticket> tickets = this.ticketService.findTicketsByFlightId(flightId);

        if (tickets.isEmpty()){
            return new ResponseEntity<List<Ticket>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Ticket> deleteTicket(@PathVariable("id") Integer ticketId){
        Ticket ticket = this.ticketService.getById(ticketId);

        if (ticket == null) {
            return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);
        }

        this.ticketService.delete(ticketId);
        return new ResponseEntity<Ticket>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Ticket> saveTicket(@RequestBody @Valid Ticket ticket){
        this.ticketService.save(ticket);
        return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Ticket>> getAllTickets(){
        List<Ticket> ticket = this.ticketService.getAll();

        if (ticket.isEmpty()){
            return new ResponseEntity<List<Ticket>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Ticket>>(ticket, HttpStatus.OK);
    }

    @PostMapping("buyticket")
    public ResponseEntity<String> buyTicket(@RequestBody Ticket ticket){
        return ResponseEntity.ok(ticketService.buyTicket(ticket));
    }

    @RequestMapping(value = "user/{username}", method = RequestMethod.GET)
    public ResponseEntity<List<Ticket>> getTicketsByUserUsername(@PathVariable("username") String username){
        List<Ticket> tickets = this.ticketService.findTicketsByUserUsername(username);

        if (tickets.isEmpty()){
            return new ResponseEntity<List<Ticket>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
    }
}
