import { Equipe } from './equipe';

export class Stade {
  constructor(
    public nom?: string,
    public capacite?: number,
    public ville?: string,
    public equipe?: Equipe,
    public id?: number
  ) {}
}
