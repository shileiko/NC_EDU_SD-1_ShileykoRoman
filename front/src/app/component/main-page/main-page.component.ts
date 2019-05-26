import { Component, OnInit } from '@angular/core';
import {Flight} from '../../models/flight.model';
import {Router} from '@angular/router';
import {FlightService} from '../../service/flight.service';
import {TicketService} from '../../service/ticket.service';
import {Ticket} from '../../models/ticket.model';
import {MainPageService} from "../../service/main-page.service";
import {User} from "../../models/user.model";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {
  flights: Flight[];
  tickets: Ticket[];
  user: User;

  constructor(private router: Router, private flightService: FlightService, private ticketService: TicketService, private mpService: MainPageService) { }

  ngOnInit() {
  }

  searchFlightDB(departureTimeSearch, fromPlaceSearch, toPlaceSearch) {
    this.flightService.filterFlight(departureTimeSearch, fromPlaceSearch, toPlaceSearch)
      .subscribe( data => {
        this.flights = data as Flight[];
      }, error1 => {
        alert('No flights');
      });
    /*this.mpService.getUsername().subscribe(data => {
      this.user = data;
      this.isAuthorize = true;
    }, error => {
      this.isAuthorize = false;
    });*/
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
    }, error1 => {
      alert('Login or register to buy ticket');
    });
  }
}
