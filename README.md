*Estacion Brava - Java Application*

*Resumen Ejecutivo*

*Descripción*
El sistema generado es de gestión para un negocio de comida que permite administrar productos y clientes. Esta aplicación es un software de escritorio basado en Java que no requiere un servidor web, ya que se ejecuta localmente desde un archivo JAR.

*Problema identificado*
El negocio carecia de un sistema eficiente para gestionar sus ventas, lo que pudo resultar en un manejo manual ineficiente. Este programa fue creado para crear una solucion eficiente y automatizada que gestione productos, clientes y la cuenta final para su venta que sea sencilla.

*Solución*
Una aplicacion en Java que permite realizar las siguientes funcionalidades:
Gestión de clientes: Agregar, modificar y eliminar clientes de la base de datos.
Gestión de ventas: Registra las ventas y mantiene un historial.

*Arquitectura*
La arquitectura de la aplicación está basada en Java y se organiza de la siguiente manera:

Java SE para la lógica de la aplicación.
Base de datos local (por ejemplo, SQLite o H2) para almacenar los datos de productos y clientes.
Interfaz de línea de comandos (CLI) para la interacción del usuario.

*Tabla de contenidos*
EN LA WIKI

*Requerimientos*
Software Requerido:
Java: 8 o superior.
Base de datos: SQLite o H2 (configurable).
Sistema operativo: Windows, Linux o macOS.

Dependencias:
Las dependencias del proyecto se gestionan mediante Maven.

*Instalación*

1. Clonar el Repositorio
2. Instalar Dependencias
Las dependencias se gestionan a través de Maven, por lo que necesitas tener Maven instalado en tu máquina. Para instalar Maven, sigue la guía oficial: Guía de instalación de Maven.
3. Generar el archivo JAR
Una vez que hayas clonado el repositorio, navega a la carpeta del proyecto y ejecuta el siguiente comando para compilar el código y generar el archivo JAR:
mvn clean package
Esto creará un archivo .jar en la carpeta target/.

*Configuración*
Configuración de la base de datos La aplicación usa una base de datos local para almacenar los productos y clientes. Por defecto, utiliza SQLite, pero puedes configurarlo para usar otro sistema de base de datos si lo deseas.

La configuración se encuentra en el archivo src/main/resources/application.properties. Aquí puedes configurar las credenciales y las opciones de la base de datos.

*Uso*
Ejecutar la aplicación Para ejecutar la aplicación, navega hasta la carpeta target/ donde se generó el archivo JAR.

*Interacción con el usuario*
La aplicación está diseñada para ejecutarse en la consola. A medida que la ejecutes, verás opciones para gestionar productos, clientes y ventas. El sistema guiará al usuario paso a paso a través de las opciones disponibles.

*Contribución*
Si deseas contribuir al proyecto, sigue estos pasos:

1. Clonar el repositorio.2
2. Crear una nueva rama
3. Commit de los cambios
4. Subir los cambios
5. Crear un Pull Request Ve a GitHub y crea un Pull Request de tu rama hacia la rama principal del repositorio.

*Roadmap*
Las siguientes funcionalidades están previstas para implementarse en futuras versiones:

Gestión de inventario avanzada: Funciones para seguimiento de stock y alertas.
Generación de reportes: Reportes automáticos de ventas, productos y clientes.
Autenticación de usuario: Implementar un sistema de inicio de sesión para usuarios administrativos.

*Acceso a la aplicacion*
Contraseña: 123456



