-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: osoba
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adresa`
--

DROP TABLE IF EXISTS `adresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adresa` (
  `adresa_id` int(11) NOT NULL AUTO_INCREMENT,
  `drzava` varchar(45) NOT NULL,
  `grad` varchar(45) NOT NULL,
  `ulica` varchar(45) NOT NULL,
  `broj` int(11) NOT NULL,
  `sprat` int(11) NOT NULL,
  PRIMARY KEY (`adresa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adresa`
--

LOCK TABLES `adresa` WRITE;
/*!40000 ALTER TABLE `adresa` DISABLE KEYS */;
INSERT INTO `adresa` VALUES (111,'Srbija','Beograd','Pozeska',12,2),(112,'Srbija','Valjevo','Kneza Viseslava',10,2),(113,'Srbija','Novi Sad','Bulevar Mihajla Pupina',97,3),(114,'Srbija','Kragujevac','Bulevar Kralja Aleksandra',128,5),(115,'Srbija','Nis','Kneza Milosa',43,4);
/*!40000 ALTER TABLE `adresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `klub`
--

DROP TABLE IF EXISTS `klub`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `klub` (
  `klub_id` int(11) NOT NULL,
  `naziv` varchar(45) NOT NULL,
  `sport` varchar(45) NOT NULL,
  `adresa_id` int(11) NOT NULL,
  `liga_id` int(11) NOT NULL,
  PRIMARY KEY (`klub_id`),
  KEY `adresa_id_klub_idx` (`adresa_id`),
  KEY `liga_id_klub_idx` (`liga_id`),
  CONSTRAINT `adresa_id_klub` FOREIGN KEY (`adresa_id`) REFERENCES `adresa` (`adresa_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `liga` FOREIGN KEY (`liga_id`) REFERENCES `liga` (`liga_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klub`
--

LOCK TABLES `klub` WRITE;
/*!40000 ALTER TABLE `klub` DISABLE KEYS */;
INSERT INTO `klub` VALUES (111,'Crvena Zvezda','fudbal',113,1),(112,'Mancester United','fudbal',112,1),(113,'Chelsea','fudbal',115,2);
/*!40000 ALTER TABLE `klub` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kompanija`
--

DROP TABLE IF EXISTS `kompanija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kompanija` (
  `kompanija_id` int(11) NOT NULL,
  `naziv` varchar(45) NOT NULL,
  `adresa_id` int(11) NOT NULL,
  PRIMARY KEY (`kompanija_id`),
  KEY `adresa_id_idx` (`adresa_id`),
  CONSTRAINT `adresa_id_kompanija` FOREIGN KEY (`adresa_id`) REFERENCES `adresa` (`adresa_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kompanija`
--

LOCK TABLES `kompanija` WRITE;
/*!40000 ALTER TABLE `kompanija` DISABLE KEYS */;
INSERT INTO `kompanija` VALUES (111,'Gasprom',113),(112,'Chevrolet',112),(113,'Samsung',115),(114,'TNation',113),(1111,'Nis Petrol',114);
/*!40000 ALTER TABLE `kompanija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `liga`
--

DROP TABLE IF EXISTS `liga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `liga` (
  `liga_id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) NOT NULL,
  `rang` int(11) NOT NULL,
  `drzava` varchar(45) NOT NULL,
  PRIMARY KEY (`liga_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liga`
--

LOCK TABLES `liga` WRITE;
/*!40000 ALTER TABLE `liga` DISABLE KEYS */;
INSERT INTO `liga` VALUES (1,'Super liga',1,'Srbija'),(2,'Liga sampiona',2,'Portugal'),(3,'Liga evrope',2,'Nemacka'),(4,'Premijer liga',1,'Engleska');
/*!40000 ALTER TABLE `liga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `radnik`
--

DROP TABLE IF EXISTS `radnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `radnik` (
  `jmbg` int(11) NOT NULL,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `godine` int(11) NOT NULL,
  `adresa_id` int(11) NOT NULL,
  `kompanija_id` int(11) NOT NULL,
  `bracni_status` varchar(45) NOT NULL,
  PRIMARY KEY (`jmbg`),
  KEY `adresa_id_idx` (`adresa_id`),
  KEY `kompanija_id_idx` (`kompanija_id`),
  CONSTRAINT `adresa_id` FOREIGN KEY (`adresa_id`) REFERENCES `adresa` (`adresa_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `kompanija_id` FOREIGN KEY (`kompanija_id`) REFERENCES `kompanija` (`kompanija_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `radnik`
--

LOCK TABLES `radnik` WRITE;
/*!40000 ALTER TABLE `radnik` DISABLE KEYS */;
INSERT INTO `radnik` VALUES (125477561,'Pera','Peric',55,112,112,'Neozenjen'),(126877561,'Laza','Lazic',44,113,113,'Ozenjen'),(158477561,'Sima','Simic',32,115,111,'Neozenjen'),(195677561,'Zika','Zikic',53,111,112,'Ozenjen'),(227477561,'Mika','Mikic',40,114,113,'Neozenjen');
/*!40000 ALTER TABLE `radnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sportista`
--

DROP TABLE IF EXISTS `sportista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sportista` (
  `jmbg` int(11) NOT NULL,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `godine` int(11) NOT NULL,
  `adresa_id` int(11) NOT NULL,
  `klub_id` int(11) NOT NULL,
  PRIMARY KEY (`jmbg`),
  KEY `adresa_id_idx` (`adresa_id`),
  KEY `klub_id_sportista_idx` (`klub_id`),
  CONSTRAINT `adresa_id_sportista` FOREIGN KEY (`adresa_id`) REFERENCES `adresa` (`adresa_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `klub_id_sportista` FOREIGN KEY (`klub_id`) REFERENCES `klub` (`klub_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sportista`
--

LOCK TABLES `sportista` WRITE;
/*!40000 ALTER TABLE `sportista` DISABLE KEYS */;
INSERT INTO `sportista` VALUES (125477478,'Andrija','Pesic',28,112,111),(126877345,'Nemanja','Matic',26,113,112),(158477665,'Edin','Azar',24,115,113),(195677876,'Filip','Stojkovic',53,111,111),(227477234,'Paul','Pogba',25,114,112);
/*!40000 ALTER TABLE `sportista` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-27 10:26:44
