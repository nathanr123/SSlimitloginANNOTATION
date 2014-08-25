/*
SQLyog Ultimate v8.5 
MySQL - 5.5.28 : Database - rems_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rems_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `rems_db`;

/*Table structure for table `rems_group` */

DROP TABLE IF EXISTS `rems_group`;

CREATE TABLE `rems_group` (
  `groupid` varchar(10) NOT NULL,
  `groupname` varchar(35) DEFAULT NULL,
  `priority` smallint(6) DEFAULT NULL,
  `createdtime` datetime NOT NULL,
  `modifiedtime` datetime NOT NULL,
  PRIMARY KEY (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rems_group` */

insert  into `rems_group`(`groupid`,`groupname`,`priority`,`createdtime`,`modifiedtime`) values ('GRP0001','Group1',5,'2014-08-06 14:20:09','2014-08-06 14:20:09'),('GRP0002','Group2',4,'2014-08-06 14:20:09','2014-08-06 14:20:09'),('GRP0003','Group3',3,'2014-08-06 14:20:09','2014-08-06 14:20:09'),('GRP0004','Group4',2,'2014-08-06 14:20:09','2014-08-06 14:20:09'),('GRP0005','Group5',1,'2014-08-06 14:20:09','2014-08-06 14:20:09');

/*Table structure for table `rems_group_permission` */

DROP TABLE IF EXISTS `rems_group_permission`;

CREATE TABLE `rems_group_permission` (
  `groupid` varchar(10) NOT NULL,
  `component` varchar(35) DEFAULT NULL,
  `canread` tinyint(1) DEFAULT '1',
  `cancreate` tinyint(1) DEFAULT '0',
  `canmodify` tinyint(1) DEFAULT '0',
  `candelete` tinyint(1) DEFAULT '0',
  `createdtime` datetime NOT NULL,
  `modifiedtime` datetime NOT NULL,
  KEY `rems_group_permission_ibfk_1` (`groupid`),
  CONSTRAINT `rems_group_permission_ibfk_1` FOREIGN KEY (`groupid`) REFERENCES `rems_group` (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rems_group_permission` */

insert  into `rems_group_permission`(`groupid`,`component`,`canread`,`cancreate`,`canmodify`,`candelete`,`createdtime`,`modifiedtime`) values ('GRP0001','SWITCH',1,1,1,1,'2014-08-06 14:42:54','2014-08-06 14:42:54'),('GRP0001','USER',1,1,1,1,'2014-08-06 14:42:54','2014-08-06 14:42:54'),('GRP0001','GROUP',1,1,1,1,'2014-08-06 14:42:54','2014-08-06 14:42:54'),('GRP0002','SWITCH',1,1,1,0,'2014-08-06 14:42:54','2014-08-06 14:42:54'),('GRP0002','USER',1,1,1,0,'2014-08-06 14:42:54','2014-08-06 14:42:54'),('GRP0002','GROUP',1,1,1,0,'2014-08-06 14:42:54','2014-08-06 14:42:54'),('GRP0003','SWITCH',1,0,1,0,'2014-08-06 14:42:54','2014-08-06 14:42:54'),('GRP0003','USER',1,0,0,0,'2014-08-06 14:42:54','2014-08-06 14:42:54'),('GRP0003','GROUP',0,0,0,0,'2014-08-06 14:42:54','2014-08-06 14:42:54'),('GRP0004','SWITCH',1,0,1,0,'2014-08-06 14:42:54','2014-08-06 14:42:54'),('GRP0004','USER',0,0,0,0,'2014-08-06 14:42:54','2014-08-06 14:42:54'),('GRP0004','GROUP',0,0,0,0,'2014-08-06 14:42:54','2014-08-06 14:42:54'),('GRP0005','SWITCH',1,0,1,0,'2014-08-06 14:42:54','2014-08-06 14:42:54'),('GRP0005','USER',0,0,0,0,'2014-08-06 14:42:54','2014-08-06 14:42:54'),('GRP0005','GROUP',0,0,0,0,'2014-08-06 14:42:54','2014-08-06 14:42:54');

/*Table structure for table `rems_log` */

DROP TABLE IF EXISTS `rems_log`;

CREATE TABLE `rems_log` (
  `logid` bigint(20) NOT NULL AUTO_INCREMENT,
  `owner` varchar(16) NOT NULL,
  `ipaddress` varchar(15) DEFAULT NULL,
  `loggroup` varchar(20) DEFAULT NULL,
  `logdescription` text,
  `createdtime` datetime NOT NULL,
  PRIMARY KEY (`logid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `rems_log` */

insert  into `rems_log`(`logid`,`owner`,`ipaddress`,`loggroup`,`logdescription`,`createdtime`) values (1,'Server','localhost','SERVER','First Creation','2014-08-06 15:03:34'),(2,'user1','172.171.28','USER','updated Successfully','2014-08-06 15:03:34');

/*Table structure for table `rems_port` */

DROP TABLE IF EXISTS `rems_port`;

CREATE TABLE `rems_port` (
  `portid` varchar(10) NOT NULL,
  `switchid` varchar(10) DEFAULT NULL,
  `portname` varchar(10) DEFAULT NULL,
  `portnumber` smallint(6) DEFAULT NULL,
  `portstatus` varchar(15) DEFAULT NULL,
  `porttype` varchar(3) DEFAULT NULL,
  `createdtime` datetime NOT NULL,
  `modifiedtime` datetime NOT NULL,
  PRIMARY KEY (`portid`),
  KEY `switchid` (`switchid`),
  CONSTRAINT `rems_port_ibfk_1` FOREIGN KEY (`switchid`) REFERENCES `rems_switch` (`switchid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rems_port` */

insert  into `rems_port`(`portid`,`switchid`,`portname`,`portnumber`,`portstatus`,`porttype`,`createdtime`,`modifiedtime`) values ('PRT00001','SWT00001','Port 1',1,'ACTIVE','IN','2014-08-06 14:58:32','2014-08-06 14:58:32'),('PRT00017','SWT00001','Port 17',17,'ACTIVE','OUT','2014-08-06 14:58:32','2014-08-06 14:58:32');

/*Table structure for table `rems_switch` */

DROP TABLE IF EXISTS `rems_switch`;

CREATE TABLE `rems_switch` (
  `switchid` varchar(10) NOT NULL,
  `switchname` varchar(125) DEFAULT 'Switch 1',
  `switchip` varchar(15) DEFAULT '192.168.2.1',
  `switchport` smallint(6) DEFAULT '333',
  `modelname` varchar(125) DEFAULT NULL,
  `modelnumber` varchar(125) DEFAULT NULL,
  `serialnumber` varchar(125) DEFAULT NULL,
  `totalnoofports` smallint(6) DEFAULT NULL,
  `noofingress` smallint(6) DEFAULT NULL,
  `noofegress` smallint(6) DEFAULT NULL,
  `createdtime` datetime NOT NULL,
  `modifiedtime` datetime NOT NULL,
  PRIMARY KEY (`switchid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rems_switch` */

insert  into `rems_switch`(`switchid`,`switchname`,`switchip`,`switchport`,`modelname`,`modelnumber`,`serialnumber`,`totalnoofports`,`noofingress`,`noofegress`,`createdtime`,`modifiedtime`) values ('SWT00001','Switch 1','172.17.200.1',333,'Polatis Switch','8000','A6000FF888890',32,16,16,'2014-08-06 14:56:55','2014-08-06 14:56:55');

/*Table structure for table `rems_user` */

DROP TABLE IF EXISTS `rems_user`;

CREATE TABLE `rems_user` (
  `username` varchar(16) NOT NULL,
  `password` varchar(250) NOT NULL,
  `priority` smallint(6) DEFAULT NULL,
  `userrole` varchar(20) DEFAULT 'ROLE_ADMIN',
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `accountNonExpired` tinyint(1) NOT NULL DEFAULT '1',
  `accountNonLocked` tinyint(1) NOT NULL DEFAULT '1',
  `credentialsNonExpired` tinyint(1) NOT NULL DEFAULT '1',
  `createdtime` datetime NOT NULL,
  `modifiedtime` datetime NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rems_user` */

insert  into `rems_user`(`username`,`password`,`priority`,`userrole`,`enabled`,`accountNonExpired`,`accountNonLocked`,`credentialsNonExpired`,`createdtime`,`modifiedtime`) values ('admin','$2a$10$ed1Xoyj76HyHHf7W8wPWy.j3WgMawG1fY1FQS6O2eAqkZDUq54nZy',9,'ROLE_ADMIN',1,1,1,1,'2014-08-06 14:47:14','2014-08-06 14:47:14'),('admin12345','$2a$10$NSEOKLwoOEIjPMzgQvEoQOb.A/OsxYFcTY5VBfBKztyjElFnlkEa.',3,'ROLE_ADMIN',1,1,1,1,'2014-08-22 12:19:53','2014-08-22 12:19:53'),('admin123456','$2a$10$m9kCaf1OMsTgleGCpNxBSOdqqC73gR7eibQP2YhzUgE/0fPRqpdNG',3,'ROLE_ADMIN',1,1,1,1,'2014-08-22 12:58:11','2014-08-22 12:58:11'),('admin333','$2a$10$/ltzqfQBs5xrfCTfMmv3Be4PtSAynSw8uvwjjuUvXzmItriTEGJL2',2,'ROLE_ADMIN',1,1,1,1,'2014-08-22 13:28:27','2014-08-22 13:28:27'),('admin33334','$2a$10$Ov2m2yopH7JKJ.sMZZIXJeol3eDmPsVFLPmaHGQymfXegormkWcWm',2,'ROLE_ADMIN',1,1,1,1,'2014-08-22 13:31:33','2014-08-22 13:31:33'),('d','$2a$10$gAX.hXK90P6D/HjTg0AdM.QoeBrVWxU6HCp1jQG.iadP6TIRfrmFG',3,'ROLE_ADMIN',1,1,1,1,'2014-08-20 14:44:47','2014-08-20 14:44:47'),('dddd','$2a$10$U95LC/5tYFGTsioi1p8ucOUBIkEryzeaBCF0oK7U3MWOAVycwtwy6',2,'ROLE_ADMIN',1,1,1,1,'2014-08-20 14:27:53','2014-08-20 14:27:53'),('guest','$2a$10$z5YVgpr3kwK3aRgndfk3g.uG6wDxcQ4VcsZhaNL65eYZazi7Rquyy',1,'ROLE_ADMIN',1,1,1,1,'2014-08-06 14:47:14','2014-08-06 14:47:14'),('mkyongf','$2a$10$UZ4fUqFWcDmw45tx5mnHr.g9mLHWgYkUptZVP6P1OtClplLYyMnC6',4,'ROLE_ADMIN',1,1,1,1,'2014-08-20 14:30:15','2014-08-20 14:30:15'),('operator','$2a$10$mLqkq4xPu8kgRhkMkQ98J.HNe8GYbWcT5d2lI94UIbmPlyerjTihi',10,'ROLE_ADMIN',1,1,1,1,'2014-08-06 14:47:14','2014-08-06 14:47:14'),('qq','$2a$10$CrebD2tWk1r8cGyvo9y/W.ik9.eXuLvbhKfwX5FKLvGE6Pfoojh22',2,'ROLE_ADMIN',1,1,1,1,'2014-08-20 14:37:32','2014-08-20 14:37:32'),('s','$2a$10$11fKqIG5DnatDoCHEPLKy.u9rpL0W10ElCEA/6l3rqIy5As4nRYAy',4,'ROLE_ADMIN',1,1,1,1,'2014-08-20 14:43:15','2014-08-20 14:43:15'),('superadmin','$2a$10$h2G/rfo2Vl/9S//ZuSHn4O2TPmwA/W93BhYt1Ex5EK9m4ia0wjD72',10,'ROLE_ADMIN',1,1,1,1,'2014-08-06 14:47:00','2014-08-06 14:47:00'),('technician','$2a$10$AST0vXNBqfVTIS4R3Kgo3..3IH6SxE3R6zYVtuP5lSk2k/GaxXtAa',8,'ROLE_ADMIN',1,1,1,1,'2014-08-06 14:47:14','2014-08-06 14:47:14'),('yhutyu','$2a$10$DsqIYaaTjZmbg9GeLh0YSeX2YYc87sAn/M.cYcrCs4kPQmvA77u2G',1,'ROLE_ADMIN',1,1,1,1,'2014-08-20 14:33:32','2014-08-20 14:33:32'),('yu','$2a$10$EF24/CFFvRAsvg8WKbwdoujIF1Lp8.VtQhgIrTZuw.ECXVFXkDU8i',3,'ROLE_ADMIN',1,1,1,1,'2014-08-20 14:39:19','2014-08-20 14:39:19');

/*Table structure for table `rems_user_detail` */

DROP TABLE IF EXISTS `rems_user_detail`;

CREATE TABLE `rems_user_detail` (
  `username` varchar(16) NOT NULL,
  `fullname` varchar(35) NOT NULL,
  `mailid` varchar(124) NOT NULL,
  `mobilenumber` varchar(15) NOT NULL,
  `createdtime` datetime NOT NULL,
  `modifiedtime` datetime NOT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `rems_user_detail_ibfk_1` FOREIGN KEY (`username`) REFERENCES `rems_user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rems_user_detail` */

insert  into `rems_user_detail`(`username`,`fullname`,`mailid`,`mobilenumber`,`createdtime`,`modifiedtime`) values ('admin','R.Kamalanathan','nathanr.kamal@gmail.com','918939258346','2014-08-20 11:03:04','2014-08-20 11:03:04'),('admin123456','R.Kamalanathan','nathanr.kamal@gmail.com','8939258346','2014-08-22 13:38:39','2014-08-22 13:38:39'),('d','kongu','d','d','2014-08-20 14:45:28','2014-08-20 14:45:28'),('dddd','fd','df','df','2014-08-20 14:30:02','2014-08-20 14:30:02'),('guest','Guest','guest@gmail.com','9999988888','2014-08-20 10:52:39','2014-08-20 10:52:39'),('mkyongf','dfgdfdf','fdgdfg','dgdfgdfgf','2014-08-20 14:30:24','2014-08-20 14:30:24'),('qq','q','q','t','2014-08-20 14:37:48','2014-08-20 14:37:48'),('s','s','s','s','2014-08-20 14:43:19','2014-08-20 14:43:19'),('yhutyu','u','u','u','2014-08-20 14:33:35','2014-08-20 14:33:35'),('yu','yu','yu','yu','2014-08-20 14:39:25','2014-08-20 14:39:25');

/*Table structure for table `rems_users_grouplist` */

DROP TABLE IF EXISTS `rems_users_grouplist`;

CREATE TABLE `rems_users_grouplist` (
  `username` varchar(16) NOT NULL,
  `groupid` varchar(10) NOT NULL,
  PRIMARY KEY (`username`,`groupid`),
  KEY `rems_users_grouplist_ibfk_1` (`username`),
  KEY `rems_users_grouplist_ibfk_2` (`groupid`),
  CONSTRAINT `rems_users_grouplist_ibfk_1` FOREIGN KEY (`username`) REFERENCES `rems_user` (`username`),
  CONSTRAINT `rems_users_grouplist_ibfk_2` FOREIGN KEY (`groupid`) REFERENCES `rems_group` (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rems_users_grouplist` */

insert  into `rems_users_grouplist`(`username`,`groupid`) values ('admin','GRP0001'),('superadmin','GRP0001'),('admin','GRP0002'),('superadmin','GRP0002');

/*Table structure for table `user_attempts` */

DROP TABLE IF EXISTS `user_attempts`;

CREATE TABLE `user_attempts` (
  `username` varchar(45) NOT NULL,
  `attempts` varchar(45) NOT NULL,
  `lastModified` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_attempts` */

insert  into `user_attempts`(`username`,`attempts`,`lastModified`) values ('guest','1','2014-08-19 14:19:51');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
