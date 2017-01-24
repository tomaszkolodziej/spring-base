import { Injectable } from '@angular/core';
import { ToastyService, ToastOptions } from 'ng2-toasty';
import { Error } from '../model/error';

@Injectable()
export class MsgService {

  constructor(private toastyService: ToastyService) {

  }

  info(message: string) {
    let msg: ToastOptions = {
      title: "Komunikat",
      msg: message,
      showClose: true,
      timeout: 5000,
      theme: "material"
    };
    this.toastyService.info(msg);
  }

  warning(message: string) {
    let msg: ToastOptions = {
      title: "Komunikat",
      msg: message,
      showClose: true,
      timeout: 5000,
      theme: "material"
    };
    this.toastyService.warning(msg);
  }

  error(error: Error) {
    this.toastyService.error(this.getMessage(error));
  }

  private getMessage(error: Error) {
    let msg: ToastOptions = {
      title: "Komunikat",
      msg: error.message,
      showClose: true,
      timeout: 5000,
      theme: "material"
    };
    return msg;
  }

}
