import { Component, OnInit } from '@angular/core';
import { Stade } from 'src/app/model/stade';
import { StadeService } from 'src/app/services/stade.service';

@Component({
  selector: 'app-stade-list',
  templateUrl: './stade-list.component.html',
  styleUrls: ['./stade-list.component.css'],
})
export class StadeListComponent implements OnInit {
  stades!: Stade[];

  constructor(private stadeSrv: StadeService) {}

  ngOnInit(): void {
    this.listStades();
  }

  listStades() {
    this.stadeSrv.getStades().subscribe((resultat) => {
      this.stades = resultat;
    });
  }

  deleteStade(id: number) {
    this.stadeSrv.deleteById(id).subscribe(() => {
      this.listStades();
    });
  }
}
