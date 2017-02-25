import {Component} from '@angular/core';
import {Config} from './shared/index';
import './operators';
import {SessionService} from "./core/service/session.service";

/**
 * This class represents the main application component.
 */
@Component({
    moduleId: module.id,
    selector: 'tk-app',
    templateUrl: 'app.component.html',
})
export class AppComponent {

    constructor(private sessionService: SessionService) {
        console.log('Environment config', Config);
    }

    isLoggedIn() {
        return this.sessionService.isLoggedIn();
    }

}
