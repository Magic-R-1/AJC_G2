import { Equipe } from './equipe';
import { StatutRole } from './statut-role';

export class Compte {
  constructor(
    public login?: string,
    public password?: string,
    public nom?: string,
    public prenom?: string,
    public statutRole?: StatutRole,
    public equipe?: Equipe,
    public email?: string,
    public id?: number
  ) {}
}
