import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from '../models/user.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {

  constructor(private http: HttpClient) {}

  private userUrl = '/api/v1/users';

  public getUsers() {
    return this.http.get<User[]>(this.userUrl, httpOptions);
  }

  public deleteUser(user) {
    return this.http.delete(this.userUrl + '/' + user.id, httpOptions);
  }

  public createUser(user) {
    return this.http.post<User>(this.userUrl, user);
  }

}
