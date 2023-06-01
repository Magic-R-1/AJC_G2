import { Confrontation } from './confrontation';
export class Arbitre {
  constructor(
    public nom?: string,
    public prenom?: string,
    public anciennete?: number,
    public nationalite?: string,
    public confrontation?: Confrontation,
    public id?: number
  ) {}
}
