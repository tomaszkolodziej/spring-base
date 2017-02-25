import {Component} from '@angular/core';
import {SessionService} from '../../core/service/session.service';
import {SystemInfo} from "../../core/model/system-info";

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

    public systemInfo: any = { name: "", version: ""};

    constructor(private sessionService: SessionService) {

    }

    ngOnInit(): void {
        this.setSystemInfo();
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
