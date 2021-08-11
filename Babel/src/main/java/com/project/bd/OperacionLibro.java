
package com.project.bd;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/*
*    OperacionLibro
*
*    Controlador de las operaciones hacia la BD
*    Esta clase implementa cada uno de los métodos que se utilizan para acceder
*    a los servicios de la BD a través del framework MyBatis.
*
*   @author Yael Estrada
*   @version 1.0
*   @since  30/07/2021
*/
public class OperacionLibro {
    //Constructor
    public void OperacionLibro(){}
    
    /*
    *   Inserta un objeto Libro en la Base de datos.
    *   Para ello, crea un objeto ConexionBD para establecer conexión y una vez
    *   abierta la sesión en el objeto SqlSession, se accede al servicio Insertar de
    *   la base de datos por medio del objeto "ServiciosLibro".
    *   Creamos el objeto Libro y lo insertamos, posteriormente consultamos
    *   para obtener su id.
    *
    *   @param  vol      atributo volumen del objeto Libro
    *   @param  titulo   atributo titulo del objeto Libro
    *   @param  idLoc    atributo idLocalizacion del objeto Libro
    *   @return          identificador numérico del objeto que se insertó.
    */
    public int insertLibro(int vol,String titulo,int idLoc){
        SqlSessionFactory sessionFactory;
        ConexionBD conexion = new ConexionBD();
        sessionFactory = conexion.crearSession();
        try (SqlSession session = sessionFactory.openSession()) {
            ServiciosLibro serviciolibro = session.getMapper(ServiciosLibro.class);
            Libro l=new Libro();
            l.setIdLibro(0);
            l.setVolumen(vol);
            l.setTitulo(titulo);
            l.setIdLocalizacion(idLoc);
            serviciolibro.Insertar(l);
            Libro lib=serviciolibro.existeLibro(l);
            session.commit();
            session.close();
            return lib.getIdLibro();
        }
        
    }
    /*
    *   Elimina un objeto Libro en la Base de datos.
    *   Para ello, crea un objeto ConexionBD para establecer conexión y una vez
    *   abierta la sesión en el objeto SqlSession, se accede al servicio Borrar de
    *   la base de datos por medio del objeto "ServiciosLibro".
    *   
    *
    *   @param  id  identificador numérico del libro que se quiere borrar.
    */
    public void borrarLibro(int id){
        SqlSessionFactory sessionFactory;
        ConexionBD conexion = new ConexionBD();
        sessionFactory = conexion.crearSession();
        try (SqlSession session = sessionFactory.openSession()) {
            ServiciosLibro serviciolibro = session.getMapper(ServiciosLibro.class);
            serviciolibro.Borrar(id);
            session.commit();
            session.close();
        }
    }
    
    /*
    *   Modifica un objeto Libro en la Base de datos.
    *   Para ello, crea un objeto ConexionBD para establecer conexión y una vez
    *   abierta la sesión en el objeto SqlSession, se accede al servicio Modificar de
    *   la base de datos por medio del objeto "ServiciosLibro".
    *   Creamos el objeto Libro y le asignamos los parámetros recibidos, 
    *   posteriormente llamamos al servicio.
    *
    *   @param  id       identificador numérico del objeto a modificar.
    *   @param  vol      atributo volumen del objeto Libro
    *   @param  titulo   atributo titulo del objeto Libro
    *   @param  idLoc    atributo idLocalizacion del objeto Libro
    */
    public void modificarLibro(int id,int vol,String titulo,int idLoc){
        SqlSessionFactory sessionFactory;
        ConexionBD conexion = new ConexionBD();
        sessionFactory = conexion.crearSession();
        try (SqlSession session = sessionFactory.openSession()) {
            ServiciosLibro serviciolibro = session.getMapper(ServiciosLibro.class);
            Libro l=new Libro();
            l.setIdLibro(id);
            l.setVolumen(vol);
            l.setTitulo(titulo);
            l.setIdLocalizacion(idLoc);
            serviciolibro.Modificar(l);
            session.commit();
            session.close();
        }
    }
    
