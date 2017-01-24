import { Injectable } from '@angular/core';

@Injectable()
export class LogService {

  private applicationName: string = "app";

  info(message: string) {
    console.log(this.getMessage(message));
  }

  warn(message: string) {
    console.warn(this.getMessage(message));
  }

  error(message: string) {
    console.error(this.getMessage(message));
  }

  dir(dataName: string, data: any) {
    console.log(this.getMessage(dataName));
    console.dir(data);
  }

  private getMessage(message: string) {
    return this.applicationName + " : " + message;
  }

}
