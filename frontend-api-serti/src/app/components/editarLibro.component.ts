import {Component} from '@angular/core';
import {Router,ActivatedRoute,Params} from '@angular/router';
import {LibrosService} from '../services/libros.service';
import {Libro} from '../models/libro';
import {Localizacion} from '../models/localizacion';
import {GLOBAL} from '../services/global';
@Component({
	selector: 'editarLibro',
	templateUrl: '../views/agregarLibro.html',
	providers:[LibrosService]
})

export class EditarLibroComponent{
		public libro: Libro;
		public title:string;
		public localizacion:Localizacion;
		public is_edit;
		public ocupado;
	constructor(
		private _libroService: LibrosService,
		private _route:ActivatedRoute,
		private _router:Router
		){
		this.title="Editar libro";
		this.libro=new Libro(0,0,'',0);
		this.localizacion=new Localizacion(0,0,0,0);
		this.is_edit=true;
		this.ocupado=false;
	}


	ngOnInit(){
		this.getLibro();
	}

	onSubmit(){
		this.saveLibro();
		this.ocupado=false;
	}

	saveLibro(){
		this._route.params.forEach((params: Params)=>{
			let id= params['id'];
			this._libroService.editLibro(this.libro.idLibro,this.libro).subscribe(
				result=>{
					let response=<any>result;
					this._libroService.editLocalizacion(this.localizacion.idLocalizacion,this.localizacion).subscribe(
						result=>{
							this._router.navigate(["/inventario"]);
						},
						error=>{
							console.log(<any>error);
						}
					);
					
				},
				error=>{
					console.log(<any>error);
				}
				);
		});
	}

	getLibro(){
		this._route.params.forEach((params: Params)=>{
			let id= params['id'];
			this._libroService.getLibro(id).subscribe(
				response=>{
					let res=<any>response;
					this.libro=res;
					this._libroService.getLocalizacion(this.libro.idLocalizacion).subscribe(
						response=>{
							let res=<any>response;
							this.localizacion=res;
						},
						error =>{
							console.log(<any>error);
						}
					);
				},
				error =>{
					console.log(<any>error);
				}
				);
		});

	}
}