    /*
    *   Obtiene todos los objetos Libro en la tabla "Libro" de la
    *   Base de datos.
    *   Para ello, crea un objeto ConexionBD para establecer conexión y una vez
    *   abierta la sesión en el objeto SqlSession, se accede al servicio Obtener de
    *   la base de datos por medio del objeto "ServiciosLibro".
    *   
    *
    *   @return     Lista de todas los libros dentro de la tabla
    */
    public List<Libro> obtenerLibros(){
        SqlSessionFactory sessionFactory;
        ConexionBD conexion = new ConexionBD();
        sessionFactory = conexion.crearSession();
        try (SqlSession session = sessionFactory.openSession()) {
            ServiciosLibro serviciolibro = session.getMapper(ServiciosLibro.class);
            List<Libro> libros=serviciolibro.Obtener();
            session.commit();
            session.close();
            return libros;
        }
    }
    
    /*
    *   Obtiene el objeto Libro en la tabla "Libro" de la
    *   Base de datos correspondiente al id recibido como parámetro.
    *   Para ello, crea un objeto ConexionBD para establecer conexión y una vez
    *   abierta la sesión en el objeto SqlSession, se accede al servicio ObtenerLibro de
    *   la base de datos por medio del objeto "ServiciosLibro".
    *   
    *
    *   @return     Libro correspondiente al id recibido dentro de la tabla
    */
    public Libro obtenerLibro(int id){
        SqlSessionFactory sessionFactory;
        ConexionBD conexion = new ConexionBD();
        sessionFactory = conexion.crearSession();
        try (SqlSession session = sessionFactory.openSession()) {
            ServiciosLibro serviciolibro = session.getMapper(ServiciosLibro.class);
            Libro libro=serviciolibro.ObtenerLibro(id);
            session.commit();
            session.close();
            return libro;
        }
    }
    
    /*
    *   Obtiene el id del objeto Libro solicitado dentro de la tabla "Libro" 
    *   si existe de la Base de datos correspondiente al id recibido como parámetro.
    *   Para ello, crea un objeto ConexionBD para establecer conexión y una vez
    *   abierta la sesión en el objeto SqlSession, se accede al servicio ExisteLibro de
    *   la base de datos por medio del objeto "ServiciosLibro".
    *   Si el objeto no existe regresa un -1, de lo contrario regresa el id del
    *   objeto
    *
    *   @return     identificador numérico del objeto
    */
    public int existeLibro(Libro l){
        SqlSessionFactory sessionFactory;
        ConexionBD conexion = new ConexionBD();
        sessionFactory = conexion.crearSession();
        try (SqlSession session = sessionFactory.openSession()) {
            ServiciosLibro serviciolibro = session.getMapper(ServiciosLibro.class);
            Libro libro=serviciolibro.existeLibro(l);
            session.commit();
            session.close();
            return libro==null? -1: libro.getIdLibro();
        }
    }
    
    /*
    *   Obtiene una lista de objetos Libro dentro de la tabla "Libro" cuyo titulo
    *   tenga alguna subcadena igual a la que se pasa como parámetro dentro de 
    *   la Base de datos.
    *   Para ello, crea un objeto ConexionBD para establecer conexión y una vez
    *   abierta la sesión en el objeto SqlSession, se accede al servicio ObtenerPorInicio de
    *   la base de datos por medio del objeto "ServiciosLibro".
    *   
    *
    *   @return     Lista de objetos libro que cumplan con la condicion.
    */
    public List<Libro> obtenerLibrosPorCadena(String s){
        SqlSessionFactory sessionFactory;
        ConexionBD conexion = new ConexionBD();
        sessionFactory = conexion.crearSession();
        try (SqlSession session = sessionFactory.openSession()) {
            ServiciosLibro serviciolibro = session.getMapper(ServiciosLibro.class);
            List<Libro> libros=serviciolibro.obtenerPorCadena(s);
            session.commit();
            session.close();
            return libros;
        }
    }
}
