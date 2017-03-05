import {Component} from '@angular/core';
import {Router} from '@angular/router';

import {MenuItem} from 'primeng/primeng';

import {AuthenticationService} from '../../core/service/authentication.service';
import {SessionService} from '../../core/service/session.service';

/**
 * This class represents the navigation bar component.
 */
@Component({
    moduleId: module.id,
    selector: 'tk-navbar',
    templateUrl: 'navbar.component.html',
    styleUrls: ['navbar.component.css'],
})
export class NavbarComponent {

    public menuItems: MenuItem[];

    constructor(private authService: AuthenticationService,
                private sessionService: SessionService,
                private router: Router) {

    }

    ngOnInit() {
        this.menuItems = [
            {
                label: "Konfiguracja",
                icon: "",
                items: [
                    {
                        label: "Moje konto",
                        routerLink: ["/my-profile"]
                    },
                    {
                        label: "Użytkownicy",
                        routerLink: ["/profiles"]
                    },
                    {
                        label: "Parametry systemu"
                    },
                    {
                        label: "Słowniki"
                    }
                ]
            },
            {
                label: "Pomoc",
                icon: "fa-info",
                items: [
                    {
                        label: "Kontakt",
                        routerLink: ["/contact"]
                    }
                ]
            },
            {
                label: "Wyloguj",
                icon: "fa-sign-out",
                command: (event) => {
                    this.logout();
                }
            }
        ];
    }

    getProfileName() {
        return this.sessionService.getProfileName();
    }

    isLoggedIn() {
        return this.sessionService.isLoggedIn();
    }

    logout() {
        this.authService.logout();
        this.router.navigate(["/"]);
    }

}
