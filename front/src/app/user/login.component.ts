import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {LoginUser} from '../models/loginUser.model';
import {LogUserService} from '../service/log-user.service';
import {Router} from '@angular/router';
import {TokenStorage} from '../config/token-provider';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @Output() isAuthorized = new EventEmitter<boolean>();
  user: LoginUser;
  err: boolean = false;

  constructor(private service: LogUserService, private tokens: TokenStorage, private router: Router) { }

  ngOnInit() {
    this.user = new LoginUser();
  }


  autorUser() {
    this.service.getToken(this.user).subscribe(
      data => {
        this.tokens.saveToken(data);
        this.isAuthorized.emit(true);
        alert('User logined successfully.');
      },
      error =>  {
        this.err = true;
      }
    );
  }

}
