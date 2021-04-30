/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.19 : Database - library
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`library` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `library`;

/*Table structure for table `library_book` */

DROP TABLE IF EXISTS `library_book`;

CREATE TABLE `library_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) DEFAULT NULL,
  `price` float(7,4) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `writer` varchar(255) DEFAULT NULL,
  `publisher_date` date DEFAULT NULL,
  `book_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `library_book` */

/*Table structure for table `library_user` */

DROP TABLE IF EXISTS `library_user`;

CREATE TABLE `library_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `library_user` */

insert  into `library_user`(`id`,`user_name`,`user_password`,`gender`,`birthday`,`phone`,`address`) values (1,'abcde','1234567','男','1997-11-20','18232422389','江西南昌'),(2,'DEVSYX','123456','男','2021-04-08','18214929543','asfa'),(3,'admin','123','男','2021-04-28','18214929590','123'),(5,'三丰','123456','男','2021-04-21','18214929543','1234');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
