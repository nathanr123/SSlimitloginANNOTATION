/*
SQLyog Ultimate v8.5 
MySQL - 5.1.23-rc-community : Database - rems_db
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
  `roleid` varchar(35) DEFAULT NULL,
  `priority` smallint(6) DEFAULT NULL,
  `createdtime` datetime NOT NULL,
  `modifiedtime` datetime NOT NULL,
  PRIMARY KEY (`groupid`),
  KEY `rems_group_ibfk_1` (`roleid`),
  CONSTRAINT `rems_group_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `rems_user_role` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rems_group` */

insert  into `rems_group`(`groupid`,`groupname`,`roleid`,`priority`,`createdtime`,`modifiedtime`) values ('GRP0001','Group1','SUPERADMIN',5,'2014-08-06 14:20:09','2014-08-06 14:20:09'),('GRP0002','Group2','ADMIN',4,'2014-08-06 14:20:09','2014-08-06 14:20:09'),('GRP0003','Group3','TECHNICIAN',3,'2014-08-06 14:20:09','2014-08-06 14:20:09'),('GRP0004','Group4','OPERATOR',2,'2014-08-06 14:20:09','2014-08-06 14:20:09'),('GRP0005','Group5','GUEST',1,'2014-08-06 14:20:09','2014-08-06 14:20:09');

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
  `password` varchar(16) NOT NULL,
  `priority` smallint(6) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `accountNonExpired` tinyint(1) NOT NULL DEFAULT '1',
  `accountNonLocked` tinyint(1) NOT NULL DEFAULT '1',
  `credentialsNonExpired` tinyint(1) NOT NULL DEFAULT '1',
  `createdtime` datetime NOT NULL,
  `modifiedtime` datetime NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rems_user` */

insert  into `rems_user`(`username`,`password`,`priority`,`enabled`,`accountNonExpired`,`accountNonLocked`,`credentialsNonExpired`,`createdtime`,`modifiedtime`) values ('admin','admin',9,1,1,0,1,'2014-08-06 14:47:14','2014-08-06 14:47:14'),('guest','guest',1,1,1,1,1,'2014-08-06 14:47:14','2014-08-06 14:47:14'),('operator','operator',10,1,1,1,1,'2014-08-06 14:47:14','2014-08-06 14:47:14'),('superadmin','superadmin',10,1,1,1,1,'2014-08-06 14:47:00','2014-08-06 14:47:00'),('technician','technician',8,1,1,1,1,'2014-08-06 14:47:14','2014-08-06 14:47:14');

/*Table structure for table `rems_user_attempts` */

DROP TABLE IF EXISTS `rems_user_attempts`;

CREATE TABLE `rems_user_attempts` (
  `username` varchar(16) NOT NULL,
  `nofattempts` tinyint(2) NOT NULL DEFAULT '0',
  `createdtime` datetime NOT NULL,
  `modifiedtime` datetime NOT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `rems_user_attempts_ibfk_1` FOREIGN KEY (`username`) REFERENCES `rems_user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rems_user_attempts` */

insert  into `rems_user_attempts`(`username`,`nofattempts`,`createdtime`,`modifiedtime`) values ('admin',3,'2014-08-06 14:53:24','2014-08-13 23:05:11');

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

insert  into `rems_user_detail`(`username`,`fullname`,`mailid`,`mobilenumber`,`createdtime`,`modifiedtime`) values ('admin','KAMALANATHAN','nathanr.kamal@gmail.com','8939258346','2014-08-06 14:50:56','2014-08-06 14:50:56');

/*Table structure for table `rems_user_role` */

DROP TABLE IF EXISTS `rems_user_role`;

CREATE TABLE `rems_user_role` (
  `roleid` varchar(35) NOT NULL,
  `roletype` varchar(35) NOT NULL DEFAULT 'ROLE_USER',
  `createdtime` datetime NOT NULL,
  `modifiedtime` datetime NOT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rems_user_role` */

insert  into `rems_user_role`(`roleid`,`roletype`,`createdtime`,`modifiedtime`) values ('ADMIN','ROLE_USER','2014-08-06 14:18:29','2014-08-06 14:18:29'),('GUEST','ROLE_USER','2014-08-06 14:18:30','2014-08-06 14:18:30'),('OPERATOR','ROLE_USER','2014-08-06 14:18:30','2014-08-06 14:18:30'),('SUPERADMIN','ROLE_ADMIN','2014-08-06 14:18:29','2014-08-06 14:18:29'),('TECHNICIAN','ROLE_USER','2014-08-06 14:18:29','2014-08-06 14:18:29');

/*Table structure for table `rems_users_grouplist` */

DROP TABLE IF EXISTS `rems_users_grouplist`;

CREATE TABLE `rems_users_grouplist` (
  `username` varchar(16) NOT NULL,
  `groupid` varchar(10) NOT NULL,
  `createdtime` datetime NOT NULL,
  `modifiedtime` datetime NOT NULL,
  KEY `rems_users_grouplist_ibfk_1` (`username`),
  KEY `rems_users_grouplist_ibfk_2` (`groupid`),
  CONSTRAINT `rems_users_grouplist_ibfk_1` FOREIGN KEY (`username`) REFERENCES `rems_user` (`username`),
  CONSTRAINT `rems_users_grouplist_ibfk_2` FOREIGN KEY (`groupid`) REFERENCES `rems_group` (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rems_users_grouplist` */

insert  into `rems_users_grouplist`(`username`,`groupid`,`createdtime`,`modifiedtime`) values ('superadmin','GRP0001','2014-08-07 18:30:36','2014-08-07 18:30:36'),('admin','GRP0002','2014-08-07 18:30:36','2014-08-07 18:30:36');

/*Table structure for table `user_roles` */

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `ROLE` varchar(45) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`ROLE`,`username`),
  KEY `fk_username_idx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `user_roles` */

insert  into `user_roles`(`user_role_id`,`username`,`ROLE`) values (1,'admin','ROLE_USER'),(2,'superadmin','ROLE_ADMIN');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
