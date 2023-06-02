import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Joueur } from '../model/joueur';

@Injectable({
  providedIn: 'root',
})
export class JoueurService {
  constructor(private httpClient: HttpClient) {}

  public getJoueursByEquipe(id: number): Observable<Joueur[]> {
    return this.httpClient.get<Joueur[]>(
      `http://localhost:8080/projetbasket/api/joueur/effectif/${id}`
    );
  }

  public getJoueurs(): Observable<Joueur[]> {
    return this.httpClient.get<Joueur[]>(
      'http://localhost:8080/projetbasket/api/joueur'
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/projetbasket/api/joueur/${id}`
    );
  }

  public create(joueur: Joueur): Observable<Joueur> {
    return this.httpClient.post<Joueur>(
      'http://localhost:8080/projetbasket/api/joueur',
      joueur
    );
  }

  public getById(id: number): Observable<Joueur> {
    return this.httpClient.get<Joueur>(
      `http://localhost:8080/projetbasket/api/joueur/${id}`
    );
  }

  public update(joueur: Joueur): Observable<Joueur> {
    return this.httpClient.put<Joueur>(
      `http://localhost:8080/projetbasket/api/joueur/${joueur.id}`,
      joueur
    );
  }
}
