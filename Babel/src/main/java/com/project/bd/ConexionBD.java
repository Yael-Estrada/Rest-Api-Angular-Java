
package com.project.bd;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
*    ConexionBD
*
*    Controlador de la conexión a la base de datos
*    Esta clase crea la conexión hacia la base de datos en MySQL llamada "babel"
*    los parámetros de conexión se encuentran dentro del archivo de configuración
*    "sql_configuracion.xml" que se encuentra en la carpeta /src/main/resources
*
*   @author Yael Estrada
*   @version 1.0
*   @since  30/07/2021
*/
public class ConexionBD {
    private static SqlSessionFactory sessionFactory = null;
    private static Reader reader;
    private static final String ARCHIVO_CONFIGURACION = "sql_configuracion.xml";
    
   /*
    *   Función que crea la sesión en la BD.
    *   @return     Objeto tipo SqlSessionFactory con el que se puede acceder
    *               a las operaciones que se implementan por medio de los servicios
    *               y mapeos a través del framework MyBatis.
    */
    
    public SqlSessionFactory crearSession(){
        try{
            reader = Resources.getResourceAsReader(ARCHIVO_CONFIGURACION);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch (IOException e){
            e.printStackTrace();
        }
        return sessionFactory;
    }
    
}
