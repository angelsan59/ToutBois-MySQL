-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 13 Octobre 2016 à 05:29
-- Version du serveur :  10.1.16-MariaDB
-- Version de PHP :  5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `toutbois`
--

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE `clients` (
  `idcli` int(11) NOT NULL,
  `actif` char(25) NOT NULL,
  `nomens` varchar(25) NOT NULL,
  `siret` int(11) NOT NULL,
  `dateder` date NOT NULL,
  `adresse1` varchar(25) NOT NULL,
  `adresse2` varchar(25) NOT NULL,
  `cp` int(11) NOT NULL,
  `ville` varchar(25) NOT NULL,
  `pays` varchar(25) NOT NULL,
  `nomcont` varchar(25) NOT NULL,
  `prenomcont` varchar(25) NOT NULL,
  `telfixe` int(11) NOT NULL,
  `telport` int(11) NOT NULL,
  `email` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `prospects`
--

CREATE TABLE `prospects` (
  `idpro` int(11) NOT NULL,
  `actif` char(25) NOT NULL,
  `nomens` varchar(25) NOT NULL,
  `siret` int(11) NOT NULL,
  `dateder` date NOT NULL,
  `adresse1` varchar(25) NOT NULL,
  `adresse2` varchar(25) NOT NULL,
  `cp` int(11) NOT NULL,
  `ville` varchar(25) NOT NULL,
  `pays` varchar(25) NOT NULL,
  `nomcont` varchar(25) NOT NULL,
  `prenomcont` varchar(25) NOT NULL,
  `telfixe` int(11) NOT NULL,
  `telport` int(11) NOT NULL,
  `email` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `representants`
--

CREATE TABLE `representants` (
  `id_rep` int(11) NOT NULL,
  `actif` char(25) NOT NULL,
  `nomrep` varchar(25) NOT NULL,
  `prenomrep` varchar(25) NOT NULL,
  `salaire` float NOT NULL,
  `txcommission` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`idcli`);

--
-- Index pour la table `prospects`
--
ALTER TABLE `prospects`
  ADD PRIMARY KEY (`idpro`);

--
-- Index pour la table `representants`
--
ALTER TABLE `representants`
  ADD PRIMARY KEY (`id_rep`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `representants`
--
ALTER TABLE `representants`
  MODIFY `id_rep` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
