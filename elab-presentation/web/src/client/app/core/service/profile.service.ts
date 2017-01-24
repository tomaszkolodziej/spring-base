import { Injectable } from '@angular/core';
import { Response } from '@angular/http';

import { HttpClient } from './http-client.service';

import { Profile } from '../model/profile';

@Injectable()
export class ProfileService {

  constructor(private httpClient: HttpClient) {

  }

  getProfileByLogin(login: string) {
    console.log("ProfileService.getProfileByLogin " + login + " method called");
    return this.httpClient.get("/profile/login/" + login)
      .map((response: Response) => {
        return response.json();
      })
      .map((profile: any) => {
        return new Profile(profile);
      });
  }

}
