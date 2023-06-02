import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Stade } from 'src/app/model/stade';
import { StadeService } from 'src/app/services/stade.service';

@Component({
  selector: 'app-stade-list',
  templateUrl: './stade-list.component.html',
  styleUrls: ['./stade-list.component.css'],
})
export class StadeListComponent implements OnInit {
  stades: Stade[] = [];
  filtre = '';

  constructor(private stadeSrv: StadeService) {}

  stadeFiltre() {
    return this.stades.filter(
      (f) =>
        f.nom?.indexOf(this.filtre) != -1 || f.ville?.indexOf(this.filtre) != -1
    );
  }

  listStades() {
    this.stadeSrv.getStades().subscribe((resultat) => {
      this.stades = resultat;
    });
  }

  ngOnInit(): void {
    this.listStades();
  }

  deleteStade(id: number) {
    this.stadeSrv.deleteById(id).subscribe(() => {
      this.listStades();
    });
  }

  updateById(id: number, stade: Stade) {
    this.stadeSrv.update(stade).subscribe(() => {
      this.listStades();
    });
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
