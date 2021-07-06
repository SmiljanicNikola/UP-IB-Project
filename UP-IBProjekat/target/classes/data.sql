-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: ibprojekat
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointments` (
  `appointment_id` int NOT NULL AUTO_INCREMENT,
  `date_and_time` datetime NOT NULL,
  `appointment_lenght` varchar(45) NOT NULL,
  `price` float NOT NULL,
  `doctor_id` int DEFAULT NULL,
  `nurse_id` int DEFAULT NULL,
  PRIMARY KEY (`appointment_id`),
  KEY `doctor_fk_idx` (`doctor_id`),
  KEY `nurse_fk_idx` (`nurse_id`),
  CONSTRAINT `doctor_fkk` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `nurse_fkk` FOREIGN KEY (`nurse_id`) REFERENCES `nurse` (`nurse_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointments`
--

LOCK TABLES `appointments` WRITE;
/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;
INSERT INTO `appointments` VALUES (1,'2021-03-15 00:12:43','1:30h',1500,1,1);
/*!40000 ALTER TABLE `appointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clinicadmins`
--

DROP TABLE IF EXISTS `clinicadmins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clinicadmins` (
  `clinicadmin_id` int NOT NULL AUTO_INCREMENT,
  `clinic_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`clinicadmin_id`),
  KEY `FKt0pjfh9pnfhubnectyoalcbaf` (`clinic_id`),
  KEY `FK7rsqut0k3k1nwuxm53sputthw` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clinicadmins`
--

LOCK TABLES `clinicadmins` WRITE;
/*!40000 ALTER TABLE `clinicadmins` DISABLE KEYS */;
INSERT INTO `clinicadmins` VALUES (1,2,46);
/*!40000 ALTER TABLE `clinicadmins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clinics`
--

DROP TABLE IF EXISTS `clinics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clinics` (
  `clinic_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `adress` varchar(255) NOT NULL,
  `avg_rate` float DEFAULT NULL,
  PRIMARY KEY (`clinic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clinics`
--

LOCK TABLES `clinics` WRITE;
/*!40000 ALTER TABLE `clinics` DISABLE KEYS */;
INSERT INTO `clinics` VALUES (1,'Ive Andrica','Ivina 1',3.1),(2,'Pere Perica','Savina 4',3.1),(4,'Zikica Perica','Ivina 2',3.5),(5,'Zikica Perica','Ivina 2',4.5),(8,'Ivaa Andrica','Ivina 3',3.1),(9,'Ivaa Andrica','Ivina 3',3.1);
/*!40000 ALTER TABLE `clinics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `doctor_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `clinic_id` int NOT NULL,
  PRIMARY KEY (`doctor_id`),
  KEY `doctor_fk_idx` (`user_id`),
  KEY `clinic_doctor_fk_idx` (`clinic_id`),
  CONSTRAINT `clinic_fk` FOREIGN KEY (`clinic_id`) REFERENCES `clinics` (`clinic_id`),
  CONSTRAINT `doctor_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,8,1),(2,9,8),(4,37,8),(7,43,2),(8,44,2);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (82);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nurse`
--

DROP TABLE IF EXISTS `nurse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nurse` (
  `nurse_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `clinic_id` int DEFAULT NULL,
  PRIMARY KEY (`nurse_id`),
  KEY `nurse_fk_idx` (`user_id`),
  KEY `FK1alq931t4pb73cqbrfm4e7lsa` (`clinic_id`),
  CONSTRAINT `FK1alq931t4pb73cqbrfm4e7lsa` FOREIGN KEY (`clinic_id`) REFERENCES `clinics` (`clinic_id`),
  CONSTRAINT `nurse_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nurse`
--

LOCK TABLES `nurse` WRITE;
/*!40000 ALTER TABLE `nurse` DISABLE KEYS */;
INSERT INTO `nurse` VALUES (1,24,1);
/*!40000 ALTER TABLE `nurse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `lbo` varchar(45) NOT NULL,
  PRIMARY KEY (`patient_id`),
  KEY `patient_user_fk_idx` (`user_id`),
  CONSTRAINT `patient_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,20,'212111212'),(2,21,'00212111212');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `refreshtoken`
--

DROP TABLE IF EXISTS `refreshtoken`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `refreshtoken` (
  `id` bigint NOT NULL,
  `expiry_date` datetime NOT NULL,
  `token` varchar(255) NOT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa652xrdji49m4isx38pp4p80p` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refreshtoken`
--

LOCK TABLES `refreshtoken` WRITE;
/*!40000 ALTER TABLE `refreshtoken` DISABLE KEYS */;
INSERT INTO `refreshtoken` VALUES (1,'2021-06-30 18:44:00','336246e9-c292-4921-a598-91a9015d0d6f',8),(2,'2021-06-30 18:54:01','11711604-247c-4910-9110-5e1da5d819c2',8),(3,'2021-06-30 18:54:13','23cd734b-7b84-442f-8da8-b9ca821eb251',8),(4,'2021-06-30 18:54:16','13866750-efdc-4ea0-ad21-9e8702971f1d',8),(5,'2021-06-30 19:04:50','bc338b49-69ea-41b3-bae4-158c93d013db',8),(6,'2021-06-30 19:07:15','2feb1f64-914c-4136-b301-c8b9ec341ced',8),(7,'2021-06-30 19:07:55','0060d1ac-400e-461b-b610-64c4b7162334',8),(8,'2021-06-30 19:08:03','b6609940-f390-4b98-baf7-dd24e27a8588',8),(9,'2021-06-30 19:09:25','c7f170ff-0135-4b27-bdb1-c7fc170ce6ae',8),(10,'2021-06-30 19:10:41','08c01f69-b6e3-472e-bee7-01727296d80c',44),(11,'2021-06-30 19:11:32','daced8e4-9486-4e83-83af-18bbe6750bfb',44),(12,'2021-06-30 19:16:37','da8cfcbc-8ef0-4f30-b6e3-db9403b336a8',44),(13,'2021-06-30 19:17:25','2f5e1854-bc96-4455-9f27-2135a28be090',8),(14,'2021-06-30 19:18:23','d5dd2997-f8a7-4e82-aca1-a0e28122ce87',8),(15,'2021-06-30 19:18:38','226fe76f-af0d-49c5-859f-ef6fb979bef8',39),(16,'2021-06-30 19:19:32','08616202-ffe0-42cf-819f-979523673ba2',20),(17,'2021-06-30 19:21:30','ed67bf70-e74c-48aa-98da-103b0a0266f5',20),(18,'2021-06-30 19:21:50','1d24587c-ec4c-49b9-8e8c-0e2bffb19a39',8),(19,'2021-06-30 19:22:44','edf33c6a-7550-4a28-aeed-3e570cafc9c6',8),(20,'2021-06-30 19:25:47','176cc7b7-cf3c-4f4f-94f2-76c01c61592c',20),(21,'2021-06-30 19:26:14','58813eb3-a164-440c-bab4-ae48dbac39e3',8),(22,'2021-06-30 19:29:35','4b1bda45-4951-40f3-9f4f-7ec6f88b3688',8),(23,'2021-06-30 19:30:01','8bca077b-c929-4601-9628-2e9afb731020',20),(24,'2021-06-30 19:31:46','4b885a64-bb69-4abc-9c1e-a01e8c6a5f91',8),(25,'2021-06-30 19:32:08','b9bed224-e1b7-4c57-9dbb-cf38617fa2e8',20),(26,'2021-06-30 19:33:27','72b69b11-60be-404c-9253-2d40f6395e73',20),(27,'2021-06-30 19:35:19','849944aa-a29d-4cd7-987d-f304f39823db',8),(28,'2021-06-30 19:37:29','18b1c08f-a92e-4a3d-b9af-d5d357ddf97c',8),(29,'2021-06-30 19:37:56','abb7c682-4180-432f-8846-bcc269502435',20),(30,'2021-06-30 19:39:16','6226e4ae-091b-457f-95d7-a3107acce35f',20),(31,'2021-06-30 19:40:26','fa97bdba-d96f-4efb-8682-02a8ac7ad430',20),(32,'2021-06-30 19:41:28','a8285677-46e1-4b41-8203-edbb41e41c66',20),(33,'2021-06-30 19:42:22','3b03d99e-0cd3-4d48-a242-f37ce1d35c8c',20),(34,'2021-06-30 19:44:13','cf8b4ba0-c891-48f0-b486-b870edfb4a39',20),(35,'2021-06-30 19:44:35','c3d53812-f560-4b68-b6af-626edf05ba01',8),(36,'2021-06-30 19:45:33','bda01f25-6544-4254-8775-dd218118024f',8),(37,'2021-06-30 19:49:03','c31e64fd-0cde-4b92-849d-f21de88baf03',8),(38,'2021-06-30 19:49:25','9ad1c185-98be-469e-b1ce-4dd60152a53b',20),(39,'2021-07-01 13:40:14','4fa7b2cd-b82f-4cd1-b4ca-70092e5b5a1e',8),(40,'2021-07-01 13:42:05','cbdcbdfc-403a-4145-9673-e77bf72c5a88',8),(41,'2021-07-01 13:46:40','92a02919-b0e7-4713-86b2-fe903bcd4f28',8),(42,'2021-07-01 13:51:06','4a258d86-1660-4f75-9f86-d5c780b611ef',8),(43,'2021-07-01 13:51:48','f614713f-098e-4f37-891f-203c189d0610',20),(44,'2021-07-01 14:01:00','d08b9aef-84e6-4689-883d-9e0f4ef92dc2',8),(45,'2021-07-01 14:14:48','6eb0ce51-e68a-409a-b43b-95d873b68e16',8),(46,'2021-07-01 14:20:30','659d2507-b9d8-4aee-8d9a-2add86755e4a',8),(47,'2021-07-01 14:30:06','30400b5a-4a82-4d0f-9401-9dde0fbfa7ba',8),(48,'2021-07-01 14:34:32','c89ef180-03a3-4347-99dc-bab52b99b066',8),(49,'2021-07-01 14:37:12','d51bbe15-f86b-44cf-8671-d43693007c4f',8),(50,'2021-07-01 14:38:04','b4999422-553b-451a-bc2c-9981933a9601',8),(51,'2021-07-01 14:40:06','7af20126-d01e-4115-bd30-e80be0490791',20),(52,'2021-07-01 14:50:11','95ff945b-ec80-46e8-9e70-d6c5066fec06',20),(53,'2021-07-01 14:50:46','b74e60bd-033d-4725-8c5d-bcdadc981bbb',8),(54,'2021-07-01 14:52:45','b22bb456-ef79-4500-9f89-7c937cc7fc38',8),(55,'2021-07-01 14:54:47','9cd94941-7280-4460-8978-59c2eef39ad0',8),(56,'2021-07-01 15:01:28','064cc9e6-473f-47cc-a5ce-6c1289c6513f',8),(57,'2021-07-01 15:30:26','05cc9a70-4f6a-4aeb-9d87-66589278b953',8),(58,'2021-07-01 15:30:45','5b9866b9-65dc-4927-a186-f5f4425e3bd4',8),(59,'2021-07-01 15:31:16','6b84ae40-5f96-4cde-b299-b5826e70dd59',20),(60,'2021-07-01 15:38:47','00b6daa6-cb40-40fe-b484-9ca757e966ba',8),(61,'2021-07-01 16:25:18','85498223-0370-4716-94ad-eb5d041b69ec',8),(62,'2021-07-01 22:20:06','9eddf0d6-6d33-4107-9bfd-3dff68cf66a1',8),(63,'2021-07-01 22:29:53','eab0eabd-40b5-419c-808d-98e514186bf4',8),(64,'2021-07-04 22:55:06','c2337647-f51a-4942-8b67-16e921515daf',8),(65,'2021-07-04 23:13:52','e835ee50-9212-453d-b2f5-aae6f7ba5737',20),(66,'2021-07-05 19:34:18','f29061d9-96ed-4110-bc69-8246870b0722',8),(67,'2021-07-06 12:44:58','32b21bc5-d44c-47cc-bb33-ab47387d21f6',8),(68,'2021-07-06 13:03:59','87dbfc2f-8d75-41e4-af04-645893b3a1b0',20),(69,'2021-07-06 13:05:33','28561396-00e4-4bc8-8f3f-fc31a79a12b0',8),(70,'2021-07-06 13:08:30','05e1d66f-b822-4330-b10d-8367d9b1c1bc',20),(71,'2021-07-06 14:29:21','0ca02f42-31ef-4926-8baa-f1dbf6ad2cee',8),(72,'2021-07-06 14:32:47','ed356844-6ebf-410a-9ec3-a759620d16ba',8),(73,'2021-07-06 14:59:32','7a64fa3a-b804-41b9-a005-b143fdc385d1',8),(74,'2021-07-06 15:05:27','b5f8b7f9-0bc9-4386-8455-612fcef0e094',8),(75,'2021-07-06 15:06:28','09a64bd3-baa4-490c-b543-0d961d09dcb5',20),(76,'2021-07-06 15:08:32','d1b7f75c-ba28-49e8-9f0a-a77f8995258b',8),(77,'2021-07-06 15:18:51','e02f46c2-25a6-45c7-ba3b-a8efa4a953ec',20),(78,'2021-07-06 15:20:51','cf2fea5d-7d77-4f12-b49f-64122130d3b9',8),(79,'2021-07-06 15:35:23','3c121b70-8103-4de0-86e6-f4f3dcd8ab6d',46),(80,'2021-07-06 15:36:14','06a8dee2-07f2-472b-9211-e4eba80e37f6',8),(81,'2021-07-06 15:42:00','d52d66ca-bc1f-49ef-9d4e-8140dd522ae4',46);
/*!40000 ALTER TABLE `refreshtoken` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'LEKAR'),(2,'MEDICINSKA SESTRA'),(3,'ADMINISTRATOR KLINIKE'),(4,'ADMINISTRATOR CENTRA'),(5,'PACIJENT');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `email` varchar(45) NOT NULL,
  `adress` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `city` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `phone` varchar(64) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `id_UNIQUE` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (8,'Ivan','Ivankovic','ivan@gmail.com','Pupinova 22','$2a$10$hSt8FjlbCAiAXopQXaY/..41jJIfpBPoxmCJlFeDUd32QIWSCyMOq','Novi Sad','Srbija','012121',0),(9,'Slavko','Milic','slavko@gmail.com','Njegoseva 21','$2a$10$HalcBrrcxf77zdfE6zHnyegXc3qK/NbXlvwtjVZi6WB2pLE7/gej6','Loznica','Srbija','01212321',1),(20,'Milena','Dravic','milena@gmail.com','Pop Lukina 1','$2a$10$kqg/Quu9a7BQ90CPdV7RRey9tQcM0xlKrZx8c1vYXwqpmyXRYUGCW','Pozarevac','Srbija','012123211',1),(21,'Pera','Peric','pera@gmail.com','Banjski 2','$2a$10$26sk6WCOfkGDp9nWRaVwxOJjk16QKvI5.K9YL9TVNwOd5C/YhNtl.','Lazarevac','Srbija','06312123211',0),(24,'Marija','Tomic','marija@gmail.com','Decanski 21','$2a$10$gO1jFzoQ/FaYC3VVwpAubeHPi0cPD9tjDtvwyBubnMZGVnkGbzQA.','Prizren','Srbija','06432163211',1),(37,'Milenko','Marin','milenko@gmail.com','Decanski 21','$2a$10$oZ2XokwdI55NKM0898Zkz.yeAVGb2XxzGIvdKLLRbbrG7PmdsyEiS','Ivanjica','Srbija','06432163211',1),(43,'Milivoje','Pesic','milivoje@gmail.com','Decanski 21','$2a$10$cYD2XiVNfDfCNr.HgeyMquEAh7FyhuFKNK3Xi8cyW0DjwHy13nDQi','Srdulice','Srbija','06432163211',1),(44,'Pedja','Pesic','pedja@gmail.com','Decanski 21','$2a$10$tT0sQI9n43liawLvmhtxVOZuXvgdz2tbK8SwENC0YFdO3e/Me.6B.','Srdulice','Srbija','06432163211',0),(45,'Ivica','ivica','ivica@gmail.com','Ivina 21','$2a$10$PHG0RVsG1vooHZBHF.4aau6T6a8lFETQAwtUj.3aDA02AqYH2b7o6','Subotica','Srbija','066443',0),(46,'admin','adminovic','adminklinike','adminovska','$2a$10$jETPwcdlGQAZhriCqlzjSu3BzP.2xbIxlg5v4LiXHMfe9LDUscpcO','admingrad','Adminija','063-219/312',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `user_id_fk_idx` (`user_id`),
  KEY `role_fk` (`role_id`),
  CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1),(7,1),(8,1),(9,1),(10,1),(11,5),(12,5),(13,5),(14,5),(15,5),(16,5),(17,5),(18,5),(19,5),(20,5),(21,5),(22,5),(23,5),(24,2),(25,1),(26,1),(27,1),(28,1),(29,1),(30,1),(31,1),(32,1),(33,1),(34,1),(35,1),(36,1),(37,1),(38,1),(43,1),(44,1),(45,5),(46,3);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verification_token`
--

DROP TABLE IF EXISTS `verification_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `verification_token` (
  `id` int NOT NULL AUTO_INCREMENT,
  `expiry_date` datetime DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3asw9wnv76uxu3kr1ekq4i1ld` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verification_token`
--

LOCK TABLES `verification_token` WRITE;
/*!40000 ALTER TABLE `verification_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `verification_token` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-06 18:03:05
