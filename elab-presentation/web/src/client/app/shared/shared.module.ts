import { NgModule, ModuleWithProviders } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgSemanticModule } from 'ng-semantic';
import { ToastyModule } from 'ng2-toasty';

import { ToolbarComponent } from './toolbar/index';
import { NavbarComponent } from './navbar/index';
import { FooterbarComponent } from './footerbar/index';
import { FooterLinksComponent } from './footerlinks/index';

import { ToleanFormLabelComponent } from './tla-form-label/index';

import { NameListService } from './name-list/index';

/**
 * Do not specify providers for modules that might be imported by a lazy loaded module.
 */
@NgModule({
  imports: [CommonModule, RouterModule, NgSemanticModule, ToastyModule.forRoot()],
  declarations: [ToolbarComponent, NavbarComponent, FooterbarComponent, FooterLinksComponent, ToleanFormLabelComponent],
  exports: [ToolbarComponent, NavbarComponent, FooterbarComponent, FooterLinksComponent, ToleanFormLabelComponent,
    CommonModule, FormsModule, RouterModule, NgSemanticModule, ToastyModule]
})
export class SharedModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: SharedModule,
      providers: [NameListService]
    };
  }
}
