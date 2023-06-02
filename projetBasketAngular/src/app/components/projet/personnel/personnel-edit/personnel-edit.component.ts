import { Component, OnInit } from '@angular/core';
import { Personnel } from 'src/app/model/personnel';
import { PersonnelService } from 'src/app/services/personnel.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Equipe } from 'src/app/model/equipe';
import { Observable } from 'rxjs';
import { EquipeService } from 'src/app/services/equipe.service';

@Component({
  selector: 'app-personnel-edit',
  templateUrl: './personnel-edit.component.html',
  styleUrls: ['./personnel-edit.component.css'],
})
export class PersonnelEditComponent implements OnInit {
  obsEquipes!: Observable<Equipe[]>;
  personnel: Personnel = new Personnel();

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
    this.obsEquipes = this.equipeSrv.getEquipes();
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

  compareById(frsOptionActive: Equipe, frsSelect: Equipe): boolean {
    if (frsSelect && frsOptionActive) {
      return frsOptionActive.id === frsSelect.id;
    }
    return false;
  }
}
