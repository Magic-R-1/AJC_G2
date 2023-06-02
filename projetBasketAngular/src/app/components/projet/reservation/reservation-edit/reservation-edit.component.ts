import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Reservation } from 'src/app/model/reservation';
import { ReservationService } from 'src/app/services/reservation.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Confrontation } from 'src/app/model/confrontation';
import { Compte } from 'src/app/model/compte';
import { ConfrontationService } from 'src/app/services/confrontation.service';
import { CompteService } from 'src/app/services/compte.service';

@Component({
  selector: 'app-reservation-edit',
  templateUrl: './reservation-edit.component.html',
  styleUrls: ['./reservation-edit.component.css'],
})
export class ReservationEditComponent implements OnInit {
  obsConfrontations!: Observable<Confrontation[]>;
  obsComptes!: Observable<Compte[]>;
  reservation: Reservation = new Reservation();

  ngOnInit(): void {
    this.reservation = new Reservation();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.reservationSrv
          .getById(params['id'])
          .subscribe((reservationJson) => {
            this.reservation = reservationJson;
          });
      }
    });
    this.obsConfrontations = this.confrontationSrv.getConfrontations();
    this.obsComptes = this.compteSrv.getComptes();
  }

  constructor(
    private reservationSrv: ReservationService,
    private confrontationSrv: ConfrontationService,
    private compteSrv: CompteService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  save() {
    //console.log(this.reservation + '-----');

    if (this.reservation.id) {
      this.reservationSrv.update(this.reservation).subscribe((res) => {
        //console.log('bien passé ici 2');
        this.router.navigateByUrl('/reservation');
      });
    } else {
      this.reservationSrv.create(this.reservation).subscribe((res) => {
        //console.log('bien passé ici 3');
        this.router.navigateByUrl('/reservation');
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
