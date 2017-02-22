import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '../shared/shared.module';
import { IndexComponent } from './index';
import { LoginComponent } from './index';
import { NoAccountYetComponent } from './index';
import { PasswordReminderComponent } from './index';
import { ContactComponent } from './index';
import { AboutUsComponent } from './index';
import { DashboardComponent } from './index';
import { MyProfileComponent } from './index';
import { TestComponent } from './index';

import { NameListService } from '../shared/name-list/index';
import { AuthenticationService } from './index';
import { HttpClient } from './index';
import { LogService } from './index';
import { MsgService } from './index';
import { TestService } from './index';
import { AuthGuard } from './index';
import { ProfileService } from './index';

@NgModule({
  imports: [CommonModule, SharedModule],
  declarations: [
    IndexComponent, LoginComponent, NoAccountYetComponent, PasswordReminderComponent,
    ContactComponent, AboutUsComponent, DashboardComponent, MyProfileComponent,
    TestComponent
  ],
  exports: [
    IndexComponent, LoginComponent, NoAccountYetComponent, PasswordReminderComponent,
    ContactComponent, AboutUsComponent, DashboardComponent, MyProfileComponent,
    TestComponent
  ],
  providers: [
    NameListService, AuthenticationService, HttpClient, LogService, MsgService,
    TestService, AuthGuard, ProfileService
  ]
})
export class CoreModule {

}
