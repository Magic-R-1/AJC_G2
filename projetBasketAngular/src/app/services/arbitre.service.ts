import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Arbitre } from '../model/arbitre';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ArbitreService {
  private static URL: string = 'http://localhost:8080/projetbasket/api/arbitre';

  constructor(private httpClient: HttpClient) {}

  public getArbitres(): Observable<Arbitre[]> {
    let options = undefined;
    if (sessionStorage.getItem('token')) {
      options = {
        headers: new HttpHeaders({
          Authorization: sessionStorage.getItem('token')!,
        }),
      };
    }
    return this.httpClient.get<Arbitre[]>(ArbitreService.URL, options);
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${ArbitreService.URL}/${id}`);
  }

  public create(arbitre: Arbitre): Observable<Arbitre> {
    return this.httpClient.post<Arbitre>(ArbitreService.URL, arbitre);
  }

  public getById(id: number): Observable<Arbitre> {
    return this.httpClient.get<Arbitre>(`${ArbitreService.URL}/${id}`);
  }

  public update(arbitre: Arbitre): Observable<Arbitre> {
    return this.httpClient.put<Arbitre>(
      `${ArbitreService.URL}/${arbitre.id}`,
      arbitre
    );
  }
}
