import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Arbitre } from 'src/app/model/arbitre';
import { ArbitreService } from 'src/app/services/arbitre.service';

@Component({
  selector: 'app-arbitre-list',
  templateUrl: './arbitre-list.component.html',
  styleUrls: ['./arbitre-list.component.css'],
})
export class ArbitreListComponent implements OnInit {
  arbitres!: Arbitre[];

  constructor(private arbitreSrv: ArbitreService) {}

  ngOnInit(): void {
    this.listArbitres();
  }

  listArbitres() {
    this.arbitreSrv.getArbitres().subscribe((resultat) => {
      this.arbitres = resultat;
    });
  }

  deleteArbitre(id: number) {
    this.arbitreSrv.deleteById(id).subscribe(() => {
      this.listArbitres();
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
