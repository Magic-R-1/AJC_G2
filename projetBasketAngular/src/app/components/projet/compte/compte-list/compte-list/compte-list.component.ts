import { Component, OnInit } from '@angular/core';
import { Compte } from 'src/app/model/compte';
import { CompteService } from 'src/app/services/compte.service';

@Component({
  selector: 'app-compte-list',
  templateUrl: './compte-list.component.html',
  styleUrls: ['./compte-list.component.css'],
})
export class CompteListComponent implements OnInit {
  compte: Compte[] = [];
  filtre = '';

  constructor(private compteSrv: CompteService) {}

  compteFiltre() {
    return this.compte.filter((c) => c.nom?.indexOf(this.filtre) !== -1);
  }

  ngOnInit(): void {
    this.listComptes();
  }

  listComptes() {
    this.compteSrv.getComptes().subscribe((resultat) => {
      this.compte = resultat;
    });
  }

  deleteCompte(id: number) {
    this.compteSrv.deleteById(id).subscribe(() => {
      this.listComptes();
    });
  }
}
