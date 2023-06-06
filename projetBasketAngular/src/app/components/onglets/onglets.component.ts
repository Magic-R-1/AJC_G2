import { Component, ElementRef, HostListener } from '@angular/core';
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
    private authSrv: AuthentificationService,
    private elementRef: ElementRef
  ) {}

  @HostListener('document:click', ['$event.target'])
  onDocumentClick(target: any) {
    // Vérifiez si le clic provient de l'élément parent ou de ses enfants
    const clickedInside = this.elementRef.nativeElement.contains(target);
    if (!clickedInside) {
      this.showAdminMenu = false;
    }
  }

  onOutsideClick() {
    // Gérez les actions supplémentaires lors d'un clic sur l'élément parent lui-même
    this.showAdminMenu = !this.showAdminMenu;
  }

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

  get equipe() {
    if (sessionStorage.getItem('compte')) {
      return JSON.parse(sessionStorage.getItem('compte')!).equipe;
    }
  }

  get admin() {
    return this.authSrv.isAdmin();
  }

  get client() {
    return this.authSrv.isClient();
  }

  get gm() {
    return this.authSrv.isGm();
  }

  logoff() {
    sessionStorage.clear();
    this.router.navigateByUrl('/home');
  }

  // Dans votre composant TypeScript
  showAdminMenu: boolean = false;
}
