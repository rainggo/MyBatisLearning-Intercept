/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50542
 Source Host           : localhost
 Source Database       : MyBatisLearning

 Target Server Type    : MySQL
 Target Server Version : 50542
 File Encoding         : utf-8

 Date: 07/31/2016 19:48:04 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `command`
-- ----------------------------
DROP TABLE IF EXISTS `command`;
CREATE TABLE `command` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(16) DEFAULT NULL,
  `DESCRIPTION` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `command`
-- ----------------------------
BEGIN;
INSERT INTO `command` VALUES ('1', '段子', '精彩段子');
COMMIT;

-- ----------------------------
--  Table structure for `command_content`
-- ----------------------------
DROP TABLE IF EXISTS `command_content`;
CREATE TABLE `command_content` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CONTENT` varchar(2048) DEFAULT NULL,
  `COMMAND_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `command_content`
-- ----------------------------
BEGIN;
INSERT INTO `command_content` VALUES ('1', '段子1', '1'), ('2', '段子2', '1'), ('3', '段子3', '1'), ('4', '段子4', '1'), ('5', '段子5', '1');
COMMIT;

-- ----------------------------
--  Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COMMAND` varchar(16) DEFAULT NULL,
  `DESCRIPTION` varchar(32) DEFAULT NULL,
  `CONTENT` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `message`
-- ----------------------------
BEGIN;
INSERT INTO `message` VALUES ('8', '查看', '精彩内容', '精彩内容'), ('9', '查看', '精彩内容', '精彩内容'), ('10', '查看', '精彩内容', '精彩内容');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
