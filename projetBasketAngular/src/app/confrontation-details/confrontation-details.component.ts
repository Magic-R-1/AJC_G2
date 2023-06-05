import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-confrontation-details',
  templateUrl: './confrontation-details.component.html',
  styleUrls: ['./confrontation-details.component.css'],
})
export class ConfrontationDetailsComponent implements OnInit {
  confrontation: any; // Remplacez any par le type approprié pour vos données de confrontation

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.params.subscribe((params) => {
      const confrontationId = params['id'];
      // Récupérez les détails de la confrontation en utilisant son identifiant (par exemple, en le récupérant depuis un service)
      this.confrontation = {
        // Détails de la confrontation
      };
    });
  }

  reserveBillets() {
    // Code spécifique pour la réservation de billets
    console.log('Billets réservés pour la confrontation :', this.confrontation);
    // Exemple d'action supplémentaire : redirection vers une page de confirmation
    // this.router.navigate(['/confirmation']);
  }
}
