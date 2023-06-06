import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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

  constructor(
    private compteSrv: CompteService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.compte = JSON.parse(sessionStorage.getItem('compte')!);
  }

  toggleEditMode() {
    this.editMode = !this.editMode;
  }

  saveCompte() {
    // Utilisez le service compte pour enregistrer les modifications du compte
    this.compteSrv.update(this.compte).subscribe(
      () => {
        this.editMode = false;
      },
      (error) => {
        console.error('Erreur lors de la mise à jour du compte :', error);
      }
    );
  }
}
