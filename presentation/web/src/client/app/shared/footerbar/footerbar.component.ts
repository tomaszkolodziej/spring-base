import {Component} from '@angular/core';
import {SessionService} from "../../core/service/session.service";

@Component({
    moduleId: module.id,
    selector: 'tk-footerbar',
    templateUrl: 'footerbar.component.html',
    styleUrls: ['footerbar.component.css']
})
export class FooterbarComponent {

    constructor(private sessionService: SessionService) {

    }

}
