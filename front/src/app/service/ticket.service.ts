import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Ticket} from '../models/ticket.model';
import {Observable} from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

const TOKEN_KEY = 'AuthToken';

@Injectable()
export class TicketService {

  constructor(private http: HttpClient) {}

  private ticketUrl = '/api/v1/ticket';

  public addTicket(ticket) {
    return this.http.post<Ticket>(this.ticketUrl, ticket);
  }

  public findTicketsByFlightId(flight) {
    return this.http.get<Ticket[]>(this.ticketUrl + '/flight/' + flight.id, httpOptions);
  }

  public buyTicket(ticket) {
    return this.http.post<Ticket>(this.ticketUrl + '/buyticket', ticket, {headers: {'Authorization': localStorage.getItem(TOKEN_KEY), 'Content-Type': 'application/json'}});
  }

  public findTicketsByUserUsername(username) {
    return this.http.get<Ticket[]>(this.ticketUrl + '/username/' + username, {headers: {'Authorization': localStorage.getItem(TOKEN_KEY), 'Content-Type': 'application/json'}});
  }

  public cancelReservation(ticket) {
    return this.http.post<Ticket>(this.ticketUrl + '/cancel', ticket, {headers: {'Authorization': localStorage.getItem(TOKEN_KEY), 'Content-Type': 'application/json'}});
  }
}
