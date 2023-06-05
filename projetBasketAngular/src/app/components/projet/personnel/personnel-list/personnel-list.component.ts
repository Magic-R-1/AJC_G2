import { AuthentificationService } from './../../../../services/authentification.service';
import { Component, OnInit } from '@angular/core';
import { Equipe } from 'src/app/model/equipe';
import { Personnel } from 'src/app/model/personnel';
import { PersonnelService } from 'src/app/services/personnel.service';

@Component({
  selector: 'app-personnel-list',
  templateUrl: './personnel-list.component.html',
  styleUrls: ['./personnel-list.component.css'],
})
export class PersonnelListComponent implements OnInit {
  personnels: Personnel[] = [];
  filtre = '';
  equipe!: Equipe;
  personnel!: Personnel;
  admin: boolean = false;

  constructor(private personnelSrv: PersonnelService) {
    this.equipe = this.compteEquipe;
  }

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

  public isAutorise(): boolean {
    if (this.admin) {
      return true;
    } else if (this.equipe.id == this.compteEquipe.id) {
      return true;
    }
    return false;
  }
}
