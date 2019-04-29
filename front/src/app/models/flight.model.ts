import DateTimeFormat = Intl.DateTimeFormat;

export class Flight {
  id: string;
  fromPlace: string;
  toPlace: string;
  departureTime: DateTimeFormat;
  arrivalTime: DateTimeFormat;
  transfers: boolean;
  aviacompany: string;
  constructor() {
  }
}
