<?php

// creamos el templete para la conexion a la base de datos.
$host = "192.200.1.4"; // ip del servidor no del anfitrion.
$usuario = "user"; // usuario de la base de datos.
$clave = "user"; // contrase;a de la base de datos.
$bd = "aplicaciones_mobiles_pf"; // nombre de la base de datos.
$conexion = mysqli_connect($host, $usuario, $clave, $bd); // coneccion a la base de datos.

if (!$conexion) {
  die("Error al conectar a la base de datos: " . mysqli_connect_error());
} // verificacion de la base de datos. 