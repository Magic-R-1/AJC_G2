import { Injectable } from '@angular/core';
import { Personnel } from '../model/personnel';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PersonnelService {
  private static URL: string =
    'http://localhost:8080/projetbasket/api/personnel';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Personnel[]> {
    return this.httpClient.get<Personnel[]>(PersonnelService.URL);
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${PersonnelService.URL}/${id}`);
  }

  public create(personnel: Personnel): Observable<Personnel> {
    return this.httpClient.post<Personnel>(PersonnelService.URL, personnel);
  }

  public getById(id: number): Observable<Personnel> {
    return this.httpClient.get<Personnel>(`${PersonnelService.URL}/${id}`);
  }

  public update(personnel: Personnel): Observable<Personnel> {
    return this.httpClient.put<Personnel>(
      `${PersonnelService.URL}/${personnel.id}`,
      personnel
    );
  }
}
