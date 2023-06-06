import { Equipe } from 'src/app/model/equipe';
import { StatutRole } from './../model/statut-role';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Compte } from '../model/compte';

@Injectable({
  providedIn: 'root',
})
export class AuthentificationService {
  private static URL: string = 'http://localhost:8080/projetbasket/api/auth';

  constructor(private httpClient: HttpClient) {}

  public login(login: string, password: string): Observable<any> {
    let headers = new HttpHeaders({
      Authorization: 'Basic ' + btoa(login + ':' + password),
    });
    return this.httpClient.get(AuthentificationService.URL, {
      headers: headers,
    });
  }

  public checkRole(statutRole: StatutRole): boolean {
    if (!this.isLogged()) {
      return false;
    }
    let compte = JSON.parse(sessionStorage.getItem('compte')!) as Compte;
    return compte.statutRole == statutRole;
  }

  public isAdmin(): boolean {
    return this.checkRole(StatutRole.ROLE_ADMIN);
  }

  public isLogged(): boolean {
    return sessionStorage.getItem('token') != null;
  }

  public isClient(): boolean {
    return this.checkRole(StatutRole.ROLE_CLIENT);
  }

  public isGm(): boolean {
    return this.checkRole(StatutRole.ROLE_GM);
  }
}
