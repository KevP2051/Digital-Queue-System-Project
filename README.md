# Sistema de turnos digitales.
## Descripción
Este proyecto consiste en un sistema de turnos digitales y su finalidad es analizar el funcionamiento de las colas de la coleccion de java
## Pre-requisitos
- JDK 21
## Información del proyecto
### Versiones.
Actualmente solo se encuentra disponible una versión del proyecto, que cuenta con funcionalidades y una interfaz de usuario básicas.
### Estructura del código.
El código fuente del proyecto se encuentra escrito en el lenguaje Java, bajo el paradigma de Programación Orientada a Objetos (POO) y empleando una arquitectura basada en 3 capas.
### Manejo de la información.
La información se gestiona exclusivamente en memoria, utilizando principalmente la estructura de datos LinkedList de la colección de Java.
Al ingresar a la aplicación, lo primero que aparecera sera un menu solicitando el tipo de usuario que desea utilizar la aplicacion, en este punto seleccionamos el tipo de uso que le vamos a dar a la aplicacion. 

*Tener en cuenta que por el momento la aplicacion solo posee un usuario administrativo y no existe una funcion para crear mas, entonces cuando se vaya a utilizar esta funcion el sistema nos pedira un tipo de documento, numero de documento y contraseña, para nuestro caso el tipo de documento sera "CC", el numero de documento sera "23412035" y la contraseña sera "admin123".*

*NOTA: Al estar la información siendo manejada únicamente en memoria, el sistema no almacena nada y en cada ejecución se debe cargar con datos.*
### Interfaz.

La interfaz se encuentra desarrollada con ayuda de la librería de Java Swing y la clase JOptionPane. La manera en la que se navega a través de los menús y funcionalidades del proyecto es ingresando comandos numéricos.

#### Interfaz de usuario.

En esta interfaz encontraremos un menu en el cual nos dira cual es el turno actual y nos encontraremos con una sola opcion la cual sera "Solicitar turno" la cual seleccionaremos marcando el numero 1 y dando aceptar. Despues de esto nos pedira unos datos y al final nos asignara el numero de turno que nos corresponde.

#### Interfaz de administrativo

En esta interfaz encontraremos al igual que el anterior un menu que nos dira el turno actual, pero en esta encontraremos 3 opciones la cuales seleccionares marcando el numero al que segun correspondan. Para este caso el 1 sera para pasar al siguiente turno, el 2 para reiniciar el numero de turno y el 3 para regresar al menu principal.

### Funcionalidades del proyecto.
Las funcionalidades del proyecto y los métodos de la clase LinkedList que implementan para llevarse a cabo, son los siguientes:
- (offer) Crear un nuevo turno.
- (poll) Pasar al siguiente turno y eliminar el turno que acabo de pasar.

## Recomendaciones
- Dado que el programa se encuentra realizado bajo la arquitectura de 3 capas, se sugiere tener precaución a la hora de realizar cambios de diseño en cuanto a vista o propiamente el modelo, debido al alto acoplamiento existente.
- El proyecto maneja toda su información únicamente en memoria, por lo que los datos no se están almacenando y en cada ejecución se deben volver a agregar.
