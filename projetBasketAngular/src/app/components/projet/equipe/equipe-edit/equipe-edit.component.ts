import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Equipe } from 'src/app/model/equipe';
import { Stade } from 'src/app/model/stade';
import { Joueur } from 'src/app/model/joueur';
import { Confrontation } from 'src/app/model/confrontation';
import { EquipeService } from 'src/app/services/equipe.service';
import { StadeService } from 'src/app/services/stade.service';
import { Compte } from 'src/app/model/compte';
import { CompteService } from 'src/app/services/compte.service';

@Component({
  selector: 'app-equipe-edit',
  templateUrl: './equipe-edit.component.html',
  styleUrls: ['./equipe-edit.component.css'],
})
export class EquipeEditComponent implements OnInit {
  obsStades!: Observable<Stade[]>;
  obsComptes!: Observable<Compte[]>;
  equipe: Equipe = new Equipe();

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.equipeSrv.getById(params['id']).subscribe((equipeJson) => {
          this.equipe = equipeJson;
        });
      }
    });
    this.obsStades = this.stadeSrv.getStades();
    this.obsComptes = this.compteSrv.getComptes();
  }

  constructor(
    private equipeSrv: EquipeService,
    private stadeSrv: StadeService,
    private compteSrv: CompteService,
    private aR: ActivatedRoute,
    private router: Router
  ) {}

  save() {
    if (this.equipe.id) {
      this.equipeSrv.update(this.equipe).subscribe((res) => {
        this.router.navigate(['/equipe']);
      });
    } else {
      this.equipeSrv.create(this.equipe).subscribe((res) => {
        this.router.navigate(['/equipe']);
      });
    }
  }

  compareById(eqpOptionActive: Equipe, eqpSelect: Equipe): boolean {
    if (eqpSelect && eqpOptionActive) {
      return eqpOptionActive.id == eqpSelect.id;
    }
    return false;
  }
}
