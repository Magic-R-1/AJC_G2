import { Confrontation } from './confrontation';
import { Compte } from './compte';

export class Reservation {
  constructor(
    public id?: number,
    public prix?: number,
    public quantite?: number,
    public dateReservation?: Date,
    public confrontation?: Confrontation,
    public compte?: Compte
  ) {}
}
