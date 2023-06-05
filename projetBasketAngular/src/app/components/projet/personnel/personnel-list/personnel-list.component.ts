import { Component, OnInit } from '@angular/core';
import { Equipe } from 'src/app/model/equipe';
import { Personnel } from 'src/app/model/personnel';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { PersonnelService } from 'src/app/services/personnel.service';

@Component({
  selector: 'app-personnel-list',
  templateUrl: './personnel-list.component.html',
  styleUrls: ['./personnel-list.component.css'],
})
export class PersonnelListComponent implements OnInit {
  personnels: Personnel[] = [];
  personnel!: Personnel;
  filtre = '';
  equipe!: Equipe;

  constructor(
    private personnelSrv: PersonnelService,
    private authSrv: AuthentificationService
  ) {}

  personnelFiltre() {
    return this.personnels.filter(
      (p) =>
        p.nom?.indexOf(this.filtre) !== -1 ||
        p.prenom?.indexOf(this.filtre) !== -1
    );
  }

  ngOnInit(): void {
    this.listPersonnels();
  }

  listPersonnels() {
    this.personnelSrv.getAll().subscribe((resultat) => {
      this.personnels = resultat;
    });
  }

  deletePersonnel(id: number) {
    this.personnelSrv.deleteById(id).subscribe(() => {
      this.listPersonnels();
    });
  }

  get compteEquipe() {
    if (sessionStorage.getItem('compte')) {
      return JSON.parse(sessionStorage.getItem('compte')!).equipe;
    }
  }

  get admin() {
    return this.authSrv.isAdmin();
  }

  public isAutorise(): boolean {
    if (this.admin) {
      return true;
    } else if (
      this.personnel &&
      this.personnel.equipe &&
      this.personnel.equipe.id === this.compteEquipe.id
    ) {
      return true;
    }
    return false;
  }
}
