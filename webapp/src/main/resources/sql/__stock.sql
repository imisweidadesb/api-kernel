/*
Navicat MySQL Data Transfer

Source Server         : 192.168.14.251_3306
Source Server Version : 50627
Source Host           : 192.168.14.251:3306
Source Database       : ztest

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2017-01-17 16:59:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for __stock
-- ----------------------------
DROP TABLE IF EXISTS `__stock`;
CREATE TABLE `__stock` (
  `__id` bigint(20) NOT NULL AUTO_INCREMENT,
  `__stock_name` varchar(10) NOT NULL,
  `__stock_code` varchar(8) NOT NULL,
  `__simple_name` varchar(45) NOT NULL,
  `__create_time` datetime NOT NULL,
  PRIMARY KEY (`__id`),
  KEY `__id` (`__id`),
  KEY `__stock_code` (`__stock_code`),
  KEY `__stock_name` (`__stock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
