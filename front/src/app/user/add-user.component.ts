import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../models/user.model';
import { UserService } from '../service/user.service';

@Component({
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent {
  user: User = new User();
  private userError: User;
  private emptyErr: User;
  private isCreated: boolean = false;
  private isExists: boolean = false;
  constructor(private router: Router, private userService: UserService) {
  }

  createUser(): void {
    this.userService.createUser(this.user).subscribe(
      data => {
        console.log(data);
        this.user = new User();
        this.isCreated = true;
        this.isExists = false;
        },
      error => {
        this.userError = error.error['0'].code;
        this.emptyErr = error.error;
        this.isCreated = false;
        this.isExists = true;
        console.log(error.error['0'].code);
      }
      );
    // this.router.navigate(['main']);
  }
}

