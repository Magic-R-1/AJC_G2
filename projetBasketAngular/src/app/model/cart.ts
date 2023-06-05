import { Confrontation } from './confrontation';

export class Cart {
  constructor(
    public confrontation?: Confrontation,
    public quantite?: number,
    public date?: string,
    public price?: number,
    public id?: number
  ) {}
}
