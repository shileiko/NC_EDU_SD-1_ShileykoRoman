import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {User} from "../models/user.model";

const TOKEN_KEY = 'AuthToken';
@Injectable()
export class MainPageService {
  private token: string;

  constructor(private http: HttpClient) {

  }

  getUsername(): Observable<any> {
    return this.http.get<User>('api/v1/users/username', {headers:{'Authorization': localStorage.getItem(TOKEN_KEY)}});
  }

}
