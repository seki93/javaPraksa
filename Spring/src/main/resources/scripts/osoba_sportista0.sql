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

-- Dump completed on 2018-02-28 12:44:19
