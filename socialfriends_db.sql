/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 8.0.15 : Database - socialfriends_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`socialfriends_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `socialfriends_db`;

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (17),(17),(17);

/*Table structure for table `social_frd_block` */

DROP TABLE IF EXISTS `social_frd_block`;

CREATE TABLE `social_frd_block` (
  `id` bigint(20) DEFAULT NULL,
  `blocker` varchar(255) DEFAULT NULL,
  `blockee` varchar(255) DEFAULT NULL,
  KEY `blocker` (`blocker`),
  KEY `blockee` (`blockee`),
  CONSTRAINT `social_frd_block_ibfk_1` FOREIGN KEY (`blocker`) REFERENCES `social_userprofile` (`email`),
  CONSTRAINT `social_frd_block_ibfk_2` FOREIGN KEY (`blockee`) REFERENCES `social_userprofile` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `social_frd_block` */

insert  into `social_frd_block`(`id`,`blocker`,`blockee`) values (16,'andy@example.com','rk@example.com');

/*Table structure for table `social_frd_subscrib` */

DROP TABLE IF EXISTS `social_frd_subscrib`;

CREATE TABLE `social_frd_subscrib` (
  `id` bigint(15) NOT NULL,
  `subscribee` varchar(200) DEFAULT NULL,
  `subscriber` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `subscriber` (`subscriber`),
  KEY `subscribee` (`subscribee`),
  CONSTRAINT `social_frd_subscrib_ibfk_1` FOREIGN KEY (`subscriber`) REFERENCES `social_userprofile` (`email`),
  CONSTRAINT `social_frd_subscrib_ibfk_2` FOREIGN KEY (`subscribee`) REFERENCES `social_userprofile` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `social_frd_subscrib` */

insert  into `social_frd_subscrib`(`id`,`subscribee`,`subscriber`) values (15,'rk@example.com','andy@example.com');

/*Table structure for table `social_friend` */

DROP TABLE IF EXISTS `social_friend`;

CREATE TABLE `social_friend` (
  `id` bigint(20) NOT NULL,
  `user_one` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_two` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userOne` (`user_one`),
  KEY `userTwo` (`user_two`),
  CONSTRAINT `social_friend_ibfk_1` FOREIGN KEY (`user_one`) REFERENCES `social_userprofile` (`email`),
  CONSTRAINT `social_friend_ibfk_2` FOREIGN KEY (`user_two`) REFERENCES `social_userprofile` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `social_friend` */

insert  into `social_friend`(`id`,`user_one`,`user_two`) values (10,'andy@example.com','john@example.com'),(12,'andy@example.com','rk@example.com'),(13,'rk@example.com','sudhansu@gmail.com'),(14,'andy@example.com','sudhansu@gmail.com');

/*Table structure for table `social_userprofile` */

DROP TABLE IF EXISTS `social_userprofile`;

CREATE TABLE `social_userprofile` (
  `email` varchar(300) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `social_userprofile` */

insert  into `social_userprofile`(`email`) values ('andy@example.com'),('john@example.com'),('rk@example.com'),('rkvishwakarma@gmail.com'),('sudhansu@gmail.com'),('vishwakarma@gmail.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
