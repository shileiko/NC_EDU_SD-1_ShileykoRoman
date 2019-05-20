import DateTimeFormat = Intl.DateTimeFormat;
import {Ticket} from './ticket.model';

export class Flight {
  id: string;
  fromPlace: string;
  toPlace: string;
  departureTime: DateTimeFormat;
  arrivalTime: DateTimeFormat;
  transfers: boolean;
  aviacompany: string;
  ticketskol: number;
  tickets: Ticket[];
  constructor() {
  }
}
