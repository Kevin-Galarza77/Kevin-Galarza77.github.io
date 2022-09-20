-- phpMyAdmin SQL Dump
-- version 5.1.4
-- https://www.phpmyadmin.net/
--
-- Host: mysql-kevin2008.alwaysdata.net
-- Generation Time: Sep 06, 2022 at 06:24 AM
-- Server version: 10.6.7-MariaDB
-- PHP Version: 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kevin2008_farmacia`
--

-- --------------------------------------------------------

--
-- Table structure for table `DETALLES`
--

CREATE TABLE `DETALLES` (
  `ID` int(11) NOT NULL,
  `NUMERO` int(11) NOT NULL,
  `ID_PRODUCTO` int(11) NOT NULL,
  `CANTIDAD` int(11) DEFAULT NULL,
  `PRECIO` decimal(5,2) DEFAULT NULL,
  `TOTALDETALLE` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `DETALLES`
--

INSERT INTO `DETALLES` (`ID`, `NUMERO`, `ID_PRODUCTO`, `CANTIDAD`, `PRECIO`, `TOTALDETALLE`) VALUES
(45, 24, 123, 5, '2.90', '14.50'),
(46, 24, 124, 10, '5.50', '55.00'),
(47, 25, 123, 1, '2.90', '2.90'),
(48, 25, 111, 10, '5.20', '52.00'),
(49, 26, 124, 2, '5.50', '11.00'),
(50, 27, 125, 1, '10.20', '10.20'),
(51, 27, 124, 1, '5.50', '5.50'),
(52, 28, 123, 5, '2.90', '14.50'),
(53, 28, 127, 3, '3.20', '9.60'),
(54, 28, 1233, 1, '4.50', '4.50');

-- --------------------------------------------------------

--
-- Table structure for table `FACTURAS`
--

CREATE TABLE `FACTURAS` (
  `NUMERO` int(11) NOT NULL,
  `CEDULA_USUARIO` varchar(10) DEFAULT NULL,
  `CEDULACLIENTE` char(10) DEFAULT NULL,
  `NOMBRECLIENTE` varchar(60) DEFAULT NULL,
  `TOTALFACTURA` decimal(5,2) DEFAULT NULL,
  `IVA` decimal(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `FACTURAS`
--

INSERT INTO `FACTURAS` (`NUMERO`, `CEDULA_USUARIO`, `CEDULACLIENTE`, `NOMBRECLIENTE`, `TOTALFACTURA`, `IVA`) VALUES
(24, '1754328183', '171056935', 'Juan Perez', '77.84', '8.34'),
(25, '1754328183', '17543281', 'Mario Cardenas', '61.49', '6.59'),
(26, '1754328183', '17532689', 'Karla Sanchez', '12.32', '1.32'),
(27, '1754328183', '234354', '4534534', '17.58', '1.88'),
(28, '1754328183', '17523698', 'Marta Flores', '32.03', '3.43');

-- --------------------------------------------------------

--
-- Table structure for table `PRODUCTOS`
--

CREATE TABLE `PRODUCTOS` (
  `ID_PRODUCTO` int(11) NOT NULL,
  `NOMBRE_PRODUCTO` varchar(60) DEFAULT NULL,
  `PRECIO_PRODUCTO` decimal(5,2) DEFAULT NULL,
  `DESCRIPCION_PRODUCTO` varchar(60) DEFAULT NULL,
  `STOCK` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `PRODUCTOS`
--

INSERT INTO `PRODUCTOS` (`ID_PRODUCTO`, `NOMBRE_PRODUCTO`, `PRECIO_PRODUCTO`, `DESCRIPCION_PRODUCTO`, `STOCK`) VALUES
(1, 'Triderm', '6.80', '1x1 unidad', 50),
(2, 'Ceramid', '18.20', 'Crema hidratante', 35),
(3, 'Umbrella', '15.30', 'Protector Solar', 30),
(5, 'Pañales Huggis', '20.00', '1x20 unidades', 120),
(6, 'Systane Ultra', '9.90', 'Humectacte Visual', 10),
(7, 'Visina', '3.40', 'Humectante de ojos', 25),
(8, 'Axe', '5.25', 'Desodorante para H/M', 23),
(9, 'Nikson', '10.50', '1x12 unidades', 50),
(10, 'Pentoxifilina 400mg', '3.50', 'caja con 30 tabletas', 50),
(11, 'Emulsion Scot', '10.60', 'Vitaminas para niños', 30),
(12, 'Vibazina 20mg', '3.60', '45 tabletas', 50),
(13, 'Aspirina', '1.00', '12 tabletas', 150),
(14, 'Seroplex', '5.80', '25 tabletas', 15),
(15, 'Zaviana 10mg', '15.60', '15 tabletas', 50),
(16, 'Atorvastatina 20 mg', '4.50', '30 tabletas', 25),
(17, 'Lomotil  2mg', '8.00', '8 tabletas', 50),
(18, 'Loperan 2mg', '15.00', '30 tablertas', 25),
(19, 'Loperan 10 mg', '5.00', '15 capsulas', 25),
(20, 'Gynorelle', '10.30', '28 tabletas', 28),
(25, 'Sal Andrews', '0.25', '1x1 unidad', 200),
(26, 'Buscapina', '0.50', '1x1 unidad', 150),
(27, 'Damamime', '1.50', '1x1 unidad', 50),
(28, 'Ibuprofeno 600mg ', '3.00', '12 tabletas', 25),
(29, 'Paracetamol', '4.50', '12 tabletas', 10),
(34, 'Eucamiel 120 Ml', '7.89', 'Jarabe Natural', 50),
(52, 'Levocetrizina 5Mg', '7.30', 'Caja de 10 tabletas', 20),
(53, 'Ventolin Hinalador', '9.00', '100Mcg', 60),
(60, 'Levotrex 5Mg', '8.60', 'Caja de 10 capsulas', 60),
(111, 'Finalin Forte', '5.20', 'Caja 30 unidades', 20),
(123, 'La fem ', '2.90', 'Caja 24 unidades', 34),
(124, 'Omeprazol 200mg', '5.50', 'Caja 30 unidades', 5),
(125, 'Lubriderm ', '10.20', '1 unidad ', 15),
(126, 'Acnotin856', '30.50', 'Caja 30 unidades', 37),
(127, 'Jabon Axepcia', '3.20', '1 unidada color verde', 30),
(1233, 'Rexona', '4.50', 'Desodorante 1x1 unidad', 25);

-- --------------------------------------------------------

--
-- Table structure for table `USUARIOS`
--

CREATE TABLE `USUARIOS` (
  `CEDULA_USUARIO` varchar(10) NOT NULL,
  `NOMBRE_USUARIO` varchar(60) DEFAULT NULL,
  `ROL_USUARIO` int(11) DEFAULT NULL,
  `CONTRASENIA` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `USUARIOS`
--

INSERT INTO `USUARIOS` (`CEDULA_USUARIO`, `NOMBRE_USUARIO`, `ROL_USUARIO`, `CONTRASENIA`) VALUES
('123456789', 'Joselyn Correa', 2, '123456789'),
('1718596254', 'Irene Jimenez', 3, '1235698'),
('1721988291', 'Salomé Quispe', 3, '251402'),
('1754328183', 'Kevin Galarza', 1, '18062002');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `DETALLES`
--
ALTER TABLE `DETALLES`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_DETALLES_TIENE_FACTURAS` (`NUMERO`),
  ADD KEY `FK_DETALLES_TIENE2_PRODUCTO` (`ID_PRODUCTO`);

