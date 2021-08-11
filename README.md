Para correr el proyecto es necesario establecer cierta configuración:

Para la aplicación Web:

Al descomprimir el zip, ingresa la a carpeta generada e instala los modulos de node con:   npm install
Se necesita configurar el path del servidor rest:
En la carpeta src/app/services/global.ts basta con cambiar el atributo url a donde esté
corriendo la aplicacion java que hace de servidor rest.
Nota: Puede que no sea necesario cambiar éste atributo pues la aplicación java está configurada
para correr en localhost:8080 por default.

Para correr la aplicación web se usa el comando "ng serve", debes tener angular instalado en tu computadora.
Para acceder basta con entrar a http://localhost:4200 (en la terminal donde lo corres te dice en que puerto está corriendo).


Para la aplicación java:

Ruta: src/main/resources/
Se necesita configurar los siguientes archivos con los datos de acceso a mysql
Previamente ya se tiene que tener instalada la base de datos dentro del servidor de mysql.

El archivo "sql_configuracion.xml" 

<property name="url" value="jdbc:mysql://localhost:3306/babel"></property>
<property name="username" value="root"></property>
<property name="password" value="root"></property>

Y en el archivo "application.properties"

spring.datasource.url=jdbc:mysql://localhost:3306/babel
spring.datasource.username=root
spring.datasource.password=root

Estos últimos se hacen únicamente para que compile la aplicación, realmente no tienen ninguna función.

Compilar el proyecto, yo use el IDE Netbeans 12.4
Al correrlo, se puede hacer directamente desde el IDE o puedes generar el ejecutable para consola desde:
Click derecho en el proyecto Netbeans, "Run Maven" -> goals y en goals escribimos "package" y corremos.
Al finalizar el programa ejecutable estará en la ruta "target/demo*.jar" este ya se puede ejecutar directamente.
