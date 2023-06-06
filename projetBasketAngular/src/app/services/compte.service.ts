import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Compte } from '../model/compte';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CompteService {
  private static URL: string = 'http://localhost:8080/projetbasket/api/compte';

  constructor(private httpClient: HttpClient) {}

  public getComptes(): Observable<Compte[]> {
    return this.httpClient.get<Compte[]>(CompteService.URL);
  }

  public getById(id: number): Observable<Compte> {
    return this.httpClient.get<Compte>(`${CompteService.URL}/${id}`);
  }

  public create(compte: Compte): Observable<Compte> {
    return this.httpClient.post<Compte>(CompteService.URL, compte);
  }

  public update(compte: Compte): Observable<Compte> {
    return this.httpClient.put<Compte>(
      `${CompteService.URL}/${compte.id}`,
      compte
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${CompteService.URL}/${id}`);
  }

  checkDoublon(login: string, email: string): Observable<boolean> {
    return this.httpClient.get<boolean>(
      `${CompteService.URL}/${login}/${email}`
    );
    // return this.httpClient.get<boolean>(
    //   `/compte?login=${login}&email=${email}`
    // );
  }
}
