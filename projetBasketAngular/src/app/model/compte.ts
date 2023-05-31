export class Compte {
  constructor(public login?: string, public role?: string) {
    this.login = login;
    this.role = role;
  }
}
