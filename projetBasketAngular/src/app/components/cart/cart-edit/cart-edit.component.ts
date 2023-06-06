import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Cart } from 'src/app/model/cart';
import { Compte } from 'src/app/model/compte';
import { Confrontation } from 'src/app/model/confrontation';
import { Reservation } from 'src/app/model/reservation';
import { CartService } from 'src/app/services/cart.service';
import { CompteService } from 'src/app/services/compte.service';
import { ConfrontationService } from 'src/app/services/confrontation.service';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-cart-edit',
  templateUrl: './cart-edit.component.html',
  styleUrls: ['./cart-edit.component.css'],
})
export class CartEditComponent implements OnInit {
  cart!: Cart;
  paymentSuccess = false;
  obsConfrontations!: Observable<Confrontation[]>;
  obsComptes!: Observable<Compte[]>;
  reservation: Reservation = new Reservation();

  constructor(
    private reservationSrv: ReservationService,
    private confrontationSrv: ConfrontationService,
    private compteSrv: CompteService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

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

  save() {
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
    this.paymentSuccess = true;
  }
  showModal() {
    this.paymentSuccess = false; // Réinitialisez la variable pour chaque tentative de paiement
  }

  closeModal() {
    this.paymentSuccess = false;
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
