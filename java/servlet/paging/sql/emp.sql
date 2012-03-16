/*
SQLyog Community Edition- MySQL GUI v5.25
Host - 5.0.45-community-nt : Database - oradb
*********************************************************************
Server version : 5.0.45-community-nt
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

USE `emp`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `deptno` int(2) NOT NULL,
  `dname` varchar(14) default NULL,
  `loc` varchar(13) default NULL,
  PRIMARY KEY  (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dept` */

insert  into `dept`(`deptno`,`dname`,`loc`) values (10,'ACCOUNTING','NEW YORK'),(20,'RESEARCH','DALLAS'),(30,'SALES','CHICAGO'),(40,'OPERATIONS','BOSTON');

/*Table structure for table `emp` */

DROP TABLE IF EXISTS `emp`;

CREATE TABLE `emp` (
  `empno` int(4) NOT NULL,
  `ename` varchar(10) default NULL,
  `job` varchar(9) default NULL,
  `mgr` int(4) default NULL,
  `hiredate` date default NULL,
  `sal` decimal(7,0) default NULL,
  `comm` decimal(7,0) default NULL,
  `deptno` int(2) default NULL,
  PRIMARY KEY  (`empno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `emp` */

insert  into `emp`(`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (7369,'SMITH','CLERK',7902,'1980-12-17','800',NULL,20),(7499,'ALLEN','SALESMAN',7698,'1981-02-20','1600','300',30),(7521,'WARD','SALESMAN',7698,'1981-02-22','1250','500',30),(7566,'JONES','MANAGER',7839,'1981-04-02','2975',NULL,20),(7654,'MARTIN','SALESMAN',7698,'1981-09-28','1250','1400',30),(7698,'BLAKE','MANAGER',7839,'1981-05-01','2850',NULL,30),(7782,'CLARK','MANAGER',7839,'1981-06-09','2450',NULL,10),(7788,'SCOTT','ANALYST',7566,'1987-04-19','3000',NULL,20),(7839,'KING','PRESIDENT',NULL,'1981-11-17','5000',NULL,10),(7844,'TURNER','SALESMAN',7698,'1981-09-08','1500','0',30),(7876,'ADAMS','CLERK',7788,'1987-05-23','1100',NULL,20),(7900,'JAMES','CLERK',7698,'1981-12-03','950',NULL,30),(7902,'FORD','ANALYST',7566,'1981-12-03','3000',NULL,20),(7934,'MILLER','CLERK',7782,'1982-01-23','1300',NULL,10);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;