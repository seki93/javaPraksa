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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-28 12:09:56
