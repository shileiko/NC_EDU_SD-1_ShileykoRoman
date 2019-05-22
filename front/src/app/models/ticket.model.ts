import {Flight} from './flight.model';
import {User} from './user.model';

export class Ticket {
  id: string;
  flight: Flight;
  user: User;
  typeOfSeat: string;
  price: number;
  luggage: boolean;
  constructor() {
  }
}
