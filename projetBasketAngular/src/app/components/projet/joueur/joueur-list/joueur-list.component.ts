import { Component, OnInit } from '@angular/core';
import { Joueur } from 'src/app/model/joueur';
import { JoueurService } from 'src/app/services/joueur.service';

@Component({
  selector: 'app-joueur-list',
  templateUrl: './joueur-list.component.html',
  styleUrls: ['./joueur-list.component.css'],
})
export class JoueurListComponent implements OnInit {
  joueurs!: Joueur[];

  constructor(private joueurSrv: JoueurService) {}

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
}
