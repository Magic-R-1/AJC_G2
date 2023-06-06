import { Component, OnInit } from '@angular/core';
import { Compte } from 'src/app/model/compte';
import { Reservation } from 'src/app/model/reservation';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css'],
})
export class ReservationListComponent implements OnInit {
  reservations: Reservation[] = [];
  compte!: Compte;

  constructor(
    private reservationSrv: ReservationService,
    private authSrv: AuthentificationService
  ) {}

  ngOnInit(): void {
    this.reservationSrv.getAll().subscribe((reservations: Reservation[]) => {
      this.reservations = reservations;
    });
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

  get admin() {
    return this.authSrv.isAdmin();
  }

  get compteID() {
    if (sessionStorage.getItem('compte')) {
      return JSON.parse(sessionStorage.getItem('compte')!).id;
    }
  }

  public isAutorise(reservation: Reservation): boolean {
    if (this.admin) {
      return true;
    } else if (reservation?.compte?.id == this.compteID) {
      return true;
    }

    return false;
  }
}
