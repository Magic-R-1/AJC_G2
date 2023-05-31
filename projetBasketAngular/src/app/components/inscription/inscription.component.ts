import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthentificationService } from 'src/app/services/authentification.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent {
  login!: string;
  password!: string;
  displayError = false;

  constructor(
    private authSrv: AuthentificationService,
    private router: Router
  ) {}

  check() {
    this.authSrv.login(this.login, this.password).subscribe({
      next: (compte) => {
        this.displayError = false;
        sessionStorage.setItem(
          'token',
          'Basic ' + btoa(this.login + ':' + this.password)
        );
        sessionStorage.setItem('compte', JSON.stringify(compte));
        this.router.navigateByUrl('/home');
      },
      error: (err) => {
        this.displayError = true;
      },
    });
  }
}
