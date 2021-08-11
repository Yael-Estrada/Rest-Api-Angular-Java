import {Injectable} from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {Observable} from 'rxjs';
import {Libro} from '../models/libro';
import {Localizacion} from '../models/localizacion';
import {GLOBAL} from './global';

@Injectable({
	providedIn:"root"
})

export class LibrosService{
	public url:string;
	constructor(
		private _http:HttpClient
		){
		this.url=GLOBAL.url;
	}

	getLibros(): Observable<any>{
		return this._http.get(this.url+GLOBAL.libros);
	}

	getLibrosCad(s: string): Observable<any>{
		return this._http.get(this.url+GLOBAL.libros+"/"+s);
	}

	addLibros(libro:Libro): Observable<any>{
		let json=JSON.stringify(libro);
		let params=json;
		let headers = new HttpHeaders().set('Content-Type','application/json');
        return this._http.post(this.url+GLOBAL.libros, params, {headers: headers});
	}

	addLocalizacion(localizacion:Localizacion): Observable<any>{
		let json=JSON.stringify(localizacion);
		let params=json;
		let headers = new HttpHeaders().set('Content-Type','application/json');
        return this._http.post(this.url+GLOBAL.localizacion, params, {headers: headers});
	}

	editLibro(id,libro:Libro): Observable<any>{
		let json=JSON.stringify(libro);
		let params=json;
		let headers = new HttpHeaders().set('Content-Type','application/json');
        return this._http.put(this.url+GLOBAL.libros+"/"+id, params, {headers: headers});
	
	}
	editLocalizacion(id,localizacion:Localizacion): Observable<any>{
		let json=JSON.stringify(localizacion);
		let params=json;
		let headers = new HttpHeaders().set('Content-Type','application/json');
        return this._http.put(this.url+GLOBAL.localizacion+"/"+id, params, {headers: headers});
	
	}

	deleteLocalizacion(id){
		return this._http.delete(this.url+GLOBAL.localizacion+"/"+id,{responseType: 'text' });
	}

	deleteLibro(id){
		return this._http.delete(this.url+GLOBAL.libros+"/"+id,{responseType: 'text' });
	}

	getLibro(id){
		return this._http.get(this.url+GLOBAL.librosid+id);
	}

	getLocalizacion(id){
		return this._http.get(this.url+GLOBAL.localizacion+"/"+id);
	}


}

