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
  confrontation: Confrontation = new Confrontation();

  ngOnInit(): void {
    this.confrontation = new Confrontation();

    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.confrontationSrv
          .getById(params['id'])
          .subscribe((confrontationJson) => {
            this.confrontation = confrontationJson;
          });
      }
    });
    this.obsArbitres = this.arbitreSrv.getArbitres();
    this.obsEquipes = this.equipeSrv.getEquipes();
  }

  constructor(
    private confrontationSrv: ConfrontationService,
    private arbitreSrv: ArbitreService,
    private equipeSrv: EquipeService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

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

  compareById(
    frsOptionActive: Arbitre | Equipe,
    frsSelect: Arbitre | Equipe
  ): boolean {
    if (frsSelect && frsOptionActive) {
      return frsOptionActive.id === frsSelect.id;
    }
    return false;
  }

  @ViewChild('myModal') myModal!: ElementRef;

  openModal() {
    this.myModal.nativeElement.classList.add('show');
    this.myModal.nativeElement.style.display = 'block';
    document.body.classList.add('modal-open');
  }

  closeModal() {
    this.myModal.nativeElement.classList.remove('show');
    this.myModal.nativeElement.style.display = 'none';
    document.body.classList.remove('modal-open');
  }
}
