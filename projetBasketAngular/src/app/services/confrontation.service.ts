import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Confrontation } from '../model/confrontation';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ConfrontationService {
  private static URL: string =
    'http://localhost:8080/projetbasket/api/confrontation';

  constructor(private httpClient: HttpClient) {}

  public getConfrontations(): Observable<Confrontation[]> {
    let options = undefined;
    if (sessionStorage.getItem('token')) {
      options = {
        headers: new HttpHeaders({
          Authorization: sessionStorage.getItem('token')!,
        }),
      };
    }
    return this.httpClient.get<Confrontation[]>(
      ConfrontationService.URL,
      options
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${ConfrontationService.URL}/${id}`);
  }

  public create(confrontation: Confrontation): Observable<Confrontation> {
    return this.httpClient.post<Confrontation>(
      ConfrontationService.URL,
      confrontation
    );
  }

  public getById(id: number): Observable<Confrontation> {
    return this.httpClient.get<Confrontation>(
      `${ConfrontationService.URL}/${id}`
    );
  }

  public update(confrontation: Confrontation): Observable<Confrontation> {
    return this.httpClient.put<Confrontation>(
      `${ConfrontationService.URL}/${confrontation.id}`,
      confrontation
    );
  }
}
