// import { Confrontation } from './confrontation';
// import { Personnel } from './personnel';
// import { Compte } from './compte';
// import { Stade } from './stade';

import { Confrontation } from './confrontation';
import { Joueur } from './joueur';
import { Stade } from './stade';

export class Equipe {
  constructor(
    public franchise?: string,
    public ville?: string,
    public joueur?: Joueur,
    public confrontation?: Confrontation,
    public stade?: Stade,
    // public personnel?: Personnel,
    // public compte?: Compte,
    public id?: number
  ) {}
}
