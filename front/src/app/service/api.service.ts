import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs/index';
import {ApiResponse} from '../models/api.response';
import {catchError} from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class ApiService {

  baseUrl: string;
  private userUrl = '/api/v1/users';
  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/';
  }

  login(loginPayload): Observable<ApiResponse> {
    return this.http.post<ApiResponse>('http://localhost:8080/' + 'token/generate-token', loginPayload).pipe(
      catchError(val => of(val)));
  }

}
