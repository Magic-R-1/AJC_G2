import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EmailService {
  private apiUrl = 'https://api.sendgrid.com/v3/mail/send'; // Remplacez par l'URL de votre API d'envoi d'e-mails

  constructor(private http: HttpClient) {}

  envoyerEmail(
    email: string,
    codeConfirmation: number,
    message: String
  ): Observable<any> {
    const url = `${this.apiUrl}/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`; // Remplacez par l'URL de l'API d'envoi d'e-mails appropriée pour votre cas d'utilisation

    // Construire le corps de l'e-mail
    const emailBody = {
      to: email,
      subject: "Confirmation d'inscription",
      body: `Votre code de confirmation est : ${codeConfirmation}`,
    };

    // Envoyer la demande POST à l'API d'envoi d'e-mails
    return this.http.post(url, emailBody);
  }
}
