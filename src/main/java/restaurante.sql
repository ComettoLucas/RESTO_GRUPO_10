-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-10-2023 a las 20:57:03
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `restaurante`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `idCategoria` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`idCategoria`, `nombre`, `estado`) VALUES
(8, 'BEBIDA', 1),
(9, 'CERVEZA', 1),
(10, 'PASTA', 1),
(11, 'MINUTA', 1),
(12, 'PRINCIPAL', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesa`
--

CREATE TABLE `mesa` (
  `idMesa` int(11) NOT NULL,
  `NroMesa` int(11) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `idReserva` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mesa`
--

INSERT INTO `mesa` (`idMesa`, `NroMesa`, `capacidad`, `estado`, `idReserva`) VALUES
(2, 0, 6, 1, 1),
(3, 1, 4, 0, NULL),
(4, 2, 4, 0, NULL),
(5, 3, 4, 0, NULL),
(6, 4, 4, 0, NULL),
(7, 5, 4, 0, NULL),
(8, 6, 4, 0, NULL),
(9, 7, 4, 0, NULL),
(10, 8, 4, 0, NULL),
(11, 9, 4, 0, NULL),
(12, 10, 4, 0, NULL),
(13, 11, 4, 0, NULL),
(14, 12, 4, 0, NULL),
(15, 13, 4, 0, NULL),
(16, 14, 4, 0, NULL),
(17, 15, 4, 0, NULL),
(18, 16, 4, 0, NULL),
(19, 17, 4, 0, NULL),
(20, 18, 4, 0, NULL),
(21, 19, 4, 0, NULL),
(22, 20, 4, 0, NULL),
(23, 21, 4, 0, NULL),
(24, 22, 4, 0, NULL),
(25, 23, 4, 0, NULL),
(26, 24, 4, 0, NULL),
(27, 25, 4, 0, NULL),
(28, 26, 4, 0, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesero`
--

CREATE TABLE `mesero` (
  `idMesero` int(11) NOT NULL,
  `NombreyApellido` varchar(60) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mesero`
--

INSERT INTO `mesero` (`idMesero`, `NombreyApellido`, `estado`) VALUES
(7, 'Lucas', 1),
(11, 'Clemente Rodriguez', 1),
(12, 'Wilmar Barrios', 1),
(13, 'Lucas Cometto', 1),
(17, 'Alejandro', 1),
(18, 'Sebas', 1),
(19, 'Facundo', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `idPedido` int(11) NOT NULL,
  `idMesa` int(11) NOT NULL,
  `idMesero` int(11) NOT NULL,
  `entregado` tinyint(1) NOT NULL,
  `pagado` tinyint(1) NOT NULL,
  `Estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`idPedido`, `idMesa`, `idMesero`, `entregado`, `pagado`, `Estado`) VALUES
(4, 2, 11, 1, 0, 1),
(7, 2, 7, 0, 0, 1),
(8, 19, 7, 0, 0, 1),
(9, 17, 7, 0, 0, 1),
(10, 12, 7, 0, 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidodetalle`
--

CREATE TABLE `pedidodetalle` (
  `idPedidoDetalle` int(11) NOT NULL,
  `idPedido` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `totalPedido` double NOT NULL,
  `cantidad` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `Nombre` varchar(60) NOT NULL,
  `CantidadenStock` int(11) NOT NULL,
  `Precio` double NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `idCategoria`, `Nombre`, `CantidadenStock`, `Precio`, `estado`) VALUES
(10, 10, 'pasta', 4, 2345, 1),
(11, 8, 'Manaos', 3, 10000000, 1),
(12, 11, 'Cerezas', 66778, 12, 1),
(13, 12, 'Calamardo', 1, 478, 1),
(14, 12, 'Panchinesa', 33, 987, 1),
(15, 11, 'Empanadas', 99998, 900, 1),
(16, 8, 'Chancho frio', 11, 6789, 1),
(17, 9, 'Brahma', 11, 456, 1),
(18, 10, 'Perpermet', 123, 77866, 1),
(19, 12, 'Cucaraha en caca de ballena', 2, 5566775665, 1),
(20, 12, 'Pastel de pap', 4, 3344, 1),
(21, 12, 'Churrasco con  arroz', 2234, 56, 1),
(22, 8, 'Cocacola', 77, 677, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL,
  `nombreApellido` varchar(60) NOT NULL,
  `dni` int(11) NOT NULL,
  `fechaHora` date NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`idReserva`, `nombreApellido`, `dni`, `fechaHora`, `estado`) VALUES
(1, 'Alex Canillia', 33445566, '2023-10-25', 1),
(2, 'Juan Perez', 331122445, '2024-01-30', 1),
(3, 'Otro Juan Perez', 55667788, '2025-02-25', 1),
(4, 'Pepito Mandarin', 55667788, '2034-11-05', 1),
(5, 'Bruno Diaz', 55667568, '2025-10-12', 1),
(6, 'Peter Parker', 43667989, '2024-04-07', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indices de la tabla `mesa`
--
ALTER TABLE `mesa`
  ADD PRIMARY KEY (`idMesa`),
  ADD KEY `idReserva` (`idReserva`);

--
-- Indices de la tabla `mesero`
--
ALTER TABLE `mesero`
  ADD PRIMARY KEY (`idMesero`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`idPedido`),
  ADD KEY `idMesero` (`idMesero`),
  ADD KEY `pedido_ibfk_1` (`idMesa`);

--
-- Indices de la tabla `pedidodetalle`
--
ALTER TABLE `pedidodetalle`
  ADD PRIMARY KEY (`idPedidoDetalle`),
  ADD KEY `idProducto` (`idProducto`),
  ADD KEY `idPedido` (`idPedido`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `idCategoria` (`idCategoria`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`idReserva`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `mesa`
--
ALTER TABLE `mesa`
  MODIFY `idMesa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `mesero`
--
ALTER TABLE `mesero`
  MODIFY `idMesero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `idPedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `pedidodetalle`
--
ALTER TABLE `pedidodetalle`
  MODIFY `idPedidoDetalle` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `idReserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `mesa`
--
ALTER TABLE `mesa`
  ADD CONSTRAINT `mesa_ibfk_1` FOREIGN KEY (`idReserva`) REFERENCES `reserva` (`idReserva`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`idMesa`) REFERENCES `mesa` (`idMesa`),
  ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`idMesero`) REFERENCES `mesero` (`idMesero`);

--
-- Filtros para la tabla `pedidodetalle`
--
ALTER TABLE `pedidodetalle`
  ADD CONSTRAINT `pedidodetalle_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`),
  ADD CONSTRAINT `pedidodetalle_ibfk_3` FOREIGN KEY (`idPedido`) REFERENCES `pedido` (`idPedido`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`idCategoria`) REFERENCES `categorias` (`idCategoria`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
