-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 03 dec 2019 om 16:49
-- Serverversie: 10.1.40-MariaDB
-- PHP-versie: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vat_calculator`
--
CREATE DATABASE IF NOT EXISTS `vat_calculator` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `vat_calculator`;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `shapes`
--

CREATE TABLE `shapes` (
  `SHAPE_ID` int(11) NOT NULL,
  `SHAPE_TYPE` enum('CUBE','CYLINDER','SPHERE','CONE','PYRAMID') NOT NULL,
  `SHAPE_LENGTH` double NOT NULL DEFAULT '0',
  `SHAPE_WIDTH` double NOT NULL DEFAULT '0',
  `SHAPE_HEIGHT` double NOT NULL DEFAULT '0',
  `SHAPE_RADIUS` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `shapes`
--
ALTER TABLE `shapes`
  ADD PRIMARY KEY (`SHAPE_ID`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `shapes`
--
ALTER TABLE `shapes`
  MODIFY `SHAPE_ID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
