import { RolePersonnel } from './role-personnel';
import { Equipe } from './equipe';

export class Personnel {
  constructor(
    public nom?: string,
    public prenom?: string,
    public salaire?: number,
    public equipe?: Equipe,
    public role_personnel?: RolePersonnel,
    public id?: number
  ) {}
}
