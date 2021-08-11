import {Component} from '@angular/core';

@Component({
	selector: 'error',
	templateUrl: '../views/error.html'
})

export class ErrorComponent{
	public titulo:string;

	constructor(){
		this.titulo="ERROR 404. Recurso no encontrado.";
	}

	ngOnInit(){
		console.log("Componente de error cargado");
	}
}