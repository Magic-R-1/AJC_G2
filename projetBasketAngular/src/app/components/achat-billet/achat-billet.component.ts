import { Component, ElementRef, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Compte } from 'src/app/model/compte';
import { Confrontation } from 'src/app/model/confrontation';
import { Reservation } from 'src/app/model/reservation';
import { CompteService } from 'src/app/services/compte.service';
import { ConfrontationService } from 'src/app/services/confrontation.service';
import { PanierService } from 'src/app/services/panier.service';
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
  obsComptes!: Observable<Compte[]>;
  reservation: Reservation = new Reservation();
  @ViewChild('myModal') myModal!: ElementRef;
  selectedConfrontation?: Confrontation;

  constructor(
    private reservationSrv: ReservationService,
    private confrontationSrv: ConfrontationService,
    private compteSrv: CompteService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private panierService: PanierService
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
    this.obsComptes = this.compteSrv.getComptes();

    const currentDate = new Date();
    this.reservation.dateReservation = currentDate;

    this.obsConfrontations.subscribe((confrontations) => {
      if (confrontations.length > 0) {
        this.selectedConfrontation = confrontations[0];
        this.reservation = new Reservation(); // Déplacer ici
        this.reservation.confrontation = this.selectedConfrontation;
      }
    });
  }

  public getCurrentDate(): Date {
    return new Date();
  }

  isConfrontationPast(confrontation: Confrontation | undefined): boolean {
    const currentDate = new Date();
    const confrontationDate = confrontation?.dateConfrontation
      ? new Date(confrontation.dateConfrontation)
      : undefined;
    return confrontationDate !== undefined && confrontationDate < currentDate;
  }

  padNumber(number: number): string {
    return number.toString().padStart(2, '0');
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
    confrontation1: Confrontation,
    confrontation2: Confrontation
  ): boolean {
    if (!confrontation1 && !confrontation2) {
      return true;
    } else if (!confrontation2) {
      return false;
    }
    return confrontation1.id == confrontation2.id;
  }

  save() {
    const request = this.reservation.id
      ? this.reservationSrv.update(this.reservation)
      : this.reservationSrv.create(this.reservation);

    request.subscribe(() => {
      this.router.navigateByUrl('/reservation');
    });
  }

  addToCart(confrontation: Confrontation | undefined) {
    if (confrontation) {
      const reservation: Reservation = {
        confrontation,
        dateReservation: this.getCurrentDate(),
        quantite: this.reservation.quantite,
      };

      this.panierService.addToCart(reservation);
    }
  }
}
