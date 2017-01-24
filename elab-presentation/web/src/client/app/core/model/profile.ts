export class Profile {

  public id: number;
  public login: string;
  public name: string;
  public firstName: string;
  public lastName: string;
  public email: string;
  public active: boolean;

  constructor(profile: any) {
    this.id = profile.id;
    this.login = profile.login;
    this.name = profile.name;
    this.firstName = profile.firstName;
    this.lastName = profile.lastName;
    this.email = profile.email;
    this.active = profile.active;
  }

}
