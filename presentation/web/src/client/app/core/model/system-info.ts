export class SystemInfo {

    public name: string;
    public version: string;
    public fullName: string;

    constructor(systemInfoResponse: any) {
        this.name = systemInfoResponse.name;
        this.version = systemInfoResponse.version;
        this.setFullName();
    }

    private setFullName() {
        this.fullName = this.name  + " ver. " + this.version;
    }

}