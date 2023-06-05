import { Component, ElementRef, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Confrontation } from 'src/app/model/confrontation';
import { Reservation } from 'src/app/model/reservation';
import { ConfrontationService } from 'src/app/services/confrontation.service';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-achat-billet',
  templateUrl: './achat-billet.component.html',
  styleUrls: ['./achat-billet.component.css'],
})
export class AchatBilletComponent {
  confrontations: Confrontation[] = [];
  reservations: Reservation[] = [];
  obsConfrontations!: Observable<Confrontation[]>;
  reservation: Reservation = new Reservation();
  @ViewChild('myModal') myModal!: ElementRef;
  selectedConfrontation?: Confrontation;

  constructor(
    private reservationSrv: ReservationService,
    private confrontationSrv: ConfrontationService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.listConfrontations();
    this.reservation = new Reservation();
    this.activatedRoute.params.subscribe((params) => {
      const reservationId = params['id'];
      if (reservationId) {
        this.reservationSrv
          .getById(reservationId)
          .subscribe((reservationJson) => {
            this.reservation = reservationJson;
          });
      }
    });
    this.obsConfrontations = this.confrontationSrv.getConfrontations();
    this.reservation.dateReservation = new Date();

    this.obsConfrontations.subscribe((confrontations) => {
      if (confrontations.length > 0) {
        this.selectedConfrontation = confrontations[0];
        this.reservation = new Reservation();
        this.reservation.confrontation = this.selectedConfrontation;
      }
    });
  }

  getCurrentDate(): string {
    const currentDate = new Date();

    const day = currentDate.getDate().toString().padStart(2, '0');
    const month = (currentDate.getMonth() + 1).toString().padStart(2, '0');
    const year = currentDate.getFullYear().toString();

    return `${day}/${month}/${year}`;
  }

  isConfrontationPast(confrontation: any): boolean {
    const currentDate = new Date();
    const confrontationDate = new Date(confrontation.dateConfrontation); // Obtient la date de la confrontation

    return confrontationDate < currentDate;
  }

  listConfrontations() {
    this.confrontationSrv.getConfrontations().subscribe((resultat) => {
      this.confrontations = resultat;
    });
  }

  deleteConfrontation(id: number) {
    this.confrontationSrv.deleteById(id).subscribe(() => {
      this.listConfrontations();
    });
  }

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

  compareById(
    frsOptionActive: Confrontation,
    frsSelect: Confrontation
  ): boolean {
    return frsSelect?.id === frsOptionActive?.id;
  }

  save() {
    this.reservation.dateReservation = new Date();

    const request = this.reservation.id
      ? this.reservationSrv.update(this.reservation)
      : this.reservationSrv.create(this.reservation);

    request.subscribe(() => {
      this.router.navigateByUrl('/reservation');
    });
  }
}
