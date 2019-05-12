/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : zujuansys

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2019-05-12 00:41:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for examination
-- ----------------------------
DROP TABLE IF EXISTS `examination`;
CREATE TABLE `examination` (
  `eid` bigint(20) NOT NULL AUTO_INCREMENT,
  `question` varchar(2550) DEFAULT NULL,
  `option_json` varchar(2000) DEFAULT NULL,
  `answer` varchar(2550) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `degree` double DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `know_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `题目知识点` (`know_id`),
  CONSTRAINT `题目知识点` FOREIGN KEY (`know_id`) REFERENCES `knowledge` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for exam_basket
-- ----------------------------
DROP TABLE IF EXISTS `exam_basket`;
CREATE TABLE `exam_basket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `exam_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for exam_paper
-- ----------------------------
DROP TABLE IF EXISTS `exam_paper`;
CREATE TABLE `exam_paper` (
  `pid` bigint(20) NOT NULL AUTO_INCREMENT,
  `course_code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `total_score` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `exam_time` timestamp NULL DEFAULT NULL,
  `revise_time` timestamp NULL DEFAULT NULL,
  `degree` double DEFAULT NULL,
  `njzy` varchar(255) DEFAULT NULL,
  `file_url` varchar(255) DEFAULT NULL,
  `xz_score` int(11) DEFAULT NULL,
  `pd_score` int(255) DEFAULT NULL,
  `tk_score` int(255) DEFAULT NULL,
  `wd_score` int(255) DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for exam_paper_format
-- ----------------------------
DROP TABLE IF EXISTS `exam_paper_format`;
CREATE TABLE `exam_paper_format` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author_id` bigint(20) DEFAULT NULL,
  `paper_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for exam_type
-- ----------------------------
DROP TABLE IF EXISTS `exam_type`;
CREATE TABLE `exam_type` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for knowledge
-- ----------------------------
DROP TABLE IF EXISTS `knowledge`;
CREATE TABLE `knowledge` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `zsdName` varchar(255) NOT NULL,
  `parentId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for pager_exam_r
-- ----------------------------
DROP TABLE IF EXISTS `pager_exam_r`;
CREATE TABLE `pager_exam_r` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `eid` bigint(20) NOT NULL,
  `pid` bigint(20) NOT NULL,
  `score` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `试卷` (`pid`),
  KEY `题目` (`eid`),
  CONSTRAINT `题目` FOREIGN KEY (`eid`) REFERENCES `examination` (`eid`) ON UPDATE CASCADE,
  CONSTRAINT `试卷` FOREIGN KEY (`pid`) REFERENCES `exam_paper` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `xuehao` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `registerTime` date DEFAULT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
