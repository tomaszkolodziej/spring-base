import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import { MsgService } from '../service/msg.service';
import { Error } from '../model/index';

@Component({
  moduleId: module.id,
  selector: 'login',
  templateUrl: 'login.component.html',
  styleUrls: ['login.component.css']
})
export class LoginComponent implements OnInit {

  user: any = {};
  loading: boolean = false;

  constructor(private authService: AuthenticationService,
              private router: Router,
              private msgService: MsgService
  ) { }

  ngOnInit() {
    this.authService.logout();
  }

  login() {
    this.loading = true;

    console.dir(this.user);

    this.authService.login(this.user.username, this.user.password)
      .subscribe(
        data => {
          if (data === true) {
            this.router.navigate(['/dashboard']);
          } else {
            this.loading = false;
            this.msgService.warning("nieprawidłowy login lub hasło");
          }
        },
        err => {
          this.loading = false;
          this.msgService.error(new Error(err));
        },
        () => {
          this.loading = false;
        }
      );
  }

  noAccountYet() {
    this.router.navigate(['/no-account-yet']);
  }

  passwordReminder() {
    this.router.navigate(['/password-reminder']);
  }

}
