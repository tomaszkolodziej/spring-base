import { Routes } from '@angular/router';

import { AboutRoutes } from './about/index';
import { CoreRoutes } from './core/index';

export const routes: Routes = [
  ...CoreRoutes,
  ...AboutRoutes
];
