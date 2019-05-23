import {Component, OnInit} from '@angular/core';
import {MainPageService} from "../../service/main-page.service";
import {Router} from "@angular/router";
import {TokenStorage} from "../../config/token-provider";
import {User} from "../../models/user.model";
import {Ticket} from "../../models/ticket.model";
import {TicketService} from "../../service/ticket.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: User;
  tickets: Ticket[];

  constructor(private service: MainPageService, private serviceTicket: TicketService, private router: Router, private token: TokenStorage) { }

  ngOnInit() {
    this.getUsername();
  }

  getUsername() {
    this.service.getUsername().subscribe(data => {
      this.user = data;
    });
  }

  findTicketsByUserUsername() {
    this.serviceTicket.findTicketsByUserUsername().subscribe(data => {
      this.tickets = data as Ticket[];
    });
  }
}
