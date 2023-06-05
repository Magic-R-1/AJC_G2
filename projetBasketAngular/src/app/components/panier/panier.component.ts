import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/app/model/reservation';
import { PanierService } from 'src/app/services/panier.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css'],
})
export class PanierComponent implements OnInit {
  reservations: Reservation[] = [];

  constructor(private panierService: PanierService) {}

  ngOnInit(): void {
    this.panierService.getCart().subscribe((cart) => {
      this.reservations = cart;
    });
  }
}
