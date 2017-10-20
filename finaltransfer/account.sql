/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : transaction

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-10-20 22:54:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `money` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'aaa', '900');
INSERT INTO `account` VALUES ('2', 'bbb', '1100');
INSERT INTO `account` VALUES ('3', 'ccc', '1000');
INSERT INTO `account` VALUES ('4', 'ddd', '1000');
INSERT INTO `account` VALUES ('5', 'eee', '1000');
