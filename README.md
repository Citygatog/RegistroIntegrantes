# Sistema de Registro de Integrantes

## Descripción del proyecto

Este proyecto consiste en una aplicación de escritorio desarrollada en Java utilizando Java Swing y AWT. Su objetivo es registrar integrantes que participan en proyectos educativos, almacenando su información durante la ejecución del programa.

La aplicación cuenta con un formulario para ingresar los datos de cada integrante y una tabla para consultar los registros realizados.

## Objetivo

Desarrollar una aplicación que permita registrar y consultar integrantes de proyectos educativos, aplicando el patrón de arquitectura Modelo-Vista-Controlador (MVC).

## Funcionalidades

- Registrar nombres y apellidos de los integrantes.
- Ingresar la URL del repositorio de GitHub.
- Seleccionar el tipo de estudiante: nuevo o antiguo.
- Seleccionar el proyecto educativo correspondiente.
- Validar que los campos obligatorios estén completos.
- Validar el formato básico de la URL del repositorio.
- Almacenar los registros en un `ArrayList` durante la ejecución del programa.
- Consultar los integrantes registrados mediante una tabla.
- Limpiar los campos del formulario después de registrar un integrante.

## Tecnologías utilizadas

- **Lenguaje:** Java.
- **Interfaz gráfica:** Java Swing y AWT.
- **Estructura de datos:** ArrayList.
- **Entorno de desarrollo:** Apache NetBeans.
- **Control de versiones:** Git y GitHub.

## Estructura del proyecto

```text
RegistroIntegrantes/
├── src/
│   ├── model/
│   │   └── Integrante.java
│   ├── view/
│   │   └── FormularioIntegrante.java
│   ├── controller/
│   │   └── IntegranteController.java
│   └── RegistroIntegrantes/
│       └── Main.java
├── nbproject/
├── build.xml
├── README.md
└── evidencias/
    ├── formulario.png
    └── consulta.png
```

## Arquitectura MVC

El proyecto utiliza el patrón Modelo-Vista-Controlador (MVC), que permite organizar el código y separar las responsabilidades de cada componente.

### Modelo

La clase `Integrante.java` representa la información de cada integrante. Contiene los atributos, el constructor y los métodos necesarios para acceder y modificar sus datos.

### Vista

La clase `FormularioIntegrante.java` contiene la interfaz gráfica de la aplicación. Permite ingresar la información, seleccionar las opciones y acceder a los botones de registro, consulta y limpieza.

### Controlador

La clase `IntegranteController.java` conecta el modelo con la vista. Se encarga de validar los datos, registrar los integrantes en el `ArrayList`, limpiar el formulario y actualizar la tabla de consulta.

### Clase principal

La clase `main.java` crea los objetos necesarios e inicia la ventana principal de la aplicación.

## Validaciones y almacenamiento

Antes de registrar un integrante, el sistema verifica que los nombres, apellidos y la URL del repositorio no estén vacíos. También comprueba que se haya seleccionado el tipo de estudiante y el proyecto educativo.

Los registros se almacenan en un `ArrayList`, por lo que permanecen disponibles mientras el programa está en ejecución. Al cerrar la aplicación, la información no se conserva porque no se utiliza una base de datos ni un sistema de almacenamiento permanente.

## Instrucciones de ejecución

1. Abrir Apache NetBeans.
2. Seleccionar File → Open Project
3. Buscar la carpeta del proyecto RegistroIntegrantes
4. Abrir el proyecto.
5. Localizar la clase main.java
6. Ejecutar el proyecto utilizando la opción Run Project o ejecutar directamente la clase principal.

También se implementaron validaciones de entrada, almacenamiento temporal mediante `ArrayList` y consulta de información a través de una tabla. La separación entre modelo, vista y controlador facilita la organización, comprensión y mantenimiento del código.

Finalmente, el uso de GitHub permite compartir el código fuente y documentar el desarrollo del proyecto.
