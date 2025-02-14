import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { CategoriaModule } from  './categoria/categoria.module'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { PeliculaComponent } from './pelicula/pelicula.component';
import { IndexComponent } from './pelicula/index/index.component';
import { CreateComponent } from './pelicula/create/create.component';
import { EditComponent } from './pelicula/edit/edit.component';

@NgModule({
  declarations: [
    AppComponent,
    PeliculaComponent,
    IndexComponent,
    CreateComponent,
    EditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    CategoriaModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
