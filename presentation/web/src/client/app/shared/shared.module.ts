import {NgModule, ModuleWithProviders} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";

import {ToastyModule} from "ng2-toasty";
import {InputTextModule} from "primeng/primeng";
import {PasswordModule} from "primeng/primeng";
import {ButtonModule} from "primeng/primeng";
import {PanelModule} from "primeng/primeng";
import {MenuModule} from "primeng/primeng";
import {MenubarModule} from "primeng/primeng";

import {ToolbarComponent} from "./toolbar/index";
import {NavbarComponent} from "./navbar/index";
import {FooterbarComponent} from "./footerbar/index";
import {FooterLinksComponent} from "./footerlinks/index";

import {ToleanFormLabelComponent} from "./tla-form-label/index";

import {NameListService} from "./name-list/index";

/**
 * Do not specify providers for modules that might be imported by a lazy loaded module.
 */
@NgModule({
    imports: [CommonModule, RouterModule, ToastyModule.forRoot(), InputTextModule, PasswordModule, ButtonModule,
        PanelModule, MenuModule, MenubarModule],
    declarations: [ToolbarComponent, NavbarComponent, FooterbarComponent, FooterLinksComponent, ToleanFormLabelComponent],
    exports: [ToolbarComponent, NavbarComponent, FooterbarComponent, FooterLinksComponent, ToleanFormLabelComponent,
        CommonModule, FormsModule, RouterModule, ToastyModule, InputTextModule, PasswordModule, ButtonModule,
        PanelModule, MenuModule, MenubarModule]
})
export class SharedModule {
    static forRoot(): ModuleWithProviders {
        return {
            ngModule: SharedModule,
            providers: [NameListService]
        };
    }
}
