import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from '../models/user.model';

const TOKEN_KEY = 'AuthToken';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {

  constructor(private http: HttpClient) {}

  private userUrl = '/api/v1/users';

  public getUsers() {
    return this.http.get<User[]>(this.userUrl, {headers: {'Authorization': 'Bearer' + localStorage.getItem(TOKEN_KEY), 'Content-Type': 'application/json'}});
  }

  public deleteUser(user) {
    return this.http.delete(this.userUrl + '/' + user.id, {headers: {'Authorization': 'Bearer' + localStorage.getItem(TOKEN_KEY), 'Content-Type': 'application/json'}});
  }

  public createUser(user) {
    return this.http.post<User>(this.userUrl, user);
  }

}
