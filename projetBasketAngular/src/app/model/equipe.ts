// import { Confrontation } from './confrontation';
// import { Personnel } from './personnel';
// import { Compte } from './compte';
// import { Stade } from './stade';

import { Joueur } from './joueur';

export class Equipe {
  constructor(
    public franchise?: string,
    public ville?: string,
    public joueur?: Joueur,
    // public confrontation?: Confrontation,
    // public stade?: Stade,
    // public personnel?: Personnel,
    // public compte?: Compte,
    public id?: number
  ) {}
}