--
-- Indexes for table `FACTURAS`
--
ALTER TABLE `FACTURAS`
  ADD PRIMARY KEY (`NUMERO`),
  ADD KEY `FK_FACTURAS_REALIZAR_USUARIOS` (`CEDULA_USUARIO`);

--
-- Indexes for table `PRODUCTOS`
--
ALTER TABLE `PRODUCTOS`
  ADD PRIMARY KEY (`ID_PRODUCTO`);

--
-- Indexes for table `USUARIOS`
--
ALTER TABLE `USUARIOS`
  ADD PRIMARY KEY (`CEDULA_USUARIO`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `DETALLES`
--
ALTER TABLE `DETALLES`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `FACTURAS`
--
ALTER TABLE `FACTURAS`
  MODIFY `NUMERO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `DETALLES`
--
ALTER TABLE `DETALLES`
  ADD CONSTRAINT `FK_DETALLES_TIENE2_PRODUCTO` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `PRODUCTOS` (`ID_PRODUCTO`),
  ADD CONSTRAINT `FK_DETALLES_TIENE_FACTURAS` FOREIGN KEY (`NUMERO`) REFERENCES `FACTURAS` (`NUMERO`);

--
-- Constraints for table `FACTURAS`
--
ALTER TABLE `FACTURAS`
  ADD CONSTRAINT `FK_FACTURAS_REALIZAR_USUARIOS` FOREIGN KEY (`CEDULA_USUARIO`) REFERENCES `USUARIOS` (`CEDULA_USUARIO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
