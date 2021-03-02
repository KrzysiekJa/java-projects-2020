-- MySQL dump 10.13  Distrib 8.0.15, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: hibernate
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CarShowroom`
--

DROP TABLE IF EXISTS `CarShowroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `CarShowroom` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Capacity` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CarShowroom`
--

LOCK TABLES `CarShowroom` WRITE;
/*!40000 ALTER TABLE `CarShowroom` DISABLE KEYS */;
INSERT INTO `CarShowroom` VALUES (1,'SpeedDe',8),(2,'AmericanCar',16),(3,'New Car',25);
/*!40000 ALTER TABLE `CarShowroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RATING`
--

DROP TABLE IF EXISTS `RATING`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `RATING` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Value` int(10) unsigned NOT NULL,
  `Carshowroom` int(10) unsigned NOT NULL,
  `Date` date DEFAULT NULL,
  `Description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Rating_ibfk_1` (`Carshowroom`),
  CONSTRAINT `Rating_ibfk_1` FOREIGN KEY (`Carshowroom`) REFERENCES `carshowroom` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RATING`
--

LOCK TABLES `RATING` WRITE;
/*!40000 ALTER TABLE `RATING` DISABLE KEYS */;
INSERT INTO `RATING` VALUES (1,4,1,'2020-12-10','German cars are the best. My favorite dealer.'),(2,2,1,'2020-12-10','After last visit: :('),(3,5,2,'2020-12-10','Their hammve are excellent.'),(4,4,2,'2020-12-10','I love this showroom with american cars.'),(5,3,2,'2020-12-10','Focus I bought from them is very good car.'),(6,4,3,'2020-12-10','Mi piacciono molto le auto italiane.'),(7,5,3,'2020-12-10','The Maluch I bought is excellent'),(8,1,3,'2020-12-10','My shop is better.'),(9,5,3,'2020-12-10','I using Panda, bought there year ago and is fantastic'),(10,4,3,'2020-12-10','ok'),(29,4,1,'2021-01-05','German cars are the best. My favorite dealer.'),(30,3,1,'2021-01-05',NULL),(49,4,1,NULL,NULL),(50,4,1,NULL,NULL),(51,5,3,NULL,NULL);
/*!40000 ALTER TABLE `RATING` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vehicle`
--

DROP TABLE IF EXISTS `Vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Vehicle` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Mark` varchar(20) NOT NULL,
  `Model` varchar(20) NOT NULL,
  `Price` float NOT NULL,
  `ProductionYear` int(10) unsigned NOT NULL,
  `Mileage` float NOT NULL,
  `EngineCapacity` float NOT NULL,
  `Carshowroom` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Vehicle_ibfk_1` (`Carshowroom`),
  CONSTRAINT `Vehicle_ibfk_1` FOREIGN KEY (`Carshowroom`) REFERENCES `carshowroom` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vehicle`
--

LOCK TABLES `Vehicle` WRITE;
/*!40000 ALTER TABLE `Vehicle` DISABLE KEYS */;
INSERT INTO `Vehicle` VALUES (1,'Opel','Corsa',20000,2007,350000,40,1),(2,'Opel','Corsa',27000,2015,200000,35.3,1),(3,'Mercedes','A3',35000,2010,250000,38.2,1),(4,'Mercedes','A3',35000,2010,250000,38.2,1),(5,'BMW','Seria 3',40000,2016,300001,42,1),(6,'BMW','Seria 7',55000,2013,400000,38.5,1),(7,'Ford','Mondeo',100000,2019,1200,35,2),(8,'Ford','Focus 1.6',120000,2019,2000,35.3,2),(9,'Ford','Focus 1.6',120000,2019,2000,35.3,2),(10,'Ford','Focus 1.6',120000,2019,2000,35.3,2),(11,'Ford','Fiesta',115000,2020,2500.1,36.2,2),(12,'Ford','Fiesta',115000,2020,2500.1,36.2,2),(13,'Ford','Fiesta 1.5',150000,2019,1300.5,40.1,2),(14,'Ford','Fiesta 1.5',150000,2019,1300.5,40.1,2),(15,'Hammer','Hammve',300000,2018,1500,45.5,2),(16,'Fiat','Maluch',1000,1988,550000,31.5,3),(17,'Fiat','Maluch',1000,1988,550000,31.5,3),(18,'Fiat','Panda',1000,2008,250000,41.5,3);
/*!40000 ALTER TABLE `Vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hibernate'
--

--
-- Dumping routines for database 'hibernate'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-01 23:42:34
