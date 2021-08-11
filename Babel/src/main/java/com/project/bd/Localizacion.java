
package com.project.bd;


/*
 *    Localizacion
 *
 *    Modelo de los objetos que se almacenan en la tabla "Localizacion" dentro
 *    de la BD "babel".
 *    
 *   @author Yael Estrada
 *   @version 1.0
 *   @since  30/07/2021
 */
public class Localizacion {
    private int idLocalizacion,sala,estante,posicion;

    /*
     *  Constructores
     *  El primero regresa un objeto vacío y el segundo inicializa los atributos
     *  conforme a los parámetros recibidos.
     */
    public Localizacion(){}
    public Localizacion(int idLocalizacion, int sala, int estante, int posicion) {
        this.idLocalizacion = idLocalizacion;
        this.sala = sala;
        this.estante = estante;
        this.posicion = posicion;
    }
    
    /*
     * Getters del objeto correspondientes a cada uno de los atributos.
     */
    public int getIdLocalizacion() {
        return idLocalizacion;
    }

    public int getSala() {
        return sala;
    }

    public int getEstante() {
        return estante;
    }

    public int getPosicion() {
        return posicion;
    }
    
    /*
     *  Setters del objeto correspondientes a cada uno de los atributos.
     */
    public void setIdLocalizacion(int idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public void setEstante(int estante) {
        this.estante = estante;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    // Regresa todos los atributos del objeto en forma de cadena.
    @Override
    public String toString() {
        return "Localizacion{" + "idLocalizacion=" + idLocalizacion + ", sala=" + sala + ", estante=" + estante + ", posicion=" + posicion + '}';
    }
    
}
