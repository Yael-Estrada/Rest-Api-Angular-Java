
package com.project.bd;

import java.util.List;
/*
*    ServiciosLocalizacion
*
*   Interfaz de los servicios que proporciona la Base de Datos específicamente 
*   en la tabla "Localizacion" de la BD "babel" a los que se accede gracias al 
*   framework MyBatis.
*
*   @author Yael Estrada
*   @version 1.0
*   @since  30/07/2021
*/
public interface ServiciosLocalizacion {
    //Inserta en la BD el objeto Localizacion.
    public void Insertar(Localizacion loc);
    //Borra la localizacion que tenga el id que se recibe como parámetro
    public void Borrar(int id);
    //Modifica la localización que se recibe como parámetro.
    public void Modificar(Localizacion loc);
    //Obtiene la lista de todas las Localizaciones en la tabla.
    public List<Localizacion> Obtener();
    //Obtiene la localización que tenga el id que se recibe como parámetro.
    public Localizacion ObtenerLocalizacion(int id);
    /*  Obtiene la localización (si existe) que coincida con los campos del 
     *  objeto recibido como parámetro, si no existe regresa null.
    ¨*/
    public Localizacion ExisteLocalizacion(Localizacion l);
}
