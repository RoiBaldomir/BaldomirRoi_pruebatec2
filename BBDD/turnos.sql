-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.11.5-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Volcando estructura para tabla turnos.ciudadano
CREATE TABLE IF NOT EXISTS `ciudadano` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `DNI` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `TELEFONO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla turnos.ciudadano: ~5 rows (aproximadamente)
INSERT INTO `ciudadano` (`ID`, `APELLIDO`, `DNI`, `NOMBRE`, `TELEFONO`) VALUES
	(1, 'Baldomir', '52345678P', 'Roi ', '635878412'),
	(2, 'López', '32456789Z', 'Javier', '623987543'),
	(3, 'Rego', '19875356K', 'Alberto', '678322156'),
	(4, 'Pérez', '65239806S', 'Daniel', '692876321'),
	(5, 'Vázquez', '97653212J', 'Cristina', '690124675');

-- Volcando estructura para tabla turnos.turno
CREATE TABLE IF NOT EXISTS `turno` (
  `NUMEROTURNO` bigint(20) NOT NULL,
  `DESCRIPCIONTRAMITE` varchar(255) DEFAULT NULL,
  `ESTADOTURNO` tinyint(1) DEFAULT 0,
  `FECHA` date DEFAULT NULL,
  `CIUDADANO_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`NUMEROTURNO`),
  KEY `FK_TURNO_CIUDADANO_ID` (`CIUDADANO_ID`),
  CONSTRAINT `FK_TURNO_CIUDADANO_ID` FOREIGN KEY (`CIUDADANO_ID`) REFERENCES `ciudadano` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla turnos.turno: ~1 rows (aproximadamente)
INSERT INTO `turno` (`NUMEROTURNO`, `DESCRIPCIONTRAMITE`, `ESTADOTURNO`, `FECHA`, `CIUDADANO_ID`) VALUES
	(1, 'Turno 1', 0, '2023-12-01', 3);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
