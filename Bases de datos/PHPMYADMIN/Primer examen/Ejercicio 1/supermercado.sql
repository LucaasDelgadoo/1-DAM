-- phpMyAdmin SQL Dump
-- version 5.1.1deb5ubuntu1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 03-12-2024 a las 13:42:09
-- Versión del servidor: 8.0.34-0ubuntu0.22.04.1
-- Versión de PHP: 8.1.2-1ubuntu2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `supermercado`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Producto`
--

CREATE TABLE `Producto` (
  `idProducto` int NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb3_spanish_ci NOT NULL,
  `categoria` varchar(50) COLLATE utf8mb3_spanish_ci NOT NULL,
  `precio` decimal(6,2) NOT NULL,
  `stock` int NOT NULL,
  `fechaVencimiento` date DEFAULT NULL
) ;

--
-- Volcado de datos para la tabla `Producto`
--

INSERT INTO `Producto` (`idProducto`, `nombre`, `categoria`, `precio`, `stock`, `fechaVencimiento`) VALUES
(1, 'Manzanas Golden', 'Alimentos', '1.50', 100, '2023-12-15'),
(2, 'Leche Entera', 'Bebidas', '0.90', 50, '2023-12-20'),
(3, 'Detergente Líquido', 'Limpieza', '9.99', 30, NULL),
(4, 'Champú Anticaspa', 'Higiene', '4.50', 20, NULL),
(5, 'Bayetas de Cocina', 'Hogar', '2.75', 40, NULL),
(6, 'Pasta de Dientes', 'Higiene', '2.00', 25, NULL),
(7, 'Arroz Largo', 'Alimentos', '1.25', 80, '2024-05-10'),
(8, 'Coca Cola', 'Bebidas', '1.20', 60, '2024-03-01'),
(9, 'Limpiador Multiusos', 'Limpieza', '3.99', 15, NULL),
(10, 'Esponjas de Cocina', 'Hogar', '1.00', 100, NULL),
(11, 'Cereal Integral', 'Alimentos', '3.75', 40, '2024-06-01'),
(12, 'Cerveza sin Alcohol', 'Bebidas', '1.50', 50, '2024-02-28'),
(13, 'Jabón de Manos', 'Higiene', '2.00', 60, NULL),
(14, 'Servilletas de Papel', 'Hogar', '1.80', 70, NULL),
(15, 'Lentejas', 'Alimentos', '2.90', 90, '2025-01-15'),
(16, 'Agua Mineral', 'Bebidas', '0.85', 200, '2025-12-31'),
(17, 'Lejía', 'Limpieza', '2.99', 25, NULL),
(18, 'Papel Higiénico', 'Higiene', '3.25', 35, '2025-03-15'),
(19, 'Molde deshechable', 'Hogar', '2.50', 10, NULL),
(20, 'Galletas Integrales', 'Alimentos', '2.25', 60, '2024-04-10'),
(21, 'Zumo de Naranja', 'Bebidas', '1.30', 50, '2023-12-31'),
(22, 'Quitamanchas', 'Limpieza', '4.75', 20, NULL),
(23, 'Gel de Baño', 'Higiene', '3.80', 40, NULL),
(24, 'Sopa', 'Alimentos', '1.90', 5, NULL),
(25, 'Harina de Trigo', 'Alimentos', '0.99', 120, '2024-09-01'),
(26, 'Zumo de Manzana', 'Bebidas', '6.50', 30, '2025-01-01'),
(27, 'Ambientador', 'Limpieza', '2.50', 60, NULL),
(28, 'Crema Hidratante', 'Higiene', '7.25', 20, NULL),
(29, 'Desodorante', 'Higiene', '4.00', 5, NULL),
(30, 'Plátanos', 'Alimentos', '1.10', 150, '2023-12-10');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Producto`
--
ALTER TABLE `Producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Producto`
--
ALTER TABLE `Producto`
  MODIFY `idProducto` int NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
