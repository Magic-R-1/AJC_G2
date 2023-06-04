import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Compte } from 'src/app/model/compte';
import { StatutRole } from 'src/app/model/statut-role';
import { CompteService } from 'src/app/services/compte.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent {
  compte!: Compte;
  StatutRole: any;

  constructor(
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
    this.compteSrv.create(this.compte).subscribe((res) => {
      this.router.navigateByUrl('/inscription/confirmation');
    });
  }
}
