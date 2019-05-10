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

  public filterFlight(departureTimeSearch, fromPlaceSearch, toPlaceSearch) {
    return this.http.get<Flight[]>(this.flightUrl + '/filter/' + departureTimeSearch + '/' + fromPlaceSearch + '/' + toPlaceSearch);
  }
}
