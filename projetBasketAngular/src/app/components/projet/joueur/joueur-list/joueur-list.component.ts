import { Component, OnInit } from '@angular/core';
import { Joueur } from 'src/app/model/joueur';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { JoueurService } from 'src/app/services/joueur.service';

@Component({
  selector: 'app-joueur-list',
  templateUrl: './joueur-list.component.html',
  styleUrls: ['./joueur-list.component.css'],
})
export class JoueurListComponent implements OnInit {
  joueurs!: Joueur[];

  constructor(
    private joueurSrv: JoueurService,
    private authSrv: AuthentificationService
  ) {}

  ngOnInit(): void {
    this.listJoueurs();
  }

  listJoueurs() {
    this.joueurSrv.getJoueurs().subscribe((resultat) => {
      this.joueurs = resultat;
    });
  }

  deleteJoueur(id: number) {
    this.joueurSrv.deleteById(id).subscribe(() => {
      this.listJoueurs();
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
}
