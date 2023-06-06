export class Stade {
  constructor(
    public nom?: string,
    public capacite?: number,
    public ville?: string,
    public id?: number
  ) {}
  isChecked: boolean = false;
}
