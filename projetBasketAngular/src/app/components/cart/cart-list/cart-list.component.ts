import { Reservation } from './../../../model/reservation';
import { Component, OnInit } from '@angular/core';

import { ReservationService } from 'src/app/services/reservation.service';

import { Router, ActivatedRoute } from '@angular/router';
import { Compte } from 'src/app/model/compte';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { CompteService } from 'src/app/services/compte.service';

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.css'],
})
export class CartListComponent implements OnInit {
  reservations: Reservation[] = [];

  filtre = '';

  constructor(
    private reservationSrv: ReservationService,
    private compteSrv: CompteService,
    private authService: AuthentificationService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.listReservations();
  }

  reservationFiltre() {
    return this.reservations.filter(
      (r) =>
        r.id?.toString().indexOf(this.filtre) !== -1 ||
        r.prix?.toString().indexOf(this.filtre) !== -1
    );
  }

  listReservations() {
    // const connectedAccountId = this.authService.compteSrv.getById();
    let compte: Compte = JSON.parse(sessionStorage.getItem('compte')!);
    this.reservationSrv.getAll().subscribe((resultat) => {
      this.reservations = resultat;
      //.filter((r) => r.compte?.id === connectedAccountId);
    });
  }

  deleteReservation(id: number) {
    this.reservationSrv.deleteById(id).subscribe(() => {
      this.listReservations();
    });
  }

  incrementQuantity(reservation: Reservation) {
    reservation.quantite!++;
    this.updateReservation(reservation);
  }

  decrementQuantity(reservation: Reservation) {
    if (reservation.quantite! > 1) {
      reservation.quantite!--;
      this.updateReservation(reservation);
    }
  }

  updateReservation(reservation: Reservation) {
    this.reservationSrv.update(reservation).subscribe(() => {
      this.listReservations();
    });
  }
}
