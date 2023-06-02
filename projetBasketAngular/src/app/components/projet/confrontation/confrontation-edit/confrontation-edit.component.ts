import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Arbitre } from 'src/app/model/arbitre';
import { Confrontation } from 'src/app/model/confrontation';
import { Equipe } from 'src/app/model/equipe';
import { ArbitreService } from 'src/app/services/arbitre.service';
import { ConfrontationService } from 'src/app/services/confrontation.service';
import { EquipeService } from 'src/app/services/equipe.service';

@Component({
  selector: 'app-confrontation-edit',
  templateUrl: './confrontation-edit.component.html',
  styleUrls: ['./confrontation-edit.component.css'],
})
export class ConfrontationEditComponent implements OnInit {
  obsArbitres!: Observable<Arbitre[]>;
  obsEquipes!: Observable<Equipe[]>;
  obsEquipesVisiteurs!: Observable<Equipe[]>;
  confrontation!: Confrontation;

  constructor(
    private confrontationSrv: ConfrontationService,
    private arbitreSrv: ArbitreService,
    private equipeSrv: EquipeService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.confrontation = new Confrontation();

    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.confrontationSrv.getById(params['id']).subscribe((res) => {
          this.confrontation = res;
        });
      }
    });

    this.obsArbitres = this.arbitreSrv.getArbitres();
    this.obsEquipes = this.equipeSrv.getEquipes();
    this.obsEquipesVisiteurs = this.equipeSrv.getEquipesVisiteurs();
  }

  save() {
    if (this.confrontation.id) {
      this.confrontationSrv.update(this.confrontation).subscribe((res) => {
        this.router.navigateByUrl('/confrontation');
      });
    } else {
      this.confrontationSrv.create(this.confrontation).subscribe((res) => {
        this.router.navigateByUrl('/confrontation');
      });
    }
  }

  compareById(frsOptionActive: Equipe, frsSelect: Equipe): boolean {
    if (frsSelect && frsOptionActive) {
      return frsOptionActive.id === frsSelect.id;
    }
    return false;
  }
}
