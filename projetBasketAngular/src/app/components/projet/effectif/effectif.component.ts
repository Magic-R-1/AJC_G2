import { JoueurService } from 'src/app/services/joueur.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Equipe } from 'src/app/model/equipe';
import { Joueur } from 'src/app/model/joueur';
import { EquipeService } from 'src/app/services/equipe.service';

@Component({
  selector: 'app-effectif',
  templateUrl: './effectif.component.html',
  styleUrls: ['./effectif.component.css'],
})
export class EffectifComponent implements OnInit {
  equipe!: Equipe;
  equipes!: Equipe[];
  joueurs: Joueur[] = [];
  constructor(
    private equipeSrv: EquipeService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private joueurSrv: JoueurService
  ) {}

  ngOnInit(): void {
    this.equipeSrv.getEquipes().subscribe((equipes: Equipe[]) => {
      this.equipes = equipes;
      this.equipe = equipes[0];
      this.loadEffectif();
    });
  }

  loadEffectif() {
    this.joueurSrv
      .getJoueursByEquipe(this.equipe.id!)
      .subscribe((joueurs: Joueur[]) => {
        this.joueurs = joueurs;
      });
  }
}
