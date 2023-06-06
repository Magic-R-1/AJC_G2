import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Compte } from 'src/app/model/compte';
import { StatutRole } from 'src/app/model/statut-role';
import { CompteService } from 'src/app/services/compte.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  compte!: Compte;
  StatutRole: any;
  erreurDoublon: boolean = false;
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
    // Vérification si le login et l'email sont déjà utilisés
    if (this.compte.login && this.compte.email) {
      this.compteSrv
        .checkDoublon(this.compte.login, this.compte.email)
        .subscribe(
          (doublonExiste) => {
            if (doublonExiste) {
              // Login ou email déjà utilisé
              this.erreurDoublon = true;
            } else {
              // Login et email disponibles, création du compte
              this.compteSrv.create(this.compte).subscribe(
                (res) => {
                  // Redirection vers la page d'inscription
                  this.router.navigateByUrl('/home');

                  // Affichage du message de validation
                  // this.inscriptionValide = true;

                  // Réinitialisation du formulaire
                }

                // this.inscriptionValide = true;
                // Gestion de l'erreur en cas d'échec de l'inscription
                //   console.error("Erreur lors de l'inscription :", error);
                // }
              );
            }
          }
          // (error) => {
          //   // Gestion de l'erreur en cas de problème de vérification
          //   console.error(
          //     'Erreur lors de la vérification des doublons :',
          //     error
          //   );
          // }
        );
    } else {
      // Gestion de l'erreur si le login ou l'email est manquant
      console.error('Login ou email manquant');
    }
  }
}
