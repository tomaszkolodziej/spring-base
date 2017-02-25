import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import "../../operators";
import {Http, Headers, Response} from "@angular/http";
import {SystemService} from "./system.service";
import {MsgService} from "./msg.service";

import {Error} from '../model/error';

@Injectable()
export class AuthenticationService {

    public token: string;

    constructor(private http: Http,
                private systemService: SystemService,
                private msgService: MsgService) {
        var currentProfile = JSON.parse(localStorage.getItem("currentProfile"));
        this.token = currentProfile && currentProfile.token;
    }

    login(username: string, password: string): Observable<boolean> {
        var user = {username: username, password: password};

        var headers = new Headers();
        headers.append("Content-Type", "application/json");

        return this.http.post("http://localhost:8090/elab/api/auth", JSON.stringify(user), {headers: headers})
            .map((authenticationResponse: Response) => {
                let authenticationResponseData = authenticationResponse.json();

                if (authenticationResponseData) {
                    this.token = authenticationResponseData.token;

                    this.addProfileToLocalStorage(authenticationResponseData);
                    this.addSystemInfoToLocalStorage();

                    return true;
                } else {
                    return false;
                }
            });
    }

    private addProfileToLocalStorage(authenticationResponse: any) {
        let currentProfile = authenticationResponse.profile;
        currentProfile.token = authenticationResponse.token;
        localStorage.setItem("currentProfile", JSON.stringify(currentProfile));
    }

    private addSystemInfoToLocalStorage() {
        let systemInfo = {};

        this.systemService.getSystemInfo().subscribe(
            (systemInfoData: any) => {
                systemInfo = systemInfoData;
            },
            (err: any) => {
                this.msgService.error(new Error(err));
            },
            () => {
                localStorage.setItem("systemInfo", JSON.stringify(systemInfo));
            }
        );
    }

    logout(): void {
        this.token = null;
        localStorage.removeItem("systemInfo");
        localStorage.removeItem("currentProfile");
    }

}
