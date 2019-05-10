import { Component, OnInit } from '@angular/core';
import {Flight} from '../../models/flight.model';
import {Router} from '@angular/router';
import {FlightService} from '../../service/flight.service';
import {SearchFlight} from '../../models/searchFlight.model';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {
  flights: Flight[];
  searchFlight: SearchFlight;
  constructor(private router: Router, private flightService: FlightService) { }

  ngOnInit() {
  }

  searchFlightDB(departureTimeSearch, fromPlaceSearch, toPlaceSearch) {
    this.flightService.filterFlight(departureTimeSearch, fromPlaceSearch, toPlaceSearch)
      .subscribe( data => {
        this.flights = data as Flight[];
      });
  }
}
