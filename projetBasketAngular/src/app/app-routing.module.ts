import { NgModule } from '@angular/core';
import { HomeComponent } from './components/home/home.component';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { AboutComponent } from './components/about/about.component';
import { RouterModule, Routes } from '@angular/router';
import { StadeListComponent } from './components/stade/stade-list/stade-list.component';
import { StadeEditComponent } from './components/stade/stade-edit/stade-edit.component';
import { EquipeEditComponent } from './components/equipe/equipe-edit/equipe-edit.component';
import { EquipeListComponent } from './components/equipe/equipe-list/equipe-list.component';

const routes: Routes = [
  { path: 'about', component: AboutComponent },
  { path: 'signup', component: InscriptionComponent },
  { path: 'stade', component: StadeListComponent },
  { path: 'stade/edit', component: StadeEditComponent },
  { path: 'stade/edit/:id', component: StadeEditComponent },
  // { path: 'team', component: EquipeListComponent },
  // { path: 'team/edit', component: EquipeEditComponent },
  // { path: 'team/edit/:id', component: EquipeEditComponent },
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
