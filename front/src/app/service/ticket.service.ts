import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Ticket} from '../models/ticket.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class TicketService {

  constructor(private http: HttpClient) {}

  private ticketUrl = '/api/v1/ticket';

  public addTicket(ticket) {
    return this.http.post<Ticket>(this.ticketUrl, ticket);
  }
}
