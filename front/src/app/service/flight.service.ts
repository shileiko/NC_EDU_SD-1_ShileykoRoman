import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import {Flight} from '../models/flight.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class FlightService {

  constructor(private http: HttpClient) {}

  private flightUrl = '/api/v1/flights';

  public getFlights() {
    return this.http.get<Flight[]>(this.flightUrl);
  }

  public deleteFlight(flight) {
    return this.http.delete(this.flightUrl + '/' + flight.id);
  }

  public createFlight(flight) {
    return this.http.post<Flight>(this.flightUrl, flight);
  }

  /*public createTicketFlight(ticket) {
    return this.http.post<Ticket>(this.)
  }*/

  public filterFlight(departureTimeSearch, fromPlaceSearch, toPlaceSearch) {
    return this.http.get<Flight[]>(this.flightUrl + '/filter/' + departureTimeSearch +  'T00:00:00.000+0000/' + departureTimeSearch +  'T23:59:59.000+0000/' + fromPlaceSearch + '/' + toPlaceSearch);
  }
}
