import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import '../../operators';
import { Profile } from '../model/profile';
import { HttpClient } from './http-client.service';
import { AuthenticationService } from './authentication.service';

@Injectable()
export class TestService {

  constructor(private http: Http,
              private httpClient: HttpClient,
              private authService: AuthenticationService) {

  }

  test() {
    console.log("TestService.test method called");
    return this.httpClient.get('/test/test')
      .map((response: Response) => {
        return response.json();
      })
      .map((profile: any) => {
        return new Profile(profile);
      });
  }

  testThrowException() {
    console.log("TestService.testThrowException method called");
    return this.http.get("http://localhost:8090/api/test/testThrowException")
      .map((response: Response) => {
        return response.json();
      });
  }

  testSendMail() {
    console.log("TestService.testSendMail method called");
    console.log("TestService.testSendMail user token: " + this.getUserToken());
    var headers = new Headers();
    headers.append("Content-Type", "application/json");
    headers.append("X-Auth-Token", this.getUserToken());
    //return this.http.post("http://localhost:8090/api/test/sendMail", JSON.stringify({}), { headers: headers });
    return this.httpClient.post("/test/sendMail");
  }

  getUserToken() {
    return this.authService.getUser().token;
  }

}
