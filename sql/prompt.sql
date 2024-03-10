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

--
-- Table structure for table `Prompt`
--

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
drop table IF EXISTS `Prompt`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create TABLE `Prompt`
(
    `prompt_id`       int(11) NOT NULL AUTO_INCREMENT,
    `field` varchar(255) DEFAULT NULL,
    `collect_count` int(11) NOT NULL,
    `user_id` int(11) DEFAULT NULL,
    `title` varchar(255) DEFAULT NULL,
    `content` varchar(255) DEFAULT NULL,
    `has_upload` boolean DEFAULT FALSE,

    PRIMARY KEY (`prompt_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prompt`
--

begin;
/*!40000 ALTER TABLE `Prompt` ENABLE KEYS */;
INSERT INTO Prompt
VALUES (1, '艺术', 0, 1,'Title1','这是一条提示词1',false);
INSERT INTO Prompt
VALUES (2, '学术', 0, 1,'Title2','这是一条提示词2',false);
INSERT INTO Prompt
VALUES (3, '软件工程', 1, 1,'Title3','这是一条提示词3',false);
/*!40000 ALTER TABLE `Prompt` ENABLE KEYS */;
COMMIT;

--
-- Table structure for table `Field`
--

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
drop table IF EXISTS `Field`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create TABLE `Field`
(
    `field_id`       int(11) NOT NULL AUTO_INCREMENT,
    `field_name` varchar(255) DEFAULT NULL,

    PRIMARY KEY (`field_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Field`
--

begin;
/*!40000 ALTER TABLE `Field` ENABLE KEYS */;
INSERT INTO Field
VALUES (1, '饮食与健康');
INSERT INTO Field
VALUES (2, '计算机科学');
INSERT INTO Field
VALUES (3, '写作');
/*!40000 ALTER TABLE `Field` ENABLE KEYS */;
COMMIT;

--
-- Table structure for table `History`
--

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
drop table IF EXISTS `History`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create TABLE `History`
(
    `history_id`       int(11) NOT NULL AUTO_INCREMENT,
    `user_id` int(11) DEFAULT NULL,
    `prompt_id` int(11) DEFAULT NULL,

    PRIMARY KEY (`history_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `History`
--

begin;
/*!40000 ALTER TABLE `History` ENABLE KEYS */;
INSERT INTO History
VALUES (1, 1, 1);
INSERT INTO History
VALUES (2, 1, 2);
INSERT INTO History
VALUES (3, 2, 3);
/*!40000 ALTER TABLE `History` ENABLE KEYS */;
COMMIT;

--
-- Table structure for table `Collect`
--

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
drop table IF EXISTS `Collect`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create TABLE `Collect`
(
    `collect_id`       int(11) NOT NULL AUTO_INCREMENT,
    `user_id` int(11) DEFAULT NULL,
    `prompt_id` int(11) DEFAULT NULL,

    PRIMARY KEY (`collect_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Collect`
--

# begin;
# /*!40000 ALTER TABLE `Collect` ENABLE KEYS */;
# INSERT INTO Collect
# VALUES (1, 'sample1', 'json', 'json','ADMIN');
# INSERT INTO Collect
# VALUES (2, 'sample2', 'json', 'json','STUDENT');
# INSERT INTO Collect
# VALUES (3, 'sample3', 'json', 'json','ADMIN');
# /*!40000 ALTER TABLE `Collect` ENABLE KEYS */;
# COMMIT;

--
-- Table structure for table `PromptTag`
--

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
drop table IF EXISTS `PromptTag`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create TABLE `PromptTag`
(
    `tag_id`       int(11) NOT NULL AUTO_INCREMENT,
    `tag_type` varchar(255) DEFAULT NULL,
    `content` varchar(255) DEFAULT NULL,

    PRIMARY KEY (`tag_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PromptTag`
--

# begin;
# /*!40000 ALTER TABLE `PromptTag` ENABLE KEYS */;
# INSERT INTO PromptTag
# VALUES (1, 'sample1', 'json', 'json','ADMIN');
# INSERT INTO PromptTag
# VALUES (2, 'sample2', 'json', 'json','STUDENT');
# INSERT INTO PromptTag
# VALUES (3, 'sample3', 'json', 'json','ADMIN');
# /*!40000 ALTER TABLE `PromptTag` ENABLE KEYS */;
# COMMIT;