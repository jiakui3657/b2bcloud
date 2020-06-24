-- --------------------------------------------------------
-- 主机:                           182.254.201.39
-- 服务器版本:                        5.6.47 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 b2bcloud 的数据库结构
DROP DATABASE IF EXISTS `b2bcloud`;
CREATE DATABASE IF NOT EXISTS `b2bcloud` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `b2bcloud`;

-- 导出  表 b2bcloud.area 结构
DROP TABLE IF EXISTS `area`;
CREATE TABLE IF NOT EXISTS `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `area_type` int(11) DEFAULT NULL,
  `fullName` varchar(20) DEFAULT NULL,
  `govCode` varchar(12) DEFAULT NULL,
  `lat` float DEFAULT NULL,
  `lng` float DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtn7all8h9e6fi9pspra60rht5` (`pid`),
  CONSTRAINT `FKtn7all8h9e6fi9pspra60rht5` FOREIGN KEY (`pid`) REFERENCES `area` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.area 的数据：~0 rows (大约)
DELETE FROM `area`;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
/*!40000 ALTER TABLE `area` ENABLE KEYS */;

-- 导出  表 b2bcloud.area_business_circle 结构
DROP TABLE IF EXISTS `area_business_circle`;
CREATE TABLE IF NOT EXISTS `area_business_circle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `area` tinyblob,
  `lat` float DEFAULT NULL,
  `lng` float DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.area_business_circle 的数据：~0 rows (大约)
DELETE FROM `area_business_circle`;
/*!40000 ALTER TABLE `area_business_circle` DISABLE KEYS */;
/*!40000 ALTER TABLE `area_business_circle` ENABLE KEYS */;

-- 导出  表 b2bcloud.article_link_tag 结构
DROP TABLE IF EXISTS `article_link_tag`;
CREATE TABLE IF NOT EXISTS `article_link_tag` (
  `Article_id` bigint(20) NOT NULL,
  `tags_id` bigint(20) NOT NULL,
  PRIMARY KEY (`Article_id`,`tags_id`),
  KEY `FKrsrf8uef04tsuc7nsepxx170n` (`tags_id`),
  CONSTRAINT `FK5lvmgukld3bx1x9g466m9e5tq` FOREIGN KEY (`Article_id`) REFERENCES `bs_tenant_article` (`id`),
  CONSTRAINT `FKrsrf8uef04tsuc7nsepxx170n` FOREIGN KEY (`tags_id`) REFERENCES `bs_tenant_article_tag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.article_link_tag 的数据：~0 rows (大约)
DELETE FROM `article_link_tag`;
/*!40000 ALTER TABLE `article_link_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_link_tag` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_config 结构
DROP TABLE IF EXISTS `bs_config`;
CREATE TABLE IF NOT EXISTS `bs_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(18) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKojhwfbool85ew4ynhl0ucfcgq` (`account_id`),
  CONSTRAINT `FKojhwfbool85ew4ynhl0ucfcgq` FOREIGN KEY (`account_id`) REFERENCES `sys_trade_account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_config 的数据：~0 rows (大约)
DELETE FROM `bs_config`;
/*!40000 ALTER TABLE `bs_config` DISABLE KEYS */;
INSERT INTO `bs_config` (`id`, `addDate`, `lastDate`, `name`, `phone`, `account_id`) VALUES
	(1, '2019-09-11 19:10:35', '2019-09-11 19:10:35', '后台管理系统', '', NULL);
/*!40000 ALTER TABLE `bs_config` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_exception_log 结构
DROP TABLE IF EXISTS `bs_exception_log`;
CREATE TABLE IF NOT EXISTS `bs_exception_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `note` longtext,
  `params` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_exception_log 的数据：~0 rows (大约)
DELETE FROM `bs_exception_log`;
/*!40000 ALTER TABLE `bs_exception_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_exception_log` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_function 结构
DROP TABLE IF EXISTS `bs_function`;
CREATE TABLE IF NOT EXISTS `bs_function` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `data_key` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `data_script` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9o27wrtudkkooqh2jp9r218hk` (`data_key`),
  KEY `FKgvfa7gpacspe5f3y88d6t6dh2` (`user_id`),
  CONSTRAINT `FKgvfa7gpacspe5f3y88d6t6dh2` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_function 的数据：~0 rows (大约)
DELETE FROM `bs_function`;
/*!40000 ALTER TABLE `bs_function` DISABLE KEYS */;
INSERT INTO `bs_function` (`id`, `addDate`, `lastDate`, `data_key`, `name`, `note`, `data_script`, `user_id`) VALUES
	(1, '2019-09-12 16:46:26', '2019-09-12 16:46:26', 'demo', 'demo', 'http://localhost:8080/web/function/demo.htm', 'import com.haoxuer.adminstore.rest.domain.response.MemberResponse;\r\nprint("hello world");\r\nresult=new MemberResponse();\r\nresult.setName("hello");', NULL);
/*!40000 ALTER TABLE `bs_function` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_product_price 结构
DROP TABLE IF EXISTS `bs_product_price`;
CREATE TABLE IF NOT EXISTS `bs_product_price` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `data_key` varchar(10) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgx2mvkyc1tbew193jc41qsehl` (`product_id`),
  CONSTRAINT `FKgx2mvkyc1tbew193jc41qsehl` FOREIGN KEY (`product_id`) REFERENCES `bs_tenant_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_product_price 的数据：~0 rows (大约)
DELETE FROM `bs_product_price`;
/*!40000 ALTER TABLE `bs_product_price` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_product_price` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_sn 结构
DROP TABLE IF EXISTS `bs_sn`;
CREATE TABLE IF NOT EXISTS `bs_sn` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `lastValue` bigint(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_sn 的数据：~0 rows (大约)
DELETE FROM `bs_sn`;
/*!40000 ALTER TABLE `bs_sn` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_sn` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_activity 结构
DROP TABLE IF EXISTS `bs_tenant_activity`;
CREATE TABLE IF NOT EXISTS `bs_tenant_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `activityType` int(11) DEFAULT NULL,
  `beginDate` datetime DEFAULT NULL,
  `days` int(11) DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `joinNum` int(11) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `money` decimal(19,2) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  `note` varchar(2000) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `refund` decimal(19,2) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `totalMoney` decimal(19,2) DEFAULT NULL,
  `vip` decimal(19,2) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `catalog_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK87xnigu3n9etrtm1ct8s1sn70` (`tenant_id`),
  KEY `FKl457gwyak7jbggr10pkmmmv6j` (`catalog_id`),
  CONSTRAINT `FK87xnigu3n9etrtm1ct8s1sn70` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKl457gwyak7jbggr10pkmmmv6j` FOREIGN KEY (`catalog_id`) REFERENCES `bs_tenant_activity_catalog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_activity 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_activity`;
/*!40000 ALTER TABLE `bs_tenant_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_activity` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_activity_catalog 结构
DROP TABLE IF EXISTS `bs_tenant_activity_catalog`;
CREATE TABLE IF NOT EXISTS `bs_tenant_activity_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsqan7u19dj9ldc3jb1viryifk` (`tenant_id`),
  KEY `FKs5ua27qu4jhwseljcdbjli5nr` (`parent_id`),
  CONSTRAINT `FKs5ua27qu4jhwseljcdbjli5nr` FOREIGN KEY (`parent_id`) REFERENCES `bs_tenant_activity_catalog` (`id`),
  CONSTRAINT `FKsqan7u19dj9ldc3jb1viryifk` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_activity_catalog 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_activity_catalog`;
/*!40000 ALTER TABLE `bs_tenant_activity_catalog` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_activity_catalog` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_activity_image 结构
DROP TABLE IF EXISTS `bs_tenant_activity_image`;
CREATE TABLE IF NOT EXISTS `bs_tenant_activity_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `label` varchar(20) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `activity_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2cux3tadj5ypuhlcsido2o4o1` (`activity_id`),
  CONSTRAINT `FK2cux3tadj5ypuhlcsido2o4o1` FOREIGN KEY (`activity_id`) REFERENCES `bs_tenant_activity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_activity_image 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_activity_image`;
/*!40000 ALTER TABLE `bs_tenant_activity_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_activity_image` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_activity_join 结构
DROP TABLE IF EXISTS `bs_tenant_activity_join`;
CREATE TABLE IF NOT EXISTS `bs_tenant_activity_join` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `money` decimal(19,2) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `tick` varchar(255) DEFAULT NULL,
  `activity_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc6hdr0uhxu619aujxmg1ssjko` (`activity_id`),
  KEY `FKnaa55oh6ik1dlp6d9wv1w5tum` (`user_id`),
  CONSTRAINT `FKc6hdr0uhxu619aujxmg1ssjko` FOREIGN KEY (`activity_id`) REFERENCES `bs_tenant_activity` (`id`),
  CONSTRAINT `FKnaa55oh6ik1dlp6d9wv1w5tum` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_activity_join 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_activity_join`;
/*!40000 ALTER TABLE `bs_tenant_activity_join` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_activity_join` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_ad 结构
DROP TABLE IF EXISTS `bs_tenant_ad`;
CREATE TABLE IF NOT EXISTS `bs_tenant_ad` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `beginDate` datetime DEFAULT NULL,
  `bussId` bigint(20) DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `adPosition_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9y5j60jbi6y136ipeynxabcno` (`tenant_id`),
  KEY `FKeatyqccc70idp0wm4efudyhoh` (`adPosition_id`),
  CONSTRAINT `FK9y5j60jbi6y136ipeynxabcno` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKeatyqccc70idp0wm4efudyhoh` FOREIGN KEY (`adPosition_id`) REFERENCES `bs_tenant_ad_position` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_ad 的数据：~6 rows (大约)
DELETE FROM `bs_tenant_ad`;
/*!40000 ALTER TABLE `bs_tenant_ad` DISABLE KEYS */;
INSERT INTO `bs_tenant_ad` (`id`, `addDate`, `lastDate`, `beginDate`, `bussId`, `catalog`, `endDate`, `note`, `path`, `sortNum`, `title`, `type`, `url`, `tenant_id`, `adPosition_id`) VALUES
	(1, '2020-06-03 10:35:08', '2020-06-03 10:35:08', NULL, NULL, NULL, NULL, '', 'http://file.metamall.cn/b2b/upload/image/202006/eb7c940e-43b2-45aa-8a19-c9afd87b4522.jpg', NULL, '11', NULL, '', 2, 2),
	(2, '2020-06-03 10:20:34', '2020-06-03 10:20:34', NULL, NULL, NULL, NULL, '', 'http://file.metamall.cn/b2b/upload/image/202006/dcd57f4e-ebaf-486a-bec2-42fb21dc8a64.jpg', NULL, '登录banner1', NULL, '', 2, 3),
	(3, '2020-05-08 22:44:50', '2020-05-08 22:44:50', NULL, NULL, NULL, NULL, '', 'http://file.metamall.cn/b2b/upload/image/202005/b72c6cae-26bc-4409-af0e-d45509b7e7be.png', NULL, '登录banner1', NULL, '', 1, 4),
	(4, '2020-05-08 22:45:06', '2020-05-08 22:45:06', NULL, NULL, NULL, NULL, '', 'http://file.metamall.cn/b2b/upload/image/202005/80b99d6b-9c60-40ad-84ae-9c473c0c3954.jpg', 7, 'wqewq', NULL, '', 1, 5),
	(5, '2020-06-03 10:32:07', '2020-06-03 10:32:07', NULL, NULL, NULL, NULL, '', 'http://file.metamall.cn/b2b/upload/image/202006/1d7a7a48-9344-4d16-bfdb-16d98ef1d383.jpg', NULL, '2132', NULL, '', 2, 2),
	(6, '2020-06-03 10:20:02', '2020-06-03 10:20:02', NULL, NULL, NULL, NULL, '', 'http://file.metamall.cn/b2b/upload/image/202006/a1f4d8da-dd9f-40f6-be7a-9e17504e1dad.jpg', NULL, '233', NULL, '', 2, 3);
/*!40000 ALTER TABLE `bs_tenant_ad` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_ad_position 结构
DROP TABLE IF EXISTS `bs_tenant_ad_position`;
CREATE TABLE IF NOT EXISTS `bs_tenant_ad_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `height` int(11) NOT NULL,
  `template` longtext NOT NULL,
  `width` int(11) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo2x9gf95pjfkfilode69wjgti` (`parent_id`),
  KEY `FKeydm2r6u3pkwb6pqct91k0bir` (`tenant_id`),
  CONSTRAINT `FKeydm2r6u3pkwb6pqct91k0bir` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKo2x9gf95pjfkfilode69wjgti` FOREIGN KEY (`parent_id`) REFERENCES `bs_tenant_ad_position` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_ad_position 的数据：~5 rows (大约)
DELETE FROM `bs_tenant_ad_position`;
/*!40000 ALTER TABLE `bs_tenant_ad_position` DISABLE KEYS */;
INSERT INTO `bs_tenant_ad_position` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `description`, `height`, `template`, `width`, `parent_id`, `tenant_id`) VALUES
	(1, '2019-12-28 15:34:09', '', '1', '2019-12-28 15:34:09', 1, 1, '根节点', 10, 0, NULL, 1, '', 1, NULL, NULL),
	(2, '2020-04-28 19:41:01', '1', '1,2', '2020-04-28 19:41:01', 2, 2, '首页banner', 3, NULL, NULL, 1, '', 1, 1, 2),
	(3, '2020-04-28 19:41:07', '2', '1,3', '2020-04-28 19:41:07', 2, 4, '登录banner', 5, NULL, NULL, 1, '', 1, 1, 2),
	(4, '2020-05-08 22:44:28', '1', '1,4', '2020-05-08 22:44:28', 2, 6, '首页广告', 7, NULL, NULL, 1, '', 1, 1, 1),
	(5, '2020-05-08 22:44:35', '2', '1,5', '2020-05-08 22:44:35', 2, 8, '登录广告', 9, NULL, NULL, 1, '', 1, 1, 1);
/*!40000 ALTER TABLE `bs_tenant_ad_position` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_area 结构
DROP TABLE IF EXISTS `bs_tenant_area`;
CREATE TABLE IF NOT EXISTS `bs_tenant_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `fullName` varchar(20) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lng` double DEFAULT NULL,
  `py` varchar(20) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsj493sdxym76fhigxytdsa0d6` (`tenant_id`),
  KEY `FK3bucvewprky2a9mli7b9nah4q` (`parent_id`),
  CONSTRAINT `FK3bucvewprky2a9mli7b9nah4q` FOREIGN KEY (`parent_id`) REFERENCES `bs_tenant_area` (`id`),
  CONSTRAINT `FKsj493sdxym76fhigxytdsa0d6` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_area 的数据：~3 rows (大约)
DELETE FROM `bs_tenant_area`;
/*!40000 ALTER TABLE `bs_tenant_area` DISABLE KEYS */;
INSERT INTO `bs_tenant_area` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `fullName`, `lat`, `lng`, `py`, `state`, `tenant_id`, `parent_id`) VALUES
	(1, '2020-03-20 16:59:22', '', '1', '2020-03-20 16:59:22', 1, 1, '根节点', 6, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '2020-03-20 17:04:05', '1', '1,2', '2020-03-20 17:04:05', 2, 2, '北京', 3, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1),
	(3, '2020-03-20 17:04:10', '2', '1,3', '2020-03-20 17:04:10', 2, 4, '陕西', 5, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1);
/*!40000 ALTER TABLE `bs_tenant_area` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_article 结构
DROP TABLE IF EXISTS `bs_tenant_article`;
CREATE TABLE IF NOT EXISTS `bs_tenant_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `comments` int(11) DEFAULT NULL,
  `exts` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `likes` int(11) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `note` text,
  `title` varchar(255) DEFAULT NULL,
  `ups` int(11) DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `catalog_id` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7i7g7t6g681dmubed6c2fqi69` (`tenant_id`),
  KEY `FKmabs6e8cwbpqnk33qwlowssqr` (`catalog_id`),
  KEY `FK7jluue0319k44lhkbpdfu79f1` (`user_id`),
  CONSTRAINT `FK7i7g7t6g681dmubed6c2fqi69` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FK7jluue0319k44lhkbpdfu79f1` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`),
  CONSTRAINT `FKmabs6e8cwbpqnk33qwlowssqr` FOREIGN KEY (`catalog_id`) REFERENCES `bs_tenant_article_catalog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_article 的数据：~1 rows (大约)
DELETE FROM `bs_tenant_article`;
/*!40000 ALTER TABLE `bs_tenant_article` DISABLE KEYS */;
INSERT INTO `bs_tenant_article` (`id`, `addDate`, `lastDate`, `comments`, `exts`, `introduction`, `likes`, `logo`, `note`, `title`, `ups`, `views`, `tenant_id`, `catalog_id`, `user_id`) VALUES
	(3, '2020-06-03 10:39:09', '2020-06-03 10:39:09', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/b2b/upload/image/202006/509e3f37-6874-45df-bf73-9d0f183f5319.jpg', '<p>陕西八鱼渭南油脂工业有限公司(SHAANXI BAYU LIPID CO., LTD.) 位于陕西省渭南高新区广通南路，占地130亩，是以从事油料收购及油脂加工、销售、科研为一体的民营企业。公司建于2002年，注册资金7938万元，至2012年年底总资产已逾10.89亿元，由**级乡镇企业家李振尧等5名自然人出资与**农业综合开发投资参股经营。公司产权清晰，法人治理结构完善，建立了较完备的现代企业管理制度，实行董事长领导下的总经理负责制。三会（股东会、董事会、监事会）齐全，班子结构合理，创新意识强烈。现有员工600余人，其中管理人员46人，专业技术人员42人。</p><p>　　多年来公司始终坚持恪守“诚实做人、质量立企”的宗旨，以市场需求为导向，以科技进步为重点，狠抓企业管理，经济效益和社会效益逐年递增。公司获得食品安全“QS”市场准入，获得全国放心粮油进农村进社区示范加工企业荣誉称号，被中国农业发展银行评为“AA”级信用企业，陕西银行同业协会“诚信企业”、陕西省“重合同，守信用”企业，被中国粮食协会评为2010年度“全国食用植物油加工50强企业”、中国食品工业协会评为“卓越绩效先进企业”。主打产品“八鱼”食用油被评为“放心粮油”， “陕西省**产品”。</p><p>【质量管理 Quality Management】</p><p>&nbsp; &nbsp; 质量是企业的生命，品牌是企业的灵魂。为强化产品质量，树立品牌形象，公司质管部门从原辅料购进、产品生产过程、入库出厂程序等方面都有一套严格的监管措施。严格控制原辅料质量，强化产品在制作过程的质量管理，完善、强化体系的管理，建立了一支质量意识强、专业技能强、责任心强的质量监督管理团队，公司质量管理体系、食品安全管理体系、环境管理体系、职业健康安全管理体系运作正常，管理有效。公司检、化验设施齐全，手段先进，有效地保证了食品安全，确保消费者能够吃到安全、放心、健康的食用油。</p><p>&nbsp; &nbsp;【生产能力 Manufacturing Capabilities】</p><p>&nbsp; &nbsp;公司拥有两条日加工500吨油料的压榨生产线、日加工300吨**食用油连续精炼生产线、10万吨小包装和中包装灌装生产线、并配有注塑吹瓶生产线，储油能力达5万吨。设备设施性能居业内**。年可加工各种油料30万吨，生产食用油10万吨。</p><p>&nbsp; &nbsp; 【主要产品 Main Products】</p><p>&nbsp; &nbsp; 以“为构建和谐社会提供营养健康、安全放心食用油”为己任，生产经营“八鱼” “同州老油坊”特香压榨菜籽油、一级菜籽油、一级大豆油、花生油、花生调和油、棉籽油等11个品种23个规格。主导产品“八鱼”特香压榨菜籽油精选西部地区（陕西、青海、内蒙等地）优质非转基因菜籽为原料，进行培炒压榨，再经中空纤维过滤而成。不接触任何化学试剂，保留了菜籽的原汁原味，味道浓郁，营养丰富；色泽浅，油烟小，有利于保护人体健康和厨房卫生，是高校、酒店、餐饮业以及家庭烹饪的*******产品。</p><p>&nbsp; &nbsp; 【科研开发 Research&amp;Development】</p><p>&nbsp; &nbsp; 以市场为导向，以科技创新为动力，不断提升企业核心竞争力。与**粮食局西安油脂科学研究设计院合作，建立了国内*******的油脂科研中试基地，建设有完善的食用油质检中心，装备了气象色谱仪，并配备了齐全的标准油色柱等一批先进检测仪器。瞄准国内外油脂生产前沿技术，研究开发适合我国实际的油脂深加工新技术和新产品，促进科技成果产业化，成为西北地区食用油生产的骨干企业。</p><p>&nbsp; &nbsp; 【市场销售 Market Sales】</p><p>&nbsp; &nbsp; 公司以直销和区域经销商相结合的销售模式，自建网络连锁配送，深度分销、掌控终端，建立了完善的销售网络体系。先做好立西安、宝鸡、咸阳、渭南、铜川等地市场、不断向陕南陕北辐射。现有专业销售人员300余名，配送车辆160多台。目前在省内各地市有近130家分销站和经销商，终端零售店达10000多户。公司制定了依托陕西市场不断进军周边省市的战略规划，力争在十二五末食用油销售突破20万吨。</p><p>&nbsp; &nbsp; 【原料基地 Bases of Raw Materials】</p><p>&nbsp; &nbsp; 以农业产业化为支撑，积极发展“定单农业”，以“公司+合作社+农户”的模式，积极推广优质花生、“双低”油菜籽品种，建立原料基地100万亩，带动7万农户走订单农业路子。合作社有组织带动农户的功能，能及时解决基地建设中遇到的问题，组织订单生产，及时搞好各项相关服务，组织农户搞好“双低”油菜的生产、经营和统一销售，确保优质原料的产出，确保农户认真履行订单义务。公司70%的加工原料来自省内合作社和农户，有力推动了农村产业结构调整，促进和带动农民增收。</p><p>&nbsp; &nbsp; 【企业文化 Company Culture】</p><p>&nbsp; &nbsp; 公司行政、人事、宣传、党工群机构齐全，企业文化健康向上。以“诚实做人、质量立企”为企业精神，以“为农民搭建致富增收的平台，为实现农业产业化不懈探路，为构建和谐社会提供营养健康、安全放心食用油，为实现八鱼人共同</p><p><br/></p>', '好油脂，八鱼造', NULL, NULL, 2, NULL, NULL);
/*!40000 ALTER TABLE `bs_tenant_article` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_article_catalog 结构
DROP TABLE IF EXISTS `bs_tenant_article_catalog`;
CREATE TABLE IF NOT EXISTS `bs_tenant_article_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `nums` bigint(20) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcgsi0w1kfw65vp4fuy0xnr748` (`tenant_id`),
  KEY `FK230rehh9ts9nq9k1vu1teylxp` (`parent_id`),
  CONSTRAINT `FK230rehh9ts9nq9k1vu1teylxp` FOREIGN KEY (`parent_id`) REFERENCES `bs_tenant_article_catalog` (`id`),
  CONSTRAINT `FKcgsi0w1kfw65vp4fuy0xnr748` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_article_catalog 的数据：~2 rows (大约)
DELETE FROM `bs_tenant_article_catalog`;
/*!40000 ALTER TABLE `bs_tenant_article_catalog` DISABLE KEYS */;
INSERT INTO `bs_tenant_article_catalog` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `nums`, `tenant_id`, `parent_id`) VALUES
	(1, '2020-05-02 17:45:41', '', '1', '2020-05-02 17:45:41', 1, 1, '根节点', 6, 0, NULL, NULL, NULL),
	(2, '2020-05-02 17:45:49', '1', '1,2', '2020-05-02 17:45:49', 2, 2, '公司新闻', 3, NULL, NULL, 2, 1),
	(3, '2020-05-02 17:45:54', '2', '1,3', '2020-05-02 17:45:54', 2, 4, '公司动态', 5, NULL, NULL, 2, 1);
/*!40000 ALTER TABLE `bs_tenant_article_catalog` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_article_comment 结构
DROP TABLE IF EXISTS `bs_tenant_article_comment`;
CREATE TABLE IF NOT EXISTS `bs_tenant_article_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `contents` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `article_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKotfbwk3r1yh4g5i8cd8lfbnq9` (`tenant_id`),
  KEY `FKskwlwdy8vjr3o8lpnv5fvjyao` (`article_id`),
  KEY `FKrlt0s3idiiyrl0r60cij4ycug` (`user_id`),
  CONSTRAINT `FKotfbwk3r1yh4g5i8cd8lfbnq9` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKrlt0s3idiiyrl0r60cij4ycug` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`),
  CONSTRAINT `FKskwlwdy8vjr3o8lpnv5fvjyao` FOREIGN KEY (`article_id`) REFERENCES `bs_tenant_article` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_article_comment 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_article_comment`;
/*!40000 ALTER TABLE `bs_tenant_article_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_article_comment` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_article_like 结构
DROP TABLE IF EXISTS `bs_tenant_article_like`;
CREATE TABLE IF NOT EXISTS `bs_tenant_article_like` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `article_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgy20jr34a7u81ar5w695c4imp` (`tenant_id`),
  KEY `FKjy2b4f1xd5gwfki02hwwqfafb` (`article_id`),
  KEY `FKpieo7f981mnobww3ix3oqdgeo` (`user_id`),
  CONSTRAINT `FKgy20jr34a7u81ar5w695c4imp` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKjy2b4f1xd5gwfki02hwwqfafb` FOREIGN KEY (`article_id`) REFERENCES `bs_tenant_article` (`id`),
  CONSTRAINT `FKpieo7f981mnobww3ix3oqdgeo` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_article_like 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_article_like`;
/*!40000 ALTER TABLE `bs_tenant_article_like` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_article_like` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_article_sensitive_category 结构
DROP TABLE IF EXISTS `bs_tenant_article_sensitive_category`;
CREATE TABLE IF NOT EXISTS `bs_tenant_article_sensitive_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9rnpa4yakjtkf2m9h4iflpcpq` (`tenant_id`),
  KEY `FKsp7ynwb2m1lhhhvxbmiv9ogd2` (`parent_id`),
  CONSTRAINT `FK9rnpa4yakjtkf2m9h4iflpcpq` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKsp7ynwb2m1lhhhvxbmiv9ogd2` FOREIGN KEY (`parent_id`) REFERENCES `bs_tenant_article_sensitive_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_article_sensitive_category 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_article_sensitive_category`;
/*!40000 ALTER TABLE `bs_tenant_article_sensitive_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_article_sensitive_category` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_article_sensitive_word 结构
DROP TABLE IF EXISTS `bs_tenant_article_sensitive_word`;
CREATE TABLE IF NOT EXISTS `bs_tenant_article_sensitive_word` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `replace_word` varchar(255) DEFAULT NULL,
  `word_size` int(11) DEFAULT NULL,
  `word` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfk27g2xg95arukd3xcal6fg8v` (`tenant_id`),
  KEY `FKh87yq0s4ufbxpc4x57wssvgrx` (`category_id`),
  KEY `FKmahmsgvp078d4l96n3rfaf9v0` (`user_id`),
  CONSTRAINT `FKfk27g2xg95arukd3xcal6fg8v` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKh87yq0s4ufbxpc4x57wssvgrx` FOREIGN KEY (`category_id`) REFERENCES `bs_tenant_article_sensitive_category` (`id`),
  CONSTRAINT `FKmahmsgvp078d4l96n3rfaf9v0` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_article_sensitive_word 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_article_sensitive_word`;
/*!40000 ALTER TABLE `bs_tenant_article_sensitive_word` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_article_sensitive_word` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_article_tag 结构
DROP TABLE IF EXISTS `bs_tenant_article_tag`;
CREATE TABLE IF NOT EXISTS `bs_tenant_article_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7e0gqxqth6ts26kqxlqqul2oh` (`tenant_id`),
  CONSTRAINT `FK7e0gqxqth6ts26kqxlqqul2oh` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_article_tag 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_article_tag`;
/*!40000 ALTER TABLE `bs_tenant_article_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_article_tag` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_article_user_catalog 结构
DROP TABLE IF EXISTS `bs_tenant_article_user_catalog`;
CREATE TABLE IF NOT EXISTS `bs_tenant_article_user_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `nums` bigint(20) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg475hrq2xy9xklk27c3g9i412` (`tenant_id`),
  KEY `FK5whqloyunogisovc2koana5j9` (`parent_id`),
  CONSTRAINT `FK5whqloyunogisovc2koana5j9` FOREIGN KEY (`parent_id`) REFERENCES `bs_tenant_article_user_catalog` (`id`),
  CONSTRAINT `FKg475hrq2xy9xklk27c3g9i412` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_article_user_catalog 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_article_user_catalog`;
/*!40000 ALTER TABLE `bs_tenant_article_user_catalog` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_article_user_catalog` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_attribute 结构
DROP TABLE IF EXISTS `bs_tenant_attribute`;
CREATE TABLE IF NOT EXISTS `bs_tenant_attribute` (
  `tenant_id` bigint(20) NOT NULL,
  `attr` varchar(300) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`tenant_id`,`name`),
  CONSTRAINT `FKro9ak7vwhcawdbu79ihcmejpa` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_attribute 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_attribute`;
/*!40000 ALTER TABLE `bs_tenant_attribute` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_attribute` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_brand 结构
DROP TABLE IF EXISTS `bs_tenant_brand`;
CREATE TABLE IF NOT EXISTS `bs_tenant_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `catalog_id` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbbeotdrw8rjru3xj7tddlaajs` (`tenant_id`),
  KEY `FKqx08gjqu92vgv5oy7w85sry46` (`catalog_id`),
  CONSTRAINT `FKbbeotdrw8rjru3xj7tddlaajs` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKqx08gjqu92vgv5oy7w85sry46` FOREIGN KEY (`catalog_id`) REFERENCES `bs_tenant_brand_catalog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_brand 的数据：~4 rows (大约)
DELETE FROM `bs_tenant_brand`;
/*!40000 ALTER TABLE `bs_tenant_brand` DISABLE KEYS */;
INSERT INTO `bs_tenant_brand` (`id`, `addDate`, `lastDate`, `logo`, `name`, `note`, `tenant_id`, `catalog_id`, `sortNum`) VALUES
	(1, '2020-03-23 16:28:24', '2020-03-23 16:28:24', '', '可口可乐', '<p>可口可乐</p>', 1, NULL, NULL),
	(3, '2020-05-07 20:30:15', '2020-05-07 20:30:15', NULL, '纽百特', NULL, 2, NULL, NULL),
	(4, '2020-05-08 22:58:03', '2020-05-08 22:58:03', NULL, '金龙鱼', NULL, 2, NULL, NULL),
	(5, '2020-06-02 15:52:50', '2020-06-02 15:52:50', 'http://file.metamall.cn/b2b/upload/image/202006/65a4212b-5354-43a7-86fa-c544cf1c7121.jpg', '八鱼', NULL, 2, NULL, NULL);
/*!40000 ALTER TABLE `bs_tenant_brand` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_brand_catalog 结构
DROP TABLE IF EXISTS `bs_tenant_brand_catalog`;
CREATE TABLE IF NOT EXISTS `bs_tenant_brand_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKefjkiw317oy0vplwnlgpece3s` (`tenant_id`),
  KEY `FK410ijoen8j5qpt7mu8cwuora0` (`parent_id`),
  CONSTRAINT `FK410ijoen8j5qpt7mu8cwuora0` FOREIGN KEY (`parent_id`) REFERENCES `bs_tenant_brand_catalog` (`id`),
  CONSTRAINT `FKefjkiw317oy0vplwnlgpece3s` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_brand_catalog 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_brand_catalog`;
/*!40000 ALTER TABLE `bs_tenant_brand_catalog` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_brand_catalog` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_brand_store 结构
DROP TABLE IF EXISTS `bs_tenant_brand_store`;
CREATE TABLE IF NOT EXISTS `bs_tenant_brand_store` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `lat` float DEFAULT NULL,
  `lng` float DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqs4a8yh3nne400gb4gpnmju91` (`tenant_id`),
  CONSTRAINT `FKqs4a8yh3nne400gb4gpnmju91` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_brand_store 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_brand_store`;
/*!40000 ALTER TABLE `bs_tenant_brand_store` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_brand_store` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_common_industry 结构
DROP TABLE IF EXISTS `bs_tenant_common_industry`;
CREATE TABLE IF NOT EXISTS `bs_tenant_common_industry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsyv7q12179ua44slpsgsmhuwc` (`tenant_id`),
  KEY `FKjis9fl3m9jmr47a1g1jfkqyhr` (`parent_id`),
  CONSTRAINT `FKjis9fl3m9jmr47a1g1jfkqyhr` FOREIGN KEY (`parent_id`) REFERENCES `bs_tenant_common_industry` (`id`),
  CONSTRAINT `FKsyv7q12179ua44slpsgsmhuwc` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_common_industry 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_common_industry`;
/*!40000 ALTER TABLE `bs_tenant_common_industry` DISABLE KEYS */;
INSERT INTO `bs_tenant_common_industry` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `tenant_id`, `parent_id`) VALUES
	(1, '2020-06-02 16:35:39', '', '1', '2020-06-02 16:35:39', 1, 1, '根节点', 2, 0, NULL, NULL);
/*!40000 ALTER TABLE `bs_tenant_common_industry` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_finance_bill 结构
DROP TABLE IF EXISTS `bs_tenant_finance_bill`;
CREATE TABLE IF NOT EXISTS `bs_tenant_finance_bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1t5flj02rn0bkp352dg6qpd7y` (`tenant_id`),
  CONSTRAINT `FK1t5flj02rn0bkp352dg6qpd7y` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_finance_bill 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_finance_bill`;
/*!40000 ALTER TABLE `bs_tenant_finance_bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_finance_bill` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_finance_invoice 结构
DROP TABLE IF EXISTS `bs_tenant_finance_invoice`;
CREATE TABLE IF NOT EXISTS `bs_tenant_finance_invoice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `bankName` varchar(255) DEFAULT NULL,
  `bankNo` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `taxNo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt4eadii4oe05vo7p8dfi8u3r5` (`tenant_id`),
  CONSTRAINT `FKt4eadii4oe05vo7p8dfi8u3r5` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_finance_invoice 的数据：~2 rows (大约)
DELETE FROM `bs_tenant_finance_invoice`;
/*!40000 ALTER TABLE `bs_tenant_finance_invoice` DISABLE KEYS */;
INSERT INTO `bs_tenant_finance_invoice` (`id`, `addDate`, `lastDate`, `tenant_id`, `address`, `bankName`, `bankNo`, `name`, `phone`, `taxNo`) VALUES
	(2, '2020-05-15 16:31:38', '2020-05-15 16:31:38', 2, '', '', '', '1', '', '1'),
	(4, '2020-05-15 16:32:57', '2020-05-15 16:32:57', 2, '', '', '1', '', '1', '1');
/*!40000 ALTER TABLE `bs_tenant_finance_invoice` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_finance_stream 结构
DROP TABLE IF EXISTS `bs_tenant_finance_stream`;
CREATE TABLE IF NOT EXISTS `bs_tenant_finance_stream` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdm02tdwu7250m9s35vm0kup0e` (`tenant_id`),
  CONSTRAINT `FKdm02tdwu7250m9s35vm0kup0e` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_finance_stream 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_finance_stream`;
/*!40000 ALTER TABLE `bs_tenant_finance_stream` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_finance_stream` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_mall_customer_address 结构
DROP TABLE IF EXISTS `bs_tenant_mall_customer_address`;
CREATE TABLE IF NOT EXISTS `bs_tenant_mall_customer_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lng` double DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlsv3kn4t81ubem7samoay518x` (`tenant_id`),
  KEY `FKgpukqex7sy5erxj8wpeiaxpqb` (`customer_id`),
  CONSTRAINT `FKgpukqex7sy5erxj8wpeiaxpqb` FOREIGN KEY (`customer_id`) REFERENCES `bs_tenant_user` (`id`),
  CONSTRAINT `FKlsv3kn4t81ubem7samoay518x` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_mall_customer_address 的数据：~3 rows (大约)
DELETE FROM `bs_tenant_mall_customer_address`;
/*!40000 ALTER TABLE `bs_tenant_mall_customer_address` DISABLE KEYS */;
INSERT INTO `bs_tenant_mall_customer_address` (`id`, `addDate`, `lastDate`, `address`, `code`, `lat`, `lng`, `name`, `note`, `phone`, `tel`, `tenant_id`, `customer_id`, `updateDate`) VALUES
	(38, '2020-06-03 23:26:16', '2020-06-11 10:50:00', '陕西省西安市新城区西六路9号', NULL, NULL, NULL, 'ada', NULL, '18229060103', NULL, 2, 96, '2020-06-11 10:50:00'),
	(39, '2020-06-04 10:14:22', '2020-06-04 15:48:16', '陕西省西安市未央区龙首北路西段1号', NULL, NULL, NULL, 'wiuq', NULL, '123', NULL, 2, 96, '2020-06-04 15:48:16'),
	(40, '2020-06-04 10:25:39', '2020-06-04 10:25:39', '陕西省西安市未央区未央路177号旺景国际大厦', NULL, NULL, NULL, '无一', NULL, '17391722580', NULL, 2, 96, '2020-06-04 10:25:39');
/*!40000 ALTER TABLE `bs_tenant_mall_customer_address` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_mall_customer_level 结构
DROP TABLE IF EXISTS `bs_tenant_mall_customer_level`;
CREATE TABLE IF NOT EXISTS `bs_tenant_mall_customer_level` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `money` decimal(19,2) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rebate` decimal(19,2) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2cfkegm4wpusqfyyqy34ky57j` (`tenant_id`),
  CONSTRAINT `FK2cfkegm4wpusqfyyqy34ky57j` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_mall_customer_level 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_mall_customer_level`;
/*!40000 ALTER TABLE `bs_tenant_mall_customer_level` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_mall_customer_level` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_mall_customer_shop_cart 结构
DROP TABLE IF EXISTS `bs_tenant_mall_customer_shop_cart`;
CREATE TABLE IF NOT EXISTS `bs_tenant_mall_customer_shop_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4cvbyrxrt9qs674xtughw3srg` (`tenant_id`),
  KEY `FK9btjc8j9aoyq9uifopk8inooq` (`user_id`),
  CONSTRAINT `FK4cvbyrxrt9qs674xtughw3srg` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FK9btjc8j9aoyq9uifopk8inooq` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_mall_customer_shop_cart 的数据：~1 rows (大约)
DELETE FROM `bs_tenant_mall_customer_shop_cart`;
/*!40000 ALTER TABLE `bs_tenant_mall_customer_shop_cart` DISABLE KEYS */;
INSERT INTO `bs_tenant_mall_customer_shop_cart` (`id`, `addDate`, `lastDate`, `num`, `tenant_id`, `user_id`) VALUES
	(1, '2020-05-25 15:23:58', '2020-05-25 15:23:58', 0, 2, 96),
	(2, '2020-05-27 19:38:44', '2020-05-27 19:38:44', 0, 2, 98);
/*!40000 ALTER TABLE `bs_tenant_mall_customer_shop_cart` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_mall_customer_shop_cart_item 结构
DROP TABLE IF EXISTS `bs_tenant_mall_customer_shop_cart_item`;
CREATE TABLE IF NOT EXISTS `bs_tenant_mall_customer_shop_cart_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `total` decimal(19,2) DEFAULT NULL,
  `trade` bit(1) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `cart_id` bigint(20) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `sku_id` bigint(20) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKln1ir085i0f3brsa7h7ml22bp` (`tenant_id`),
  KEY `FKm5t5xhwybebsi5iqmftjrxgk4` (`cart_id`),
  KEY `FK55f8jgnxru98ooipdfliiyi3r` (`item_id`),
  KEY `FKbl2qbq7h873mguihmc6xi2pc7` (`product_id`),
  KEY `FKrskagigps5y01dlnq2pn26j1a` (`sku_id`),
  KEY `FKhppoidcagr0j29e8i2p03q7kj` (`store_id`),
  KEY `FKp6opv2vigm5qyfp3v152l36df` (`user_id`),
  CONSTRAINT `FK55f8jgnxru98ooipdfliiyi3r` FOREIGN KEY (`item_id`) REFERENCES `bs_tenant_order_trade_item` (`id`),
  CONSTRAINT `FKbl2qbq7h873mguihmc6xi2pc7` FOREIGN KEY (`product_id`) REFERENCES `bs_tenant_product` (`id`),
  CONSTRAINT `FKhppoidcagr0j29e8i2p03q7kj` FOREIGN KEY (`store_id`) REFERENCES `bs_tenant_store_info` (`id`),
  CONSTRAINT `FKln1ir085i0f3brsa7h7ml22bp` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKm5t5xhwybebsi5iqmftjrxgk4` FOREIGN KEY (`cart_id`) REFERENCES `bs_tenant_mall_customer_shop_cart` (`id`),
  CONSTRAINT `FKp6opv2vigm5qyfp3v152l36df` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`),
  CONSTRAINT `FKrskagigps5y01dlnq2pn26j1a` FOREIGN KEY (`sku_id`) REFERENCES `bs_tenant_product_sku` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_mall_customer_shop_cart_item 的数据：~3 rows (大约)
DELETE FROM `bs_tenant_mall_customer_shop_cart_item`;
/*!40000 ALTER TABLE `bs_tenant_mall_customer_shop_cart_item` DISABLE KEYS */;
INSERT INTO `bs_tenant_mall_customer_shop_cart_item` (`id`, `addDate`, `lastDate`, `price`, `size`, `total`, `trade`, `tenant_id`, `cart_id`, `item_id`, `product_id`, `sku_id`, `store_id`, `user_id`) VALUES
	(13, '2020-05-27 19:38:44', '2020-05-27 19:38:44', 43.00, 1, 43.00, b'1', 2, 2, NULL, 17, NULL, NULL, 98),
	(14, '2020-05-27 19:38:45', '2020-05-27 19:38:45', 34.00, 1, 34.00, b'1', 2, 2, NULL, 18, NULL, NULL, 98),
	(117, '2020-06-12 15:31:02', '2020-06-12 15:32:44', 0.01, 1, 0.01, NULL, 2, 1, NULL, 17, NULL, NULL, 96),
	(119, '2020-06-13 22:40:02', '2020-06-13 22:40:02', 85.90, 1, 85.90, NULL, 2, 1, NULL, 16, NULL, NULL, 96);
/*!40000 ALTER TABLE `bs_tenant_mall_customer_shop_cart_item` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_mall_customer_tag 结构
DROP TABLE IF EXISTS `bs_tenant_mall_customer_tag`;
CREATE TABLE IF NOT EXISTS `bs_tenant_mall_customer_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `num` bigint(20) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3omq2fe96sc2x44hk6fu7p6jp` (`tenant_id`),
  CONSTRAINT `FK3omq2fe96sc2x44hk6fu7p6jp` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_mall_customer_tag 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_mall_customer_tag`;
/*!40000 ALTER TABLE `bs_tenant_mall_customer_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_mall_customer_tag` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_mall_customer_to_tag 结构
DROP TABLE IF EXISTS `bs_tenant_mall_customer_to_tag`;
CREATE TABLE IF NOT EXISTS `bs_tenant_mall_customer_to_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `tag_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqink16v000nomguvmi40d6ymm` (`tenant_id`),
  KEY `FKa2ndpdc1jmof2d062g0h9k8mj` (`customer_id`),
  KEY `FKnkue1eo89505j2hch2o8maoe6` (`tag_id`),
  CONSTRAINT `FKa2ndpdc1jmof2d062g0h9k8mj` FOREIGN KEY (`customer_id`) REFERENCES `bs_tenant_user` (`id`),
  CONSTRAINT `FKnkue1eo89505j2hch2o8maoe6` FOREIGN KEY (`tag_id`) REFERENCES `bs_tenant_mall_customer_tag` (`id`),
  CONSTRAINT `FKqink16v000nomguvmi40d6ymm` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_mall_customer_to_tag 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_mall_customer_to_tag`;
/*!40000 ALTER TABLE `bs_tenant_mall_customer_to_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_mall_customer_to_tag` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_mall_goods 结构
DROP TABLE IF EXISTS `bs_tenant_mall_goods`;
CREATE TABLE IF NOT EXISTS `bs_tenant_mall_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
  `merchant` varchar(255) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `note` varchar(30) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `brand_id` bigint(20) DEFAULT NULL,
  `catalog_id` int(11) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb76p09rp83kdibpqwqa7axptl` (`tenant_id`),
  KEY `FKevg3ong8yvy7wadx4cfkjkeq9` (`brand_id`),
  KEY `FKs54gim0axwdbpec0t92qjg7i3` (`catalog_id`),
  CONSTRAINT `FKb76p09rp83kdibpqwqa7axptl` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKevg3ong8yvy7wadx4cfkjkeq9` FOREIGN KEY (`brand_id`) REFERENCES `bs_tenant_mall_goods_brand` (`id`),
  CONSTRAINT `FKs54gim0axwdbpec0t92qjg7i3` FOREIGN KEY (`catalog_id`) REFERENCES `bs_tenant_mall_goods_catalog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_mall_goods 的数据：~4 rows (大约)
DELETE FROM `bs_tenant_mall_goods`;
/*!40000 ALTER TABLE `bs_tenant_mall_goods` DISABLE KEYS */;
INSERT INTO `bs_tenant_mall_goods` (`id`, `addDate`, `lastDate`, `code`, `merchant`, `name`, `note`, `tenant_id`, `brand_id`, `catalog_id`, `img`, `label`, `unit`, `status`) VALUES
	(1, '2019-12-29 18:26:41', '2019-12-29 18:26:41', NULL, NULL, '铅笔', '123', 1, 3, NULL, NULL, NULL, NULL, NULL),
	(2, '2019-12-29 18:28:11', '2019-12-29 18:28:11', NULL, NULL, '铅笔', '123', 1, 3, 2, NULL, NULL, NULL, NULL),
	(3, '2020-04-30 20:11:40', '2020-04-30 20:11:40', NULL, NULL, '厂牌/型号', '1', 1, 3, 3, NULL, NULL, NULL, NULL),
	(4, '2020-04-30 20:11:53', '2020-04-30 20:11:53', NULL, NULL, '11', '', 1, 3, 3, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `bs_tenant_mall_goods` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_mall_goods_brand 结构
DROP TABLE IF EXISTS `bs_tenant_mall_goods_brand`;
CREATE TABLE IF NOT EXISTS `bs_tenant_mall_goods_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8t1logps8fd92v82ewq7n0uuy` (`tenant_id`),
  CONSTRAINT `FK8t1logps8fd92v82ewq7n0uuy` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_mall_goods_brand 的数据：~3 rows (大约)
DELETE FROM `bs_tenant_mall_goods_brand`;
/*!40000 ALTER TABLE `bs_tenant_mall_goods_brand` DISABLE KEYS */;
INSERT INTO `bs_tenant_mall_goods_brand` (`id`, `addDate`, `lastDate`, `tenant_id`, `logo`, `name`, `status`) VALUES
	(1, '2019-12-29 16:37:35', '2019-12-29 16:37:35', 1, '11', '金龙鱼', '1'),
	(2, '2019-12-29 18:05:08', '2019-12-29 18:05:08', 1, '', '联想', '1'),
	(3, '2019-12-29 18:19:13', '2019-12-29 18:19:14', 1, '', '索尼', '1');
/*!40000 ALTER TABLE `bs_tenant_mall_goods_brand` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_mall_goods_catalog 结构
DROP TABLE IF EXISTS `bs_tenant_mall_goods_catalog`;
CREATE TABLE IF NOT EXISTS `bs_tenant_mall_goods_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKddc8bootge34agmlwy63okgvu` (`tenant_id`),
  KEY `FKbyvrndm8wfrp1fhhxyecs6o6n` (`parent_id`),
  CONSTRAINT `FKbyvrndm8wfrp1fhhxyecs6o6n` FOREIGN KEY (`parent_id`) REFERENCES `bs_tenant_mall_goods_catalog` (`id`),
  CONSTRAINT `FKddc8bootge34agmlwy63okgvu` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_mall_goods_catalog 的数据：~5 rows (大约)
DELETE FROM `bs_tenant_mall_goods_catalog`;
/*!40000 ALTER TABLE `bs_tenant_mall_goods_catalog` DISABLE KEYS */;
INSERT INTO `bs_tenant_mall_goods_catalog` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `tenant_id`, `parent_id`) VALUES
	(1, '2019-12-28 12:25:34', '', '1', '2019-12-28 12:25:34', 1, 1, '根节点', 12, 0, NULL, NULL),
	(2, '2019-12-28 12:25:49', '001', '1,2', '2019-12-28 12:25:49', 2, 2, '快消品', 3, NULL, 1, 1),
	(3, '2019-12-28 12:25:59', '002', '1,3', '2019-12-28 12:25:59', 2, 4, '食用油', 9, NULL, 1, 1),
	(5, '2019-12-28 15:11:09', '001', '1,3,5', '2019-12-28 15:11:09', 3, 5, '金龙鱼', 8, NULL, 1, 3),
	(6, '2019-12-29 16:38:01', '001', '1,3,5,6', '2019-12-29 16:38:01', 4, 6, '金龙鱼1', 7, NULL, 1, 5),
	(7, '2020-04-07 22:39:32', '003', '1,7', '2020-04-07 22:39:32', 2, 10, '3c', 11, NULL, 1, 1);
/*!40000 ALTER TABLE `bs_tenant_mall_goods_catalog` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_mall_goods_catalog_bs_tenant_mall_goods_catalog 结构
DROP TABLE IF EXISTS `bs_tenant_mall_goods_catalog_bs_tenant_mall_goods_catalog`;
CREATE TABLE IF NOT EXISTS `bs_tenant_mall_goods_catalog_bs_tenant_mall_goods_catalog` (
  `GoodsCatalog_id` int(11) NOT NULL,
  `child_id` int(11) NOT NULL,
  UNIQUE KEY `UK_audrxo9e8wa2pxvwndliub7du` (`child_id`),
  KEY `FKrax4kbd5oj0eqff6dd3vc14pg` (`GoodsCatalog_id`),
  CONSTRAINT `FKrax4kbd5oj0eqff6dd3vc14pg` FOREIGN KEY (`GoodsCatalog_id`) REFERENCES `bs_tenant_mall_goods_catalog` (`id`),
  CONSTRAINT `FKsfm2y4f41jax7djwiv9oky93b` FOREIGN KEY (`child_id`) REFERENCES `bs_tenant_mall_goods_catalog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_mall_goods_catalog_bs_tenant_mall_goods_catalog 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_mall_goods_catalog_bs_tenant_mall_goods_catalog`;
/*!40000 ALTER TABLE `bs_tenant_mall_goods_catalog_bs_tenant_mall_goods_catalog` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_mall_goods_catalog_bs_tenant_mall_goods_catalog` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_mall_goods_sku 结构
DROP TABLE IF EXISTS `bs_tenant_mall_goods_sku`;
CREATE TABLE IF NOT EXISTS `bs_tenant_mall_goods_sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `skuName` varchar(255) DEFAULT NULL,
  `skuNo` varchar(255) DEFAULT NULL,
  `stock` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `goodsSpu_id` bigint(20) DEFAULT NULL,
  `spuId` varchar(255) DEFAULT NULL,
  `goodsId` varchar(255) DEFAULT NULL,
  `spuNameId` varchar(255) DEFAULT NULL,
  `spuValueId` varchar(255) DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK75ehr6dvm7gr45nt6mgh1co7b` (`tenant_id`),
  KEY `FKpytl6s90qqlhwk0ntkha6lbk7` (`goodsSpu_id`),
  KEY `FK9547yejrf7fna1mpo2rr3iio2` (`goods_id`),
  CONSTRAINT `FK75ehr6dvm7gr45nt6mgh1co7b` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FK9547yejrf7fna1mpo2rr3iio2` FOREIGN KEY (`goods_id`) REFERENCES `bs_tenant_mall_goods` (`id`),
  CONSTRAINT `FKpytl6s90qqlhwk0ntkha6lbk7` FOREIGN KEY (`goodsSpu_id`) REFERENCES `bs_tenant_mall_goods_spu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_mall_goods_sku 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_mall_goods_sku`;
/*!40000 ALTER TABLE `bs_tenant_mall_goods_sku` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_mall_goods_sku` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_mall_goods_sku_spu 结构
DROP TABLE IF EXISTS `bs_tenant_mall_goods_sku_spu`;
CREATE TABLE IF NOT EXISTS `bs_tenant_mall_goods_sku_spu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `goodsSku_id` bigint(20) DEFAULT NULL,
  `spuValue_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKehe89hk05eqvmtt266pvbhbua` (`tenant_id`),
  KEY `FK9pv7i0qxnsk909kbsm4jy2b6y` (`goodsSku_id`),
  KEY `FKcti5fanmyfds8xwjgssxiqxc1` (`spuValue_id`),
  CONSTRAINT `FK9pv7i0qxnsk909kbsm4jy2b6y` FOREIGN KEY (`goodsSku_id`) REFERENCES `bs_tenant_mall_goods_sku` (`id`),
  CONSTRAINT `FKcti5fanmyfds8xwjgssxiqxc1` FOREIGN KEY (`spuValue_id`) REFERENCES `bs_tenant_mall_goods_spu_value` (`id`),
  CONSTRAINT `FKehe89hk05eqvmtt266pvbhbua` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_mall_goods_sku_spu 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_mall_goods_sku_spu`;
/*!40000 ALTER TABLE `bs_tenant_mall_goods_sku_spu` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_mall_goods_sku_spu` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_mall_goods_spu 结构
DROP TABLE IF EXISTS `bs_tenant_mall_goods_spu`;
CREATE TABLE IF NOT EXISTS `bs_tenant_mall_goods_spu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `catalog` tinyblob,
  `spuName` tinyblob,
  `spuValue` tinyblob,
  `status` varchar(255) DEFAULT NULL,
  `catalog_id` int(11) DEFAULT NULL,
  `spuName_id` bigint(20) DEFAULT NULL,
  `spuValue_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK28xrqins2knp3mc4lusx67vdb` (`tenant_id`),
  KEY `FK3ot73dd1qj7u0381rmcug9cbr` (`catalog_id`),
  KEY `FKcnrafi154ighuwomk4q12cc2y` (`spuName_id`),
  KEY `FKe3vnrjop0awbit38hcjswm24x` (`spuValue_id`),
  CONSTRAINT `FK28xrqins2knp3mc4lusx67vdb` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FK3ot73dd1qj7u0381rmcug9cbr` FOREIGN KEY (`catalog_id`) REFERENCES `bs_tenant_mall_goods_catalog` (`id`),
  CONSTRAINT `FKcnrafi154ighuwomk4q12cc2y` FOREIGN KEY (`spuName_id`) REFERENCES `bs_tenant_mall_goods_spu_name` (`id`),
  CONSTRAINT `FKe3vnrjop0awbit38hcjswm24x` FOREIGN KEY (`spuValue_id`) REFERENCES `bs_tenant_mall_goods_spu_value` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_mall_goods_spu 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_mall_goods_spu`;
/*!40000 ALTER TABLE `bs_tenant_mall_goods_spu` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_mall_goods_spu` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_mall_goods_spu_name 结构
DROP TABLE IF EXISTS `bs_tenant_mall_goods_spu_name`;
CREATE TABLE IF NOT EXISTS `bs_tenant_mall_goods_spu_name` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `isColor` int(11) NOT NULL,
  `isCrux` int(11) NOT NULL,
  `isInput` int(11) NOT NULL,
  `spuName` varchar(64) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `catalog_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlhfhwe9bkppyy80kexaxs0q7i` (`tenant_id`),
  KEY `FKqpr81yj88gxvqxgpx61sga2rd` (`catalog_id`),
  CONSTRAINT `FKlhfhwe9bkppyy80kexaxs0q7i` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKqpr81yj88gxvqxgpx61sga2rd` FOREIGN KEY (`catalog_id`) REFERENCES `bs_tenant_mall_goods_catalog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_mall_goods_spu_name 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_mall_goods_spu_name`;
/*!40000 ALTER TABLE `bs_tenant_mall_goods_spu_name` DISABLE KEYS */;
INSERT INTO `bs_tenant_mall_goods_spu_name` (`id`, `addDate`, `lastDate`, `tenant_id`, `isColor`, `isCrux`, `isInput`, `spuName`, `status`, `catalog_id`) VALUES
	(1, '2020-01-15 21:08:16', '2020-01-15 21:08:16', 1, 0, 0, 0, '系统', '', NULL);
/*!40000 ALTER TABLE `bs_tenant_mall_goods_spu_name` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_mall_goods_spu_value 结构
DROP TABLE IF EXISTS `bs_tenant_mall_goods_spu_value`;
CREATE TABLE IF NOT EXISTS `bs_tenant_mall_goods_spu_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `spuValue` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `spuName_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqgxa482xnsfkj8bcnp1u2wqox` (`tenant_id`),
  KEY `FKnewj3jo70vpevq6anypdch1tx` (`spuName_id`),
  CONSTRAINT `FKnewj3jo70vpevq6anypdch1tx` FOREIGN KEY (`spuName_id`) REFERENCES `bs_tenant_mall_goods_spu_name` (`id`),
  CONSTRAINT `FKqgxa482xnsfkj8bcnp1u2wqox` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_mall_goods_spu_value 的数据：~3 rows (大约)
DELETE FROM `bs_tenant_mall_goods_spu_value`;
/*!40000 ALTER TABLE `bs_tenant_mall_goods_spu_value` DISABLE KEYS */;
INSERT INTO `bs_tenant_mall_goods_spu_value` (`id`, `addDate`, `lastDate`, `tenant_id`, `spuValue`, `status`, `spuName_id`) VALUES
	(1, '2020-01-15 21:08:16', '2020-01-15 21:08:16', 1, '13', NULL, 1),
	(2, '2020-01-15 21:08:16', '2020-01-15 21:08:16', 1, '12', NULL, 1),
	(3, '2020-01-15 21:08:16', '2020-01-15 21:08:16', 1, '1', NULL, 1);
/*!40000 ALTER TABLE `bs_tenant_mall_goods_spu_value` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_message 结构
DROP TABLE IF EXISTS `bs_tenant_message`;
CREATE TABLE IF NOT EXISTS `bs_tenant_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `messageType` int(11) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `nums` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `catalog_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdb5sqoc6ypmcqack24mfk14l0` (`tenant_id`),
  KEY `FKqru4qufeibktsmx657xk1f819` (`catalog_id`),
  CONSTRAINT `FKdb5sqoc6ypmcqack24mfk14l0` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKqru4qufeibktsmx657xk1f819` FOREIGN KEY (`catalog_id`) REFERENCES `bs_tenant_message_catalog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_message 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_message`;
/*!40000 ALTER TABLE `bs_tenant_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_message` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_message_catalog 结构
DROP TABLE IF EXISTS `bs_tenant_message_catalog`;
CREATE TABLE IF NOT EXISTS `bs_tenant_message_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `system` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqio3lvdpi3cn0h3o2eiw1mflh` (`tenant_id`),
  KEY `FKkdvj97h3ix9aceai5sxf6oe1m` (`parent_id`),
  CONSTRAINT `FKkdvj97h3ix9aceai5sxf6oe1m` FOREIGN KEY (`parent_id`) REFERENCES `bs_tenant_message_catalog` (`id`),
  CONSTRAINT `FKqio3lvdpi3cn0h3o2eiw1mflh` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_message_catalog 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_message_catalog`;
/*!40000 ALTER TABLE `bs_tenant_message_catalog` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_message_catalog` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_message_member 结构
DROP TABLE IF EXISTS `bs_tenant_message_member`;
CREATE TABLE IF NOT EXISTS `bs_tenant_message_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `message_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdmberinbl32col7b8iejog3rp` (`tenant_id`),
  KEY `FKcx0alav2mk9wk8mbmahp449b9` (`message_id`),
  KEY `FKktq9ib75ecs5kirhrnq9eluxj` (`user_id`),
  CONSTRAINT `FKcx0alav2mk9wk8mbmahp449b9` FOREIGN KEY (`message_id`) REFERENCES `bs_tenant_message` (`id`),
  CONSTRAINT `FKdmberinbl32col7b8iejog3rp` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKktq9ib75ecs5kirhrnq9eluxj` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_message_member 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_message_member`;
/*!40000 ALTER TABLE `bs_tenant_message_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_message_member` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_oauth_config 结构
DROP TABLE IF EXISTS `bs_tenant_oauth_config`;
CREATE TABLE IF NOT EXISTS `bs_tenant_oauth_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `appKey` varchar(255) DEFAULT NULL,
  `appSecret` varchar(255) DEFAULT NULL,
  `className` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKuvbkdfs7of0mk5vxky6ierlp` (`tenant_id`),
  CONSTRAINT `FKuvbkdfs7of0mk5vxky6ierlp` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_oauth_config 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_oauth_config`;
/*!40000 ALTER TABLE `bs_tenant_oauth_config` DISABLE KEYS */;
INSERT INTO `bs_tenant_oauth_config` (`id`, `addDate`, `lastDate`, `appKey`, `appSecret`, `className`, `model`, `name`, `state`, `tenant_id`) VALUES
	(1, '2020-05-19 17:38:26', '2020-05-19 17:38:26', 'wx49dab0ea2b3293a9', 'bd58a6142698f3b19b09acb254d61f70', 'com.haoxuer.discover.user.oauth.impl.WeiAppOauthHandler', 'wxapp', '微信小程序登录', 1, 2);
/*!40000 ALTER TABLE `bs_tenant_oauth_config` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_order_exchange 结构
DROP TABLE IF EXISTS `bs_tenant_order_exchange`;
CREATE TABLE IF NOT EXISTS `bs_tenant_order_exchange` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `no` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjdfge61nv5navwvs1v772k09p` (`tenant_id`),
  CONSTRAINT `FKjdfge61nv5navwvs1v772k09p` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_order_exchange 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_order_exchange`;
/*!40000 ALTER TABLE `bs_tenant_order_exchange` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_order_exchange` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_order_info 结构
DROP TABLE IF EXISTS `bs_tenant_order_info`;
CREATE TABLE IF NOT EXISTS `bs_tenant_order_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `commentState` int(11) DEFAULT NULL,
  `deliveryTime` datetime DEFAULT NULL,
  `discount` decimal(19,2) DEFAULT NULL,
  `editPriceTime` datetime DEFAULT NULL,
  `finishTime` datetime DEFAULT NULL,
  `freight` decimal(19,2) DEFAULT NULL,
  `hasExtendReceive` bit(1) NOT NULL,
  `integralDiscount` decimal(19,2) DEFAULT NULL,
  `mergeOrderCode` varchar(255) DEFAULT NULL,
  `newRefundId` bigint(20) DEFAULT NULL,
  `orderCode` varchar(255) DEFAULT NULL,
  `orderSource` int(11) DEFAULT NULL,
  `orderTime` datetime DEFAULT NULL,
  `orderType` int(11) DEFAULT NULL,
  `outTradeNum` varchar(255) DEFAULT NULL,
  `payAmount` decimal(19,2) DEFAULT NULL,
  `payMode` int(11) DEFAULT NULL,
  `paySource` int(11) DEFAULT NULL,
  `payTime` datetime DEFAULT NULL,
  `platformDiscount` decimal(19,2) DEFAULT NULL,
  `productAmount` decimal(19,2) DEFAULT NULL,
  `productCount` int(11) DEFAULT NULL,
  `receiveTime` datetime DEFAULT NULL,
  `redPacketDiscount` decimal(19,2) DEFAULT NULL,
  `remindTime` datetime DEFAULT NULL,
  `returnAmount` decimal(19,2) DEFAULT NULL,
  `returnCount` int(11) DEFAULT NULL,
  `sendIntegral` decimal(19,2) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `storeState` int(11) DEFAULT NULL,
  `sysReceiveTime` datetime DEFAULT NULL,
  `totalAmount` decimal(19,2) DEFAULT NULL,
  `useIntegral` decimal(19,2) DEFAULT NULL,
  `useRedPacket` decimal(19,2) DEFAULT NULL,
  `userState` int(11) DEFAULT NULL,
  `weight` decimal(19,2) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `consignee` varchar(20) DEFAULT NULL,
  `no` varchar(50) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `payState` int(11) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq74e53d20v1krlmse41t3p1eb` (`tenant_id`),
  KEY `FKeh24208iqf76srkw4jrq5uj0j` (`store_id`),
  KEY `FKnqe1tv4h56jql4g3lk90s1lpc` (`user_id`),
  CONSTRAINT `FKeh24208iqf76srkw4jrq5uj0j` FOREIGN KEY (`store_id`) REFERENCES `bs_tenant_store_info` (`id`),
  CONSTRAINT `FKnqe1tv4h56jql4g3lk90s1lpc` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`),
  CONSTRAINT `FKq74e53d20v1krlmse41t3p1eb` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_order_info 的数据：~23 rows (大约)
DELETE FROM `bs_tenant_order_info`;
/*!40000 ALTER TABLE `bs_tenant_order_info` DISABLE KEYS */;
INSERT INTO `bs_tenant_order_info` (`id`, `addDate`, `lastDate`, `amount`, `commentState`, `deliveryTime`, `discount`, `editPriceTime`, `finishTime`, `freight`, `hasExtendReceive`, `integralDiscount`, `mergeOrderCode`, `newRefundId`, `orderCode`, `orderSource`, `orderTime`, `orderType`, `outTradeNum`, `payAmount`, `payMode`, `paySource`, `payTime`, `platformDiscount`, `productAmount`, `productCount`, `receiveTime`, `redPacketDiscount`, `remindTime`, `returnAmount`, `returnCount`, `sendIntegral`, `state`, `storeState`, `sysReceiveTime`, `totalAmount`, `useIntegral`, `useRedPacket`, `userState`, `weight`, `tenant_id`, `store_id`, `user_id`, `address`, `consignee`, `no`, `note`, `payState`, `phone`) VALUES
	(12, '2020-05-27 14:53:16', '2020-05-27 14:53:28', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '行政中心', 'ada', '2020052714531582659617', NULL, 1, '17192512093'),
	(24, '2020-05-27 15:58:42', '2020-05-27 15:59:08', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '行政中心', 'ada', '2020052715584234157504', NULL, 1, '17192512093'),
	(32, '2020-05-27 17:17:17', '2020-05-27 17:17:37', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '行政中心', 'ada', '2020052717171604877751', NULL, 1, '17192512093'),
	(34, '2020-05-27 17:22:38', '2020-05-27 17:22:48', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '行政中心', 'ada', '2020052717223755581392', NULL, 1, '17192512093'),
	(35, '2020-05-27 17:27:26', '2020-05-27 17:27:51', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '行政中心', 'ada', '2020052717272635735399', NULL, 1, '17192512093'),
	(36, '2020-05-27 17:29:54', '2020-05-27 17:30:15', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '行政中心', 'ada', '2020052717295447844950', NULL, 1, '17192512093'),
	(38, '2020-05-27 19:38:52', '2020-05-27 19:38:52', 43.00, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 98, NULL, NULL, '2020052719385209097165', NULL, 0, NULL),
	(47, '2020-05-28 10:05:46', '2020-05-28 10:06:06', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '行政中心', 'ada', '2020052810054610293282', NULL, 1, '17192512093'),
	(48, '2020-05-28 10:07:37', '2020-05-28 10:07:48', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '行政中心', 'ada', '2020052810073627783083', NULL, 1, '17192512093'),
	(49, '2020-05-28 10:09:38', '2020-05-28 10:09:48', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '行政中心', 'ada', '2020052810093837413379', NULL, 1, '17192512093'),
	(52, '2020-05-28 10:13:01', '2020-05-28 10:13:06', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '行政中心', 'ada', '2020052810130054918948', NULL, 1, '17192512093'),
	(54, '2020-05-28 14:31:02', '2020-05-28 14:31:28', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '行政中心', 'ada', '2020052814310190478706', NULL, 1, '17192512093'),
	(55, '2020-05-28 14:32:15', '2020-05-28 14:32:30', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '行政中心', 'ada', '2020052814321460220274', NULL, 1, '17192512093'),
	(59, '2020-05-28 17:48:01', '2020-05-28 17:48:01', 15500.00, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 500, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '行政中心', 'ada', '2020052817480155118348', NULL, 0, '17192512093'),
	(60, '2020-05-28 17:48:36', '2020-05-28 17:48:44', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '行政中心', 'ada', '2020052817483591603424', NULL, 1, '17192512093'),
	(61, '2020-05-31 22:32:50', '2020-05-31 22:32:50', 4000.00, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '行政中心', 'ada', '2020053122324916927882', NULL, 0, '17192512093'),
	(62, '2020-06-02 21:38:28', '2020-06-02 21:38:28', 760.00, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '测试', '测试', '2020060221382778785043', NULL, 0, '13001192817'),
	(63, '2020-06-05 11:11:45', '2020-06-05 11:11:46', 262.80, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '陕西省西安市新城区西六路9号', 'ada', '2020060511114400939383', NULL, 0, '18229060103'),
	(65, '2020-06-05 13:04:44', '2020-06-05 13:05:08', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '陕西省西安市新城区西六路9号', 'ada', '2020060513044362393727', NULL, 1, '18229060103'),
	(66, '2020-06-05 13:05:27', '2020-06-05 13:05:46', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '陕西省西安市新城区西六路9号', 'ada', '2020060513052786527486', NULL, 1, '18229060103'),
	(67, '2020-06-05 13:06:01', '2020-06-05 13:06:22', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '陕西省西安市新城区西六路9号', 'ada', '2020060513060191896502', NULL, 1, '18229060103'),
	(68, '2020-06-11 15:37:31', '2020-06-11 15:37:32', 1.23, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '陕西省西安市新城区西六路9号', 'ada', '2020061115373157397317', NULL, 0, '18229060103'),
	(71, '2020-06-13 22:42:39', '2020-06-13 22:42:44', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '陕西省西安市新城区西六路9号', 'ada', '2020061322423978222813', NULL, 1, '18229060103'),
	(72, '2020-06-13 22:43:13', '2020-06-13 22:43:19', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 96, '陕西省西安市新城区西六路9号', 'ada', '2020061322431340410057', NULL, 1, '18229060103');
/*!40000 ALTER TABLE `bs_tenant_order_info` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_order_item 结构
DROP TABLE IF EXISTS `bs_tenant_order_item`;
CREATE TABLE IF NOT EXISTS `bs_tenant_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `discountAmount` decimal(19,2) DEFAULT NULL,
  `freight` decimal(19,2) DEFAULT NULL,
  `giveType` bit(1) DEFAULT NULL,
  `integralDiscount` decimal(19,2) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `payAmount` decimal(19,2) DEFAULT NULL,
  `platformDiscount` decimal(19,2) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `productCount` int(11) DEFAULT NULL,
  `realAmount` decimal(19,2) DEFAULT NULL,
  `realPrice` decimal(19,2) DEFAULT NULL,
  `redPacketDiscount` decimal(19,2) DEFAULT NULL,
  `refundState` int(11) DEFAULT NULL,
  `returnAmount` decimal(19,2) DEFAULT NULL,
  `returnCount` int(11) DEFAULT NULL,
  `skuAttr` varchar(255) DEFAULT NULL,
  `storageCount` int(11) DEFAULT NULL,
  `useIntegral` decimal(19,2) DEFAULT NULL,
  `useRedPacket` decimal(19,2) DEFAULT NULL,
  `weight` decimal(19,2) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `orderData_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `sku_id` bigint(20) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `returnNum` int(11) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `surplusNum` int(11) DEFAULT NULL,
  `useNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdk7hsf5a7a4rourknf2lovg2j` (`tenant_id`),
  KEY `FKk7nckrvpdd3rhnetx85cnhaw` (`orderData_id`),
  KEY `FKhaqlpvlcxwexiogys9avge0yl` (`product_id`),
  KEY `FKomla2ld9sdk6vrbo1otxh0ljp` (`sku_id`),
  CONSTRAINT `FKdk7hsf5a7a4rourknf2lovg2j` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKhaqlpvlcxwexiogys9avge0yl` FOREIGN KEY (`product_id`) REFERENCES `bs_tenant_product` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKk7nckrvpdd3rhnetx85cnhaw` FOREIGN KEY (`orderData_id`) REFERENCES `bs_tenant_order_info` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKomla2ld9sdk6vrbo1otxh0ljp` FOREIGN KEY (`sku_id`) REFERENCES `bs_tenant_product_sku` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_order_item 的数据：~27 rows (大约)
DELETE FROM `bs_tenant_order_item`;
/*!40000 ALTER TABLE `bs_tenant_order_item` DISABLE KEYS */;
INSERT INTO `bs_tenant_order_item` (`id`, `addDate`, `lastDate`, `discountAmount`, `freight`, `giveType`, `integralDiscount`, `logo`, `name`, `payAmount`, `platformDiscount`, `price`, `productCount`, `realAmount`, `realPrice`, `redPacketDiscount`, `refundState`, `returnAmount`, `returnCount`, `skuAttr`, `storageCount`, `useIntegral`, `useRedPacket`, `weight`, `tenant_id`, `orderData_id`, `product_id`, `sku_id`, `unit`, `returnNum`, `size`, `surplusNum`, `useNum`) VALUES
	(13, '2020-05-27 14:53:16', '2020-06-13 22:40:49', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/f011784a-01e1-4c02-bc45-5f0ce8ba9dd6.jpg', '测试1', NULL, NULL, 0.01, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, 7, NULL, 'kg', 0, 1, 0, 0),
	(35, '2020-05-27 15:58:42', '2020-06-13 22:40:49', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/f011784a-01e1-4c02-bc45-5f0ce8ba9dd6.jpg', '测试1', NULL, NULL, 0.01, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 24, 7, NULL, 'kg', 0, 1, 0, 0),
	(44, '2020-05-27 17:17:17', '2020-06-13 22:40:49', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/f011784a-01e1-4c02-bc45-5f0ce8ba9dd6.jpg', '测试1', NULL, NULL, 0.01, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 32, 7, NULL, 'kg', 0, 1, 0, 0),
	(46, '2020-05-27 17:22:38', '2020-06-13 22:40:49', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/f011784a-01e1-4c02-bc45-5f0ce8ba9dd6.jpg', '测试1', NULL, NULL, 0.01, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 34, 7, NULL, 'kg', 0, 1, 0, 0),
	(47, '2020-05-27 17:27:26', '2020-06-13 22:40:49', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/f011784a-01e1-4c02-bc45-5f0ce8ba9dd6.jpg', '测试1', NULL, NULL, 0.01, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 35, 7, NULL, 'kg', 0, 1, 0, 0),
	(48, '2020-05-27 17:29:54', '2020-06-13 22:40:49', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/f011784a-01e1-4c02-bc45-5f0ce8ba9dd6.jpg', '测试1', NULL, NULL, 0.01, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 36, 7, NULL, 'kg', 0, 1, 0, 0),
	(50, '2020-05-27 19:38:52', '2020-05-27 19:38:52', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/5ecfc424-0c55-4f1e-bb64-0a3e5651b103.jpg', '测试9', NULL, NULL, 43.00, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 38, 17, NULL, '', 0, 1, 7, 0),
	(59, '2020-05-28 10:05:46', '2020-06-13 22:40:49', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/f011784a-01e1-4c02-bc45-5f0ce8ba9dd6.jpg', '测试1', NULL, NULL, 0.01, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 47, 7, NULL, 'kg', 0, 1, 0, 0),
	(60, '2020-05-28 10:07:37', '2020-06-13 22:40:49', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/f011784a-01e1-4c02-bc45-5f0ce8ba9dd6.jpg', '测试1', NULL, NULL, 0.01, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 48, 7, NULL, 'kg', 0, 1, 0, 0),
	(61, '2020-05-28 10:09:38', '2020-06-13 22:40:49', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/f011784a-01e1-4c02-bc45-5f0ce8ba9dd6.jpg', '测试1', NULL, NULL, 0.01, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 49, 7, NULL, 'kg', 0, 1, 0, 0),
	(64, '2020-05-28 10:13:01', '2020-06-13 22:40:49', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/f011784a-01e1-4c02-bc45-5f0ce8ba9dd6.jpg', '测试1', NULL, NULL, 0.01, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 52, 7, NULL, 'kg', 0, 1, 0, 0),
	(66, '2020-05-28 14:31:02', '2020-06-13 22:40:49', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/f011784a-01e1-4c02-bc45-5f0ce8ba9dd6.jpg', '测试1', NULL, NULL, 0.01, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 54, 7, NULL, 'kg', 0, 1, 0, 0),
	(67, '2020-05-28 14:32:15', '2020-06-13 22:40:49', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/f011784a-01e1-4c02-bc45-5f0ce8ba9dd6.jpg', '测试1', NULL, NULL, 0.01, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 55, 7, NULL, 'kg', 0, 1, 0, 0),
	(71, '2020-05-28 17:48:01', '2020-06-05 11:16:46', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/2b63a8a3-c370-4269-aae4-7bc74d934624.jpg', '5L食用油', NULL, NULL, 3.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 59, 9, NULL, '斤', 0, 100, 99, 0),
	(72, '2020-05-28 17:48:01', '2020-06-08 09:59:44', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/5ecfc424-0c55-4f1e-bb64-0a3e5651b103.jpg', '测试9', NULL, NULL, 43.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 59, 17, NULL, '', 0, 200, 0, 0),
	(73, '2020-05-28 17:48:01', '2020-06-05 11:19:09', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/712b1219-40aa-4caf-9e3e-e5d6e9ac1552.jpg', 'rtret', NULL, NULL, 33.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 59, 6, NULL, '斤', 0, 200, 0, 0),
	(74, '2020-05-28 17:48:36', '2020-06-13 22:40:49', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/f011784a-01e1-4c02-bc45-5f0ce8ba9dd6.jpg', '测试1', NULL, NULL, 0.01, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 60, 7, NULL, 'kg', 0, 1, 0, 0),
	(75, '2020-05-31 22:32:50', '2020-06-05 14:28:36', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/14b34f9e-eb2c-4af2-a9e6-2a53a1ba8cbd.jpg', '2L玉米油', NULL, NULL, 4.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 61, 10, NULL, '', 0, 1000, 0, 0),
	(76, '2020-06-02 21:38:28', '2020-06-05 11:17:19', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/47b19b3c-f706-4910-ac34-dca414d51811.jpg', '八鱼食用油非转基因压榨一级菜籽油5L', NULL, NULL, 76.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 62, 14, NULL, 'kg', 0, 10, 0, 0),
	(77, '2020-06-05 11:11:45', '2020-06-08 10:31:56', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/a8ba37c0-ceb4-41ed-9f02-6e00fbfad815.jpg', '八鱼食用油非转基因三级特香压榨菜籽油1L', NULL, NULL, 21.90, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 63, 23, NULL, '', 0, 12, 0, 0),
	(79, '2020-06-05 13:04:44', '2020-06-05 13:10:28', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/c8dc206e-94fd-4b35-a4d9-7a94e4a0c5f5.jpg', '八鱼139度压榨菜籽油1L', NULL, NULL, 0.01, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 65, 22, NULL, 'kg', 0, 1, 0, 0),
	(80, '2020-06-05 13:05:27', '2020-06-05 13:10:28', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/c8dc206e-94fd-4b35-a4d9-7a94e4a0c5f5.jpg', '八鱼139度压榨菜籽油1L', NULL, NULL, 0.01, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 66, 22, NULL, 'kg', 0, 1, 0, 0),
	(81, '2020-06-05 13:06:01', '2020-06-05 13:06:01', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/c8dc206e-94fd-4b35-a4d9-7a94e4a0c5f5.jpg', '八鱼139度压榨菜籽油1L', NULL, NULL, 0.01, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 67, 22, NULL, 'kg', 0, 1, 1, 0),
	(82, '2020-06-11 15:37:31', '2020-06-11 15:37:31', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/c8dc206e-94fd-4b35-a4d9-7a94e4a0c5f5.jpg', '八鱼139度压榨菜籽油1L', NULL, NULL, 0.01, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 68, 22, NULL, 'kg', 0, 123, 123, 0),
	(86, '2020-06-13 22:42:39', '2020-06-13 22:42:39', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/2b9623fb-7f3f-4a4a-9b0b-a1d6c4f6adfd.jpg', '八鱼陕派风味非转基因压榨菜籽油5L+500ML', NULL, NULL, 0.01, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 71, 17, NULL, 'kg', 0, 1, 1, 0),
	(87, '2020-06-13 22:43:13', '2020-06-13 22:43:13', NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/2b9623fb-7f3f-4a4a-9b0b-a1d6c4f6adfd.jpg', '八鱼陕派风味非转基因压榨菜籽油5L+500ML', NULL, NULL, 0.01, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 72, 17, NULL, 'kg', 0, 1, 1, 0);
/*!40000 ALTER TABLE `bs_tenant_order_item` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_order_refund 结构
DROP TABLE IF EXISTS `bs_tenant_order_refund`;
CREATE TABLE IF NOT EXISTS `bs_tenant_order_refund` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `no` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `money` decimal(19,2) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `refundDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK921qdnfhwhd74qrkwvo4vbeiu` (`tenant_id`),
  CONSTRAINT `FK921qdnfhwhd74qrkwvo4vbeiu` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_order_refund 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_order_refund`;
/*!40000 ALTER TABLE `bs_tenant_order_refund` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_order_refund` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_order_tally 结构
DROP TABLE IF EXISTS `bs_tenant_order_tally`;
CREATE TABLE IF NOT EXISTS `bs_tenant_order_tally` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `no` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `consignee` varchar(20) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `customerAddress_id` bigint(20) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg6o5b36k227seplvknrru61jw` (`tenant_id`),
  KEY `FKt6omxngqio7v0lncusu8qlqb9` (`customer_id`),
  KEY `FKcgh2tnl8m9u32v8pl44s2bkhl` (`customerAddress_id`),
  CONSTRAINT `FKcgh2tnl8m9u32v8pl44s2bkhl` FOREIGN KEY (`customerAddress_id`) REFERENCES `bs_tenant_mall_customer_address` (`id`),
  CONSTRAINT `FKg6o5b36k227seplvknrru61jw` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKt6omxngqio7v0lncusu8qlqb9` FOREIGN KEY (`customer_id`) REFERENCES `bs_tenant_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_order_tally 的数据：~15 rows (大约)
DELETE FROM `bs_tenant_order_tally`;
/*!40000 ALTER TABLE `bs_tenant_order_tally` DISABLE KEYS */;
INSERT INTO `bs_tenant_order_tally` (`id`, `addDate`, `lastDate`, `no`, `tenant_id`, `name`, `state`, `address`, `consignee`, `note`, `phone`, `customer_id`, `customerAddress_id`, `size`) VALUES
	(1, '2020-06-05 10:55:25', '2020-06-05 10:55:25', NULL, 2, NULL, NULL, '39', NULL, NULL, NULL, 96, NULL, NULL),
	(2, '2020-06-05 10:56:36', '2020-06-05 10:56:36', NULL, 2, NULL, NULL, '39', NULL, NULL, NULL, 96, NULL, NULL),
	(3, '2020-06-05 11:01:58', '2020-06-05 11:01:58', NULL, 2, NULL, NULL, '39', NULL, NULL, NULL, 96, NULL, NULL),
	(4, '2020-06-05 11:06:05', '2020-06-05 11:06:05', NULL, 2, NULL, NULL, '39', NULL, NULL, NULL, 96, NULL, NULL),
	(5, '2020-06-05 11:07:05', '2020-06-05 11:07:05', NULL, 2, NULL, NULL, '39', NULL, NULL, NULL, 96, NULL, NULL),
	(14, '2020-06-05 11:16:46', '2020-06-05 11:16:46', NULL, 2, NULL, NULL, '39', NULL, NULL, NULL, 96, NULL, NULL),
	(15, '2020-06-05 11:17:19', '2020-06-05 11:17:19', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, 96, NULL, NULL),
	(16, '2020-06-05 11:17:51', '2020-06-05 11:17:51', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, 96, NULL, NULL),
	(17, '2020-06-05 11:18:29', '2020-06-05 11:18:29', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, 96, NULL, NULL),
	(18, '2020-06-05 11:18:54', '2020-06-05 11:18:54', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, 96, NULL, NULL),
	(19, '2020-06-05 11:19:09', '2020-06-05 11:19:09', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, 96, NULL, NULL),
	(20, '2020-06-05 11:19:22', '2020-06-05 11:19:22', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, 96, NULL, NULL),
	(21, '2020-06-05 11:19:58', '2020-06-05 11:19:58', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, 96, NULL, NULL),
	(22, '2020-06-05 11:45:40', '2020-06-05 11:45:40', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, 96, NULL, NULL),
	(25, '2020-06-05 13:10:28', '2020-06-05 13:10:28', NULL, 2, NULL, NULL, '陕西省西安市未央区龙首北路西段1号', 'wiuq', NULL, NULL, 96, NULL, NULL),
	(26, '2020-06-05 14:28:36', '2020-06-05 14:28:36', NULL, 2, NULL, NULL, '陕西省西安市未央区龙首北路西段1号', 'wiuq', NULL, '123', 96, 39, 1000),
	(27, '2020-06-08 09:59:44', '2020-06-08 09:59:44', NULL, 2, NULL, NULL, '陕西省西安市未央区龙首北路西段1号', 'wiuq', NULL, '123', 96, 39, 200),
	(28, '2020-06-08 10:31:56', '2020-06-08 10:31:56', NULL, 2, NULL, NULL, '陕西省西安市新城区西六路9号', 'ada', NULL, '18229060103', 96, 38, 1),
	(29, '2020-06-13 22:40:49', '2020-06-13 22:40:49', NULL, 2, NULL, NULL, '陕西省西安市未央区龙首北路西段1号', 'wiuq', NULL, '123', 96, 39, 69),
	(30, '2020-06-13 22:40:52', '2020-06-13 22:40:52', NULL, 2, NULL, NULL, '陕西省西安市未央区龙首北路西段1号', 'wiuq', NULL, '123', 96, 39, NULL);
/*!40000 ALTER TABLE `bs_tenant_order_tally` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_order_tally_item 结构
DROP TABLE IF EXISTS `bs_tenant_order_tally_item`;
CREATE TABLE IF NOT EXISTS `bs_tenant_order_tally_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `tally_id` bigint(20) DEFAULT NULL,
  `orderItem_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoht94qv7h9kov7cnst8q7r0qt` (`tenant_id`),
  KEY `FKqcahu4nakyx9vdmmpv7p0k1l` (`tally_id`),
  KEY `FKapx6nna9k6ffa0qjuj13hdaxl` (`orderItem_id`),
  CONSTRAINT `FKapx6nna9k6ffa0qjuj13hdaxl` FOREIGN KEY (`orderItem_id`) REFERENCES `bs_tenant_order_item` (`id`),
  CONSTRAINT `FKoht94qv7h9kov7cnst8q7r0qt` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKqcahu4nakyx9vdmmpv7p0k1l` FOREIGN KEY (`tally_id`) REFERENCES `bs_tenant_order_tally` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_order_tally_item 的数据：~23 rows (大约)
DELETE FROM `bs_tenant_order_tally_item`;
/*!40000 ALTER TABLE `bs_tenant_order_tally_item` DISABLE KEYS */;
INSERT INTO `bs_tenant_order_tally_item` (`id`, `addDate`, `lastDate`, `size`, `tenant_id`, `tally_id`, `orderItem_id`) VALUES
	(1, '2020-06-05 11:16:46', '2020-06-05 11:16:46', 1, NULL, 14, 71),
	(2, '2020-06-05 11:17:19', '2020-06-05 11:17:19', 10, NULL, 15, 76),
	(3, '2020-06-05 11:18:54', '2020-06-05 11:18:54', 1, NULL, 18, 73),
	(4, '2020-06-05 11:19:09', '2020-06-05 11:19:09', 199, NULL, 19, 73),
	(5, '2020-06-05 11:19:58', '2020-06-05 11:19:58', 11, NULL, 21, 77),
	(6, '2020-06-05 13:10:28', '2020-06-05 13:10:28', 1, NULL, 25, 79),
	(7, '2020-06-05 13:10:28', '2020-06-05 13:10:28', 1, NULL, 25, 80),
	(8, '2020-06-05 14:28:36', '2020-06-05 14:28:36', 1000, 2, 26, 75),
	(9, '2020-06-08 09:59:44', '2020-06-08 09:59:44', 200, 2, 27, 72),
	(10, '2020-06-08 10:31:56', '2020-06-08 10:31:56', 1, 2, 28, 77),
	(11, '2020-06-13 22:40:49', '2020-06-13 22:40:49', 2, 2, 29, 13),
	(12, '2020-06-13 22:40:49', '2020-06-13 22:40:49', 4, 2, 29, 35),
	(13, '2020-06-13 22:40:49', '2020-06-13 22:40:49', 7, 2, 29, 44),
	(14, '2020-06-13 22:40:49', '2020-06-13 22:40:49', 7, 2, 29, 46),
	(15, '2020-06-13 22:40:49', '2020-06-13 22:40:49', 7, 2, 29, 47),
	(16, '2020-06-13 22:40:49', '2020-06-13 22:40:49', 7, 2, 29, 48),
	(17, '2020-06-13 22:40:49', '2020-06-13 22:40:49', 8, 2, 29, 59),
	(18, '2020-06-13 22:40:49', '2020-06-13 22:40:49', 8, 2, 29, 60),
	(19, '2020-06-13 22:40:49', '2020-06-13 22:40:49', 8, 2, 29, 61),
	(20, '2020-06-13 22:40:49', '2020-06-13 22:40:49', 8, 2, 29, 64),
	(21, '2020-06-13 22:40:49', '2020-06-13 22:40:49', 1, 2, 29, 66),
	(22, '2020-06-13 22:40:49', '2020-06-13 22:40:49', 1, 2, 29, 67),
	(23, '2020-06-13 22:40:49', '2020-06-13 22:40:49', 1, 2, 29, 74);
/*!40000 ALTER TABLE `bs_tenant_order_tally_item` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_order_trade 结构
DROP TABLE IF EXISTS `bs_tenant_order_trade`;
CREATE TABLE IF NOT EXISTS `bs_tenant_order_trade` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `no` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `money` decimal(19,2) DEFAULT NULL,
  `payState` int(11) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `promote_id` bigint(20) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `productCount` int(11) DEFAULT NULL,
  `payMoney` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3wae3yj4uykpbl1hi3sp7xicd` (`tenant_id`),
  KEY `FKesk0ufh7apesllil60b6oisfd` (`customer_id`),
  KEY `FK9i348lqrvb8lbfbwmcgkmjti7` (`promote_id`),
  CONSTRAINT `FK3wae3yj4uykpbl1hi3sp7xicd` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FK9i348lqrvb8lbfbwmcgkmjti7` FOREIGN KEY (`promote_id`) REFERENCES `bs_tenant_promote_info` (`id`),
  CONSTRAINT `FKesk0ufh7apesllil60b6oisfd` FOREIGN KEY (`customer_id`) REFERENCES `bs_tenant_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_order_trade 的数据：~16 rows (大约)
DELETE FROM `bs_tenant_order_trade`;
/*!40000 ALTER TABLE `bs_tenant_order_trade` DISABLE KEYS */;
INSERT INTO `bs_tenant_order_trade` (`id`, `addDate`, `lastDate`, `no`, `tenant_id`, `money`, `payState`, `customer_id`, `promote_id`, `note`, `productCount`, `payMoney`) VALUES
	(1, '2020-04-05 20:53:40', '2020-04-05 20:53:40', '0001', 1, NULL, NULL, NULL, NULL, NULL, 30, 0.01),
	(15, '2020-05-19 18:40:20', '2020-05-19 18:40:30', '2020051918401934493865', 2, 0.01, 1, 96, 1, NULL, 1, 0.01),
	(90, '2020-05-21 16:37:22', '2020-05-21 16:37:26', '2020052116372207748052', 2, 0.10, 1, 96, 1, NULL, 10, 0.01),
	(93, '2020-05-21 17:25:52', '2020-05-21 17:38:09', '2020052117255189262456', 2, 0.11, 1, 96, 1, NULL, 11, 0.01),
	(96, '2020-05-22 14:24:17', '2020-05-22 14:26:54', '2020052214241644738440', 2, 0.10, 1, 96, 1, NULL, 10, 0.01),
	(97, '2020-05-22 14:44:34', '2020-05-22 14:57:24', '2020052214443468498427', 2, 0.10, 1, 96, 1, NULL, 10, 0.01),
	(104, '2020-05-22 14:59:41', '2020-05-22 15:00:03', '2020052214594078348685', 2, 0.10, 1, 96, 1, NULL, 10, 0.01),
	(105, '2020-05-22 15:03:21', '2020-05-22 15:11:38', '2020052215032076662775', 2, 0.10, 1, 96, 1, NULL, 10, 0.01),
	(116, '2020-05-27 17:13:34', '2020-05-27 17:14:34', '2020052717133482502292', 2, 0.10, 1, 96, 1, NULL, 10, 0.01),
	(119, '2020-05-27 19:39:32', '2020-05-27 19:39:43', '2020052719393133054124', 2, 0.10, 1, 98, 1, NULL, 10, 0.01),
	(120, '2020-05-27 19:40:28', '2020-05-27 19:40:28', '2020052719402770331006', 2, 0.10, 0, 98, 1, NULL, 10, 0.01),
	(121, '2020-05-27 19:40:31', '2020-05-27 19:40:31', '2020052719403041351128', 2, 0.10, 0, 98, 1, NULL, 10, 0.01),
	(122, '2020-05-27 19:40:33', '2020-05-27 19:40:33', '2020052719403259030561', 2, 0.10, 0, 98, 1, NULL, 10, 0.01),
	(123, '2020-05-27 19:40:35', '2020-05-27 19:40:35', '2020052719403516825676', 2, 0.10, 0, 98, 1, NULL, 10, 0.01),
	(125, '2020-05-28 17:56:10', '2020-05-28 17:56:16', '2020052817561079521494', 2, 0.20, 1, 96, 1, NULL, 20, 0.02),
	(127, '2020-06-13 22:46:04', '2020-06-13 22:46:09', '2020061322460359724770', 2, 0.11, 1, 96, 1, NULL, 11, 0.01);
/*!40000 ALTER TABLE `bs_tenant_order_trade` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_order_trade_item 结构
DROP TABLE IF EXISTS `bs_tenant_order_trade_item`;
CREATE TABLE IF NOT EXISTS `bs_tenant_order_trade_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `useNum` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `trade_id` bigint(20) DEFAULT NULL,
  `surplusNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgfqbe2tkxjw29a45ato1rfo6i` (`tenant_id`),
  KEY `FKt5w344ibgmg75y8p6fm7m3oi4` (`product_id`),
  KEY `FK7e8f3t3oysm71td8vwg1j0kim` (`trade_id`),
  CONSTRAINT `FK7e8f3t3oysm71td8vwg1j0kim` FOREIGN KEY (`trade_id`) REFERENCES `bs_tenant_order_trade` (`id`),
  CONSTRAINT `FKgfqbe2tkxjw29a45ato1rfo6i` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKt5w344ibgmg75y8p6fm7m3oi4` FOREIGN KEY (`product_id`) REFERENCES `bs_tenant_product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_order_trade_item 的数据：~16 rows (大约)
DELETE FROM `bs_tenant_order_trade_item`;
/*!40000 ALTER TABLE `bs_tenant_order_trade_item` DISABLE KEYS */;
INSERT INTO `bs_tenant_order_trade_item` (`id`, `addDate`, `lastDate`, `logo`, `name`, `price`, `size`, `useNum`, `tenant_id`, `product_id`, `trade_id`, `surplusNum`) VALUES
	(1, '2020-05-19 18:40:20', '2020-05-19 18:40:20', 'http://file.metamall.cn/metamall/upload/image/202005/712b1219-40aa-4caf-9e3e-e5d6e9ac1552.jpg', 'rtret', 0.01, 1, 0, 2, 6, 15, 10),
	(83, '2020-05-21 16:37:22', '2020-05-21 16:37:22', 'http://file.metamall.cn/metamall/upload/image/202005/f011784a-01e1-4c02-bc45-5f0ce8ba9dd6.jpg', '测试1', 0.01, 10, 0, 2, 7, 90, 10),
	(86, '2020-05-21 17:25:52', '2020-05-21 17:25:52', 'http://file.metamall.cn/metamall/upload/image/202005/0b8e3345-99eb-48c2-bd57-9c10014cf8e7.jpg', '测试2', 0.01, 11, 0, 2, 8, 93, 10),
	(92, '2020-05-22 14:24:17', '2020-05-22 14:24:17', 'http://file.metamall.cn/metamall/upload/image/202005/712b1219-40aa-4caf-9e3e-e5d6e9ac1552.jpg', 'rtret', 0.01, 10, 0, 2, 6, 96, 10),
	(93, '2020-05-22 14:44:34', '2020-05-22 14:44:34', 'http://file.metamall.cn/metamall/upload/image/202005/80adf3c1-f8ba-4d8f-af04-cc223316f001.jpg', '23232', 0.01, 10, 0, 2, 5, 97, 10),
	(100, '2020-05-22 14:59:41', '2020-05-22 14:59:41', 'http://file.metamall.cn/metamall/upload/image/202005/712b1219-40aa-4caf-9e3e-e5d6e9ac1552.jpg', 'rtret', 0.01, 10, 0, 2, 6, 104, 10),
	(101, '2020-05-22 15:03:21', '2020-05-22 15:03:21', 'http://file.metamall.cn/metamall/upload/image/202005/80adf3c1-f8ba-4d8f-af04-cc223316f001.jpg', '23232', 0.01, 10, 0, 2, 5, 105, 10),
	(122, '2020-05-27 17:13:34', '2020-05-27 17:13:34', 'http://file.metamall.cn/metamall/upload/image/202005/f011784a-01e1-4c02-bc45-5f0ce8ba9dd6.jpg', '测试1', 0.01, 10, 0, 2, 7, 116, 10),
	(125, '2020-05-27 19:39:32', '2020-05-27 19:39:32', 'http://file.metamall.cn/metamall/upload/image/202005/712b1219-40aa-4caf-9e3e-e5d6e9ac1552.jpg', 'rtret', 0.01, 10, 0, 2, 6, 119, 10),
	(126, '2020-05-27 19:40:28', '2020-05-27 19:40:28', 'http://file.metamall.cn/metamall/upload/image/202005/712b1219-40aa-4caf-9e3e-e5d6e9ac1552.jpg', 'rtret', 0.01, 10, 0, 2, 6, 120, 10),
	(127, '2020-05-27 19:40:31', '2020-05-27 19:40:31', 'http://file.metamall.cn/metamall/upload/image/202005/712b1219-40aa-4caf-9e3e-e5d6e9ac1552.jpg', 'rtret', 0.01, 10, 0, 2, 6, 121, 10),
	(128, '2020-05-27 19:40:33', '2020-05-27 19:40:33', 'http://file.metamall.cn/metamall/upload/image/202005/712b1219-40aa-4caf-9e3e-e5d6e9ac1552.jpg', 'rtret', 0.01, 10, 0, 2, 6, 122, 10),
	(129, '2020-05-27 19:40:35', '2020-05-27 19:40:35', 'http://file.metamall.cn/metamall/upload/image/202005/712b1219-40aa-4caf-9e3e-e5d6e9ac1552.jpg', 'rtret', 0.01, 10, 0, 2, 6, 123, 10),
	(132, '2020-05-28 17:56:10', '2020-05-28 17:56:10', 'http://file.metamall.cn/metamall/upload/image/202005/f011784a-01e1-4c02-bc45-5f0ce8ba9dd6.jpg', '测试1', 0.01, 20, 0, 2, 7, 125, 20),
	(134, '2020-06-13 22:46:04', '2020-06-13 22:46:04', 'http://file.metamall.cn/metamall/upload/image/202006/7f874f27-aac2-4a0f-b0e8-580ac011cf74.png', '八鱼小榨浓香非转基因压榨菜籽油5L', 0.01, 1, 0, 2, 6, 127, 1),
	(135, '2020-06-13 22:46:04', '2020-06-13 22:46:04', 'http://file.metamall.cn/metamall/upload/image/202006/617fc65a-d112-4580-8d7c-c66fa2b0f20b.jpg', '八鱼食用油皇家小榨非转基因菜籽油 5L', 0.01, 10, 0, 2, 5, 127, 10);
/*!40000 ALTER TABLE `bs_tenant_order_trade_item` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_order_trade_use_item 结构
DROP TABLE IF EXISTS `bs_tenant_order_trade_use_item`;
CREATE TABLE IF NOT EXISTS `bs_tenant_order_trade_use_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `record_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6pwly9opkyrnmag293tot2jr2` (`tenant_id`),
  KEY `FKokjo23pq4jj1rixe7cl1y51cv` (`item_id`),
  KEY `FKnbk0nb7vbu0yk986prnoqvoyj` (`record_id`),
  CONSTRAINT `FK6pwly9opkyrnmag293tot2jr2` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKnbk0nb7vbu0yk986prnoqvoyj` FOREIGN KEY (`record_id`) REFERENCES `bs_tenant_order_trade_use_record` (`id`),
  CONSTRAINT `FKokjo23pq4jj1rixe7cl1y51cv` FOREIGN KEY (`item_id`) REFERENCES `bs_tenant_order_trade_item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_order_trade_use_item 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_order_trade_use_item`;
/*!40000 ALTER TABLE `bs_tenant_order_trade_use_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_order_trade_use_item` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_order_trade_use_record 结构
DROP TABLE IF EXISTS `bs_tenant_order_trade_use_record`;
CREATE TABLE IF NOT EXISTS `bs_tenant_order_trade_use_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `orderData_id` bigint(20) DEFAULT NULL,
  `trade_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjp00ga499lfhj354p42s37920` (`tenant_id`),
  KEY `FKiri1fk5rwmnb53dp79cmiiggd` (`customer_id`),
  KEY `FKchylgb0exc9x261scaqi3fhal` (`orderData_id`),
  KEY `FKmvgobrxxxatewq3kufdkdfdfg` (`trade_id`),
  CONSTRAINT `FKchylgb0exc9x261scaqi3fhal` FOREIGN KEY (`orderData_id`) REFERENCES `bs_tenant_order_info` (`id`),
  CONSTRAINT `FKiri1fk5rwmnb53dp79cmiiggd` FOREIGN KEY (`customer_id`) REFERENCES `bs_tenant_user` (`id`),
  CONSTRAINT `FKjp00ga499lfhj354p42s37920` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKmvgobrxxxatewq3kufdkdfdfg` FOREIGN KEY (`trade_id`) REFERENCES `bs_tenant_order_trade` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_order_trade_use_record 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_order_trade_use_record`;
/*!40000 ALTER TABLE `bs_tenant_order_trade_use_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_order_trade_use_record` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_org_info 结构
DROP TABLE IF EXISTS `bs_tenant_org_info`;
CREATE TABLE IF NOT EXISTS `bs_tenant_org_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `num` bigint(20) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8pih1d8nkouif42ydl2dhk4mf` (`tenant_id`),
  KEY `FK3cemgu4vamik1yb3i4u9icme8` (`parent_id`),
  CONSTRAINT `FK3cemgu4vamik1yb3i4u9icme8` FOREIGN KEY (`parent_id`) REFERENCES `bs_tenant_org_info` (`id`),
  CONSTRAINT `FK8pih1d8nkouif42ydl2dhk4mf` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_org_info 的数据：~4 rows (大约)
DELETE FROM `bs_tenant_org_info`;
/*!40000 ALTER TABLE `bs_tenant_org_info` DISABLE KEYS */;
INSERT INTO `bs_tenant_org_info` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `catalog`, `num`, `tenant_id`, `parent_id`) VALUES
	(1, '2020-04-27 17:29:52', '', '1', '2020-04-27 17:29:52', 1, 1, '根节点', 2, 0, NULL, NULL, NULL, NULL),
	(2, '2020-04-27 18:23:35', NULL, '2', '2020-04-27 18:23:35', 1, 3, '市场部门', 6, NULL, NULL, NULL, 2, NULL),
	(3, '2020-04-27 18:23:48', NULL, '3', '2020-04-27 18:23:48', 1, 7, '营销部门', 8, NULL, NULL, NULL, 2, NULL),
	(4, '2020-04-27 18:23:55', NULL, '4', '2020-04-27 18:23:55', 1, 9, '推广部门', 10, NULL, NULL, NULL, 2, NULL),
	(5, '2020-04-27 18:24:03', NULL, '2,5', '2020-04-27 18:24:03', 2, 4, '市场一部', 5, NULL, NULL, NULL, 2, 2);
/*!40000 ALTER TABLE `bs_tenant_org_info` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_pay_cash_payment 结构
DROP TABLE IF EXISTS `bs_tenant_pay_cash_payment`;
CREATE TABLE IF NOT EXISTS `bs_tenant_pay_cash_payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `bussNo` varchar(255) DEFAULT NULL,
  `cash` decimal(19,2) DEFAULT NULL,
  `demo` varchar(255) DEFAULT NULL,
  `fee` decimal(19,2) DEFAULT NULL,
  `money` decimal(19,2) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `no` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `openId` varchar(255) DEFAULT NULL,
  `sendState` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `idNo` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqagtqmggrs2yx9x2pyflxc9p` (`tenant_id`),
  KEY `FKr3qejk7cmiv2up2gojoyesi1b` (`user_id`),
  CONSTRAINT `FKqagtqmggrs2yx9x2pyflxc9p` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKr3qejk7cmiv2up2gojoyesi1b` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_pay_cash_payment 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_pay_cash_payment`;
/*!40000 ALTER TABLE `bs_tenant_pay_cash_payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_pay_cash_payment` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_pay_order 结构
DROP TABLE IF EXISTS `bs_tenant_pay_order`;
CREATE TABLE IF NOT EXISTS `bs_tenant_pay_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `amountPaid` decimal(19,2) DEFAULT NULL,
  `couponDiscount` decimal(19,2) DEFAULT NULL,
  `fee` decimal(19,2) DEFAULT NULL,
  `freight` decimal(19,2) DEFAULT NULL,
  `money` decimal(19,2) DEFAULT NULL,
  `offsetAmount` decimal(19,2) DEFAULT NULL,
  `orderStatus` int(11) DEFAULT NULL,
  `paymentStatus` int(11) DEFAULT NULL,
  `point` bigint(20) DEFAULT NULL,
  `promotionDiscount` decimal(19,2) DEFAULT NULL,
  `shippingStatus` int(11) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `tax` decimal(19,2) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6m8os1bmxk036bom9x6354dly` (`tenant_id`),
  KEY `FKg5cdj9xcq3nodabotmtx74c48` (`user_id`),
  CONSTRAINT `FK6m8os1bmxk036bom9x6354dly` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKg5cdj9xcq3nodabotmtx74c48` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_pay_order 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_pay_order`;
/*!40000 ALTER TABLE `bs_tenant_pay_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_pay_order` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_pay_payment 结构
DROP TABLE IF EXISTS `bs_tenant_pay_payment`;
CREATE TABLE IF NOT EXISTS `bs_tenant_pay_payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `bank` varchar(255) DEFAULT NULL,
  `bussId` bigint(20) DEFAULT NULL,
  `bussNo` varchar(50) DEFAULT NULL,
  `expire` datetime DEFAULT NULL,
  `fee` decimal(19,2) DEFAULT NULL,
  `handle` varchar(255) DEFAULT NULL,
  `method` int(11) DEFAULT NULL,
  `no` varchar(255) DEFAULT NULL,
  `payState` int(11) DEFAULT NULL,
  `paymentDate` datetime DEFAULT NULL,
  `paymentMethod` varchar(255) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdktw77m74amttfel8402ilf3i` (`tenant_id`),
  KEY `FKo7tmethqdbabp15ot2ei9avts` (`user_id`),
  CONSTRAINT `FKdktw77m74amttfel8402ilf3i` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKo7tmethqdbabp15ot2ei9avts` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=240 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_pay_payment 的数据：~204 rows (大约)
DELETE FROM `bs_tenant_pay_payment`;
/*!40000 ALTER TABLE `bs_tenant_pay_payment` DISABLE KEYS */;
INSERT INTO `bs_tenant_pay_payment` (`id`, `addDate`, `lastDate`, `account`, `amount`, `bank`, `bussId`, `bussNo`, `expire`, `fee`, `handle`, `method`, `no`, `payState`, `paymentDate`, `paymentMethod`, `sn`, `status`, `type`, `tenant_id`, `user_id`) VALUES
	(1, '2020-05-19 17:58:19', '2020-05-19 17:58:19', NULL, 300.00, NULL, 4, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(2, '2020-05-19 17:58:59', '2020-05-19 17:58:59', NULL, 300.00, NULL, 5, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(3, '2020-05-19 18:00:10', '2020-05-19 18:00:10', NULL, 300.00, NULL, 6, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(4, '2020-05-19 18:00:37', '2020-05-19 18:00:37', NULL, 300.00, NULL, 7, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(5, '2020-05-19 18:01:16', '2020-05-19 18:01:16', NULL, 300.00, NULL, 8, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(6, '2020-05-19 18:07:27', '2020-05-19 18:07:27', NULL, 300.00, NULL, 9, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(7, '2020-05-19 18:09:18', '2020-05-19 18:09:18', NULL, 300.00, NULL, 10, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020051918091710688201', 0, NULL, NULL, 'wx19180917623790a999f2642c1876888100', 0, NULL, 2, 96),
	(8, '2020-05-19 18:10:25', '2020-05-19 18:10:25', NULL, 300.00, NULL, 11, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020051918102455395727', 0, NULL, NULL, 'wx19181025131807e9c9ff6cd91205279400', 0, NULL, 2, 96),
	(9, '2020-05-19 18:12:44', '2020-05-19 18:12:44', NULL, 300.00, NULL, 12, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020051918124482942265', 0, NULL, NULL, 'wx19181244262000224dca9a6e1090345400', 0, NULL, 2, 96),
	(10, '2020-05-19 18:13:21', '2020-05-19 18:13:21', NULL, 0.30, NULL, 13, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020051918132090381771', 0, NULL, NULL, 'wx19181320863521e31eaed86a1110831300', 0, NULL, 2, 96),
	(11, '2020-05-19 18:14:10', '2020-05-19 18:14:20', NULL, 0.01, NULL, 14, '4200000523202005191025810051', NULL, NULL, 'orderTradePayHandler', NULL, '2020051918140984731394', 1, NULL, NULL, 'wx1918140953076118cd9afb0a1143490100', 0, NULL, 2, 96),
	(12, '2020-05-19 18:40:20', '2020-05-19 18:40:30', NULL, 0.01, NULL, 15, '4200000533202005193669165506', NULL, NULL, 'orderTradePayHandler', NULL, '2020051918401930580175', 1, NULL, NULL, 'wx19184020089221ae9681c5cc1843899800', 0, NULL, 2, 96),
	(13, '2020-05-19 18:48:17', '2020-05-19 18:48:33', NULL, 0.01, NULL, 16, '4200000533202005194672011821', NULL, NULL, 'orderTradePayHandler', NULL, '2020051918481663051535', 1, NULL, NULL, 'wx1918481732678391a25706c31443908500', 0, NULL, 2, 96),
	(14, '2020-05-19 19:02:22', '2020-05-19 19:02:22', NULL, 0.30, NULL, 17, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(15, '2020-05-19 19:02:25', '2020-05-19 19:02:25', NULL, 0.30, NULL, 18, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(16, '2020-05-20 10:17:43', '2020-05-20 10:17:43', NULL, 0.01, NULL, 19, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052010174295632984', 0, NULL, NULL, 'wx20101742924236892de1b2de1844686800', 0, NULL, 2, 96),
	(17, '2020-05-20 10:17:52', '2020-05-20 10:17:52', NULL, 0.01, NULL, 20, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052010175156081014', 0, NULL, NULL, 'wx20101751905292ca4c2ffb2d1771054900', 0, NULL, 2, 96),
	(18, '2020-05-20 10:18:32', '2020-05-20 10:18:32', NULL, 0.01, NULL, 21, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052010183177753201', 0, NULL, NULL, 'wx20101832003336d522e4e5621566241200', 0, NULL, 2, 96),
	(19, '2020-05-20 10:19:09', '2020-05-20 10:19:09', NULL, 0.01, NULL, 22, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052010190864421315', 0, NULL, NULL, 'wx2010190875431327632d44bc1300260000', 0, NULL, 2, 96),
	(20, '2020-05-20 10:19:37', '2020-05-20 10:19:37', NULL, 0.01, NULL, 23, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052010193649379630', 0, NULL, NULL, 'wx201019370085425617b5350d1107614400', 0, NULL, 2, 96),
	(21, '2020-05-20 10:37:12', '2020-05-20 10:37:12', NULL, 0.01, NULL, 24, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(22, '2020-05-20 11:56:10', '2020-05-20 11:56:10', NULL, 0.01, NULL, 25, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(23, '2020-05-20 11:58:41', '2020-05-20 11:58:41', NULL, 0.01, NULL, 26, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(24, '2020-05-20 12:20:17', '2020-05-20 12:20:17', NULL, 0.01, NULL, 27, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(25, '2020-05-20 12:20:25', '2020-05-20 12:20:25', NULL, 0.01, NULL, 28, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(26, '2020-05-20 12:20:39', '2020-05-20 12:20:39', NULL, 0.01, NULL, 29, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(27, '2020-05-20 12:20:51', '2020-05-20 12:20:51', NULL, 0.01, NULL, 30, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(28, '2020-05-20 12:21:01', '2020-05-20 12:21:01', NULL, 0.01, NULL, 31, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(29, '2020-05-20 12:21:07', '2020-05-20 12:21:07', NULL, 0.01, NULL, 32, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(30, '2020-05-20 12:21:13', '2020-05-20 12:21:13', NULL, 0.01, NULL, 33, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(31, '2020-05-20 12:21:25', '2020-05-20 12:21:25', NULL, 0.01, NULL, 34, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(32, '2020-05-20 12:21:33', '2020-05-20 12:21:33', NULL, 0.01, NULL, 35, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(33, '2020-05-20 12:22:54', '2020-05-20 12:22:54', NULL, 0.01, NULL, 36, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(34, '2020-05-20 12:23:16', '2020-05-20 12:23:16', NULL, 0.01, NULL, 37, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(35, '2020-05-20 12:24:09', '2020-05-20 12:24:09', NULL, 0.01, NULL, 38, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(36, '2020-05-20 12:28:24', '2020-05-20 12:28:24', NULL, 0.01, NULL, 39, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052012282345292087', 0, NULL, NULL, 'wx20122823992674276cf12e7a1440903800', 0, NULL, 2, 96),
	(37, '2020-05-20 12:28:56', '2020-05-20 12:28:56', NULL, 0.01, NULL, 40, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052012285588379242', 0, NULL, NULL, 'wx2012285596683024011990531005028800', 0, NULL, 2, 96),
	(38, '2020-05-20 12:29:04', '2020-05-20 12:29:04', NULL, 0.01, NULL, 41, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(39, '2020-05-20 12:31:04', '2020-05-20 12:31:04', NULL, 0.01, NULL, 42, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052012310364885610', 0, NULL, NULL, 'wx2012310409091950c72aa67d1329755000', 0, NULL, 2, 96),
	(40, '2020-05-20 12:34:13', '2020-05-20 12:34:13', NULL, 0.01, NULL, 43, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052012341322514381', 0, NULL, NULL, 'wx201234134142524dc4270d191348423800', 0, NULL, 2, 96),
	(41, '2020-05-20 13:42:22', '2020-05-20 13:42:22', NULL, 0.01, NULL, 44, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052013422166678574', 0, NULL, NULL, 'wx20134221681736fdfa41ae1f1422711100', 0, NULL, 2, 96),
	(42, '2020-05-20 13:55:28', '2020-05-20 13:55:28', NULL, 0.01, NULL, 45, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052013552795062917', 0, NULL, NULL, 'wx201355281838803c66ff99261490929100', 0, NULL, 2, 96),
	(43, '2020-05-20 14:30:57', '2020-05-20 14:30:57', NULL, 0.01, NULL, 46, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(44, '2020-05-20 14:36:24', '2020-05-20 14:36:24', NULL, 0.01, NULL, 47, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(45, '2020-05-20 14:37:01', '2020-05-20 14:37:01', NULL, 0.01, NULL, 48, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(46, '2020-05-20 14:40:16', '2020-05-20 14:40:16', NULL, 0.01, NULL, 49, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(47, '2020-05-20 14:40:51', '2020-05-20 14:40:51', NULL, 0.01, NULL, 50, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(48, '2020-05-20 14:41:57', '2020-05-20 14:41:57', NULL, 0.01, NULL, 51, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(49, '2020-05-20 14:42:56', '2020-05-20 14:42:56', NULL, 0.01, NULL, 52, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(50, '2020-05-20 14:43:20', '2020-05-20 14:43:20', NULL, 0.01, NULL, 53, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(51, '2020-05-20 14:54:55', '2020-05-20 14:54:55', NULL, 0.01, NULL, 54, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052014545569451226', 0, NULL, NULL, 'wx20145455360664b12f2ed3dc1705906900', 0, NULL, 2, 96),
	(52, '2020-05-20 14:55:53', '2020-05-20 14:55:53', NULL, 0.01, NULL, 55, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052014555337486574', 0, NULL, NULL, 'wx2014555329002307c5797c751096098000', 0, NULL, 2, 96),
	(53, '2020-05-20 14:57:08', '2020-05-20 14:57:08', NULL, 0.01, NULL, 56, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052014570793040149', 0, NULL, NULL, 'wx20145708033456ca79b93e3f1822914900', 0, NULL, 2, 96),
	(54, '2020-05-20 15:08:24', '2020-05-20 15:08:24', NULL, 0.01, NULL, 57, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(55, '2020-05-20 15:10:09', '2020-05-20 15:10:09', NULL, 0.01, NULL, 58, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(56, '2020-05-20 15:36:37', '2020-05-20 15:36:37', NULL, 0.01, NULL, 59, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(57, '2020-05-20 17:26:29', '2020-05-20 17:26:29', NULL, 0.01, NULL, 60, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(58, '2020-05-20 17:30:17', '2020-05-20 17:30:17', NULL, 0.01, NULL, 61, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(59, '2020-05-20 17:33:19', '2020-05-20 17:33:19', NULL, 0.01, NULL, 62, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052017331886142587', 0, NULL, NULL, 'wx201733190272327e430a33121857765500', 0, NULL, 2, 96),
	(60, '2020-05-20 17:33:29', '2020-05-20 17:33:29', NULL, 0.01, NULL, 63, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052017332869271140', 0, NULL, NULL, 'wx2017332888292431f245b67c1063185000', 0, NULL, 2, 96),
	(61, '2020-05-20 17:33:54', '2020-05-20 17:33:54', NULL, 0.01, NULL, 64, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052017335342654425', 0, NULL, NULL, 'wx201733538173626b83a00bc61305003100', 0, NULL, 2, 96),
	(62, '2020-05-21 10:13:44', '2020-05-21 10:13:44', NULL, 0.01, NULL, 65, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(63, '2020-05-21 11:14:32', '2020-05-21 11:14:32', NULL, 1.00, NULL, 66, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052111143109650230', 0, NULL, NULL, 'wx211114321318493e2eb44afc1074137800', 0, NULL, 2, 96),
	(64, '2020-05-21 11:15:00', '2020-05-21 11:15:00', NULL, 1.20, NULL, 67, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052111145955627642', 0, NULL, NULL, 'wx2111145968963204c3d1d0631567506900', 0, NULL, 2, 96),
	(65, '2020-05-21 11:15:14', '2020-05-21 11:15:14', NULL, 1.01, NULL, 68, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052111151363952523', 0, NULL, NULL, 'wx2111151406583897c1302b081074497200', 0, NULL, 2, 96),
	(66, '2020-05-21 11:17:35', '2020-05-21 11:17:35', NULL, 0.01, NULL, 69, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052111173432451497', 0, NULL, NULL, 'wx211117349836568d638471481960244200', 0, NULL, 2, 96),
	(67, '2020-05-21 11:21:27', '2020-05-21 11:21:27', NULL, 0.28, NULL, 70, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052111212626372527', 0, NULL, NULL, 'wx21112126774556de13ab4f7f1169649100', 0, NULL, 2, 96),
	(68, '2020-05-21 11:29:08', '2020-05-21 11:29:08', NULL, 0.02, NULL, 71, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052111290781575060', 0, NULL, NULL, 'wx21112907892607a0aeb8e5041403897600', 0, NULL, 2, 96),
	(69, '2020-05-21 11:49:15', '2020-05-21 11:49:15', NULL, 1.00, NULL, 72, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052111491586284711', 0, NULL, NULL, 'wx21114915427565db719567151787543500', 0, NULL, 2, 96),
	(70, '2020-05-21 14:30:10', '2020-05-21 14:30:10', NULL, 0.01, NULL, 73, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(71, '2020-05-21 14:36:23', '2020-05-21 14:36:23', NULL, 0.01, NULL, 74, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(72, '2020-05-21 15:53:11', '2020-05-21 15:53:11', NULL, 0.01, NULL, 75, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(73, '2020-05-21 16:16:20', '2020-05-21 16:16:20', NULL, 0.00, NULL, 76, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(74, '2020-05-21 16:16:56', '2020-05-21 16:16:56', NULL, 0.00, NULL, 77, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(75, '2020-05-21 16:17:56', '2020-05-21 16:17:56', NULL, 0.00, NULL, 78, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(76, '2020-05-21 16:19:06', '2020-05-21 16:19:06', NULL, 0.00, NULL, 79, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(77, '2020-05-21 16:19:35', '2020-05-21 16:19:35', NULL, 0.00, NULL, 80, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(78, '2020-05-21 16:19:45', '2020-05-21 16:19:45', NULL, 0.00, NULL, 81, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(79, '2020-05-21 16:23:13', '2020-05-21 16:23:13', NULL, 0.15, NULL, 82, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052116231243677481', 0, NULL, NULL, 'wx21162313077730a98bdf27901240378200', 0, NULL, 2, 96),
	(80, '2020-05-21 16:27:40', '2020-05-21 16:27:40', NULL, 0.15, NULL, 83, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(81, '2020-05-21 16:27:52', '2020-05-21 16:27:52', NULL, 0.15, NULL, 84, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(82, '2020-05-21 16:28:24', '2020-05-21 16:28:24', NULL, 0.18, NULL, 85, NULL, NULL, NULL, 'orderTradePayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(83, '2020-05-21 16:28:50', '2020-05-21 16:28:50', NULL, 0.15, NULL, 86, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052116285057718174', 0, NULL, NULL, 'wx2116285034809167da7abf341159351300', 0, NULL, 2, 96),
	(84, '2020-05-21 16:30:14', '2020-05-21 16:30:14', NULL, 0.01, NULL, 82, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052116301498150126', 0, NULL, NULL, 'wx21163014262809e0e5fa21841632981700', 0, NULL, 2, 96),
	(85, '2020-05-21 16:34:35', '2020-05-21 16:34:35', NULL, 1.50, NULL, 87, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052116343403264809', 0, NULL, NULL, 'wx211634350197302abd02571f1374590600', 0, NULL, 2, 96),
	(86, '2020-05-21 16:35:44', '2020-05-21 16:35:44', NULL, 1.50, NULL, 88, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052116354316144326', 0, NULL, NULL, 'wx211635435347681c5451605b1507555000', 0, NULL, 2, 96),
	(87, '2020-05-21 16:35:58', '2020-05-21 16:35:58', NULL, 0.15, NULL, 89, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052116355722944470', 0, NULL, NULL, 'wx21163557956707d7d0b44c801624013800', 0, NULL, 2, 96),
	(88, '2020-05-21 16:37:22', '2020-05-21 16:37:26', NULL, 0.01, NULL, 90, '4200000538202005212451428455', NULL, NULL, 'orderTradePayHandler', NULL, '2020052116372271172692', 1, NULL, NULL, 'wx211637222760531e9be343d21762136600', 0, NULL, 2, 96),
	(89, '2020-05-21 16:53:36', '2020-05-21 16:53:36', NULL, 1.00, NULL, 91, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052116533559256670', 0, NULL, NULL, 'wx211653360873378b7b933c761481630800', 0, NULL, 2, 96),
	(90, '2020-05-21 16:57:26', '2020-05-21 16:57:26', NULL, 0.01, NULL, 92, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052116572549155364', 0, NULL, NULL, 'wx21165725688652498d2ef1551061931100', 0, NULL, 2, 96),
	(91, '2020-05-21 17:25:52', '2020-05-21 17:25:52', NULL, 0.01, NULL, 93, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052117255142523975', 0, NULL, NULL, 'wx2117255191890618c7f519b71345906700', 0, NULL, 2, 96),
	(92, '2020-05-21 17:37:27', '2020-05-21 17:37:27', NULL, 0.01, NULL, 93, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052117372656785922', 0, NULL, NULL, 'wx2117372707934367979dc2d11232233700', 0, NULL, 2, 96),
	(93, '2020-05-21 17:38:04', '2020-05-21 17:38:09', NULL, 0.01, NULL, 93, '4200000549202005216888503604', NULL, NULL, 'orderTradePayHandler', NULL, '2020052117380387543721', 1, NULL, NULL, 'wx211738040506241488485a401290987200', 0, NULL, 2, 96),
	(94, '2020-05-21 18:22:00', '2020-05-21 18:22:00', NULL, 0.01, NULL, 94, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052118215999610068', 0, NULL, NULL, 'wx21182200011208b6e77d46ad1381950000', 0, NULL, 2, 96),
	(95, '2020-05-21 18:22:15', '2020-05-21 18:22:15', NULL, 0.01, NULL, 94, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052118221457094939', 0, NULL, NULL, 'wx211822149905189e5a892cc61017714200', 0, NULL, 2, 96),
	(96, '2020-05-22 10:25:50', '2020-05-22 10:25:50', NULL, 0.01, NULL, 94, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052210254996620673', 0, NULL, NULL, 'wx22102549657833541f587c271941658500', 0, NULL, 2, 96),
	(97, '2020-05-22 14:23:29', '2020-05-22 14:23:29', NULL, 0.01, NULL, 95, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052214232844584884', 0, NULL, NULL, 'wx2214232898674815261795da1595376600', 0, NULL, 2, 96),
	(98, '2020-05-22 14:23:41', '2020-05-22 14:23:41', NULL, 0.01, NULL, 95, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052214234122100751', 0, NULL, NULL, 'wx22142341284724f8c0b2b8ce1007257800', 0, NULL, 2, 96),
	(99, '2020-05-22 14:24:17', '2020-05-22 14:24:17', NULL, 0.01, NULL, 96, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052214241655305001', 0, NULL, NULL, 'wx221424169862892f8b1715e21129895200', 0, NULL, 2, 96),
	(100, '2020-05-22 14:24:39', '2020-05-22 14:24:39', NULL, 0.01, NULL, 96, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052214243815204348', 0, NULL, NULL, 'wx221424389574372fdd3658e41525140300', 0, NULL, 2, 96),
	(101, '2020-05-22 14:26:33', '2020-05-22 14:26:54', NULL, 0.01, NULL, 96, '4200000524202005228933687617', NULL, NULL, 'orderTradePayHandler', NULL, '2020052214263229460957', 1, NULL, NULL, 'wx22142632831219516d96bd301413465900', 0, NULL, 2, 96),
	(102, '2020-05-22 14:42:18', '2020-05-22 14:42:18', NULL, 0.01, NULL, 95, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052214421706221920', 0, NULL, NULL, 'wx221442178252397d62dcd0b31114603900', 0, NULL, 2, 96),
	(103, '2020-05-22 14:44:35', '2020-05-22 14:44:35', NULL, 0.01, NULL, 97, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052214443423639988', 0, NULL, NULL, 'wx221444345513961d9ad188de1248849000', 0, NULL, 2, 96),
	(104, '2020-05-22 14:44:39', '2020-05-22 14:44:39', NULL, 0.01, NULL, 98, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052214443883341954', 0, NULL, NULL, 'wx22144439037479aeab7d73bf1865036800', 0, NULL, 2, 96),
	(105, '2020-05-22 14:44:45', '2020-05-22 14:44:45', NULL, 0.01, NULL, 99, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052214444498773114', 0, NULL, NULL, 'wx22144445054415ac9d4191ca1884654500', 0, NULL, 2, 96),
	(106, '2020-05-22 14:44:46', '2020-05-22 14:44:46', NULL, 0.01, NULL, 100, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052214444516926758', 0, NULL, NULL, 'wx22144445552529731d492c961021322900', 0, NULL, 2, 96),
	(107, '2020-05-22 14:44:48', '2020-05-22 14:44:48', NULL, 0.01, NULL, 101, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052214444786924569', 0, NULL, NULL, 'wx2214444758198390b04b08b41866702400', 0, NULL, 2, 96),
	(108, '2020-05-22 14:45:15', '2020-05-22 14:45:15', NULL, 0.01, NULL, 102, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052214451409771910', 0, NULL, NULL, 'wx221445150184908d7588e2e21889675400', 0, NULL, 2, 96),
	(109, '2020-05-22 14:47:00', '2020-05-22 14:47:00', NULL, 0.01, NULL, 103, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052214465936926020', 0, NULL, NULL, 'wx22144659799860271b5942d01353091500', 0, NULL, 2, 96),
	(110, '2020-05-22 14:47:22', '2020-05-22 14:47:22', NULL, 0.01, NULL, 103, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052214472203497378', 0, NULL, NULL, 'wx2214472222097762c384effa1920045100', 0, NULL, 2, 96),
	(111, '2020-05-22 14:47:34', '2020-05-22 14:47:34', NULL, 0.01, NULL, 103, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052214473314738893', 0, NULL, NULL, 'wx221447341166867b4472fe8b1576652500', 0, NULL, 2, 96),
	(112, '2020-05-22 14:49:01', '2020-05-22 14:49:01', NULL, 0.01, NULL, 103, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052214490122241161', 0, NULL, NULL, 'wx2214490118182261a5030a9b1776625500', 0, NULL, 2, 96),
	(113, '2020-05-22 14:49:04', '2020-05-22 14:49:04', NULL, 0.01, NULL, 102, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052214490379349717', 0, NULL, NULL, 'wx22144903974980cd3d071cdd1266956100', 0, NULL, 2, 96),
	(114, '2020-05-22 14:52:52', '2020-05-22 14:52:52', NULL, 0.01, NULL, 97, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052214525169411906', 0, NULL, NULL, 'wx221452517421095895b002b61646159700', 0, NULL, 2, 96),
	(115, '2020-05-22 14:57:06', '2020-05-22 14:57:24', NULL, 0.01, NULL, 97, '4200000525202005224452662813', NULL, NULL, 'orderTradePayHandler', NULL, '2020052214570589589189', 1, NULL, NULL, 'wx221457060692980cfa3cf0221187588400', 0, NULL, 2, 96),
	(116, '2020-05-22 14:59:41', '2020-05-22 14:59:41', NULL, 0.01, NULL, 104, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052214594081719226', 0, NULL, NULL, 'wx221459409189621b78cdcb651469894100', 0, NULL, 2, 96),
	(117, '2020-05-22 14:59:50', '2020-05-22 15:00:03', NULL, 0.01, NULL, 104, '4200000542202005224038390796', NULL, NULL, 'orderTradePayHandler', NULL, '2020052214594968353527', 1, NULL, NULL, 'wx22145949558298ff96ae3a371849732400', 0, NULL, 2, 96),
	(118, '2020-05-22 15:03:21', '2020-05-22 15:03:21', NULL, 0.01, NULL, 105, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052215032006625179', 0, NULL, NULL, 'wx22150320936589c6a5737eb01723601800', 0, NULL, 2, 96),
	(119, '2020-05-22 15:03:54', '2020-05-22 15:03:54', NULL, 0.01, NULL, 105, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052215035430410712', 0, NULL, NULL, 'wx22150354230598598c76a8911115862800', 0, NULL, 2, 96),
	(120, '2020-05-22 15:04:29', '2020-05-22 15:04:29', NULL, 0.01, NULL, 105, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052215042835379787', 0, NULL, NULL, 'wx2215042887961121d3aad80d1079635100', 0, NULL, 2, 96),
	(121, '2020-05-22 15:04:49', '2020-05-22 15:04:49', NULL, 0.01, NULL, 105, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052215044874007586', 0, NULL, NULL, 'wx2215044905917673e8f2c9091142294600', 0, NULL, 2, 96),
	(122, '2020-05-22 15:05:27', '2020-05-22 15:05:27', NULL, 0.01, NULL, 105, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052215052665427460', 0, NULL, NULL, 'wx2215052652231457bffc436f1775254700', 0, NULL, 2, 96),
	(123, '2020-05-22 15:11:20', '2020-05-22 15:11:38', NULL, 0.01, NULL, 105, '4200000522202005228082845076', NULL, NULL, 'orderTradePayHandler', NULL, '2020052215111915019285', 1, NULL, NULL, 'wx22151120028298fa55a7423e1033065500', 0, NULL, 2, 96),
	(124, '2020-05-22 15:15:02', '2020-05-22 15:15:02', NULL, 0.01, NULL, 106, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052215150197314089', 0, NULL, NULL, 'wx22151501887393c80d2b228f1660474600', 0, NULL, 2, 96),
	(125, '2020-05-22 15:18:30', '2020-05-22 15:18:30', NULL, 0.12, NULL, 107, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052215183039631039', 0, NULL, NULL, 'wx22151830180721c7f72ba9511166489800', 0, NULL, 2, 96),
	(126, '2020-05-22 15:23:07', '2020-05-22 15:23:07', NULL, 0.04, NULL, 108, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052215230774408903', 0, NULL, NULL, 'wx22152307418968d12b64364b1829785200', 0, NULL, 2, 96),
	(127, '2020-05-22 15:23:22', '2020-05-22 15:23:22', NULL, 0.08, NULL, 109, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052215232236699783', 0, NULL, NULL, 'wx22152322413444a1706b7d501587955300', 0, NULL, 2, 96),
	(128, '2020-05-22 15:23:36', '2020-05-22 15:23:36', NULL, 0.08, NULL, 110, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052215233651018967', 0, NULL, NULL, 'wx22152336273160e0ab6157091727491200', 0, NULL, 2, 96),
	(129, '2020-05-22 15:23:45', '2020-05-22 15:23:45', NULL, 0.07, NULL, 111, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052215234564415396', 0, NULL, NULL, 'wx22152345401704e65b779a351745463100', 0, NULL, 2, 96),
	(130, '2020-05-23 09:52:14', '2020-05-23 09:52:14', NULL, 0.07, NULL, 111, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052309521354883132', 0, NULL, NULL, 'wx230952137904928698d694d91980498700', 0, NULL, 2, 96),
	(131, '2020-05-23 22:23:54', '2020-05-23 22:23:54', NULL, 0.01, NULL, 112, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052322235319568448', 0, NULL, NULL, 'wx232223542918349932b6933b1156735700', 0, NULL, 2, 96),
	(132, '2020-05-23 22:24:17', '2020-05-23 22:24:17', NULL, 0.07, NULL, 111, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052322241681120834', 0, NULL, NULL, 'wx23222416757347b4f06c24a71226031600', 0, NULL, 2, 96),
	(133, '2020-05-27 09:59:01', '2020-05-27 09:59:01', NULL, 0.10, NULL, 1, NULL, NULL, NULL, 'orderPayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(134, '2020-05-27 09:59:26', '2020-05-27 09:59:26', NULL, 330.10, NULL, 2, NULL, NULL, NULL, 'orderPayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(135, '2020-05-27 10:00:07', '2020-05-27 10:00:07', NULL, 3.00, NULL, 3, NULL, NULL, NULL, 'orderPayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(136, '2020-05-27 10:00:35', '2020-05-27 10:00:35', NULL, 3.00, NULL, 4, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052710003495377158', 0, NULL, NULL, 'wx2710003451333205e55d174e1756039700', 0, NULL, 2, 96),
	(137, '2020-05-27 10:01:02', '2020-05-27 10:01:02', NULL, 3.00, NULL, 5, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052710010176544970', 0, NULL, NULL, 'wx27100102130338bcc48fdb431847052500', 0, NULL, 2, 96),
	(138, '2020-05-27 10:01:25', '2020-05-27 10:01:25', NULL, 3.00, NULL, 6, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052710012486032554', 0, NULL, NULL, 'wx27100124669541ae921b28551410941900', 0, NULL, 2, 96),
	(139, '2020-05-27 10:02:13', '2020-05-27 10:02:13', NULL, 3.00, NULL, 7, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052710021209595883', 0, NULL, NULL, 'wx2710021307736121a13565c51915167800', 0, NULL, 2, 96),
	(140, '2020-05-27 10:02:44', '2020-05-27 10:02:44', NULL, 530.00, NULL, 8, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052710024365029691', 0, NULL, NULL, 'wx27100243700377bd4e50d0a31815625200', 0, NULL, 2, 96),
	(141, '2020-05-27 10:05:19', '2020-05-27 10:05:19', NULL, 530.00, NULL, 9, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052710051856659870', 0, NULL, NULL, 'wx27100518531389cb750f915d1048568700', 0, NULL, 2, 96),
	(142, '2020-05-27 14:51:38', '2020-05-27 14:51:38', NULL, 3333.00, NULL, 10, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052714513830171581', 0, NULL, NULL, 'wx271451382605423f08e069ec1384402800', 0, NULL, 2, 96),
	(143, '2020-05-27 14:52:58', '2020-05-27 14:52:58', NULL, 0.01, NULL, 11, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052714525760889801', 0, NULL, NULL, 'wx271452577937198e24d5535c1623228300', 0, NULL, 2, 96),
	(144, '2020-05-27 14:53:16', '2020-05-27 14:53:28', NULL, 0.01, NULL, 12, '4200000535202005275160295280', NULL, NULL, 'orderPayHandler', NULL, '2020052714531513772882', 1, NULL, NULL, 'wx271453159166905da69493d71152505300', 0, NULL, 2, 96),
	(145, '2020-05-27 15:00:19', '2020-05-27 15:00:19', NULL, 0.01, NULL, 13, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052715001865063643', 0, NULL, NULL, 'wx2715001878852487f23f5f7b1382051400', 0, NULL, 2, 96),
	(146, '2020-05-27 15:00:38', '2020-05-27 15:00:38', NULL, 330.01, NULL, 14, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052715003725967980', 0, NULL, NULL, 'wx27150037862119572e1faf851324150100', 0, NULL, 2, 96),
	(147, '2020-05-27 15:08:14', '2020-05-27 15:08:14', NULL, 53.00, NULL, 15, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052715081397371579', 0, NULL, NULL, 'wx271508141382953c550b6c3b1630252300', 0, NULL, 2, 96),
	(148, '2020-05-27 15:13:17', '2020-05-27 15:13:17', NULL, 330.00, NULL, 16, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052715131657601735', 0, NULL, NULL, 'wx27151316590102285bf3327e1481630900', 0, NULL, 2, 96),
	(149, '2020-05-27 15:15:51', '2020-05-27 15:15:51', NULL, 0.11, NULL, 17, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052715155156867483', 0, NULL, NULL, 'wx27151551262009ce8c2388eb1626789100', 0, NULL, 2, 96),
	(150, '2020-05-27 15:16:39', '2020-05-27 15:16:39', NULL, 53.00, NULL, 18, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052715163830867779', 0, NULL, NULL, 'wx271516386103109ece8489e91371990200', 0, NULL, 2, 96),
	(151, '2020-05-27 15:16:51', '2020-05-27 15:16:51', NULL, 59.01, NULL, 19, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052715165166104648', 0, NULL, NULL, 'wx271516514286486b03ec916e1665379200', 0, NULL, 2, 96),
	(152, '2020-05-27 15:17:03', '2020-05-27 15:17:03', NULL, 92.01, NULL, 20, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052715170231382952', 0, NULL, NULL, 'wx271517027087236d1cb5d8871589463600', 0, NULL, 2, 96),
	(153, '2020-05-27 15:18:02', '2020-05-27 15:18:02', NULL, 0.01, NULL, 21, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052715180167024847', 0, NULL, NULL, 'wx271518020298333e5d7b1e001055685600', 0, NULL, 2, 96),
	(154, '2020-05-27 15:40:51', '2020-05-27 15:40:51', NULL, 136.01, NULL, 22, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052715405147962364', 0, NULL, NULL, 'wx27154051302301618a6b492a1317261200', 0, NULL, 2, 96),
	(155, '2020-05-27 15:48:35', '2020-05-27 15:48:35', NULL, 0.01, NULL, 21, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052715483474697218', 0, NULL, NULL, 'wx271548346382326feb52dfcf1718529500', 0, NULL, 2, 96),
	(156, '2020-05-27 15:50:22', '2020-05-27 15:50:22', NULL, 583.00, NULL, 23, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052715502164176185', 0, NULL, NULL, 'wx271550221743772bebaf27241525055500', 0, NULL, 2, 96),
	(157, '2020-05-27 15:58:43', '2020-05-27 15:59:08', NULL, 0.01, NULL, 24, '4200000535202005277408059038', NULL, NULL, 'orderPayHandler', NULL, '2020052715584227444028', 1, NULL, NULL, 'wx271558427485658ed92e0b361691086700', 0, NULL, 2, 96),
	(158, '2020-05-27 15:59:26', '2020-05-27 15:59:26', NULL, 0.01, NULL, 25, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052715592500306642', 0, NULL, NULL, 'wx271559255948832ea5161f1b1952770300', 0, NULL, 2, 96),
	(159, '2020-05-27 15:59:29', '2020-05-27 15:59:29', NULL, 0.01, NULL, 26, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052715592814596471', 0, NULL, NULL, 'wx27155928539767cd0131700a1635150300', 0, NULL, 2, 96),
	(160, '2020-05-27 15:59:32', '2020-05-27 15:59:32', NULL, 0.01, NULL, 27, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052715593139730117', 0, NULL, NULL, 'wx271559318449635947752fb21176140600', 0, NULL, 2, 96),
	(161, '2020-05-27 15:59:44', '2020-05-27 15:59:44', NULL, 0.01, NULL, 26, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052715594456275485', 0, NULL, NULL, 'wx27155944423597ab4eac1bf21567381400', 0, NULL, 2, 96),
	(162, '2020-05-27 15:59:53', '2020-05-27 15:59:53', NULL, 0.01, NULL, 25, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052715595246573169', 0, NULL, NULL, 'wx27155952730318ba6b35e9d91178153300', 0, NULL, 2, 96),
	(163, '2020-05-27 16:02:28', '2020-05-27 16:02:28', NULL, 530.00, NULL, 28, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052716022756421786', 0, NULL, NULL, 'wx271602275396074698abcd651361625100', 0, NULL, 2, 96),
	(164, '2020-05-27 16:02:45', '2020-05-27 16:02:45', NULL, 583.11, NULL, 29, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052716024466181081', 0, NULL, NULL, 'wx27160244649880e05f90bc8a1505763500', 0, NULL, 2, 96),
	(165, '2020-05-27 16:06:08', '2020-05-27 16:06:08', NULL, 748.00, NULL, 30, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052716060715931879', 0, NULL, NULL, 'wx271606081768701fd0fab7681207721600', 0, NULL, 2, 96),
	(166, '2020-05-27 16:15:36', '2020-05-27 16:15:36', NULL, 0.01, NULL, 113, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052716153609578288', 0, NULL, NULL, 'wx271615363802938b329381941044074100', 0, NULL, 2, 96),
	(167, '2020-05-27 16:16:35', '2020-05-27 16:16:35', NULL, 0.01, NULL, 114, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052716163419373782', 0, NULL, NULL, 'wx27161635055480a18a9db6741682404200', 0, NULL, 2, 96),
	(168, '2020-05-27 17:12:44', '2020-05-27 17:12:44', NULL, 0.01, NULL, 115, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052717124473747157', 0, NULL, NULL, 'wx2717124437913963d170759f1927256600', 0, NULL, 2, 96),
	(169, '2020-05-27 17:13:35', '2020-05-27 17:14:34', NULL, 0.01, NULL, 116, '4200000538202005273718509776', NULL, NULL, 'orderTradePayHandler', NULL, '2020052717133402187333', 1, NULL, NULL, 'wx27171334539890c7bafe539f1543797800', 0, NULL, 2, 96),
	(170, '2020-05-27 17:16:36', '2020-05-27 17:16:36', NULL, 0.01, NULL, 31, NULL, NULL, NULL, 'orderPayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(171, '2020-05-27 17:17:17', '2020-05-27 17:17:37', NULL, 0.01, NULL, 32, '4200000529202005270154695052', NULL, NULL, 'orderPayHandler', NULL, '2020052717171646510128', 1, NULL, NULL, 'wx2717171713928306d0ec92a11372534800', 0, NULL, 2, 96),
	(172, '2020-05-27 17:18:16', '2020-05-27 17:18:16', NULL, 0.01, NULL, 33, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052717181520483634', 0, NULL, NULL, 'wx27171815613077d720bee1cc1804584700', 0, NULL, 2, 96),
	(173, '2020-05-27 17:18:52', '2020-05-27 17:18:52', NULL, 0.01, NULL, 117, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052717185281941271', 0, NULL, NULL, 'wx27171852218440b97c29ce5c1888781300', 0, NULL, 2, 96),
	(174, '2020-05-27 17:22:06', '2020-05-27 17:22:06', NULL, 0.01, NULL, 118, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052717220516083099', 0, NULL, NULL, 'wx27172205740088df2b17ae001219174000', 0, NULL, 2, 96),
	(175, '2020-05-27 17:22:38', '2020-05-27 17:22:48', NULL, 0.01, NULL, 34, '4200000544202005276281827927', NULL, NULL, 'orderPayHandler', NULL, '2020052717223763185738', 1, NULL, NULL, 'wx2717223777893261c753ccf11197354800', 0, NULL, 2, 96),
	(176, '2020-05-27 17:27:27', '2020-05-27 17:27:51', NULL, 0.01, NULL, 35, '4200000531202005273392897543', NULL, NULL, 'orderPayHandler', NULL, '2020052717272655358116', 1, NULL, NULL, 'wx27172726629852f50a2f2c451995276400', 0, NULL, 2, 96),
	(177, '2020-05-27 17:29:55', '2020-05-27 17:30:15', NULL, 0.01, NULL, 36, '4200000523202005270289839663', NULL, NULL, 'orderPayHandler', NULL, '2020052717295409028600', 1, NULL, NULL, 'wx2717295449241192e3179ccb1614353000', 0, NULL, 2, 96),
	(178, '2020-05-27 19:38:29', '2020-05-27 19:38:29', NULL, 0.01, NULL, 37, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052719382993852695', 0, NULL, NULL, 'wx27193829325052295b679c091593304900', 0, NULL, 2, 96),
	(179, '2020-05-27 19:38:53', '2020-05-27 19:38:53', NULL, 43.00, NULL, 38, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052719385261905523', 0, NULL, NULL, 'wx271938524700600d5ed36d411425717600', 0, NULL, 2, 98),
	(180, '2020-05-27 19:39:32', '2020-05-27 19:39:43', NULL, 0.01, NULL, 119, '4200000538202005271767258666', NULL, NULL, 'orderTradePayHandler', NULL, '2020052719393155756551', 1, NULL, NULL, 'wx2719393216825196d18ec2d51810932300', 0, NULL, 2, 98),
	(181, '2020-05-27 19:40:28', '2020-05-27 19:40:28', NULL, 0.01, NULL, 120, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052719402703958516', 0, NULL, NULL, 'wx27194028149209ec51359dc31867951500', 0, NULL, 2, 98),
	(182, '2020-05-27 19:40:31', '2020-05-27 19:40:31', NULL, 0.01, NULL, 121, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052719403032403239', 0, NULL, NULL, 'wx27194030981278036a01073a1486174000', 0, NULL, 2, 98),
	(183, '2020-05-27 19:40:33', '2020-05-27 19:40:33', NULL, 0.01, NULL, 122, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052719403253351319', 0, NULL, NULL, 'wx271940331791639ebfea7c411908370000', 0, NULL, 2, 98),
	(184, '2020-05-27 19:40:35', '2020-05-27 19:40:35', NULL, 0.01, NULL, 123, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052719403579879822', 0, NULL, NULL, 'wx271940352135508158a290b01512171600', 0, NULL, 2, 98),
	(185, '2020-05-28 09:55:46', '2020-05-28 09:55:46', NULL, 0.01, NULL, 39, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052809554503086337', 0, NULL, NULL, 'wx280955460496855bd2398e3d1507109300', 0, NULL, 2, 96),
	(186, '2020-05-28 09:56:51', '2020-05-28 09:56:51', NULL, 0.01, NULL, 40, NULL, NULL, NULL, 'orderPayHandler', NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, 2, 96),
	(187, '2020-05-28 09:58:56', '2020-05-28 09:58:56', NULL, 0.01, NULL, 41, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052809585563406540', 0, NULL, NULL, 'wx28095856020879ad30c5d0fe1753752100', 0, NULL, 2, 96),
	(188, '2020-05-28 09:59:44', '2020-05-28 09:59:44', NULL, 0.01, NULL, 42, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052809594394088021', 0, NULL, NULL, 'wx28095943902743d3edb65eea1802439700', 0, NULL, 2, 96),
	(189, '2020-05-28 10:00:48', '2020-05-28 10:00:48', NULL, 0.01, NULL, 43, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052810004818714125', 0, NULL, NULL, 'wx28100048434075359b5d471e1070799400', 0, NULL, 2, 96),
	(190, '2020-05-28 10:01:45', '2020-05-28 10:01:45', NULL, 0.01, NULL, 44, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052810014529900997', 0, NULL, NULL, 'wx281001453803660d46a8f3b71347517900', 0, NULL, 2, 96),
	(191, '2020-05-28 10:04:16', '2020-05-28 10:04:16', NULL, 0.01, NULL, 45, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052810041686505650', 0, NULL, NULL, 'wx281004163834392b3dbd9ec71857591900', 0, NULL, 2, 96),
	(192, '2020-05-28 10:05:04', '2020-05-28 10:05:04', NULL, 0.01, NULL, 46, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052810050451214312', 0, NULL, NULL, 'wx281005043007181debb798751827793600', 0, NULL, 2, 96),
	(193, '2020-05-28 10:05:46', '2020-05-28 10:06:06', NULL, 0.01, NULL, 47, '4200000544202005284773764351', NULL, NULL, 'orderPayHandler', NULL, '2020052810054656303569', 1, NULL, NULL, 'wx28100546201763bc79b4b5281712235800', 0, NULL, 2, 96),
	(194, '2020-05-28 10:07:37', '2020-05-28 10:07:48', NULL, 0.01, NULL, 48, '4200000526202005284400638370', NULL, NULL, 'orderPayHandler', NULL, '2020052810073605719377', 1, NULL, NULL, 'wx281007367612504bb44c304b1328805500', 0, NULL, 2, 96),
	(195, '2020-05-28 10:09:38', '2020-05-28 10:09:48', NULL, 0.01, NULL, 49, '4200000550202005289983865978', NULL, NULL, 'orderPayHandler', NULL, '2020052810093816543471', 1, NULL, NULL, 'wx281009384395624eb6c9c7381432082400', 0, NULL, 2, 96),
	(196, '2020-05-28 10:12:02', '2020-05-28 10:12:02', NULL, 0.01, NULL, 50, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052810120176654348', 0, NULL, NULL, 'wx281012018537548c460228bb1062672300', 0, NULL, 2, 96),
	(197, '2020-05-28 10:12:54', '2020-05-28 10:12:54', NULL, 0.01, NULL, 51, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052810125309658608', 0, NULL, NULL, 'wx28101253553666ae3427e98e1468918700', 0, NULL, 2, 96),
	(198, '2020-05-28 10:13:01', '2020-05-28 10:13:06', NULL, 0.01, NULL, 52, '4200000551202005289609460243', NULL, NULL, 'orderPayHandler', NULL, '2020052810130085987741', 1, NULL, NULL, 'wx28101300922060ed0ef702061794820900', 0, NULL, 2, 96),
	(199, '2020-05-28 10:38:30', '2020-05-28 10:38:30', NULL, 20.00, NULL, 53, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052810382943624132', 0, NULL, NULL, 'wx281038298107332dbc1602c71549786100', 0, NULL, 2, 96),
	(200, '2020-05-28 14:31:02', '2020-05-28 14:31:28', NULL, 0.01, NULL, 54, '4200000545202005282649517697', NULL, NULL, 'orderPayHandler', NULL, '2020052814310198259951', 1, NULL, NULL, 'wx28143102297989d884d58a111102611800', 0, NULL, 2, 96),
	(201, '2020-05-28 14:32:15', '2020-05-28 14:32:30', NULL, 0.01, NULL, 55, '4200000543202005289297507849', NULL, NULL, 'orderPayHandler', NULL, '2020052814321493169867', 1, NULL, NULL, 'wx28143215187468c924f9dc921957922500', 0, NULL, 2, 96),
	(202, '2020-05-28 15:02:25', '2020-05-28 15:02:25', NULL, 43.00, NULL, 56, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052815022579965005', 0, NULL, NULL, 'wx2815022538456797d17861b61335394800', 0, NULL, 2, 96),
	(203, '2020-05-28 15:02:42', '2020-05-28 15:02:42', NULL, 330.00, NULL, 57, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052815024216586195', 0, NULL, NULL, 'wx2815024225252837cd1eb64a1393787100', 0, NULL, 2, 96),
	(204, '2020-05-28 15:03:01', '2020-05-28 15:03:01', NULL, 3.00, NULL, 58, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052815030057727850', 0, NULL, NULL, 'wx2815030099644095c6ccadd21756074500', 0, NULL, 2, 96),
	(205, '2020-05-28 15:25:44', '2020-05-28 15:25:44', NULL, 330.00, NULL, 57, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052815254366574801', 0, NULL, NULL, 'wx28152543696278e6b27c34191489447700', 0, NULL, 2, 96),
	(206, '2020-05-28 15:25:47', '2020-05-28 15:25:47', NULL, 43.00, NULL, 56, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052815254617229807', 0, NULL, NULL, 'wx281525470473596e9d8dce0f1495003000', 0, NULL, 2, 96),
	(207, '2020-05-28 17:48:01', '2020-05-28 17:48:01', NULL, 15500.00, NULL, 59, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020052817480178719654', 0, NULL, NULL, 'wx2817480139869264c77f62b21995826700', 0, NULL, 2, 96),
	(208, '2020-05-28 17:48:36', '2020-05-28 17:48:44', NULL, 0.01, NULL, 60, '4200000542202005283077334535', NULL, NULL, 'orderPayHandler', NULL, '2020052817483538381764', 1, NULL, NULL, 'wx28174836110697cacf58f0331899175800', 0, NULL, 2, 96),
	(209, '2020-05-28 17:55:52', '2020-05-28 17:55:52', NULL, 96.02, NULL, 124, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020052817555249650049', 0, NULL, NULL, 'wx281755524326082e65cdc3221924495000', 0, NULL, 2, 96),
	(210, '2020-05-28 17:56:11', '2020-05-28 17:56:16', NULL, 0.02, NULL, 125, '4200000526202005285337056947', NULL, NULL, 'orderTradePayHandler', NULL, '2020052817561016151419', 1, NULL, NULL, 'wx281756106040357fdc7dd5ed1595811600', 0, NULL, 2, 96),
	(211, '2020-05-31 22:32:50', '2020-05-31 22:32:50', NULL, 4000.00, NULL, 61, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020053122324915375095', 0, NULL, NULL, 'wx312232499559217f37c409921815472300', 0, NULL, 2, 96),
	(212, '2020-06-02 21:38:28', '2020-06-02 21:38:28', NULL, 760.00, NULL, 62, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020060221382748841692', 0, NULL, NULL, 'wx02213828219880fcc0d23b131390268800', 0, NULL, 2, 96),
	(213, '2020-06-03 11:30:54', '2020-06-03 11:30:54', NULL, 48.00, NULL, 126, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020060311305358307411', 0, NULL, NULL, 'wx0311305362156540fa4c206f1507280500', 0, NULL, 2, 96),
	(214, '2020-06-05 11:11:46', '2020-06-05 11:11:46', NULL, 262.80, NULL, 63, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020060511114400539782', 0, NULL, NULL, 'wx051111455014131a110673401940226000', 0, NULL, 2, 96),
	(215, '2020-06-05 11:13:04', '2020-06-05 11:13:04', NULL, 2693.70, NULL, 64, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020060511130354187972', 0, NULL, NULL, 'wx05111304063458bde2700a011409130700', 0, NULL, 2, 96),
	(216, '2020-06-05 13:04:44', '2020-06-05 13:05:08', NULL, 0.01, NULL, 65, '4200000542202006057741251616', NULL, NULL, 'orderPayHandler', NULL, '2020060513044346761101', 1, NULL, NULL, 'wx051304442770985608a0ebb91517782100', 0, NULL, 2, 96),
	(217, '2020-06-05 13:05:28', '2020-06-05 13:05:46', NULL, 0.01, NULL, 66, '4200000534202006059418585535', NULL, NULL, 'orderPayHandler', NULL, '2020060513052774222246', 1, NULL, NULL, 'wx0513052751600872f1383f301855217600', 0, NULL, 2, 96),
	(218, '2020-06-05 13:06:01', '2020-06-05 13:06:22', NULL, 0.01, NULL, 67, '4200000545202006058514600370', NULL, NULL, 'orderPayHandler', NULL, '2020060513060116630868', 1, NULL, NULL, 'wx05130601401379c74e03ca8b1867312300', 0, NULL, 2, 96),
	(219, '2020-06-10 17:18:28', '2020-06-10 17:18:28', NULL, 1.00, NULL, NULL, NULL, NULL, NULL, 'commonHandle', NULL, '2020061017182665794854', 0, NULL, NULL, NULL, NULL, NULL, 2, 96),
	(220, '2020-06-10 17:35:59', '2020-06-10 17:35:59', NULL, 1.00, NULL, NULL, NULL, NULL, NULL, 'commonHandle', NULL, '2020061017355888567377', 0, NULL, NULL, NULL, NULL, NULL, 2, 96),
	(221, '2020-06-10 17:36:11', '2020-06-10 17:36:42', NULL, 0.01, NULL, NULL, '4200000541202006102212271750', NULL, NULL, 'commonHandle', NULL, '2020061017361071783534', 1, NULL, NULL, NULL, NULL, NULL, 2, 96),
	(222, '2020-06-10 17:37:51', '2020-06-10 17:37:51', NULL, 0.01, NULL, NULL, NULL, NULL, NULL, 'commonHandle', NULL, '2020061017375073615833', 0, NULL, NULL, NULL, NULL, NULL, 2, 96),
	(223, '2020-06-10 17:51:01', '2020-06-10 17:51:01', NULL, 0.01, NULL, NULL, NULL, NULL, NULL, 'commonHandle', NULL, '2020061017510042115278', 0, NULL, NULL, NULL, NULL, NULL, 2, 96),
	(224, '2020-06-10 18:19:24', '2020-06-10 18:19:30', NULL, 0.01, NULL, NULL, '4200000528202006100883269163', NULL, NULL, 'commonHandle', NULL, '2020061018192352883390', 1, NULL, NULL, NULL, NULL, NULL, 2, 96),
	(225, '2020-06-10 18:31:37', '2020-06-10 18:31:49', NULL, 0.01, NULL, NULL, '4200000537202006100795406424', NULL, NULL, 'commonHandler', NULL, '2020061018313523680700', 1, NULL, NULL, NULL, NULL, NULL, 2, 96),
	(226, '2020-06-11 10:47:07', '2020-06-11 10:47:07', NULL, 0.10, NULL, NULL, NULL, NULL, NULL, 'commonHandler', NULL, '2020061110470718926399', 0, NULL, NULL, NULL, NULL, NULL, 2, 96),
	(227, '2020-06-11 10:47:17', '2020-06-11 10:47:22', NULL, 0.01, NULL, NULL, '4200000550202006113166016495', NULL, NULL, 'commonHandler', NULL, '2020061110471696611976', 1, NULL, NULL, NULL, NULL, NULL, 2, 96),
	(228, '2020-06-11 15:14:02', '2020-06-11 15:14:02', NULL, 0.01, NULL, NULL, NULL, NULL, NULL, 'commonHandler', NULL, '2020061115140133875022', 0, NULL, NULL, NULL, NULL, NULL, 2, 96),
	(229, '2020-06-11 15:37:32', '2020-06-11 15:37:32', NULL, 1.23, NULL, 68, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020061115373149322983', 0, NULL, NULL, 'wx11153731508484dd0503d5ac1438126200', 0, NULL, 2, 96),
	(230, '2020-06-12 10:35:45', '2020-06-12 10:35:45', NULL, 93.00, NULL, NULL, NULL, NULL, NULL, 'commonHandler', NULL, '2020061210354415799488', 0, NULL, NULL, NULL, NULL, NULL, 2, 96),
	(231, '2020-06-12 15:33:00', '2020-06-12 15:33:14', NULL, 0.01, NULL, 69, '4200000535202006121121018700', NULL, NULL, 'orderPayHandler', NULL, '2020061215325647628761', 1, NULL, NULL, 'wx121532596019145c6f9ae5151098518700', 0, NULL, 2, 96),
	(232, '2020-06-12 16:06:25', '2020-06-12 16:06:48', NULL, 0.02, NULL, 70, '4200000539202006124877788794', NULL, NULL, 'orderPayHandler', NULL, '2020061216062411630101', 1, NULL, NULL, 'wx12160625042037ceeb39bb191940209400', 0, NULL, 2, 96),
	(233, '2020-06-13 22:38:56', '2020-06-13 22:39:00', NULL, 0.01, NULL, NULL, '4200000544202006137540695934', NULL, NULL, 'commonHandler', NULL, '2020061322385519727522', 1, NULL, NULL, NULL, NULL, NULL, 2, 96),
	(234, '2020-06-13 22:42:39', '2020-06-13 22:42:44', NULL, 0.01, NULL, 71, '4200000526202006133181330186', NULL, NULL, 'orderPayHandler', NULL, '2020061322423993963413', 1, NULL, NULL, 'wx13224239341846c2c919a7141122875500', 0, NULL, 2, 96),
	(235, '2020-06-13 22:43:13', '2020-06-13 22:43:19', NULL, 0.01, NULL, 72, '4200000535202006139023829814', NULL, NULL, 'orderPayHandler', NULL, '2020061322431346124026', 1, NULL, NULL, 'wx13224313360872504d08f6221266937700', 0, NULL, 2, 96),
	(236, '2020-06-13 22:44:01', '2020-06-13 22:44:01', NULL, 1.23, NULL, 68, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020061322440085336358', 0, NULL, NULL, 'wx132244005752894bf30276381542272100', 0, NULL, 2, 96),
	(237, '2020-06-13 22:44:08', '2020-06-13 22:44:08', NULL, 262.80, NULL, 63, NULL, NULL, NULL, 'orderPayHandler', NULL, '2020061322440836451964', 0, NULL, NULL, 'wx1322440824643137a48b6e941440867700', 0, NULL, 2, 96),
	(238, '2020-06-13 22:46:04', '2020-06-13 22:46:09', NULL, 0.01, NULL, 127, '4200000537202006133991565398', NULL, NULL, 'orderTradePayHandler', NULL, '2020061322460306260878', 1, NULL, NULL, 'wx1322460391354522ac29c1c61376307800', 0, NULL, 2, 96),
	(239, '2020-06-13 22:47:04', '2020-06-13 22:47:04', NULL, 48.00, NULL, 128, NULL, NULL, NULL, 'orderTradePayHandler', NULL, '2020061322470305487049', 0, NULL, NULL, 'wx13224704051802e9ba526b581739880600', 0, NULL, 2, 96);
/*!40000 ALTER TABLE `bs_tenant_pay_payment` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_plugin_config 结构
DROP TABLE IF EXISTS `bs_tenant_plugin_config`;
CREATE TABLE IF NOT EXISTS `bs_tenant_plugin_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `isEnabled` bit(1) NOT NULL,
  `pluginId` varchar(100) NOT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbi4s6nkissjspk4ql1160h5fh` (`tenant_id`),
  CONSTRAINT `FKbi4s6nkissjspk4ql1160h5fh` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_plugin_config 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_plugin_config`;
/*!40000 ALTER TABLE `bs_tenant_plugin_config` DISABLE KEYS */;
INSERT INTO `bs_tenant_plugin_config` (`id`, `addDate`, `lastDate`, `sortNum`, `isEnabled`, `pluginId`, `tenant_id`) VALUES
	(1, '2020-04-16 17:36:36', '2020-05-19 17:13:46', 1, b'1', 'weiAppPaymentPlugin', 2);
/*!40000 ALTER TABLE `bs_tenant_plugin_config` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_plugin_config_attribute 结构
DROP TABLE IF EXISTS `bs_tenant_plugin_config_attribute`;
CREATE TABLE IF NOT EXISTS `bs_tenant_plugin_config_attribute` (
  `plugin_id` bigint(20) NOT NULL,
  `attr` varchar(300) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`plugin_id`,`name`),
  CONSTRAINT `FK7mi5jmb5xuy2kbhudyx8pqfsg` FOREIGN KEY (`plugin_id`) REFERENCES `bs_tenant_plugin_config` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_plugin_config_attribute 的数据：~10 rows (大约)
DELETE FROM `bs_tenant_plugin_config_attribute`;
/*!40000 ALTER TABLE `bs_tenant_plugin_config_attribute` DISABLE KEYS */;
INSERT INTO `bs_tenant_plugin_config_attribute` (`plugin_id`, `attr`, `name`) VALUES
	(1, 'wx49dab0ea2b3293a9', 'appId'),
	(1, 'on', 'enabled'),
	(1, '01e16d1a116f418ba9eea143f85c305a', 'key'),
	(1, '1581993941', 'mch_id'),
	(1, 'https://cloud.demomall.cn/b2b/weixinnotifyurl.htm', 'notify_url'),
	(1, '1', 'order'),
	(1, 'Sign=WXPay', 'packageinfo'),
	(1, '', 'payType'),
	(1, '', 'subAppId'),
	(1, '', 'sub_mch_id');
/*!40000 ALTER TABLE `bs_tenant_plugin_config_attribute` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_product 结构
DROP TABLE IF EXISTS `bs_tenant_product`;
CREATE TABLE IF NOT EXISTS `bs_tenant_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `costPrice` decimal(19,2) DEFAULT NULL,
  `hasSku` bit(1) DEFAULT NULL,
  `inventory` int(11) DEFAULT NULL,
  `invoice` bit(1) DEFAULT NULL,
  `itemNumber` varchar(255) DEFAULT NULL,
  `marketPrice` decimal(19,2) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `salePrice` decimal(19,2) DEFAULT NULL,
  `sellState` bit(1) DEFAULT NULL,
  `shelfTime` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `storeProductCategory` tinyblob,
  `summary` varchar(255) DEFAULT NULL,
  `summaryColor` varchar(255) DEFAULT NULL,
  `volume` double DEFAULT NULL,
  `warningValue` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `attrName` varchar(255) DEFAULT NULL,
  `attrValue` varchar(255) DEFAULT NULL,
  `groupName` varchar(255) DEFAULT NULL,
  `proTypeAttrId` int(11) DEFAULT NULL,
  `productTypeAttr` tinyblob,
  `productTypeId` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `brand_id` bigint(20) DEFAULT NULL,
  `catalog_id` int(11) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `productType_id` bigint(20) DEFAULT NULL,
  `demo` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `storeState` int(11) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `label_id` bigint(20) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `vipPrice` decimal(19,2) DEFAULT NULL,
  `supplier_id` bigint(20) DEFAULT NULL,
  `barCode` varchar(255) DEFAULT NULL,
  `netWeight` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1kbhlbbab6s492trhbrr0020j` (`tenant_id`),
  KEY `FK63j0s3wdap4hxs0eupwy3tgdh` (`brand_id`),
  KEY `FK4y1pyaetcn87r2xj0aod06imf` (`catalog_id`),
  KEY `FKqd35ac57ybuptt7ma5k658k0v` (`store_id`),
  KEY `FK1t87ecrxukg2qdc27qagfwtf3` (`product_id`),
  KEY `FKgjadtiwmprja67tauf38r3t7d` (`productType_id`),
  KEY `FKn4c6acqvc2mf6fs6xulpbs4ai` (`label_id`),
  KEY `FKi4w1fe6bbqv50sas5shed3ibq` (`supplier_id`),
  CONSTRAINT `FK1kbhlbbab6s492trhbrr0020j` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FK1t87ecrxukg2qdc27qagfwtf3` FOREIGN KEY (`product_id`) REFERENCES `bs_tenant_product` (`id`),
  CONSTRAINT `FK4y1pyaetcn87r2xj0aod06imf` FOREIGN KEY (`catalog_id`) REFERENCES `bs_tenant_product_catalog` (`id`),
  CONSTRAINT `FK63j0s3wdap4hxs0eupwy3tgdh` FOREIGN KEY (`brand_id`) REFERENCES `bs_tenant_brand` (`id`),
  CONSTRAINT `FKgjadtiwmprja67tauf38r3t7d` FOREIGN KEY (`productType_id`) REFERENCES `bs_tenant_product_type` (`id`),
  CONSTRAINT `FKi4w1fe6bbqv50sas5shed3ibq` FOREIGN KEY (`supplier_id`) REFERENCES `bs_tenant_purchase_supplier` (`id`),
  CONSTRAINT `FKn4c6acqvc2mf6fs6xulpbs4ai` FOREIGN KEY (`label_id`) REFERENCES `bs_tenant_product_label` (`id`),
  CONSTRAINT `FKqd35ac57ybuptt7ma5k658k0v` FOREIGN KEY (`store_id`) REFERENCES `bs_tenant_store_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_product 的数据：~22 rows (大约)
DELETE FROM `bs_tenant_product`;
/*!40000 ALTER TABLE `bs_tenant_product` DISABLE KEYS */;
INSERT INTO `bs_tenant_product` (`id`, `addDate`, `lastDate`, `code`, `costPrice`, `hasSku`, `inventory`, `invoice`, `itemNumber`, `marketPrice`, `name`, `salePrice`, `sellState`, `shelfTime`, `status`, `storeProductCategory`, `summary`, `summaryColor`, `volume`, `warningValue`, `weight`, `attrName`, `attrValue`, `groupName`, `proTypeAttrId`, `productTypeAttr`, `productTypeId`, `tenant_id`, `brand_id`, `catalog_id`, `store_id`, `product_id`, `productType_id`, `demo`, `logo`, `sortNum`, `storeState`, `unit`, `state`, `label_id`, `note`, `vipPrice`, `supplier_id`, `barCode`, `netWeight`) VALUES
	(1, '2020-03-23 16:31:20', '2020-03-23 16:31:20', '1.1.10', NULL, NULL, NULL, NULL, '', NULL, '苹果', NULL, NULL, NULL, NULL, NULL, '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '2020-03-23 16:31:31', '2020-03-23 16:31:31', '1.1.2', NULL, NULL, NULL, NULL, '', NULL, '西红柿', NULL, NULL, NULL, NULL, NULL, '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3, '2020-03-23 16:31:47', '2020-03-23 16:31:47', '1.1.3', NULL, NULL, NULL, NULL, '', NULL, '香蕉', NULL, NULL, NULL, NULL, NULL, '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(5, '2020-05-07 20:25:56', '2020-06-02 15:46:33', '0', 100.10, NULL, NULL, NULL, NULL, 125.80, '八鱼食用油皇家小榨非转基因菜籽油 5L', 119.90, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 5, 4, NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/617fc65a-d112-4580-8d7c-c66fa2b0f20b.jpg', NULL, NULL, 'kg', 0, NULL, NULL, NULL, NULL, '5656', NULL),
	(6, '2020-05-08 22:55:48', '2020-06-02 15:49:03', NULL, 78.00, NULL, NULL, NULL, NULL, 92.00, '八鱼小榨浓香非转基因压榨菜籽油5L', 83.90, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 5, 4, NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/7f874f27-aac2-4a0f-b0e8-580ac011cf74.png', NULL, NULL, 'kg', 0, 2, NULL, NULL, NULL, '695466654', NULL),
	(7, '2020-05-21 16:07:01', '2020-06-03 11:07:19', NULL, 0.01, NULL, NULL, NULL, NULL, 0.01, '测试1', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 4, 5, NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/b2777b37-c77e-4b05-b9fc-db3ce43bb995.jpg', NULL, NULL, 'kg', 0, 1, NULL, NULL, 1, '1695466654', NULL),
	(8, '2020-05-21 16:08:54', '2020-06-02 15:50:15', NULL, 23.00, NULL, NULL, NULL, NULL, 32.00, '八鱼食用油非转基因压榨菜籽油 1.8L', 29.90, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 5, 4, NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/bb9510b2-7a69-473d-9a9a-ea7c95035ddd.jpg', NULL, NULL, 'kg', 0, 1, NULL, NULL, 1, '6954666542', NULL),
	(9, '2020-05-23 21:32:41', '2020-05-23 21:32:47', NULL, 1.00, NULL, NULL, NULL, NULL, 2.00, '5L食用油', 3.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3, 5, NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/2b63a8a3-c370-4269-aae4-7bc74d934624.jpg', NULL, NULL, '斤', 0, 2, NULL, NULL, 1, '', NULL),
	(10, '2020-05-23 21:33:28', '2020-06-02 15:48:46', NULL, 2.00, NULL, NULL, NULL, NULL, 3.00, '2L玉米油', 4.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3, 4, NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202005/14b34f9e-eb2c-4af2-a9e6-2a53a1ba8cbd.jpg', NULL, NULL, '', 2, NULL, NULL, NULL, 1, '1', NULL),
	(11, '2020-05-25 14:21:27', '2020-06-02 15:43:13', NULL, 50.00, NULL, NULL, NULL, NULL, 61.00, '八鱼食用油 非转基因飘香菜籽油5L', 58.90, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 5, 4, NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/cde88946-6343-462c-b26b-763fc99d13ef.jpg', NULL, NULL, 'kg', NULL, 1, NULL, NULL, 1, '', NULL),
	(12, '2020-05-25 14:22:14', '2020-06-02 15:42:01', NULL, 67.00, NULL, NULL, NULL, NULL, 77.00, '八鱼139度压榨菜籽油5L+400ML', 73.90, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 5, 4, NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/1b14d948-a7e9-445f-94f5-14a7861b5840.jpg', NULL, NULL, 'kg', 0, 1, NULL, NULL, 1, '', NULL),
	(13, '2020-05-25 14:23:05', '2020-06-02 15:41:59', NULL, 58.00, NULL, NULL, NULL, NULL, 62.00, '八鱼非转基因压榨纯正菜籽油5L', 61.90, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 5, 4, NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/8112ab03-9cf9-4726-b174-0610d0af7dd2.jpg', NULL, NULL, 'kg', 0, 1, NULL, NULL, NULL, '', NULL),
	(14, '2020-05-25 16:55:06', '2020-06-02 15:41:58', NULL, 69.00, NULL, NULL, NULL, NULL, 78.00, '八鱼食用油非转基因压榨一级菜籽油5L', 76.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 5, 4, NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/47b19b3c-f706-4910-ac34-dca414d51811.jpg', NULL, NULL, 'kg', 0, 1, NULL, NULL, 1, '', NULL),
	(15, '2020-05-25 16:55:32', '2020-06-02 15:41:57', NULL, 49.00, NULL, NULL, NULL, NULL, 59.00, '八鱼非转基因压榨臻香菜籽油5L', 56.90, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 5, 4, NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/bbadf4b2-dd89-480c-a030-a8f172e9ba3b.jpg', NULL, NULL, 'kg', 0, 1, NULL, NULL, NULL, '', NULL),
	(16, '2020-05-25 16:55:59', '2020-06-02 15:41:57', NULL, 79.00, NULL, NULL, NULL, NULL, 88.00, '八鱼食用油 非转基因 浓香小榨菜籽油5L', 85.90, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 4, NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/34a750e4-b2e6-4bd4-a184-a125e18a68fd.jpg', NULL, NULL, 'kg', 0, 1, NULL, NULL, NULL, '', NULL),
	(17, '2020-05-25 16:56:44', '2020-06-12 15:32:40', NULL, 76.00, NULL, NULL, NULL, NULL, 88.00, '八鱼陕派风味非转基因压榨菜籽油5L+500ML', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 5, 4, NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/2b9623fb-7f3f-4a4a-9b0b-a1d6c4f6adfd.jpg', NULL, NULL, 'kg', 0, 1, NULL, NULL, NULL, '', NULL),
	(18, '2020-05-25 16:57:27', '2020-06-02 15:41:55', NULL, 59.00, NULL, NULL, NULL, NULL, 70.00, '八鱼食用油特香压榨菜籽油5L', 65.90, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 5, 4, NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/52cd96b7-a9e1-4684-a3be-23e11ec0728d.jpg', NULL, NULL, 'kg', 0, 1, NULL, NULL, 1, '', NULL),
	(19, '2020-05-25 17:01:11', '2020-06-02 15:41:54', NULL, 48.00, NULL, NULL, NULL, NULL, 55.00, '八鱼食用油非转基因纯香菜籽油5L', 54.90, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 5, 4, NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/5e2c82c1-70f1-4889-9301-807fc2e7a634.jpg', NULL, NULL, 'kg', 0, 1, NULL, NULL, NULL, '', NULL),
	(20, '2020-05-28 11:05:13', '2020-06-03 11:07:06', NULL, 44.00, NULL, NULL, NULL, NULL, 49.00, '测试玉米油', 47.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 5, NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/36189559-19df-4bba-9275-06c8b0ea54dc.jpg', NULL, NULL, 'kg', NULL, NULL, NULL, NULL, NULL, '', NULL),
	(21, '2020-05-28 11:05:44', '2020-06-03 11:27:47', NULL, 55.00, NULL, NULL, NULL, NULL, 59.00, '测试花生油', 57.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, 6, NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/4beb18ad-05bc-4057-ac54-f9dfa5dc6a4b.jpg', NULL, NULL, 'kg', 0, NULL, NULL, NULL, NULL, '', NULL),
	(22, '2020-06-02 15:47:45', '2020-06-05 13:04:23', NULL, 16.00, NULL, NULL, NULL, NULL, 24.00, '八鱼139度压榨菜籽油1L', 0.01, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 5, 4, NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/c8dc206e-94fd-4b35-a4d9-7a94e4a0c5f5.jpg', NULL, NULL, 'kg', NULL, 1, NULL, NULL, NULL, '', NULL),
	(23, '2020-06-02 15:51:41', '2020-06-02 15:51:41', NULL, 14.00, NULL, NULL, NULL, NULL, 24.00, '八鱼食用油非转基因三级特香压榨菜籽油1L', 21.90, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 5, 4, NULL, NULL, NULL, NULL, 'http://file.metamall.cn/metamall/upload/image/202006/a8ba37c0-ceb4-41ed-9f02-6e00fbfad815.jpg', NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', NULL);
/*!40000 ALTER TABLE `bs_tenant_product` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_product_catalog 结构
DROP TABLE IF EXISTS `bs_tenant_product_catalog`;
CREATE TABLE IF NOT EXISTS `bs_tenant_product_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `bondPrice` decimal(19,2) DEFAULT NULL,
  `commissionRate` decimal(19,2) DEFAULT NULL,
  `consumerBondModTime` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `nameAlias` varchar(255) DEFAULT NULL,
  `productTypeId` int(11) DEFAULT NULL,
  `showState` bit(1) DEFAULT NULL,
  `templatePath` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `virtualState` bit(1) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `productType_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK62ixapv0rxe0f8evosbqwgti2` (`tenant_id`),
  KEY `FKtgblbo2sna0imfflqgsubx0sa` (`parent_id`),
  KEY `FKutfiwfrng04sfuimmmxs27da` (`productType_id`),
  CONSTRAINT `FK62ixapv0rxe0f8evosbqwgti2` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKtgblbo2sna0imfflqgsubx0sa` FOREIGN KEY (`parent_id`) REFERENCES `bs_tenant_product_catalog` (`id`),
  CONSTRAINT `FKutfiwfrng04sfuimmmxs27da` FOREIGN KEY (`productType_id`) REFERENCES `bs_tenant_product_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_product_catalog 的数据：~5 rows (大约)
DELETE FROM `bs_tenant_product_catalog`;
/*!40000 ALTER TABLE `bs_tenant_product_catalog` DISABLE KEYS */;
INSERT INTO `bs_tenant_product_catalog` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `bondPrice`, `commissionRate`, `consumerBondModTime`, `description`, `icon`, `keywords`, `nameAlias`, `productTypeId`, `showState`, `templatePath`, `title`, `virtualState`, `tenant_id`, `parent_id`, `productType_id`) VALUES
	(1, '2020-03-23 16:18:01', '', '1', '2020-03-23 16:18:01', 1, 1, '根节点', 12, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '2020-03-23 16:18:31', '1', '1,2', '2020-03-23 16:18:31', 2, 2, '食品饮料', 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, NULL),
	(3, '2020-03-23 16:23:39', '1', '1,2,3', '2020-03-23 16:23:39', 3, 3, '食用油', 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 2, NULL),
	(4, '2020-03-28 16:58:12', '1', '1,4', '2020-03-28 16:58:12', 2, 6, '菜籽油', 7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1, NULL),
	(5, '2020-03-28 16:58:17', '2', '1,5', '2020-03-28 16:58:17', 2, 8, '玉米油', 9, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1, NULL),
	(6, '2020-05-23 21:37:04', '3', '1,6', '2020-05-23 21:37:04', 2, 10, '花生油', 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1, NULL);
/*!40000 ALTER TABLE `bs_tenant_product_catalog` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_product_category 结构
DROP TABLE IF EXISTS `bs_tenant_product_category`;
CREATE TABLE IF NOT EXISTS `bs_tenant_product_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `bondPrice` decimal(19,2) DEFAULT NULL,
  `commissionRate` decimal(19,2) DEFAULT NULL,
  `consumerBondModTime` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `nameAlias` varchar(255) DEFAULT NULL,
  `productTypeId` int(11) DEFAULT NULL,
  `showState` bit(1) DEFAULT NULL,
  `templatePath` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `virtualState` bit(1) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `productType_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi3pqa9jlleimsd6fgon1px1g5` (`tenant_id`),
  KEY `FK2jrwm26p89nmfpmo23tg1dnbj` (`parent_id`),
  KEY `FKrw4tu1jxuxxn010qcpuuy33b3` (`productType_id`),
  CONSTRAINT `FK2jrwm26p89nmfpmo23tg1dnbj` FOREIGN KEY (`parent_id`) REFERENCES `bs_tenant_product_category` (`id`),
  CONSTRAINT `FKi3pqa9jlleimsd6fgon1px1g5` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKrw4tu1jxuxxn010qcpuuy33b3` FOREIGN KEY (`productType_id`) REFERENCES `bs_tenant_product_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_product_category 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_product_category`;
/*!40000 ALTER TABLE `bs_tenant_product_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_product_category` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_product_category_nav 结构
DROP TABLE IF EXISTS `bs_tenant_product_category_nav`;
CREATE TABLE IF NOT EXISTS `bs_tenant_product_category_nav` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `brandIds` varchar(255) DEFAULT NULL,
  `subCateIds` varchar(255) DEFAULT NULL,
  `topCateIds` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc89hrulj4i4x3h1clsgc8vj4q` (`tenant_id`),
  KEY `FK56p51rp7a40ijlxkhndoxg74p` (`category_id`),
  CONSTRAINT `FK56p51rp7a40ijlxkhndoxg74p` FOREIGN KEY (`category_id`) REFERENCES `bs_tenant_product_catalog` (`id`),
  CONSTRAINT `FKc89hrulj4i4x3h1clsgc8vj4q` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_product_category_nav 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_product_category_nav`;
/*!40000 ALTER TABLE `bs_tenant_product_category_nav` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_product_category_nav` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_product_category_statistics 结构
DROP TABLE IF EXISTS `bs_tenant_product_category_statistics`;
CREATE TABLE IF NOT EXISTS `bs_tenant_product_category_statistics` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `consignmentScore` float DEFAULT NULL,
  `productScore` float DEFAULT NULL,
  `serviceScore` float DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr918huytdxnwunjagicy26eas` (`tenant_id`),
  KEY `FKacn2cvf297ts1vn6tx6ca5xww` (`category_id`),
  CONSTRAINT `FKacn2cvf297ts1vn6tx6ca5xww` FOREIGN KEY (`category_id`) REFERENCES `bs_tenant_product_catalog` (`id`),
  CONSTRAINT `FKr918huytdxnwunjagicy26eas` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_product_category_statistics 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_product_category_statistics`;
/*!40000 ALTER TABLE `bs_tenant_product_category_statistics` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_product_category_statistics` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_product_compose 结构
DROP TABLE IF EXISTS `bs_tenant_product_compose`;
CREATE TABLE IF NOT EXISTS `bs_tenant_product_compose` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `composeType` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `composeProduct_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2bghgbw92fgedonfh5tauhfmd` (`tenant_id`),
  KEY `FKt2waihsf0wy60iepqluxbd8ho` (`composeProduct_id`),
  KEY `FKd5o8fspbs90hg9s08iabjvjd4` (`product_id`),
  CONSTRAINT `FK2bghgbw92fgedonfh5tauhfmd` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKd5o8fspbs90hg9s08iabjvjd4` FOREIGN KEY (`product_id`) REFERENCES `bs_tenant_product` (`id`),
  CONSTRAINT `FKt2waihsf0wy60iepqluxbd8ho` FOREIGN KEY (`composeProduct_id`) REFERENCES `bs_tenant_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_product_compose 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_product_compose`;
/*!40000 ALTER TABLE `bs_tenant_product_compose` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_product_compose` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_product_consultation 结构
DROP TABLE IF EXISTS `bs_tenant_product_consultation`;
CREATE TABLE IF NOT EXISTS `bs_tenant_product_consultation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKebwxm24gr3hnrtktkn7y25efa` (`tenant_id`),
  KEY `FK56xub9qbtkkfiwplfwfhgdntq` (`product_id`),
  CONSTRAINT `FK56xub9qbtkkfiwplfwfhgdntq` FOREIGN KEY (`product_id`) REFERENCES `bs_tenant_product` (`id`),
  CONSTRAINT `FKebwxm24gr3hnrtktkn7y25efa` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_product_consultation 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_product_consultation`;
/*!40000 ALTER TABLE `bs_tenant_product_consultation` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_product_consultation` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_product_label 结构
DROP TABLE IF EXISTS `bs_tenant_product_label`;
CREATE TABLE IF NOT EXISTS `bs_tenant_product_label` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `storeState` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp8ul51rmpmr7aq7py4697h8xq` (`tenant_id`),
  CONSTRAINT `FKp8ul51rmpmr7aq7py4697h8xq` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_product_label 的数据：~1 rows (大约)
DELETE FROM `bs_tenant_product_label`;
/*!40000 ALTER TABLE `bs_tenant_product_label` DISABLE KEYS */;
INSERT INTO `bs_tenant_product_label` (`id`, `addDate`, `lastDate`, `name`, `storeState`, `tenant_id`, `sortNum`) VALUES
	(1, '2020-05-04 14:50:05', '2020-05-04 14:50:05', '新品', NULL, 2, NULL),
	(2, '2020-05-08 22:58:41', '2020-05-08 22:58:41', '热门', NULL, 2, NULL);
/*!40000 ALTER TABLE `bs_tenant_product_label` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_product_sku 结构
DROP TABLE IF EXISTS `bs_tenant_product_sku`;
CREATE TABLE IF NOT EXISTS `bs_tenant_product_sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `costPrice` decimal(19,2) DEFAULT NULL,
  `inventory` int(11) DEFAULT NULL,
  `marketPrice` decimal(19,2) DEFAULT NULL,
  `saleAttrCode` varchar(255) DEFAULT NULL,
  `salesPrice` decimal(19,2) DEFAULT NULL,
  `skuNumber` varchar(255) DEFAULT NULL,
  `warning` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `salePrice` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbsox0tw2pij8njeraj13hs0gf` (`tenant_id`),
  KEY `FKciejb8kmn5uy64dqwqa4pf5gp` (`product_id`),
  CONSTRAINT `FKbsox0tw2pij8njeraj13hs0gf` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKciejb8kmn5uy64dqwqa4pf5gp` FOREIGN KEY (`product_id`) REFERENCES `bs_tenant_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_product_sku 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_product_sku`;
/*!40000 ALTER TABLE `bs_tenant_product_sku` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_product_sku` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_product_sku_attr 结构
DROP TABLE IF EXISTS `bs_tenant_product_sku_attr`;
CREATE TABLE IF NOT EXISTS `bs_tenant_product_sku_attr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `attrName` varchar(255) DEFAULT NULL,
  `attrValueCode` varchar(255) DEFAULT NULL,
  `attrValueName` varchar(255) DEFAULT NULL,
  `groupName` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `productType_id` bigint(20) DEFAULT NULL,
  `productTypeAttr_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK14tbh4pi76lii4y14wv11ib2` (`tenant_id`),
  KEY `FKox831lecle92u99s7f38vasbk` (`product_id`),
  KEY `FKeitrebe2pml8rbqetorih7rof` (`productType_id`),
  KEY `FKmt9rr10sfj879q9rhr0hin4en` (`productTypeAttr_id`),
  CONSTRAINT `FK14tbh4pi76lii4y14wv11ib2` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKeitrebe2pml8rbqetorih7rof` FOREIGN KEY (`productType_id`) REFERENCES `bs_tenant_product_type` (`id`),
  CONSTRAINT `FKmt9rr10sfj879q9rhr0hin4en` FOREIGN KEY (`productTypeAttr_id`) REFERENCES `bs_tenant_product_type` (`id`),
  CONSTRAINT `FKox831lecle92u99s7f38vasbk` FOREIGN KEY (`product_id`) REFERENCES `bs_tenant_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_product_sku_attr 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_product_sku_attr`;
/*!40000 ALTER TABLE `bs_tenant_product_sku_attr` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_product_sku_attr` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_product_spec 结构
DROP TABLE IF EXISTS `bs_tenant_product_spec`;
CREATE TABLE IF NOT EXISTS `bs_tenant_product_spec` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK73by3s606hmt2iarfxogh3ow5` (`tenant_id`),
  CONSTRAINT `FK73by3s606hmt2iarfxogh3ow5` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_product_spec 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_product_spec`;
/*!40000 ALTER TABLE `bs_tenant_product_spec` DISABLE KEYS */;
INSERT INTO `bs_tenant_product_spec` (`id`, `addDate`, `lastDate`, `name`, `sortNum`, `tenant_id`) VALUES
	(1, '2020-05-04 14:50:19', '2020-05-04 14:50:19', '容量', 1, 2);
/*!40000 ALTER TABLE `bs_tenant_product_spec` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_product_spec_value 结构
DROP TABLE IF EXISTS `bs_tenant_product_spec_value`;
CREATE TABLE IF NOT EXISTS `bs_tenant_product_spec_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `spec_id` bigint(20) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3xmcpwdavyp8p1kv18e1amsfv` (`tenant_id`),
  KEY `FKh6u1e2n2od8g4jvuvi23xct24` (`spec_id`),
  CONSTRAINT `FK3xmcpwdavyp8p1kv18e1amsfv` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKh6u1e2n2od8g4jvuvi23xct24` FOREIGN KEY (`spec_id`) REFERENCES `bs_tenant_product_spec` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_product_spec_value 的数据：~2 rows (大约)
DELETE FROM `bs_tenant_product_spec_value`;
/*!40000 ALTER TABLE `bs_tenant_product_spec_value` DISABLE KEYS */;
INSERT INTO `bs_tenant_product_spec_value` (`id`, `addDate`, `lastDate`, `image`, `name`, `tenant_id`, `spec_id`, `sortNum`) VALUES
	(1, '2020-05-04 14:50:26', '2020-05-04 14:50:26', NULL, '1L', NULL, 1, 1),
	(2, '2020-05-04 14:50:31', '2020-05-04 14:50:31', NULL, '2L', NULL, 1, 2),
	(3, '2020-05-04 14:50:36', '2020-05-04 14:50:36', NULL, '5L', NULL, 1, 3);
/*!40000 ALTER TABLE `bs_tenant_product_spec_value` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_product_tag 结构
DROP TABLE IF EXISTS `bs_tenant_product_tag`;
CREATE TABLE IF NOT EXISTS `bs_tenant_product_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKppnuuko0yf0xe4w81j80bs0jh` (`tenant_id`),
  CONSTRAINT `FKppnuuko0yf0xe4w81j80bs0jh` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_product_tag 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_product_tag`;
/*!40000 ALTER TABLE `bs_tenant_product_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_product_tag` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_product_tag_links 结构
DROP TABLE IF EXISTS `bs_tenant_product_tag_links`;
CREATE TABLE IF NOT EXISTS `bs_tenant_product_tag_links` (
  `product_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  PRIMARY KEY (`product_id`,`tag_id`),
  KEY `FKg3cvhd03ne1mhjrib04nlhiet` (`tag_id`),
  CONSTRAINT `FKg3cvhd03ne1mhjrib04nlhiet` FOREIGN KEY (`tag_id`) REFERENCES `bs_tenant_product_tag` (`id`),
  CONSTRAINT `FKth60whrtdnppidfq0b7qba5g7` FOREIGN KEY (`product_id`) REFERENCES `bs_tenant_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_product_tag_links 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_product_tag_links`;
/*!40000 ALTER TABLE `bs_tenant_product_tag_links` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_product_tag_links` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_product_type 结构
DROP TABLE IF EXISTS `bs_tenant_product_type`;
CREATE TABLE IF NOT EXISTS `bs_tenant_product_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `custom` bit(1) DEFAULT NULL,
  `groupName` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `attrGroupName` varchar(255) DEFAULT NULL,
  `attrType` smallint(6) DEFAULT NULL,
  `isSaleAttr` bit(1) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `required` bit(1) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt3kdhk8w02un503has3ieeoqc` (`tenant_id`),
  KEY `FK7twdledtg0say67p7lpfvv5jj` (`store_id`),
  KEY `FKsudtynxyrtuia3x5y2wutg8t1` (`type_id`),
  CONSTRAINT `FK7twdledtg0say67p7lpfvv5jj` FOREIGN KEY (`store_id`) REFERENCES `bs_tenant_store_info` (`id`),
  CONSTRAINT `FKsudtynxyrtuia3x5y2wutg8t1` FOREIGN KEY (`type_id`) REFERENCES `bs_tenant_product_type` (`id`),
  CONSTRAINT `FKt3kdhk8w02un503has3ieeoqc` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_product_type 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_product_type`;
/*!40000 ALTER TABLE `bs_tenant_product_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_product_type` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_product_type_value 结构
DROP TABLE IF EXISTS `bs_tenant_product_type_value`;
CREATE TABLE IF NOT EXISTS `bs_tenant_product_type_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `attrCode` varchar(255) DEFAULT NULL,
  `attrType` smallint(6) DEFAULT NULL,
  `attrValue` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `attr_id` bigint(20) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtqqjgyrlrsmgd8w7u1qqfldp7` (`tenant_id`),
  KEY `FKorahu06k9n7s85y3g4b9bs7wh` (`attr_id`),
  KEY `FKt48d405lp2wgvhrg3ra8ll8wc` (`store_id`),
  CONSTRAINT `FKorahu06k9n7s85y3g4b9bs7wh` FOREIGN KEY (`attr_id`) REFERENCES `bs_tenant_product_type` (`id`),
  CONSTRAINT `FKt48d405lp2wgvhrg3ra8ll8wc` FOREIGN KEY (`store_id`) REFERENCES `bs_tenant_store_info` (`id`),
  CONSTRAINT `FKtqqjgyrlrsmgd8w7u1qqfldp7` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_product_type_value 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_product_type_value`;
/*!40000 ALTER TABLE `bs_tenant_product_type_value` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_product_type_value` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_promote_coupon 结构
DROP TABLE IF EXISTS `bs_tenant_promote_coupon`;
CREATE TABLE IF NOT EXISTS `bs_tenant_promote_coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `couponScope` smallint(6) DEFAULT NULL,
  `couponType` int(11) DEFAULT NULL,
  `discountAmount` decimal(19,2) DEFAULT NULL,
  `expireType` smallint(6) DEFAULT NULL,
  `getMode` smallint(6) DEFAULT NULL,
  `getNum` smallint(6) DEFAULT NULL,
  `isPlatformCoupon` bit(1) DEFAULT NULL,
  `issueNum` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `orderAmount` decimal(19,2) DEFAULT NULL,
  `storeState` int(11) DEFAULT NULL,
  `useBeginTime` datetime DEFAULT NULL,
  `useDay` int(11) DEFAULT NULL,
  `useEndTime` datetime DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `promote_id` bigint(20) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg64uouvkep6tda6m0v3dkghj0` (`tenant_id`),
  KEY `FKss2t5tqf220fk0d1ekcl5bybf` (`user_id`),
  KEY `FKf3kq14n4890g3mtj34dkdjdwu` (`promote_id`),
  KEY `FKt04cv5bunl2sh2efygl9td8oc` (`store_id`),
  CONSTRAINT `FKf3kq14n4890g3mtj34dkdjdwu` FOREIGN KEY (`promote_id`) REFERENCES `bs_tenant_promote_info` (`id`),
  CONSTRAINT `FKg64uouvkep6tda6m0v3dkghj0` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKss2t5tqf220fk0d1ekcl5bybf` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`),
  CONSTRAINT `FKt04cv5bunl2sh2efygl9td8oc` FOREIGN KEY (`store_id`) REFERENCES `bs_tenant_store_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_promote_coupon 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_promote_coupon`;
/*!40000 ALTER TABLE `bs_tenant_promote_coupon` DISABLE KEYS */;
INSERT INTO `bs_tenant_promote_coupon` (`id`, `addDate`, `lastDate`, `couponScope`, `couponType`, `discountAmount`, `expireType`, `getMode`, `getNum`, `isPlatformCoupon`, `issueNum`, `name`, `orderAmount`, `storeState`, `useBeginTime`, `useDay`, `useEndTime`, `tenant_id`, `user_id`, `promote_id`, `store_id`) VALUES
	(1, '2020-03-23 20:59:18', '2020-03-23 20:59:18', NULL, NULL, 1.00, NULL, 0, 5, NULL, NULL, '满10送1', 10.00, 1, '2020-03-03 00:00:00', NULL, '2020-03-29 00:00:00', 1, NULL, NULL, NULL),
	(2, '2020-05-03 11:25:56', '2020-05-03 11:25:56', NULL, NULL, 1.00, NULL, 0, 2, NULL, NULL, '满10送1', 10.00, 1, '2020-05-23 00:00:00', NULL, '2020-05-31 00:00:00', 2, NULL, NULL, NULL);
/*!40000 ALTER TABLE `bs_tenant_promote_coupon` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_promote_coupon_scope 结构
DROP TABLE IF EXISTS `bs_tenant_promote_coupon_scope`;
CREATE TABLE IF NOT EXISTS `bs_tenant_promote_coupon_scope` (
  `coupon_id` bigint(20) NOT NULL,
  `category_id` int(11) NOT NULL,
  KEY `FKcqgp99ev9x7385n322x0qhxhw` (`coupon_id`),
  KEY `FKm2ha42pasfep9g4snqtrj8p6a` (`category_id`),
  CONSTRAINT `FKcqgp99ev9x7385n322x0qhxhw` FOREIGN KEY (`coupon_id`) REFERENCES `bs_tenant_promote_coupon` (`id`),
  CONSTRAINT `FKd9qu84jedxic7ddslbu0oob1d` FOREIGN KEY (`category_id`) REFERENCES `bs_tenant_product_category` (`id`),
  CONSTRAINT `FKm2ha42pasfep9g4snqtrj8p6a` FOREIGN KEY (`category_id`) REFERENCES `bs_tenant_product_catalog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_promote_coupon_scope 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_promote_coupon_scope`;
/*!40000 ALTER TABLE `bs_tenant_promote_coupon_scope` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_promote_coupon_scope` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_promote_exclude_product 结构
DROP TABLE IF EXISTS `bs_tenant_promote_exclude_product`;
CREATE TABLE IF NOT EXISTS `bs_tenant_promote_exclude_product` (
  `promote_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  KEY `FKmyb6xgjslypdhbkc6s310nay5` (`product_id`),
  KEY `FKhycahl0e830h1lpgqc2l8gl9q` (`promote_id`),
  CONSTRAINT `FKhycahl0e830h1lpgqc2l8gl9q` FOREIGN KEY (`promote_id`) REFERENCES `bs_tenant_promote_info` (`id`),
  CONSTRAINT `FKmyb6xgjslypdhbkc6s310nay5` FOREIGN KEY (`product_id`) REFERENCES `bs_tenant_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_promote_exclude_product 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_promote_exclude_product`;
/*!40000 ALTER TABLE `bs_tenant_promote_exclude_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_promote_exclude_product` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_promote_give_product 结构
DROP TABLE IF EXISTS `bs_tenant_promote_give_product`;
CREATE TABLE IF NOT EXISTS `bs_tenant_promote_give_product` (
  `promote_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  KEY `FKqkvdb9pttxa455jtk7bqa06w2` (`product_id`),
  KEY `FKipd7blj1snfj50c2a1lwsvbs` (`promote_id`),
  CONSTRAINT `FKipd7blj1snfj50c2a1lwsvbs` FOREIGN KEY (`promote_id`) REFERENCES `bs_tenant_promote_info` (`id`),
  CONSTRAINT `FKqkvdb9pttxa455jtk7bqa06w2` FOREIGN KEY (`product_id`) REFERENCES `bs_tenant_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_promote_give_product 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_promote_give_product`;
/*!40000 ALTER TABLE `bs_tenant_promote_give_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_promote_give_product` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_promote_info 结构
DROP TABLE IF EXISTS `bs_tenant_promote_info`;
CREATE TABLE IF NOT EXISTS `bs_tenant_promote_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `beginDate` datetime DEFAULT NULL,
  `conType` int(11) DEFAULT NULL,
  `discountAmount` int(11) DEFAULT NULL,
  `discountMode` int(11) DEFAULT NULL,
  `enableState` int(11) DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `orderAmount` int(11) DEFAULT NULL,
  `platformPromote` int(11) DEFAULT NULL,
  `productNum` int(11) DEFAULT NULL,
  `promoteScope` int(11) DEFAULT NULL,
  `promoteType` int(11) DEFAULT NULL,
  `storeState` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `mini` int(11) DEFAULT NULL,
  `step` int(11) DEFAULT NULL,
  `scale` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcstxg6mmii0ty85n1qybflghw` (`tenant_id`),
  CONSTRAINT `FKcstxg6mmii0ty85n1qybflghw` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_promote_info 的数据：~1 rows (大约)
DELETE FROM `bs_tenant_promote_info`;
/*!40000 ALTER TABLE `bs_tenant_promote_info` DISABLE KEYS */;
INSERT INTO `bs_tenant_promote_info` (`id`, `addDate`, `lastDate`, `beginDate`, `conType`, `discountAmount`, `discountMode`, `enableState`, `endDate`, `icon`, `name`, `note`, `orderAmount`, `platformPromote`, `productNum`, `promoteScope`, `promoteType`, `storeState`, `tenant_id`, `logo`, `mini`, `step`, `scale`) VALUES
	(1, '2020-06-03 11:28:17', '2020-06-03 11:28:17', '2020-04-13 00:00:00', NULL, NULL, NULL, NULL, '2020-07-30 00:00:00', NULL, '三月份订货会', '11', NULL, NULL, NULL, NULL, NULL, NULL, 2, 'http://file.metamall.cn/metamall/upload/image/202006/3e7ca269-b7ff-404f-865e-585114b1208c.jpg', 10, 10, 10.00);
/*!40000 ALTER TABLE `bs_tenant_promote_info` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_promote_product 结构
DROP TABLE IF EXISTS `bs_tenant_promote_product`;
CREATE TABLE IF NOT EXISTS `bs_tenant_promote_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `promote_id` bigint(20) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf76obrosjfskw5pi0a7fnvc9y` (`tenant_id`),
  KEY `FK6jternab8jgg6ktro57b5rxcg` (`product_id`),
  KEY `FKkcwpthqoqrfda3p9vqjv09y9s` (`promote_id`),
  CONSTRAINT `FK6jternab8jgg6ktro57b5rxcg` FOREIGN KEY (`product_id`) REFERENCES `bs_tenant_product` (`id`),
  CONSTRAINT `FKf76obrosjfskw5pi0a7fnvc9y` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKkcwpthqoqrfda3p9vqjv09y9s` FOREIGN KEY (`promote_id`) REFERENCES `bs_tenant_promote_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_promote_product 的数据：~6 rows (大约)
DELETE FROM `bs_tenant_promote_product`;
/*!40000 ALTER TABLE `bs_tenant_promote_product` DISABLE KEYS */;
INSERT INTO `bs_tenant_promote_product` (`id`, `addDate`, `lastDate`, `tenant_id`, `product_id`, `promote_id`, `price`) VALUES
	(1, '2020-05-11 20:20:17', '2020-05-19 18:13:15', 2, 6, 1, 0.01),
	(3, '2020-05-11 20:20:36', '2020-05-19 18:12:40', 2, 5, 1, 0.01),
	(4, '2020-05-21 16:07:24', '2020-05-21 16:07:34', 2, 7, 1, 0.01),
	(5, '2020-05-21 16:09:09', '2020-05-21 16:09:14', 2, 8, 1, 0.01),
	(6, '2020-05-28 14:29:53', '2020-05-28 17:53:14', 2, 19, 1, 48.00),
	(7, '2020-05-28 17:53:22', '2020-05-28 17:54:04', 2, 12, 1, 48.00);
/*!40000 ALTER TABLE `bs_tenant_promote_product` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_promote_scope_category 结构
DROP TABLE IF EXISTS `bs_tenant_promote_scope_category`;
CREATE TABLE IF NOT EXISTS `bs_tenant_promote_scope_category` (
  `promote_id` bigint(20) NOT NULL,
  `category_id` int(11) NOT NULL,
  KEY `FKqmrhdpr7529mfj6dc205ij1gg` (`promote_id`),
  KEY `FKepqhf1o7a3owjtjqdg8j4l852` (`category_id`),
  CONSTRAINT `FK8mvf9j8nfbnjjfrtnns7hj4ij` FOREIGN KEY (`category_id`) REFERENCES `bs_tenant_product_category` (`id`),
  CONSTRAINT `FKepqhf1o7a3owjtjqdg8j4l852` FOREIGN KEY (`category_id`) REFERENCES `bs_tenant_product_catalog` (`id`),
  CONSTRAINT `FKqmrhdpr7529mfj6dc205ij1gg` FOREIGN KEY (`promote_id`) REFERENCES `bs_tenant_promote_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_promote_scope_category 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_promote_scope_category`;
/*!40000 ALTER TABLE `bs_tenant_promote_scope_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_promote_scope_category` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_purchase_supplier 结构
DROP TABLE IF EXISTS `bs_tenant_purchase_supplier`;
CREATE TABLE IF NOT EXISTS `bs_tenant_purchase_supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lng` double DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `shop` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK17gnwv5s9igqahoj2e7y8snf3` (`tenant_id`),
  CONSTRAINT `FK17gnwv5s9igqahoj2e7y8snf3` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_purchase_supplier 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_purchase_supplier`;
/*!40000 ALTER TABLE `bs_tenant_purchase_supplier` DISABLE KEYS */;
INSERT INTO `bs_tenant_purchase_supplier` (`id`, `addDate`, `lastDate`, `address`, `lat`, `lng`, `name`, `note`, `phone`, `shop`, `tel`, `tenant_id`) VALUES
	(1, '2020-05-12 22:43:34', '2020-05-12 22:43:34', '', NULL, NULL, '八鱼', '', '', '', '', 2);
/*!40000 ALTER TABLE `bs_tenant_purchase_supplier` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_role 结构
DROP TABLE IF EXISTS `bs_tenant_role`;
CREATE TABLE IF NOT EXISTS `bs_tenant_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2xnbtyaupmh8kndgx7vwdtjd` (`tenant_id`),
  CONSTRAINT `FK2xnbtyaupmh8kndgx7vwdtjd` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_role 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_role`;
/*!40000 ALTER TABLE `bs_tenant_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_role` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_store_info 结构
DROP TABLE IF EXISTS `bs_tenant_store_info`;
CREATE TABLE IF NOT EXISTS `bs_tenant_store_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `auditOpinion` varchar(255) DEFAULT NULL,
  `auditResults` smallint(6) DEFAULT NULL,
  `contactMail` varchar(255) DEFAULT NULL,
  `contactMobile` varchar(255) DEFAULT NULL,
  `contactName` varchar(255) DEFAULT NULL,
  `domainName` varchar(255) DEFAULT NULL,
  `freePayStatus` smallint(6) DEFAULT NULL,
  `freePayType` int(11) DEFAULT NULL,
  `headImgId` int(11) DEFAULT NULL,
  `isProductAuditEnable` bit(1) DEFAULT NULL,
  `isWechatEnable` bit(1) DEFAULT NULL,
  `levelId` int(11) DEFAULT NULL,
  `logoId` int(11) DEFAULT NULL,
  `memberId` int(11) DEFAULT NULL,
  `saleCateBond` decimal(19,2) DEFAULT NULL,
  `saleCateId` int(11) DEFAULT NULL,
  `selfShop` bit(1) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `storeEntegerStatus` smallint(6) DEFAULT NULL,
  `storeName` varchar(255) DEFAULT NULL,
  `storeType` smallint(6) DEFAULT NULL,
  `storeUsername` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `productCategory_id` int(11) DEFAULT NULL,
  `productCatalog_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmssa9xqqgxwvk6mbu97e23fse` (`tenant_id`),
  KEY `FKsqs8te0knhdkto1opautc99gf` (`account_id`),
  KEY `FKbxwklc44gj3w1o254u5hdh17j` (`productCategory_id`),
  KEY `FKcdhkpgr1c61h58qnkr5y5ce5u` (`productCatalog_id`),
  CONSTRAINT `FKbxwklc44gj3w1o254u5hdh17j` FOREIGN KEY (`productCategory_id`) REFERENCES `bs_tenant_product_category` (`id`),
  CONSTRAINT `FKcdhkpgr1c61h58qnkr5y5ce5u` FOREIGN KEY (`productCatalog_id`) REFERENCES `bs_tenant_product_catalog` (`id`),
  CONSTRAINT `FKmssa9xqqgxwvk6mbu97e23fse` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKsqs8te0knhdkto1opautc99gf` FOREIGN KEY (`account_id`) REFERENCES `sys_trade_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_store_info 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_store_info`;
/*!40000 ALTER TABLE `bs_tenant_store_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_store_info` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_store_product_category 结构
DROP TABLE IF EXISTS `bs_tenant_store_product_category`;
CREATE TABLE IF NOT EXISTS `bs_tenant_store_product_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `showState` bit(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `topState` bit(1) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK50ir996fw98khsg3u5teumwqh` (`tenant_id`),
  KEY `FKld05khmhtq5v7galfabwhay89` (`parent_id`),
  KEY `FKbgej2g3bh7epngos47kdmx07s` (`store_id`),
  CONSTRAINT `FK50ir996fw98khsg3u5teumwqh` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKbgej2g3bh7epngos47kdmx07s` FOREIGN KEY (`store_id`) REFERENCES `bs_tenant_store_info` (`id`),
  CONSTRAINT `FKld05khmhtq5v7galfabwhay89` FOREIGN KEY (`parent_id`) REFERENCES `bs_tenant_store_product_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_store_product_category 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_store_product_category`;
/*!40000 ALTER TABLE `bs_tenant_store_product_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_store_product_category` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_transport_distribution_sheet 结构
DROP TABLE IF EXISTS `bs_tenant_transport_distribution_sheet`;
CREATE TABLE IF NOT EXISTS `bs_tenant_transport_distribution_sheet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `no` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcogatdd0rtrws971ldiy7lwqm` (`tenant_id`),
  CONSTRAINT `FKcogatdd0rtrws971ldiy7lwqm` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_transport_distribution_sheet 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_transport_distribution_sheet`;
/*!40000 ALTER TABLE `bs_tenant_transport_distribution_sheet` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_transport_distribution_sheet` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_transport_distribution_vehicle 结构
DROP TABLE IF EXISTS `bs_tenant_transport_distribution_vehicle`;
CREATE TABLE IF NOT EXISTS `bs_tenant_transport_distribution_vehicle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `bearing` decimal(19,2) DEFAULT NULL,
  `no` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `vehicleType` tinyblob,
  `tenant_id` bigint(20) DEFAULT NULL,
  `vehicleType_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcpk4wc5km2tjcvwjipuu4wew4` (`tenant_id`),
  KEY `FKge9s535d15ptm2vdpac2t467h` (`vehicleType_id`),
  CONSTRAINT `FKcpk4wc5km2tjcvwjipuu4wew4` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKge9s535d15ptm2vdpac2t467h` FOREIGN KEY (`vehicleType_id`) REFERENCES `bs_tenant_transport_vehicle_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_transport_distribution_vehicle 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_transport_distribution_vehicle`;
/*!40000 ALTER TABLE `bs_tenant_transport_distribution_vehicle` DISABLE KEYS */;
INSERT INTO `bs_tenant_transport_distribution_vehicle` (`id`, `addDate`, `lastDate`, `bearing`, `no`, `note`, `vehicleType`, `tenant_id`, `vehicleType_id`) VALUES
	(1, '2020-03-21 17:10:09', '2020-03-21 17:10:09', 100.00, '陕A563123', '查勘损失', NULL, 1, 1);
/*!40000 ALTER TABLE `bs_tenant_transport_distribution_vehicle` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_transport_driver 结构
DROP TABLE IF EXISTS `bs_tenant_transport_driver`;
CREATE TABLE IF NOT EXISTS `bs_tenant_transport_driver` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKji6f6wxrhf8qkw9gv7yuv1yjc` (`tenant_id`),
  CONSTRAINT `FKji6f6wxrhf8qkw9gv7yuv1yjc` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_transport_driver 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_transport_driver`;
/*!40000 ALTER TABLE `bs_tenant_transport_driver` DISABLE KEYS */;
INSERT INTO `bs_tenant_transport_driver` (`id`, `addDate`, `lastDate`, `level`, `name`, `note`, `phone`, `tenant_id`) VALUES
	(1, '2020-03-21 17:26:23', '2020-03-21 17:26:23', 'B照', '陈司机', '', '18229060103', 1);
/*!40000 ALTER TABLE `bs_tenant_transport_driver` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_transport_vehicle_type 结构
DROP TABLE IF EXISTS `bs_tenant_transport_vehicle_type`;
CREATE TABLE IF NOT EXISTS `bs_tenant_transport_vehicle_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `maxWeight` decimal(19,2) DEFAULT NULL,
  `minSend` decimal(19,2) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo9spno8juorly1xjjnx3tjccy` (`tenant_id`),
  CONSTRAINT `FKo9spno8juorly1xjjnx3tjccy` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_transport_vehicle_type 的数据：~2 rows (大约)
DELETE FROM `bs_tenant_transport_vehicle_type`;
/*!40000 ALTER TABLE `bs_tenant_transport_vehicle_type` DISABLE KEYS */;
INSERT INTO `bs_tenant_transport_vehicle_type` (`id`, `addDate`, `lastDate`, `icon`, `maxWeight`, `minSend`, `name`, `tenant_id`) VALUES
	(1, '2020-03-21 16:59:20', '2020-03-21 16:59:20', '', 5000.00, 1000.00, 'A', 1),
	(2, '2020-03-21 17:09:58', '2020-03-21 17:09:58', '', 5000.00, 1000.00, 'B', 1);
/*!40000 ALTER TABLE `bs_tenant_transport_vehicle_type` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_user 结构
DROP TABLE IF EXISTS `bs_tenant_user`;
CREATE TABLE IF NOT EXISTS `bs_tenant_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `loginSize` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `no` varchar(20) DEFAULT NULL,
  `storeState` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `userType` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lng` double DEFAULT NULL,
  `manager` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `shop` varchar(255) DEFAULT NULL,
  `level_id` bigint(20) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `addressId` bigint(20) DEFAULT NULL,
  `credit` decimal(19,2) DEFAULT NULL,
  `score_id` bigint(20) DEFAULT NULL,
  `permissionType` int(11) DEFAULT NULL,
  `fee_id` bigint(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `job` varchar(20) DEFAULT NULL,
  `dataType` int(11) DEFAULT NULL,
  `rebate_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo9q4kb8keeoo71fsewt4vmg3v` (`tenant_id`),
  KEY `FKkuv9jfrmhqop5vnyvs4krek8a` (`level_id`),
  KEY `FKkv13p1w7n9m69w54qp33gdg2m` (`org_id`),
  KEY `FK768u8k72tcoykwqdjk4q2kg32` (`account_id`),
  KEY `FKjnadp38iy8uvdttuqdl92vdtp` (`score_id`),
  KEY `FKk3lau071dyaac148eq4tio6xg` (`fee_id`),
  KEY `FK1i5jgi4ll3yr43a6sjyr2mv4a` (`rebate_id`),
  CONSTRAINT `FK1i5jgi4ll3yr43a6sjyr2mv4a` FOREIGN KEY (`rebate_id`) REFERENCES `sys_trade_account` (`id`),
  CONSTRAINT `FK70s1bens5369rdaqi9euk8a2u` FOREIGN KEY (`org_id`) REFERENCES `bs_tenant_org_info` (`id`),
  CONSTRAINT `FK768u8k72tcoykwqdjk4q2kg32` FOREIGN KEY (`account_id`) REFERENCES `sys_trade_account` (`id`),
  CONSTRAINT `FKjnadp38iy8uvdttuqdl92vdtp` FOREIGN KEY (`score_id`) REFERENCES `sys_trade_account` (`id`),
  CONSTRAINT `FKk3lau071dyaac148eq4tio6xg` FOREIGN KEY (`fee_id`) REFERENCES `sys_trade_account` (`id`),
  CONSTRAINT `FKkuv9jfrmhqop5vnyvs4krek8a` FOREIGN KEY (`level_id`) REFERENCES `bs_tenant_mall_customer_level` (`id`),
  CONSTRAINT `FKkv13p1w7n9m69w54qp33gdg2m` FOREIGN KEY (`org_id`) REFERENCES `bs_tenant_user_org` (`id`),
  CONSTRAINT `FKo9q4kb8keeoo71fsewt4vmg3v` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_user 的数据：~103 rows (大约)
DELETE FROM `bs_tenant_user`;
/*!40000 ALTER TABLE `bs_tenant_user` DISABLE KEYS */;
INSERT INTO `bs_tenant_user` (`id`, `addDate`, `lastDate`, `avatar`, `catalog`, `loginSize`, `name`, `phone`, `state`, `no`, `storeState`, `tenant_id`, `userType`, `address`, `lat`, `lng`, `manager`, `note`, `shop`, `level_id`, `org_id`, `account_id`, `addressId`, `credit`, `score_id`, `permissionType`, `fee_id`, `email`, `job`, `dataType`, `rebate_id`) VALUES
	(1, '2020-03-23 17:11:49', '2020-04-25 11:54:32', NULL, NULL, NULL, '贾魁', '18229060101', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '纽百特', NULL, NULL, 4, NULL, 100.00, 5, NULL, 9, NULL, NULL, NULL, NULL),
	(2, '2020-03-23 17:11:44', '2020-04-25 12:02:19', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, 17, NULL, 1.00, NULL, NULL, 10, NULL, NULL, NULL, NULL),
	(3, '2020-03-23 16:50:27', '2020-03-23 16:50:27', NULL, NULL, NULL, '陈联高', '18229060103', NULL, '陕A563123', NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(4, '2020-03-23 17:11:44', '2020-04-25 11:55:53', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, 13, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(5, '2020-03-23 17:11:44', '2020-04-25 11:55:42', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, 12, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(6, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(7, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(8, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(9, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(10, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(11, '2020-03-23 17:11:44', '2020-04-25 12:05:47', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 20, NULL, NULL, NULL, NULL),
	(12, '2020-03-23 17:11:44', '2020-04-25 12:01:43', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, 18, NULL, NULL, 16, NULL, NULL, NULL, NULL, NULL, NULL),
	(13, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(14, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(15, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(16, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(17, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(18, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(19, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(20, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(21, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(22, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(23, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(24, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(25, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(26, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(27, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(28, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(29, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(30, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(31, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(32, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(33, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(34, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(35, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(36, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(37, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(38, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(39, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(40, '2020-03-23 17:11:44', '2020-04-25 12:02:35', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 19, NULL, NULL, NULL, NULL),
	(41, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(42, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(43, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(44, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(45, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(46, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(47, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(48, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(49, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(50, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(51, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(52, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(53, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(54, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(55, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(56, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(57, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(58, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(59, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(60, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(61, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(62, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(63, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(64, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(65, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(66, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(67, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(68, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(69, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(70, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(71, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(72, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(73, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(74, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(75, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(76, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(77, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(78, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(79, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(80, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(81, '2020-03-23 17:11:44', '2020-04-25 11:59:05', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, 15, NULL, NULL, NULL, NULL, 1000, NULL),
	(82, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(83, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(84, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(85, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(86, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(87, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(88, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(89, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(90, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(91, '2020-03-23 17:11:44', '2020-04-22 10:24:12', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, 3, NULL, 12.00, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(92, '2020-03-23 17:11:44', '2020-04-25 11:56:36', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, 14, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(93, '2020-03-23 17:11:44', '2020-03-23 17:11:44', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1000, NULL),
	(94, '2020-03-23 17:11:44', '2020-04-25 11:54:55', NULL, NULL, NULL, '陈联高', '18229060103', NULL, NULL, NULL, 1, NULL, '', NULL, NULL, '', '', '可乐', NULL, NULL, 1, NULL, NULL, 11, NULL, 7, NULL, NULL, 1000, NULL),
	(96, '2020-04-27 18:19:17', '2020-06-11 10:50:00', NULL, NULL, 0, 'ada', '', NULL, 'ada', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 28, 38, NULL, 26, NULL, 25, '', '', 2000, 27),
	(97, '2020-04-28 19:38:02', '2020-04-28 19:38:14', NULL, NULL, 0, 'ada', '18229060103', NULL, '18229060103', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3, NULL, NULL, NULL, NULL, NULL, NULL, '735529126@qq.com', 'ceo', 1000, NULL),
	(98, '2020-05-03 11:20:53', '2020-05-03 11:21:55', NULL, NULL, 0, '陈', '18229060103', NULL, 'ada1', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2000, NULL),
	(99, '2020-06-04 17:44:32', '2020-06-04 17:44:32', NULL, NULL, 0, '哈哈', '13772412', NULL, 'adas', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, '八鱼', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2000, NULL),
	(100, '2020-06-04 17:45:39', '2020-06-04 17:45:39', NULL, NULL, 0, 'weq', 'qwe', NULL, 'qqq', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, 'qew', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2000, NULL),
	(101, '2020-06-04 17:46:42', '2020-06-04 17:46:42', NULL, NULL, 0, '12341', '3241234', NULL, '阿松大', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, '123412', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2000, NULL),
	(102, '2020-06-04 17:46:48', '2020-06-04 17:46:48', NULL, NULL, 0, '12341', '3241234', NULL, '22', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, '123412', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2000, NULL),
	(103, '2020-06-04 17:47:25', '2020-06-04 17:47:25', NULL, NULL, 0, '1234', '1234', NULL, 'r1', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, '1234', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2000, NULL),
	(104, '2020-06-06 22:33:24', '2020-06-06 22:33:24', NULL, NULL, 0, '', '', NULL, '2123', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2000, NULL);
/*!40000 ALTER TABLE `bs_tenant_user` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_user_department 结构
DROP TABLE IF EXISTS `bs_tenant_user_department`;
CREATE TABLE IF NOT EXISTS `bs_tenant_user_department` (
  `user_id` bigint(20) NOT NULL,
  `department_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`department_id`),
  KEY `FK8ts4fsyq5ptsgxg6r0wcjib3l` (`department_id`),
  CONSTRAINT `FK34j07hi99krar74dg2npn8if1` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`),
  CONSTRAINT `FK8ts4fsyq5ptsgxg6r0wcjib3l` FOREIGN KEY (`department_id`) REFERENCES `bs_tenant_org_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_user_department 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_user_department`;
/*!40000 ALTER TABLE `bs_tenant_user_department` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_user_department` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_user_lockout 结构
DROP TABLE IF EXISTS `bs_tenant_user_lockout`;
CREATE TABLE IF NOT EXISTS `bs_tenant_user_lockout` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `beginDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4oavj9sirqn8ehincbrwqli26` (`tenant_id`),
  KEY `FKjegcyuicmil8nvxdaeb14wq78` (`user_id`),
  CONSTRAINT `FK4oavj9sirqn8ehincbrwqli26` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKjegcyuicmil8nvxdaeb14wq78` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_user_lockout 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_user_lockout`;
/*!40000 ALTER TABLE `bs_tenant_user_lockout` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_user_lockout` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_user_login_log 结构
DROP TABLE IF EXISTS `bs_tenant_user_login_log`;
CREATE TABLE IF NOT EXISTS `bs_tenant_user_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `account` varchar(20) DEFAULT NULL,
  `client` varchar(20) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9k51wio99xajn8hx073dv83ky` (`user_id`),
  CONSTRAINT `FK9k51wio99xajn8hx073dv83ky` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_user_login_log 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_user_login_log`;
/*!40000 ALTER TABLE `bs_tenant_user_login_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_user_login_log` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_user_no 结构
DROP TABLE IF EXISTS `bs_tenant_user_no`;
CREATE TABLE IF NOT EXISTS `bs_tenant_user_no` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `bindType` int(11) DEFAULT NULL,
  `no` varchar(50) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5nrim5ajitxgd43g17nux4xb1` (`tenant_id`),
  KEY `FK37keiwek5hvq3hmwp4si6no13` (`user_id`),
  CONSTRAINT `FK37keiwek5hvq3hmwp4si6no13` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`),
  CONSTRAINT `FK5nrim5ajitxgd43g17nux4xb1` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_user_no 的数据：~7 rows (大约)
DELETE FROM `bs_tenant_user_no`;
/*!40000 ALTER TABLE `bs_tenant_user_no` DISABLE KEYS */;
INSERT INTO `bs_tenant_user_no` (`id`, `addDate`, `lastDate`, `bindType`, `no`, `tenant_id`, `user_id`) VALUES
	(1, '2020-04-27 18:19:17', '2020-04-27 18:19:17', 2, 'ada', 2, 96),
	(2, '2020-04-28 19:38:02', '2020-04-28 19:38:02', 2, '18229060103', 2, 97),
	(3, '2020-05-03 11:20:53', '2020-05-03 11:20:53', 2, 'ada1', 2, 98),
	(4, '2020-06-04 17:44:32', '2020-06-04 17:44:32', 2, 'adas', 2, 99),
	(5, '2020-06-04 17:45:39', '2020-06-04 17:45:39', 2, 'qqq', 2, 100),
	(6, '2020-06-04 17:46:42', '2020-06-04 17:46:42', 2, '阿松大', 2, 101),
	(7, '2020-06-04 17:46:48', '2020-06-04 17:46:48', 2, '22', 2, 102),
	(8, '2020-06-04 17:47:25', '2020-06-04 17:47:25', 2, 'r1', 2, 103),
	(9, '2020-06-06 22:33:24', '2020-06-06 22:33:24', 2, '2123', 2, 104);
/*!40000 ALTER TABLE `bs_tenant_user_no` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_user_oauth_token 结构
DROP TABLE IF EXISTS `bs_tenant_user_oauth_token`;
CREATE TABLE IF NOT EXISTS `bs_tenant_user_oauth_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `accessToken` varchar(255) DEFAULT NULL,
  `expiresIn` bigint(20) DEFAULT NULL,
  `loginSize` int(11) DEFAULT NULL,
  `refreshToken` varchar(255) DEFAULT NULL,
  `tokenType` varchar(255) DEFAULT NULL,
  `uid` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiubvp2e3vgh0stk9dophbh2wl` (`tenant_id`),
  KEY `FK43x1mbenpq69ih6p2u72bjlks` (`user_id`),
  CONSTRAINT `FK43x1mbenpq69ih6p2u72bjlks` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`),
  CONSTRAINT `FKiubvp2e3vgh0stk9dophbh2wl` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_user_oauth_token 的数据：~5 rows (大约)
DELETE FROM `bs_tenant_user_oauth_token`;
/*!40000 ALTER TABLE `bs_tenant_user_oauth_token` DISABLE KEYS */;
INSERT INTO `bs_tenant_user_oauth_token` (`id`, `addDate`, `lastDate`, `accessToken`, `expiresIn`, `loginSize`, `refreshToken`, `tokenType`, `uid`, `tenant_id`, `user_id`) VALUES
	(12, '2020-05-19 18:38:58', '2020-06-13 22:36:58', '6ILoeiMpOsFZ0myFjnk9HQ==', NULL, 68, '', 'wxapp', 'oBBsL49HfhsnhLsjkgoe_3nsn-MA', 2, 96),
	(13, '2020-05-19 19:02:18', '2020-06-12 17:16:01', 'tSE1VTrBdrifBtCNqrsnSA==', NULL, 796, '', 'wxapp', 'oBBsL4_8Auha4XpHPl0W_l7ZiTYs', 2, 96),
	(14, '2020-05-28 17:43:47', '2020-06-12 21:31:15', 'kEjtF9I+ZnOa3seSMTh6bw==', NULL, 9, '', 'wxapp', 'oBBsL40oUUgWMwFUSQilb1v_GwMY', 2, 96),
	(15, '2020-06-08 10:41:38', '2020-06-08 10:41:38', 'S9Ama4F7LsSaVFAAhJy14Q==', NULL, 0, '', 'wxapp', 'oBBsL48OrVKxqmvQ9U4p3IT2NPZY', 2, 96),
	(16, '2020-06-08 13:53:05', '2020-06-08 13:53:05', 'WblG3cvn/aAsylBXpYu2Og==', NULL, 0, '', 'wxapp', 'oBBsL4zYjfNS97DNK7hJJzqr2oqs', 2, 96),
	(17, '2020-06-08 15:47:57', '2020-06-08 15:47:57', 'Sl5mtYMHL9J78zUJP8EGPg==', NULL, 0, '', 'wxapp', 'oBBsL4_37cain1SUQ0PY3DIUmlV0', 2, 96),
	(18, '2020-06-10 14:31:23', '2020-06-10 15:30:51', '4jfxUQxj5D8gnYovqjjoQg==', NULL, 1, '', 'wxapp', 'oBBsL40fAfaz-BkzoXDpPw_ErGnw', 2, 96),
	(19, '2020-06-12 19:59:30', '2020-06-12 19:59:30', 'Yh51s3mUrq8KEhRJ2qBr+A==', NULL, 0, '', 'wxapp', 'oBBsL4y2uIjESVE_JufKn_kitzyM', 2, 96);
/*!40000 ALTER TABLE `bs_tenant_user_oauth_token` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_user_org 结构
DROP TABLE IF EXISTS `bs_tenant_user_org`;
CREATE TABLE IF NOT EXISTS `bs_tenant_user_org` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `num` bigint(20) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKku2noyei1y4hxeddl3tbsyug1` (`tenant_id`),
  KEY `FKif9r80kjkwwy637g5kgxpgwht` (`parent_id`),
  CONSTRAINT `FKif9r80kjkwwy637g5kgxpgwht` FOREIGN KEY (`parent_id`) REFERENCES `bs_tenant_user_org` (`id`),
  CONSTRAINT `FKku2noyei1y4hxeddl3tbsyug1` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_user_org 的数据：~3 rows (大约)
DELETE FROM `bs_tenant_user_org`;
/*!40000 ALTER TABLE `bs_tenant_user_org` DISABLE KEYS */;
INSERT INTO `bs_tenant_user_org` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `catalog`, `num`, `tenant_id`, `parent_id`) VALUES
	(1, '2020-03-23 16:49:32', '', '1', '2020-03-23 16:49:32', 1, 1, '根节点', 6, 0, NULL, NULL, NULL, NULL),
	(2, '2020-03-23 16:49:38', '1', '1,2', '2020-03-23 16:49:38', 2, 2, '财务部', 3, NULL, NULL, NULL, 1, 1),
	(3, '2020-03-23 16:49:43', '2', '1,3', '2020-03-23 16:49:43', 2, 4, '市场部', 5, NULL, NULL, NULL, 1, 1);
/*!40000 ALTER TABLE `bs_tenant_user_org` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_user_role 结构
DROP TABLE IF EXISTS `bs_tenant_user_role`;
CREATE TABLE IF NOT EXISTS `bs_tenant_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `alias` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `roleType` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `catalog_id` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi2ajki0ecjd22bb29ag1eogpf` (`tenant_id`),
  KEY `FK7p611d8t9vvtnn5lvnj15j5kk` (`catalog_id`),
  KEY `FK5nc762rbyvqfbn4qu41aagult` (`user_id`),
  CONSTRAINT `FK5nc762rbyvqfbn4qu41aagult` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`),
  CONSTRAINT `FK7p611d8t9vvtnn5lvnj15j5kk` FOREIGN KEY (`catalog_id`) REFERENCES `bs_tenant_user_role_catalog` (`id`),
  CONSTRAINT `FKi2ajki0ecjd22bb29ag1eogpf` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_user_role 的数据：~4 rows (大约)
DELETE FROM `bs_tenant_user_role`;
/*!40000 ALTER TABLE `bs_tenant_user_role` DISABLE KEYS */;
INSERT INTO `bs_tenant_user_role` (`id`, `addDate`, `lastDate`, `alias`, `description`, `name`, `roleType`, `tenant_id`, `catalog_id`, `sortNum`, `user_id`) VALUES
	(1, '2020-03-20 17:01:45', '2020-03-20 17:01:45', '', '', '财务', NULL, 1, NULL, NULL, NULL),
	(2, '2020-03-21 17:34:10', '2020-03-21 17:34:10', '', '', '库管', NULL, 1, NULL, NULL, NULL),
	(3, '2020-03-28 16:55:27', '2020-03-28 16:55:27', '', '', '老板', 1, 1, NULL, NULL, NULL),
	(4, '2020-03-28 16:55:51', '2020-03-28 16:55:51', '', '', '经销商助理', 0, 1, NULL, NULL, NULL),
	(5, '2020-05-17 21:00:03', '2020-05-17 21:00:03', '', '', '', NULL, 2, NULL, NULL, NULL);
/*!40000 ALTER TABLE `bs_tenant_user_role` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_user_role_authority 结构
DROP TABLE IF EXISTS `bs_tenant_user_role_authority`;
CREATE TABLE IF NOT EXISTS `bs_tenant_user_role_authority` (
  `role_id` bigint(20) NOT NULL,
  `permission` varchar(100) DEFAULT NULL,
  KEY `FK2ywwqf8vqof6xa3wodexblqdh` (`role_id`),
  CONSTRAINT `FK2ywwqf8vqof6xa3wodexblqdh` FOREIGN KEY (`role_id`) REFERENCES `bs_tenant_user_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_user_role_authority 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_user_role_authority`;
/*!40000 ALTER TABLE `bs_tenant_user_role_authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_user_role_authority` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_user_role_catalog 结构
DROP TABLE IF EXISTS `bs_tenant_user_role_catalog`;
CREATE TABLE IF NOT EXISTS `bs_tenant_user_role_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcn8gg95wpd73cfpikcgukl2xg` (`parent_id`),
  CONSTRAINT `FKcn8gg95wpd73cfpikcgukl2xg` FOREIGN KEY (`parent_id`) REFERENCES `bs_tenant_user_role_catalog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_user_role_catalog 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_user_role_catalog`;
/*!40000 ALTER TABLE `bs_tenant_user_role_catalog` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_user_role_catalog` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_user_role_links 结构
DROP TABLE IF EXISTS `bs_tenant_user_role_links`;
CREATE TABLE IF NOT EXISTS `bs_tenant_user_role_links` (
  `user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`roles_id`),
  KEY `FKfi9rpq04rkgsq64u72tr5w9j1` (`roles_id`),
  KEY `FKsh77fjgwrbdwvlhgddrfc7x5m` (`role_id`),
  CONSTRAINT `FK6ativw8oabqyxgutvi2obq01r` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`),
  CONSTRAINT `FKfi9rpq04rkgsq64u72tr5w9j1` FOREIGN KEY (`roles_id`) REFERENCES `bs_tenant_user_role` (`id`),
  CONSTRAINT `FKsh77fjgwrbdwvlhgddrfc7x5m` FOREIGN KEY (`role_id`) REFERENCES `bs_tenant_user_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_user_role_links 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_user_role_links`;
/*!40000 ALTER TABLE `bs_tenant_user_role_links` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_user_role_links` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_user_security 结构
DROP TABLE IF EXISTS `bs_tenant_user_security`;
CREATE TABLE IF NOT EXISTS `bs_tenant_user_security` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `checkSize` int(11) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  `securityType` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbj4u5rc9gyubwu86vvp1s2fnq` (`tenant_id`),
  KEY `FKbc9mausvaj6c8d1ewgyg7cx9l` (`user_id`),
  CONSTRAINT `FKbc9mausvaj6c8d1ewgyg7cx9l` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`),
  CONSTRAINT `FKbj4u5rc9gyubwu86vvp1s2fnq` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_user_security 的数据：~7 rows (大约)
DELETE FROM `bs_tenant_user_security`;
/*!40000 ALTER TABLE `bs_tenant_user_security` DISABLE KEYS */;
INSERT INTO `bs_tenant_user_security` (`id`, `addDate`, `lastDate`, `checkSize`, `password`, `salt`, `securityType`, `tenant_id`, `user_id`) VALUES
	(1, '2020-04-27 18:19:17', '2020-04-27 18:19:17', 0, '60c9ecb954780589bde1880f5f7c8958654e5bbc', '56b6999b8da0db0d', 0, 2, 96),
	(2, '2020-04-28 19:38:02', '2020-04-28 19:38:02', 0, 'ffc736033781cac99d24fad423691455a273a519', 'e46f0cf52153d2be', 0, 2, 97),
	(3, '2020-05-03 11:20:53', '2020-05-03 11:20:53', 0, '48bf642ff593b02cca5609d07350cdf1d35a7a6b', '629ac76fa9b4526b', 0, 2, 98),
	(4, '2020-06-04 17:44:32', '2020-06-04 17:44:32', 0, '73c036586c6911068797559bd2e55b31b1e4949a', 'c24eaef7b878bf40', 0, 2, 99),
	(5, '2020-06-04 17:45:39', '2020-06-04 17:45:39', 0, '60b54881d7bfbd195cecf487c1b7e9543758ad8d', '16fcfd1c986f302a', 0, 2, 100),
	(6, '2020-06-04 17:46:42', '2020-06-04 17:46:42', 0, 'f7fd412b10afa16e1b8ab835465ad35cc0b4e975', '43f3d6157f3792fb', 0, 2, 101),
	(7, '2020-06-04 17:46:48', '2020-06-04 17:46:48', 0, '9918a8904da2d825ab667ac3669d02de598499c8', 'f3491e7e747bf372', 0, 2, 102),
	(8, '2020-06-04 17:47:25', '2020-06-04 17:47:25', 0, '28ced1540b90c4d0460030ab988be6326f29092e', 'b61a6a15902ee362', 0, 2, 103),
	(9, '2020-06-06 22:33:24', '2020-06-06 22:33:24', 0, 'fe5d51a9904cec1c40ae0a8536a4ead1595670c0', '8f02599987653adb', 0, 2, 104);
/*!40000 ALTER TABLE `bs_tenant_user_security` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_user_tag_links 结构
DROP TABLE IF EXISTS `bs_tenant_user_tag_links`;
CREATE TABLE IF NOT EXISTS `bs_tenant_user_tag_links` (
  `user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`roles_id`),
  KEY `FKr8xc5w4835gqxrubj2sl31h6` (`roles_id`),
  CONSTRAINT `FKitfaynuwwfcekbmyj4709abqj` FOREIGN KEY (`user_id`) REFERENCES `bs_tenant_user` (`id`),
  CONSTRAINT `FKr8xc5w4835gqxrubj2sl31h6` FOREIGN KEY (`roles_id`) REFERENCES `bs_tenant_mall_customer_tag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_user_tag_links 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_user_tag_links`;
/*!40000 ALTER TABLE `bs_tenant_user_tag_links` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_user_tag_links` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_wms_warehouse 结构
DROP TABLE IF EXISTS `bs_tenant_wms_warehouse`;
CREATE TABLE IF NOT EXISTS `bs_tenant_wms_warehouse` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `catalog` tinyblob,
  `lat` float DEFAULT NULL,
  `lng` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrnyynuaiw2dm9ykce2swve0kd` (`tenant_id`),
  CONSTRAINT `FKrnyynuaiw2dm9ykce2swve0kd` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_wms_warehouse 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_wms_warehouse`;
/*!40000 ALTER TABLE `bs_tenant_wms_warehouse` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_wms_warehouse` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_wms_warehouse_bill 结构
DROP TABLE IF EXISTS `bs_tenant_wms_warehouse_bill`;
CREATE TABLE IF NOT EXISTS `bs_tenant_wms_warehouse_bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `billType` int(11) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjf5dgmij3e2pwso452yoih4d5` (`tenant_id`),
  CONSTRAINT `FKjf5dgmij3e2pwso452yoih4d5` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_wms_warehouse_bill 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_wms_warehouse_bill`;
/*!40000 ALTER TABLE `bs_tenant_wms_warehouse_bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_wms_warehouse_bill` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_wms_warehouse_bill_item 结构
DROP TABLE IF EXISTS `bs_tenant_wms_warehouse_bill_item`;
CREATE TABLE IF NOT EXISTS `bs_tenant_wms_warehouse_bill_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `bill_id` bigint(20) DEFAULT NULL,
  `good_id` bigint(20) DEFAULT NULL,
  `cost` decimal(19,2) DEFAULT NULL,
  `money` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkeu3dm6b2qrbndbqree5sqjxe` (`tenant_id`),
  KEY `FK7pg2rxwsdp8mjhup1la52rm1w` (`bill_id`),
  KEY `FKb793jgut80dgateno2c8hnbvx` (`good_id`),
  CONSTRAINT `FK7pg2rxwsdp8mjhup1la52rm1w` FOREIGN KEY (`bill_id`) REFERENCES `bs_tenant_wms_warehouse_bill` (`id`),
  CONSTRAINT `FKb793jgut80dgateno2c8hnbvx` FOREIGN KEY (`good_id`) REFERENCES `bs_tenant_wms_warehouse_good` (`id`),
  CONSTRAINT `FKkeu3dm6b2qrbndbqree5sqjxe` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_wms_warehouse_bill_item 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_wms_warehouse_bill_item`;
/*!40000 ALTER TABLE `bs_tenant_wms_warehouse_bill_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_wms_warehouse_bill_item` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_wms_warehouse_catalog 结构
DROP TABLE IF EXISTS `bs_tenant_wms_warehouse_catalog`;
CREATE TABLE IF NOT EXISTS `bs_tenant_wms_warehouse_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4xv7sxy70vdjnvgmvj062ny0o` (`tenant_id`),
  KEY `FKsg40j2jdap39kb9us61761sak` (`parent_id`),
  CONSTRAINT `FK4xv7sxy70vdjnvgmvj062ny0o` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKsg40j2jdap39kb9us61761sak` FOREIGN KEY (`parent_id`) REFERENCES `bs_tenant_wms_warehouse_catalog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_wms_warehouse_catalog 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_wms_warehouse_catalog`;
/*!40000 ALTER TABLE `bs_tenant_wms_warehouse_catalog` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_wms_warehouse_catalog` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_wms_warehouse_good 结构
DROP TABLE IF EXISTS `bs_tenant_wms_warehouse_good`;
CREATE TABLE IF NOT EXISTS `bs_tenant_wms_warehouse_good` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `code` varchar(30) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `pyHeader` varchar(20) DEFAULT NULL,
  `sn` varchar(30) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `money` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoemk6bb9pxse7u8dypbw82u7x` (`tenant_id`),
  CONSTRAINT `FKoemk6bb9pxse7u8dypbw82u7x` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_wms_warehouse_good 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_wms_warehouse_good`;
/*!40000 ALTER TABLE `bs_tenant_wms_warehouse_good` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_wms_warehouse_good` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_wms_warehouse_good_catalog 结构
DROP TABLE IF EXISTS `bs_tenant_wms_warehouse_good_catalog`;
CREATE TABLE IF NOT EXISTS `bs_tenant_wms_warehouse_good_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `storeState` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2ucyt2a437fp4krgl072ueald` (`tenant_id`),
  KEY `FK3l5d55injmfqtuif6t0q02ayp` (`parent_id`),
  CONSTRAINT `FK2ucyt2a437fp4krgl072ueald` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FK3l5d55injmfqtuif6t0q02ayp` FOREIGN KEY (`parent_id`) REFERENCES `bs_tenant_wms_warehouse_good_catalog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_wms_warehouse_good_catalog 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_wms_warehouse_good_catalog`;
/*!40000 ALTER TABLE `bs_tenant_wms_warehouse_good_catalog` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_wms_warehouse_good_catalog` ENABLE KEYS */;

-- 导出  表 b2bcloud.bs_tenant_wms_warehouse_item 结构
DROP TABLE IF EXISTS `bs_tenant_wms_warehouse_item`;
CREATE TABLE IF NOT EXISTS `bs_tenant_wms_warehouse_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `good_id` bigint(20) DEFAULT NULL,
  `warehouse_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkdoq1424hqek3862c0oriog87` (`tenant_id`),
  KEY `FKdl4q9kk4w42kvhvo6uqm5lo8h` (`good_id`),
  KEY `FK1xmso21et9py8kj75pjpqhpn8` (`warehouse_id`),
  CONSTRAINT `FK1xmso21et9py8kj75pjpqhpn8` FOREIGN KEY (`warehouse_id`) REFERENCES `bs_tenant_wms_warehouse` (`id`),
  CONSTRAINT `FKdl4q9kk4w42kvhvo6uqm5lo8h` FOREIGN KEY (`good_id`) REFERENCES `bs_tenant_wms_warehouse_good` (`id`),
  CONSTRAINT `FKkdoq1424hqek3862c0oriog87` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.bs_tenant_wms_warehouse_item 的数据：~0 rows (大约)
DELETE FROM `bs_tenant_wms_warehouse_item`;
/*!40000 ALTER TABLE `bs_tenant_wms_warehouse_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `bs_tenant_wms_warehouse_item` ENABLE KEYS */;

-- 导出  表 b2bcloud.config_data_version 结构
DROP TABLE IF EXISTS `config_data_version`;
CREATE TABLE IF NOT EXISTS `config_data_version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `sequence` varchar(255) DEFAULT NULL,
  `step` int(11) DEFAULT NULL,
  `versionnum` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_f8c3y9hevq9jmdrb1wjyyqut` (`versionnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.config_data_version 的数据：~0 rows (大约)
DELETE FROM `config_data_version`;
/*!40000 ALTER TABLE `config_data_version` DISABLE KEYS */;
/*!40000 ALTER TABLE `config_data_version` ENABLE KEYS */;

-- 导出  表 b2bcloud.CustomerAccount 结构
DROP TABLE IF EXISTS `CustomerAccount`;
CREATE TABLE IF NOT EXISTS `CustomerAccount` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `manager` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `shop` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `level_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiym1g3gwthi8ibufene3u39td` (`tenant_id`),
  KEY `FKcsh80utql7v98xejx9bc5euh9` (`account_id`),
  KEY `FKpbvmgrbjrkxxm3xl10fy9pofp` (`level_id`),
  CONSTRAINT `FKcsh80utql7v98xejx9bc5euh9` FOREIGN KEY (`account_id`) REFERENCES `sys_trade_account` (`id`),
  CONSTRAINT `FKiym1g3gwthi8ibufene3u39td` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKpbvmgrbjrkxxm3xl10fy9pofp` FOREIGN KEY (`level_id`) REFERENCES `bs_tenant_mall_customer_level` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.CustomerAccount 的数据：~0 rows (大约)
DELETE FROM `CustomerAccount`;
/*!40000 ALTER TABLE `CustomerAccount` DISABLE KEYS */;
/*!40000 ALTER TABLE `CustomerAccount` ENABLE KEYS */;

-- 导出  表 b2bcloud.flow_define 结构
DROP TABLE IF EXISTS `flow_define`;
CREATE TABLE IF NOT EXISTS `flow_define` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.flow_define 的数据：0 rows
DELETE FROM `flow_define`;
/*!40000 ALTER TABLE `flow_define` DISABLE KEYS */;
/*!40000 ALTER TABLE `flow_define` ENABLE KEYS */;

-- 导出  表 b2bcloud.menu 结构
DROP TABLE IF EXISTS `menu`;
CREATE TABLE IF NOT EXISTS `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `nums` bigint(20) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqcf9gem97gqa5qjm4d3elcqt5` (`pid`)
) ENGINE=MyISAM AUTO_INCREMENT=132 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.menu 的数据：116 rows
DELETE FROM `menu`;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `catalog`, `icon`, `nums`, `path`, `permission`, `pid`) VALUES
	(1, '2017-09-25 14:25:39', '', '1', '2017-09-25 14:25:39', 1, 1, '根节点', 232, 0, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '2018-08-21 21:48:58', NULL, '1,2', '2018-08-21 21:48:58', 2, 2, '系统设置', 27, 55, 0, 'fa  fa-gear', 0, '', '2', 1),
	(3, '2017-09-25 14:34:37', NULL, '1,2,3', '2017-09-25 14:34:37', 3, 3, '菜单管理', 4, 0, 0, 'fa  fa-reorder', 0, 'admin/menu/view_list.htm', 'menu', 2),
	(4, '2017-09-25 14:36:59', NULL, '1,2,4', '2017-09-25 14:36:59', 3, 5, '角色管理', 6, 0, 0, 'fa  fa-tree', 0, 'admin/userrole/view_list.htm', 'userrole', 2),
	(5, '2020-05-19 17:24:23', NULL, '1,2,5', '2020-05-19 17:24:23', 3, 7, '第三方登陆配置', 8, 0, 0, 'fa  fa-connectdevelop', 0, 'tenant/tenantoauthconfig/view_list.htm', 'tenantoauthconfig', 2),
	(6, '2017-09-25 14:35:30', NULL, '1,2,6', '2017-09-25 14:35:30', 3, 9, '友情链接分类管理', 10, 0, 0, 'fa  fa-link', 0, 'admin/linktype/view_list.htm', 'linktype', 2),
	(7, '2017-09-25 14:37:37', NULL, '1,2,7', '2017-09-25 14:37:37', 3, 11, '友情链接管理', 12, 0, 0, 'fa  fa-link', 0, 'admin/link/view_list.htm', 'link', 2),
	(8, '2017-09-25 14:48:04', NULL, '1,2,8', '2017-09-25 14:48:04', 3, 13, '角色分类配置', 14, 0, 0, 'fa  fa-user-secret', 0, 'admin/userrolecatalog/view_list.htm', 'userrolecatalog', 2),
	(9, '2019-03-12 10:37:42', NULL, '1,2,9', '2019-03-12 10:37:42', 3, 15, '移动app配置', 16, 0, 0, 'fa  fa-life-ring', 0, 'admin/app/view_list.htm', 'appversion', 2),
	(10, '2017-09-25 15:22:17', NULL, '1,2,10', '2017-09-25 15:22:17', 3, 17, '网站主题配置', 18, 0, 0, 'fa  fa-sitemap', 0, 'admin/theme.htm', '10', 2),
	(11, '2018-12-01 10:25:00', NULL, '1,2,11', '2018-12-01 10:25:00', 3, 19, '模板管理', 20, 0, 0, 'fa fa-circle-o', 0, 'admin/tmpl/view_list.htm', 'tmpl', 2),
	(12, '2018-07-16 15:09:53', NULL, '1,12', '2018-07-16 15:09:53', 2, 28, '流程管理', 33, 3, 0, 'fa  fa-archive', 0, '', '12', 1),
	(13, '2017-10-26 14:51:49', NULL, '1,12,13', '2017-10-26 14:51:49', 3, 29, '工作流管理', 30, NULL, 0, 'fa fa-circle-o', NULL, 'admin/flow/view_list.htm', 'flow', 12),
	(14, '2017-10-26 15:42:26', NULL, '1,12,14', '2017-10-26 15:42:26', 3, 31, '模型管理', 32, NULL, 0, 'fa fa-circle-o', NULL, 'admin/act/view_list.htm', 'act', 12),
	(15, '2017-12-27 14:04:35', NULL, '1,15', '2017-12-27 14:04:35', 2, 34, '服务插件管理', 49, 4, 0, 'fa  fa-cloud', 0, '', '15', 1),
	(16, '2018-07-10 21:57:50', NULL, '1,15,16', '2018-07-10 21:57:50', 3, 35, '验证码插件配置', 36, 0, 0, 'fa  fa-commenting-o', 0, 'admin/plugin_sendcode/list.htm', 'plugin_sendcode', 15),
	(17, '2018-07-10 21:58:05', NULL, '1,15,17', '2018-07-10 21:58:05', 3, 37, '存储插件配置', 38, 0, 0, 'fa  fa-cloud-upload', 0, 'admin/plugin_storage/list.htm', 'plugin_storage', 15),
	(18, '2018-07-10 21:57:36', NULL, '1,15,18', '2018-07-10 21:57:36', 3, 39, '推送插件配置', 40, 0, 0, 'fa fa-circle-o', 0, 'admin/plugin_push/list.htm', 'plugin_push', 15),
	(19, '2017-12-27 14:04:52', NULL, '1,19', '2017-12-27 14:04:52', 2, 50, '控制台', 51, 1, 0, 'fa fa-home', 0, 'admin/index.htm', '19', 1),
	(21, '2017-12-27 14:27:31', NULL, '1,20,21', '2017-12-27 14:27:31', 3, 51, '用户管理', 52, 0, 0, 'fa fa-user', 0, 'admin/member/view_list.htm', 'member', 20),
	(22, '2019-09-12 16:09:33', NULL, '1,20,22', '2019-09-12 16:09:33', 3, 53, '账号管理', 54, 0, 0, 'fa fa-list', 0, 'admin/member/accounts.htm', 'accounts', 20),
	(23, '2017-12-27 15:05:28', NULL, '1,20,23', '2017-12-27 15:05:28', 3, 55, '登陆日志', 56, 0, 0, 'fa fa-support', 0, 'admin/userloginlog/view_list.htm', 'userloginlog', 20),
	(24, '2018-12-17 22:04:25', NULL, '1,15,24', '2018-12-17 22:04:25', 3, 41, '支付插件管理', 42, 0, 0, 'fa fa-circle-o', 0, '', '24', 15),
	(25, '2018-12-17 22:04:32', NULL, '1,15,25', '2018-12-17 22:04:32', 3, 43, '第三方登陆插件配置', 44, 0, 0, 'fa fa-circle-o', 0, 'admin/plugin_oauth/list.htm', 'plugin_oauth', 15),
	(26, '2018-12-17 22:04:29', NULL, '1,15,26', '2018-12-17 22:04:29', 3, 45, '邮件插件配置', 46, 0, 0, 'fa fa-circle-o', 0, '', '26', 15),
	(29, '2018-07-10 21:28:12', NULL, '1,28,29', '2018-07-10 21:28:12', 3, 57, ' Bucket管理 ', 58, NULL, 0, 'fa fa-circle-o', NULL, '', '', 28),
	(30, '2018-07-10 21:29:17', NULL, '1,28,30', '2018-07-10 21:29:17', 3, 59, '统计分析', 60, NULL, 0, 'fa fa-circle-o', NULL, '', '', 28),
	(32, '2018-07-10 21:31:03', NULL, '1,31,32', '2018-07-10 21:31:03', 3, 61, '积分明细', 62, NULL, 0, 'fa fa-circle-o', NULL, '', '', 31),
	(33, '2018-07-10 21:31:09', NULL, '1,31,33', '2018-07-10 21:31:09', 3, 63, '积分规则管理', 64, NULL, 0, 'fa fa-circle-o', NULL, '', '', 31),
	(34, '2018-07-16 15:02:29', NULL, '1,34', '2018-07-16 15:02:29', 2, 66, '定时任务管理', 73, 5, 0, 'fa  fa-calendar-plus-o', 0, '', '34', 1),
	(35, '2018-07-16 14:57:01', NULL, '1,34,35', '2018-07-16 14:57:01', 3, 67, '控制台', 68, 0, 0, 'fa fa-dashboard', 0, 'admin/crontask/index.htm', '35', 34),
	(36, '2018-07-16 14:57:20', NULL, '1,34,36', '2018-07-16 14:57:20', 3, 69, '任务管理', 70, 0, 0, 'fa   fa-list-ol', 0, 'admin/crontask/view_list.htm', 'crontask', 34),
	(37, '2018-07-16 14:56:48', NULL, '1,34,37', '2018-07-16 14:56:48', 3, 71, '运行记录', 72, 0, 0, 'fa fa-reorder', 0, 'admin/crontaskrecord/view_list.htm', 'crontaskrecord', 34),
	(38, '2018-07-16 14:58:54', NULL, '1,38', '2018-07-16 14:58:54', 2, 74, '消息通知', 81, 5, 0, 'fa  fa-comments', 0, '', '38', 1),
	(39, '2018-12-07 08:56:04', NULL, '1,38,39', '2018-12-07 08:56:04', 3, 75, '收件箱', 76, 0, 0, 'fa fa-circle-o', 0, 'admin/usernotificationmember/view_list.htm', 'usernotificationmember', 38),
	(40, '2018-07-16 15:00:19', NULL, '1,38,40', '2018-07-16 15:00:19', 3, 77, '通知分类', 78, NULL, 0, 'fa fa-circle-o', NULL, 'admin/usernotificationcatalog/view_list.htm', 'usernotificationcatalog', 38),
	(42, '2018-07-16 15:07:53', NULL, '1,41,42', '2018-07-16 15:07:53', 3, 81, '地区管理', 82, 0, 0, 'fa  fa-building-o', 0, 'admin/area/view_list.htm', 'area', 41),
	(43, '2018-12-01 11:07:37', NULL, '1,2,43', '2018-12-01 11:07:37', 3, 21, '个人资料管理', 22, -1, 0, 'glyphicon glyphicon-user', 0, 'admin/member/basic.htm', 'member_basic', 2),
	(44, '2018-12-07 08:57:37', NULL, '1,38,44', '2018-12-07 08:57:37', 3, 79, '通知管理', 80, 3, 0, 'fa fa-circle-o', NULL, 'admin/usernotification/view_list.htm', 'usernotification', 38),
	(45, '2018-12-17 22:04:21', NULL, '1,15,45', '2018-12-17 22:04:21', 3, 47, '服务管理', 48, -1, 0, 'fa fa-circle-o', NULL, 'admin/plugin_proxy/list.htm', 'plugin_proxy', 15),
	(47, '2019-09-11 19:15:40', NULL, '1,2,47', '2019-09-11 19:15:40', 3, 23, '数据字典管理', 24, 0, 0, 'fa  fa-square', 0, 'admin/dictionary/view_list.htm', 'dictionary', 2),
	(48, '2019-09-11 19:14:28', NULL, '1,2,48', '2019-09-11 19:14:28', 3, 25, '系统配置', 26, -1, 0, 'fa  fa-cogs', 0, 'admin/config.htm', 'system_config', 2),
	(49, '2019-09-12 16:43:16', NULL, '1,49', '2019-09-12 16:43:16', 2, 84, '云服务', 87, 6, 0, 'fa  fa-cloud', 0, '', '49', 1),
	(50, '2019-09-12 16:43:04', NULL, '1,49,50', '2019-09-12 16:43:04', 3, 85, '云函数', 86, 0, 0, 'fa  fa-code', 0, 'admin/function/view_list.htm', 'function', 49),
	(52, '2019-09-17 20:49:56', NULL, '1,51,52', '2019-09-17 20:49:56', 3, 87, '广告位管理', 88, 0, 0, 'fa  fa-minus-square', 0, 'admin/adposition/view_list.htm', 'adposition', 51),
	(53, '2019-09-17 20:50:11', NULL, '1,51,53', '2019-09-17 20:50:11', 3, 89, '广告管理', 90, 0, 0, 'fa fa-life-buoy', 0, 'admin/ad/view_list.htm', 'ad', 51),
	(54, '2020-03-28 17:08:55', NULL, '1,54', '2020-03-28 17:08:55', 2, 92, '租户中心', 97, 7, 0, 'fa  fa-user-secret', 0, '', '54', 1),
	(55, '2019-11-05 11:21:14', NULL, '1,54,55', '2019-11-05 11:21:14', 3, 93, '租户类型', 94, 0, 0, 'fa fa-circle-o', 0, 'admin/tenantcatalog/view_list.htm', 'tenantcatalog', 54),
	(56, '2019-11-05 11:23:33', NULL, '1,54,56', '2019-11-05 11:23:33', 3, 95, '租户管理', 96, 0, 0, 'fa fa-circle-o', 0, 'admin/tenant/view_list.htm', 'tenant', 54),
	(58, '2019-11-05 18:23:10', NULL, '1,57,58', '2019-11-05 18:23:10', 3, 97, '品牌分类', 98, 0, 0, 'fa  fa-tree', 0, 'admin/brandcatalog/view_list.htm', 'brandcatalog', 57),
	(59, '2019-11-05 18:22:59', NULL, '1,57,59', '2019-11-05 18:22:59', 3, 99, '品牌管理', 100, 0, 0, 'fa  fa-delicious', 0, 'admin/brand/view_list.htm', 'brand', 57),
	(60, '2019-11-05 18:41:19', NULL, '1,57,60', '2019-11-05 18:41:19', 3, 101, '门店管理', 102, 0, 0, 'fa fa-circle-o', 0, 'admin/brandstore/view_list.htm', 'brandstore', 57),
	(61, '2020-01-13 12:45:32', NULL, '1,61', '2020-01-13 12:45:32', 2, 104, '订单中心', 115, 8, 0, 'fa  fa-chevron-circle-down ', 0, '', '61', 1),
	(62, '2020-03-18 14:19:13', NULL, '1,61,62', '2020-03-18 14:19:13', 3, 105, '订货单', 106, 2, 0, 'fa fa-circle-o', 0, 'tenant/orderdata/view_list.htm', 'orderdata', 61),
	(64, '2019-11-06 19:46:10', NULL, '1,63,64', '2019-11-06 19:46:10', 3, 115, '场馆管理', 116, 0, 0, 'fa fa-shopping-cart', 0, 'admin/venue/view_list.htm', 'venue', 63),
	(65, '2019-11-06 19:46:24', NULL, '1,63,65', '2019-11-06 19:46:24', 3, 117, '场馆分类', 118, 0, 0, 'fa  fa-bars', 0, 'admin/venuecatalog/view_list.htm', 'venuecatalog', 63),
	(67, '2019-11-06 18:55:48', NULL, '1,66,67', '2019-11-06 18:55:48', 3, 119, '活动分类', 120, 0, 0, 'fa fa-circle-o', 0, 'admin/activitycatalog/view_list.htm', 'activitycatalog', 66),
	(68, '2019-11-06 18:55:35', NULL, '1,66,68', '2019-11-06 18:55:35', 3, 121, '活动管理', 122, 0, 0, 'fa fa-circle-o', 0, 'admin/activity/view_list.htm', 'activity', 66),
	(69, '2019-11-06 19:48:27', NULL, '1,69', '2019-11-06 19:48:27', 2, 124, '财务中心', 133, 9, 0, 'fa  fa-cny', 0, '', '69', 1),
	(101, '2020-04-13 17:51:17', NULL, '1,69,101', '2020-04-13 17:51:17', 3, 127, '客户对账', 128, 1, 0, 'fa fa-circle-o', 0, 'tenant/financeaccount/view_list.htm', 'financeaccount', 69),
	(102, '2020-04-13 17:53:26', NULL, '1,69,102', '2020-04-13 17:53:26', 3, 129, '收款退款', 130, 3, 0, 'fa fa-circle-o', 0, 'tenant/bill/view_list.htm', 'bill', 69),
	(92, '2020-03-27 20:57:49', NULL, '1,92', '2020-03-27 20:57:49', 2, 168, '营销中心', 173, 100, 0, 'fa  fa-bullseye', 0, '', '92', 1),
	(93, '2020-03-15 17:43:39', NULL, '1,92,93', '2020-03-15 17:43:39', 3, 169, '优惠卷管理', 170, 2, 0, 'fa fa-circle-o', 0, 'tenant/coupon/view_list.htm', 'coupon', 92),
	(73, '2019-11-07 14:49:58', NULL, '1,73', '2019-11-07 14:49:58', 2, 134, '服务中心', 141, 10, 0, 'fa  fa-cloud', 0, '', '73', 1),
	(74, '2019-11-07 14:51:50', NULL, '1,73,74', '2019-11-07 14:51:50', 3, 135, '代理服务', 136, 0, 0, 'fa fa-circle-o', 0, 'admin/tenant_plugin_proxy/list.htm', 'tenant_plugin_proxy', 73),
	(75, '2019-11-07 16:30:58', NULL, '1,73,75', '2019-11-07 16:30:58', 3, 137, '支付服务', 138, NULL, 0, 'fa fa-circle-o', NULL, 'admin/tenant_plugin_payment/list.htm', 'tenant_plugin_payment', 73),
	(76, '2019-11-07 18:16:31', NULL, '1,76', '2019-11-07 18:16:31', 2, 142, '会员中心', 145, 11, 0, 'fa  fa-users', 0, '', '76', 1),
	(77, '2019-11-07 18:25:45', NULL, '1,76,77', '2019-11-07 18:25:45', 3, 143, '会员管理', 144, 0, 0, 'fa fa-circle-o', 0, 'admin/malluser/view_list.htm', 'malluser', 76),
	(78, '2019-11-10 15:31:45', NULL, '1,73,78', '2019-11-10 15:31:45', 3, 139, '推送服务', 140, 0, 0, 'fa fa-circle-o', 0, 'admin/tenant_plugin_push/list.htm', 'tenant_plugin_push', 73),
	(79, '2020-01-13 12:40:54', NULL, '1,79', '2020-01-13 12:40:54', 2, 146, '商品中心', 155, 12, 0, 'fa  fa-ship', 0, '', '79', 1),
	(80, '2019-12-28 12:24:55', NULL, '1,79,80', '2019-12-28 12:24:55', 3, 147, '商品分类管理', 148, 0, 0, 'fa fa-circle-o', 0, 'admin/goodscatalog/view_list.htm', 'goodscatalog', 79),
	(81, '2019-12-28 12:28:31', NULL, '1,79,81', '2019-12-28 12:28:31', 3, 149, '商品管理', 150, 0, 0, 'fa fa-circle-o', 0, 'admin/goods/view_list.htm', 'goods', 79),
	(82, '2019-12-29 14:18:16', NULL, '1,79,82', '2019-12-29 14:18:16', 3, 151, '品牌管理', 152, 0, 0, 'fa fa-circle-o', 0, '/admin/goodsbrand/view_list.htm', 'goodsbrand', 79),
	(83, '2020-01-05 19:09:38', NULL, '1,79,83', '2020-01-05 19:09:38', 3, 153, '规格管理', 154, 0, 0, 'fa fa-circle-o', 0, '/admin/spuname/view_list.htm', 'spuname', 79),
	(85, '2020-03-23 18:05:27', NULL, '1,61,85', '2020-03-23 18:05:27', 3, 107, '退货单', 108, 4, 0, 'fa fa-circle-o', 0, 'tenant/orderrefund/view_list.htm', 'orderrefund', 61),
	(86, '2020-01-13 13:04:52', NULL, '1,86', '2020-01-13 13:04:52', 2, 156, '客户中心', 157, 13, 0, 'fa fa-users', 0, 'admin/customer/view_list.htm', 'customer', 1),
	(87, '2020-01-13 12:49:00', NULL, '1,87', '2020-01-13 12:49:00', 2, 158, '配送中心', 167, 14, 0, 'fa  fa-truck', 0, '', '87', 1),
	(88, '2020-03-21 16:56:07', NULL, '1,87,88', '2020-03-21 16:56:07', 3, 159, '配送单', 160, 0, 0, 'fa fa-circle-o', 0, 'tenant/distributionsheet/view_list.htm', 'distributionsheet', 87),
	(89, '2020-03-23 18:17:32', NULL, '1,61,89', '2020-03-23 18:17:32', 3, 109, '订货会订单', 110, 1, 0, 'fa fa-circle-o', 0, 'tenant/ordertrade/view_list.htm', 'ordertrade', 61),
	(90, '2020-03-23 18:06:20', NULL, '1,61,90', '2020-03-23 18:06:20', 3, 111, '换货单', 112, 5, 0, 'fa fa-circle-o', 0, 'tenant/orderexchange/view_list.htm', 'orderexchange', 61),
	(91, '2020-03-23 18:04:48', NULL, '1,61,91', '2020-03-23 18:04:48', 3, 113, '理货单', 114, 3, 0, 'fa fa-circle-o', 0, 'tenant/ordertally/view_list.htm', 'ordertally', 61),
	(94, '2020-03-15 18:06:19', NULL, '1,92,94', '2020-03-15 18:06:19', 3, 171, '营销活动', 172, 1, 0, 'fa fa-circle-o', 0, 'tenant/promote/view_list.htm', 'promote', 92),
	(96, '2020-03-20 16:09:04', NULL, '1,96', '2020-03-20 16:09:04', 2, 174, '配置中心', 185, 1000, 0, 'fa  fa-gear', 0, '', '96', 1),
	(97, '2020-03-20 16:11:42', NULL, '1,96,97', '2020-03-20 16:11:42', 3, 175, '地区管理', 176, 0, 0, 'fa fa-circle-o', 0, 'tenant/tenantarea/view_list.htm', 'tenantarea', 96),
	(98, '2020-03-20 16:12:18', NULL, '1,96,98', '2020-03-20 16:12:18', 3, 177, '角色管理', 178, 0, 0, 'fa fa-circle-o', 0, 'tenant/tenantuserrole/view_list.htm', 'tenantuserrole', 96),
	(99, '2020-03-20 16:11:58', NULL, '1,96,99', '2020-03-20 16:11:58', 3, 179, '数据字典', 180, 0, 0, 'fa fa-circle-o', 0, 'tenant/tenantdictionary/view_list.htm', 'tenantdictionary', 96),
	(100, '2020-04-13 17:54:17', NULL, '1,69,100', '2020-04-13 17:54:17', 3, 125, '客户账务', 126, 4, 0, 'fa fa-circle-o', 0, 'tenant/financestream/view_list.htm', 'financestream', 69),
	(103, '2020-04-13 17:51:31', NULL, '1,69,103', '2020-04-13 17:51:31', 3, 131, '订单发票', 132, 2, 0, 'fa fa-circle-o', 0, 'tenant/invoice/view_list.htm', 'invoice', 69),
	(104, '2020-03-27 20:56:50', NULL, '1,104', '2020-03-27 20:56:50', 2, 186, '报表中心', 197, 11, 0, 'fa  fa-bar-chart', 0, '', '104', 1),
	(105, '2020-03-25 11:42:46', NULL, '1,104,105', '2020-03-25 11:42:46', 3, 187, '概况', 188, 1, 0, 'fa fa-circle-o', 0, 'tenant/statistics/home.htm', 'statistics_home', 104),
	(106, '2020-03-25 11:42:26', NULL, '1,104,106', '2020-03-25 11:42:26', 3, 189, '客户分析', 190, 2, 0, 'fa fa-circle-o', 0, 'tenant/statistics/customer.htm', 'statistics_customer', 104),
	(107, '2020-03-25 11:42:03', NULL, '1,104,107', '2020-03-25 11:42:03', 3, 191, '业绩分析', 192, 3, 0, 'fa fa-circle-o', 0, 'tenant/statistics/kpi.htm', 'statistics_kpi', 104),
	(108, '2020-03-25 11:41:40', NULL, '1,104,108', '2020-03-25 11:41:40', 3, 193, '商品分析', 194, 4, 0, 'fa fa-circle-o', 0, 'tenant/statistics/goods.htm', 'statistics_goods', 104),
	(109, '2020-03-25 11:41:19', NULL, '1,104,109', '2020-03-25 11:41:19', 3, 195, '区域分析', 196, 5, 0, 'fa fa-circle-o', 0, 'tenant/statistics/area.htm', 'statistics_area', 104),
	(110, '2020-03-21 16:56:35', NULL, '1,87,110', '2020-03-21 16:56:35', 3, 161, '配送车型', 162, 0, 0, 'fa fa-circle-o', 0, 'tenant/vehicletype/view_list.htm', 'vehicletype', 87),
	(111, '2020-03-21 16:56:23', NULL, '1,87,111', '2020-03-21 16:56:23', 3, 163, '配送车辆', 164, 3, 0, 'fa fa-circle-o', 0, 'tenant/distributionvehicle/view_list.htm', 'distributionvehicle', 87),
	(112, '2020-03-21 16:56:47', NULL, '1,87,112', '2020-03-21 16:56:47', 3, 165, '配送司机', 166, 4, 0, 'fa fa-circle-o', 0, 'tenant/driver/view_list.htm', 'driver', 87),
	(113, '2020-03-23 15:52:36', NULL, '1,113', '2020-03-23 15:52:36', 2, 198, '货品中心', 209, 15, 0, 'fa  fa-ship', 0, '', '113', 1),
	(114, '2020-03-23 16:02:43', NULL, '1,113,114', '2020-03-23 16:02:43', 3, 199, '品牌管理', 200, 2, 0, 'fa fa-circle-o', 0, 'admin/brand/view_list.htm', 'brand', 113),
	(115, '2020-03-23 16:24:47', NULL, '1,113,115', '2020-03-23 16:24:47', 3, 201, '商品管理', 202, 1, 0, 'fa fa-circle-o', 0, 'tenant/product/view_list.htm', 'product', 113),
	(116, '2020-03-23 16:12:40', NULL, '1,113,116', '2020-03-23 16:12:40', 3, 203, '分类管理', 204, 3, 0, 'fa fa-circle-o', 0, 'tenant/productcatalog/view_list.htm', 'productcatalog', 113),
	(117, '2020-03-27 20:58:37', NULL, '1,117', '2020-03-27 20:58:37', 2, 210, '组织管理', 215, 100, 0, 'fa  fa-cubes', 0, '', '117', 1),
	(118, '2020-03-23 16:48:58', NULL, '1,117,118', '2020-03-23 16:48:58', 3, 211, '组织管理', 212, 0, 0, 'fa fa-circle-o', 0, 'tenant/organization/view_list.htm', 'organization', 117),
	(119, '2020-03-23 16:49:10', NULL, '1,117,119', '2020-03-23 16:49:10', 3, 213, '员工管理', 214, 0, 0, 'fa fa-circle-o', 0, 'tenant/employee/view_list.htm', 'employee', 117),
	(120, '2020-04-08 18:36:51', NULL, '1,113,120', '2020-04-08 18:36:51', 3, 205, '商品标签管理', 206, 4, 0, 'fa fa-circle-o', 0, 'tenant/productlabel/view_list.htm', 'productlabel', 113),
	(121, '2020-04-15 19:23:15', NULL, '1,113,121', '2020-04-15 19:23:15', 3, 207, '商品规格', 208, 5, 0, 'fa fa-circle-o', 0, 'tenant/productspec/view_list.htm', 'productspec', 113),
	(122, '2020-04-28 16:42:57', NULL, '1,122', '2020-04-28 16:42:57', 2, 216, '广告中心', 221, 2, 0, 'fa fa fa-buysellads', 0, '', '122', 1),
	(123, '2020-05-08 22:15:02', NULL, '1,122,123', '2020-05-08 22:15:02', 3, 217, '广告位管理', 218, 0, 0, 'fa  fa-minus-square', 0, 'tenant/adposition/view_list.htm', 'adposition', 122),
	(124, '2020-05-08 22:15:07', NULL, '1,122,124', '2020-05-08 22:15:07', 3, 219, '广告管理', 220, 1, 0, 'fa fa-life-buoy', 0, 'tenant/ad/view_list.htm', 'ad', 122),
	(125, '2020-05-02 16:35:04', NULL, '1,125', '2020-05-02 16:35:04', 2, 222, '内容管理', 227, 800, 0, 'fa  fa-list-alt', 0, '', '125', 1),
	(126, '2020-05-02 16:35:30', NULL, '1,125,126', '2020-05-02 16:35:30', 3, 223, '内容分类管理', 224, 1, 0, 'fa fa-table', 0, 'tenant/articlecatalog/view_list.htm', 'articlecatalog', 125),
	(127, '2020-05-02 16:35:19', NULL, '1,125,127', '2020-05-02 16:35:19', 3, 225, '内容管理', 226, 2, 0, 'fa  fa-file-text', 0, 'tenant/article/view_list.htm', 'article', 125),
	(128, '2020-05-07 14:09:12', NULL, '1,128', '2020-05-07 14:09:12', 2, 228, '采购中心', 231, 100, 0, 'fa  fa-shopping-cart', 0, '', '128', 1),
	(129, '2020-05-07 14:08:00', NULL, '1,128,129', '2020-05-07 14:08:00', 3, 229, '供应商', 230, 0, 0, 'fa fa-circle-o', 0, 'tenant/supplier/view_list.htm', 'supplier', 128),
	(130, '2020-05-07 14:18:25', NULL, '1,96,130', '2020-05-07 14:18:25', 3, 181, '行业配置', 182, 0, 0, 'fa fa-circle-o', 0, 'tenant/industry/view_list.htm', 'industry', 96),
	(131, '2020-05-19 17:32:31', NULL, '1,96,131', '2020-05-19 17:32:31', 3, 183, '第三方登录配置', 184, 0, 0, 'fa fa-circle-o', 0, 'tenant/tenantoauthconfig/view_list.htm', 'tenantoauthconfig', 96);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

-- 导出  表 b2bcloud.plugin_config 结构
DROP TABLE IF EXISTS `plugin_config`;
CREATE TABLE IF NOT EXISTS `plugin_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `isEnabled` bit(1) NOT NULL,
  `pluginId` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_d80yc0eis8aaqm59fnxc5rs0l` (`pluginId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.plugin_config 的数据：~0 rows (大约)
DELETE FROM `plugin_config`;
/*!40000 ALTER TABLE `plugin_config` DISABLE KEYS */;
INSERT INTO `plugin_config` (`id`, `addDate`, `lastDate`, `sortNum`, `isEnabled`, `pluginId`) VALUES
	(1, '2020-04-28 19:42:05', '2020-04-28 19:42:23', 1, b'1', 'diskFilePlugin');
/*!40000 ALTER TABLE `plugin_config` ENABLE KEYS */;

-- 导出  表 b2bcloud.plugin_config_attribute 结构
DROP TABLE IF EXISTS `plugin_config_attribute`;
CREATE TABLE IF NOT EXISTS `plugin_config_attribute` (
  `PluginConfig_id` bigint(20) NOT NULL,
  `attributes` varchar(255) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`PluginConfig_id`,`name`),
  CONSTRAINT `FK9s4k66fykxc5x1oo58bg0ku82` FOREIGN KEY (`PluginConfig_id`) REFERENCES `plugin_config` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.plugin_config_attribute 的数据：~5 rows (大约)
DELETE FROM `plugin_config_attribute`;
/*!40000 ALTER TABLE `plugin_config_attribute` DISABLE KEYS */;
INSERT INTO `plugin_config_attribute` (`PluginConfig_id`, `attributes`, `name`) VALUES
	(1, '/usr/local/nginx/html/b2b', 'disk'),
	(1, 'on', 'enabled'),
	(1, '1', 'order'),
	(1, 'http://file.metamall.cn/b2b', 'url'),
	(1, 'http://file.metamall.cn/b2b', 'urlPrefix');
/*!40000 ALTER TABLE `plugin_config_attribute` ENABLE KEYS */;

-- 导出  表 b2bcloud.site_app 结构
DROP TABLE IF EXISTS `site_app`;
CREATE TABLE IF NOT EXISTS `site_app` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `appKey` varchar(255) DEFAULT NULL,
  `appSecret` varchar(255) DEFAULT NULL,
  `counts` bigint(20) DEFAULT NULL,
  `downUrl` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `packageName` varchar(255) DEFAULT NULL,
  `system` varchar(255) DEFAULT NULL,
  `versionCode` int(11) DEFAULT NULL,
  `versionName` varchar(255) DEFAULT NULL,
  `system_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_jfx5shexfh9lo32836m2t62ga` (`packageName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.site_app 的数据：~0 rows (大约)
DELETE FROM `site_app`;
/*!40000 ALTER TABLE `site_app` DISABLE KEYS */;
INSERT INTO `site_app` (`id`, `addDate`, `lastDate`, `appKey`, `appSecret`, `counts`, `downUrl`, `name`, `note`, `packageName`, `system`, `versionCode`, `versionName`, `system_name`) VALUES
	(1, '2018-12-05 10:09:50', '2018-12-05 10:09:50', 'xh5jjwae1', '8b6hpn7ejjx46b4ncn21e9146bd', NULL, '', '客服端', '', '', NULL, NULL, '', 'android');
/*!40000 ALTER TABLE `site_app` ENABLE KEYS */;

-- 导出  表 b2bcloud.site_app_version 结构
DROP TABLE IF EXISTS `site_app_version`;
CREATE TABLE IF NOT EXISTS `site_app_version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `downUrl` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `versionCode` int(11) DEFAULT NULL,
  `versionName` varchar(255) DEFAULT NULL,
  `app_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9rgjxw6r5h7gf0e7ijfbademt` (`app_id`),
  CONSTRAINT `FK9rgjxw6r5h7gf0e7ijfbademt` FOREIGN KEY (`app_id`) REFERENCES `site_app` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.site_app_version 的数据：~0 rows (大约)
DELETE FROM `site_app_version`;
/*!40000 ALTER TABLE `site_app_version` DISABLE KEYS */;
/*!40000 ALTER TABLE `site_app_version` ENABLE KEYS */;

-- 导出  表 b2bcloud.site_config 结构
DROP TABLE IF EXISTS `site_config`;
CREATE TABLE IF NOT EXISTS `site_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `domainName` varchar(255) DEFAULT NULL,
  `favicon` varchar(255) DEFAULT NULL,
  `icp` varchar(255) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `mobile` bit(1) NOT NULL,
  `pageSize` int(11) DEFAULT NULL,
  `shortName` varchar(255) DEFAULT NULL,
  `theme` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.site_config 的数据：~0 rows (大约)
DELETE FROM `site_config`;
/*!40000 ALTER TABLE `site_config` DISABLE KEYS */;
INSERT INTO `site_config` (`id`, `addDate`, `lastDate`, `description`, `domainName`, `favicon`, `icp`, `keywords`, `logo`, `mobile`, `pageSize`, `shortName`, `theme`, `title`) VALUES
	(1, '2019-11-20 12:20:31', '2019-11-20 12:20:31', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, 'default', NULL);
/*!40000 ALTER TABLE `site_config` ENABLE KEYS */;

-- 导出  表 b2bcloud.site_link 结构
DROP TABLE IF EXISTS `site_link`;
CREATE TABLE IF NOT EXISTS `site_link` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `target` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `linkType_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1316ht5o7bmu4jbixoso45paa` (`linkType_id`),
  CONSTRAINT `FK1316ht5o7bmu4jbixoso45paa` FOREIGN KEY (`linkType_id`) REFERENCES `site_link_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.site_link 的数据：~5 rows (大约)
DELETE FROM `site_link`;
/*!40000 ALTER TABLE `site_link` DISABLE KEYS */;
INSERT INTO `site_link` (`id`, `addDate`, `lastDate`, `icon`, `name`, `sortNum`, `target`, `url`, `linkType_id`) VALUES
	(1, '2018-12-07 18:51:35', '2018-12-07 18:51:35', NULL, '不挂科', NULL, '_blank', 'http://www.buguake.cc', 3),
	(2, '2018-12-07 18:51:55', '2018-12-07 18:51:55', NULL, '开源中国', NULL, '_self', 'https://www.oschina.net/', 2),
	(3, '2018-12-07 18:57:56', '2018-12-07 18:57:56', NULL, 'discover', NULL, '_blank', 'https://gitee.com/cng1985/discover', 4),
	(4, '2018-12-07 18:58:20', '2018-12-07 18:58:20', NULL, 'ucms', NULL, '_blank', 'https://gitee.com/cng1985/iwan', 4),
	(5, '2018-12-07 18:59:13', '2018-12-07 18:59:13', NULL, '点评系统', NULL, '_blank', 'https://gitee.com/quhaodian/iyelp', 4);
/*!40000 ALTER TABLE `site_link` ENABLE KEYS */;

-- 导出  表 b2bcloud.site_link_type 结构
DROP TABLE IF EXISTS `site_link_type`;
CREATE TABLE IF NOT EXISTS `site_link_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsve8aryqrci3acgot8k7rt6ix` (`pid`),
  CONSTRAINT `FKsve8aryqrci3acgot8k7rt6ix` FOREIGN KEY (`pid`) REFERENCES `site_link_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.site_link_type 的数据：~4 rows (大约)
DELETE FROM `site_link_type`;
/*!40000 ALTER TABLE `site_link_type` DISABLE KEYS */;
INSERT INTO `site_link_type` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `pid`) VALUES
	(1, '2017-12-27 13:59:20', '', '1', '2017-12-27 13:59:20', 1, 1, '根节点', 8, 0, NULL),
	(2, '2017-12-29 08:52:53', '001', '1,2', '2017-12-29 08:52:53', 2, 2, '开源网站', 3, NULL, 1),
	(3, '2017-12-29 08:53:07', '002', '1,3', '2017-12-29 08:53:07', 2, 4, '朋友网站', 5, NULL, 1),
	(4, '2018-12-07 18:57:03', '003', '1,4', '2018-12-07 18:57:03', 2, 6, '开源项目', 7, NULL, 1);
/*!40000 ALTER TABLE `site_link_type` ENABLE KEYS */;

-- 导出  表 b2bcloud.site_template_web 结构
DROP TABLE IF EXISTS `site_template_web`;
CREATE TABLE IF NOT EXISTS `site_template_web` (
  `id` varchar(255) NOT NULL,
  `catalog` int(11) DEFAULT NULL,
  `demo` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.site_template_web 的数据：~0 rows (大约)
DELETE FROM `site_template_web`;
/*!40000 ALTER TABLE `site_template_web` DISABLE KEYS */;
/*!40000 ALTER TABLE `site_template_web` ENABLE KEYS */;

-- 导出  表 b2bcloud.site_theme_config 结构
DROP TABLE IF EXISTS `site_theme_config`;
CREATE TABLE IF NOT EXISTS `site_theme_config` (
  `id` varchar(32) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `path` varchar(20) DEFAULT NULL,
  `screenShot` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.site_theme_config 的数据：~0 rows (大约)
DELETE FROM `site_theme_config`;
/*!40000 ALTER TABLE `site_theme_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `site_theme_config` ENABLE KEYS */;

-- 导出  表 b2bcloud.spring_session 结构
DROP TABLE IF EXISTS `spring_session`;
CREATE TABLE IF NOT EXISTS `spring_session` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`),
  UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 正在导出表  b2bcloud.spring_session 的数据：~0 rows (大约)
DELETE FROM `spring_session`;
/*!40000 ALTER TABLE `spring_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `spring_session` ENABLE KEYS */;

-- 导出  表 b2bcloud.spring_session_attributes 结构
DROP TABLE IF EXISTS `spring_session_attributes`;
CREATE TABLE IF NOT EXISTS `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`),
  CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 正在导出表  b2bcloud.spring_session_attributes 的数据：~0 rows (大约)
DELETE FROM `spring_session_attributes`;
/*!40000 ALTER TABLE `spring_session_attributes` DISABLE KEYS */;
/*!40000 ALTER TABLE `spring_session_attributes` ENABLE KEYS */;

-- 导出  表 b2bcloud.storage_bucket 结构
DROP TABLE IF EXISTS `storage_bucket`;
CREATE TABLE IF NOT EXISTS `storage_bucket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nums` bigint(20) DEFAULT NULL,
  `volume` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gh3c3jhrw4nb5kyy7j7ku6pf5` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.storage_bucket 的数据：~0 rows (大约)
DELETE FROM `storage_bucket`;
/*!40000 ALTER TABLE `storage_bucket` DISABLE KEYS */;
INSERT INTO `storage_bucket` (`id`, `addDate`, `lastDate`, `name`, `nums`, `volume`) VALUES
	(1, '2019-12-29 18:05:04', '2020-06-03 10:35:07', 'website', 22, 6907842);
/*!40000 ALTER TABLE `storage_bucket` ENABLE KEYS */;

-- 导出  表 b2bcloud.storage_file 结构
DROP TABLE IF EXISTS `storage_file`;
CREATE TABLE IF NOT EXISTS `storage_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `diskPath` varchar(255) DEFAULT NULL,
  `fileType` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `volume` bigint(20) DEFAULT NULL,
  `bucket_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7n23g7ejwp2ki3fpf2xyk7dj1` (`bucket_id`),
  KEY `FKc2x9vsme8cy43h1que2hrlr06` (`parent_id`),
  KEY `FKeebalhjs5j5219fyjmguyq3n` (`user_id`),
  CONSTRAINT `FK7n23g7ejwp2ki3fpf2xyk7dj1` FOREIGN KEY (`bucket_id`) REFERENCES `storage_bucket` (`id`),
  CONSTRAINT `FKc2x9vsme8cy43h1que2hrlr06` FOREIGN KEY (`parent_id`) REFERENCES `storage_file` (`id`),
  CONSTRAINT `FKeebalhjs5j5219fyjmguyq3n` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.storage_file 的数据：~21 rows (大约)
DELETE FROM `storage_file`;
/*!40000 ALTER TABLE `storage_file` DISABLE KEYS */;
INSERT INTO `storage_file` (`id`, `addDate`, `lastDate`, `diskPath`, `fileType`, `name`, `path`, `volume`, `bucket_id`, `parent_id`, `user_id`) VALUES
	(1, '2019-12-29 18:05:04', '2019-12-29 18:05:04', NULL, 0, 'u=4238142487,3274484296&fm=26&gp=0.jpg', NULL, 17590, 1, NULL, 16),
	(2, '2019-12-29 18:06:07', '2019-12-29 18:06:07', NULL, 0, 'u=4238142487,3274484296&fm=26&gp=0.jpg', NULL, 17590, 1, NULL, 16),
	(3, '2019-12-29 18:19:04', '2019-12-29 18:19:04', NULL, 0, 'u=4238142487,3274484296&fm=26&gp=0.jpg', NULL, 17590, 1, NULL, 16),
	(4, '2020-04-11 21:46:34', '2020-04-11 21:46:34', NULL, 0, '222.jpg', NULL, 212160, 1, NULL, 17),
	(5, '2020-04-28 19:41:17', '2020-04-28 19:41:17', NULL, 0, '1577190607(1).png', NULL, 175252, 1, NULL, 17),
	(6, '2020-04-28 19:42:50', '2020-04-28 19:42:50', NULL, 0, '1577190607(1).png', 'http://file.metamall.cn/b2b/upload/image/202004/0be97ca0-52f0-4bae-bebf-747e184ab6ae.png', 175252, 1, NULL, 17),
	(7, '2020-05-02 17:46:02', '2020-05-02 17:46:02', NULL, 0, 'QQ截图20200325185305.png', 'http://file.metamall.cn/b2b/upload/image/202005/440e9512-c758-4fe2-b90a-e9a966986cbf.png', 703424, 1, NULL, 17),
	(8, '2020-05-04 14:50:52', '2020-05-04 14:50:52', NULL, 0, '4e4f8c58e538c459.jpg', 'http://file.metamall.cn/b2b/upload/image/202005/03c71ca2-0ac6-4f9d-83d0-b4e20a3ead20.jpg', 15268, 1, NULL, 17),
	(9, '2020-05-08 17:22:31', '2020-05-08 17:22:31', NULL, 0, '4.jpg', 'http://file.metamall.cn/b2b/upload/image/202005/3defefcb-d7dc-4d1f-b166-86cf004ac698.jpg', 78049, 1, NULL, 17),
	(10, '2020-05-08 22:44:47', '2020-05-08 22:44:47', NULL, 0, '1.png', 'http://file.metamall.cn/b2b/upload/image/202005/b72c6cae-26bc-4409-af0e-d45509b7e7be.png', 1509379, 1, NULL, 16),
	(11, '2020-05-08 22:45:04', '2020-05-08 22:45:04', NULL, 0, 'timg2.jpg', 'http://file.metamall.cn/b2b/upload/image/202005/80b99d6b-9c60-40ad-84ae-9c473c0c3954.jpg', 115385, 1, NULL, 16),
	(12, '2020-05-09 14:42:04', '2020-05-09 14:42:04', NULL, 0, 'timg2.jpg', 'http://file.metamall.cn/b2b/upload/image/202005/c1c89f42-c591-45e3-98f5-6ad6978deab3.jpg', 115385, 1, NULL, 17),
	(13, '2020-05-09 14:42:15', '2020-05-09 14:42:15', NULL, 0, '4.jpg', 'http://file.metamall.cn/b2b/upload/image/202005/15be4000-f0bd-4d48-9cde-383683f7906d.jpg', 78049, 1, NULL, 17),
	(14, '2020-05-12 16:02:17', '2020-05-12 16:02:17', NULL, 0, '1.png', 'http://file.metamall.cn/b2b/upload/image/202005/f0aacc22-e22e-4760-90df-88ba9b999955.png', 1509379, 1, NULL, 17),
	(15, '2020-05-12 16:03:43', '2020-05-12 16:03:43', NULL, 0, '5.jpg', 'http://file.metamall.cn/b2b/upload/image/202005/d9dd965e-95c6-4501-8611-a7f4617e42cd.jpg', 44108, 1, NULL, 17),
	(16, '2020-05-23 21:37:58', '2020-05-23 21:37:58', NULL, 0, '1.png', 'http://file.metamall.cn/b2b/upload/image/202005/6f771838-087b-499a-aaac-40e381616b1e.png', 1509379, 1, NULL, 17),
	(17, '2020-06-02 15:52:49', '2020-06-02 15:52:49', NULL, 0, '57d7606dNa07505e5.jpg', 'http://file.metamall.cn/b2b/upload/image/202006/65a4212b-5354-43a7-86fa-c544cf1c7121.jpg', 4271, 1, NULL, 17),
	(18, '2020-06-02 16:44:49', '2020-06-02 16:44:49', NULL, 0, '20141009170404778.jpg', 'http://file.metamall.cn/b2b/upload/image/202006/509e3f37-6874-45df-bf73-9d0f183f5319.jpg', 18618, 1, NULL, 17),
	(19, '2020-06-03 10:19:56', '2020-06-03 10:19:56', NULL, 0, '57d7606dNa07505e5.jpg', 'http://file.metamall.cn/b2b/upload/image/202006/a1f4d8da-dd9f-40f6-be7a-9e17504e1dad.jpg', 4256, 1, NULL, 17),
	(20, '2020-06-03 10:20:33', '2020-06-03 10:20:33', NULL, 0, '20141009170404778.jpg', 'http://file.metamall.cn/b2b/upload/image/202006/dcd57f4e-ebaf-486a-bec2-42fb21dc8a64.jpg', 18618, 1, NULL, 17),
	(21, '2020-06-03 10:32:05', '2020-06-03 10:32:05', NULL, 0, '5bffb4eaN2405d580.jpg', 'http://file.metamall.cn/b2b/upload/image/202006/1d7a7a48-9344-4d16-bfdb-16d98ef1d383.jpg', 369115, 1, NULL, 17),
	(22, '2020-06-03 10:35:07', '2020-06-03 10:35:07', NULL, 0, '5c05e288N093d54d4.jpg', 'http://file.metamall.cn/b2b/upload/image/202006/eb7c940e-43b2-45aa-8a19-c9afd87b4522.jpg', 199725, 1, NULL, 17);
/*!40000 ALTER TABLE `storage_file` ENABLE KEYS */;

-- 导出  表 b2bcloud.system_config_option 结构
DROP TABLE IF EXISTS `system_config_option`;
CREATE TABLE IF NOT EXISTS `system_config_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `config_key` varchar(50) DEFAULT NULL,
  `config_value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_2oj8i6u0tw1w3ljkt3l49lfq6` (`config_key`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.system_config_option 的数据：~4 rows (大约)
DELETE FROM `system_config_option`;
/*!40000 ALTER TABLE `system_config_option` DISABLE KEYS */;
INSERT INTO `system_config_option` (`id`, `addDate`, `lastDate`, `config_key`, `config_value`) VALUES
	(1, '2020-04-27 18:19:33', '2020-04-27 18:19:33', 'option_token_config_2', 'mykgeKqRotjfJxHj0ONqSDaZzqHQX9d5FSMBu8DOxN6HJARNdyTa8lTV7uPhu0KvADBTXOEha2ZquWiSIo/ZOw=='),
	(2, '2020-04-27 18:19:33', '2020-04-27 18:19:33', 'option_token_day_2', '360'),
	(3, '2020-05-08 22:45:30', '2020-05-08 22:45:30', 'option_token_config_1', 'QBLrEjQdEO6I3ibWCQiIGhog4Yy7n+9CuHtKSJH8s8Qv0OCtBdVCL0wg8qlsOhVOOXL0Rb/eQXdmR14NH0wyXw=='),
	(4, '2020-05-08 22:46:56', '2020-05-08 22:46:56', 'option_token_config_null', 'a4EL2gn4qr1Mg+kWAHoBPRanymJIxIMcNR0Je1IW4HNoNvOk36Ssg5J0QvGLTPeftQZsfcu/4ks9aYsmoGU43Q=='),
	(5, '2020-05-14 10:48:24', '2020-05-14 10:48:24', 'option_token_config_3', '60nUeavFvozdL3GZi9ndzFpMRCjFYT23rjAc5Kg1/63+smgW5SSxi9zuZSM3zDsfCs3bheelLzpIgmVhn0E25Q=='),
	(6, '2020-05-19 14:25:19', '2020-05-19 14:25:19', 'option_token_config_4', '36XSY/7bdLUGrYjeB/gFveS8Oyk6Ccdz+ao8dTBF+D/t3KpX39E78JS5/8gvB2BiruXQue1FN7xrkndSuhnGow==');
/*!40000 ALTER TABLE `system_config_option` ENABLE KEYS */;

-- 导出  表 b2bcloud.system_dictionary 结构
DROP TABLE IF EXISTS `system_dictionary`;
CREATE TABLE IF NOT EXISTS `system_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `data_key` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `storeState` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.system_dictionary 的数据：~0 rows (大约)
DELETE FROM `system_dictionary`;
/*!40000 ALTER TABLE `system_dictionary` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_dictionary` ENABLE KEYS */;

-- 导出  表 b2bcloud.system_dictionary_item 结构
DROP TABLE IF EXISTS `system_dictionary_item`;
CREATE TABLE IF NOT EXISTS `system_dictionary_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sortNum` int(11) NOT NULL,
  `state` int(11) DEFAULT NULL,
  `dictionary_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2toq4t20km76i83xfyb8adrf` (`dictionary_id`),
  CONSTRAINT `FK2toq4t20km76i83xfyb8adrf` FOREIGN KEY (`dictionary_id`) REFERENCES `system_dictionary` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.system_dictionary_item 的数据：~0 rows (大约)
DELETE FROM `system_dictionary_item`;
/*!40000 ALTER TABLE `system_dictionary_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_dictionary_item` ENABLE KEYS */;

-- 导出  表 b2bcloud.sys_tenant 结构
DROP TABLE IF EXISTS `sys_tenant`;
CREATE TABLE IF NOT EXISTS `sys_tenant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `beginDate` datetime DEFAULT NULL,
  `expireDate` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `catalog_id` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lng` double DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `domain` varchar(50) DEFAULT NULL,
  `theme` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6j19sphfmlex77ygrf50bjw6x` (`catalog_id`),
  CONSTRAINT `FK6j19sphfmlex77ygrf50bjw6x` FOREIGN KEY (`catalog_id`) REFERENCES `sys_tenant_catalog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.sys_tenant 的数据：~2 rows (大约)
DELETE FROM `sys_tenant`;
/*!40000 ALTER TABLE `sys_tenant` DISABLE KEYS */;
INSERT INTO `sys_tenant` (`id`, `addDate`, `lastDate`, `beginDate`, `expireDate`, `name`, `note`, `catalog_id`, `address`, `lat`, `lng`, `phone`, `domain`, `theme`) VALUES
	(1, '2019-12-28 12:21:23', '2019-12-28 12:21:23', '2019-12-28 00:00:00', NULL, '八爪鱼', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '2020-03-23 18:18:13', '2020-03-23 18:18:13', '2020-03-01 00:00:00', '2022-03-01 00:00:00', '去好店', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `sys_tenant` ENABLE KEYS */;

-- 导出  表 b2bcloud.sys_tenant_catalog 结构
DROP TABLE IF EXISTS `sys_tenant_catalog`;
CREATE TABLE IF NOT EXISTS `sys_tenant_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3cnjkx8wppoean7ohy0nc6k27` (`parent_id`),
  CONSTRAINT `FK3cnjkx8wppoean7ohy0nc6k27` FOREIGN KEY (`parent_id`) REFERENCES `sys_tenant_catalog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.sys_tenant_catalog 的数据：~2 rows (大约)
DELETE FROM `sys_tenant_catalog`;
/*!40000 ALTER TABLE `sys_tenant_catalog` DISABLE KEYS */;
INSERT INTO `sys_tenant_catalog` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `parent_id`) VALUES
	(1, '2019-12-28 12:20:28', '', '1', '2019-12-28 12:20:28', 1, 1, '根节点', 2, 0, NULL),
	(2, '2019-12-28 12:21:03', '001', '2', '2019-12-28 12:21:03', 1, 3, '电商', 4, NULL, 1);
/*!40000 ALTER TABLE `sys_tenant_catalog` ENABLE KEYS */;

-- 导出  表 b2bcloud.sys_tenant_dictionary 结构
DROP TABLE IF EXISTS `sys_tenant_dictionary`;
CREATE TABLE IF NOT EXISTS `sys_tenant_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `data_key` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `storeState` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKal2gyvjxvsmyr0snkaaok6yv8` (`tenant_id`),
  CONSTRAINT `FKal2gyvjxvsmyr0snkaaok6yv8` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.sys_tenant_dictionary 的数据：~2 rows (大约)
DELETE FROM `sys_tenant_dictionary`;
/*!40000 ALTER TABLE `sys_tenant_dictionary` DISABLE KEYS */;
INSERT INTO `sys_tenant_dictionary` (`id`, `addDate`, `lastDate`, `data_key`, `name`, `note`, `storeState`, `version`, `tenant_id`) VALUES
	(1, '2020-03-20 17:02:04', '2020-03-20 17:02:04', 'weight', '重量单位', '', 1, NULL, 1),
	(2, '2020-03-21 17:11:25', '2020-03-21 17:11:25', 'jztype', '驾照类型', '', 1, NULL, 1),
	(3, '2020-05-07 20:26:32', '2020-05-07 20:26:32', 'unit', '计量单位', '', 1, NULL, 2);
/*!40000 ALTER TABLE `sys_tenant_dictionary` ENABLE KEYS */;

-- 导出  表 b2bcloud.sys_tenant_dictionary_item 结构
DROP TABLE IF EXISTS `sys_tenant_dictionary_item`;
CREATE TABLE IF NOT EXISTS `sys_tenant_dictionary_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sortNum` int(11) NOT NULL,
  `state` int(11) DEFAULT NULL,
  `dictionary_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj5v1c7clrq07mecig3mvrnq0e` (`dictionary_id`),
  CONSTRAINT `FKj5v1c7clrq07mecig3mvrnq0e` FOREIGN KEY (`dictionary_id`) REFERENCES `sys_tenant_dictionary` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.sys_tenant_dictionary_item 的数据：~8 rows (大约)
DELETE FROM `sys_tenant_dictionary_item`;
/*!40000 ALTER TABLE `sys_tenant_dictionary_item` DISABLE KEYS */;
INSERT INTO `sys_tenant_dictionary_item` (`id`, `name`, `sortNum`, `state`, `dictionary_id`) VALUES
	(1, '斤', 1, NULL, 1),
	(2, '吨', 2, NULL, 1),
	(3, 'A照', 1, NULL, 2),
	(4, 'B照', 2, NULL, 2),
	(5, 'C1', 3, NULL, 2),
	(6, 'C2', 4, NULL, 2),
	(7, 'kg', 1, NULL, 3),
	(8, '斤', 2, NULL, 3);
/*!40000 ALTER TABLE `sys_tenant_dictionary_item` ENABLE KEYS */;

-- 导出  表 b2bcloud.sys_tenant_document 结构
DROP TABLE IF EXISTS `sys_tenant_document`;
CREATE TABLE IF NOT EXISTS `sys_tenant_document` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `data_key` varchar(20) DEFAULT NULL,
  `note` longtext,
  `tenant_id` bigint(20) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnkxicgthylf09q1kin98fuo3a` (`tenant_id`),
  CONSTRAINT `FKnkxicgthylf09q1kin98fuo3a` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.sys_tenant_document 的数据：~0 rows (大约)
DELETE FROM `sys_tenant_document`;
/*!40000 ALTER TABLE `sys_tenant_document` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_tenant_document` ENABLE KEYS */;

-- 导出  表 b2bcloud.sys_tenant_member 结构
DROP TABLE IF EXISTS `sys_tenant_member`;
CREATE TABLE IF NOT EXISTS `sys_tenant_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKehjjek3hwjddd1k9b6u19mnvl` (`tenant_id`),
  KEY `FKjcndsd6wvtfawpwq8kk6dwx5j` (`member_id`),
  CONSTRAINT `FKehjjek3hwjddd1k9b6u19mnvl` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKjcndsd6wvtfawpwq8kk6dwx5j` FOREIGN KEY (`member_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.sys_tenant_member 的数据：~2 rows (大约)
DELETE FROM `sys_tenant_member`;
/*!40000 ALTER TABLE `sys_tenant_member` DISABLE KEYS */;
INSERT INTO `sys_tenant_member` (`id`, `addDate`, `lastDate`, `tenant_id`, `member_id`) VALUES
	(1, '2019-12-28 12:24:06', '2019-12-28 12:24:06', 1, 16),
	(2, '2020-03-23 18:18:53', '2020-03-23 18:18:53', 2, 17);
/*!40000 ALTER TABLE `sys_tenant_member` ENABLE KEYS */;

-- 导出  表 b2bcloud.sys_tenant_menu 结构
DROP TABLE IF EXISTS `sys_tenant_menu`;
CREATE TABLE IF NOT EXISTS `sys_tenant_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `menuId` int(11) DEFAULT NULL,
  `num` bigint(20) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg45rx2i13j7j6uy6tyqvutc8e` (`tenant_id`),
  KEY `FKqen3n3vttgdti86wqqtgrut4h` (`parent_id`),
  CONSTRAINT `FKg45rx2i13j7j6uy6tyqvutc8e` FOREIGN KEY (`tenant_id`) REFERENCES `sys_tenant` (`id`),
  CONSTRAINT `FKqen3n3vttgdti86wqqtgrut4h` FOREIGN KEY (`parent_id`) REFERENCES `sys_tenant_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.sys_tenant_menu 的数据：~155 rows (大约)
DELETE FROM `sys_tenant_menu`;
/*!40000 ALTER TABLE `sys_tenant_menu` DISABLE KEYS */;
INSERT INTO `sys_tenant_menu` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `catalog`, `icon`, `menuId`, `num`, `path`, `permission`, `tenant_id`, `parent_id`) VALUES
	(1, '2020-03-20 16:15:52', NULL, NULL, '2020-03-20 16:15:52', 1, 1, '功能菜单', 114, NULL, 1, NULL, NULL, NULL, NULL, NULL, 1, NULL),
	(2, '2020-03-20 16:15:59', NULL, '1,19', '2020-03-20 16:15:59', 2, 262, '控制台', 263, 0, 0, 'fa fa-home', 19, NULL, 'admin/index.htm', '19', 1, 1),
	(3, '2020-03-20 16:15:59', NULL, '1,49', '2020-03-20 16:15:59', 2, 310, '云服务', 315, 0, 0, 'fa  fa-cloud', 49, NULL, '', '49', 1, 1),
	(4, '2020-03-20 16:15:59', NULL, '1,49,50', '2020-03-20 16:15:59', 3, 311, '云函数', 312, 0, 0, 'fa  fa-code', 50, NULL, 'admin/function/view_list.htm', 'function', 1, 3),
	(5, '2020-03-20 16:15:59', NULL, '1,54', '2020-03-20 16:15:59', 2, 316, '租户中心', 325, 0, 0, 'fa fa-circle-o', 54, NULL, '', '54', 1, 1),
	(6, '2020-03-20 16:15:59', NULL, '1,54,55', '2020-03-20 16:15:59', 3, 317, '租户类型', 318, 0, 0, 'fa fa-circle-o', 55, NULL, 'admin/tenantcatalog/view_list.htm', 'tenantcatalog', 1, 5),
	(7, '2020-03-20 16:15:59', NULL, '1,54,56', '2020-03-20 16:15:59', 3, 319, '租户管理', 320, 0, 0, 'fa fa-circle-o', 56, NULL, 'admin/tenant/view_list.htm', 'tenant', 1, 5),
	(8, '2020-03-20 16:15:59', NULL, '1,61', '2020-03-20 16:15:59', 2, 326, '订单中心', 349, 0, 0, 'fa  fa-chevron-circle-down ', 61, NULL, '', '61', 1, 1),
	(9, '2020-03-20 16:15:59', NULL, '1,61,89', '2020-03-20 16:15:59', 3, 331, '订货会订单', 332, 1, 0, 'fa fa-circle-o', 89, NULL, '', '89', 1, 8),
	(10, '2020-03-20 16:15:59', NULL, '1,61,62', '2020-03-20 16:15:59', 3, 327, '订货单', 328, 2, 0, 'fa fa-circle-o', 62, NULL, 'tenant/orderdata/view_list.htm', 'orderdata', 1, 8),
	(11, '2020-03-20 16:15:59', NULL, '1,61,91', '2020-03-20 16:15:59', 3, 335, '理货单', 336, 3, 0, 'fa fa-circle-o', 91, NULL, '', '91', 1, 8),
	(12, '2020-03-20 16:15:59', NULL, '1,61,85', '2020-03-20 16:15:59', 3, 329, '退货单', 330, 4, 0, 'fa fa-circle-o', 85, NULL, '', '85', 1, 8),
	(13, '2020-03-20 16:15:59', NULL, '1,61,90', '2020-03-20 16:15:59', 3, 333, '换货单', 334, 5, 0, 'fa fa-circle-o', 90, NULL, '', '90', 1, 8),
	(14, '2020-03-20 16:15:59', NULL, '1,69', '2020-03-20 16:15:59', 2, 344, '财务中心', 349, 0, 0, 'fa  fa-cny', 69, NULL, '', '69', 1, 1),
	(15, '2020-03-20 16:15:59', NULL, '1,69,70', '2020-03-20 16:15:59', 3, 345, '提现管理', 346, 0, 0, 'fa fa-circle-o', 70, NULL, 'admin/cashpayment/view_list.htm', 'cashpayment', 1, 14),
	(16, '2020-03-20 16:15:59', NULL, '1,73', '2020-03-20 16:15:59', 2, 346, '服务中心', 361, 0, 0, 'fa  fa-cloud', 73, NULL, '', '73', 1, 1),
	(17, '2020-03-20 16:15:59', NULL, '1,73,75', '2020-03-20 16:15:59', 3, 349, '支付服务', 350, NULL, 0, 'fa fa-circle-o', 75, NULL, 'admin/tenant_plugin_payment/list.htm', 'tenant_plugin_payment', 1, 16),
	(18, '2020-03-20 16:15:59', NULL, '1,73,74', '2020-03-20 16:15:59', 3, 347, '代理服务', 348, 0, 0, 'fa fa-circle-o', 74, NULL, 'admin/tenant_plugin_proxy/list.htm', 'tenant_plugin_proxy', 1, 16),
	(19, '2020-03-20 16:15:59', NULL, '1,73,78', '2020-03-20 16:15:59', 3, 351, '推送服务', 352, 0, 0, 'fa fa-circle-o', 78, NULL, 'admin/tenant_plugin_push/list.htm', 'tenant_plugin_push', 1, 16),
	(20, '2020-03-20 16:15:59', NULL, '1,76', '2020-03-20 16:15:59', 2, 352, '会员中心', 357, 0, 0, 'fa  fa-users', 76, NULL, '', '76', 1, 1),
	(21, '2020-03-20 16:15:59', NULL, '1,76,77', '2020-03-20 16:15:59', 3, 353, '会员管理', 354, 0, 0, 'fa fa-circle-o', 77, NULL, 'admin/malluser/view_list.htm', 'malluser', 1, 20),
	(22, '2020-03-20 16:15:59', NULL, '1,79', '2020-03-20 16:15:59', 2, 354, '商品中心', 373, 0, 0, 'fa  fa-ship', 79, NULL, '', '79', 1, 1),
	(23, '2020-03-20 16:15:59', NULL, '1,79,80', '2020-03-20 16:15:59', 3, 355, '商品分类管理', 356, 0, 0, 'fa fa-circle-o', 80, NULL, 'admin/goodscatalog/view_list.htm', 'goodscatalog', 1, 22),
	(24, '2020-03-20 16:15:59', NULL, '1,79,81', '2020-03-20 16:15:59', 3, 357, '商品管理', 358, 0, 0, 'fa fa-circle-o', 81, NULL, 'admin/goods/view_list.htm', 'goods', 1, 22),
	(25, '2020-03-20 16:15:59', NULL, '1,79,82', '2020-03-20 16:15:59', 3, 359, '品牌管理', 360, 0, 0, 'fa fa-circle-o', 82, NULL, '/admin/goodsbrand/view_list.htm', 'goodsbrand', 1, 22),
	(26, '2020-03-20 16:15:59', NULL, '1,79,83', '2020-03-20 16:15:59', 3, 361, '规格管理', 362, 0, 0, 'fa fa-circle-o', 83, NULL, '/admin/spuname/view_list.htm', 'spuname', 1, 22),
	(27, '2020-03-20 16:15:59', NULL, '1,86', '2020-03-20 16:15:59', 2, 362, '客户中心', 363, 0, 0, 'fa fa-users', 86, NULL, 'admin/customer/view_list.htm', 'customer', 1, 1),
	(28, '2020-03-20 16:15:59', NULL, '1,87', '2020-03-20 16:15:59', 2, 362, '配送中心', 367, 0, 0, 'fa  fa-truck', 87, NULL, '', '87', 1, 1),
	(29, '2020-03-20 16:15:59', NULL, '1,87,88', '2020-03-20 16:15:59', 3, 363, '配送单', 364, NULL, 0, 'fa fa-circle-o', 88, NULL, '', '88', 1, 28),
	(30, '2020-03-20 16:15:59', NULL, '1,12', '2020-03-20 16:15:59', 2, 118, '流程管理', 127, 1, 0, 'fa  fa-archive', 12, NULL, '', '12', 1, 1),
	(31, '2020-03-20 16:15:59', NULL, '1,12,13', '2020-03-20 16:15:59', 3, 119, '工作流管理', 120, NULL, 0, 'fa fa-circle-o', 13, NULL, 'admin/flow/view_list.htm', 'flow', 1, 30),
	(32, '2020-03-20 16:15:59', NULL, '1,12,14', '2020-03-20 16:15:59', 3, 121, '模型管理', 122, NULL, 0, 'fa fa-circle-o', 14, NULL, 'admin/act/view_list.htm', 'act', 1, 30),
	(33, '2020-03-20 16:15:59', NULL, '1,15', '2020-03-20 16:15:59', 2, 122, '服务插件管理', 157, 2, 0, 'fa  fa-cloud', 15, NULL, '', '15', 1, 1),
	(34, '2020-03-20 16:15:59', NULL, '1,15,45', '2020-03-20 16:15:59', 3, 135, '服务管理', 136, -1, 0, 'fa fa-circle-o', 45, NULL, 'admin/plugin_proxy/list.htm', 'plugin_proxy', 1, 33),
	(35, '2020-03-20 16:15:59', NULL, '1,15,16', '2020-03-20 16:15:59', 3, 123, '验证码插件配置', 124, 0, 0, 'fa  fa-commenting-o', 16, NULL, 'admin/plugin_sendcode/list.htm', 'plugin_sendcode', 1, 33),
	(36, '2020-03-20 16:15:59', NULL, '1,15,17', '2020-03-20 16:15:59', 3, 125, '存储插件配置', 126, 0, 0, 'fa  fa-cloud-upload', 17, NULL, 'admin/plugin_storage/list.htm', 'plugin_storage', 1, 33),
	(37, '2020-03-20 16:15:59', NULL, '1,15,18', '2020-03-20 16:15:59', 3, 127, '推送插件配置', 128, 0, 0, 'fa fa-circle-o', 18, NULL, 'admin/plugin_push/list.htm', 'plugin_push', 1, 33),
	(38, '2020-03-20 16:15:59', NULL, '1,15,24', '2020-03-20 16:15:59', 3, 129, '支付插件管理', 130, 0, 0, 'fa fa-circle-o', 24, NULL, '', '24', 1, 33),
	(39, '2020-03-20 16:15:59', NULL, '1,15,25', '2020-03-20 16:15:59', 3, 131, '第三方登陆插件配置', 132, 0, 0, 'fa fa-circle-o', 25, NULL, 'admin/plugin_oauth/list.htm', 'plugin_oauth', 1, 33),
	(40, '2020-03-20 16:15:59', NULL, '1,15,26', '2020-03-20 16:15:59', 3, 133, '邮件插件配置', 134, 0, 0, 'fa fa-circle-o', 26, NULL, '', '26', 1, 33),
	(41, '2020-03-20 16:15:59', NULL, '1,34', '2020-03-20 16:15:59', 2, 158, '定时任务管理', 217, 3, 0, 'fa  fa-calendar-plus-o', 34, NULL, '', '34', 1, 1),
	(42, '2020-03-20 16:15:59', NULL, '1,34,35', '2020-03-20 16:15:59', 3, 159, '控制台', 160, 0, 0, 'fa fa-dashboard', 35, NULL, 'admin/crontask/index.htm', '35', 1, 41),
	(43, '2020-03-20 16:15:59', NULL, '1,34,36', '2020-03-20 16:15:59', 3, 161, '任务管理', 162, 0, 0, 'fa   fa-list-ol', 36, NULL, 'admin/crontask/view_list.htm', 'crontask', 1, 41),
	(44, '2020-03-20 16:15:59', NULL, '1,34,37', '2020-03-20 16:15:59', 3, 163, '运行记录', 164, 0, 0, 'fa fa-reorder', 37, NULL, 'admin/crontaskrecord/view_list.htm', 'crontaskrecord', 1, 41),
	(45, '2020-03-20 16:15:59', NULL, '1,38', '2020-03-20 16:15:59', 2, 164, '消息通知', 217, 5, 0, 'fa  fa-comments', 38, NULL, '', '38', 1, 1),
	(46, '2020-03-20 16:15:59', NULL, '1,38,40', '2020-03-20 16:15:59', 3, 167, '通知分类', 168, NULL, 0, 'fa fa-circle-o', 40, NULL, 'admin/usernotificationcatalog/view_list.htm', 'usernotificationcatalog', 1, 45),
	(47, '2020-03-20 16:15:59', NULL, '1,38,39', '2020-03-20 16:15:59', 3, 165, '收件箱', 166, 0, 0, 'fa fa-circle-o', 39, NULL, 'admin/usernotificationmember/view_list.htm', 'usernotificationmember', 1, 45),
	(48, '2020-03-20 16:15:59', NULL, '1,38,44', '2020-03-20 16:15:59', 3, 189, '通知管理', 190, 3, 0, 'fa fa-circle-o', 44, NULL, 'admin/usernotification/view_list.htm', 'usernotification', 1, 45),
	(49, '2020-03-20 16:15:59', NULL, '1,2', '2020-03-20 16:15:59', 2, 2, '系统设置', 93, 55, 0, 'fa  fa-gear', 2, NULL, '', '2', 1, 1),
	(50, '2020-03-20 16:15:59', NULL, '1,2,43', '2020-03-20 16:15:59', 3, 21, '个人资料管理', 22, -1, 0, 'glyphicon glyphicon-user', 43, NULL, 'admin/member/basic.htm', 'member_basic', 1, 49),
	(51, '2020-03-20 16:15:59', NULL, '1,2,48', '2020-03-20 16:15:59', 3, 25, '系统配置', 26, -1, 0, 'fa  fa-cogs', 48, NULL, 'admin/config.htm', 'system_config', 1, 49),
	(52, '2020-03-20 16:15:59', NULL, '1,2,3', '2020-03-20 16:15:59', 3, 3, '菜单管理', 4, 0, 0, 'fa  fa-reorder', 3, NULL, 'admin/menu/view_list.htm', 'menu', 1, 49),
	(53, '2020-03-20 16:15:59', NULL, '1,2,4', '2020-03-20 16:15:59', 3, 5, '角色管理', 6, 0, 0, 'fa  fa-tree', 4, NULL, 'admin/userrole/view_list.htm', 'userrole', 1, 49),
	(54, '2020-03-20 16:15:59', NULL, '1,2,5', '2020-03-20 16:15:59', 3, 7, '第三方登陆配置', 8, 0, 0, 'fa  fa-connectdevelop', 5, NULL, 'admin/tenantoauthconfig/view_list.htm', 'tenantoauthconfig', 1, 49),
	(55, '2020-03-20 16:15:59', NULL, '1,2,6', '2020-03-20 16:15:59', 3, 9, '友情链接分类管理', 10, 0, 0, 'fa  fa-link', 6, NULL, 'admin/linktype/view_list.htm', 'linktype', 1, 49),
	(56, '2020-03-20 16:15:59', NULL, '1,2,7', '2020-03-20 16:15:59', 3, 11, '友情链接管理', 12, 0, 0, 'fa  fa-link', 7, NULL, 'admin/link/view_list.htm', 'link', 1, 49),
	(57, '2020-03-20 16:15:59', NULL, '1,2,8', '2020-03-20 16:15:59', 3, 13, '角色分类配置', 14, 0, 0, 'fa  fa-user-secret', 8, NULL, 'admin/userrolecatalog/view_list.htm', 'userrolecatalog', 1, 49),
	(58, '2020-03-20 16:15:59', NULL, '1,2,9', '2020-03-20 16:15:59', 3, 15, '移动app配置', 16, 0, 0, 'fa  fa-life-ring', 9, NULL, 'admin/app/view_list.htm', 'appversion', 1, 49),
	(59, '2020-03-20 16:15:59', NULL, '1,2,10', '2020-03-20 16:15:59', 3, 17, '网站主题配置', 18, 0, 0, 'fa  fa-sitemap', 10, NULL, 'admin/theme.htm', '10', 1, 49),
	(60, '2020-03-20 16:15:59', NULL, '1,2,11', '2020-03-20 16:15:59', 3, 19, '模板管理', 20, 0, 0, 'fa fa-circle-o', 11, NULL, 'admin/tmpl/view_list.htm', 'tmpl', 1, 49),
	(61, '2020-03-20 16:15:59', NULL, '1,2,47', '2020-03-20 16:15:59', 3, 23, '数据字典管理', 24, 0, 0, 'fa  fa-square', 47, NULL, 'admin/dictionary/view_list.htm', 'dictionary', 1, 49),
	(62, '2020-03-20 16:15:59', NULL, '1,92', '2020-03-20 16:15:59', 2, 290, '营销中心', 299, 100, 0, 'fa fa-circle-o', 92, NULL, '', '92', 1, 1),
	(63, '2020-03-20 16:15:59', NULL, '1,92,94', '2020-03-20 16:15:59', 3, 293, '营销活动', 294, 1, 0, 'fa fa-circle-o', 94, NULL, 'tenant/promote/view_list.htm', 'promote', 1, 62),
	(64, '2020-03-20 16:15:59', NULL, '1,92,93', '2020-03-20 16:15:59', 3, 291, '优惠卷管理', 292, 2, 0, 'fa fa-circle-o', 93, NULL, 'tenant/coupon/view_list.htm', 'coupon', 1, 62),
	(65, '2020-03-20 16:15:59', NULL, '1,96', '2020-03-20 16:15:59', 2, 294, '配置中心', 307, 1000, 0, 'fa  fa-gear', 96, NULL, '', '96', 1, 1),
	(66, '2020-03-20 16:15:59', NULL, '1,96,97', '2020-03-20 16:15:59', 3, 295, '地区管理', 296, 0, 0, 'fa fa-circle-o', 97, NULL, 'tenant/tenantarea/view_list.htm', 'tenantarea', 1, 65),
	(67, '2020-03-20 16:15:59', NULL, '1,96,98', '2020-03-20 16:15:59', 3, 297, '角色管理', 298, 0, 0, 'fa fa-circle-o', 98, NULL, 'tenant/tenantuserrole/view_list.htm', 'tenantuserrole', 1, 65),
	(68, '2020-03-20 16:15:59', NULL, '1,96,99', '2020-03-20 16:15:59', 3, 299, '数据字典', 300, 0, 0, 'fa fa-circle-o', 99, NULL, 'tenant/tenantdictionary/view_list.htm', 'tenantdictionary', 1, 65),
	(69, '2020-03-23 18:18:18', NULL, NULL, '2020-03-23 18:18:18', 1, 374, '功能菜单', 415, NULL, 1, NULL, NULL, NULL, NULL, NULL, 2, NULL),
	(70, '2020-03-23 18:18:18', NULL, '1,19', '2020-03-23 18:18:18', 2, 92, '控制台', 93, 0, 0, 'fa fa-home', 19, NULL, 'admin/index.htm', '19', 2, 69),
	(71, '2020-03-23 18:18:18', NULL, '1,49', '2020-03-23 18:18:18', 2, 138, '云服务', 143, 0, 0, 'fa  fa-cloud', 49, NULL, '', '49', 2, 69),
	(72, '2020-03-23 18:18:18', NULL, '1,49,50', '2020-03-23 18:18:18', 3, 139, '云函数', 140, 0, 0, 'fa  fa-code', 50, NULL, 'admin/function/view_list.htm', 'function', 2, 71),
	(73, '2020-03-23 18:18:18', NULL, '1,54', '2020-03-23 18:18:18', 2, 146, '租户中心', 155, 0, 0, 'fa fa-circle-o', 54, NULL, '', '54', 2, 69),
	(74, '2020-03-23 18:18:18', NULL, '1,54,55', '2020-03-23 18:18:18', 3, 147, '租户类型', 148, 0, 0, 'fa fa-circle-o', 55, NULL, 'admin/tenantcatalog/view_list.htm', 'tenantcatalog', 2, 73),
	(75, '2020-03-23 18:18:18', NULL, '1,54,56', '2020-03-23 18:18:18', 3, 149, '租户管理', 150, 0, 0, 'fa fa-circle-o', 56, NULL, 'admin/tenant/view_list.htm', 'tenant', 2, 73),
	(76, '2020-03-23 18:18:18', NULL, '1,61', '2020-03-23 18:18:18', 2, 158, '订单中心', 189, 0, 0, 'fa  fa-chevron-circle-down ', 61, NULL, '', '61', 2, 69),
	(77, '2020-03-23 18:18:18', NULL, '1,61,89', '2020-03-23 18:18:18', 3, 163, '订货会订单', 164, 1, 0, 'fa fa-circle-o', 89, NULL, 'tenant/ordertrade/view_list.htm', 'ordertrade', 2, 76),
	(78, '2020-03-23 18:18:18', NULL, '1,61,62', '2020-03-23 18:18:18', 3, 159, '订货单', 160, 2, 0, 'fa fa-circle-o', 62, NULL, 'tenant/orderdata/view_list.htm', 'orderdata', 2, 76),
	(79, '2020-03-23 18:18:18', NULL, '1,61,91', '2020-03-23 18:18:18', 3, 167, '理货单', 168, 3, 0, 'fa fa-circle-o', 91, NULL, 'tenant/ordertally/view_list.htm', 'ordertally', 2, 76),
	(80, '2020-03-23 18:18:18', NULL, '1,61,85', '2020-03-23 18:18:18', 3, 161, '退货单', 162, 4, 0, 'fa fa-circle-o', 85, NULL, 'tenant/orderrefund/view_list.htm', 'orderrefund', 2, 76),
	(81, '2020-03-23 18:18:18', NULL, '1,61,90', '2020-03-23 18:18:18', 3, 165, '换货单', 166, 5, 0, 'fa fa-circle-o', 90, NULL, 'tenant/orderexchange/view_list.htm', 'orderexchange', 2, 76),
	(82, '2020-03-23 18:18:18', NULL, '1,69', '2020-03-23 18:18:18', 2, 188, '财务中心', 217, 0, 0, 'fa  fa-cny', 69, NULL, '', '69', 2, 69),
	(83, '2020-03-23 18:18:18', NULL, '1,69,101', '2020-03-23 18:18:18', 3, 191, '客户对账', 192, NULL, 0, 'fa fa-circle-o', 101, NULL, '', '101', 2, 82),
	(84, '2020-03-23 18:18:18', NULL, '1,69,102', '2020-03-23 18:18:18', 3, 193, '收款退款', 194, NULL, 0, 'fa fa-circle-o', 102, NULL, '', '102', 2, 82),
	(85, '2020-03-23 18:18:18', NULL, '1,69,100', '2020-03-23 18:18:18', 3, 189, '客户账务', 190, NULL, 0, 'fa fa-circle-o', 100, NULL, '', '100', 2, 82),
	(86, '2020-03-23 18:18:18', NULL, '1,69,103', '2020-03-23 18:18:18', 3, 195, '订单发票', 196, NULL, 0, 'fa fa-circle-o', 103, NULL, '', '103', 2, 82),
	(87, '2020-03-23 18:18:18', NULL, '1,73', '2020-03-23 18:18:18', 2, 198, '服务中心', 217, 0, 0, 'fa  fa-cloud', 73, NULL, '', '73', 2, 69),
	(88, '2020-03-23 18:18:18', NULL, '1,73,75', '2020-03-23 18:18:18', 3, 201, '支付服务', 202, NULL, 0, 'fa fa-circle-o', 75, NULL, 'admin/tenant_plugin_payment/list.htm', 'tenant_plugin_payment', 2, 87),
	(89, '2020-03-23 18:18:18', NULL, '1,73,74', '2020-03-23 18:18:18', 3, 199, '代理服务', 200, 0, 0, 'fa fa-circle-o', 74, NULL, 'admin/tenant_plugin_proxy/list.htm', 'tenant_plugin_proxy', 2, 87),
	(90, '2020-03-23 18:18:18', NULL, '1,73,78', '2020-03-23 18:18:18', 3, 203, '推送服务', 204, 0, 0, 'fa fa-circle-o', 78, NULL, 'admin/tenant_plugin_push/list.htm', 'tenant_plugin_push', 2, 87),
	(91, '2020-03-23 18:18:18', NULL, '1,76', '2020-03-23 18:18:18', 2, 206, '会员中心', 211, 0, 0, 'fa  fa-users', 76, NULL, '', '76', 2, 69),
	(92, '2020-03-23 18:18:18', NULL, '1,76,77', '2020-03-23 18:18:18', 3, 207, '会员管理', 208, 0, 0, 'fa fa-circle-o', 77, NULL, 'admin/malluser/view_list.htm', 'malluser', 2, 91),
	(93, '2020-03-23 18:18:18', NULL, '1,79', '2020-03-23 18:18:18', 2, 210, '商品中心', 241, 0, 0, 'fa  fa-ship', 79, NULL, '', '79', 2, 69),
	(94, '2020-03-23 18:18:18', NULL, '1,79,80', '2020-03-23 18:18:18', 3, 211, '商品分类管理', 212, 0, 0, 'fa fa-circle-o', 80, NULL, 'admin/goodscatalog/view_list.htm', 'goodscatalog', 2, 93),
	(95, '2020-03-23 18:18:18', NULL, '1,79,81', '2020-03-23 18:18:18', 3, 217, '商品管理', 218, 0, 0, 'fa fa-circle-o', 81, NULL, 'admin/goods/view_list.htm', 'goods', 2, 93),
	(96, '2020-03-23 18:18:18', NULL, '1,79,82', '2020-03-23 18:18:18', 3, 219, '品牌管理', 220, 0, 0, 'fa fa-circle-o', 82, NULL, '/admin/goodsbrand/view_list.htm', 'goodsbrand', 2, 93),
	(97, '2020-03-23 18:18:18', NULL, '1,79,83', '2020-03-23 18:18:18', 3, 221, '规格管理', 222, 0, 0, 'fa fa-circle-o', 83, NULL, '/admin/spuname/view_list.htm', 'spuname', 2, 93),
	(98, '2020-03-23 18:18:18', NULL, '1,86', '2020-03-23 18:18:18', 2, 224, '客户中心', 225, 0, 0, 'fa fa-users', 86, NULL, 'admin/customer/view_list.htm', 'customer', 2, 69),
	(99, '2020-03-23 18:18:18', NULL, '1,87', '2020-03-23 18:18:18', 2, 226, '配送中心', 253, 0, 0, 'fa  fa-truck', 87, NULL, '', '87', 2, 69),
	(100, '2020-03-23 18:18:18', NULL, '1,87,88', '2020-03-23 18:18:18', 3, 227, '配送单', 228, 0, 0, 'fa fa-circle-o', 88, NULL, 'tenant/distributionsheet/view_list.htm', 'distributionsheet', 2, 99),
	(101, '2020-03-23 18:18:18', NULL, '1,87,110', '2020-03-23 18:18:18', 3, 229, '配送车型', 230, 0, 0, 'fa fa-circle-o', 110, NULL, 'tenant/vehicletype/view_list.htm', 'vehicletype', 2, 99),
	(102, '2020-03-23 18:18:18', NULL, '1,87,111', '2020-03-23 18:18:18', 3, 241, '配送车辆', 242, 3, 0, 'fa fa-circle-o', 111, NULL, 'tenant/distributionvehicle/view_list.htm', 'distributionvehicle', 2, 99),
	(103, '2020-03-23 18:18:18', NULL, '1,87,112', '2020-03-23 18:18:18', 3, 243, '配送司机', 244, 4, 0, 'fa fa-circle-o', 112, NULL, 'tenant/driver/view_list.htm', 'driver', 2, 99),
	(104, '2020-03-23 18:18:18', NULL, '1,113', '2020-03-23 18:18:18', 2, 272, '货品中心', 285, 0, 0, 'fa  fa-ship', 113, NULL, '', '113', 2, 69),
	(105, '2020-03-23 18:18:18', NULL, '1,113,115', '2020-03-23 18:18:18', 3, 275, '商品管理', 276, 1, 0, 'fa fa-circle-o', 115, NULL, 'tenant/product/view_list.htm', 'product', 2, 104),
	(106, '2020-03-23 18:18:18', NULL, '1,113,114', '2020-03-23 18:18:18', 3, 273, '品牌管理', 274, 2, 0, 'fa fa-circle-o', 114, NULL, 'admin/brand/view_list.htm', 'brand', 2, 104),
	(107, '2020-03-23 18:18:18', NULL, '1,113,116', '2020-03-23 18:18:18', 3, 277, '分类管理', 278, 3, 0, 'fa fa-circle-o', 116, NULL, 'tenant/productcatalog/view_list.htm', 'productcatalog', 2, 104),
	(108, '2020-03-23 18:18:18', NULL, '1,12', '2020-03-23 18:18:18', 2, 52, '流程管理', 61, 1, 0, 'fa  fa-archive', 12, NULL, '', '12', 2, 69),
	(109, '2020-03-23 18:18:18', NULL, '1,12,13', '2020-03-23 18:18:18', 3, 53, '工作流管理', 54, NULL, 0, 'fa fa-circle-o', 13, NULL, 'admin/flow/view_list.htm', 'flow', 2, 108),
	(110, '2020-03-23 18:18:18', NULL, '1,12,14', '2020-03-23 18:18:18', 3, 55, '模型管理', 56, NULL, 0, 'fa fa-circle-o', 14, NULL, 'admin/act/view_list.htm', 'act', 2, 108),
	(111, '2020-03-23 18:18:18', NULL, '1,15', '2020-03-23 18:18:18', 2, 58, '服务插件管理', 87, 2, 0, 'fa  fa-cloud', 15, NULL, '', '15', 2, 69),
	(112, '2020-03-23 18:18:18', NULL, '1,15,45', '2020-03-23 18:18:18', 3, 71, '服务管理', 72, -1, 0, 'fa fa-circle-o', 45, NULL, 'admin/plugin_proxy/list.htm', 'plugin_proxy', 2, 111),
	(113, '2020-03-23 18:18:18', NULL, '1,15,16', '2020-03-23 18:18:18', 3, 59, '验证码插件配置', 60, 0, 0, 'fa  fa-commenting-o', 16, NULL, 'admin/plugin_sendcode/list.htm', 'plugin_sendcode', 2, 111),
	(114, '2020-03-23 18:18:18', NULL, '1,15,17', '2020-03-23 18:18:18', 3, 61, '存储插件配置', 62, 0, 0, 'fa  fa-cloud-upload', 17, NULL, 'admin/plugin_storage/list.htm', 'plugin_storage', 2, 111),
	(115, '2020-03-23 18:18:18', NULL, '1,15,18', '2020-03-23 18:18:18', 3, 63, '推送插件配置', 64, 0, 0, 'fa fa-circle-o', 18, NULL, 'admin/plugin_push/list.htm', 'plugin_push', 2, 111),
	(116, '2020-03-23 18:18:18', NULL, '1,15,24', '2020-03-23 18:18:18', 3, 65, '支付插件管理', 66, 0, 0, 'fa fa-circle-o', 24, NULL, '', '24', 2, 111),
	(117, '2020-03-23 18:18:18', NULL, '1,15,25', '2020-03-23 18:18:18', 3, 67, '第三方登陆插件配置', 68, 0, 0, 'fa fa-circle-o', 25, NULL, 'admin/plugin_oauth/list.htm', 'plugin_oauth', 2, 111),
	(118, '2020-03-23 18:18:18', NULL, '1,15,26', '2020-03-23 18:18:18', 3, 69, '邮件插件配置', 70, 0, 0, 'fa fa-circle-o', 26, NULL, '', '26', 2, 111),
	(119, '2020-03-23 18:18:18', NULL, '1,34', '2020-03-23 18:18:18', 2, 90, '定时任务管理', 103, 3, 0, 'fa  fa-calendar-plus-o', 34, NULL, '', '34', 2, 69),
	(120, '2020-03-23 18:18:18', NULL, '1,34,35', '2020-03-23 18:18:18', 3, 91, '控制台', 92, 0, 0, 'fa fa-dashboard', 35, NULL, 'admin/crontask/index.htm', '35', 2, 119),
	(121, '2020-03-23 18:18:18', NULL, '1,34,36', '2020-03-23 18:18:18', 3, 93, '任务管理', 94, 0, 0, 'fa   fa-list-ol', 36, NULL, 'admin/crontask/view_list.htm', 'crontask', 2, 119),
	(122, '2020-03-23 18:18:18', NULL, '1,34,37', '2020-03-23 18:18:18', 3, 95, '运行记录', 96, 0, 0, 'fa fa-reorder', 37, NULL, 'admin/crontaskrecord/view_list.htm', 'crontaskrecord', 2, 119),
	(123, '2020-03-23 18:18:18', NULL, '1,38', '2020-03-23 18:18:18', 2, 98, '消息通知', 111, 5, 0, 'fa  fa-comments', 38, NULL, '', '38', 2, 69),
	(124, '2020-03-23 18:18:18', NULL, '1,38,40', '2020-03-23 18:18:18', 3, 101, '通知分类', 102, NULL, 0, 'fa fa-circle-o', 40, NULL, 'admin/usernotificationcatalog/view_list.htm', 'usernotificationcatalog', 2, 123),
	(125, '2020-03-23 18:18:18', NULL, '1,38,39', '2020-03-23 18:18:18', 3, 99, '收件箱', 100, 0, 0, 'fa fa-circle-o', 39, NULL, 'admin/usernotificationmember/view_list.htm', 'usernotificationmember', 2, 123),
	(126, '2020-03-23 18:18:18', NULL, '1,38,44', '2020-03-23 18:18:18', 3, 103, '通知管理', 104, 3, 0, 'fa fa-circle-o', 44, NULL, 'admin/usernotification/view_list.htm', 'usernotification', 2, 123),
	(127, '2020-03-23 18:18:18', NULL, '1,104', '2020-03-23 18:18:18', 2, 220, '报表中心', 241, 11, 0, 'fa fa-circle-o', 104, NULL, '', '104', 2, 69),
	(128, '2020-03-23 18:18:18', NULL, '1,104,105', '2020-03-23 18:18:18', 3, 221, '概况', 222, NULL, 0, 'fa fa-circle-o', 105, NULL, '', '105', 2, 127),
	(129, '2020-03-23 18:18:18', NULL, '1,104,106', '2020-03-23 18:18:18', 3, 223, '客户分析', 224, NULL, 0, 'fa fa-circle-o', 106, NULL, '', '106', 2, 127),
	(130, '2020-03-23 18:18:18', NULL, '1,104,107', '2020-03-23 18:18:18', 3, 225, '业绩分析', 226, NULL, 0, 'fa fa-circle-o', 107, NULL, '', '107', 2, 127),
	(131, '2020-03-23 18:18:18', NULL, '1,104,108', '2020-03-23 18:18:18', 3, 227, '商品分析', 228, NULL, 0, 'fa fa-circle-o', 108, NULL, '', '108', 2, 127),
	(132, '2020-03-23 18:18:18', NULL, '1,104,109', '2020-03-23 18:18:18', 3, 229, '区域分析', 230, NULL, 0, 'fa fa-circle-o', 109, NULL, '', '109', 2, 127),
	(133, '2020-03-23 18:18:18', NULL, '1,2', '2020-03-23 18:18:18', 2, 2, '系统设置', 51, 55, 0, 'fa  fa-gear', 2, NULL, '', '2', 2, 69),
	(134, '2020-03-23 18:18:18', NULL, '1,2,43', '2020-03-23 18:18:18', 3, 21, '个人资料管理', 22, -1, 0, 'glyphicon glyphicon-user', 43, NULL, 'admin/member/basic.htm', 'member_basic', 2, 133),
	(135, '2020-03-23 18:18:18', NULL, '1,2,48', '2020-03-23 18:18:18', 3, 25, '系统配置', 26, -1, 0, 'fa  fa-cogs', 48, NULL, 'admin/config.htm', 'system_config', 2, 133),
	(136, '2020-03-23 18:18:18', NULL, '1,2,3', '2020-03-23 18:18:18', 3, 3, '菜单管理', 4, 0, 0, 'fa  fa-reorder', 3, NULL, 'admin/menu/view_list.htm', 'menu', 2, 133),
	(137, '2020-03-23 18:18:18', NULL, '1,2,4', '2020-03-23 18:18:18', 3, 5, '角色管理', 6, 0, 0, 'fa  fa-tree', 4, NULL, 'admin/userrole/view_list.htm', 'userrole', 2, 133),
	(138, '2020-03-23 18:18:18', NULL, '1,2,5', '2020-03-23 18:18:18', 3, 7, '第三方登陆配置', 8, 0, 0, 'fa  fa-connectdevelop', 5, NULL, 'admin/tenantoauthconfig/view_list.htm', 'tenantoauthconfig', 2, 133),
	(139, '2020-03-23 18:18:18', NULL, '1,2,6', '2020-03-23 18:18:18', 3, 9, '友情链接分类管理', 10, 0, 0, 'fa  fa-link', 6, NULL, 'admin/linktype/view_list.htm', 'linktype', 2, 133),
	(140, '2020-03-23 18:18:18', NULL, '1,2,7', '2020-03-23 18:18:18', 3, 11, '友情链接管理', 12, 0, 0, 'fa  fa-link', 7, NULL, 'admin/link/view_list.htm', 'link', 2, 133),
	(141, '2020-03-23 18:18:18', NULL, '1,2,8', '2020-03-23 18:18:18', 3, 13, '角色分类配置', 14, 0, 0, 'fa  fa-user-secret', 8, NULL, 'admin/userrolecatalog/view_list.htm', 'userrolecatalog', 2, 133),
	(142, '2020-03-23 18:18:18', NULL, '1,2,9', '2020-03-23 18:18:18', 3, 15, '移动app配置', 16, 0, 0, 'fa  fa-life-ring', 9, NULL, 'admin/app/view_list.htm', 'appversion', 2, 133),
	(143, '2020-03-23 18:18:18', NULL, '1,2,10', '2020-03-23 18:18:18', 3, 17, '网站主题配置', 18, 0, 0, 'fa  fa-sitemap', 10, NULL, 'admin/theme.htm', '10', 2, 133),
	(144, '2020-03-23 18:18:18', NULL, '1,2,11', '2020-03-23 18:18:18', 3, 19, '模板管理', 20, 0, 0, 'fa fa-circle-o', 11, NULL, 'admin/tmpl/view_list.htm', 'tmpl', 2, 133),
	(145, '2020-03-23 18:18:18', NULL, '1,2,47', '2020-03-23 18:18:18', 3, 23, '数据字典管理', 24, 0, 0, 'fa  fa-square', 47, NULL, 'admin/dictionary/view_list.htm', 'dictionary', 2, 133),
	(146, '2020-03-23 18:18:18', NULL, '1,92', '2020-03-23 18:18:18', 2, 168, '营销中心', 177, 100, 0, 'fa fa-circle-o', 92, NULL, '', '92', 2, 69),
	(147, '2020-03-23 18:18:18', NULL, '1,92,94', '2020-03-23 18:18:18', 3, 171, '营销活动', 172, 1, 0, 'fa fa-circle-o', 94, NULL, 'tenant/promote/view_list.htm', 'promote', 2, 146),
	(148, '2020-03-23 18:18:18', NULL, '1,92,93', '2020-03-23 18:18:18', 3, 169, '优惠卷管理', 170, 2, 0, 'fa fa-circle-o', 93, NULL, 'tenant/coupon/view_list.htm', 'coupon', 2, 146),
	(149, '2020-03-23 18:18:18', NULL, '1,117', '2020-03-23 18:18:18', 2, 208, '组织管理', 217, 100, 0, 'fa fa-circle-o', 117, NULL, '', '117', 2, 69),
	(150, '2020-03-23 18:18:18', NULL, '1,117,118', '2020-03-23 18:18:18', 3, 209, '组织管理', 210, 0, 0, 'fa fa-circle-o', 118, NULL, 'tenant/organization/view_list.htm', 'organization', 2, 149),
	(151, '2020-03-23 18:18:18', NULL, '1,117,119', '2020-03-23 18:18:18', 3, 211, '员工管理', 212, 0, 0, 'fa fa-circle-o', 119, NULL, 'tenant/employee/view_list.htm', 'employee', 2, 149),
	(152, '2020-03-23 18:18:18', NULL, '1,96', '2020-03-23 18:18:18', 2, 174, '配置中心', 187, 1000, 0, 'fa  fa-gear', 96, NULL, '', '96', 2, 69),
	(153, '2020-03-23 18:18:18', NULL, '1,96,97', '2020-03-23 18:18:18', 3, 175, '地区管理', 176, 0, 0, 'fa fa-circle-o', 97, NULL, 'tenant/tenantarea/view_list.htm', 'tenantarea', 2, 152),
	(154, '2020-03-23 18:18:18', NULL, '1,96,98', '2020-03-23 18:18:18', 3, 177, '角色管理', 178, 0, 0, 'fa fa-circle-o', 98, NULL, 'tenant/tenantuserrole/view_list.htm', 'tenantuserrole', 2, 152),
	(155, '2020-03-23 18:18:18', NULL, '1,96,99', '2020-03-23 18:18:18', 3, 179, '数据字典', 180, 0, 0, 'fa fa-circle-o', 99, NULL, 'tenant/tenantdictionary/view_list.htm', 'tenantdictionary', 2, 152);
/*!40000 ALTER TABLE `sys_tenant_menu` ENABLE KEYS */;

-- 导出  表 b2bcloud.sys_trade_account 结构
DROP TABLE IF EXISTS `sys_trade_account`;
CREATE TABLE IF NOT EXISTS `sys_trade_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `accountType` int(11) DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `checkValue` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.sys_trade_account 的数据：~24 rows (大约)
DELETE FROM `sys_trade_account`;
/*!40000 ALTER TABLE `sys_trade_account` DISABLE KEYS */;
INSERT INTO `sys_trade_account` (`id`, `addDate`, `lastDate`, `accountType`, `amount`, `checkValue`, `salt`) VALUES
	(1, '2020-04-22 10:23:21', '2020-04-22 10:23:21', 1, 1.00, 'e23e0c923a38c30026ffdf934bab5e4b955d4930', '11be9e25642678e2'),
	(2, '2020-04-22 10:23:21', '2020-06-10 17:40:30', 1, -8125.00, '80764f67eeffc4e7452dd288577addb916208e5e', 'b156bfe768381db9'),
	(3, '2020-04-22 10:24:12', '2020-04-25 11:58:41', 1, -11.00, '208750c665203e1e357d482a00ad7b15e01d6614', '09d4fd02a745f533'),
	(4, '2020-04-24 11:13:22', '2020-04-25 12:10:33', 1, 8009.00, 'ea0a759a02140216388f0ec1e67a635b9cd2b4d9', '59e5a1a2ab4d6af8'),
	(5, '2020-04-25 10:37:31', '2020-04-25 10:37:43', 0, 3.00, 'b6cf8a2d0c34806d3734a893db732d5d091a3347', 'c45b41d8a33b5c62'),
	(6, '2020-04-25 10:37:31', '2020-06-10 17:41:02', 1, -16.00, '38b885d90734f7cfe360440bc5b33a0a8e26d377', '907a09983d52cb00'),
	(7, '2020-04-25 11:54:25', '2020-04-25 11:54:25', 0, 1.00, 'b9f0b03a43a971a032f20fe3a99e5db359a1fb0d', '76d7d2e9430cf040'),
	(8, '2020-04-25 11:54:25', '2020-06-10 17:41:13', 1, -12.00, '830813d6a59064d2079903095b170252b88aa478', '315611da87da283f'),
	(9, '2020-04-25 11:54:32', '2020-04-25 11:54:45', 0, 5.00, '4eb158c0dc56ed5b29585bcdcafaff855aa0ccf0', '65e05e545ca3e7cd'),
	(10, '2020-04-25 11:54:36', '2020-04-25 11:54:36', 0, 2.00, 'a69ba9cd79fe4ea391056525910dd72881686132', '075b7dfdf890e1dc'),
	(11, '2020-04-25 11:54:55', '2020-04-25 11:54:55', 0, 1.00, 'cf2fa6f912e227a49435b1ca3bcf475455323af2', '831ef6c923aac9e3'),
	(12, '2020-04-25 11:55:41', '2020-04-25 11:56:18', 1, 12.00, '8da49f60a961de47c5e8c80b87c1d9df2b3f9022', '95e65964420ad69f'),
	(13, '2020-04-25 11:55:53', '2020-04-25 11:55:53', 1, -1.00, '015672d021539c1c6581e3f4b4e91691f1dbf432', '86acc562ba1d4820'),
	(14, '2020-04-25 11:56:36', '2020-04-25 11:57:22', 1, -1.00, '1e9150f6564b9ea0639943cfbc87624578f13d13', 'a78f3ad7e66c7686'),
	(15, '2020-04-25 11:59:05', '2020-04-25 11:59:05', 0, 1.00, 'ac19662814cd832649bc8f71b50a2d41730fc723', '240972db0fab5db1'),
	(16, '2020-04-25 11:59:17', '2020-04-25 11:59:17', 0, 1.00, '2e9541bf1d2b8f7c23b6a1909cc0373e900acf85', '0bae9d9fedb3f538'),
	(17, '2020-04-25 12:01:14', '2020-04-25 12:01:31', 1, 1.00, '1925ff3b0fafd88c87cf1fc92ba949ec0ffa33c4', '8638f099fe1fe67c'),
	(18, '2020-04-25 12:01:43', '2020-04-25 12:01:52', 1, 2.00, 'e24a86e735068647878ddc692e124555965ba10f', 'ce5b9a7ed25ff284'),
	(19, '2020-04-25 12:02:35', '2020-04-25 12:02:35', 0, 1.00, 'c477b5b76ea152c19341960f3f1d154583db8614', '0548ba30211a79ff'),
	(20, '2020-04-25 12:05:47', '2020-04-25 12:05:53', 0, 2.00, 'cad5c313fe15a732cf6a3883df1e458a07bbab85', '5a36d16a059c07b1'),
	(21, '2020-05-03 11:21:55', '2020-05-03 11:22:03', 1, 112.00, '6bc3004fd5665e62d1a653986596bd4ce61009ee', 'f9a6fc6c434d6f86'),
	(25, '2020-06-10 16:57:37', '2020-06-10 17:41:13', 0, 1.00, '0eda64805a227d8520c222884c08595b19fe2dfc', 'ccd8a6c181187078'),
	(26, '2020-06-10 16:57:37', '2020-06-10 17:41:02', 0, 10.00, '417f6d0ed2dc02d4db9314e14c7d1731aed5518b', '73af3c0bd8af85d3'),
	(27, '2020-06-10 16:57:37', '2020-06-10 16:57:37', 0, 0.00, '7edf07d06cc4c6e2e17ffb92326e52e2d6c7be78', 'dec40c4efefccfba'),
	(28, '2020-06-10 16:57:37', '2020-06-13 22:39:00', 0, 1.03, '37b6b45828c2960f0f526e3238f5b9d38a00fb39', '461a761cb6f002fb'),
	(29, '2020-06-10 18:31:49', '2020-06-13 22:39:00', 1, -0.03, '56d108cf5b7cb1a1d286096aa9886ed5d6cd42a0', 'b7a63ad4777f7612');
/*!40000 ALTER TABLE `sys_trade_account` ENABLE KEYS */;

-- 导出  表 b2bcloud.sys_trade_account_exception 结构
DROP TABLE IF EXISTS `sys_trade_account_exception`;
CREATE TABLE IF NOT EXISTS `sys_trade_account_exception` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `checkValue` varchar(255) DEFAULT NULL,
  `oldAmount` decimal(19,2) DEFAULT NULL,
  `oldCheckValue` varchar(255) DEFAULT NULL,
  `oldSalt` varchar(255) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1m0rkqckvet4dpba4iobom9bd` (`account_id`),
  CONSTRAINT `FK1m0rkqckvet4dpba4iobom9bd` FOREIGN KEY (`account_id`) REFERENCES `sys_trade_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.sys_trade_account_exception 的数据：~0 rows (大约)
DELETE FROM `sys_trade_account_exception`;
/*!40000 ALTER TABLE `sys_trade_account_exception` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_trade_account_exception` ENABLE KEYS */;

-- 导出  表 b2bcloud.sys_trade_basic_account 结构
DROP TABLE IF EXISTS `sys_trade_basic_account`;
CREATE TABLE IF NOT EXISTS `sys_trade_basic_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `trade_key` varchar(50) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4q8hs8tl45tbgj7dwkbfxwvkm` (`trade_key`),
  KEY `FKgcc5jsy2cexdiwknpv3ms8h3e` (`account_id`),
  CONSTRAINT `FKgcc5jsy2cexdiwknpv3ms8h3e` FOREIGN KEY (`account_id`) REFERENCES `sys_trade_account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.sys_trade_basic_account 的数据：~2 rows (大约)
DELETE FROM `sys_trade_basic_account`;
/*!40000 ALTER TABLE `sys_trade_basic_account` DISABLE KEYS */;
INSERT INTO `sys_trade_basic_account` (`id`, `addDate`, `lastDate`, `trade_key`, `account_id`) VALUES
	(1, '2020-04-22 10:23:21', '2020-04-22 10:23:21', 'recharge', 2),
	(2, '2020-04-25 10:37:31', '2020-04-25 10:37:31', 'score', 6),
	(3, '2020-04-25 11:54:25', '2020-04-25 11:54:25', 'fee', 8),
	(4, '2020-06-10 18:31:49', '2020-06-10 18:31:49', 'payment', 29);
/*!40000 ALTER TABLE `sys_trade_basic_account` ENABLE KEYS */;

-- 导出  表 b2bcloud.sys_trade_info 结构
DROP TABLE IF EXISTS `sys_trade_info`;
CREATE TABLE IF NOT EXISTS `sys_trade_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `from_id` bigint(20) DEFAULT NULL,
  `to_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb00j1ko828ceh39r74r9ajn9l` (`from_id`),
  KEY `FK25kmhmgd3vpnkrove9gjt06vq` (`to_id`),
  CONSTRAINT `FK25kmhmgd3vpnkrove9gjt06vq` FOREIGN KEY (`to_id`) REFERENCES `sys_trade_account` (`id`),
  CONSTRAINT `FKb00j1ko828ceh39r74r9ajn9l` FOREIGN KEY (`from_id`) REFERENCES `sys_trade_account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.sys_trade_info 的数据：~45 rows (大约)
DELETE FROM `sys_trade_info`;
/*!40000 ALTER TABLE `sys_trade_info` DISABLE KEYS */;
INSERT INTO `sys_trade_info` (`id`, `addDate`, `lastDate`, `amount`, `from_id`, `to_id`) VALUES
	(1, '2020-04-22 10:23:21', '2020-04-22 10:23:21', 1.00, 2, 1),
	(2, '2020-04-22 10:24:12', '2020-04-22 10:24:12', 1.00, 3, 2),
	(3, '2020-04-22 10:24:21', '2020-04-22 10:24:21', 12.00, 3, 2),
	(4, '2020-04-24 11:13:22', '2020-04-24 11:13:22', 10000.00, 2, 4),
	(5, '2020-04-25 10:36:49', '2020-04-25 10:36:49', 2000.00, 4, 2),
	(6, '2020-04-25 10:37:35', '2020-04-25 10:37:35', 1.00, 6, 5),
	(7, '2020-04-25 10:37:43', '2020-04-25 10:37:43', 2.00, 6, 5),
	(8, '2020-04-25 11:54:25', '2020-04-25 11:54:25', 1.00, 8, 7),
	(9, '2020-04-25 11:54:32', '2020-04-25 11:54:32', 2.00, 8, 9),
	(10, '2020-04-25 11:54:36', '2020-04-25 11:54:36', 2.00, 8, 10),
	(11, '2020-04-25 11:54:39', '2020-04-25 11:54:39', 2.00, 8, 9),
	(12, '2020-04-25 11:54:42', '2020-04-25 11:54:42', 2.00, 8, 9),
	(13, '2020-04-25 11:54:45', '2020-04-25 11:54:45', 1.00, 9, 8),
	(14, '2020-04-25 11:54:55', '2020-04-25 11:54:55', 1.00, 6, 11),
	(15, '2020-04-25 11:55:17', '2020-04-25 11:55:17', 2.00, 2, 4),
	(16, '2020-04-25 11:55:42', '2020-04-25 11:55:42', 11.00, 2, 12),
	(17, '2020-04-25 11:55:53', '2020-04-25 11:55:53', 1.00, 13, 2),
	(18, '2020-04-25 11:56:18', '2020-04-25 11:56:18', 1.00, 2, 12),
	(19, '2020-04-25 11:56:36', '2020-04-25 11:56:36', 1.00, 2, 14),
	(20, '2020-04-25 11:56:50', '2020-04-25 11:56:50', 1.00, 14, 2),
	(21, '2020-04-25 11:57:22', '2020-04-25 11:57:22', 1.00, 14, 2),
	(22, '2020-04-25 11:58:29', '2020-04-25 11:58:29', 1.00, 2, 3),
	(23, '2020-04-25 11:58:41', '2020-04-25 11:58:41', 1.00, 2, 3),
	(24, '2020-04-25 11:59:05', '2020-04-25 11:59:05', 1.00, 6, 15),
	(25, '2020-04-25 11:59:17', '2020-04-25 11:59:17', 1.00, 6, 16),
	(26, '2020-04-25 12:01:14', '2020-04-25 12:01:14', 1.00, 2, 17),
	(27, '2020-04-25 12:01:23', '2020-04-25 12:01:23', 1.00, 17, 2),
	(28, '2020-04-25 12:01:31', '2020-04-25 12:01:31', 1.00, 2, 17),
	(29, '2020-04-25 12:01:43', '2020-04-25 12:01:43', 1.00, 2, 18),
	(30, '2020-04-25 12:01:52', '2020-04-25 12:01:52', 1.00, 2, 18),
	(31, '2020-04-25 12:02:35', '2020-04-25 12:02:35', 1.00, 8, 19),
	(32, '2020-04-25 12:05:47', '2020-04-25 12:05:47', 1.00, 8, 20),
	(33, '2020-04-25 12:05:50', '2020-04-25 12:05:50', 1.00, 20, 8),
	(34, '2020-04-25 12:05:53', '2020-04-25 12:05:53', 2.00, 8, 20),
	(35, '2020-04-25 12:09:57', '2020-04-25 12:09:57', 1.00, 2, 4),
	(36, '2020-04-25 12:10:01', '2020-04-25 12:10:01', 1.00, 2, 4),
	(37, '2020-04-25 12:10:05', '2020-04-25 12:10:05', 1.00, 2, 4),
	(38, '2020-04-25 12:10:08', '2020-04-25 12:10:08', 1.00, 2, 4),
	(39, '2020-04-25 12:10:13', '2020-04-25 12:10:13', 1.00, 2, 4),
	(40, '2020-04-25 12:10:16', '2020-04-25 12:10:16', 1.00, 2, 4),
	(41, '2020-04-25 12:10:21', '2020-04-25 12:10:21', 1.00, 4, 2),
	(42, '2020-04-25 12:10:30', '2020-04-25 12:10:30', 1.00, 2, 4),
	(43, '2020-04-25 12:10:33', '2020-04-25 12:10:33', 1.00, 2, 4),
	(44, '2020-05-03 11:21:55', '2020-05-03 11:21:55', 1.00, 2, 21),
	(45, '2020-05-03 11:22:03', '2020-05-03 11:22:03', 111.00, 2, 21),
	(46, '2020-06-10 17:40:30', '2020-06-10 17:40:30', 1.00, 2, 28),
	(47, '2020-06-10 17:40:50', '2020-06-10 17:40:50', 1.00, 6, 26),
	(48, '2020-06-10 17:40:58', '2020-06-10 17:40:58', 1.00, 26, 6),
	(49, '2020-06-10 17:41:02', '2020-06-10 17:41:02', 10.00, 6, 26),
	(50, '2020-06-10 17:41:13', '2020-06-10 17:41:13', 1.00, 8, 25),
	(51, '2020-06-10 18:31:49', '2020-06-10 18:31:49', 0.01, 29, 28),
	(52, '2020-06-11 10:47:22', '2020-06-11 10:47:22', 0.01, 29, 28),
	(53, '2020-06-13 22:39:00', '2020-06-13 22:39:00', 0.01, 29, 28);
/*!40000 ALTER TABLE `sys_trade_info` ENABLE KEYS */;

-- 导出  表 b2bcloud.sys_trade_stream 结构
DROP TABLE IF EXISTS `sys_trade_stream`;
CREATE TABLE IF NOT EXISTS `sys_trade_stream` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `afterAmount` decimal(19,2) DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `changeType` int(11) DEFAULT NULL,
  `note` varchar(100) DEFAULT NULL,
  `preAmount` decimal(19,2) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `info_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK499th7tpww7kwgkd9btfexq36` (`account_id`),
  KEY `FK7k0ohx0lf7nf4quc4cgisxpo` (`info_id`),
  CONSTRAINT `FK499th7tpww7kwgkd9btfexq36` FOREIGN KEY (`account_id`) REFERENCES `sys_trade_account` (`id`),
  CONSTRAINT `FK7k0ohx0lf7nf4quc4cgisxpo` FOREIGN KEY (`info_id`) REFERENCES `sys_trade_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.sys_trade_stream 的数据：~102 rows (大约)
DELETE FROM `sys_trade_stream`;
/*!40000 ALTER TABLE `sys_trade_stream` DISABLE KEYS */;
INSERT INTO `sys_trade_stream` (`id`, `addDate`, `lastDate`, `afterAmount`, `amount`, `changeType`, `note`, `preAmount`, `account_id`, `info_id`) VALUES
	(1, '2020-04-22 10:23:21', '2020-04-22 10:23:21', -1.00, -1.00, 1, '', 0.00, 2, 1),
	(2, '2020-04-22 10:23:21', '2020-04-22 10:23:21', 1.00, 1.00, 1, '', 0.00, 1, 1),
	(3, '2020-04-22 10:24:12', '2020-04-22 10:24:12', -1.00, -1.00, 1, '2', 0.00, 3, 2),
	(4, '2020-04-22 10:24:12', '2020-04-22 10:24:12', 0.00, 1.00, 1, '2', -1.00, 2, 2),
	(5, '2020-04-22 10:24:21', '2020-04-22 10:24:21', -13.00, -12.00, 1, '2', -1.00, 3, 3),
	(6, '2020-04-22 10:24:21', '2020-04-22 10:24:21', 12.00, 12.00, 1, '2', 0.00, 2, 3),
	(7, '2020-04-24 11:13:22', '2020-04-24 11:13:22', -9988.00, -10000.00, 1, '', 12.00, 2, 4),
	(8, '2020-04-24 11:13:22', '2020-04-24 11:13:22', 10000.00, 10000.00, 1, '', 0.00, 4, 4),
	(9, '2020-04-25 10:36:49', '2020-04-25 10:36:49', 8000.00, -2000.00, 1, '1', 10000.00, 4, 5),
	(10, '2020-04-25 10:36:49', '2020-04-25 10:36:49', -7988.00, 2000.00, 1, '1', -9988.00, 2, 5),
	(11, '2020-04-25 10:37:35', '2020-04-25 10:37:35', -1.00, -1.00, 1001, '1', 0.00, 6, 6),
	(12, '2020-04-25 10:37:35', '2020-04-25 10:37:35', 1.00, 1.00, 1001, '1', 0.00, 5, 6),
	(13, '2020-04-25 10:37:43', '2020-04-25 10:37:43', -3.00, -2.00, 1001, '2', -1.00, 6, 7),
	(14, '2020-04-25 10:37:43', '2020-04-25 10:37:43', 3.00, 2.00, 1001, '2', 1.00, 5, 7),
	(15, '2020-04-25 11:54:25', '2020-04-25 11:54:25', -1.00, -1.00, 1001, '1', 0.00, 8, 8),
	(16, '2020-04-25 11:54:25', '2020-04-25 11:54:25', 1.00, 1.00, 1001, '1', 0.00, 7, 8),
	(17, '2020-04-25 11:54:32', '2020-04-25 11:54:32', -3.00, -2.00, 1001, '2', -1.00, 8, 9),
	(18, '2020-04-25 11:54:32', '2020-04-25 11:54:32', 2.00, 2.00, 1001, '2', 0.00, 9, 9),
	(19, '2020-04-25 11:54:36', '2020-04-25 11:54:36', -5.00, -2.00, 1001, '2', -3.00, 8, 10),
	(20, '2020-04-25 11:54:36', '2020-04-25 11:54:36', 2.00, 2.00, 1001, '2', 0.00, 10, 10),
	(21, '2020-04-25 11:54:39', '2020-04-25 11:54:39', -7.00, -2.00, 1001, '2', -5.00, 8, 11),
	(22, '2020-04-25 11:54:39', '2020-04-25 11:54:39', 4.00, 2.00, 1001, '2', 2.00, 9, 11),
	(23, '2020-04-25 11:54:42', '2020-04-25 11:54:42', -9.00, -2.00, 1001, '2', -7.00, 8, 12),
	(24, '2020-04-25 11:54:42', '2020-04-25 11:54:42', 6.00, 2.00, 1001, '2', 4.00, 9, 12),
	(25, '2020-04-25 11:54:45', '2020-04-25 11:54:45', 5.00, -1.00, 1001, '1', 6.00, 9, 13),
	(26, '2020-04-25 11:54:45', '2020-04-25 11:54:45', -8.00, 1.00, 1001, '1', -9.00, 8, 13),
	(27, '2020-04-25 11:54:55', '2020-04-25 11:54:55', -4.00, -1.00, 1001, '12', -3.00, 6, 14),
	(28, '2020-04-25 11:54:55', '2020-04-25 11:54:55', 1.00, 1.00, 1001, '12', 0.00, 11, 14),
	(29, '2020-04-25 11:55:17', '2020-04-25 11:55:17', -7990.00, -2.00, 1, '222222222222222222222222222222', -7988.00, 2, 15),
	(30, '2020-04-25 11:55:17', '2020-04-25 11:55:17', 8002.00, 2.00, 1, '222222222222222222222222222222', 8000.00, 4, 15),
	(31, '2020-04-25 11:55:42', '2020-04-25 11:55:42', -8001.00, -11.00, 1, '2', -7990.00, 2, 16),
	(32, '2020-04-25 11:55:42', '2020-04-25 11:55:42', 11.00, 11.00, 1, '2', 0.00, 12, 16),
	(33, '2020-04-25 11:55:53', '2020-04-25 11:55:53', -1.00, -1.00, 1, '1', 0.00, 13, 17),
	(34, '2020-04-25 11:55:53', '2020-04-25 11:55:53', -8000.00, 1.00, 1, '1', -8001.00, 2, 17),
	(35, '2020-04-25 11:56:18', '2020-04-25 11:56:18', -8001.00, -1.00, 1, '1', -8000.00, 2, 18),
	(36, '2020-04-25 11:56:18', '2020-04-25 11:56:18', 12.00, 1.00, 1, '1', 11.00, 12, 18),
	(37, '2020-04-25 11:56:36', '2020-04-25 11:56:36', -8002.00, -1.00, 1, '1', -8001.00, 2, 19),
	(38, '2020-04-25 11:56:36', '2020-04-25 11:56:36', 1.00, 1.00, 1, '1', 0.00, 14, 19),
	(39, '2020-04-25 11:56:50', '2020-04-25 11:56:50', 0.00, -1.00, 1, '1', 1.00, 14, 20),
	(40, '2020-04-25 11:56:50', '2020-04-25 11:56:50', -8001.00, 1.00, 1, '1', -8002.00, 2, 20),
	(41, '2020-04-25 11:57:22', '2020-04-25 11:57:22', -1.00, -1.00, 1, '2', 0.00, 14, 21),
	(42, '2020-04-25 11:57:22', '2020-04-25 11:57:22', -8000.00, 1.00, 1, '2', -8001.00, 2, 21),
	(43, '2020-04-25 11:58:29', '2020-04-25 11:58:29', -8001.00, -1.00, 1, '1', -8000.00, 2, 22),
	(44, '2020-04-25 11:58:29', '2020-04-25 11:58:29', -12.00, 1.00, 1, '1', -13.00, 3, 22),
	(45, '2020-04-25 11:58:41', '2020-04-25 11:58:41', -8002.00, -1.00, 1, '1', -8001.00, 2, 23),
	(46, '2020-04-25 11:58:41', '2020-04-25 11:58:41', -11.00, 1.00, 1, '1', -12.00, 3, 23),
	(47, '2020-04-25 11:59:05', '2020-04-25 11:59:05', -5.00, -1.00, 1001, '1', -4.00, 6, 24),
	(48, '2020-04-25 11:59:05', '2020-04-25 11:59:05', 1.00, 1.00, 1001, '1', 0.00, 15, 24),
	(49, '2020-04-25 11:59:17', '2020-04-25 11:59:17', -6.00, -1.00, 1001, '1', -5.00, 6, 25),
	(50, '2020-04-25 11:59:17', '2020-04-25 11:59:17', 1.00, 1.00, 1001, '1', 0.00, 16, 25),
	(51, '2020-04-25 12:01:14', '2020-04-25 12:01:14', -8003.00, -1.00, 1, '1', -8002.00, 2, 26),
	(52, '2020-04-25 12:01:14', '2020-04-25 12:01:14', 1.00, 1.00, 1, '1', 0.00, 17, 26),
	(53, '2020-04-25 12:01:23', '2020-04-25 12:01:23', 0.00, -1.00, 1, '1', 1.00, 17, 27),
	(54, '2020-04-25 12:01:23', '2020-04-25 12:01:23', -8002.00, 1.00, 1, '1', -8003.00, 2, 27),
	(55, '2020-04-25 12:01:31', '2020-04-25 12:01:31', -8003.00, -1.00, 1, '1', -8002.00, 2, 28),
	(56, '2020-04-25 12:01:31', '2020-04-25 12:01:31', 1.00, 1.00, 1, '1', 0.00, 17, 28),
	(57, '2020-04-25 12:01:43', '2020-04-25 12:01:43', -8004.00, -1.00, 1, '1', -8003.00, 2, 29),
	(58, '2020-04-25 12:01:43', '2020-04-25 12:01:43', 1.00, 1.00, 1, '1', 0.00, 18, 29),
	(59, '2020-04-25 12:01:52', '2020-04-25 12:01:52', -8005.00, -1.00, 1, '1', -8004.00, 2, 30),
	(60, '2020-04-25 12:01:52', '2020-04-25 12:01:52', 2.00, 1.00, 1, '1', 1.00, 18, 30),
	(61, '2020-04-25 12:02:35', '2020-04-25 12:02:35', -9.00, -1.00, 1001, '1', -8.00, 8, 31),
	(62, '2020-04-25 12:02:35', '2020-04-25 12:02:35', 1.00, 1.00, 1001, '1', 0.00, 19, 31),
	(63, '2020-04-25 12:05:47', '2020-04-25 12:05:47', -10.00, -1.00, 1001, '1', -9.00, 8, 32),
	(64, '2020-04-25 12:05:47', '2020-04-25 12:05:47', 1.00, 1.00, 1001, '1', 0.00, 20, 32),
	(65, '2020-04-25 12:05:50', '2020-04-25 12:05:50', 0.00, -1.00, 1001, '1', 1.00, 20, 33),
	(66, '2020-04-25 12:05:50', '2020-04-25 12:05:50', -9.00, 1.00, 1001, '1', -10.00, 8, 33),
	(67, '2020-04-25 12:05:53', '2020-04-25 12:05:53', -11.00, -2.00, 1001, '2', -9.00, 8, 34),
	(68, '2020-04-25 12:05:53', '2020-04-25 12:05:53', 2.00, 2.00, 1001, '2', 0.00, 20, 34),
	(69, '2020-04-25 12:09:57', '2020-04-25 12:09:57', -8006.00, -1.00, 1, '1', -8005.00, 2, 35),
	(70, '2020-04-25 12:09:57', '2020-04-25 12:09:57', 8003.00, 1.00, 1, '1', 8002.00, 4, 35),
	(71, '2020-04-25 12:10:01', '2020-04-25 12:10:01', -8007.00, -1.00, 1, '1', -8006.00, 2, 36),
	(72, '2020-04-25 12:10:01', '2020-04-25 12:10:01', 8004.00, 1.00, 1, '1', 8003.00, 4, 36),
	(73, '2020-04-25 12:10:05', '2020-04-25 12:10:05', -8008.00, -1.00, 1, '1', -8007.00, 2, 37),
	(74, '2020-04-25 12:10:05', '2020-04-25 12:10:05', 8005.00, 1.00, 1, '1', 8004.00, 4, 37),
	(75, '2020-04-25 12:10:08', '2020-04-25 12:10:08', -8009.00, -1.00, 1, '1', -8008.00, 2, 38),
	(76, '2020-04-25 12:10:08', '2020-04-25 12:10:08', 8006.00, 1.00, 1, '1', 8005.00, 4, 38),
	(77, '2020-04-25 12:10:13', '2020-04-25 12:10:13', -8010.00, -1.00, 1, '1', -8009.00, 2, 39),
	(78, '2020-04-25 12:10:13', '2020-04-25 12:10:13', 8007.00, 1.00, 1, '1', 8006.00, 4, 39),
	(79, '2020-04-25 12:10:16', '2020-04-25 12:10:16', -8011.00, -1.00, 1, '1', -8010.00, 2, 40),
	(80, '2020-04-25 12:10:16', '2020-04-25 12:10:16', 8008.00, 1.00, 1, '1', 8007.00, 4, 40),
	(81, '2020-04-25 12:10:21', '2020-04-25 12:10:21', 8007.00, -1.00, 1, '2', 8008.00, 4, 41),
	(82, '2020-04-25 12:10:21', '2020-04-25 12:10:21', -8010.00, 1.00, 1, '2', -8011.00, 2, 41),
	(83, '2020-04-25 12:10:30', '2020-04-25 12:10:30', -8011.00, -1.00, 1, '1', -8010.00, 2, 42),
	(84, '2020-04-25 12:10:30', '2020-04-25 12:10:30', 8008.00, 1.00, 1, '1', 8007.00, 4, 42),
	(85, '2020-04-25 12:10:33', '2020-04-25 12:10:33', -8012.00, -1.00, 1, '1', -8011.00, 2, 43),
	(86, '2020-04-25 12:10:33', '2020-04-25 12:10:33', 8009.00, 1.00, 1, '1', 8008.00, 4, 43),
	(87, '2020-05-03 11:21:55', '2020-05-03 11:21:55', -8013.00, -1.00, 1, '1', -8012.00, 2, 44),
	(88, '2020-05-03 11:21:55', '2020-05-03 11:21:55', 1.00, 1.00, 1, '1', 0.00, 21, 44),
	(89, '2020-05-03 11:22:03', '2020-05-03 11:22:03', -8124.00, -111.00, 1, '11', -8013.00, 2, 45),
	(90, '2020-05-03 11:22:03', '2020-05-03 11:22:03', 112.00, 111.00, 1, '11', 1.00, 21, 45),
	(91, '2020-06-10 17:40:30', '2020-06-10 17:40:30', -8125.00, -1.00, 1, '充值', -8124.00, 2, 46),
	(92, '2020-06-10 17:40:30', '2020-06-10 17:40:30', 1.00, 1.00, 1, '充值', 0.00, 28, 46),
	(93, '2020-06-10 17:40:50', '2020-06-10 17:40:50', -7.00, -1.00, 1001, '1', -6.00, 6, 47),
	(94, '2020-06-10 17:40:50', '2020-06-10 17:40:50', 1.00, 1.00, 1001, '1', 0.00, 26, 47),
	(95, '2020-06-10 17:40:58', '2020-06-10 17:40:58', 0.00, -1.00, 1001, '1', 1.00, 26, 48),
	(96, '2020-06-10 17:40:58', '2020-06-10 17:40:58', -6.00, 1.00, 1001, '1', -7.00, 6, 48),
	(97, '2020-06-10 17:41:02', '2020-06-10 17:41:02', -16.00, -10.00, 1001, '1', -6.00, 6, 49),
	(98, '2020-06-10 17:41:02', '2020-06-10 17:41:02', 10.00, 10.00, 1001, '1', 0.00, 26, 49),
	(99, '2020-06-10 17:41:13', '2020-06-10 17:41:13', -12.00, -1.00, 1001, '初始化', -11.00, 8, 50),
	(100, '2020-06-10 17:41:13', '2020-06-10 17:41:13', 1.00, 1.00, 1001, '初始化', 0.00, 25, 50),
	(101, '2020-06-10 18:31:49', '2020-06-10 18:31:49', -0.01, -0.01, 1, '充值', 0.00, 29, 51),
	(102, '2020-06-10 18:31:49', '2020-06-10 18:31:49', 1.01, 0.01, 1, '充值', 1.00, 28, 51),
	(103, '2020-06-11 10:47:22', '2020-06-11 10:47:22', -0.02, -0.01, 1, '充值', -0.01, 29, 52),
	(104, '2020-06-11 10:47:22', '2020-06-11 10:47:22', 1.02, 0.01, 1, '充值', 1.01, 28, 52),
	(105, '2020-06-13 22:39:00', '2020-06-13 22:39:00', -0.03, -0.01, 1, '充值', -0.02, 29, 53),
	(106, '2020-06-13 22:39:00', '2020-06-13 22:39:00', 1.03, 0.01, 1, '充值', 1.02, 28, 53);
/*!40000 ALTER TABLE `sys_trade_stream` ENABLE KEYS */;

-- 导出  表 b2bcloud.sys_trade_user_account 结构
DROP TABLE IF EXISTS `sys_trade_user_account`;
CREATE TABLE IF NOT EXISTS `sys_trade_user_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `trade_key` varchar(50) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqn3g3ql33vkvanib5187iybht` (`account_id`),
  KEY `FK38tgxi15323dcrllbgb9pbxf6` (`user_id`),
  CONSTRAINT `FK38tgxi15323dcrllbgb9pbxf6` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`),
  CONSTRAINT `FKqn3g3ql33vkvanib5187iybht` FOREIGN KEY (`account_id`) REFERENCES `sys_trade_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.sys_trade_user_account 的数据：~0 rows (大约)
DELETE FROM `sys_trade_user_account`;
/*!40000 ALTER TABLE `sys_trade_user_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_trade_user_account` ENABLE KEYS */;

-- 导出  表 b2bcloud.task 结构
DROP TABLE IF EXISTS `task`;
CREATE TABLE IF NOT EXISTS `task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `cron` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `nums` bigint(20) DEFAULT NULL,
  `recordState` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `nextDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqpj60iiafuf9b7dh5xtxoeusw` (`user_id`),
  CONSTRAINT `FKqpj60iiafuf9b7dh5xtxoeusw` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.task 的数据：~2 rows (大约)
DELETE FROM `task`;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` (`id`, `addDate`, `lastDate`, `cron`, `name`, `note`, `nums`, `recordState`, `state`, `url`, `user_id`, `nextDate`) VALUES
	(1, '2019-09-12 16:39:22', '2020-06-14 23:50:02', '1 50 23 * * ?', '测试', '11', 114398, 4, 1, 'https://api.maotouin.com/uinfo/crawler/sync_company_new.htm', NULL, '2020-05-08 23:50:01'),
	(2, '2020-03-23 20:14:01', '2020-06-15 10:38:45', '/5 * * * * ?', '五秒一次', '1', 1371317, 5, 1, 'http://file.metamall.cn', NULL, '2020-05-08 13:00:35');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;

-- 导出  表 b2bcloud.task_attribute 结构
DROP TABLE IF EXISTS `task_attribute`;
CREATE TABLE IF NOT EXISTS `task_attribute` (
  `task_id` bigint(20) NOT NULL,
  `attr` varchar(100) DEFAULT NULL,
  `name` varchar(36) NOT NULL,
  PRIMARY KEY (`task_id`,`name`),
  CONSTRAINT `FKkkpewueys70bcx84x9yd2dsec` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.task_attribute 的数据：~0 rows (大约)
DELETE FROM `task_attribute`;
/*!40000 ALTER TABLE `task_attribute` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_attribute` ENABLE KEYS */;

-- 导出  表 b2bcloud.task_record 结构
DROP TABLE IF EXISTS `task_record`;
CREATE TABLE IF NOT EXISTS `task_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `expensesTime` bigint(20) DEFAULT NULL,
  `note` varchar(20) DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhcsb7k9mkjpq63wpmfopg0tty` (`task_id`),
  CONSTRAINT `FKhcsb7k9mkjpq63wpmfopg0tty` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.task_record 的数据：~59 rows (大约)
DELETE FROM `task_record`;
/*!40000 ALTER TABLE `task_record` DISABLE KEYS */;
INSERT INTO `task_record` (`id`, `addDate`, `lastDate`, `expensesTime`, `note`, `task_id`) VALUES
	(1, '2019-09-12 16:39:24', '2019-09-12 16:39:24', 223, '', 1),
	(2, '2020-03-25 23:50:02', '2020-03-25 23:50:02', 606, '', 1),
	(3, '2020-03-28 23:50:01', '2020-03-28 23:50:01', 421, '', 1),
	(4, '2020-03-29 23:50:01', '2020-03-29 23:50:01', 249, '', 1),
	(5, '2020-03-30 23:50:02', '2020-03-30 23:50:02', 684, '', 1),
	(6, '2020-03-31 23:50:01', '2020-03-31 23:50:01', 360, '', 1),
	(7, '2020-04-01 23:50:01', '2020-04-01 23:50:01', 344, '', 1),
	(8, '2020-04-02 23:50:01', '2020-04-02 23:50:01', 222, '', 1),
	(9, '2020-04-03 23:50:01', '2020-04-03 23:50:01', 273, '', 1),
	(10, '2020-04-04 23:50:01', '2020-04-04 23:50:01', 296, '', 1),
	(11, '2020-04-05 23:50:01', '2020-04-05 23:50:01', 322, '', 1),
	(12, '2020-04-06 23:50:01', '2020-04-06 23:50:01', 293, '', 1),
	(13, '2020-04-07 23:50:01', '2020-04-07 23:50:01', 392, '', 1),
	(14, '2020-04-08 23:50:02', '2020-04-08 23:50:02', 673, '', 1),
	(15, '2020-04-09 23:50:01', '2020-04-09 23:50:01', 238, '', 1),
	(16, '2020-04-10 23:50:01', '2020-04-10 23:50:01', 279, '', 1),
	(17, '2020-04-11 23:50:01', '2020-04-11 23:50:01', 320, '', 1),
	(18, '2020-04-12 23:50:01', '2020-04-12 23:50:01', 303, '', 1),
	(19, '2020-04-13 23:50:01', '2020-04-13 23:50:01', 462, '', 1),
	(20, '2020-04-14 23:50:21', '2020-04-14 23:50:21', 20465, '', 1),
	(21, '2020-04-15 23:50:02', '2020-04-15 23:50:02', 487, '', 1),
	(22, '2020-04-16 23:50:01', '2020-04-16 23:50:01', 311, '', 1),
	(23, '2020-04-17 23:50:01', '2020-04-17 23:50:01', 350, '', 1),
	(24, '2020-04-18 23:50:01', '2020-04-18 23:50:01', 407, '', 1),
	(25, '2020-04-19 23:50:02', '2020-04-19 23:50:02', 518, '', 1),
	(26, '2020-04-20 23:50:01', '2020-04-20 23:50:01', 288, '', 1),
	(27, '2020-04-21 23:50:01', '2020-04-21 23:50:01', 429, '', 1),
	(28, '2020-04-22 23:50:01', '2020-04-22 23:50:01', 371, '', 1),
	(29, '2020-04-23 23:50:01', '2020-04-23 23:50:01', 439, '', 1),
	(30, '2020-04-24 23:50:02', '2020-04-24 23:50:02', 616, '', 1),
	(31, '2020-04-25 23:50:01', '2020-04-25 23:50:01', 319, '', 1),
	(32, '2020-04-26 23:50:01', '2020-04-26 23:50:01', 347, '', 1),
	(33, '2020-04-27 23:50:02', '2020-04-27 23:50:02', 789, '', 1),
	(34, '2020-04-28 23:50:01', '2020-04-28 23:50:01', 388, '', 1),
	(35, '2020-04-29 23:50:02', '2020-04-29 23:50:02', 544, '', 1),
	(36, '2020-04-30 23:50:02', '2020-04-30 23:50:02', 739, '', 1),
	(37, '2020-05-01 23:50:02', '2020-05-01 23:50:02', 783, '', 1),
	(38, '2020-05-02 23:50:02', '2020-05-02 23:50:02', 1227, '', 1),
	(39, '2020-05-03 23:50:02', '2020-05-03 23:50:02', 807, '', 1),
	(40, '2020-05-04 23:50:02', '2020-05-04 23:50:02', 902, '', 1),
	(41, '2020-05-05 23:50:01', '2020-05-05 23:50:01', 328, '', 1),
	(42, '2020-05-06 23:50:02', '2020-05-06 23:50:02', 677, '', 1),
	(43, '2020-05-07 23:50:02', '2020-05-07 23:50:02', 621, '', 1),
	(44, '2020-05-08 23:50:01', '2020-05-08 23:50:01', 379, '', 1),
	(45, '2020-05-09 23:50:01', '2020-05-09 23:50:01', 371, '', 1),
	(46, '2020-05-10 23:50:02', '2020-05-10 23:50:02', 749, '', 1),
	(47, '2020-05-11 23:50:01', '2020-05-11 23:50:01', 389, '', 1),
	(48, '2020-05-12 23:50:02', '2020-05-12 23:50:02', 515, '', 1),
	(49, '2020-05-13 23:50:02', '2020-05-13 23:50:02', 815, '', 1),
	(50, '2020-05-14 23:50:02', '2020-05-14 23:50:03', 636, '', 1),
	(51, '2020-05-15 23:50:01', '2020-05-15 23:50:01', 399, '', 1),
	(52, '2020-05-16 23:50:02', '2020-05-16 23:50:02', 791, '', 1),
	(53, '2020-05-17 23:50:02', '2020-05-17 23:50:02', 1136, '', 1),
	(54, '2020-05-18 23:50:02', '2020-05-18 23:50:02', 580, '', 1),
	(55, '2020-05-19 23:50:01', '2020-05-19 23:50:01', 303, '', 1),
	(56, '2020-05-20 23:50:02', '2020-05-20 23:50:02', 718, '', 1),
	(57, '2020-05-21 23:50:01', '2020-05-21 23:50:01', 347, '', 1),
	(58, '2020-05-22 23:50:02', '2020-05-22 23:50:02', 709, '', 1),
	(59, '2020-05-23 23:50:01', '2020-05-23 23:50:02', 469, '', 1),
	(60, '2020-05-24 23:50:02', '2020-05-24 23:50:02', 668, '', 1),
	(61, '2020-05-25 23:50:01', '2020-05-25 23:50:01', 368, '', 1),
	(62, '2020-05-26 23:50:02', '2020-05-26 23:50:02', 571, '', 1),
	(63, '2020-05-27 23:50:01', '2020-05-27 23:50:01', 360, '', 1),
	(64, '2020-05-28 23:50:01', '2020-05-28 23:50:01', 379, '', 1),
	(65, '2020-05-29 23:50:01', '2020-05-29 23:50:01', 300, '', 1),
	(66, '2020-05-30 23:50:02', '2020-05-30 23:50:02', 567, '', 1),
	(67, '2020-05-31 23:50:01', '2020-05-31 23:50:01', 361, '', 1),
	(68, '2020-06-01 23:50:01', '2020-06-01 23:50:01', 367, '', 1),
	(69, '2020-06-02 23:50:01', '2020-06-02 23:50:01', 471, '', 1),
	(70, '2020-06-03 23:50:02', '2020-06-03 23:50:02', 772, '', 1),
	(71, '2020-06-04 23:50:01', '2020-06-04 23:50:01', 347, '', 1),
	(72, '2020-06-05 23:50:02', '2020-06-05 23:50:02', 577, '', 1),
	(73, '2020-06-06 23:50:01', '2020-06-06 23:50:01', 345, '', 1),
	(74, '2020-06-07 23:50:01', '2020-06-07 23:50:01', 356, '', 1),
	(75, '2020-06-08 23:50:02', '2020-06-08 23:50:02', 590, '', 1),
	(76, '2020-06-09 23:50:02', '2020-06-09 23:50:02', 847, '', 1),
	(77, '2020-06-10 23:50:02', '2020-06-10 23:50:02', 1041, '', 1),
	(78, '2020-06-11 23:50:02', '2020-06-11 23:50:02', 681, '', 1),
	(79, '2020-06-12 23:50:02', '2020-06-12 23:50:02', 628, '', 1),
	(80, '2020-06-13 23:50:01', '2020-06-13 23:50:01', 363, '', 1),
	(81, '2020-06-14 23:50:02', '2020-06-14 23:50:02', 745, '', 1);
/*!40000 ALTER TABLE `task_record` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_account 结构
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE IF NOT EXISTS `user_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `accountType` int(11) DEFAULT NULL,
  `loginSize` int(11) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKloyhlvrn82g8811wyjaa8ehm0` (`user_id`),
  CONSTRAINT `FKloyhlvrn82g8811wyjaa8ehm0` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_account 的数据：~0 rows (大约)
DELETE FROM `user_account`;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_code 结构
DROP TABLE IF EXISTS `user_code`;
CREATE TABLE IF NOT EXISTS `user_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `loginSize` int(11) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfulmxb2y8nrres564ymc2kqr4` (`userid`),
  CONSTRAINT `FKfulmxb2y8nrres564ymc2kqr4` FOREIGN KEY (`userid`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_code 的数据：~0 rows (大约)
DELETE FROM `user_code`;
/*!40000 ALTER TABLE `user_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_code` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_feedback 结构
DROP TABLE IF EXISTS `user_feedback`;
CREATE TABLE IF NOT EXISTS `user_feedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `exts` varchar(5000) DEFAULT NULL,
  `feedContent` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(5000) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK16hwg5kemchnom1viytedumwr` (`user_id`),
  CONSTRAINT `FK16hwg5kemchnom1viytedumwr` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_feedback 的数据：~0 rows (大约)
DELETE FROM `user_feedback`;
/*!40000 ALTER TABLE `user_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_feedback` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_identification 结构
DROP TABLE IF EXISTS `user_identification`;
CREATE TABLE IF NOT EXISTS `user_identification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `bindType` int(11) DEFAULT NULL,
  `no` varchar(50) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh4c2qe2s2jyoq5gwl4sp09efn` (`user_id`),
  CONSTRAINT `FKh4c2qe2s2jyoq5gwl4sp09efn` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_identification 的数据：~10 rows (大约)
DELETE FROM `user_identification`;
/*!40000 ALTER TABLE `user_identification` DISABLE KEYS */;
INSERT INTO `user_identification` (`id`, `addDate`, `lastDate`, `bindType`, `no`, `user_id`) VALUES
	(1, '2018-12-01 10:26:11', '2018-12-01 10:26:11', 2, 'ada', 1),
	(2, '2018-12-01 10:26:23', '2018-12-01 10:26:23', 2, 'admin', 2),
	(9, '2019-09-12 16:03:06', '2019-09-12 16:03:06', 2, '3', 10),
	(10, '2019-09-12 16:03:06', '2019-09-12 16:03:06', 2, 't1', 11),
	(11, '2019-09-12 16:03:06', '2019-09-12 16:03:06', 2, 't2', 12),
	(12, '2019-09-12 16:03:06', '2019-09-12 16:03:06', 2, 't3', 13),
	(13, '2019-11-06 17:32:29', '2019-11-06 17:32:29', 2, 't5', 14),
	(14, '2019-11-07 23:20:42', '2019-11-07 23:20:42', 2, 'quhaodian', 15),
	(15, '2019-12-28 12:24:06', '2019-12-28 12:24:06', 2, 'b2', 16),
	(16, '2020-03-23 18:18:53', '2020-03-23 18:18:53', 2, 'b1', 17);
/*!40000 ALTER TABLE `user_identification` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_info 结构
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE IF NOT EXISTS `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `loginSize` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `edge` varchar(255) DEFAULT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `household_id` int(11) DEFAULT NULL,
  `companyName` varchar(30) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `job` varchar(20) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `storeState` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3193uu2asgocbhkk1mus5wfd7` (`household_id`),
  KEY `FK5osla9rjm07kbyi8wx7oq8qbs` (`account_id`),
  CONSTRAINT `FK3193uu2asgocbhkk1mus5wfd7` FOREIGN KEY (`household_id`) REFERENCES `area` (`id`),
  CONSTRAINT `FK5osla9rjm07kbyi8wx7oq8qbs` FOREIGN KEY (`account_id`) REFERENCES `sys_trade_account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_info 的数据：~10 rows (大约)
DELETE FROM `user_info`;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` (`id`, `addDate`, `lastDate`, `avatar`, `catalog`, `loginSize`, `name`, `phone`, `state`, `edge`, `introduce`, `note`, `sex`, `household_id`, `companyName`, `email`, `job`, `account_id`, `storeState`) VALUES
	(1, '2017-12-27 14:44:05', '2020-06-02 20:53:35', NULL, 0, 903, '管理员', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '2019-09-12 16:31:05', '2019-09-17 19:42:36', NULL, 0, 9, 'super', 'a', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(10, '2019-09-12 16:26:22', '2019-09-12 16:29:21', NULL, 0, 6, '333', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(11, '2019-11-06 17:41:57', '2019-11-06 23:12:39', NULL, 0, 54, 't1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(12, '2019-09-12 16:26:22', '2019-11-05 18:28:07', NULL, 0, 21, 't2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(13, '2019-09-12 16:26:22', '2019-09-12 16:29:21', NULL, 0, 6, 't3', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(14, '2019-11-06 17:40:50', '2019-11-20 10:47:15', NULL, 0, 81, '陈联高', 't5', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(15, '2019-11-07 23:20:42', '2019-11-17 18:20:58', NULL, NULL, 21, '陈联高', 'quhaodian', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(16, '2019-12-28 12:24:06', '2020-05-12 22:43:43', NULL, NULL, 650, '八爪鱼', 'b1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(17, '2020-03-23 18:18:53', '2020-06-13 22:14:10', NULL, NULL, 278, '陈坤', 'b2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_info_attribute 结构
DROP TABLE IF EXISTS `user_info_attribute`;
CREATE TABLE IF NOT EXISTS `user_info_attribute` (
  `user_id` bigint(20) NOT NULL,
  `attr` varchar(100) DEFAULT NULL,
  `name` varchar(36) NOT NULL,
  PRIMARY KEY (`user_id`,`name`),
  CONSTRAINT `FKjf8g1vng9lpmniy8u187j7t0` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_info_attribute 的数据：~0 rows (大约)
DELETE FROM `user_info_attribute`;
/*!40000 ALTER TABLE `user_info_attribute` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_info_attribute` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_label 结构
DROP TABLE IF EXISTS `user_label`;
CREATE TABLE IF NOT EXISTS `user_label` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_cal21cv5bdi7ee791jvtvji3t` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_label 的数据：~0 rows (大约)
DELETE FROM `user_label`;
/*!40000 ALTER TABLE `user_label` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_label` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_label_links 结构
DROP TABLE IF EXISTS `user_label_links`;
CREATE TABLE IF NOT EXISTS `user_label_links` (
  `user_id` bigint(20) NOT NULL,
  `labels_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`labels_id`),
  KEY `FKe69vxi1aiq7ww12d8pf03hrn1` (`labels_id`),
  CONSTRAINT `FK5njpwjktgb87ggnjm63vejdwc` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`),
  CONSTRAINT `FKe69vxi1aiq7ww12d8pf03hrn1` FOREIGN KEY (`labels_id`) REFERENCES `user_label` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_label_links 的数据：~0 rows (大约)
DELETE FROM `user_label_links`;
/*!40000 ALTER TABLE `user_label_links` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_label_links` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_lockout 结构
DROP TABLE IF EXISTS `user_lockout`;
CREATE TABLE IF NOT EXISTS `user_lockout` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `beginDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpb7diegkhtsskj1c8j5iq9ap5` (`user_id`),
  CONSTRAINT `FKpb7diegkhtsskj1c8j5iq9ap5` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_lockout 的数据：~0 rows (大约)
DELETE FROM `user_lockout`;
/*!40000 ALTER TABLE `user_lockout` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_lockout` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_login_log 结构
DROP TABLE IF EXISTS `user_login_log`;
CREATE TABLE IF NOT EXISTS `user_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `client` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj91w0nnfocpdp796lr3ot4lxs` (`user_id`),
  CONSTRAINT `FKj91w0nnfocpdp796lr3ot4lxs` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=279 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_login_log 的数据：~236 rows (大约)
DELETE FROM `user_login_log`;
/*!40000 ALTER TABLE `user_login_log` DISABLE KEYS */;
INSERT INTO `user_login_log` (`id`, `addDate`, `lastDate`, `account`, `client`, `ip`, `state`, `user_id`) VALUES
	(1, '2019-11-20 17:34:33', '2019-11-20 17:34:33', NULL, NULL, '127.0.0.1', 1, 1),
	(2, '2019-12-28 12:25:29', '2019-12-28 12:25:29', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(3, '2019-12-28 12:27:10', '2019-12-28 12:27:10', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(4, '2019-12-28 12:31:28', '2019-12-28 12:31:28', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(5, '2019-12-28 12:49:11', '2019-12-28 12:49:11', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(6, '2019-12-29 11:28:22', '2019-12-29 11:28:22', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(7, '2019-12-29 13:44:03', '2019-12-29 13:44:03', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(8, '2019-12-29 14:18:36', '2019-12-29 14:18:36', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(9, '2019-12-29 18:23:41', '2019-12-29 18:23:41', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(10, '2019-12-30 19:41:56', '2019-12-30 19:41:56', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(11, '2020-01-05 19:07:57', '2020-01-05 19:07:57', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(12, '2020-01-05 19:09:48', '2020-01-05 19:09:48', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(13, '2020-01-10 21:22:35', '2020-01-10 21:22:35', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(14, '2020-01-10 21:22:49', '2020-01-10 21:22:49', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(15, '2020-01-13 12:39:23', '2020-01-13 12:39:23', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(16, '2020-01-13 12:41:31', '2020-01-13 12:41:31', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(17, '2020-01-13 13:04:04', '2020-01-13 13:04:04', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(18, '2020-01-13 13:04:27', '2020-01-13 13:04:27', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(19, '2020-01-13 13:05:08', '2020-01-13 13:05:08', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(20, '2020-01-15 21:06:51', '2020-01-15 21:06:51', NULL, NULL, '127.0.0.1', 1, 16),
	(21, '2020-01-17 10:19:17', '2020-01-17 10:19:17', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(22, '2020-01-17 19:51:23', '2020-01-17 19:51:23', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(23, '2020-01-18 17:32:43', '2020-01-18 17:32:43', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(24, '2020-01-18 17:42:25', '2020-01-18 17:42:25', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(25, '2020-03-12 20:20:24', '2020-03-12 20:20:24', NULL, NULL, '127.0.0.1', 1, 1),
	(26, '2020-03-12 20:23:51', '2020-03-12 20:23:51', NULL, NULL, '127.0.0.1', 1, 16),
	(27, '2020-03-18 13:53:51', '2020-03-18 13:53:51', NULL, NULL, '127.0.0.1', 1, 16),
	(28, '2020-03-18 14:13:46', '2020-03-18 14:13:46', NULL, NULL, '127.0.0.1', 1, 16),
	(29, '2020-03-18 14:14:01', '2020-03-18 14:14:01', NULL, NULL, '127.0.0.1', 1, 16),
	(30, '2020-03-18 14:14:48', '2020-03-18 14:14:48', NULL, NULL, '127.0.0.1', 1, 16),
	(31, '2020-03-18 17:20:57', '2020-03-18 17:20:57', NULL, NULL, '127.0.0.1', 1, 16),
	(32, '2020-03-18 17:35:42', '2020-03-18 17:35:42', NULL, NULL, '127.0.0.1', 1, 16),
	(33, '2020-03-18 21:23:11', '2020-03-18 21:23:11', NULL, NULL, '127.0.0.1', 1, 16),
	(34, '2020-03-19 12:54:03', '2020-03-19 12:54:03', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(35, '2020-03-20 13:33:04', '2020-03-20 13:33:04', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(36, '2020-03-20 16:03:41', '2020-03-20 16:03:41', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(37, '2020-03-20 16:06:06', '2020-03-20 16:06:06', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(38, '2020-03-20 16:20:50', '2020-03-20 16:20:50', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(39, '2020-03-20 16:25:15', '2020-03-20 16:25:15', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(40, '2020-03-20 16:57:44', '2020-03-20 16:57:44', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(41, '2020-03-20 16:58:56', '2020-03-20 16:58:56', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(42, '2020-03-20 16:59:39', '2020-03-20 16:59:39', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(43, '2020-03-20 17:01:37', '2020-03-20 17:01:37', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(44, '2020-03-20 17:20:05', '2020-03-20 17:20:05', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(45, '2020-03-21 10:45:50', '2020-03-21 10:45:50', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(46, '2020-03-21 16:52:36', '2020-03-21 16:52:36', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(47, '2020-03-21 16:57:14', '2020-03-21 16:57:14', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(48, '2020-03-21 16:57:30', '2020-03-21 16:57:30', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(49, '2020-03-21 16:58:33', '2020-03-21 16:58:33', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(50, '2020-03-21 17:05:23', '2020-03-21 17:05:23', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(51, '2020-03-21 17:09:46', '2020-03-21 17:09:46', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(52, '2020-03-21 17:18:01', '2020-03-21 17:18:01', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(53, '2020-03-21 17:24:10', '2020-03-21 17:24:10', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(54, '2020-03-21 17:33:38', '2020-03-21 17:33:38', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(55, '2020-03-23 15:49:11', '2020-03-23 15:49:11', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(56, '2020-03-23 15:49:36', '2020-03-23 15:49:36', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(57, '2020-03-23 16:17:34', '2020-03-23 16:17:34', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(58, '2020-03-23 16:17:50', '2020-03-23 16:17:50', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(59, '2020-03-23 16:22:17', '2020-03-23 16:22:17', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(60, '2020-03-23 16:24:16', '2020-03-23 16:24:16', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(61, '2020-03-23 16:25:40', '2020-03-23 16:25:40', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(62, '2020-03-23 16:26:03', '2020-03-23 16:26:03', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(63, '2020-03-23 16:26:20', '2020-03-23 16:26:20', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(64, '2020-03-23 16:26:36', '2020-03-23 16:26:36', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(65, '2020-03-23 16:38:57', '2020-03-23 16:38:57', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(66, '2020-03-23 16:41:06', '2020-03-23 16:41:06', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(67, '2020-03-23 16:42:12', '2020-03-23 16:42:12', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(68, '2020-03-23 16:45:22', '2020-03-23 16:45:22', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(69, '2020-03-23 16:48:26', '2020-03-23 16:48:26', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(70, '2020-03-23 16:49:28', '2020-03-23 16:49:28', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(71, '2020-03-23 17:08:30', '2020-03-23 17:08:30', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(72, '2020-03-23 17:09:39', '2020-03-23 17:09:39', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(73, '2020-03-23 17:09:56', '2020-03-23 17:09:56', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(74, '2020-03-23 18:03:40', '2020-03-23 18:03:40', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(75, '2020-03-23 18:16:56', '2020-03-23 18:16:56', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(76, '2020-03-23 18:19:10', '2020-03-23 18:19:10', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 17),
	(77, '2020-03-23 18:19:51', '2020-03-23 18:19:51', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(78, '2020-03-23 20:10:08', '2020-03-23 20:10:08', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(79, '2020-03-23 20:12:53', '2020-03-23 20:12:53', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(80, '2020-03-23 20:55:00', '2020-03-23 20:55:00', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(81, '2020-03-23 20:57:28', '2020-03-23 20:57:28', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(82, '2020-03-23 20:59:25', '2020-03-23 20:59:25', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(83, '2020-03-23 20:59:40', '2020-03-23 20:59:40', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 17),
	(84, '2020-03-24 18:26:51', '2020-03-24 18:26:51', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(85, '2020-03-25 11:30:25', '2020-03-25 11:30:25', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(86, '2020-03-25 11:30:44', '2020-03-25 11:30:44', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(87, '2020-03-25 11:32:35', '2020-03-25 11:32:35', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(88, '2020-03-25 11:40:25', '2020-03-25 11:40:25', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(89, '2020-03-25 12:07:06', '2020-03-25 12:07:06', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(90, '2020-03-25 12:07:17', '2020-03-25 12:07:17', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(91, '2020-03-25 12:07:48', '2020-03-25 12:07:48', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(92, '2020-03-25 12:09:04', '2020-03-25 12:09:04', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(93, '2020-03-25 12:10:59', '2020-03-25 12:10:59', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(94, '2020-03-25 12:12:13', '2020-03-25 12:12:13', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 17),
	(95, '2020-03-25 12:12:32', '2020-03-25 12:12:32', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(96, '2020-03-25 17:25:51', '2020-03-25 17:25:51', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(97, '2020-03-25 17:39:03', '2020-03-25 17:39:03', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(98, '2020-03-25 17:40:21', '2020-03-25 17:40:21', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(99, '2020-03-25 17:52:24', '2020-03-25 17:52:24', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(100, '2020-03-25 20:02:25', '2020-03-25 20:02:25', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(101, '2020-03-25 20:02:44', '2020-03-25 20:02:44', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(102, '2020-03-25 21:00:05', '2020-03-25 21:00:05', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(103, '2020-03-27 16:11:35', '2020-03-27 16:11:35', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(104, '2020-03-27 20:08:50', '2020-03-27 20:08:50', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(105, '2020-03-27 20:56:29', '2020-03-27 20:56:29', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(106, '2020-03-27 20:58:47', '2020-03-27 20:58:47', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(107, '2020-03-27 21:04:20', '2020-03-27 21:04:20', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(108, '2020-03-27 21:19:11', '2020-03-27 21:19:11', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 17),
	(109, '2020-03-27 21:20:35', '2020-03-27 21:20:35', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(110, '2020-03-28 16:54:14', '2020-03-28 16:54:14', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 16),
	(111, '2020-03-28 16:56:12', '2020-03-28 16:56:12', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(112, '2020-03-28 16:56:32', '2020-03-28 16:56:32', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 17),
	(113, '2020-03-28 17:07:22', '2020-03-28 17:07:22', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 1),
	(114, '2020-03-28 17:09:14', '2020-03-28 17:09:14', NULL, NULL, '0:0:0:0:0:0:0:1', 1, 17),
	(115, '2020-03-28 17:56:16', '2020-03-28 17:56:16', NULL, NULL, '113.139.208.245', 1, 16),
	(116, '2020-03-28 17:56:34', '2020-03-28 17:56:34', NULL, NULL, '113.139.208.245', 1, 17),
	(117, '2020-03-28 18:01:47', '2020-03-28 18:01:47', NULL, NULL, '113.139.208.245', 1, 1),
	(118, '2020-03-29 15:13:04', '2020-03-29 15:13:04', NULL, NULL, '1.83.0.81', 1, 16),
	(119, '2020-04-05 20:50:24', '2020-04-05 20:50:24', NULL, NULL, '117.136.87.193', 1, 16),
	(120, '2020-04-05 20:53:09', '2020-04-05 20:53:09', NULL, NULL, '123.139.169.146', 1, 16),
	(121, '2020-04-05 20:55:18', '2020-04-05 20:55:18', NULL, NULL, '123.139.169.146', 1, 16),
	(122, '2020-04-05 20:55:30', '2020-04-05 20:55:30', NULL, NULL, '123.139.169.146', 1, 16),
	(123, '2020-04-07 21:16:18', '2020-04-07 21:16:18', NULL, NULL, '123.139.134.165', 1, 16),
	(124, '2020-04-07 21:23:22', '2020-04-07 21:23:22', NULL, NULL, '113.139.212.2', 1, 16),
	(125, '2020-04-07 21:25:49', '2020-04-07 21:25:49', NULL, NULL, '113.139.212.2', 1, 16),
	(126, '2020-04-07 22:31:03', '2020-04-07 22:31:03', NULL, NULL, '123.139.134.165', 1, 16),
	(127, '2020-04-08 14:21:34', '2020-04-08 14:21:34', NULL, NULL, '117.136.87.9', 1, 16),
	(128, '2020-04-08 14:25:24', '2020-04-08 14:25:24', NULL, NULL, '117.136.87.9', 1, 16),
	(129, '2020-04-11 21:43:46', '2020-04-11 21:43:46', NULL, NULL, '1.83.2.158', 1, 16),
	(130, '2020-04-11 21:43:59', '2020-04-11 21:43:59', NULL, NULL, '1.83.2.158', 1, 17),
	(131, '2020-04-11 21:47:52', '2020-04-11 21:47:52', NULL, NULL, '1.83.2.158', 1, 17),
	(132, '2020-04-14 11:37:42', '2020-04-14 11:37:42', NULL, NULL, '113.201.59.50', 1, 17),
	(133, '2020-04-14 19:06:58', '2020-04-14 19:06:58', NULL, NULL, '113.201.59.50', 1, 17),
	(134, '2020-04-15 16:16:00', '2020-04-15 16:16:00', NULL, NULL, '1.83.2.187', 1, 17),
	(135, '2020-04-16 16:36:22', '2020-04-16 16:36:22', NULL, NULL, '117.136.86.24', 1, 17),
	(136, '2020-04-17 11:27:04', '2020-04-17 11:27:04', NULL, NULL, '113.201.59.50', 1, 17),
	(137, '2020-04-20 14:47:01', '2020-04-20 14:47:01', NULL, NULL, '113.201.59.50', 1, 17),
	(138, '2020-04-22 07:52:50', '2020-04-22 07:52:50', NULL, NULL, '123.139.172.143', 1, 17),
	(139, '2020-04-22 07:54:01', '2020-04-22 07:54:01', NULL, NULL, '123.139.172.143', 1, 17),
	(140, '2020-04-22 07:59:05', '2020-04-22 07:59:05', NULL, NULL, '123.139.172.143', 1, 17),
	(141, '2020-04-22 10:16:44', '2020-04-22 10:16:44', NULL, NULL, '113.139.213.250', 1, 17),
	(142, '2020-04-22 10:17:35', '2020-04-22 10:17:35', NULL, NULL, '113.139.213.250', 1, 1),
	(143, '2020-04-22 10:18:02', '2020-04-22 10:18:02', NULL, NULL, '113.139.213.250', 1, 16),
	(144, '2020-04-22 10:18:22', '2020-04-22 10:18:22', NULL, NULL, '113.139.213.250', 1, 1),
	(145, '2020-04-22 10:21:36', '2020-04-22 10:21:37', NULL, NULL, '113.139.213.250', 1, 17),
	(146, '2020-04-22 11:16:18', '2020-04-22 11:16:18', NULL, NULL, '113.139.209.232', 1, 17),
	(147, '2020-04-24 11:10:03', '2020-04-24 11:10:03', NULL, NULL, '113.201.59.50', 1, 17),
	(148, '2020-04-24 17:00:26', '2020-04-24 17:00:26', NULL, NULL, '113.139.208.36', 1, 17),
	(149, '2020-04-25 10:36:15', '2020-04-25 10:36:15', NULL, NULL, '113.139.214.208', 1, 17),
	(150, '2020-04-25 11:54:04', '2020-04-25 11:54:04', NULL, NULL, '113.139.214.208', 1, 17),
	(151, '2020-04-26 15:21:12', '2020-04-26 15:21:12', NULL, NULL, '113.201.59.50', 1, 17),
	(152, '2020-04-26 15:58:48', '2020-04-26 15:58:48', NULL, NULL, '113.139.214.208', 1, 17),
	(153, '2020-04-27 17:12:50', '2020-04-27 17:12:50', NULL, NULL, '1.83.2.60', 1, 16),
	(154, '2020-04-27 17:24:51', '2020-04-27 17:24:51', NULL, NULL, '113.201.59.50', 1, 17),
	(155, '2020-04-27 17:40:27', '2020-04-27 17:40:27', NULL, NULL, '1.83.2.60', 1, 17),
	(156, '2020-04-27 18:18:55', '2020-04-27 18:18:55', NULL, NULL, '1.83.2.60', 1, 17),
	(157, '2020-04-27 18:28:46', '2020-04-27 18:28:46', NULL, NULL, '1.83.2.60', 1, 1),
	(158, '2020-04-27 19:50:45', '2020-04-27 19:50:45', NULL, NULL, '1.83.2.60', 1, 17),
	(159, '2020-04-28 19:33:27', '2020-04-28 19:33:27', NULL, NULL, '113.139.208.226', 1, 17),
	(160, '2020-04-28 19:39:57', '2020-04-28 19:39:57', NULL, NULL, '113.139.208.226', 1, 1),
	(161, '2020-04-28 19:40:49', '2020-04-28 19:40:49', NULL, NULL, '113.139.208.226', 1, 17),
	(162, '2020-04-28 19:41:38', '2020-04-28 19:41:38', NULL, NULL, '113.139.208.226', 1, 17),
	(163, '2020-04-28 19:41:50', '2020-04-28 19:41:50', NULL, NULL, '113.139.208.226', 1, 1),
	(164, '2020-04-28 19:42:40', '2020-04-28 19:42:40', NULL, NULL, '113.139.208.226', 1, 17),
	(165, '2020-04-30 16:37:56', '2020-04-30 16:37:56', NULL, NULL, '1.83.28.22', 1, 16),
	(166, '2020-04-30 16:38:04', '2020-04-30 16:38:04', NULL, NULL, '1.83.28.22', 1, 17),
	(167, '2020-04-30 20:11:05', '2020-04-30 20:11:05', NULL, NULL, '1.83.28.22', 1, 16),
	(168, '2020-04-30 20:12:43', '2020-04-30 20:12:43', NULL, NULL, '1.83.28.22', 1, 16),
	(169, '2020-04-30 20:12:53', '2020-04-30 20:12:53', NULL, NULL, '1.83.28.22', 1, 17),
	(170, '2020-05-02 17:45:15', '2020-05-02 17:45:15', NULL, NULL, '1.83.1.78', 1, 1),
	(171, '2020-05-02 17:45:34', '2020-05-02 17:45:34', NULL, NULL, '1.83.1.78', 1, 17),
	(172, '2020-05-03 11:20:02', '2020-05-03 11:20:02', NULL, NULL, '111.18.130.98', 1, 17),
	(173, '2020-05-03 11:20:25', '2020-05-03 11:20:25', NULL, NULL, '111.18.130.98', 1, 17),
	(174, '2020-05-03 18:10:41', '2020-05-03 18:10:41', NULL, NULL, '111.18.130.98', 1, 17),
	(175, '2020-05-04 14:11:28', '2020-05-04 14:11:28', NULL, NULL, '113.139.213.78', 1, 17),
	(176, '2020-05-06 10:20:44', '2020-05-06 10:20:44', NULL, NULL, '223.104.11.31', 1, 17),
	(177, '2020-05-07 20:18:44', '2020-05-07 20:18:44', NULL, NULL, '113.139.208.207', 1, 17),
	(178, '2020-05-07 21:08:57', '2020-05-07 21:08:57', NULL, NULL, '113.139.208.207', 1, 16),
	(179, '2020-05-07 21:09:04', '2020-05-07 21:09:04', NULL, NULL, '113.139.208.207', 1, 17),
	(180, '2020-05-08 12:31:29', '2020-05-08 12:31:29', NULL, NULL, '117.136.87.55', 1, 17),
	(181, '2020-05-08 12:59:18', '2020-05-08 12:59:18', NULL, NULL, '113.139.208.207', 1, 1),
	(182, '2020-05-08 17:16:25', '2020-05-08 17:16:25', NULL, NULL, '113.139.210.30', 1, 17),
	(183, '2020-05-08 17:21:57', '2020-05-08 17:21:57', NULL, NULL, '113.139.210.30', 1, 17),
	(184, '2020-05-08 22:42:23', '2020-05-08 22:42:23', NULL, NULL, '113.139.210.30', 1, 17),
	(185, '2020-05-08 22:43:34', '2020-05-08 22:43:34', NULL, NULL, '113.139.210.30', 1, 16),
	(186, '2020-05-08 22:43:46', '2020-05-08 22:43:46', NULL, NULL, '113.139.210.30', 1, 1),
	(187, '2020-05-08 22:44:18', '2020-05-08 22:44:18', NULL, NULL, '113.139.210.30', 1, 16),
	(188, '2020-05-08 22:53:31', '2020-05-08 22:53:31', NULL, NULL, '113.139.210.30', 1, 16),
	(189, '2020-05-08 22:55:21', '2020-05-08 22:55:21', NULL, NULL, '113.139.210.30', 1, 17),
	(190, '2020-05-09 14:41:44', '2020-05-09 14:41:44', NULL, NULL, '113.139.210.30', 1, 17),
	(191, '2020-05-09 20:15:41', '2020-05-09 20:15:41', NULL, NULL, '113.139.210.30', 1, 17),
	(192, '2020-05-10 13:32:51', '2020-05-10 13:32:51', NULL, NULL, '113.139.215.8', 1, 17),
	(193, '2020-05-11 20:16:38', '2020-05-11 20:16:38', NULL, NULL, '1.83.3.164', 1, 17),
	(194, '2020-05-11 22:04:04', '2020-05-11 22:04:04', NULL, NULL, '111.19.32.178', 1, 17),
	(195, '2020-05-12 14:40:21', '2020-05-12 14:40:21', NULL, NULL, '1.83.3.164', 1, 17),
	(196, '2020-05-12 16:01:52', '2020-05-12 16:01:52', NULL, NULL, '1.83.3.164', 1, 16),
	(197, '2020-05-12 16:02:02', '2020-05-12 16:02:02', NULL, NULL, '1.83.3.164', 1, 17),
	(198, '2020-05-12 20:02:52', '2020-05-12 20:02:52', NULL, NULL, '1.83.3.164', 1, 17),
	(199, '2020-05-12 22:42:07', '2020-05-12 22:42:07', NULL, NULL, '111.19.94.4', 1, 17),
	(200, '2020-05-12 22:42:58', '2020-05-12 22:42:58', NULL, NULL, '111.19.94.4', 1, 1),
	(201, '2020-05-12 22:43:20', '2020-05-12 22:43:20', NULL, NULL, '111.19.94.4', 1, 17),
	(202, '2020-05-12 22:43:43', '2020-05-12 22:43:43', NULL, NULL, '111.19.94.4', 1, 16),
	(203, '2020-05-14 10:24:23', '2020-05-14 10:24:23', NULL, NULL, '1.83.29.133', 1, 17),
	(204, '2020-05-14 10:41:07', '2020-05-14 10:41:07', NULL, NULL, '1.83.29.133', 1, 17),
	(205, '2020-05-14 20:07:28', '2020-05-14 20:07:28', NULL, NULL, '1.83.28.50', 1, 17),
	(206, '2020-05-15 10:09:25', '2020-05-15 10:09:25', NULL, NULL, '1.83.28.50', 1, 17),
	(207, '2020-05-15 10:09:34', '2020-05-15 10:09:34', NULL, NULL, '1.83.28.50', 1, 1),
	(208, '2020-05-15 10:37:32', '2020-05-15 10:37:32', NULL, NULL, '1.83.28.50', 1, 17),
	(209, '2020-05-15 14:16:04', '2020-05-15 14:16:04', NULL, NULL, '1.83.28.50', 1, 17),
	(210, '2020-05-15 16:28:54', '2020-05-15 16:28:54', NULL, NULL, '1.83.28.50', 1, 17),
	(211, '2020-05-15 16:37:56', '2020-05-15 16:37:56', NULL, NULL, '1.83.28.50', 1, 17),
	(212, '2020-05-15 16:52:53', '2020-05-15 16:52:53', NULL, NULL, '1.83.28.50', 1, 17),
	(213, '2020-05-17 20:53:27', '2020-05-17 20:53:27', NULL, NULL, '123.139.171.30', 1, 17),
	(214, '2020-05-18 17:43:45', '2020-05-18 17:43:45', NULL, NULL, '113.139.214.76', 1, 17),
	(215, '2020-05-18 21:42:58', '2020-05-18 21:42:58', NULL, NULL, '1.83.29.193', 1, 17),
	(216, '2020-05-19 15:53:58', '2020-05-19 15:53:58', NULL, NULL, '113.200.106.222', 1, 17),
	(217, '2020-05-19 17:11:03', '2020-05-19 17:11:03', NULL, NULL, '1.83.29.193', 1, 17),
	(218, '2020-05-19 17:22:59', '2020-05-19 17:22:59', NULL, NULL, '1.83.29.193', 1, 1),
	(219, '2020-05-19 17:31:51', '2020-05-19 17:31:51', NULL, NULL, '1.83.29.193', 1, 1),
	(220, '2020-05-19 17:33:16', '2020-05-19 17:33:16', NULL, NULL, '1.83.29.193', 1, 17),
	(221, '2020-05-19 17:33:46', '2020-05-19 17:33:46', NULL, NULL, '1.83.29.193', 1, 1),
	(222, '2020-05-19 17:34:24', '2020-05-19 17:34:24', NULL, NULL, '1.83.29.193', 1, 17),
	(223, '2020-05-19 17:37:54', '2020-05-19 17:37:54', NULL, NULL, '1.83.29.193', 1, 17),
	(224, '2020-05-19 18:12:20', '2020-05-19 18:12:20', NULL, NULL, '1.83.29.193', 1, 17),
	(225, '2020-05-19 18:29:56', '2020-05-19 18:29:56', NULL, NULL, '1.83.29.193', 1, 17),
	(226, '2020-05-19 18:40:43', '2020-05-19 18:40:43', NULL, NULL, '1.83.29.193', 1, 17),
	(227, '2020-05-19 18:48:06', '2020-05-19 18:48:06', NULL, NULL, '1.83.29.193', 1, 17),
	(228, '2020-05-19 18:54:55', '2020-05-19 18:54:55', NULL, NULL, '1.83.29.193', 1, 17),
	(229, '2020-05-19 18:56:05', '2020-05-19 18:56:05', NULL, NULL, '1.83.29.193', 1, 1),
	(230, '2020-05-19 19:01:22', '2020-05-19 19:01:22', NULL, NULL, '1.83.29.193', 1, 17),
	(231, '2020-05-20 12:54:42', '2020-05-20 12:54:42', NULL, NULL, '113.139.210.77', 1, 17),
	(232, '2020-05-20 17:28:03', '2020-05-20 17:28:03', NULL, NULL, '113.139.210.77', 1, 17),
	(233, '2020-05-21 16:02:33', '2020-05-21 16:02:33', NULL, NULL, '113.139.210.41', 1, 17),
	(234, '2020-05-21 16:13:38', '2020-05-21 16:13:38', NULL, NULL, '113.139.210.41', 1, 17),
	(235, '2020-05-21 16:36:15', '2020-05-21 16:36:15', NULL, NULL, '113.139.210.41', 1, 17),
	(236, '2020-05-22 15:56:50', '2020-05-22 15:56:50', NULL, NULL, '113.201.59.50', 1, 17),
	(237, '2020-05-22 16:22:31', '2020-05-22 16:22:31', NULL, NULL, '113.201.59.50', 1, 17),
	(238, '2020-05-23 17:14:49', '2020-05-23 17:14:49', NULL, NULL, '1.83.28.31', 1, 17),
	(239, '2020-05-23 18:56:35', '2020-05-23 18:56:35', NULL, NULL, '1.83.28.31', 1, 1),
	(240, '2020-05-23 21:31:21', '2020-05-23 21:31:21', NULL, NULL, '1.83.28.31', 1, 17),
	(241, '2020-05-24 17:32:00', '2020-05-24 17:32:00', NULL, NULL, '113.139.212.23', 1, 1),
	(242, '2020-05-25 10:48:05', '2020-05-25 10:48:05', NULL, NULL, '113.139.212.23', 1, 17),
	(243, '2020-05-25 14:15:17', '2020-05-25 14:15:17', NULL, NULL, '113.139.212.23', 1, 17),
	(244, '2020-05-25 15:23:32', '2020-05-25 15:23:32', NULL, NULL, '113.139.212.23', 1, 17),
	(245, '2020-05-25 16:54:33', '2020-05-25 16:54:33', NULL, NULL, '113.139.212.23', 1, 17),
	(246, '2020-05-25 17:02:26', '2020-05-25 17:02:26', NULL, NULL, '113.139.212.23', 1, 17),
	(247, '2020-05-27 12:59:31', '2020-05-27 12:59:31', NULL, NULL, '117.136.87.182', 1, 17),
	(248, '2020-05-27 15:01:29', '2020-05-27 15:01:29', NULL, NULL, '113.139.210.5', 1, 1),
	(249, '2020-05-27 15:08:43', '2020-05-27 15:08:43', NULL, NULL, '113.139.210.5', 1, 17),
	(250, '2020-05-27 15:12:55', '2020-05-27 15:12:55', NULL, NULL, '113.139.210.5', 1, 17),
	(251, '2020-05-27 19:48:24', '2020-05-27 19:48:24', NULL, NULL, '113.139.210.5', 1, 17),
	(252, '2020-05-28 11:02:53', '2020-05-28 11:02:53', NULL, NULL, '113.139.210.5', 1, 17),
	(253, '2020-05-28 11:03:08', '2020-05-28 11:03:08', NULL, NULL, '113.139.210.5', 1, 17),
	(254, '2020-05-28 13:50:03', '2020-05-28 13:50:03', NULL, NULL, '113.139.210.5', 1, 17),
	(255, '2020-05-28 13:50:20', '2020-05-28 13:50:20', NULL, NULL, '113.139.210.5', 1, 17),
	(256, '2020-05-28 13:57:45', '2020-05-28 13:57:45', NULL, NULL, '113.139.210.5', 1, 17),
	(257, '2020-05-28 14:14:45', '2020-05-28 14:14:45', NULL, NULL, '113.139.210.5', 1, 17),
	(258, '2020-05-28 14:28:57', '2020-05-28 14:28:57', NULL, NULL, '113.139.210.5', 1, 17),
	(259, '2020-05-28 17:52:59', '2020-05-28 17:52:59', NULL, NULL, '113.139.210.5', 1, 17),
	(260, '2020-05-29 16:54:52', '2020-05-29 16:54:52', NULL, NULL, '113.139.215.117', 1, 17),
	(261, '2020-05-30 17:59:43', '2020-05-30 17:59:43', NULL, NULL, '113.139.214.121', 1, 17),
	(262, '2020-06-02 15:29:42', '2020-06-02 15:29:42', NULL, NULL, '113.139.209.62', 1, 17),
	(263, '2020-06-02 20:53:21', '2020-06-02 20:53:21', NULL, NULL, '113.139.209.62', 1, 17),
	(264, '2020-06-02 20:53:35', '2020-06-02 20:53:35', NULL, NULL, '113.139.209.62', 1, 1),
	(265, '2020-06-03 10:18:51', '2020-06-03 10:18:51', NULL, NULL, '113.139.210.242', 1, 17),
	(266, '2020-06-04 17:25:56', '2020-06-04 17:25:56', NULL, NULL, '1.83.28.69', 1, 17),
	(267, '2020-06-05 11:17:22', '2020-06-05 11:17:22', NULL, NULL, '1.83.28.69', 1, 17),
	(268, '2020-06-05 13:03:54', '2020-06-05 13:03:54', NULL, NULL, '1.83.28.69', 1, 17),
	(269, '2020-06-05 13:50:26', '2020-06-05 13:50:26', NULL, NULL, '1.83.28.69', 1, 17),
	(270, '2020-06-05 14:09:26', '2020-06-05 14:09:26', NULL, NULL, '1.83.28.69', 1, 17),
	(271, '2020-06-09 10:32:44', '2020-06-09 10:32:44', NULL, NULL, '111.19.94.13', 1, 17),
	(272, '2020-06-10 12:20:26', '2020-06-10 12:20:26', NULL, NULL, '124.89.103.4', 1, 17),
	(273, '2020-06-10 17:07:32', '2020-06-10 17:07:32', NULL, NULL, '113.139.214.220', 1, 17),
	(274, '2020-06-10 17:39:54', '2020-06-10 17:39:54', NULL, NULL, '113.139.214.220', 1, 17),
	(275, '2020-06-10 18:18:06', '2020-06-10 18:18:06', NULL, NULL, '113.139.214.220', 1, 17),
	(276, '2020-06-11 14:14:30', '2020-06-11 14:14:30', NULL, NULL, '1.85.222.103', 1, 17),
	(277, '2020-06-12 15:31:41', '2020-06-12 15:31:41', NULL, NULL, '113.139.211.187', 1, 17),
	(278, '2020-06-13 22:00:00', '2020-06-13 22:00:00', NULL, NULL, '113.139.215.15', 1, 17);
/*!40000 ALTER TABLE `user_login_log` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_notification 结构
DROP TABLE IF EXISTS `user_notification`;
CREATE TABLE IF NOT EXISTS `user_notification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `clicks` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `imageType` int(11) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `nums` int(11) DEFAULT NULL,
  `taxonomy` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `top` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `authorid` bigint(20) DEFAULT NULL,
  `catalogid` int(11) DEFAULT NULL,
  `storeState` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKen7mn6n9j4ach4hyewfjakkg2` (`authorid`),
  KEY `FK25yxc2g4kt2wk510uy05nr10f` (`catalogid`),
  CONSTRAINT `FK25yxc2g4kt2wk510uy05nr10f` FOREIGN KEY (`catalogid`) REFERENCES `user_notification_catalog` (`id`),
  CONSTRAINT `FKen7mn6n9j4ach4hyewfjakkg2` FOREIGN KEY (`authorid`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_notification 的数据：~4 rows (大约)
DELETE FROM `user_notification`;
/*!40000 ALTER TABLE `user_notification` DISABLE KEYS */;
INSERT INTO `user_notification` (`id`, `addDate`, `lastDate`, `category`, `clicks`, `image`, `imageType`, `introduction`, `note`, `nums`, `taxonomy`, `title`, `top`, `url`, `authorid`, `catalogid`, `storeState`) VALUES
	(1, '2018-12-07 08:57:59', '2018-12-07 08:57:59', 2, NULL, NULL, NULL, NULL, 'sdsd', NULL, NULL, 'ds', NULL, NULL, 1, NULL, NULL),
	(2, '2018-12-07 11:23:32', '2018-12-07 11:23:32', 2, NULL, NULL, NULL, NULL, 'ere', NULL, NULL, 'fd', NULL, NULL, 1, NULL, NULL),
	(3, '2018-12-07 13:42:18', '2018-12-07 13:42:18', 2, NULL, NULL, NULL, NULL, 'ddd', 2, NULL, 'dd', NULL, NULL, 1, NULL, 1),
	(4, '2018-12-07 13:49:28', '2018-12-07 13:49:28', 1, NULL, NULL, NULL, NULL, 'nice', 1, NULL, 'hi', NULL, NULL, 1, NULL, 1);
/*!40000 ALTER TABLE `user_notification` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_notification_catalog 结构
DROP TABLE IF EXISTS `user_notification_catalog`;
CREATE TABLE IF NOT EXISTS `user_notification_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `system` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgftt45f6mnajuk0k4c8aya4ew` (`pid`),
  CONSTRAINT `FKgftt45f6mnajuk0k4c8aya4ew` FOREIGN KEY (`pid`) REFERENCES `user_notification_catalog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_notification_catalog 的数据：~0 rows (大约)
DELETE FROM `user_notification_catalog`;
/*!40000 ALTER TABLE `user_notification_catalog` DISABLE KEYS */;
INSERT INTO `user_notification_catalog` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `icon`, `system`, `pid`) VALUES
	(1, '2018-07-16 15:01:15', '', '1', '2018-07-16 15:01:15', 1, 1, '根节点', 2, 0, NULL, NULL, NULL);
/*!40000 ALTER TABLE `user_notification_catalog` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_notification_member 结构
DROP TABLE IF EXISTS `user_notification_member`;
CREATE TABLE IF NOT EXISTS `user_notification_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `notificationid` bigint(20) DEFAULT NULL,
  `uid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKolldeppu9xw9we1jwgcvpc6m7` (`notificationid`),
  KEY `FKlatb6olq7rthe83lg86qovdqh` (`uid`),
  CONSTRAINT `FKlatb6olq7rthe83lg86qovdqh` FOREIGN KEY (`uid`) REFERENCES `user_info` (`id`),
  CONSTRAINT `FKolldeppu9xw9we1jwgcvpc6m7` FOREIGN KEY (`notificationid`) REFERENCES `user_notification` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_notification_member 的数据：~7 rows (大约)
DELETE FROM `user_notification_member`;
/*!40000 ALTER TABLE `user_notification_member` DISABLE KEYS */;
INSERT INTO `user_notification_member` (`id`, `addDate`, `lastDate`, `state`, `notificationid`, `uid`) VALUES
	(1, '2018-12-07 08:57:59', '2018-12-07 08:57:59', 0, 1, 1),
	(2, '2018-12-07 08:57:59', '2018-12-07 08:57:59', 0, 1, 2),
	(3, '2018-12-07 11:23:32', '2018-12-07 11:23:32', 0, 2, 1),
	(4, '2018-12-07 11:23:32', '2018-12-07 11:23:32', 0, 2, 2),
	(5, '2018-12-07 13:42:18', '2018-12-07 13:42:18', 0, 3, 1),
	(6, '2018-12-07 13:42:18', '2018-12-07 13:42:18', 0, 3, 2),
	(7, '2018-12-07 13:49:28', '2018-12-07 13:49:28', 0, 4, 2);
/*!40000 ALTER TABLE `user_notification_member` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_notification_num 结构
DROP TABLE IF EXISTS `user_notification_num`;
CREATE TABLE IF NOT EXISTS `user_notification_num` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `mid` bigint(20) DEFAULT NULL,
  `uid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmi0949b37eayfjjpvv421bmvy` (`uid`),
  CONSTRAINT `FKmi0949b37eayfjjpvv421bmvy` FOREIGN KEY (`uid`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_notification_num 的数据：~0 rows (大约)
DELETE FROM `user_notification_num`;
/*!40000 ALTER TABLE `user_notification_num` DISABLE KEYS */;
INSERT INTO `user_notification_num` (`id`, `addDate`, `lastDate`, `mid`, `uid`) VALUES
	(1, '2018-12-07 08:56:24', '2019-09-11 19:18:48', 0, 1);
/*!40000 ALTER TABLE `user_notification_num` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_notification_time 结构
DROP TABLE IF EXISTS `user_notification_time`;
CREATE TABLE IF NOT EXISTS `user_notification_time` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `uid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5co2x7rgocx6fmbfptaknqxh8` (`uid`),
  CONSTRAINT `FK5co2x7rgocx6fmbfptaknqxh8` FOREIGN KEY (`uid`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_notification_time 的数据：~0 rows (大约)
DELETE FROM `user_notification_time`;
/*!40000 ALTER TABLE `user_notification_time` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_notification_time` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_oauth_config 结构
DROP TABLE IF EXISTS `user_oauth_config`;
CREATE TABLE IF NOT EXISTS `user_oauth_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `appKey` varchar(255) DEFAULT NULL,
  `appSecret` varchar(255) DEFAULT NULL,
  `className` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_oauth_config 的数据：~0 rows (大约)
DELETE FROM `user_oauth_config`;
/*!40000 ALTER TABLE `user_oauth_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_oauth_config` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_oauth_token 结构
DROP TABLE IF EXISTS `user_oauth_token`;
CREATE TABLE IF NOT EXISTS `user_oauth_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `access_token` varchar(255) DEFAULT NULL,
  `expires_in` bigint(20) DEFAULT NULL,
  `loginSize` int(11) DEFAULT NULL,
  `refresh_token` varchar(255) DEFAULT NULL,
  `token_type` varchar(255) DEFAULT NULL,
  `uid` varchar(255) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhco9s5j1bhp44w3mpt19kmi21` (`userid`),
  CONSTRAINT `FKhco9s5j1bhp44w3mpt19kmi21` FOREIGN KEY (`userid`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_oauth_token 的数据：~0 rows (大约)
DELETE FROM `user_oauth_token`;
/*!40000 ALTER TABLE `user_oauth_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_oauth_token` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_role 结构
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `alias` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `roleType` int(11) DEFAULT NULL,
  `catalog_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrwtb6ktd4x1qi6sjjiu3134a1` (`catalog_id`),
  CONSTRAINT `FKrwtb6ktd4x1qi6sjjiu3134a1` FOREIGN KEY (`catalog_id`) REFERENCES `user_role_catalog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_role 的数据：~4 rows (大约)
DELETE FROM `user_role`;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`id`, `addDate`, `lastDate`, `alias`, `description`, `name`, `roleType`, `catalog_id`) VALUES
	(1, '2019-11-06 19:19:26', '2019-11-06 19:19:26', '', '', 'admin', 0, 2),
	(2, '2019-09-17 20:50:47', '2019-09-17 20:50:47', '管理员', '后台管理员', '管理员', 0, 2),
	(3, '2020-05-19 18:56:15', '2020-05-19 18:56:15', '租户管理员', '', 'tenant_admin', 0, 2),
	(4, '2020-05-08 22:44:11', '2020-05-08 22:44:11', '', '', '租户类型2', 0, 2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_role_authority 结构
DROP TABLE IF EXISTS `user_role_authority`;
CREATE TABLE IF NOT EXISTS `user_role_authority` (
  `role_id` bigint(20) NOT NULL,
  `permission` varchar(100) DEFAULT NULL,
  KEY `FKo6xok4ngrsuacqkyjpqbykn9l` (`role_id`),
  CONSTRAINT `FKo6xok4ngrsuacqkyjpqbykn9l` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_role_authority 的数据：~147 rows (大约)
DELETE FROM `user_role_authority`;
/*!40000 ALTER TABLE `user_role_authority` DISABLE KEYS */;
INSERT INTO `user_role_authority` (`role_id`, `permission`) VALUES
	(2, '19'),
	(2, '2'),
	(2, 'member_basic'),
	(2, 'dictionary'),
	(2, 'system_config'),
	(1, '63'),
	(1, 'venue'),
	(1, 'venuecatalog'),
	(1, '66'),
	(1, 'activitycatalog'),
	(1, 'activity'),
	(1, '19'),
	(1, '20'),
	(1, 'member'),
	(1, 'accounts'),
	(1, 'userloginlog'),
	(1, '49'),
	(1, 'function'),
	(1, '51'),
	(1, 'adposition'),
	(1, 'ad'),
	(1, '54'),
	(1, 'tenantcatalog'),
	(1, 'tenant'),
	(1, '57'),
	(1, 'brandcatalog'),
	(1, 'brand'),
	(1, 'brandstore'),
	(1, '15'),
	(1, 'plugin_sendcode'),
	(1, 'plugin_storage'),
	(1, 'plugin_push'),
	(1, 'plugin_oauth'),
	(1, 'plugin_proxy'),
	(1, '34'),
	(1, '35'),
	(1, 'crontask'),
	(1, 'crontaskrecord'),
	(1, '38'),
	(1, 'usernotificationmember'),
	(1, 'usernotificationcatalog'),
	(1, 'usernotification'),
	(1, 'types'),
	(1, 'area'),
	(1, '2'),
	(1, 'menu'),
	(1, 'userrole'),
	(1, 'tenantoauthconfig'),
	(1, 'linktype'),
	(1, 'link'),
	(1, 'userrolecatalog'),
	(1, 'appversion'),
	(1, '10'),
	(1, 'tmpl'),
	(1, 'member_basic'),
	(1, 'dictionary'),
	(1, 'system_config'),
	(4, '19'),
	(4, '122'),
	(4, 'adposition'),
	(4, 'ad'),
	(4, '61'),
	(4, 'orderdata'),
	(4, 'orderrefund'),
	(4, 'ordertrade'),
	(4, 'orderexchange'),
	(4, 'ordertally'),
	(4, '69'),
	(4, '104'),
	(4, 'statistics_home'),
	(4, 'statistics_customer'),
	(4, 'statistics_kpi'),
	(4, 'statistics_goods'),
	(4, 'statistics_area'),
	(4, '79'),
	(4, 'goodscatalog'),
	(4, 'goods'),
	(4, 'goodsbrand'),
	(4, 'spuname'),
	(4, 'customer'),
	(4, '87'),
	(4, 'distributionsheet'),
	(4, 'vehicletype'),
	(4, 'distributionvehicle'),
	(4, 'driver'),
	(4, '92'),
	(4, 'coupon'),
	(4, 'promote'),
	(4, '117'),
	(4, 'organization'),
	(4, 'employee'),
	(4, '96'),
	(4, 'tenantarea'),
	(4, 'tenantuserrole'),
	(4, 'tenantdictionary'),
	(3, '19'),
	(3, '122'),
	(3, 'adposition'),
	(3, 'ad'),
	(3, '61'),
	(3, 'orderdata'),
	(3, 'orderrefund'),
	(3, 'ordertrade'),
	(3, 'orderexchange'),
	(3, 'ordertally'),
	(3, '69'),
	(3, 'financestream'),
	(3, 'financeaccount'),
	(3, 'bill'),
	(3, 'invoice'),
	(3, '73'),
	(3, 'tenant_plugin_payment'),
	(3, '104'),
	(3, 'statistics_home'),
	(3, 'statistics_customer'),
	(3, 'statistics_kpi'),
	(3, 'statistics_goods'),
	(3, 'statistics_area'),
	(3, 'customer'),
	(3, '87'),
	(3, 'distributionsheet'),
	(3, 'vehicletype'),
	(3, 'distributionvehicle'),
	(3, 'driver'),
	(3, '113'),
	(3, 'brand'),
	(3, 'product'),
	(3, 'productcatalog'),
	(3, 'productlabel'),
	(3, 'productspec'),
	(3, 'tenantoauthconfig'),
	(3, '92'),
	(3, 'coupon'),
	(3, 'promote'),
	(3, '117'),
	(3, 'organization'),
	(3, '128'),
	(3, 'supplier'),
	(3, '125'),
	(3, 'articlecatalog'),
	(3, 'article'),
	(3, '96'),
	(3, 'tenantarea'),
	(3, 'tenantuserrole'),
	(3, 'tenantdictionary'),
	(3, 'industry'),
	(3, 'tenantoauthconfig');
/*!40000 ALTER TABLE `user_role_authority` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_role_catalog 结构
DROP TABLE IF EXISTS `user_role_catalog`;
CREATE TABLE IF NOT EXISTS `user_role_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `levelInfo` int(11) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  `sortNum` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkk8xoshxnvrtd39dd20k4vi85` (`pid`),
  CONSTRAINT `FKkk8xoshxnvrtd39dd20k4vi85` FOREIGN KEY (`pid`) REFERENCES `user_role_catalog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_role_catalog 的数据：~4 rows (大约)
DELETE FROM `user_role_catalog`;
/*!40000 ALTER TABLE `user_role_catalog` DISABLE KEYS */;
INSERT INTO `user_role_catalog` (`id`, `addDate`, `code`, `ids`, `lastDate`, `levelInfo`, `lft`, `name`, `rgt`, `sortNum`, `pid`) VALUES
	(1, '2017-12-27 13:59:23', '', '1', '2017-12-27 13:59:23', 1, 1, '根节点', 8, 0, NULL),
	(2, '2018-08-12 16:43:59', '002', '1,2', '2018-08-12 16:43:59', 2, 2, '系统', 5, NULL, 1),
	(3, '2018-08-12 16:44:19', '001', '1,3', '2018-08-12 16:44:19', 2, 6, '自定义', 7, NULL, 1),
	(4, '2018-08-12 17:24:34', 'gg', '1,2,4', '2018-08-12 17:24:34', 3, 3, 'gg', 4, NULL, 2);
/*!40000 ALTER TABLE `user_role_catalog` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_role_links 结构
DROP TABLE IF EXISTS `user_role_links`;
CREATE TABLE IF NOT EXISTS `user_role_links` (
  `user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`roles_id`),
  KEY `FKpm1oweb01msxxqf212qmd0984` (`roles_id`),
  CONSTRAINT `FK3r2sf8531lbjt40y3qjhkg2an` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKpm1oweb01msxxqf212qmd0984` FOREIGN KEY (`roles_id`) REFERENCES `user_role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_role_links 的数据：~11 rows (大约)
DELETE FROM `user_role_links`;
/*!40000 ALTER TABLE `user_role_links` DISABLE KEYS */;
INSERT INTO `user_role_links` (`user_id`, `roles_id`) VALUES
	(1, 1),
	(10, 1),
	(12, 1),
	(13, 1),
	(2, 2),
	(10, 2),
	(11, 3),
	(14, 3),
	(15, 3),
	(17, 3),
	(16, 4);
/*!40000 ALTER TABLE `user_role_links` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_security 结构
DROP TABLE IF EXISTS `user_security`;
CREATE TABLE IF NOT EXISTS `user_security` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `checkSize` int(11) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  `securityType` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK641wdw6hf3c0nflv03rt0d6h2` (`user_id`),
  CONSTRAINT `FK641wdw6hf3c0nflv03rt0d6h2` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_security 的数据：~10 rows (大约)
DELETE FROM `user_security`;
/*!40000 ALTER TABLE `user_security` DISABLE KEYS */;
INSERT INTO `user_security` (`id`, `addDate`, `lastDate`, `checkSize`, `password`, `salt`, `securityType`, `user_id`) VALUES
	(1, '2018-12-01 10:26:11', '2020-05-08 22:43:58', 0, 'b7fd99348a3723ef703881f7de92ceb2ec61adb3', 'e1e8c5fab5a28e13', 0, 1),
	(2, '2018-12-01 10:26:23', '2018-12-01 10:26:23', 0, 'd9730873f22fdd9bef4793e9c28b9a5d877810a0', 'ea6990c1cbfbcbbb', 0, 2),
	(9, '2019-09-12 16:03:06', '2019-09-12 16:25:09', 0, 'ed6325aba15042638a7efc01b003746735c5b82b', 'b797c613fd100142', 0, 10),
	(10, '2018-12-01 10:26:11', '2018-12-01 10:29:19', 0, 'b63e05a75d3c13c53becedeb885bda5b67a6664a', 'e1e8c5fab5a28e13', 0, 11),
	(11, '2018-12-01 10:26:11', '2018-12-01 10:29:19', 0, 'b63e05a75d3c13c53becedeb885bda5b67a6664a', 'e1e8c5fab5a28e13', 0, 12),
	(12, '2018-12-01 10:26:11', '2018-12-01 10:29:19', 0, 'b63e05a75d3c13c53becedeb885bda5b67a6664a', 'e1e8c5fab5a28e13', 0, 13),
	(13, '2019-11-06 17:32:29', '2019-11-06 17:32:29', 0, 'c3c3323ea3a8d016276e9f982c0db84c18259be4', 'acd649e695826230', 0, 14),
	(14, '2019-11-07 23:20:42', '2019-11-07 23:20:42', 0, '5932f9d38533a1158e8c4f09c490d04fb97afc72', '169f554f9d751ab5', 0, 15),
	(15, '2019-12-28 12:24:06', '2019-12-28 12:24:06', 0, 'df499c9e124225f2fdc3c7ad34c6faf392292083', '36f8999ecd43783e', 0, 16),
	(16, '2020-03-23 18:18:53', '2020-03-23 18:18:53', 0, 'b68bb5521adcde1b1be0ae2ac3b65a125bfe4f3a', 'f99eeb6b79174df8', 0, 17);
/*!40000 ALTER TABLE `user_security` ENABLE KEYS */;

-- 导出  表 b2bcloud.user_verification 结构
DROP TABLE IF EXISTS `user_verification`;
CREATE TABLE IF NOT EXISTS `user_verification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addDate` datetime DEFAULT NULL,
  `lastDate` datetime DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  b2bcloud.user_verification 的数据：~0 rows (大约)
DELETE FROM `user_verification`;
/*!40000 ALTER TABLE `user_verification` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_verification` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
