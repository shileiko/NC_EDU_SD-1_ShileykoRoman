import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {LoginUser} from '../models/loginUser.model';
import {Router} from '@angular/router';


@Injectable()
export class LogUserService {
  private _user: LoginUser = new LoginUser();
  private token: string;


  constructor(private http: HttpClient, private router: Router) { }

  getToken(user: LoginUser) {
    let param = JSON.stringify(user);
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post('/api/token/generate-token', param, {headers});
  }


}
