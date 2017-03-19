import { Component } from '@angular/core';
import {SessionService} from "../../core/service/session.service";

@Component({
  moduleId: module.id,
  selector: 'tk-footerlinks',
  templateUrl: 'footerlinks.component.html',
  styleUrls: ['footerlinks.component.css']
})
export class FooterLinksComponent {

    constructor(private sessionService: SessionService) {

    }



}
