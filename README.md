Aplicacion para la evaluacion 1 de mapeo Objeto/relacional

Proyecto en **Java** que gestiona información de partidos, equipos, jugadores y goleadores de la ChampionsMx.  
La aplicación sigue una arquitectura organizada en capas para separar responsabilidades.

## Estructura del proyecto
ChampionsMx
│
├── .idea/ # Configuración propia de IntelliJ IDEA
├── out/ # Archivos compilados (.class)
├── src/ # Código fuente del proyecto
│ └── com.uacm.edu.championsmx
│ ├── controlador/ # Controladores que manejan la lógica de comunicación entre la vista y la capa de servicios/DAO
│ ├── dao/ # Acceso a datos (consultas SQL, conexión a la BD, CRUD)
│ ├── modelo/ # Clases del modelo (Partido, Jugador, Equipo, Goleador, etc.)
│ ├── service/ # Servicios que contienen la lógica de negocio (validaciones, cálculos, reglas)
│ └── vista/ # Interfaz gráfica (Swing)
│ ├── componentes/ # Componentes reutilizables (botones, tablas personalizadas, paneles)
│ └── modales/ # Ventanas emergentes o pantallas principales de la aplicación
│ └── VistaPrincipal # Pantalla principal de la aplicación
├── Main.java # Clase principal para iniciar la aplicación
└── ChampionsMx.iml # Archivo de configuración del proyecto en IntelliJ

## Librerias necesarias
mariadb-java-client-3.5.6  Driver para poder establecer conexión con la base de datos

## Base de datos
Maria DB
