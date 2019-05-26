import {Component, OnInit} from '@angular/core';
import {MainPageService} from '../../service/main-page.service';
import {Router} from '@angular/router';
import {TokenStorage} from '../../config/token-provider';
import {User} from "../../models/user.model";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  user: User;
  username: any;
  isAuthorized: boolean;

  constructor(private service: MainPageService, private router: Router, private token: TokenStorage) { }

  ngOnInit() {
    this.getUsername();
  }

  onChange(status: any) {
    if (status === true) {
      this.getUsername();
    }
  }

  getUsername() {
    this.service.getUsername().subscribe(username => {
      this.username = username as string;
      if (this.username == null) {
        console.log(this.username.username);
        this.username = '';
        this.isAuthorized = false;
      } else {
        console.log(this.username.username);
        this.isAuthorized = true;
      }
    });
  }

  logOut() {
    this.token.signOut();
    this.isAuthorized = false;
    this.username = null;
    this.router.navigate(['main']);
  }
}

