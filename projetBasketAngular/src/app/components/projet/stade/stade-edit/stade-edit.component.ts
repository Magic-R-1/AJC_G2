import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Stade } from 'src/app/model/stade';
import { StadeService } from 'src/app/services/stade.service';

@Component({
  selector: 'app-stade-edit',
  templateUrl: './stade-edit.component.html',
  styleUrls: ['./stade-edit.component.css'],
})
export class StadeEditComponent implements OnInit {
  stade!: Stade;

  constructor(
    private stadeSrv: StadeService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.stade = new Stade();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.stadeSrv.getById(params['id']).subscribe((res) => {
          this.stade = res;
        });
      }
    });
  }

  save() {
    if (this.stade.id) {
      this.stadeSrv.update(this.stade).subscribe((res) => {
        this.router.navigateByUrl('/stade');
      });
    } else {
      this.stadeSrv.create(this.stade).subscribe((res) => {
        this.router.navigateByUrl('/stade');
      });
    }
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
