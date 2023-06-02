import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stade } from '../model/stade';

@Injectable({
  providedIn: 'root',
})
export class StadeService {
  private static URL: string = 'http://localhost:8080/projetbasket/api/stade';

  constructor(private httpClient: HttpClient) {}

  public getStades(): Observable<Stade[]> {
    let options = undefined;
    if (sessionStorage.getItem('token')) {
      options = {
        headers: new HttpHeaders({
          Authorization: sessionStorage.getItem('token')!,
        }),
      };
    }
    return this.httpClient.get<Stade[]>(StadeService.URL, options);
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${StadeService.URL}/${id}`);
  }

  public create(stade: Stade): Observable<Stade> {
    return this.httpClient.post<Stade>(StadeService.URL, stade);
  }

  public getById(id: number): Observable<Stade> {
    return this.httpClient.get<Stade>(`${StadeService.URL}/${id}`);
  }

  public update(stade: Stade): Observable<Stade> {
    return this.httpClient.put<Stade>(`${StadeService.URL}/${stade.id}`, stade);
  }
  public updateById(id: number, stade: Stade): Observable<Stade> {
    return this.httpClient.put<Stade>(`${StadeService.URL}/${id}`, stade);
  }
}
