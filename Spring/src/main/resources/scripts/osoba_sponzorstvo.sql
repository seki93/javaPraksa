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
-- Table structure for table `sponzorstvo`
--

DROP TABLE IF EXISTS `sponzorstvo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sponzorstvo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kompanija_id` int(11) DEFAULT NULL,
  `klub_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sponzorstvo_kompanija_id_idx` (`kompanija_id`),
  KEY `sponzorstvo_klub_id_idx` (`klub_id`),
  CONSTRAINT `sponzorstvo_klub_id` FOREIGN KEY (`klub_id`) REFERENCES `klub` (`klub_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sponzorstvo_kompanija_id` FOREIGN KEY (`kompanija_id`) REFERENCES `kompanija` (`kompanija_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sponzorstvo`
--

LOCK TABLES `sponzorstvo` WRITE;
/*!40000 ALTER TABLE `sponzorstvo` DISABLE KEYS */;
INSERT INTO `sponzorstvo` VALUES (1,111,111),(2,111,112);
/*!40000 ALTER TABLE `sponzorstvo` ENABLE KEYS */;
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
