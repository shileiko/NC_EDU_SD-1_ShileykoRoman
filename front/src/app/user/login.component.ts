import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ApiService} from '../service/api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  invalidLogin: boolean;
  constructor(private formBuilder: FormBuilder, private router: Router, private apiService: ApiService) {
    this.invalidLogin = false;
  }

  onSubmit() {
    if (this.loginForm.invalid) {
      return;
    }
    const loginPayload = {
      email: this.loginForm.controls.email.value,
      pass: this.loginForm.controls.pass.value
    };
    this.apiService.login(loginPayload).subscribe(data => {
      if (data.status === 200) {
        window.localStorage.setItem('token', data.result.token);
        this.router.navigate(['users']);
      } else {
        this.invalidLogin = true;
        alert(data.message);
      }
    });
  }

  ngOnInit() {
    window.localStorage.removeItem('token');
    this.loginForm = this.formBuilder.group({
      email: ['', Validators.compose([Validators.required])],
      pass: ['', Validators.required]
    });
  }

}
