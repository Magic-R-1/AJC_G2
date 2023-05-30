import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { FormsModule } from '@angular/forms';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { MenuComponent } from './components/menu/menu.component';
import { AboutComponent } from './components/about/about.component';
import { StadeEditComponent } from './components/stade/stade-edit/stade-edit.component';
import { StadeListComponent } from './components/stade/stade-list/stade-list.component';
import { EquipeListComponent } from './components/equipe/equipe-list/equipe-list.component';
import { EquipeEditComponent } from './components/equipe/equipe-edit/equipe-edit.component';
import { AuthentificationInterceptor } from './interceptors/authentification.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    InscriptionComponent,
    MenuComponent,
    AboutComponent,
    StadeEditComponent,
    StadeListComponent,
    EquipeListComponent,
    EquipeEditComponent,
  ],
  imports: [HttpClientModule, BrowserModule, AppRoutingModule, FormsModule],
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
