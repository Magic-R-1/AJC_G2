import { JoueurService } from 'src/app/services/joueur.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Equipe } from 'src/app/model/equipe';
import { Joueur } from 'src/app/model/joueur';
import { EquipeService } from 'src/app/services/equipe.service';
import { AuthentificationService } from 'src/app/services/authentification.service';

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
    private joueurSrv: JoueurService,
    private authSrv: AuthentificationService
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

  calculateAge(dateOfBirth: Date): number {
    const today = new Date();
    const birthDate = new Date(dateOfBirth);

    let age = today.getFullYear() - birthDate.getFullYear();

    const monthDiff = today.getMonth() - birthDate.getMonth();

    if (
      monthDiff < 0 ||
      (monthDiff === 0 && today.getDate() < birthDate.getDate())
    ) {
      age--;
    }

    return age;
  }

  get admin() {
    return this.authSrv.isAdmin();
  }

  get client() {
    return this.authSrv.isClient();
  }

  get gm() {
    return this.authSrv.isGm();
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
