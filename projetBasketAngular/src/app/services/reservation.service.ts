import { Injectable } from '@angular/core';
import { Reservation } from '../model/reservation';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ReservationService {
  private static URL: string = 'http://localhost:8080/projetbasket/api/team';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<[Reservation]> {
    return this.httpClient.get<[Reservation]>(ReservationService.URL);
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${ReservationService.URL}/${id}`);
  }

  public create(reservation: Reservation): Observable<Reservation> {
    return this.httpClient.post<Reservation>(
      ReservationService.URL,
      reservation
    );
  }

  public getById(id: number): Observable<Reservation> {
    return this.httpClient.get<Reservation>(`${ReservationService.URL}/${id}`);
  }

  public update(reservation: Reservation): Observable<Reservation> {
    return this.httpClient.put<Reservation>(
      `${ReservationService.URL}/${reservation.id}`,
      reservation
    );
  }
}
