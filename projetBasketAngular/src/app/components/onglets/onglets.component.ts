import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthentificationService } from 'src/app/services/authentification.service';

@Component({
  selector: 'app-onglets',
  templateUrl: './onglets.component.html',
  styleUrls: ['./onglets.component.css'],
})
export class OngletsComponent {
  constructor(
    private router: Router,
    private authSrv: AuthentificationService
  ) {}

  get login() {
    if (sessionStorage.getItem('compte')) {
      return JSON.parse(sessionStorage.getItem('compte')!).username;
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
