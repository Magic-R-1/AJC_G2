import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ConnexionComponent } from './components/connexion/connexion.component';
import { MenuComponent } from './components/menu/menu.component';
import { AboutComponent } from './components/about/about.component';
import { AuthentificationInterceptor } from './interceptors/authentification.interceptor';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SondageQuizComponent } from './components/sondage-quiz/sondage-quiz.component';
import { ArticlesComponent } from './components/articles/articles.component';
import { Actualite1Component } from './components/actualite/actualite1/actualite1.component';
import { Actualite3Component } from './components/actualite/actualite3/actualite3.component';
import { Actualite2Component } from './components/actualite/actualite2/actualite2.component';
import { HeaderComponent } from './components/header/header.component';
import { NewsletterComponent } from './components/newsletter/newsletter.component';
import { FooterComponent } from './components/footer/footer.component';
import { EquipeListComponent } from './components/projet/equipe/equipe-list/equipe-list.component';
import { StadeEditComponent } from './components/projet/stade/stade-edit/stade-edit.component';
import { StadeListComponent } from './components/projet/stade/stade-list/stade-list.component';
import { ArbitreEditComponent } from './components/projet/arbitre/arbitre-edit/arbitre-edit.component';
import { ArbitreListComponent } from './components/projet/arbitre/arbitre-list/arbitre-list.component';
import { ConfrontationEditComponent } from './components/projet/confrontation/confrontation-edit/confrontation-edit.component';
import { ConfrontationListComponent } from './components/projet/confrontation/confrontation-list/confrontation-list.component';
import { CompteEditComponent } from './components/projet/compte/compte-edit/compte-edit/compte-edit.component';
import { CompteListComponent } from './components/projet/compte/compte-list/compte-list/compte-list.component';
import { JoueurEditComponent } from './components/projet/joueur/joueur-edit/joueur-edit.component';
import { JoueurListComponent } from './components/projet/joueur/joueur-list/joueur-list.component';
import { ReservationEditComponent } from './components/projet/reservation/reservation-edit/reservation-edit.component';
import { ReservationListComponent } from './components/projet/reservation/reservation-list/reservation-list.component';
import { PersonnelListComponent } from './components/projet/personnel/personnel-list/personnel-list.component';
import { PersonnelEditComponent } from './components/projet/personnel/personnel-edit/personnel-edit.component';
import { CustomComponent } from './components/custom/custom.component';
import { EquipeEditComponent } from './components/projet/equipe/equipe-edit/equipe-edit.component';
import { EffectifComponent } from './components/projet/effectif/effectif.component';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { InscriptionConfirmationComponent } from './components/inscription/inscription-confirmation/inscription-confirmation.component';
import { ConfrontationDetailsComponent } from './confrontation-details/confrontation-details.component';
import { AchatBilletComponent } from './components/achat-billet/achat-billet.component';
import { PanierComponent } from './components/panier/panier.component';
import { CartListComponent } from './components/cart/cart-list/cart-list.component';
import { CartEditComponent } from './components/cart/cart-edit/cart-edit.component';
import { MoncompteComponent } from './components/projet/moncompte/moncompte.component';

@NgModule({
  declarations: [
    AppComponent,
    InscriptionComponent,
    HomeComponent,
    ConnexionComponent,
    MenuComponent,
    AboutComponent,
    StadeEditComponent,
    StadeListComponent,
    EquipeListComponent,
    EquipeEditComponent,
    SondageQuizComponent,
    ArticlesComponent,
    Actualite1Component,
    Actualite3Component,
    Actualite2Component,
    HeaderComponent,
    NewsletterComponent,
    FooterComponent,
    ConfrontationListComponent,
    ConfrontationEditComponent,
    ArbitreListComponent,
    ArbitreEditComponent,
    CompteEditComponent,
    CompteListComponent,
    JoueurEditComponent,
    JoueurListComponent,
    ReservationEditComponent,
    ReservationListComponent,
    PersonnelListComponent,
    PersonnelEditComponent,
    CustomComponent,
    EffectifComponent,
    InscriptionConfirmationComponent,
    AchatBilletComponent,
    ConfrontationDetailsComponent,
    PanierComponent,
    CartListComponent,
    CartEditComponent,
    MoncompteComponent,
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthentificationInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
