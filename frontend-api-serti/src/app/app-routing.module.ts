import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ModuleWithProviders} from '@angular/core';
import {HomeComponent} from './components/home.component';
import {InventarioComponent } from './components/inventario.component';
import {AgregarLibroComponent } from './components/agregarlibro.component';
import {EditarLibroComponent } from './components/editarLibro.component';
import {ErrorComponent } from './components/error.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'home',component: HomeComponent},
  {path: 'inventario', component: InventarioComponent},
  {path: 'agregarLibro', component: AgregarLibroComponent},
  {path: 'editarLibro/:id', component: EditarLibroComponent},
  {path: '**', component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
