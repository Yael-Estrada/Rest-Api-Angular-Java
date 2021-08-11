package com.project.rest;

import com.project.bd.*;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
*    ApiRestController
*
*    Controlador para las peticiones de la API Rest: Get, Post, Put, Delete
*    Esta clase implementa cada una de las respuestas a los métodos REST antes
*    mencionados que se hacen al servidor montado en https://localhost:8080 
*    mediante el framework Spring 
*
*   @author Yael Estrada
*   @version 1.0
*   @since  30/07/2021
*/
@RestController
@RequestMapping("/") 
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,
    RequestMethod.POST,RequestMethod.DELETE})

public class ApiRestController {
    /*
     *   Controladores para el acceso a los datos de la BD
     */
    private final OperacionLibro oplib=new OperacionLibro();;
    private final OperacionLocalizacion oploc=new OperacionLocalizacion();
    
    /*  
     *  Manejador de peticion GET hacia http://localhost:8080/libros
     *  @return     Una lista con los libros que se encuentran registrados en la BD
     *              dentro de la tabla "Libro".
     */
    @GetMapping("/libros")
    public List<Libro> findAll(){
        List<Libro> libros=oplib.obtenerLibros();
        return libros;
    }
    
    /*
     *  Manejador de peticion GET hacia http://localhost:8080/localizacion/{id}
     *  @param  id  Identificador numérico de la localizacion a obtener.
     *  @return     Un objeto localizacion correspondiente al id y que se 
     *              encuentran registrado en la BD dentro de la tabla 
     *              "Localizacion".
     */
    @GetMapping("/localizacion/{Id}")
    public Localizacion getLocalizacion(@PathVariable int Id){
        Localizacion l = oploc.obtenerLocalizacion(Id);
        if(l == null) {
            return null;
        }
        return l;
    }
    
    /*
     *  Manejador de peticion GET hacia http://localhost:8080/libro/{id}
     *  @param  Id  Identificador numérico del libro a obtener.
     *  @return     Un objeto libro correspondiente al id y que se encuentran 
     *              regitstrado en la BD dentro de la tabla "Libro".
     */
    @GetMapping("/libro/{Id}")
    public Libro getLibro(@PathVariable int Id){
        Libro l = oplib.obtenerLibro(Id);
        if(l == null) {
            return null;
        }
        return l;
    }
    
    /*
     *  Manejador de peticion GET hacia http://localhost:8080/libros/{s}
     *  @param  s   Cadena de caracteres que debe contener el título de los libros
                    a obtener.
     *  @return     Una lista de objetos libro cuyo titulo en alguna subcadena
     *              coincida con la cadena "s" y se encuentran 
     *              registrados en la BD dentro de la tabla "Libro".
     */
    @GetMapping("/libros/{s}")
    public List<Libro> encontrarLibrosCad(@PathVariable String s){
        List<Libro> libros=oplib.obtenerLibrosPorCadena(s);
        return libros;
    }
    
    /*
     *  Manejador de peticion POST hacia http://localhost:8080/libros, primero
     *  revisa si no hay algún libro registrado con el mismo título y volumen,
     *  para posteriormente insertarlo en la BD.
     *  @param  libro   Un objeto Libro que se registrará en la BD.
     *  @return         El objeto Libro registrado con el fin de mantener la
     *                  consistencia entre los datos del cliente y el servidor.
     */
    @PostMapping("/libros")
    @ResponseBody
    public Libro addLibro(@RequestBody Libro libro) {
        int id;
        if((id=oplib.existeLibro(libro))!=-1){
            return this.getLibro(id);
        }
        libro.setIdLibro(0);
        id=oplib.insertLibro(libro.getVolumen(),libro.getTitulo(),
                libro.getIdLocalizacion());
        libro.setIdLibro(id);
        return libro;
    }
    
    /*
     *  Manejador de peticion POST hacia http://localhost:8080/localizacion, primero
     *  revisa si no hay algúna localizacion registrada con el mismo numero de
     *  sala,estante y posición para posteriormente insertarla en la BD.
     *  @param  localizacion   Un objeto Localizacion que se registrará en la BD.
     *  @return                El objeto Localizacion registrado con el fin de 
     *                         mantener la consistencia entre los datos del 
     *                         cliente y el servidor.
     */
    @PostMapping("/localizacion")
    @ResponseBody
    public Localizacion addLocalizacion(@RequestBody Localizacion l) {
        int id;
        if((id=oploc.existeLocalizacion(l))!=-1){
            Localizacion res=this.getLocalizacion(id);
            res.setIdLocalizacion(-1);
            return res;
        }
        l.setIdLocalizacion(0);
        id=oploc.insertLocalizacion(l.getSala(),l.getEstante(), l.getPosicion());
        l.setIdLocalizacion(id);
        return l;
    }
    
    
    /*
     *  Manejador de peticion PUT hacia http://localhost:8080/libros/{Id}
     *  @param  Id      Identificador numérico del libro que quiere ser modificado.
     *  @param libro    Un objeto libro que contendrá los datos a modificar del
     *                  libro con el Id ingresado.
     *  @return         El objeto Libro modificado con el fin de 
     *                  mantener la consistencia entre los datos del 
     *                  cliente y el servidor.
     */
    @PutMapping("/libros/{Id}")
    public Libro updateLibro(@PathVariable int Id,@RequestBody Libro libro) {
        oplib.modificarLibro(Id,libro.getVolumen(),libro.getTitulo(),
                libro.getIdLocalizacion());
        libro.setIdLibro(Id);
        return libro;
    }
    
    /*
     *  Manejador de peticion PUT hacia http://localhost:8080/localizacion/{Id}
     *  @param  Id            Identificador numérico de la localizacion que quiere 
     *                        ser modificada.
     *  @param localizacion   Un objeto localizacion que contendrá los datos a 
     *                        modificar de la localizacion con el Id ingresado.
     *  @return               El objeto Localizacion modificado con el fin de 
     *                        mantener la consistencia entre los datos del 
     *                        cliente y el servidor.
     */
    @PutMapping("/localizacion/{Id}")
    public Localizacion updateLocalizacion(@PathVariable int Id,
            @RequestBody Localizacion loc) {
        oploc.modificarLocalizacion(Id,loc.getSala(),loc.getEstante(), 
                loc.getPosicion());
        loc.setIdLocalizacion(Id);
        return loc;
    }
    
    /*
     *  Manejador de peticion DELETE hacia http://localhost:8080/libros/{Id}
     *  @param  Id  Identificador numérico del libro que quiere ser borrado.
     *  @return     Una cadena de confirmación únicamente para notificar que
     *              el objeto se borró exitosamente.
     */
    @DeleteMapping("libros/{Id}")
    public String deteteLibro(@PathVariable int Id) {
        Libro libro = oplib.obtenerLibro(Id);
        if(libro == null) {
            return "Libro "+Id+" not found";
        }
        oplib.borrarLibro(Id);
        return "Deleted libro - "+Id;
    }
    
    /*
     *  Manejador de peticion DELETE hacia http://localhost:8080/localizacion/{Id}
     *  @param  Id  Identificador numérico de la localizacion que quiere ser borrada.
     *  @return     Una cadena de confirmación únicamente para notificar que
     *              el objeto se borró exitosamente.
     */
    @DeleteMapping("localizacion/{Id}")
    public String deteteLocalizacion(@PathVariable int Id) {
        Localizacion loc = oploc.obtenerLocalizacion(Id);
        if(loc == null) {
            return "Location "+Id+" not found";
        }
        oploc.borrarLocalizacion(Id);
        return "Deleted location - "+Id;
    }
    
}
