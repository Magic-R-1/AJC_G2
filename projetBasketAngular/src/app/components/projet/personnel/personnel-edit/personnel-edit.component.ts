import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Personnel } from 'src/app/model/personnel';
import { PersonnelService } from 'src/app/services/personnel.service';
import { Router, ActivatedRoute, NavigationEnd } from '@angular/router';
import { Equipe } from 'src/app/model/equipe';
import { Observable } from 'rxjs';
import { EquipeService } from 'src/app/services/equipe.service';
import { Compte } from 'src/app/model/compte';
import { StatutRole } from 'src/app/model/statut-role';

@Component({
  selector: 'app-personnel-edit',
  templateUrl: './personnel-edit.component.html',
  styleUrls: ['./personnel-edit.component.css'],
})
export class PersonnelEditComponent implements OnInit {
  obsEquipes!: Equipe[];
  personnel: Personnel = new Personnel();
  equipe!: Equipe;

  constructor(
    private personnelSrv: PersonnelService,
    private equipeSrv: EquipeService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.personnel = new Personnel();

    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.personnelSrv.getById(params['id']).subscribe((personnelJson) => {
          this.personnel = personnelJson;
        });
      }
    });
    this.equipeSrv.getEquipes().subscribe((equipes) => {
      this.obsEquipes = equipes;
      let compte: Compte = JSON.parse(sessionStorage.getItem('compte')!);

      if (compte.statutRole == StatutRole.ROLE_GM) {
        // this.personnel.equipe=compte.equipe
        this.obsEquipes = [];
        this.obsEquipes.push(compte.equipe!);
      }
    });
  }

  save() {
    if (this.personnel.id) {
      this.personnelSrv.update(this.personnel).subscribe((res) => {
        this.router.navigateByUrl('/personnel');
      });
    } else {
      this.personnelSrv.create(this.personnel).subscribe((res) => {
        this.router.navigateByUrl('/personnel');
      });
    }
  }

  compare(equipe1: Equipe, equipe2: Equipe): boolean {
    if (!equipe1 && !equipe2) {
      return true;
    } else if (!equipe2) {
      return false;
    }
    return equipe1.id == equipe2.id;
  }

  get compteEquipe() {
    if (sessionStorage.getItem('compte')) {
      return JSON.parse(sessionStorage.getItem('compte')!).equipe;
    }
  }
}
function getLastRoute(event: Event | undefined) {
  throw new Error('Function not implemented.');
}
