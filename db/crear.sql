-- creamos la base de datos.
CREATE DATABASE IF NOT EXISTS `aplicaciones_mobiles_pf` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
-- entramos a la base de datos creada.
USE `aplicaciones_mobiles_pf`;
/*
creamos la tabla para registrar los elementos de la tabla periodica si es que no existe.
Estos son los elementos que se encuentran en la tabla periodica.
---------------------------------------------------------------
Nombre del elemento.
Símbolo químico.
Número atómico.
Peso atómico o Masa atómica.
Configuración electrónica.
Estado de agregación a temperatura ambiente.
Punto de fusión.
Punto de ebullición.
Densidad.
Valencia.
Energía de ionización.
Electronegatividad.
Radio atómico.
Isótopos.
Año de descubrimiento.
Descubridor.
Grupo y período en la tabla periódica.
Propiedades químicas.
Propiedades físicas.
Aplicaciones principales.
*/
CREATE TABLE IF NOT EXISTS `elementos` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `nombre` varchar(100) NOT NULL,
    `simbolo_quimico` varchar(10) NOT NULL,
    `numero_atomico` int(11) NOT NULL,
    `peso_atomico` decimal(10, 2) NULL,
    `configuracion_electronica` varchar(100) NULL,
    `estado_agregacion` varchar(100) NULL,
    `punto_fusion` decimal(10, 2) NULL,
    `punto_ebullicion` decimal(10, 2) NULL,
    `densidad` decimal(10, 2) NULL,
    `valencia` varchar(100) NULL,
    `energia_ionizacion` decimal(10, 2) NULL,
    `electronegatividad` decimal(10, 2) NULL,
    `radio_atomico` decimal(10, 2) NULL,
    `isotopos` varchar(100) NULL,
    `anio_descubrimiento` int(11) NULL,
    `descubridor` varchar(100) NULL,
    `grupo_periodo` varchar(100) NULL,
    `propiedades_quimicas` text NULL,
    `propiedades_fisicas` text NULL,
    `aplicaciones_principales` text NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;