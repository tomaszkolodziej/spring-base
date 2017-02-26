import {Component} from '@angular/core';
import {SessionService} from '../../core/service/session.service';
import {SystemInfo} from "../../core/model/system-info";
import {SystemService} from "../../core/service/system.service";

/**
 * This class represents the toolbar component.
 */
@Component({
    moduleId: module.id,
    selector: 'tk-toolbar',
    templateUrl: 'toolbar.component.html',
    styleUrls: ['toolbar.component.css']
})
export class ToolbarComponent {

    public systemInfo: SystemInfo = null;

    constructor(private systemService: SystemService,
                private sessionService: SessionService) {
        this.addSystemInfoToLocalStorage();
    }

    private addSystemInfoToLocalStorage() {
        this.systemService.getSystemInfo().subscribe(
            (systemInfoData: any) => {
                this.systemInfo = systemInfoData;
                localStorage.setItem("systemInfo", JSON.stringify(this.systemInfo));
            }
        );
    }

    isLoggedIn() {
        return this.sessionService.isLoggedIn();
    }

    getProfileName() {
        return this.sessionService.getProfileName();
    }

    setSystemInfo() {
        this.systemInfo = this.sessionService.getSystemInfo();
    }

}
