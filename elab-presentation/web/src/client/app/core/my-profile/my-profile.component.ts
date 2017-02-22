import { Component } from '@angular/core';

import { ProfileService } from '../service/profile.service';
import { AuthenticationService } from '../service/authentication.service';
import { MsgService } from '../service/msg.service';

import { Profile } from '../model/profile';
import { Error } from '../model/error';

@Component({
  moduleId: module.id,
  selector: 'my-profile',
  templateUrl: 'my-profile.component.html',
  styleUrls: ['my-profile.component.css']
})
export class MyProfileComponent {

  loading: boolean = false;

  profile: Profile = null;

  constructor(private profileService: ProfileService,
              private authService: AuthenticationService,
              private msgService: MsgService) {
    this.loadProfile();
    this.loadSettings();
  }

  loadProfile() {
    console.log("Loading profile...");
    this.profileService.getProfileByLogin(this.getUserLogin()).subscribe(
      (data: any) => {
        this.loading = true;
        this.profile = data;
      },
      (err: any) => {
        this.msgService.error(new Error(err));
      },
      () => {
        console.log("Pobrano profil");
        console.dir(this.profile);
        this.loading = false;
      }
    );
  }

  loadSettings() {
    console.log("Loading settings...");

  }

  saveProfile() {
    this.loading = true;

  }

  saveSettings() {
    this.loading = true;

  }

  restoreDefaultSettings() {
    this.loading = true;

  }

  savePassword() {
    this.loading = true;

  }

  private getUserLogin(): string {
    return this.authService.getUser().username;
  }

}
