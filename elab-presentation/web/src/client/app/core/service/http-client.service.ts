import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import {AuthenticationService} from './authentication.service';

@Injectable()
export class HttpClient {

  constructor(private http: Http,
              private authService: AuthenticationService) {

  }

  get(url: string, data?: any) {
    return this.http.get(this.getFullUrl(url), data);
  }

  post(url: string, data?: any) {
    //var headers = new Headers();
    //headers.append("Content-Type", "application/json");
    //headers.append("X-Auth-Token", this.getUserToken());

    //if (data) {
    //  return this.http.post(this.getFullUrl(url), JSON.stringify(data), { headers: headers });
    //} else {
    //  return this.http.post(this.getFullUrl(url), JSON.stringify({}), { headers: headers });
    //}
  }

  private getFullUrl(url: string): string {
    return 'http://localhost:8090/elab/api' + url;
  }

  private getUserToken(): string {
    return this.authService.getUser().token;
  }

}
