import { Component } from '@angular/core';

@Component({
  selector: 'app-newsletter',
  templateUrl: './newsletter.component.html',
  styleUrls: ['./newsletter.component.css'],
})
export class NewsletterComponent {
  subscribe() {
    // Récupérez la valeur de l'adresse e-mail à partir du formulaire et effectuez l'action d'abonnement à la newsletter ici
    // Vous pouvez utiliser un service ou une API pour gérer l'abonnement
    const email = (document.getElementById('email') as HTMLInputElement).value;
    console.log('Adresse e-mail :', email);
  }
}
