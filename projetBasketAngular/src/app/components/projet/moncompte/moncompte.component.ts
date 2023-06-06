import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Compte } from 'src/app/model/compte';
import { CompteService } from 'src/app/services/compte.service';

@Component({
  selector: 'app-moncompte',
  templateUrl: './moncompte.component.html',
  styleUrls: ['./moncompte.component.css'],
})
export class MoncompteComponent implements OnInit {
  compte!: Compte;
  editMode: boolean = false;

  constructor(private compteSrv: CompteService, private router: Router) {}

  ngOnInit(): void {
    this.compte = JSON.parse(sessionStorage.getItem('compte')!);
    this.compte.password = '';
  }

  toggleEditMode() {
    this.editMode = !this.editMode;
  }

  saveCompte() {
    // Utilisez le service compte pour enregistrer les modifications du compte
    console.log(this.compte);
    this.compteSrv.update(this.compte).subscribe(
      () => {
        //this.editMode = false;
        sessionStorage.setItem('compte', JSON.stringify(this.compte));
        sessionStorage.setItem(
          'token',
          'Basic ' + btoa(this.compte.login + ':' + this.compte.password)
        );
        this.editMode = false;
        // this.router.navigateByUrl('/home');
      },
      (error) => {
        console.error('Erreur lors de la mise à jour du compte :', error);
      }
    );
  }
}
