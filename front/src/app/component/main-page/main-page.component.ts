import { Component, OnInit } from '@angular/core';
import {Flight} from '../../models/flight.model';
import {Router} from '@angular/router';
import {FlightService} from '../../service/flight.service';
import {TicketService} from '../../service/ticket.service';
import {Ticket} from '../../models/ticket.model';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {
  flights: Flight[];
  tickets: Ticket[];
  constructor(private router: Router, private flightService: FlightService, private ticketService: TicketService) { }

  ngOnInit() {
  }

  searchFlightDB(departureTimeSearch, fromPlaceSearch, toPlaceSearch) {
    this.flightService.filterFlight(departureTimeSearch, fromPlaceSearch, toPlaceSearch)
      .subscribe( data => {
        this.flights = data as Flight[];
      });
  }

  findTicketsByFlightId(flight: Flight) {
    this.ticketService.findTicketsByFlightId(flight)
      .subscribe( data => {
        this.tickets = data as Ticket[];
      });
  }

  buyTicket(ticket: Ticket) {
    this.ticketService.buyTicket(ticket).subscribe( data => {
      alert('You successfully booked ticket');
    });
  }
}
