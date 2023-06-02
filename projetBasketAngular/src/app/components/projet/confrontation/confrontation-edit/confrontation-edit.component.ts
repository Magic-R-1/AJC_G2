import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Arbitre } from 'src/app/model/arbitre';
import { Confrontation } from 'src/app/model/confrontation';
import { Equipe } from 'src/app/model/equipe';
import { Reservation } from 'src/app/model/reservation';
import { ArbitreService } from 'src/app/services/arbitre.service';
import { ConfrontationService } from 'src/app/services/confrontation.service';
import { EquipeService } from 'src/app/services/equipe.service';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-confrontation-edit',
  templateUrl: './confrontation-edit.component.html',
  styleUrls: ['./confrontation-edit.component.css'],
})
export class ConfrontationEditComponent implements OnInit {
  obsArbitres!: Observable<Arbitre[]>;
  obsEquipes!: Observable<Equipe[]>;
  obsReservations!: Observable<Reservation[]>;

  ngOnInit(): void {
    let arbitre: Arbitre = new Arbitre();
    let equipe: Equipe = new Equipe();
    let reservation: Reservation = new Reservation();
    this.confrontation = new Confrontation();
    this.confrontation.arbitre = arbitre;
    this.confrontation.equipe = equipe;
    this.confrontation.reservation = reservation;
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.confrontationSrv.getById(params['id']).subscribe((res) => {
          this.confrontation = res;
        });
      }
    });
    this.obsArbitres = this.arbitreSrv.getArbitres();
    //this.obsEquipes = this.equipeSrv.getEquipes();
    //this.obsReservations = this.reservationSrv.getReservations();
  }

  confrontation: Confrontation = new Confrontation();

  constructor(
    private confrontationSrv: ConfrontationService,
    private arbitreSrv: ArbitreService,
    private equipeSrv: EquipeService,
    private reservationSrv: ReservationService,
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
    frsOptionActive: Arbitre | Equipe | Reservation,
    frsSelect: Arbitre | Equipe | Reservation
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
