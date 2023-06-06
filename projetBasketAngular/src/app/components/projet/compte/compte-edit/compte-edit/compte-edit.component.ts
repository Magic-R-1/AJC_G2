import { Component, ElementRef, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Compte } from 'src/app/model/compte';
import { CompteService } from 'src/app/services/compte.service';

@Component({
  selector: 'app-compte-edit',
  templateUrl: './compte-edit.component.html',
  styleUrls: ['./compte-edit.component.css'],
})
export class CompteEditComponent {
  compte!: Compte;
  StatutRole: any;
  constructor(
    private compteSrv: CompteService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.compte = new Compte();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.compteSrv.getById(params['id']).subscribe((res) => {
          this.compte = res;
        });
      }
    });
  }
  save() {
    if (this.compte.id) {
      this.compteSrv.update(this.compte).subscribe((res) => {
        this.router.navigateByUrl('/compte');
      });
    } else {
      this.compteSrv.create(this.compte).subscribe((res) => {
        this.router.navigateByUrl('/compte');
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
