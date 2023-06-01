import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Arbitre } from 'src/app/model/arbitre';
import { Confrontation } from 'src/app/model/confrontation';
import { ArbitreService } from 'src/app/services/arbitre.service';
import { ConfrontationService } from 'src/app/services/confrontation.service';

@Component({
  selector: 'app-arbitre-edit',
  templateUrl: './arbitre-edit.component.html',
  styleUrls: ['./arbitre-edit.component.css'],
})
export class ArbitreEditComponent implements OnInit {
  obsConfrontations!: Observable<Confrontation[]>;

  ngOnInit(): void {
    let confrontation: Confrontation = new Confrontation();
    this.arbitre = new Arbitre();
    this.arbitre.confrontation = confrontation;
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.arbitreSrv.getById(params['id']).subscribe((produitJson) => {
          this.arbitre = produitJson;
        });
      }
    });
    this.obsConfrontations = this.confrontationSrv.getConfrontations();
  }

  arbitre: Arbitre = new Arbitre();

  constructor(
    private arbitreSrv: ArbitreService,
    private confrontationSrv: ConfrontationService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  save() {
    if (this.arbitre.id) {
      this.arbitreSrv.update(this.arbitre).subscribe((res) => {
        this.router.navigateByUrl('/arbitre');
      });
    } else {
      this.arbitreSrv.create(this.arbitre).subscribe((res) => {
        this.router.navigateByUrl('/arbitre');
      });
    }
  }

  compareById(
    frsOptionActive: Confrontation,
    frsSelect: Confrontation
  ): boolean {
    if (frsSelect && frsOptionActive) {
      return frsOptionActive.id === frsSelect.id;
    }
    return false;
  }
}
