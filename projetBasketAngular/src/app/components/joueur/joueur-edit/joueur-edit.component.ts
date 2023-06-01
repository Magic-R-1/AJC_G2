import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AptitudePhysique } from 'src/app/model/aptitude-physique';
import { Joueur } from 'src/app/model/joueur';
import { JoueurService } from 'src/app/services/joueur.service';

@Component({
  selector: 'app-joueur-edit',
  templateUrl: './joueur-edit.component.html',
  styleUrls: ['./joueur-edit.component.css'],
})
export class JoueurEditComponent implements OnInit {
  joueur!: Joueur;

  constructor(
    private joueurSrv: JoueurService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    let aptitudesPhysiques: AptitudePhysique = new AptitudePhysique();
    this.joueur = new Joueur();
    this.joueur.aptitudesPhysiques = aptitudesPhysiques;

    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.joueurSrv.getById(params['id']).subscribe((res) => {
          this.joueur = res;
        });
      }
    });
  }

  save() {
    if (this.joueur.id) {
      this.joueurSrv.update(this.joueur).subscribe((res) => {
        this.router.navigateByUrl('/joueur');
      });
    } else {
      this.joueurSrv.create(this.joueur).subscribe((res) => {
        this.router.navigateByUrl('/joueur');
      });
    }
  }
}
