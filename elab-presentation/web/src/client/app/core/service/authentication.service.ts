import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import '../../operators';
import { Http, Headers, Response } from '@angular/http';

@Injectable()
export class AuthenticationService {

  public token: string;

  constructor(private http: Http) {
    var currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.token = currentUser && currentUser.token;
  }

  login(username: string, password: string): Observable<boolean> {
    var user = { username: username, password: password };

    var headers = new Headers();
    headers.append("Content-Type", "application/json");

    return this.http.post('http://localhost:8090/elab/api/auth', JSON.stringify(user), { headers: headers })
      .map((response: Response) => {
        let responseData = response.json();

        if (responseData) {
          this.token = responseData.token;
          localStorage.setItem('currentUser', JSON.stringify({ username: responseData.username, token: this.token }));
          return true;
        } else {
          return false;
        }
      });
  }

  isLoggedIn(): boolean {
    let currentUser = localStorage.getItem('currentUser');
    return currentUser && currentUser != null;
  }

  getUser() {
    if (this.isLoggedIn()) {
      return JSON.parse(localStorage.getItem("currentUser"));
    }
    return { };
  }

  logout(): void {
    this.token = null;
    localStorage.removeItem('currentUser');
  }

}
