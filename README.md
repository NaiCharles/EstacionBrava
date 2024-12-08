Descripcion

Este proyecto tiene como objetivo desarrollar una aplicación de escritorio con interfaz gráfica en Java para la gestión de usuarios, productos en inventarios, transacciones financieras, y generación de reportes. La solución permite a los administradores agregar o eliminar usuarios, productos e ingresos o egresos financieros, y consultar reportes detallados sobre el estado del inventario y las finanzas.

Problema idemtificado

En muchos entornos comerciales, la gestión de inventarios y la administración financiera requieren herramientas fáciles de usar pero potentes. A menudo, las soluciones existentes son demasiado complejas o costosas, lo que dificulta la adopción en pequeñas y medianas empresas.

Solucion

La aplicación proporciona una solución sencilla e intuitiva para administrar inventarios, usuarios y finanzas. Utiliza una interfaz gráfica basada en Swing para facilitar la interacción del usuario. Ofrece funcionalidades clave como la gestión de productos, control de saldo financiero, y reportes detallados.

Arquitectura

La arquitectura de la aplicación está basada en un patrón de diseño MVC, donde
*Modelo:* Maneja la lógica de negocio, almacenamiento de datos (usuarios, productos, finanzas).
*Vista:* Interfaz gráfica construida con Swing.
*Controlador:* Gestiona los eventos de la interfaz y comunica las acciones del usuario con el modelo.

1. [Requerimientos](#requerimientos)
2. [Instalación](#instalación)
3. [Configuración](#configuración)
4. [Uso](#uso)
5. [Contribución](#contribución)
6. [Roadmap](#roadmap)
7. [Demostración](#demostración)

- [Wiki del proyecto en GitHub](https://github.com/NaiCharles/EstacionBrava/wiki

Requerimientos

Servidores de aplicación

No se requiere un servidor de aplicación, ya que la aplicación es de escritorio.

Servidores Web

No se requiere un servidor web.

Bases de datos
La aplicación no utiliza bases de datos externas, almacena los datos de usuarios, inventarios y finanzas en memoria durante la ejecución.

Paquetes adicionales

*Java SE 8 o superior.*
*Swing:* Para la creación de la interfaz gráfica.

Versión de Java

Java 8 o superior es requerido para ejecutar la aplicación.

¿Cómo instalar el ambiente de desarrollo?

1. **Instalar Java 8 o superior**: 
   Asegúrate de tener instalado el JDK de Java 8 o superior. Puedes descargarlo desde [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html).
   Asegurate de tener instalado Eclipse IDE. Puedes descargarlo desde [EclipseIDE](https://www.eclipse.org/downloads/).

3. **Descargar el proyecto**:
   Clona el repositorio ejecutando:
   ```bash
   git clone https://github.com/NaiCharles/EstacionBrava

¿Cómo ejecutar pruebas manualmente?

En Eclipse IDE, darle al boton de Start

¿Cómo implementar la solución en producción en un ambiente local o en la nube como Heroku?

Para implementar la aplicación en producción, simplemente sigue estos pasos para generar el archivo JAR y distribuirlo:

Generar archivo JAR:

En tu IDE, crea un archivo JAR ejecutable para la aplicación.
Si usas la línea de comandos, ejecuta:
jar -cvf InventarioFinanzas.jar -C bin .


Configuración del producto

Los datos como los usuarios, productos y transacciones son almacenados en memoria durante la ejecución de la aplicación.

Configuración de los requerimientos

No es necesario configurar ningún archivo externo para ejecutar la aplicación.

Sección de referencia para usuario final. Manual que se hará referencia para usuarios finales.

Para iniciar el programa, tendra que: 1.- Ingresar su usuario y contraseña (adjuntado en la entrega del programa como primer usuario).

usuario: admin
contraseña: admin123

Sección de referencia para usuario administrador.

Sera el mismo, como se indico, solamente tendra accesos los administradores.

Guía de contribución para usuarios.

Ingrese a Git Bash
Conar el repositorio con: git clone https://github.com/tu-usuario/proyecto.git

Crear el nuevo brench: git checkout -b nombre-de-tu-branch

Realizar cambios y hacer commit: git add .
git commit -m "Descripción de los cambios"

Enviar el Pull Request:

Ve al repositorio en GitHub y envía el Pull Request.

Esperar la revisión: El Pull Request será revisado y fusionado por los mantenedores del repositorio.


Requerimientos que se implementarán en un futuro.

Mejoras en la interfaz gráfica: Añadir más colores, íconos y optimizar la experiencia del usuario.
Autenticación avanzada: Implementar un sistema de autenticación con roles más específicos y contraseñas seguras.

Para iniciar el programa, tendra que: 1.- Ingresar su usuario y contraseña (adjuntado en la entrega del programa como primer usuario).

usuario: admin
contraseña: admin123

-- Opcion 1 "Usuarios"

El programa le pedira nombre y contraseña para agregar algun usuario.
El programa si desea quitar alguno, le pedira el nombre.
El programa le permite ver los usuarios registrados al darle click en "Ver usuarios"

-- Opcion 2 "Inventario"

El programa le pedira el nombre del producto y cuanta cantidad si presiona la opcion de "Agregar producto"
El programa le solicitara el nombre y cantidada a quitar de producto/s al presionar la opcion "Quitar producto"
El programa le permite ver el inventario disponible.

-- Opcion 3 "Fianzas"

Agregar dinero: Le pide el motivo y la cantidad.
Quitar dinero: Le solicita el monto y motivo del retiro.

-- Opcion 4 "Reportes"

Al ingresar, le muestra el reporte del dinero, le genera el dinero actual, los retiros, ingresos, motivo, fecha y cantidad.

-- Opcion 5 "Salir"

El sistema sale del sistema.


Sin mas que añadir, les mando un saludo cordial de mi parte. Ian Jeremi Pérez Charles.
