import {Component} from '@angular/core';
import {Router,ActivatedRoute,Params} from '@angular/router';
import {LibrosService} from '../services/libros.service';
import {Libro} from '../models/libro';
import {Localizacion} from '../models/localizacion';
import {GLOBAL} from '../services/global';
@Component({
	selector: 'agregarLibro',
	templateUrl: '../views/agregarLibro.html',
	providers:[LibrosService]
})

export class AgregarLibroComponent{
	public title:string;
	public libro:Libro;
	public localizacion:Localizacion;
	public is_edit;
	public ocupado;
	constructor(
		private _libroService: LibrosService,
		private _route:ActivatedRoute,
		private _router:Router
		){
		this.title="Agregar un nuevo libro"
		this.libro=new Libro(0,0,"",0);
		this.localizacion=new Localizacion(0,0,0,0);
		this.is_edit=false;
		this.ocupado=false;
	}

	ngOnInit(){
		console.log("Componente cargado");
	}

	onSubmit(){
		this.saveLibro();
		this.ocupado=false;
	}

	saveLibro(){
		this._libroService.addLocalizacion(this.localizacion).subscribe(
				response=>{
					this.localizacion=response;
					if(this.localizacion.idLocalizacion==-1){
						console.log("Ya esta ocupada");
						this.ocupado=true;
					}
					else{
						this.libro.idLocalizacion=this.localizacion.idLocalizacion;
						this._libroService.addLibros(this.libro).subscribe(
							response=>{
								if(response){
									this._router.navigate(["/inventario"]);
								}
							},
							error=>{
								console.log(<any>error);
							}
						);
					}
				},
				error=>{
					console.log(<any>error);
				}
			);
	}

}