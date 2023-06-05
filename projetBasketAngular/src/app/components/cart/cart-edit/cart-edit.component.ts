import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Cart } from 'src/app/model/cart';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart-edit',
  templateUrl: './cart-edit.component.html',
  styleUrls: ['./cart-edit.component.css'],
})
export class CartEditComponent implements OnInit {
  cart!: Cart;
  paymentSuccess = false;

  constructor(
    private cartSrv: CartService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.cart = new Cart();

    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.cartSrv.getById(params['id']).subscribe((res) => {
          this.cart = res;
        });
      }
    });
  }

  save() {
    if (this.cart.id) {
      this.cartSrv.update(this.cart).subscribe((res) => {
        this.router.navigateByUrl('/cart');
      });
    } else {
      this.cartSrv.create(this.cart).subscribe((res) => {
        this.router.navigateByUrl('/cart');
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
}
