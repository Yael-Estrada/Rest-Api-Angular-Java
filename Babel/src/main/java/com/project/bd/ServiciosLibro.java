
package com.project.bd;

import java.util.List;
/*
*    ServiciosLibro
*
*   Interfaz de los servicios que proporciona la Base de Datos específicamente 
*   en la tabla "Libro" de la BD "babel" a los que se accede gracias al 
*   framework MyBatis.
*
*   @author Yael Estrada
*   @version 1.0
*   @since  30/07/2021
*/
public interface ServiciosLibro {
    //Inserta en la BD el objeto Libro
    public void Insertar(Libro lib);
    //Borra el libro que tenga el id que se recibe como parámetro
    public void Borrar(int id);
    //Modifica el libro que se recibe como parámetro.
    public void Modificar(Libro lib);
    //Obtiene la lista de todos los Libros en la tabla.
    public List<Libro> Obtener();
    //Obtiene el libro que tenga el id que se recibe como parámetro.
    public Libro ObtenerLibro(int id);
    /*  Obtiene el libro (si existe) que coincida con los campos del 
     *  objeto recibido como parámetro, si no existe regresa null.
    ¨*/
    public Libro existeLibro(Libro l);
    //Obtiene la lista de los libros cuyo titulo tenga como subcadena la cadena s.
    public List<Libro> obtenerPorCadena(String s);
}
