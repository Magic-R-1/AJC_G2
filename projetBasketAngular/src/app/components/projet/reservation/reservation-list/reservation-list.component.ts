import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/app/model/reservation';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css'],
})
export class ReservationListComponent implements OnInit {
  reservations: Reservation[] = [];
  filtre = '';

  constructor(private reservationSrv: ReservationService) {}

  reservationFiltre() {
    return this.reservations.filter(
      (r) =>
        r.id?.toString().indexOf(this.filtre) !== -1 ||
        r.prix?.toString().indexOf(this.filtre) !== -1
    );
  }

  ngOnInit(): void {
    this.listReservations();
  }

  listReservations() {
    this.reservationSrv.getAll().subscribe((resultat) => {
      this.reservations = resultat;
    });
  }

  deleteReservation(id: number) {
    this.reservationSrv.deleteById(id).subscribe(() => {
      this.listReservations();
    });
  }
}
