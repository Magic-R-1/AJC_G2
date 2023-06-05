import { Component, OnInit } from '@angular/core';
import { Cart } from 'src/app/model/cart';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.css'],
})
export class CartListComponent implements OnInit {
  carts: Cart[] = [
    {
      confrontation: {
        /* détails de la confrontation */
      },
      quantite: 2,
      date: '2023-06-04',
      price: 10.99,
      id: 1,
    },
    {
      confrontation: {
        /* détails de la confrontation */
      },
      quantite: 1,
      date: '2023-06-05',
      price: 9.99,
      id: 2,
    },
  ];
  filtre = '';

  constructor(private cartSrv: CartService) {}
  cartFiltre() {
    return this.carts.filter((f) => f.date?.indexOf(this.filtre) != -1);
  }
  ngOnInit(): void {
    this.listCarts();
  }

  listCarts() {
    this.cartSrv.getCarts().subscribe((resultat) => {
      this.carts = resultat;
    });
  }

  deleteCart(id: number) {
    this.cartSrv.deleteById(id).subscribe(() => {
      this.listCarts();
    });
  }
}
