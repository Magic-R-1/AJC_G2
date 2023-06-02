import { Injectable } from '@angular/core';
import { Stade } from 'src/app/model/stade';

@Injectable({
  providedIn: 'root',
})
export class StadeDataService {
  private stade: Stade | undefined;
  stadeId: number | null = null;

  constructor() {}

  getStade(): Stade | undefined {
    return this.stade;
  }

  setStade(stade: Stade) {
    this.stade = stade;
  }

  clearStade() {
    this.stade = undefined;
  }

  setStadeId(id: number) {
    this.stadeId = id;
  }
}
