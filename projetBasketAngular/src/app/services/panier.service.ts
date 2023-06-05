import { Injectable } from '@angular/core';
import { Reservation } from 'src/app/model/reservation';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PanierService {
  private cart: Reservation[] = [];
  private cartSubject: Subject<Reservation[]> = new Subject<Reservation[]>();

  constructor() {}

  addToCart(reservation: Reservation) {
    this.cart.push(reservation);
    this.cartSubject.next(this.cart);
    console.log('Reservation added to cart:', reservation);
  }

  getCart() {
    return this.cartSubject.asObservable();
  }

  clearCart() {
    this.cart = [];
    this.cartSubject.next(this.cart);
  }
}
