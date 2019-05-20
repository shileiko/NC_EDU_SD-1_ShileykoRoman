import {Component, OnInit} from '@angular/core';
import {Flight} from '../../models/flight.model';
import {FlightService} from '../../service/flight.service';
import {Router} from '@angular/router';
import {Ticket} from '../../models/ticket.model';
import {TicketService} from '../../service/ticket.service';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit{
  ticket: Ticket = new Ticket();
  flight: Flight;
  constructor(private router: Router, private flightService: FlightService, private ticketService: TicketService) { }

  ngOnInit() {
    this.ticket.flight = new Flight();
  }

  createFlight(): void {
    this.flightService.createFlight(this.flight)
      .subscribe( data => {
        alert('Flight created successfully.');
      });
    // this.router.navigate(['flights']);
  }

  addTicket(): void {
    this.ticketService.addTicket(this.ticket).subscribe();
  }
}
