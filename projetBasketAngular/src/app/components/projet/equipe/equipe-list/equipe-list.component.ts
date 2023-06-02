import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Equipe } from 'src/app/model/equipe';
import { Stade } from 'src/app/model/stade';
import { Joueur } from 'src/app/model/joueur';
import { Confrontation } from 'src/app/model/confrontation';
import { EquipeService } from 'src/app/services/equipe.service';
import { StadeService } from 'src/app/services/stade.service';
import { Compte } from 'src/app/model/compte';
import { CompteService } from 'src/app/services/compte.service';

@Component({
  selector: 'app-equipe-list',
  templateUrl: './equipe-list.component.html',
  styleUrls: ['./equipe-list.component.css'],
})
export class EquipeListComponent implements OnInit {
  equipes: Equipe[] = [];
  filtre = '';

  constructor(
    private equipeSrv: EquipeService,
    private stadeSrv: StadeService,
    private compteSrv: CompteService,
    private aR: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.listEquipes();
  }

  equipeFiltre() {
    return this.equipes.filter(
      (f) =>
        f.franchise?.indexOf(this.filtre) != -1 ||
        f.ville?.indexOf(this.filtre) != -1
    );
  }

  listEquipes() {
    this.equipeSrv.getEquipes().subscribe((resultat) => {
      this.equipes = resultat;
    });
  }

  deleteEquipe(id: number) {
    this.equipeSrv.deleteById(id).subscribe(() => {
      this.listEquipes();
    });
  }
}
