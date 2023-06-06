import { NgModule, Component } from '@angular/core';
import { HomeComponent } from './components/home/home.component';
import { ConnexionComponent } from './components/connexion/connexion.component';
import { AboutComponent } from './components/about/about.component';
import { RouterModule, Routes } from '@angular/router';
import { StadeListComponent } from './components/projet/stade/stade-list/stade-list.component';
import { StadeEditComponent } from './components/projet/stade/stade-edit/stade-edit.component';
import { EquipeEditComponent } from './components/projet/equipe/equipe-edit/equipe-edit.component';
import { EquipeListComponent } from './components/projet/equipe/equipe-list/equipe-list.component';
import { Actualite1Component } from './components/actualite/actualite1/actualite1.component';
import { Actualite2Component } from './components/actualite/actualite2/actualite2.component';
import { Actualite3Component } from './components/actualite/actualite3/actualite3.component';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { CompteListComponent } from './components/projet/compte/compte-list/compte-list/compte-list.component';
import { CompteEditComponent } from './components/projet/compte/compte-edit/compte-edit/compte-edit.component';
import { ArbitreEditComponent } from './components/projet/arbitre/arbitre-edit/arbitre-edit.component';
import { ArbitreListComponent } from './components/projet/arbitre/arbitre-list/arbitre-list.component';
import { ConfrontationEditComponent } from './components/projet/confrontation/confrontation-edit/confrontation-edit.component';
import { ConfrontationListComponent } from './components/projet/confrontation/confrontation-list/confrontation-list.component';
import { JoueurListComponent } from './components/projet/joueur/joueur-list/joueur-list.component';
import { JoueurEditComponent } from './components/projet/joueur/joueur-edit/joueur-edit.component';
import { PersonnelEditComponent } from './components/projet/personnel/personnel-edit/personnel-edit.component';
import { PersonnelListComponent } from './components/projet/personnel/personnel-list/personnel-list.component';
import { ReservationEditComponent } from './components/projet/reservation/reservation-edit/reservation-edit.component';
import { ReservationListComponent } from './components/projet/reservation/reservation-list/reservation-list.component';
import { EffectifComponent } from './components/projet/effectif/effectif.component';
import { InscriptionConfirmationComponent } from './components/inscription/inscription-confirmation/inscription-confirmation.component';
import { MoncompteComponent } from './components/projet/moncompte/moncompte.component';

const routes: Routes = [
  { path: 'about', component: AboutComponent },
  { path: 'signup', component: ConnexionComponent },
  { path: 'stade', component: StadeListComponent },
  { path: 'stade/edit', component: StadeEditComponent },
  { path: 'stade/edit/:id', component: StadeEditComponent },
  { path: 'equipe', component: EquipeListComponent },
  { path: 'equipe/edit', component: EquipeEditComponent },
  { path: 'equipe/edit/:id', component: EquipeEditComponent },
  { path: 'joueur', component: JoueurListComponent },
  { path: 'joueur/edit', component: JoueurEditComponent },
  { path: 'joueur/edit/:id', component: JoueurEditComponent },
  { path: 'effectif', component: EffectifComponent },
  { path: 'personnel', component: PersonnelListComponent },
  { path: 'personnel/edit', component: PersonnelEditComponent },
  { path: 'personnel/edit/:id', component: PersonnelEditComponent },
  { path: 'reservation', component: ReservationListComponent },
  { path: 'reservation/edit', component: ReservationEditComponent },
  { path: 'reservation/edit/:id', component: ReservationEditComponent },
  { path: 'compte', component: CompteListComponent },
  { path: 'compte/edit', component: CompteEditComponent },
  { path: 'compte/edit/:id', component: CompteEditComponent },
  { path: 'arbitre', component: ArbitreListComponent },
  { path: 'arbitre/edit', component: ArbitreEditComponent },
  { path: 'arbitre/edit/:id', component: ArbitreEditComponent },
  { path: 'confrontation', component: ConfrontationListComponent },
  { path: 'confrontation/edit', component: ConfrontationEditComponent },
  { path: 'confrontation/edit/:id', component: ConfrontationEditComponent },
  { path: 'actualite/actualite1', component: Actualite1Component },
  { path: 'actualite/actualite2', component: Actualite2Component },
  { path: 'actualite/actualite3', component: Actualite3Component },
  { path: 'monCompte', component: MoncompteComponent },

  {
    path: 'inscription/confirmation',
    component: InscriptionConfirmationComponent,
  },
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'inscription', component: InscriptionComponent },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
