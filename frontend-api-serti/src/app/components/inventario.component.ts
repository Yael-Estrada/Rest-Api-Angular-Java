import {Component} from '@angular/core';
import {Router,ActivatedRoute,Params} from '@angular/router';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import {LibrosService} from '../services/libros.service';
import {Libro} from '../models/libro';
import {Localizacion} from '../models/localizacion';
@Component({
	selector: 'inventario',
	templateUrl: '../views/inventario.html',
	providers: [LibrosService]
})

export class InventarioComponent{
	public titulo:string;
	public libros: Libro[];
	public confirmado;
	public localizacion:Localizacion;
	public txtsearch:string;
	public  closeResult = '';
	constructor(
		private _route:ActivatedRoute,
		private _router: Router,
		private _librosService: LibrosService,
		private modalService: NgbModal
		){
		this.titulo="Inventario de libros";
		this.confirmado=null;
		this.localizacion=null;
	}

	ngOnInit(){
		console.log("Componente productos cargado");
		this.getLibros();
	}
	borrarConfirm(id){
		this.confirmado=id;
	}
	cancelarConfirm(){
		this.confirmado=null;
	}
	getLibros(){
		this._librosService.getLibros().subscribe(
			result=> {
				if(result)
					this.libros=result;
			},
			error=>{
				console.log(<any>error);
			}
			);
	}

	getLibrosCad(){
		this._librosService.getLibrosCad(this.txtsearch).subscribe(
			result=> {
				if(result)
					this.libros=result;
			},
			error=>{
				console.log(<any>error);
			}
			);
	}

	onDelete(id){
		let idloc=0;
		for(let i=0;i<this.libros.length;i++){
			if(this.libros[i].idLibro==id){
				idloc=this.libros[i].idLocalizacion;
			}
		}
		this._librosService.deleteLibro(id).subscribe(
			result=>{
				let response=<any>result;
				console.log(result);
				if(response){
					this._librosService.deleteLocalizacion(idloc).subscribe(
					result=>{
						let response=<any>result;
						console.log(result);
						if(response){
							this.getLibros();
						}
						else{
							console.log(result);
						}
					},
					error=>{
						console.log(error);
					}
					);
				}
				else{
					console.log(result);
				}
			},
			error=>{
				console.log(error);
			}
			);
		
	}

	getLocalizacion(id){
		let idloc;
		for(let i=0;i<this.libros.length;i++){
			if(this.libros[i].idLibro==id){
				idloc=this.libros[i].idLocalizacion;
			}
		}
		this._librosService.getLocalizacion(idloc).subscribe(
			result=>{
				let res=<any>result;
				this.localizacion=res;
				console.log(this.localizacion);
			},
			error=>{
				console.log(<any>error);
			}
		);
	}

	open(id,content){
		this.getLocalizacion(id);
		this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
	    this.closeResult = `Closed with: ${result}`;
	    }, (reason) => {
	      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
	    });
	}
	
	private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

}