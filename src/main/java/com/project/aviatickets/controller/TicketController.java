package com.project.aviatickets.controller;

import com.project.aviatickets.model.Ticket;
import com.project.aviatickets.service.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tickets/")
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
}
