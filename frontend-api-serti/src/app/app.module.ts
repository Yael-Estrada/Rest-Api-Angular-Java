import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { RouterModule } from '@angular/router';
import {HomeComponent} from './components/home.component';
import {InventarioComponent } from './components/inventario.component';
import {AgregarLibroComponent } from './components/agregarlibro.component';
import {EditarLibroComponent } from './components/editarLibro.component';
import {ErrorComponent } from './components/error.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ErrorComponent,
    InventarioComponent,
    AgregarLibroComponent,
    EditarLibroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
