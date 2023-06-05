import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cart } from '../model/cart';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  private static URL: string = 'http://localhost:8080/projetbasket/api/cart';

  constructor(private httpClient: HttpClient) {}

  public getCarts(): Observable<Cart[]> {
    return this.httpClient.get<Cart[]>(CartService.URL);
  }

  public getById(id: number): Observable<Cart> {
    return this.httpClient.get<Cart>(`${CartService.URL}/${id}`);
  }

  public create(cart: Cart): Observable<Cart> {
    return this.httpClient.post<Cart>(CartService.URL, cart);
  }

  public update(cart: Cart): Observable<Cart> {
    return this.httpClient.put<Cart>(`${CartService.URL}/${cart.id}`, cart);
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${CartService.URL}/${id}`);
  }
}
