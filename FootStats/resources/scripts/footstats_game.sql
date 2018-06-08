-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: footstats
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
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `awayclub_id` int(11) DEFAULT NULL,
  `homeclub_id` int(11) DEFAULT NULL,
  `referee_id` int(11) DEFAULT NULL,
  `matchstats_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_434omus1a6qf88kutw29qxv1e` (`homeclub_id`),
  KEY `FK_iavh8rdhs7upbfwk7kps10to7` (`referee_id`),
  KEY `FK_mbp9rn05wat8rj8xfpyi0v9vk` (`awayclub_id`),
  KEY `game_matchstats` (`matchstats_id`),
  CONSTRAINT `FK_434omus1a6qf88kutw29qxv1e` FOREIGN KEY (`homeclub_id`) REFERENCES `club` (`id`),
  CONSTRAINT `FK_iavh8rdhs7upbfwk7kps10to7` FOREIGN KEY (`referee_id`) REFERENCES `referee` (`id`),
  CONSTRAINT `FK_mbp9rn05wat8rj8xfpyi0v9vk` FOREIGN KEY (`awayclub_id`) REFERENCES `club` (`id`),
  CONSTRAINT `game_matchstats` FOREIGN KEY (`matchstats_id`) REFERENCES `matchstats` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1409 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,66,43,NULL,1,'2018-05-13'),(2,225,36,NULL,2,'2018-05-13'),(3,2,226,NULL,3,'2018-05-13'),(4,227,5,NULL,4,'2018-05-13'),(5,42,1,NULL,5,'2018-05-13'),(6,9,228,NULL,6,'2018-05-13'),(7,4,17,NULL,7,'2018-05-13'),(8,230,229,NULL,8,'2018-05-13'),(9,232,231,NULL,9,'2018-05-13'),(10,11,233,NULL,10,'2018-05-13'),(11,1,233,NULL,11,'2018-05-10'),(12,227,4,NULL,12,'2018-05-09'),(13,228,231,NULL,13,'2018-05-09'),(14,226,9,NULL,14,'2018-05-09'),(15,2,232,NULL,15,'2018-05-09'),(16,17,229,NULL,16,'2018-05-08'),(17,43,2,NULL,17,'2018-05-06'),(18,5,9,NULL,18,'2018-05-06'),(19,226,4,NULL,19,'2018-05-06'),(20,17,11,NULL,20,'2018-05-05'),(21,229,66,NULL,21,'2018-05-05'),(22,233,232,NULL,22,'2018-05-05'),(23,228,42,NULL,23,'2018-05-05'),(24,231,225,NULL,24,'2018-05-05'),(25,36,230,NULL,25,'2018-05-05'),(26,1,227,NULL,26,'2018-05-04'),(27,42,231,NULL,27,'2018-04-30'),(28,2,1,NULL,28,'2018-04-29'),(29,4,233,NULL,29,'2018-04-29'),(30,9,229,NULL,30,'2018-04-28'),(31,227,43,NULL,31,'2018-04-28'),(32,232,36,NULL,32,'2018-04-28'),(33,11,226,NULL,33,'2018-04-28'),(34,225,228,NULL,34,'2018-04-28'),(35,66,17,NULL,35,'2018-04-28'),(36,230,5,NULL,36,'2018-04-28'),(37,228,11,NULL,37,'2018-04-23'),(38,229,4,NULL,38,'2018-04-22'),(39,233,2,NULL,39,'2018-04-22'),(40,43,230,NULL,40,'2018-04-22'),(41,36,42,NULL,41,'2018-04-21'),(42,5,225,NULL,42,'2018-04-21'),(43,9,43,NULL,43,'2018-04-19'),(44,17,232,NULL,44,'2018-04-19'),(45,1,66,NULL,45,'2018-04-18'),(46,231,227,NULL,46,'2018-04-17'),(47,230,233,NULL,47,'2018-04-16'),(48,225,1,NULL,48,'2018-04-15'),(49,2,228,NULL,49,'2018-04-15'),(50,4,231,NULL,50,'2018-04-14'),(51,66,5,NULL,51,'2018-04-14'),(52,232,43,NULL,52,'2018-04-14'),(53,227,36,NULL,53,'2018-04-14'),(54,42,226,NULL,54,'2018-04-14'),(55,11,229,NULL,55,'2018-04-14'),(56,9,17,NULL,56,'2018-04-14'),(57,233,9,NULL,57,'2018-04-08'),(58,17,2,NULL,58,'2018-04-08'),(59,1,4,NULL,59,'2018-04-07'),(60,36,66,NULL,60,'2018-04-07'),(61,226,227,NULL,61,'2018-04-07'),(62,228,232,NULL,62,'2018-04-07'),(63,231,230,NULL,63,'2018-04-07'),(64,43,42,NULL,64,'2018-04-07'),(65,229,225,NULL,65,'2018-04-07'),(66,5,11,NULL,66,'2018-04-07'),(67,231,9,NULL,67,'2018-04-01'),(68,230,2,NULL,68,'2018-04-01'),(69,4,11,NULL,69,'2018-03-31'),(70,232,227,NULL,70,'2018-03-31'),(71,229,1,NULL,71,'2018-03-31'),(72,226,228,NULL,72,'2018-03-31'),(73,66,42,NULL,73,'2018-03-31'),(74,43,225,NULL,74,'2018-03-31'),(75,17,233,NULL,75,'2018-03-31'),(76,5,36,NULL,76,'2018-03-31'),(77,42,5,NULL,77,'2018-03-17'),(78,225,66,NULL,78,'2018-03-17'),(79,36,226,NULL,79,'2018-03-17'),(80,11,230,NULL,80,'2018-03-17'),(81,4,230,NULL,81,'2018-03-12'),(82,231,66,NULL,82,'2018-03-11'),(83,42,2,NULL,83,'2018-03-11'),(84,36,9,NULL,84,'2018-03-10'),(85,227,11,NULL,85,'2018-03-10'),(86,229,226,NULL,86,'2018-03-10'),(87,17,228,NULL,87,'2018-03-10'),(88,232,225,NULL,88,'2018-03-10'),(89,43,233,NULL,89,'2018-03-10'),(90,5,1,NULL,90,'2018-03-10'),(91,1,36,NULL,91,'2018-03-05'),(92,244,2668,NULL,92,'2018-05-21'),(93,234,176,NULL,93,'2018-05-12'),(94,2668,244,NULL,94,'2018-05-17'),(95,235,179,NULL,95,'2018-05-12'),(96,237,236,NULL,96,'2018-05-12'),(97,238,171,NULL,97,'2018-05-12'),(98,175,239,NULL,98,'2018-05-12'),(99,241,240,NULL,99,'2018-05-12'),(100,167,242,NULL,100,'2018-05-12'),(101,169,243,NULL,101,'2018-05-12'),(102,245,244,NULL,102,'2018-05-12'),(103,243,237,NULL,103,'2018-05-05'),(104,236,238,NULL,104,'2018-05-05'),(105,242,241,NULL,105,'2018-05-05'),(106,171,169,NULL,106,'2018-05-05'),(107,179,245,NULL,107,'2018-05-05'),(108,239,234,NULL,108,'2018-05-05'),(109,244,175,NULL,109,'2018-05-05'),(110,240,235,NULL,110,'2018-05-05'),(111,176,167,NULL,111,'2018-05-05'),(112,241,167,NULL,112,'2018-04-29'),(113,175,242,NULL,113,'2018-04-29'),(114,235,176,NULL,114,'2018-04-28'),(115,169,179,NULL,115,'2018-04-28'),(116,245,236,NULL,116,'2018-04-28'),(117,237,239,NULL,117,'2018-04-28'),(118,238,243,NULL,118,'2018-04-28'),(119,171,244,NULL,119,'2018-04-28'),(120,234,240,NULL,120,'2018-04-27'),(121,243,245,NULL,121,'2018-04-22'),(122,242,237,NULL,122,'2018-04-22'),(123,176,241,NULL,123,'2018-04-21'),(124,239,169,NULL,124,'2018-04-21'),(125,236,171,NULL,125,'2018-04-21'),(126,179,234,NULL,126,'2018-04-21'),(127,240,175,NULL,127,'2018-04-21'),(128,167,235,NULL,128,'2018-04-21'),(129,244,238,NULL,129,'2018-04-20'),(130,236,242,NULL,130,'2018-04-16'),(131,175,167,NULL,131,'2018-04-15'),(132,241,243,NULL,132,'2018-04-15'),(133,238,179,NULL,133,'2018-04-14'),(134,169,176,NULL,134,'2018-04-14'),(135,245,239,NULL,135,'2018-04-14'),(136,171,240,NULL,136,'2018-04-14'),(137,234,235,NULL,137,'2018-04-14'),(138,237,244,NULL,138,'2018-04-13'),(139,176,175,NULL,139,'2018-04-09'),(140,240,169,NULL,140,'2018-04-08'),(141,235,241,NULL,141,'2018-04-08'),(142,243,171,NULL,142,'2018-04-07'),(143,179,237,NULL,143,'2018-04-07'),(144,239,238,NULL,144,'2018-04-07'),(145,242,245,NULL,145,'2018-04-07'),(146,244,236,NULL,146,'2018-04-07'),(147,167,234,NULL,147,'2018-04-06'),(148,238,242,NULL,148,'2018-04-01'),(149,169,167,NULL,149,'2018-04-01'),(150,244,239,NULL,150,'2018-03-31'),(151,241,179,NULL,151,'2018-03-31'),(152,237,176,NULL,152,'2018-03-31'),(153,175,234,NULL,153,'2018-03-31'),(154,245,240,NULL,154,'2018-03-31'),(155,236,243,NULL,155,'2018-03-31'),(156,171,235,NULL,156,'2018-03-31'),(157,179,175,NULL,157,'2018-03-18'),(158,176,245,NULL,158,'2018-03-18'),(159,234,241,NULL,159,'2018-03-18'),(160,243,244,NULL,160,'2018-03-17'),(161,167,237,NULL,161,'2018-03-17'),(162,240,238,NULL,162,'2018-03-17'),(163,242,169,NULL,163,'2018-03-17'),(164,239,171,NULL,164,'2018-03-17'),(165,235,236,NULL,165,'2018-03-16'),(166,245,167,NULL,166,'2018-03-12'),(167,169,241,NULL,167,'2018-03-11'),(168,175,235,NULL,168,'2018-03-11'),(169,238,176,NULL,169,'2018-03-10'),(170,171,179,NULL,170,'2018-03-10'),(171,237,234,NULL,171,'2018-03-10'),(172,236,239,NULL,172,'2018-03-10'),(173,244,240,NULL,173,'2018-03-10'),(174,243,242,NULL,174,'2018-03-09'),(175,179,236,NULL,175,'2018-03-04'),(176,235,245,NULL,176,'2018-03-04'),(177,241,175,NULL,177,'2018-03-03'),(178,240,237,NULL,178,'2018-03-03'),(179,234,169,NULL,179,'2018-03-03'),(180,242,171,NULL,180,'2018-03-03'),(181,239,243,NULL,181,'2018-03-03'),(182,176,244,NULL,182,'2018-03-03'),(183,167,238,NULL,183,'2018-03-02'),(184,237,241,NULL,184,'2018-02-26'),(185,245,175,NULL,185,'2018-02-25'),(186,243,176,NULL,186,'2018-02-25'),(187,171,167,NULL,187,'2018-02-24'),(188,239,179,NULL,188,'2018-02-24'),(189,238,234,NULL,189,'2018-02-24'),(190,236,240,NULL,190,'2018-02-24'),(191,169,235,NULL,191,'2018-02-24'),(192,244,242,NULL,192,'2018-02-23'),(193,175,169,NULL,193,'2018-02-19'),(194,241,238,NULL,194,'2018-02-18'),(195,235,237,NULL,195,'2018-02-18'),(196,240,243,NULL,196,'2018-02-17'),(197,234,245,NULL,197,'2018-02-17'),(198,167,236,NULL,198,'2018-02-17'),(199,176,171,NULL,199,'2018-02-17'),(200,179,244,NULL,200,'2018-02-17'),(201,242,239,NULL,201,'2018-02-16'),(202,244,167,NULL,202,'2018-02-11'),(203,238,235,NULL,203,'2018-02-11'),(204,243,179,NULL,204,'2018-02-10'),(205,239,176,NULL,205,'2018-02-10'),(206,171,241,NULL,206,'2018-02-10'),(207,245,169,NULL,207,'2018-02-10'),(208,236,234,NULL,208,'2018-02-10'),(209,242,240,NULL,209,'2018-02-10'),(210,237,175,NULL,210,'2018-02-09'),(211,234,171,NULL,211,'2018-02-04'),(212,169,237,NULL,212,'2018-02-04'),(213,175,238,NULL,213,'2018-02-03'),(214,176,236,NULL,214,'2018-02-03'),(215,240,239,NULL,215,'2018-02-03'),(216,179,242,NULL,216,'2018-02-03'),(217,167,243,NULL,217,'2018-02-03'),(218,235,244,NULL,218,'2018-02-03'),(219,241,245,NULL,219,'2018-02-02'),(220,244,234,NULL,220,'2018-01-28'),(221,242,176,NULL,221,'2018-01-28'),(222,239,167,NULL,222,'2018-01-27'),(223,240,179,NULL,223,'2018-01-27'),(224,236,241,NULL,224,'2018-01-27'),(225,237,245,NULL,225,'2018-01-27'),(226,171,175,NULL,226,'2018-01-27'),(227,243,235,NULL,227,'2018-01-27'),(228,238,169,NULL,228,'2018-01-26'),(229,234,243,NULL,229,'2018-01-21'),(230,167,179,NULL,230,'2018-01-21'),(231,245,171,NULL,231,'2018-01-20'),(232,237,238,NULL,232,'2018-01-20'),(233,175,236,NULL,233,'2018-01-20'),(234,176,240,NULL,234,'2018-01-20'),(235,235,242,NULL,235,'2018-01-20'),(236,169,244,NULL,236,'2018-01-20'),(237,241,239,NULL,237,'2018-01-19'),(238,244,241,NULL,238,'2018-01-14'),(239,238,245,NULL,239,'2018-01-14'),(240,243,175,NULL,240,'2018-01-13'),(241,171,237,NULL,241,'2018-01-13'),(242,236,169,NULL,242,'2018-01-13'),(243,242,234,NULL,243,'2018-01-13'),(244,239,235,NULL,244,'2018-01-13'),(245,240,167,NULL,245,'2018-01-13'),(246,179,176,NULL,246,'2018-01-12'),(247,239,175,NULL,247,'2017-12-17'),(248,176,234,NULL,248,'2017-12-17'),(249,240,241,NULL,249,'2017-12-16'),(250,236,237,NULL,250,'2017-12-16'),(251,243,169,NULL,251,'2017-12-16'),(252,244,245,NULL,252,'2017-12-16'),(253,179,235,NULL,253,'2017-12-16'),(254,242,167,NULL,254,'2017-12-16'),(255,171,238,NULL,255,'2017-12-15'),(256,167,176,NULL,256,'2017-12-13'),(257,245,179,NULL,257,'2017-12-13'),(258,234,239,NULL,258,'2017-12-13'),(259,237,243,NULL,259,'2017-12-13'),(260,235,240,NULL,260,'2017-12-13'),(261,238,236,NULL,261,'2017-12-12'),(262,169,171,NULL,262,'2017-12-12'),(263,241,242,NULL,263,'2017-12-12'),(264,175,244,NULL,264,'2017-12-12'),(265,239,237,NULL,265,'2017-12-10'),(266,240,234,NULL,266,'2017-12-10'),(267,236,245,NULL,267,'2017-12-10'),(268,243,238,NULL,268,'2017-12-09'),(269,167,241,NULL,269,'2017-12-09'),(270,179,169,NULL,270,'2017-12-09'),(271,244,171,NULL,271,'2017-12-09'),(272,242,175,NULL,272,'2017-12-09'),(273,176,235,NULL,273,'2017-12-08'),(274,238,244,NULL,274,'2017-12-03'),(275,169,239,NULL,275,'2017-12-03'),(276,245,243,NULL,276,'2017-12-02'),(277,241,176,NULL,277,'2017-12-02'),(278,234,179,NULL,278,'2017-12-02'),(279,175,240,NULL,279,'2017-12-02'),(280,237,242,NULL,280,'2017-12-02'),(281,235,167,NULL,281,'2017-12-02'),(282,171,236,NULL,282,'2017-12-01'),(283,239,245,NULL,283,'2017-11-26'),(284,240,171,NULL,284,'2017-11-26'),(285,179,238,NULL,285,'2017-11-25'),(286,244,237,NULL,286,'2017-11-25'),(287,243,241,NULL,287,'2017-11-25'),(288,176,169,NULL,288,'2017-11-25'),(289,242,236,NULL,289,'2017-11-25'),(290,167,175,NULL,290,'2017-11-25'),(291,235,234,NULL,291,'2017-11-24'),(292,234,167,NULL,292,'2017-11-19'),(293,171,243,NULL,293,'2017-11-19'),(294,238,239,NULL,294,'2017-11-18'),(295,175,176,NULL,295,'2017-11-18'),(296,237,179,NULL,296,'2017-11-18'),(297,169,240,NULL,297,'2017-11-18'),(298,245,242,NULL,298,'2017-11-18'),(299,236,244,NULL,299,'2017-11-18'),(300,241,235,NULL,300,'2017-11-17'),(301,239,244,NULL,301,'2017-11-05'),(302,240,245,NULL,302,'2017-11-05'),(303,179,241,NULL,303,'2017-11-04'),(304,176,237,NULL,304,'2017-11-04'),(305,242,238,NULL,305,'2017-11-04'),(306,243,236,NULL,306,'2017-11-04'),(307,235,171,NULL,307,'2017-11-04'),(308,234,175,NULL,308,'2017-11-04'),(309,167,169,NULL,309,'2017-11-03'),(310,236,235,NULL,310,'2017-10-29'),(311,237,167,NULL,311,'2017-10-29'),(312,175,179,NULL,312,'2017-10-28'),(313,245,176,NULL,313,'2017-10-28'),(314,241,234,NULL,314,'2017-10-28'),(315,171,239,NULL,315,'2017-10-28'),(316,238,240,NULL,316,'2017-10-28'),(317,244,243,NULL,317,'2017-10-28'),(318,169,242,NULL,318,'2017-10-27'),(319,240,244,NULL,319,'2017-10-22'),(320,239,236,NULL,320,'2017-10-22'),(321,167,245,NULL,321,'2017-10-22'),(322,179,171,NULL,322,'2017-10-21'),(323,234,237,NULL,323,'2017-10-21'),(324,176,238,NULL,324,'2017-10-21'),(325,241,169,NULL,325,'2017-10-21'),(326,235,175,NULL,326,'2017-10-21'),(327,242,243,NULL,327,'2017-10-20'),(328,238,167,NULL,328,'2017-10-15'),(329,244,176,NULL,329,'2017-10-15'),(330,175,241,NULL,330,'2017-10-14'),(331,236,179,NULL,331,'2017-10-14'),(332,169,234,NULL,332,'2017-10-14'),(333,243,239,NULL,333,'2017-10-14'),(334,237,240,NULL,334,'2017-10-14'),(335,171,242,NULL,335,'2017-10-14'),(336,245,235,NULL,336,'2017-10-13'),(337,175,245,NULL,337,'2017-10-01'),(338,179,239,NULL,338,'2017-10-01'),(339,240,236,NULL,339,'2017-10-01'),(340,167,171,NULL,340,'2017-09-30'),(341,241,237,NULL,341,'2017-09-30'),(342,234,238,NULL,342,'2017-09-30'),(343,235,169,NULL,343,'2017-09-30'),(344,242,244,NULL,344,'2017-09-30'),(345,176,243,NULL,345,'2017-09-29'),(346,171,176,NULL,346,'2017-09-24'),(347,245,234,NULL,347,'2017-09-24'),(348,238,241,NULL,348,'2017-09-23'),(349,243,240,NULL,349,'2017-09-23'),(350,239,242,NULL,350,'2017-09-23'),(351,169,175,NULL,351,'2017-09-23'),(352,237,235,NULL,352,'2017-09-23'),(353,236,167,NULL,353,'2017-09-23'),(354,244,179,NULL,354,'2017-09-22'),(355,234,236,NULL,355,'2017-09-20'),(356,241,171,NULL,356,'2017-09-20'),(357,176,239,NULL,357,'2017-09-20'),(358,240,242,NULL,358,'2017-09-20'),(359,169,245,NULL,359,'2017-09-20'),(360,175,237,NULL,360,'2017-09-19'),(361,179,243,NULL,361,'2017-09-19'),(362,167,244,NULL,362,'2017-09-19'),(363,235,238,NULL,363,'2017-09-19'),(364,245,241,NULL,364,'2017-09-17'),(365,236,176,NULL,365,'2017-09-17'),(366,239,240,NULL,366,'2017-09-17'),(367,238,175,NULL,367,'2017-09-16'),(368,242,179,NULL,368,'2017-09-16'),(369,237,169,NULL,369,'2017-09-16'),(370,244,235,NULL,370,'2017-09-16'),(371,243,167,NULL,371,'2017-09-16'),(372,171,234,NULL,372,'2017-09-15'),(373,235,243,NULL,373,'2017-09-10'),(374,167,239,NULL,374,'2017-09-10'),(375,179,240,NULL,375,'2017-09-09'),(376,245,237,NULL,376,'2017-09-09'),(377,169,238,NULL,377,'2017-09-09'),(378,241,236,NULL,378,'2017-09-09'),(379,176,242,NULL,379,'2017-09-09'),(380,234,244,NULL,380,'2017-09-09'),(381,175,171,NULL,381,'2017-09-08'),(382,243,234,NULL,382,'2017-08-27'),(383,236,175,NULL,383,'2017-08-27'),(384,239,241,NULL,384,'2017-08-26'),(385,238,237,NULL,385,'2017-08-26'),(386,240,176,NULL,386,'2017-08-26'),(387,244,169,NULL,387,'2017-08-26'),(388,242,235,NULL,388,'2017-08-26'),(389,179,167,NULL,389,'2017-08-26'),(390,171,245,NULL,390,'2017-08-25'),(391,245,238,NULL,391,'2017-08-20'),(392,169,236,NULL,392,'2017-08-20'),(393,175,243,NULL,393,'2017-08-19'),(394,237,171,NULL,394,'2017-08-19'),(395,235,239,NULL,395,'2017-08-19'),(396,167,240,NULL,396,'2017-08-19'),(397,234,242,NULL,397,'2017-08-19'),(398,241,244,NULL,398,'2017-08-19'),(399,176,179,NULL,399,'2017-08-18'),(1030,66,43,NULL,1030,'2018-05-13'),(1031,225,36,NULL,1031,'2018-05-13'),(1032,2,226,NULL,1032,'2018-05-13'),(1033,227,5,NULL,1033,'2018-05-13'),(1034,42,1,NULL,1034,'2018-05-13'),(1035,9,228,NULL,1035,'2018-05-13'),(1036,4,17,NULL,1036,'2018-05-13'),(1037,230,229,NULL,1037,'2018-05-13'),(1038,232,231,NULL,1038,'2018-05-13'),(1039,11,233,NULL,1039,'2018-05-13'),(1040,1,233,NULL,1040,'2018-05-10'),(1041,227,4,NULL,1041,'2018-05-09'),(1042,228,231,NULL,1042,'2018-05-09'),(1043,226,9,NULL,1043,'2018-05-09'),(1044,2,232,NULL,1044,'2018-05-09'),(1045,17,229,NULL,1045,'2018-05-08'),(1046,43,2,NULL,1046,'2018-05-06'),(1047,5,9,NULL,1047,'2018-05-06'),(1048,226,4,NULL,1048,'2018-05-06'),(1049,17,11,NULL,1049,'2018-05-05'),(1050,229,66,NULL,1050,'2018-05-05'),(1051,233,232,NULL,1051,'2018-05-05'),(1052,228,42,NULL,1052,'2018-05-05'),(1053,231,225,NULL,1053,'2018-05-05'),(1054,36,230,NULL,1054,'2018-05-05'),(1055,1,227,NULL,1055,'2018-05-04'),(1056,42,231,NULL,1056,'2018-04-30'),(1057,2,1,NULL,1057,'2018-04-29'),(1058,4,233,NULL,1058,'2018-04-29'),(1059,9,229,NULL,1059,'2018-04-28'),(1060,227,43,NULL,1060,'2018-04-28'),(1061,232,36,NULL,1061,'2018-04-28'),(1062,11,226,NULL,1062,'2018-04-28'),(1063,225,228,NULL,1063,'2018-04-28'),(1064,66,17,NULL,1064,'2018-04-28'),(1065,230,5,NULL,1065,'2018-04-28'),(1066,228,11,NULL,1066,'2018-04-23'),(1067,229,4,NULL,1067,'2018-04-22'),(1068,233,2,NULL,1068,'2018-04-22'),(1069,43,230,NULL,1069,'2018-04-22'),(1070,36,42,NULL,1070,'2018-04-21'),(1071,5,225,NULL,1071,'2018-04-21'),(1072,9,43,NULL,1072,'2018-04-19'),(1073,17,232,NULL,1073,'2018-04-19'),(1074,1,66,NULL,1074,'2018-04-18'),(1075,231,227,NULL,1075,'2018-04-17'),(1076,230,233,NULL,1076,'2018-04-16'),(1077,225,1,NULL,1077,'2018-04-15'),(1078,2,228,NULL,1078,'2018-04-15'),(1079,4,231,NULL,1079,'2018-04-14'),(1080,66,5,NULL,1080,'2018-04-14'),(1081,232,43,NULL,1081,'2018-04-14'),(1082,227,36,NULL,1082,'2018-04-14'),(1083,42,226,NULL,1083,'2018-04-14'),(1084,11,229,NULL,1084,'2018-04-14'),(1085,9,17,NULL,1085,'2018-04-14'),(1086,233,9,NULL,1086,'2018-04-08'),(1087,17,2,NULL,1087,'2018-04-08'),(1088,1,4,NULL,1088,'2018-04-07'),(1089,36,66,NULL,1089,'2018-04-07'),(1090,226,227,NULL,1090,'2018-04-07'),(1091,228,232,NULL,1091,'2018-04-07'),(1092,231,230,NULL,1092,'2018-04-07'),(1093,43,42,NULL,1093,'2018-04-07'),(1094,229,225,NULL,1094,'2018-04-07'),(1095,5,11,NULL,1095,'2018-04-07'),(1096,231,9,NULL,1096,'2018-04-01'),(1097,230,2,NULL,1097,'2018-04-01'),(1098,4,11,NULL,1098,'2018-03-31'),(1099,232,227,NULL,1099,'2018-03-31'),(1100,229,1,NULL,1100,'2018-03-31'),(1101,226,228,NULL,1101,'2018-03-31'),(1102,66,42,NULL,1102,'2018-03-31'),(1103,43,225,NULL,1103,'2018-03-31'),(1104,17,233,NULL,1104,'2018-03-31'),(1105,5,36,NULL,1105,'2018-03-31'),(1106,42,5,NULL,1106,'2018-03-17'),(1107,225,66,NULL,1107,'2018-03-17'),(1108,36,226,NULL,1108,'2018-03-17'),(1109,11,230,NULL,1109,'2018-03-17'),(1110,4,230,NULL,1110,'2018-03-12'),(1111,231,66,NULL,1111,'2018-03-11'),(1112,42,2,NULL,1112,'2018-03-11'),(1113,36,9,NULL,1113,'2018-03-10'),(1114,227,11,NULL,1114,'2018-03-10'),(1115,229,226,NULL,1115,'2018-03-10'),(1116,17,228,NULL,1116,'2018-03-10'),(1117,232,225,NULL,1117,'2018-03-10'),(1118,43,233,NULL,1118,'2018-03-10'),(1119,5,1,NULL,1119,'2018-03-10'),(1120,1,36,NULL,1120,'2018-03-05'),(1121,9,4,NULL,1121,'2018-03-04'),(1122,2,227,NULL,1122,'2018-03-04'),(1123,228,5,NULL,1123,'2018-03-03'),(1124,66,232,NULL,1124,'2018-03-03'),(1125,230,17,NULL,1125,'2018-03-03'),(1126,233,229,NULL,1126,'2018-03-03'),(1127,226,231,NULL,1127,'2018-03-03'),(1128,225,42,NULL,1128,'2018-03-03'),(1129,11,43,NULL,1129,'2018-03-03'),(1130,4,2,NULL,1130,'2018-03-01'),(1131,9,1,NULL,1131,'2018-02-25'),(1132,231,36,NULL,1132,'2018-02-25'),(1133,11,42,NULL,1133,'2018-02-24'),(1134,228,66,NULL,1134,'2018-02-24'),(1135,229,227,NULL,1135,'2018-02-24'),(1136,17,43,NULL,1136,'2018-02-24'),(1137,233,5,NULL,1137,'2018-02-24'),(1138,226,225,NULL,1138,'2018-02-24'),(1139,230,232,NULL,1139,'2018-02-24'),(1140,225,9,NULL,1140,'2018-02-12'),(1141,5,17,NULL,1141,'2018-02-11'),(1142,1,228,NULL,1142,'2018-02-11'),(1143,66,226,NULL,1143,'2018-02-11'),(1144,232,4,NULL,1144,'2018-02-10'),(1145,36,11,NULL,1145,'2018-02-10'),(1146,227,230,NULL,1146,'2018-02-10'),(1147,43,229,NULL,1147,'2018-02-10'),(1148,42,233,NULL,1148,'2018-02-10'),(1149,2,231,NULL,1149,'2018-02-10'),(1150,9,42,NULL,1150,'2018-02-05'),(1151,231,5,NULL,1151,'2018-02-04'),(1152,228,36,NULL,1152,'2018-02-04'),(1153,11,2,NULL,1153,'2018-02-03'),(1154,230,66,NULL,1154,'2018-02-03'),(1155,233,227,NULL,1155,'2018-02-03'),(1156,229,232,NULL,1156,'2018-02-03'),(1157,226,1,NULL,1157,'2018-02-03'),(1158,17,225,NULL,1158,'2018-02-03'),(1159,4,43,NULL,1159,'2018-02-03'),(1160,225,4,NULL,1160,'2018-01-31'),(1161,42,230,NULL,1161,'2018-01-31'),(1162,1,231,NULL,1162,'2018-01-31'),(1163,66,9,NULL,1163,'2018-01-31'),(1164,232,11,NULL,1164,'2018-01-31'),(1165,43,228,NULL,1165,'2018-01-31'),(1166,227,17,NULL,1166,'2018-01-31'),(1167,5,226,NULL,1167,'2018-01-30'),(1168,2,229,NULL,1168,'2018-01-30'),(1169,36,233,NULL,1169,'2018-01-30'),(1170,5,229,NULL,1170,'2018-01-22'),(1171,231,17,NULL,1171,'2018-01-21'),(1172,228,4,NULL,1172,'2018-01-20'),(1173,36,2,NULL,1173,'2018-01-20'),(1174,1,43,NULL,1174,'2018-01-20'),(1175,225,11,NULL,1175,'2018-01-20'),(1176,42,232,NULL,1176,'2018-01-20'),(1177,226,230,NULL,1177,'2018-01-20'),(1178,66,233,NULL,1178,'2018-01-20'),(1179,9,227,NULL,1179,'2018-01-20'),(1180,230,1,NULL,1180,'2018-01-15'),(1181,4,5,NULL,1181,'2018-01-14'),(1182,2,66,NULL,1182,'2018-01-14'),(1183,11,231,NULL,1183,'2018-01-13'),(1184,232,9,NULL,1184,'2018-01-13'),(1185,43,36,NULL,1185,'2018-01-13'),(1186,233,226,NULL,1186,'2018-01-13'),(1187,229,228,NULL,1187,'2018-01-13'),(1188,17,42,NULL,1188,'2018-01-13'),(1189,227,225,NULL,1189,'2018-01-13'),(1190,233,231,NULL,1190,'2018-01-04'),(1191,9,2,NULL,1191,'2018-01-03'),(1192,42,4,NULL,1192,'2018-01-02'),(1193,36,17,NULL,1193,'2018-01-02'),(1194,231,229,NULL,1194,'2018-01-02'),(1195,225,233,NULL,1195,'2018-01-02'),(1196,1,11,NULL,1196,'2018-01-01'),(1197,5,43,NULL,1197,'2018-01-01'),(1198,226,232,NULL,1198,'2018-01-01'),(1199,228,230,NULL,1199,'2018-01-01'),(1200,66,227,NULL,1200,'2018-01-01'),(1201,2,225,NULL,1201,'2017-12-31'),(1202,4,36,NULL,1202,'2017-12-31'),(1203,17,1,NULL,1203,'2017-12-30'),(1204,11,66,NULL,1204,'2017-12-30'),(1205,230,9,NULL,1205,'2017-12-30'),(1206,43,226,NULL,1206,'2017-12-30'),(1207,232,5,NULL,1207,'2017-12-30'),(1208,227,228,NULL,1208,'2017-12-30'),(1209,229,42,NULL,1209,'2017-12-30'),(1210,2,36,NULL,1210,'2017-12-28'),(1211,4,228,NULL,1211,'2017-12-27'),(1212,229,5,NULL,1212,'2017-12-26'),(1213,233,66,NULL,1213,'2017-12-26'),(1214,227,9,NULL,1214,'2017-12-26'),(1215,230,226,NULL,1215,'2017-12-26'),(1216,43,1,NULL,1216,'2017-12-26'),(1217,232,42,NULL,1217,'2017-12-26'),(1218,11,225,NULL,1218,'2017-12-26'),(1219,17,231,NULL,1219,'2017-12-26'),(1220,1,232,NULL,1220,'2017-12-23'),(1221,231,43,NULL,1221,'2017-12-23'),(1222,42,227,NULL,1222,'2017-12-23'),(1223,66,4,NULL,1223,'2017-12-23'),(1224,226,17,NULL,1224,'2017-12-23'),(1225,225,230,NULL,1225,'2017-12-23'),(1226,36,229,NULL,1226,'2017-12-23'),(1227,228,233,NULL,1227,'2017-12-23'),(1228,9,11,NULL,1228,'2017-12-23'),(1229,5,2,NULL,1229,'2017-12-22'),(1230,229,11,NULL,1230,'2017-12-18'),(1231,5,66,NULL,1231,'2017-12-17'),(1232,1,225,NULL,1232,'2017-12-17'),(1233,231,4,NULL,1233,'2017-12-16'),(1234,233,230,NULL,1234,'2017-12-16'),(1235,228,2,NULL,1235,'2017-12-16'),(1236,43,227,NULL,1236,'2017-12-16'),(1237,17,9,NULL,1237,'2017-12-16'),(1238,226,42,NULL,1238,'2017-12-16'),(1239,36,232,NULL,1239,'2017-12-16'),(1240,225,5,NULL,1240,'2017-12-13'),(1241,66,1,NULL,1241,'2017-12-13'),(1242,227,231,NULL,1242,'2017-12-13'),(1243,2,233,NULL,1243,'2017-12-13'),(1244,11,228,NULL,1244,'2017-12-13'),(1245,232,17,NULL,1245,'2017-12-13'),(1246,4,229,NULL,1246,'2017-12-13'),(1247,42,36,NULL,1247,'2017-12-12'),(1248,9,226,NULL,1248,'2017-12-12'),(1249,230,43,NULL,1249,'2017-12-12'),(1250,4,1,NULL,1250,'2017-12-10'),(1251,11,5,NULL,1251,'2017-12-10'),(1252,2,17,NULL,1252,'2017-12-10'),(1253,232,228,NULL,1253,'2017-12-09'),(1254,42,43,NULL,1254,'2017-12-09'),(1255,66,36,NULL,1255,'2017-12-09'),(1256,227,226,NULL,1256,'2017-12-09'),(1257,225,229,NULL,1257,'2017-12-09'),(1258,230,231,NULL,1258,'2017-12-09'),(1259,9,233,NULL,1259,'2017-12-09'),(1260,233,4,NULL,1260,'2017-12-03'),(1261,17,66,NULL,1261,'2017-12-03'),(1262,1,2,NULL,1262,'2017-12-02'),(1263,5,227,NULL,1263,'2017-12-02'),(1264,226,11,NULL,1264,'2017-12-02'),(1265,43,232,NULL,1265,'2017-12-02'),(1266,229,230,NULL,1266,'2017-12-02'),(1267,231,42,NULL,1267,'2017-12-02'),(1268,36,225,NULL,1268,'2017-12-02'),(1269,228,9,NULL,1269,'2017-12-02'),(1270,233,11,NULL,1270,'2017-11-29'),(1271,17,4,NULL,1271,'2017-11-29'),(1272,5,230,NULL,1272,'2017-11-29'),(1273,226,2,NULL,1273,'2017-11-29'),(1274,43,66,NULL,1274,'2017-11-29'),(1275,229,9,NULL,1275,'2017-11-29'),(1276,1,42,NULL,1276,'2017-11-28'),(1277,228,225,NULL,1277,'2017-11-28'),(1278,36,227,NULL,1278,'2017-11-28'),(1279,231,232,NULL,1279,'2017-11-28'),(1280,4,226,NULL,1280,'2017-11-26'),(1281,11,17,NULL,1281,'2017-11-26'),(1282,9,5,NULL,1282,'2017-11-25'),(1283,230,36,NULL,1283,'2017-11-25'),(1284,227,1,NULL,1284,'2017-11-25'),(1285,42,228,NULL,1285,'2017-11-25'),(1286,66,229,NULL,1286,'2017-11-25'),(1287,225,231,NULL,1287,'2017-11-25'),(1288,232,233,NULL,1288,'2017-11-24'),(1289,230,227,NULL,1289,'2017-11-20'),(1290,233,42,NULL,1290,'2017-11-19'),(1291,228,1,NULL,1291,'2017-11-18'),(1292,226,66,NULL,1292,'2017-11-18'),(1293,229,43,NULL,1293,'2017-11-18'),(1294,11,36,NULL,1294,'2017-11-18'),(1295,4,232,NULL,1295,'2017-11-18'),(1296,17,5,NULL,1296,'2017-11-18'),(1297,9,225,NULL,1297,'2017-11-18'),(1298,231,2,NULL,1298,'2017-11-18'),(1299,1,9,NULL,1299,'2017-11-05'),(1300,42,11,NULL,1300,'2017-11-05'),(1301,2,4,NULL,1301,'2017-11-05'),(1302,36,231,NULL,1302,'2017-11-05'),(1303,5,233,NULL,1303,'2017-11-04'),(1304,225,226,NULL,1304,'2017-11-04'),(1305,66,228,NULL,1305,'2017-11-04'),(1306,43,17,NULL,1306,'2017-11-04'),(1307,227,229,NULL,1307,'2017-11-04'),(1308,232,230,NULL,1308,'2017-11-04'),(1309,228,43,NULL,1309,'2017-10-30'),(1310,11,232,NULL,1310,'2017-10-29'),(1311,17,227,NULL,1311,'2017-10-29'),(1312,9,66,NULL,1312,'2017-10-28'),(1313,229,2,NULL,1313,'2017-10-28'),(1314,233,36,NULL,1314,'2017-10-28'),(1315,226,5,NULL,1315,'2017-10-28'),(1316,230,42,NULL,1316,'2017-10-28'),(1317,4,225,NULL,1317,'2017-10-28'),(1318,231,1,NULL,1318,'2017-10-28'),(1319,5,231,NULL,1319,'2017-10-22'),(1320,2,11,NULL,1320,'2017-10-22'),(1321,225,17,NULL,1321,'2017-10-21'),(1322,1,226,NULL,1322,'2017-10-21'),(1323,43,4,NULL,1323,'2017-10-21'),(1324,36,228,NULL,1324,'2017-10-21'),(1325,66,230,NULL,1325,'2017-10-21'),(1326,232,229,NULL,1326,'2017-10-21'),(1327,42,9,NULL,1327,'2017-10-21'),(1328,227,233,NULL,1328,'2017-10-20'),(1329,225,232,NULL,1329,'2017-10-16'),(1330,228,17,NULL,1330,'2017-10-15'),(1331,11,227,NULL,1331,'2017-10-15'),(1332,2,42,NULL,1332,'2017-10-14'),(1333,233,43,NULL,1333,'2017-10-14'),(1334,9,36,NULL,1334,'2017-10-14'),(1335,230,4,NULL,1335,'2017-10-14'),(1336,226,229,NULL,1336,'2017-10-14'),(1337,66,231,NULL,1337,'2017-10-14'),(1338,1,5,NULL,1338,'2017-10-14'),(1339,5,228,NULL,1339,'2017-10-01'),(1340,43,11,NULL,1340,'2017-10-01'),(1341,227,2,NULL,1341,'2017-10-01'),(1342,4,9,NULL,1342,'2017-09-30'),(1343,232,66,NULL,1343,'2017-09-30'),(1344,36,1,NULL,1344,'2017-09-30'),(1345,17,230,NULL,1345,'2017-09-30'),(1346,42,225,NULL,1346,'2017-09-30'),(1347,229,233,NULL,1347,'2017-09-30'),(1348,231,226,NULL,1348,'2017-09-30'),(1349,225,2,NULL,1349,'2017-09-25'),(1350,228,227,NULL,1350,'2017-09-24'),(1351,5,232,NULL,1351,'2017-09-23'),(1352,226,43,NULL,1352,'2017-09-23'),(1353,66,11,NULL,1353,'2017-09-23'),(1354,36,4,NULL,1354,'2017-09-23'),(1355,1,17,NULL,1355,'2017-09-23'),(1356,9,230,NULL,1356,'2017-09-23'),(1357,42,229,NULL,1357,'2017-09-23'),(1358,231,233,NULL,1358,'2017-09-23'),(1359,11,1,NULL,1359,'2017-09-17'),(1360,2,9,NULL,1360,'2017-09-17'),(1361,229,231,NULL,1361,'2017-09-16'),(1362,232,226,NULL,1362,'2017-09-16'),(1363,43,5,NULL,1363,'2017-09-16'),(1364,230,228,NULL,1364,'2017-09-16'),(1365,4,42,NULL,1365,'2017-09-16'),(1366,233,225,NULL,1366,'2017-09-16'),(1367,17,36,NULL,1367,'2017-09-16'),(1368,227,66,NULL,1368,'2017-09-15'),(1369,226,233,NULL,1369,'2017-09-11'),(1370,228,229,NULL,1370,'2017-09-10'),(1371,36,43,NULL,1371,'2017-09-10'),(1372,1,230,NULL,1372,'2017-09-09'),(1373,66,2,NULL,1373,'2017-09-09'),(1374,225,227,NULL,1374,'2017-09-09'),(1375,231,11,NULL,1375,'2017-09-09'),(1376,9,232,NULL,1376,'2017-09-09'),(1377,42,17,NULL,1377,'2017-09-09'),(1378,5,4,NULL,1378,'2017-09-09'),(1379,2,5,NULL,1379,'2017-08-27'),(1380,43,231,NULL,1380,'2017-08-27'),(1381,11,9,NULL,1381,'2017-08-27'),(1382,230,225,NULL,1382,'2017-08-27'),(1383,232,1,NULL,1383,'2017-08-26'),(1384,229,36,NULL,1384,'2017-08-26'),(1385,17,226,NULL,1385,'2017-08-26'),(1386,233,228,NULL,1386,'2017-08-26'),(1387,227,42,NULL,1387,'2017-08-26'),(1388,4,66,NULL,1388,'2017-08-26'),(1389,11,4,NULL,1389,'2017-08-21'),(1390,9,231,NULL,1390,'2017-08-20'),(1391,228,226,NULL,1391,'2017-08-20'),(1392,2,230,NULL,1392,'2017-08-19'),(1393,42,66,NULL,1393,'2017-08-19'),(1394,225,43,NULL,1394,'2017-08-19'),(1395,227,232,NULL,1395,'2017-08-19'),(1396,36,5,NULL,1396,'2017-08-19'),(1397,233,17,NULL,1397,'2017-08-19'),(1398,1,229,NULL,1398,'2017-08-19'),(1399,233,1,NULL,1399,'2017-08-13'),(1400,231,228,NULL,1400,'2017-08-13'),(1401,4,227,NULL,1401,'2017-08-12'),(1402,43,9,NULL,1402,'2017-08-12'),(1403,226,36,NULL,1403,'2017-08-12'),(1404,230,11,NULL,1404,'2017-08-12'),(1405,229,17,NULL,1405,'2017-08-12'),(1406,66,225,NULL,1406,'2017-08-12'),(1407,5,42,NULL,1407,'2017-08-12'),(1408,232,2,NULL,1408,'2017-08-11');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-08 10:46:25
