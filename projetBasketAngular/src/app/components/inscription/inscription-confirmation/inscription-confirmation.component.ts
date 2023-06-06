import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Compte } from 'src/app/model/compte';
import { StatutRole } from 'src/app/model/statut-role';
import { CompteService } from 'src/app/services/compte.service';

@Component({
  selector: 'app-inscription-confirmation',
  templateUrl: './inscription-confirmation.component.html',
  styleUrls: ['./inscription-confirmation.component.css'],
})
export class InscriptionConfirmationComponent implements OnInit {
  compte!: Compte;
  StatutRole: any;
  form!: FormGroup;

  inscriptionValide: boolean = false;

  constructor(
    //this.compte = {}, // Initialisation du compte vide
    private compteSrv: CompteService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.compte = new Compte();

    this.compte = {
      statutRole: StatutRole.ROLE_CLIENT,
    };

    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.compteSrv.getById(params['id']).subscribe((res) => {
          this.compte = res;
        });
      }
    });
  }

  save() {
    this.compteSrv.create(this.compte).subscribe(
      (res) => {
        // Redirection vers la page de confirmation d'inscription
        this.router.navigateByUrl('/inscription');

        // Affichage du message de validation
        this.inscriptionValide = true;
        this.compte = {};
      }
      // (error) => {
      //   // Gestion de l'erreur en cas d'échec de l'inscription
      //   console.error("Erreur lors de l'inscription :", error);
      // }
    );
  }
}
