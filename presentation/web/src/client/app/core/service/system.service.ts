import {Injectable} from "@angular/core";
import {Response} from "@angular/http";
import {HttpClient} from "./http-client.service";
import {SystemInfo} from "../model/system-info";

@Injectable()
export class SystemService {

    constructor(private httpClient: HttpClient) {

    }

    getSystemInfo() {
        return this.httpClient.get("/system")
            .map((response: Response) => {
                return response.json();
            })
            .map((systemInfoResponse: any) => {
                return new SystemInfo(systemInfoResponse);
            });
    }

}