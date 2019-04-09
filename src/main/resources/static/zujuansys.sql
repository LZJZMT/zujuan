/*
Navicat MySQL Data Transfer

Source Server         : linux
Source Server Version : 100038
Source Host           : 172.0.5.173:3306
Source Database       : zujuansys

Target Server Type    : MYSQL
Target Server Version : 100038
File Encoding         : 65001

Date: 2019-04-09 15:29:48
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examination
-- ----------------------------
INSERT INTO `examination` VALUES ('26', '<p class=\"MsoNormal\"><span>设</span><span>&nbsp;<img src=\"/image/155470461745465892.png\" alt=\"undefined\"></span><span>（</span><span>N</span><span>：自然数集，</span><span>E</span><sub><span></span></sub><sup><span>+</span></sup><span>&nbsp;</span><span>正偶数）</span><span>则</span><span><img src=\"/image/155470462889767345.png\" alt=\"undefined\"></span><u><span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span></u><span>&nbsp;</span><span>。</span><span><o:p></o:p></span></p>', null, '{1,2,3}', '', '2', '2', '37');
INSERT INTO `examination` VALUES ('28', 'sadasdasdasd', '{}', 'aa', '', '1', '1', '38');
INSERT INTO `examination` VALUES ('29', 'wqqweqeqe<img src=\"/image/155470867503733929.png\" alt=\"undefined\">', null, 'q', '', '1', '3', '50');

-- ----------------------------
-- Table structure for exam_basket
-- ----------------------------
DROP TABLE IF EXISTS `exam_basket`;
CREATE TABLE `exam_basket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `exam_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_basket
-- ----------------------------
INSERT INTO `exam_basket` VALUES ('60', '1', '26');
INSERT INTO `exam_basket` VALUES ('61', '1', '28');
INSERT INTO `exam_basket` VALUES ('62', '1', '29');

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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_paper
-- ----------------------------
INSERT INTO `exam_paper` VALUES ('26', '34', '人', null, '2019-04-09 15:12:05', '2019-04-17 00:00:03', '2019-04-23 00:00:00', '1.3', '13', null, null, null, null, null, '1', null);
INSERT INTO `exam_paper` VALUES ('27', '123', 'qwe', null, '2019-04-09 15:20:34', '2019-04-18 00:00:00', '2019-04-23 00:00:00', '1.3', '34', null, null, null, null, null, '1', null);

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
-- Records of exam_type
-- ----------------------------
INSERT INTO `exam_type` VALUES ('1', '选择题');
INSERT INTO `exam_type` VALUES ('2', '填空题');
INSERT INTO `exam_type` VALUES ('3', '判断题');
INSERT INTO `exam_type` VALUES ('4', '问答题');

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
-- Records of knowledge
-- ----------------------------
INSERT INTO `knowledge` VALUES ('36', '集合', null);
INSERT INTO `knowledge` VALUES ('37', '集合的概念及表示', '36');
INSERT INTO `knowledge` VALUES ('38', '特殊集合', '36');
INSERT INTO `knowledge` VALUES ('39', '集合的运算', '36');
INSERT INTO `knowledge` VALUES ('40', '计数问题', '36');
INSERT INTO `knowledge` VALUES ('41', '集合的应用', '36');
INSERT INTO `knowledge` VALUES ('42', '关系', null);
INSERT INTO `knowledge` VALUES ('43', '关系的概念及表示', '42');
INSERT INTO `knowledge` VALUES ('44', '关系的性质', '42');
INSERT INTO `knowledge` VALUES ('45', '关系的运算', '42');
INSERT INTO `knowledge` VALUES ('46', '特殊关系', '42');
INSERT INTO `knowledge` VALUES ('47', '关系的应用', '42');
INSERT INTO `knowledge` VALUES ('48', '函数', null);
INSERT INTO `knowledge` VALUES ('49', '函数的概念', '48');
INSERT INTO `knowledge` VALUES ('50', '函数的运算', '48');
INSERT INTO `knowledge` VALUES ('51', '函数的应用', '48');
INSERT INTO `knowledge` VALUES ('52', '命题逻辑', null);
INSERT INTO `knowledge` VALUES ('53', '命题逻辑的基本概念', '52');
INSERT INTO `knowledge` VALUES ('54', '命题逻辑公式', '52');
INSERT INTO `knowledge` VALUES ('55', '命题逻辑推理', '52');
INSERT INTO `knowledge` VALUES ('56', '命题逻辑的应用', '52');
INSERT INTO `knowledge` VALUES ('57', '谓词逻辑', null);
INSERT INTO `knowledge` VALUES ('58', '谓词逻辑的基本概念', '57');
INSERT INTO `knowledge` VALUES ('59', '谓词逻辑公式', '57');
INSERT INTO `knowledge` VALUES ('60', '谓词逻辑推理', '57');
INSERT INTO `knowledge` VALUES ('61', '谓词逻辑的应用', '57');
INSERT INTO `knowledge` VALUES ('62', '代数系统', null);
INSERT INTO `knowledge` VALUES ('63', '代数系统的基本概念', '62');
INSERT INTO `knowledge` VALUES ('64', '代数运算的性质', '62');
INSERT INTO `knowledge` VALUES ('65', '相互联系的代数系统', '62');
INSERT INTO `knowledge` VALUES ('66', '代数系统的应用', '62');
INSERT INTO `knowledge` VALUES ('67', '典型代数系统', null);
INSERT INTO `knowledge` VALUES ('68', '半群和群', '67');
INSERT INTO `knowledge` VALUES ('69', '环和域', '67');
INSERT INTO `knowledge` VALUES ('70', '格和布尔代数', '67');
INSERT INTO `knowledge` VALUES ('71', '图', null);
INSERT INTO `knowledge` VALUES ('72', '图的概念与表示', '71');
INSERT INTO `knowledge` VALUES ('73', '赋权图', '71');
INSERT INTO `knowledge` VALUES ('74', '欧拉图', '71');
INSERT INTO `knowledge` VALUES ('75', '哈密顿图', '71');
INSERT INTO `knowledge` VALUES ('76', '二部图', '71');
INSERT INTO `knowledge` VALUES ('77', '平面图', '71');
INSERT INTO `knowledge` VALUES ('78', '树', null);
INSERT INTO `knowledge` VALUES ('79', '无向树', '78');
INSERT INTO `knowledge` VALUES ('80', '有向树', '78');

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
  CONSTRAINT `试卷` FOREIGN KEY (`pid`) REFERENCES `exam_paper` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `题目` FOREIGN KEY (`eid`) REFERENCES `examination` (`eid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pager_exam_r
-- ----------------------------
INSERT INTO `pager_exam_r` VALUES ('26', '26', '26', null);
INSERT INTO `pager_exam_r` VALUES ('27', '26', '27', '12');
INSERT INTO `pager_exam_r` VALUES ('28', '28', '27', '12');
INSERT INTO `pager_exam_r` VALUES ('29', '29', '27', '34');

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
-- Records of persistent_logins
-- ----------------------------
INSERT INTO `persistent_logins` VALUES ('admin', 'FuNImWxcKZbWG4qDelUAMw==', 'EiMH6jaXwG5OisWLfmLEVg==', '2019-04-09 14:05:26');
INSERT INTO `persistent_logins` VALUES ('admin2', 'k7IK8zuvFBqoMt3eTx1IlQ==', 'f0frO9nVhAFYDCrkYWryUA==', '2019-01-10 14:23:21');
INSERT INTO `persistent_logins` VALUES ('李子健1', 'OCg0LQEaeCKUUdG7l6nORA==', '23OFrz97qMmoXgXx9F0+pw==', '2019-01-10 13:36:18');

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
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员');

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'qqqqqq', '15676383609', '852533466@qq.com', '2019-01-09', '1');
INSERT INTO `user` VALUES ('2', 'admin2', '179013', null, '852533466@qq.com', '2019-01-09', '2');
INSERT INTO `user` VALUES ('3', 'admin2', 'qqqqqq', null, '852533466@qq.com', '2019-01-09', '2');
INSERT INTO `user` VALUES ('4', 'admin2', 'qqqqqq', null, '852533466@qq.com', '2019-01-09', '2');
INSERT INTO `user` VALUES ('5', 'admin2', 'qqqqqq', null, '852533466@qq.com', '2019-01-09', '2');
INSERT INTO `user` VALUES ('6', 'admin3', 'qqqqqq', null, '852533466@qq.com', '2019-01-09', '2');
INSERT INTO `user` VALUES ('7', 'admin4', 'qqqqqq', null, '852533466@qq.com', '2019-01-09', '2');
INSERT INTO `user` VALUES ('8', 'admin5', 'qqqqqq', null, '852533466@qq.com', '2019-01-09', '2');
INSERT INTO `user` VALUES ('9', '李子健', 'qqqqqq', null, '852533466@qq.com', '2019-01-10', '2');
INSERT INTO `user` VALUES ('10', '李子健1', 'qqqq1234', null, '852533466@qq.com', '2019-01-10', '2');
INSERT INTO `user` VALUES ('11', 'adminadmin', 'qqqq1234', null, '852533466@qq.com', '2019-01-11', '2');
