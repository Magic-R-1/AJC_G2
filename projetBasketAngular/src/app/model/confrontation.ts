import { Arbitre } from './arbitre';
import { Equipe } from './equipe';

export class Confrontation {
  constructor(
    public dateConfrontation?: Date,
    public duree?: number,
    public scoreDomicile?: number,
    public scoreVisiteur?: number,
    public arbitre?: Arbitre,
    public equipe?: Equipe,
    public equipeVisiteur?: Equipe,
    public id?: number
  ) {}
}
