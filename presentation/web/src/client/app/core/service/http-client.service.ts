import {Injectable} from '@angular/core';
import {Http, Headers } from '@angular/http';
import {SessionService} from './session.service';

@Injectable()
export class HttpClient {

  constructor(private http: Http,
              private sessionService: SessionService) {

  }

  get(url: string, data?: any) {
    return this.http.get(this.getFullUrl(url), data);
  }

  post(url: string, data?: any) {
    //var headers = new Headers();
    //headers.append("Content-Type", "application/json");
    //headers.append("X-Auth-Token", this.sessionService.getProfileToken());

    //if (data) {
    //  return this.http.post(this.getFullUrl(url), JSON.stringify(data), { headers: headers });
    //} else {
    //  return this.http.post(this.getFullUrl(url), JSON.stringify({}), { headers: headers });
    //}
  }

  private getFullUrl(url: string): string {
    return 'http://localhost:8090/elab/api' + url;
  }

}
