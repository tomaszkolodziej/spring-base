import {Injectable} from '@angular/core';
import {SystemInfo} from "../model/system-info";

@Injectable()
export class SessionService {

    getProfileName(): string {
        return this.getProfile().name;
    }

    getProfileToken(): string {
        return this.getProfile().token;
    }

    getProfile() {
        if (this.isLoggedIn()) {
            return JSON.parse(localStorage.getItem("currentProfile"));
        }
        return {};
    }

    isLoggedIn(): boolean {
        let currentProfile = localStorage.getItem('currentProfile');
        return currentProfile && currentProfile != null;
    }

    getSystemInfo(): SystemInfo {
        return JSON.parse(localStorage.getItem("systemInfo"));
    }

}