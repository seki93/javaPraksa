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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-28 12:09:57
