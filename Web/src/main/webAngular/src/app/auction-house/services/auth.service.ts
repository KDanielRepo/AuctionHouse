import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const AUTH_API = '/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }

  login(login: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'login', {
      login,
      password
    }, httpOptions);
  }

  register(login: string, email: string, password: string, phone_number: number): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      login,
      email,
      password,
      phone_number
    }, httpOptions);
  }
}
