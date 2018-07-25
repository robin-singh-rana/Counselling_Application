-- MySQL dump 10.13  Distrib 5.5.0-m2, for Win64 (unknown)
--
-- Host: localhost    Database: student
-- ------------------------------------------------------
-- Server version	5.5.0-m2-community

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
-- Table structure for table `stud_choices`
--

DROP TABLE IF EXISTS `stud_choices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stud_choices` (
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `choice_1` varchar(100) DEFAULT NULL,
  `choice_2` varchar(100) DEFAULT NULL,
  `choice_3` varchar(100) DEFAULT NULL,
  `choice_4` varchar(100) DEFAULT NULL,
  `choice_5` varchar(100) DEFAULT NULL,
  `choice_6` varchar(100) DEFAULT NULL,
  `choice_7` varchar(100) DEFAULT NULL,
  `choice_8` varchar(100) DEFAULT NULL,
  `choice_9` varchar(100) DEFAULT NULL,
  `choice_10` varchar(100) DEFAULT NULL,
  `choice_11` varchar(100) DEFAULT NULL,
  `choice_12` varchar(100) DEFAULT NULL,
  `choice_13` varchar(100) DEFAULT NULL,
  `choice_14` varchar(100) DEFAULT NULL,
  `choice_15` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stud_choices`
--

LOCK TABLES `stud_choices` WRITE;
/*!40000 ALTER TABLE `stud_choices` DISABLE KEYS */;
INSERT INTO `stud_choices` VALUES ('abc','123','CDAC-MOHALI: COMPUTER SCIENCE AND ENGINEERING','CDAC-MOHALI: ELECTRICAL ENGINEERING','CDAC-MOHALI: MECHANICAL ENGINEERING','NONE','NONE','NONE','NONE','NONE','NONE','NONE','NONE','NONE','NONE','NONE','NONE'),('def','456','CDAC-MOHALI: COMPUTER SCIENCE AND ENGINEERING','CDAC-MOHALI: ELECTRICAL ENGINEERING','CDAC-MOHALI: MECHANICAL ENGINEERING','NONE','NONE','NONE','NONE','NONE','NONE','NONE','NONE','NONE','NONE','NONE','NONE'),('ghi','789','CDAC-MOHALI: COMPUTER SCIENCE AND ENGINEERING','CDAC-MOHALI: ELECTRICAL ENGINEERING','NONE','NONE','NONE','NONE','NONE','NONE','NONE','NONE','NONE','NONE','NONE','NONE','CDAC-MOHALI: CIVIL ENGINEERING');
/*!40000 ALTER TABLE `stud_choices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stud_info`
--

DROP TABLE IF EXISTS `stud_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stud_info` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `gender` varchar(30) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL,
  `marks` int(11) NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stud_info`
--

LOCK TABLES `stud_info` WRITE;
/*!40000 ALTER TABLE `stud_info` DISABLE KEYS */;
INSERT INTO `stud_info` VALUES (19,'abc','abc@gmail.com','123','Male','Arunachal Pradesh',490),(20,'def','def@gmail.com','456','Male','Chhattisgarh',150),(21,'ghi','ghi@gmail.com','789','Male','Jammu & Kashmir',450);
/*!40000 ALTER TABLE `stud_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stud_ranks`
--

DROP TABLE IF EXISTS `stud_ranks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stud_ranks` (
  `rank` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `gender` varchar(30) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL,
  `marks` int(11) NOT NULL,
  PRIMARY KEY (`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stud_ranks`
--

LOCK TABLES `stud_ranks` WRITE;
/*!40000 ALTER TABLE `stud_ranks` DISABLE KEYS */;
INSERT INTO `stud_ranks` VALUES (1,'abc','abc@gmail.com','123','Male','Arunachal Pradesh',490),(2,'ghi','ghi@gmail.com','789','Male','Jammu & Kashmir',450),(3,'def','def@gmail.com','456','Male','Chhattisgarh',150);
/*!40000 ALTER TABLE `stud_ranks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stud_result`
--

DROP TABLE IF EXISTS `stud_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stud_result` (
  `rank` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `seat_allocated` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stud_result`
--

LOCK TABLES `stud_result` WRITE;
/*!40000 ALTER TABLE `stud_result` DISABLE KEYS */;
INSERT INTO `stud_result` VALUES (1,'abc','123','CDAC-MOHALI: COMPUTER SCIENCE AND ENGINEERING'),(2,'ghi','789','CDAC-MOHALI: ELECTRICAL ENGINEERING'),(3,'def','456','CDAC-MOHALI: MECHANICAL ENGINEERING');
/*!40000 ALTER TABLE `stud_result` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-28 16:00:13
