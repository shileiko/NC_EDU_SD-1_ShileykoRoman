import {Ticket} from './ticket.model';
import {Role} from "./role.model";

export class User {
  id: string;
  username: string;
  firstname: string;
  surname: string;
  email: string;
  password: string;
  role: Role;
  tickets: Ticket[];

  constructor() {
  }
}
