<?php
// agregamos el templete de la conexion 
include("basedatos.php");

// Clase para manejar búsquedas en la base de datos
class Busqueda
{
  // Método para construir la consulta SQL basada en los parámetros
  public function buscarElementos($nombre = null, $simbolo = null, $numeroAtomico = null)
  {
    // Iniciar la consulta
    $consulta = "SELECT * FROM elementos WHERE 1=1"; // 1=1 para evitar problemas con la primera cláusula AND

    // Crear un array para almacenar los parámetros de la consulta
    $parametros = array();
    $tipos = '';

    // Añadir condiciones a la consulta solo si los parámetros no son nulos
    if (!is_null($nombre)) {
      $consulta .= " AND nombre = ?";
      $parametros[] = $nombre;
      $tipos .= 's'; // Tipo string
    }
    if (!is_null($simbolo)) {
      $consulta .= " AND simbolo_quimico = ?";
      $parametros[] = $simbolo;
      $tipos .= 's'; // Tipo string
    }
    if (!is_null($numeroAtomico)) {
      $consulta .= " AND numero_atomico = ?";
      $parametros[] = $numeroAtomico;
      $tipos .= 'i'; // Tipo integer
    }

    // Preparar la consulta
    $stmt = mysqli_prepare($GLOBALS['conexion'], $consulta);
    if ($tipos) {
      // Vincular parámetros si existen
      mysqli_stmt_bind_param($stmt, $tipos, ...$parametros);
    }

    // Ejecutar la consulta
    mysqli_stmt_execute($stmt);
    $resultado = mysqli_stmt_get_result($stmt);

    // Crear un array para almacenar los resultados
    $elementos = array();
    while ($elemento = mysqli_fetch_assoc($resultado)) {
      $elementos[] = $elemento;
    }

    // Retornar los resultados
    return $elementos;
  }
}

// Implementación en la web
$busqueda = new Busqueda();

// Obtener los parámetros de la URL, permitiendo valores nulos
$nombre = isset($_GET['nombre']) && $_GET['nombre'] !== 'null' ? $_GET['nombre'] : null;
$simbolo = isset($_GET['simbolo']) && $_GET['simbolo'] !== 'null' ? $_GET['simbolo'] : null;
$numeroAtomico = isset($_GET['numeroAtomico']) && $_GET['numeroAtomico'] !== 'null' ? $_GET['numeroAtomico'] : null;

// Realizar la búsqueda con los parámetros proporcionados
$elementos = $busqueda->buscarElementos($nombre, $simbolo, $numeroAtomico);

// Retornar los resultados en formato JSON
header('Content-Type: application/json; charset=utf-8');
echo json_encode($elementos, JSON_UNESCAPED_UNICODE);
