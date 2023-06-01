import { NgModule } from '@angular/core';
import { HomeComponent } from './components/home/home.component';
import { ConnexionComponent } from './components/connexion/connexion.component';
import { AboutComponent } from './components/about/about.component';
import { RouterModule, Routes } from '@angular/router';
import { StadeListComponent } from './components/projet/stade/stade-list/stade-list.component';
import { StadeEditComponent } from './components/projet/stade/stade-edit/stade-edit.component';
//import { EquipeEditComponent } from './components/projet/equipe/equipe-edit/equipe-edit.component';
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

const routes: Routes = [
  { path: 'about', component: AboutComponent },
  { path: 'signup', component: ConnexionComponent },
  { path: 'stade', component: StadeListComponent },
  { path: 'stade/edit', component: StadeEditComponent },
  { path: 'stade/edit/:id', component: StadeEditComponent },
  { path: 'team', component: EquipeListComponent },
  // { path: 'team/edit', component: EquipeEditComponent },
  // { path: 'team/edit/:id', component: EquipeEditComponent },
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
  { path: 'inscription', component: InscriptionComponent },
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
