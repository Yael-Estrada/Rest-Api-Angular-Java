
package com.project.bd;

/*
 *    Libro
 *
 *    Modelo de los objetos que se almacenan en la tabla "Libro" dentro
 *    de la BD "babel".
 *    
 *   @author Yael Estrada
 *   @version 1.0
 *   @since  30/07/2021
 */
public class Libro {
    private int idLibro,idLocalizacion,volumen;
    private String titulo;
    
    /*
     *  Constructores
     *  El primero regresa un objeto vacío y el segundo inicializa los atributos
     *  conforme a los parámetros recibidos.
     */
    public Libro(){}
    public Libro(int idLibro, int idLocalizacion, int volumen, String titulo) {
        this.idLibro = idLibro;
        this.idLocalizacion = idLocalizacion;
        this.volumen = volumen;
        this.titulo = titulo;
    }

    /*
     * Getters del objeto correspondientes a cada uno de los atributos.
     */
    public int getIdLibro() {
        return idLibro;
    }

    public int getIdLocalizacion() {
        return idLocalizacion;
    }

    public int getVolumen() {
        return volumen;
    }

    public String getTitulo() {
        return titulo;
    }

    /*
     *  Setters del objeto correspondientes a cada uno de los atributos.
     */
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public void setIdLocalizacion(int idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Regresa todos los atributos del objeto en forma de cadena.
    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", idLocalizacion=" + idLocalizacion + ", volumen=" + volumen + ", titulo=" + titulo + '}';
    }
    
       
}
