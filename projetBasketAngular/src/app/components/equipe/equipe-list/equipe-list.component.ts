import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Equipe } from 'src/app/model/equipe';
import { EquipeService } from 'src/app/services/equipe.service';

@Component({
  selector: 'app-equipe-list',
  templateUrl: './equipe-list.component.html',
  styleUrls: ['./equipe-list.component.css'],
})
export class EquipeListComponent implements OnInit {
  obsEquipes!: Observable<Equipe[]>;

  constructor(private equipeSrv: EquipeService) {}
  ngOnInit(): void {
    this.obsEquipes = this.equipeSrv.getAll();
  }

  // delete(id: number) {
  //   this.equipeSrv.delete(id).subscribe(() => {
  //     this.obsEquipes = this.equipeSrv.getAll();
  //   });
  // }
}