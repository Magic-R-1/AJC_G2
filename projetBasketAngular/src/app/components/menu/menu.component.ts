import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Compte } from 'src/app/model/compte';
import { AuthentificationService } from 'src/app/services/authentification.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
})
export class MenuComponent {
  constructor(
    private router: Router,
    private authSrv: AuthentificationService
  ) {}

  get login() {
    if (sessionStorage.getItem('compte')) {
      return JSON.parse(sessionStorage.getItem('compte')!).username;
    } else {
      return false;
    }
  }

  get admin() {
    return this.authSrv.isAdmin;
  }

  get client() {
    return this.authSrv.isClient;
  }

  get gm() {
    return this.authSrv.isGm;
  }

  logon(): boolean {
    if (sessionStorage.getItem('compte') != null) {
      return true;
    } else return false;
  }
  logoff() {
    sessionStorage.clear();
    this.router.navigateByUrl('/home');
  }

  // Dans votre composant TypeScript
  showAdminMenu: boolean = false;
}
