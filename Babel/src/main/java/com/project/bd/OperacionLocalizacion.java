package com.project.bd;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/*
*    OperacionLocalizacion
*
*    Controlador de las operaciones hacia la BD
*    Esta clase implementa cada uno de los métodos que se utilizan para acceder
*    a los servicios de la BD a través del framework MyBatis.
*
*   @author Yael Estrada
*   @version 1.0
*   @since  30/07/2021
*/public class OperacionLocalizacion {
    //Constructor
    public void OperacionLocalizacion(){}
    
    /*
    *   Inserta un objeto Localizacion en la Base de datos.
    *   Para ello, crea un objeto ConexionBD para establecer conexión y una vez
    *   abierta la sesión en el objeto SqlSession, se accede al servicio Insertar de
    *   la base de datos por medio del objeto "ServiciosLocalizacion".
    *   Creamos el objeto Localizacion y lo insertamos, posteriormente consultamos
    *   para obtener su id.
    *
    *   @param  sala        atributo sala del objeto Localizacion
    *   @param  estante     atributo estante del objeto Localizacion
    *   @param  posicion    atributo posicion del objeto Localizacion
    *   @return             identificador numérico del objeto que se insertó.
    */
    public int insertLocalizacion(int sala,int estante,int posicion){
        SqlSessionFactory sessionFactory;
        ConexionBD conexion = new ConexionBD();
        sessionFactory = conexion.crearSession();
        try (SqlSession session = sessionFactory.openSession()) {
            ServiciosLocalizacion serviciolocalizacion = session.getMapper(ServiciosLocalizacion.class);
            Localizacion l=new Localizacion();
            l.setIdLocalizacion(0);
            l.setSala(sala);
            l.setEstante(estante);
            l.setPosicion(posicion);
            serviciolocalizacion.Insertar(l);
            Localizacion loc=serviciolocalizacion.ExisteLocalizacion(l);
            session.commit();
            session.close();
            return loc.getIdLocalizacion();
        } 
    }
    
     /*
    *   Elimina un objeto Localizacion en la Base de datos.
    *   Para ello, crea un objeto ConexionBD para establecer conexión y una vez
    *   abierta la sesión en el objeto SqlSession, se accede al servicio Borrar de
    *   la base de datos por medio del objeto "ServiciosLocalizacion".
    *   
    *
    *   @param  id  identificador numérico de la localizacion que se quiere borrar.
    */
    public void borrarLocalizacion(int id){
        SqlSessionFactory sessionFactory;
        ConexionBD conexion = new ConexionBD();
        sessionFactory = conexion.crearSession();
        try (SqlSession session = sessionFactory.openSession()) {
            ServiciosLocalizacion serviciolocalizacion = session.getMapper(ServiciosLocalizacion.class);
            serviciolocalizacion.Borrar(id);
            session.commit();
            session.close();
        }
    }
    
    /*
    *   Modifica un objeto Localizacion en la Base de datos.
    *   Para ello, crea un objeto ConexionBD para establecer conexión y una vez
    *   abierta la sesión en el objeto SqlSession, se accede al servicio Modificar de
    *   la base de datos por medio del objeto "ServiciosLocalizacion".
    *   Creamos el objeto Localizacion y le asignamos los parámetros recibidos, 
    *   posteriormente llamamos al servicio.
    *
    *   @param  id          identificador numérico del objeto a modificar.
    *   @param  sala        atributo sala del objeto Localizacion.
    *   @param  estante     atributo estante del objeto Localizacion.
    *   @param  posicion    atributo posicion del objeto Localizacion.
    */
    public void modificarLocalizacion(int id,int sala,int estante,int posicion){
        SqlSessionFactory sessionFactory;
        ConexionBD conexion = new ConexionBD();
        sessionFactory = conexion.crearSession();
        try (SqlSession session = sessionFactory.openSession()) {
            ServiciosLocalizacion serviciolocalizacion = session.getMapper(ServiciosLocalizacion.class);
            Localizacion l=new Localizacion();
            l.setIdLocalizacion(id);
            l.setSala(sala);
            l.setEstante(estante);
            l.setPosicion(posicion);
            serviciolocalizacion.Modificar(l);
            session.commit();
            session.close();
        }
    }
    
     /*
    *   Obtiene todos los objetos Localizacion en la tabla "Localizacion" de la
    *   Base de datos.
    *   Para ello, crea un objeto ConexionBD para establecer conexión y una vez
    *   abierta la sesión en el objeto SqlSession, se accede al servicio Obtener de
    *   la base de datos por medio del objeto "ServiciosLocalizacion".
    *   
    *
    *   @return     Lista de todas las localizaciones dentro de la tabla
    */
    public List<Localizacion> obtenerLocalizaciones(){
        SqlSessionFactory sessionFactory;
        ConexionBD conexion = new ConexionBD();
        sessionFactory = conexion.crearSession();
        try (SqlSession session = sessionFactory.openSession()) {
            ServiciosLocalizacion servicioloc = session.getMapper(ServiciosLocalizacion.class);
            List<Localizacion> locs=servicioloc.Obtener();
            session.commit();
            session.close();
            return locs;
        }
    }
    
    /*
    *   Obtiene el objeto Localizacion en la tabla "Localizacion" de la
    *   Base de datos correspondiente al id recibido como parámetro.
    *   Para ello, crea un objeto ConexionBD para establecer conexión y una vez
    *   abierta la sesión en el objeto SqlSession, se accede al servicio ObtenerLocalizacion de
    *   la base de datos por medio del objeto "ServiciosLocalizacion".
    *   
    *
    *   @return     Localización correspondiente al id recibido dentro de la tabla
    */
    public Localizacion obtenerLocalizacion(int id){
        SqlSessionFactory sessionFactory;
        ConexionBD conexion = new ConexionBD();
        sessionFactory = conexion.crearSession();
        try (SqlSession session = sessionFactory.openSession()) {
            ServiciosLocalizacion servicioloc = session.getMapper(ServiciosLocalizacion.class);
            Localizacion loc=servicioloc.ObtenerLocalizacion(id);
            session.commit();
            session.close();
            return loc;
        }
    }
    
    
    /*
    *   Obtiene el id del objeto Localizacion solicitado dentro de la tabla "Localizacion" 
    *   si existe de la Base de datos correspondiente al id recibido como parámetro.
    *   Para ello, crea un objeto ConexionBD para establecer conexión y una vez
    *   abierta la sesión en el objeto SqlSession, se accede al servicio ExisteLocalizacion de
    *   la base de datos por medio del objeto "ServiciosLocalizacion".
    *   Si el objeto no existe regresa un -1, de lo contrario regresa el id del
    *   objeto
    *
    *   @return     identificador numérico del objeto
    */
    public int existeLocalizacion(Localizacion l){
        SqlSessionFactory sessionFactory;
        ConexionBD conexion = new ConexionBD();
        sessionFactory = conexion.crearSession();
        try (SqlSession session = sessionFactory.openSession()) {
            ServiciosLocalizacion servicioloc = session.getMapper(ServiciosLocalizacion.class);
            Localizacion loc=servicioloc.ExisteLocalizacion(l);
            session.commit();
            session.close();
            return loc==null? -1:loc.getIdLocalizacion();
        }
    }
    
}
