<?php
// Agregamos el template de la conexión
include("basedatos.php");

// Header para que el navegador sepa que se está enviando un JSON
header('Content-Type: application/json; charset=utf-8');

class Busqueda {
    private $conexion;

    public function __construct($conexion) {
        $this->conexion = $conexion;
    }

    public function buscarElementos($nombre = null, $simbolo = null, $numeroAtomico = null) {
        // Crear la consulta SQL base
        $sql = "SELECT * FROM elementos WHERE 1=1";
        
        // Condiciones para cada parámetro
        $params = [];
        if (!empty($nombre)) {
            $sql .= " AND nombre = ?";
            $params[] = $nombre;
        }
        if (!empty($simbolo)) {
            $sql .= " AND simbolo = ?";
            $params[] = $simbolo;
        }
        if (!empty($numeroAtomico)) {
            $sql .= " AND numero_atomico = ?";
            $params[] = $numeroAtomico;
        }

        // Preparar y ejecutar la consulta
        $stmt = $this->conexion->prepare($sql);
        $stmt->execute($params);
        
        // Obtener los resultados
        $resultados = $stmt->fetchAll(PDO::FETCH_ASSOC);

        // Retornar los resultados en formato JSON
        return json_encode($resultados);
    }
}

// Crear una instancia de la clase Busqueda
$conexion = new PDO('mysql:host=localhost;dbname=tu_base_datos', 'usuario', 'contraseña');
$busqueda = new Busqueda($conexion);

// Ejemplo de uso: recibir los parámetros de búsqueda desde una solicitud POST
$nombre = isset($_POST['nombre']) ? $_POST['nombre'] : null;
$simbolo = isset($_POST['simbolo']) ? $_POST['simbolo'] : null;
$numeroAtomico = isset($_POST['numero_atomico']) ? $_POST['numero_atomico'] : null;

// Llamar al método buscarElementos y mostrar el resultado
echo $busqueda->buscarElementos($nombre, $simbolo, $numeroAtomico);
?>
