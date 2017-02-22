import { Route } from '@angular/router';
import { AuthGuard } from './index';
import { IndexComponent } from './index';
import { LoginComponent } from './index';
import { NoAccountYetComponent } from './index';
import { PasswordReminderComponent } from './index';
import { ContactComponent } from './index';
import { AboutUsComponent } from './index';
import { DashboardComponent } from './index';
import { MyProfileComponent } from './index';

export const CoreRoutes: Route[] = [
  {
    path: '',
    component: IndexComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'no-account-yet',
    component: NoAccountYetComponent
  },
  {
    path: 'password-reminder',
    component: PasswordReminderComponent
  },
  {
    path: 'contact',
    component: ContactComponent
  },
  {
    path: 'about-us',
    component: AboutUsComponent
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'my-profile',
    component: MyProfileComponent,
    canActivate: [AuthGuard]
  }
];
