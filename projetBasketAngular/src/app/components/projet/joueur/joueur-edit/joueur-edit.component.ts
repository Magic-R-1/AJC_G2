import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AptitudePhysique } from 'src/app/model/aptitude-physique';
import { Equipe } from 'src/app/model/equipe';
import { Joueur } from 'src/app/model/joueur';
import { EquipeService } from 'src/app/services/equipe.service';
import { JoueurService } from 'src/app/services/joueur.service';

@Component({
  selector: 'app-joueur-edit',
  templateUrl: './joueur-edit.component.html',
  styleUrls: ['./joueur-edit.component.css'],
})
export class JoueurEditComponent implements OnInit {
  joueur!: Joueur;
  obsEquipes!: Observable<Equipe[]>;

  constructor(
    private joueurSrv: JoueurService,
    private equipeSrv: EquipeService,
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
    this.obsEquipes = this.equipeSrv.getEquipes();
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

  compareById(frsOptionActive: Equipe, frsSelect: Equipe): boolean {
    if (frsSelect && frsOptionActive) {
      return frsOptionActive.id === frsSelect.id;
    }
    return false;
  }

  @ViewChild('myModal') myModal!: ElementRef;

  openModal() {
    this.myModal.nativeElement.classList.add('show');
    this.myModal.nativeElement.style.display = 'block';
    document.body.classList.add('modal-open');
  }

  closeModal() {
    this.myModal.nativeElement.classList.remove('show');
    this.myModal.nativeElement.style.display = 'none';
    document.body.classList.remove('modal-open');
  }
}
