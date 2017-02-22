import { ToastOptions } from 'ng2-toasty';

export class Error {

  public id: string;
  public code: string;
  public message: string;
  public returnData: any;
  public fieldErrors: any;

  constructor(err: any) {
    let error = JSON.parse(err._body);
    this.id = error.id;
    this.code = error.code;
    this.message = error.message;
    this.returnData = error.returnData;
    this.fieldErrors = error.fieldErrors;
  }

}
