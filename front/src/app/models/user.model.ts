import {Ticket} from './ticket.model';

export class User {
  id: string;
  username: string;
  firstname: string;
  surname: string;
  email: string;
  password: string;
  role: string;
  tickets: Ticket[];

  constructor() {
  }
}
