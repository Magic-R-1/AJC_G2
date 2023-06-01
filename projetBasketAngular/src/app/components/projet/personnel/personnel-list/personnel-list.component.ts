import { Component, OnInit } from '@angular/core';
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

  constructor(private personnelSrv: PersonnelService) {}

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
}
