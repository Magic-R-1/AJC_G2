import { AptitudePhysique } from './aptitude-physique';
import { Equipe } from './equipe';

export class Joueur {
  constructor(
    public nom?: string,
    public prenom?: string,
    public taille?: number,
    public poids?: number,
    public date_naissance?: Date,
    public numero_maillot?: number,
    public salaire?: number,
    public statut?: string,
    public poste?: string,
    public equipe?: Equipe,
    public aptitudesPhysiques?: AptitudePhysique,
    public id?: number
  ) {}
}
