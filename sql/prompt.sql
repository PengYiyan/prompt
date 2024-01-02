-- MySQL dump 10.13  Distrib 5.7.19, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: promptDemo
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

drop database IF EXISTS `promptDemo`;
create DATABASE promptDemo;
USE promptDemo;

--
-- Table structure for table `User`
--

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
drop table IF EXISTS `User`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create TABLE `User`
(
    `user_id`       int(11) NOT NULL AUTO_INCREMENT,
    `user_name` varchar(255) DEFAULT NULL,
    `email` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `role` ENUM('ADMIN','STUDENT') DEFAULT NULL,

    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

begin;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
INSERT INTO User
VALUES (1, 'sample1', 'json', 'json','ADMIN');
INSERT INTO User
VALUES (2, 'sample2', 'json', 'json','STUDENT');
INSERT INTO User
VALUES (3, 'sample3', 'json', 'json','ADMIN');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
COMMIT;