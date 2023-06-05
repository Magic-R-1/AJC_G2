import { Personnel } from './personnel';
import { Compte } from './compte';

import { Confrontation } from './confrontation';
import { Joueur } from './joueur';
import { Stade } from './stade';
import { Reservation } from './reservation';

export class Equipe {
  constructor(
    public franchise?: string,
    public ville?: string,
    public joueur?: Joueur,
    public personnel?: Personnel,
    public confrontation?: Confrontation,
    public stade?: Stade,
    public reservation?: Reservation,
    public compte?: Compte,
    public id?: number
  ) {}
}
