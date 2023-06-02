import { Personnel } from './personnel';
import { Compte } from './compte';

import { Confrontation } from './confrontation';
import { Joueur } from './joueur';
import { Stade } from './stade';

export class Equipe {
  constructor(
    public franchise?: string,
    public ville?: string,
    public stade?: Stade,
    public compte?: Compte,
    public id?: number
  ) {}
}
