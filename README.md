# PruebaAppGate

Resumen de codificación
Proyecto de para prueba de la compañia AppGate
 
*El framework
Se utiliza como framework principal Selenium en su ultima versión 3.141.5, Selenium proporciona una herramienta de reproducción para la creación de pruebas sin la necesidad de aprender un lenguaje de scripting de prueba (Selenium IDE). También proporciona un lenguaje específico de dominio de prueba (Selenese) para escribir pruebas utilizando el lenguaje de programación Java.
 
Tambien se utiliza JUnit en su version 4.12 que nos permite realizar la ejecución de clases Java de manera controlada, para poder evaluar si el funcionamiento de cada uno de los métodos de la clase se comporta como se espera.
 
*Compilador
Se utiliza como compilador el Java SE Development Kit 8 en su version 11.0.1, El JDK incluye una JVM privada y algunos otros recursos para finalizar el desarrollo de una aplicación Java.
 
*Prácticas de automatización
La practica de automatizacion que se utiliza es:
 
* Screenplay: Es un modelo centrado en el usuario, que lo ayuda a cambiar el enfoque de las pruebas de aceptación automatizadas de interacciones de bajo nivel
con el sistema, es lo que quieren lograr con su interacción con su sistema y cómo exactamente lo van a hacer. Se utiliza esta practica por que es muy buena
y amigable con los principios SOLID, ademas de esto integra el negocio con el código y es mucho mas facil de entender, y su implementacion con DevOps tiene mucha
simpatia.
 
* Serenity BDD: Es una biblioteca de informes de código abierto que nos ayuda a escribir criterios de aceptación automatizados mejor estructurados y más sostenibles,
y también produce informes de pruebas valiosos y significativos que no solo informan sobre los resultados de las pruebas. pero también qué características han sido evaluadas. 

*Herramienta de automatización utilizado
*Selenium
*JUnit
*Serenity BDD
*ScreenPlay
*Cucumber

NOTA: TODO SE AUTOMATIZO CON LA BASE DE DATOS QUE SE CREO LOCAL

*Pasos para poder ejecutar el proyecto:
1. Descargar el pryecto
2. crear base de datos local 
se anexa script de ejemplo

create database BdPruebaAppGate

USE [BdPruebaAppGate]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblEmpleado](
	[IdEmpleado] [int] NULL,
	[Nombre] [varchar](500) NULL,
	[Meses] [int] NULL,
	[Salario] [int] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO

3. habilitar usuario sa para su conexion y su respectiva clave NOTA: RECORDAR HABILITAR LA CONEXION DE TU SQL A NIVEL LOCAL POR EL PUERTO 1433
4. en el archivo sqlserver-bd.properties debes de colocar los siguientes datos:

JDBC=jdbc:jtds:sqlserver:
BD=aqui va el nombre de la base de datos
PORT=1433
HOST=aqui va la instancia que tengas en sql
USER=sa
PASS=clave del usuario sa



*Estrategia de automatización se crean los escenarios:
-Crear empleados
el cual esta habilitado para crear los usuarios que desees segun el requerimiento
-Actualizar empleado
actualiza el empleado de la base de datos
-Listar empleados
lista todos los empleados de la base de datos
-Consulta empleado con salario menor a y con meses menor a 
consulta el empleado
-Buscar emppleado
busca el empleado con el criterio de id
-Eliminar empleado
elimina el usuario de la base de datos
 
*Archivo Jenkinsfile
este archivo contiene los pasos que se ejecutaran en el pipeline que se crea en el jenkins.
1. se crean variable de fecha
2. se crean variable de correo el cual debe estar configurado para que permirtir la salida de email por otras aplicaciones
3. se crean variable de DRunner la cual debe llevar el runner que se va a ejecutar (este nombre se debe agregar en el pipeline del jenkins ) 
4. se crea variable de WORKSPACE la cual debe de llevar el nombre del servidor dodne se almacenara las evidencias
5. recordar que para salir correos desde jenkins debes configuararlo

*Entregables:
Escenarios escritos en lenguaje Gherkin
Proyecto de automatizacion de escenarios
archivo README
Jenkinsfile
Ejercicios de programacion
Notificacion en Jenkins

*Comandos especificos para ejecución
gradle test --tests nombre del runner a ejecutar  aggregate
gradle compileJava test
gradle test aggregate
gradle build

