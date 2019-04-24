export class LoginUser {

  username: string;
  password: string;

  constructor() {
  }

  get _username(): string {
    return this.username;
  }

  set _username(value: string) {
    this.username = value;
  }

  get _password(): string {
    return this.password;
  }

  set _password(value: string) {
    this.password = value;
  }

}
