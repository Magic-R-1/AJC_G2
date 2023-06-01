import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Equipe } from '../model/equipe';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class EquipeService {
  private static URL: string = 'http://localhost:8080/projetbasket/api/team';

  constructor(private httpClient: HttpClient) {}

  public getEquipes(): Observable<Equipe[]> {
    return this.httpClient.get<Equipe[]>(EquipeService.URL);
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${EquipeService.URL}/${id}`);
  }

  public create(equipe: Equipe): Observable<Equipe> {
    return this.httpClient.post<Equipe>(EquipeService.URL, equipe);
  }

  public getById(id: number): Observable<Equipe> {
    return this.httpClient.get<Equipe>(`${EquipeService.URL}/${id}`);
  }

  public update(equipe: Equipe): Observable<Equipe> {
    return this.httpClient.put<Equipe>(
      `${EquipeService.URL}/${equipe.id}`,
      equipe
    );
  }
}
