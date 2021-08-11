package com.project.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


/*
 *  BabelApplication
 *  Clase principal del API Rest que implementa una aplicación Spring Boot que 
 *  inicializa un servidor web en el puerto 8080 para procesar peticiones REST 
 *  de un cliente y acceder a una Base de Datos SQL por medio del framework MyBatis.
 *
 *  @author Yael Estrada
 *  @version 1.0
 *  @since  30/07/2021
*/
@SpringBootApplication
@ComponentScan()
public class BabelApplication {

	public static void main(String[] args) {
		SpringApplication.run(BabelApplication.class, args);
	}

}
