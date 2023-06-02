import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Arbitre } from 'src/app/model/arbitre';
import { ArbitreService } from 'src/app/services/arbitre.service';

@Component({
  selector: 'app-arbitre-edit',
  templateUrl: './arbitre-edit.component.html',
  styleUrls: ['./arbitre-edit.component.css'],
})
export class ArbitreEditComponent implements OnInit {
  arbitre!: Arbitre;

  constructor(
    private arbitreSrv: ArbitreService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.arbitre = new Arbitre();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.arbitreSrv.getById(params['id']).subscribe((res) => {
          this.arbitre = res;
        });
      }
    });
  }

  save() {
    if (this.arbitre.id) {
      this.arbitreSrv.update(this.arbitre).subscribe((res) => {
        this.router.navigateByUrl('/arbitre');
      });
    } else {
      this.arbitreSrv.create(this.arbitre).subscribe((res) => {
        this.router.navigateByUrl('/arbitre');
      });
    }
  }
}
