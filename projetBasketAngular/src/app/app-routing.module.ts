import { NgModule } from '@angular/core';
import { HomeComponent } from './components/home/home.component';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { AboutComponent } from './components/about/about.component';
import { RouterModule, Routes } from '@angular/router';
import { StadeListComponent } from './components/stade/stade-list/stade-list.component';
import { StadeEditComponent } from './components/stade/stade-edit/stade-edit.component';
import { EquipeEditComponent } from './components/equipe/equipe-edit/equipe-edit.component';
import { EquipeListComponent } from './components/equipe/equipe-list/equipe-list.component';
import { Actualite1Component } from './components/actualite/actualite1/actualite1.component';
import { Actualite2Component } from './components/actualite/actualite2/actualite2.component';
import { Actualite3Component } from './components/actualite/actualite3/actualite3.component';

const routes: Routes = [
  { path: 'about', component: AboutComponent },
  { path: 'signup', component: InscriptionComponent },
  { path: 'stade', component: StadeListComponent },
  { path: 'stade/edit', component: StadeEditComponent },
  { path: 'stade/edit/:id', component: StadeEditComponent },
  // { path: 'team', component: EquipeListComponent },
  // { path: 'team/edit', component: EquipeEditComponent },
  // { path: 'team/edit/:id', component: EquipeEditComponent },

  { path: 'actualite/actualite1', component: Actualite1Component },
  { path: 'actualite/actualite2', component: Actualite2Component },
  { path: 'actualite/actualite3', component: Actualite3Component },
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
