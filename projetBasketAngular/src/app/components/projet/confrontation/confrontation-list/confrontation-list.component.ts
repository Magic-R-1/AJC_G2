import { Component, OnInit } from '@angular/core';
import { Confrontation } from 'src/app/model/confrontation';
import { ConfrontationService } from 'src/app/services/confrontation.service';

@Component({
  selector: 'app-confrontation-list',
  templateUrl: './confrontation-list.component.html',
  styleUrls: ['./confrontation-list.component.css'],
})
export class ConfrontationListComponent implements OnInit {
  confrontations: Confrontation[] = [];
  filtre = '';

  constructor(private confrontationSrv: ConfrontationService) {}

  ngOnInit(): void {
    this.listConfrontations();
  }

  listConfrontations() {
    this.confrontationSrv.getConfrontations().subscribe((resultat) => {
      this.confrontations = resultat;
    });
  }

  deleteConfrontation(id: number) {
    this.confrontationSrv.deleteById(id).subscribe(() => {
      this.listConfrontations();
    });
  }

  confrontationFiltre() {
    return this.confrontations.filter((f) =>
      f.dateConfrontation?.toLocaleDateString().includes(this.filtre)
    );
  }
}
