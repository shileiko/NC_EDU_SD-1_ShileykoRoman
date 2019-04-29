import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Flight} from '../../models/flight.model';
import {FlightService} from '../../service/flight.service';

@Component({
  selector: 'app-flights',
  templateUrl: './flights.component.html',
  styleUrls: ['./flights.component.css']
})
export class FlightsComponent implements OnInit {

  flights: Flight[];

  constructor(private router: Router, private flightService: FlightService) {

  }

  ngOnInit() {
    this.flightService.getFlights()
      .subscribe( data => {
        this.flights = data;
      });
  }

  deleteFlight(flight: Flight): void {
    this.flightService.deleteFlight(flight)
      .subscribe( data => {
        this.flights = this.flights.filter(f => f !== flight);
      });
  }
}
