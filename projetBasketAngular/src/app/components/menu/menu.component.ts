import { Component } from '@angular/core';
import { Router } from '@angular/router';
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
      return JSON.parse(sessionStorage.getItem('compte')!).login;
    }
  }

  get statutRole() {
    if (sessionStorage.getItem('compte')) {
      return JSON.parse(sessionStorage.getItem('compte')!).statutRole;
    }
  }

  get prenom() {
    if (sessionStorage.getItem('compte')) {
      return JSON.parse(sessionStorage.getItem('compte')!).prenom;
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

  logoff() {
    sessionStorage.clear();
    this.router.navigateByUrl('/home');
  }

  // Dans votre composant TypeScript
  showAdminMenu: boolean = false;
}
