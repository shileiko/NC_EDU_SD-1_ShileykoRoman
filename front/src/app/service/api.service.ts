import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable, of} from 'rxjs/index';
import {ApiResponse} from '../models/api.response';
import {catchError} from 'rxjs/operators';

@Injectable()
export class ApiService {

  baseUrl: string;
  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/';
  }

  login(loginPayload): Observable<ApiResponse> {
    return this.http.post<ApiResponse>('http://localhost:8080/' + 'token/generate-token', loginPayload).pipe(
      catchError(val => of(val)));
  }
}

