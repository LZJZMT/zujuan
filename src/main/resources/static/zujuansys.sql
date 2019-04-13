/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : zujuansys

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2019-04-13 17:45:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `examination`
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
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examination
-- ----------------------------
INSERT INTO `examination` VALUES ('31', '<p></p><p class=\"MsoNormal\"><span>设</span><span lang=\"EN-US\">R</span><span>，</span><span lang=\"EN-US\">S</span><span>是集合</span><span lang=\"EN-US\">A</span><span>上的关系，则下列说法正确的是（</span><span lang=\"EN-US\"><span>&nbsp;&nbsp;&nbsp; </span></span><span>）</span><span lang=\"EN-US\"><o:p></o:p></span></p>\n\n<p class=\"MsoNormal\"><span lang=\"EN-US\"><span>&nbsp; </span>A</span><span>．若</span><span lang=\"EN-US\">R</span><span>，</span><span lang=\"EN-US\">S </span><span>是自反的，</span><span> </span><span>则<img src=\"/image/155514669004395941.png\" alt=\"undefined\"></span><span>是自反的；</span><span lang=\"EN-US\"><o:p></o:p></span></p>\n\n<p class=\"MsoNormal\"><span lang=\"EN-US\"><span>&nbsp; </span>B</span><span>．若</span><span lang=\"EN-US\">R</span><span>，</span><span lang=\"EN-US\">S </span><span>是反自反的，</span><span> </span><span>则<img src=\"/image/155514669311168.png\" alt=\"undefined\"></span>是反自反的；</p>\n\n<p class=\"MsoNormal\"><span lang=\"EN-US\"><span>&nbsp; </span>C</span><span>．若</span><span lang=\"EN-US\">R</span><span>，</span><span lang=\"EN-US\">S </span><span>是对称的，</span><span> </span><span>则<img src=\"/image/15551466963469051.png\" alt=\"undefined\"></span>是对称的；</p>\n\n<p class=\"MsoNormal\"><span lang=\"EN-US\"><span>&nbsp; </span>D</span><span>．若</span><span lang=\"EN-US\">R</span><span>，</span><span lang=\"EN-US\">S </span><span>是传递的，</span><span> </span><span>则<img src=\"/image/155514669906748864.png\" alt=\"undefined\"></span>是传递的。</p><br><p></p>', '{}', 'A', '', '2', '1', '41');
INSERT INTO `examination` VALUES ('32', '<p><p class=\"MsoNormal\"><span>设</span><span lang=\"EN-US\">P</span><span>，</span><span lang=\"EN-US\">Q </span><span>的真值为</span><span lang=\"EN-US\">0</span><span>，</span><span lang=\"EN-US\">R</span><span>，</span><span lang=\"EN-US\">S</span><span>的真值为</span><span lang=\"EN-US\">1</span><span>，则</span><span lang=\"EN-US\"><o:p></o:p></span></p>\n\n<p class=\"MsoNormal\"><span><img src=\"/image/155513783128857463.png\" alt=\"undefined\">的真值</span><span lang=\"EN-US\">= <u><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></u><span>&nbsp;</span></span><span>。</span><span lang=\"EN-US\"><o:p></o:p></span></p><br></p>', null, '12', '', '1', '2', '44');
INSERT INTO `examination` VALUES ('33', '<p><span>如下图所示的赋权图表示某七个城市<img src=\"/image/155513786421287723.png\" alt=\"undefined\"></span><span>及预先算出它们之间的一些直接通信线路造价，试给出一个设计方案，使得各城市之间能够通信而且总造价最小。</span></p><p><span><img src=\"/image/15551378803731011.png\" alt=\"undefined\"><br></span></p>', null, '预先算出它们之间的一些', '', '1', '4', '74');
INSERT INTO `examination` VALUES ('34', '为阿斯顿阿松大位切尔茜3<img src=\"/image/155514713459937526.png\" alt=\"undefined\">', null, '123', '', '1', '2', '44');

-- ----------------------------
-- Table structure for `exam_basket`
-- ----------------------------
DROP TABLE IF EXISTS `exam_basket`;
CREATE TABLE `exam_basket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `exam_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_basket
-- ----------------------------

-- ----------------------------
-- Table structure for `exam_paper`
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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_paper
-- ----------------------------
INSERT INTO `exam_paper` VALUES ('35', 'HGHJ123184329', '桂林电子科技大学离散数学期末考试试卷', '100', '2019-04-13 17:37:07', '2019-04-13 08:00:00', '2019-04-30 08:00:00', '1.2', '15软件工程', '/image/exampaper/桂林电子科技大学离散数学期末考试试卷836.1660561205831.doc', null, null, null, null, '12', '120');
INSERT INTO `exam_paper` VALUES ('36', 'RZ20192813123', '桂林电子科技大学离散数学期末考试试卷', '100', '2019-04-13 17:40:41', '2019-04-24 00:00:00', '2019-04-29 00:00:00', '1.2', '2015软件工程', '/image/exampaper/桂林电子科技大学离散数学期末考试试卷0.doc', null, null, null, null, '12', '120');

-- ----------------------------
-- Table structure for `exam_type`
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
-- Table structure for `knowledge`
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
-- Table structure for `pager_exam_r`
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
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pager_exam_r
-- ----------------------------
INSERT INTO `pager_exam_r` VALUES ('52', '31', '35', '20');
INSERT INTO `pager_exam_r` VALUES ('53', '32', '35', '20');
INSERT INTO `pager_exam_r` VALUES ('54', '33', '35', '40');
INSERT INTO `pager_exam_r` VALUES ('55', '34', '35', '20');
INSERT INTO `pager_exam_r` VALUES ('56', '31', '36', null);
INSERT INTO `pager_exam_r` VALUES ('57', '32', '36', null);
INSERT INTO `pager_exam_r` VALUES ('58', '33', '36', null);
INSERT INTO `pager_exam_r` VALUES ('59', '34', '36', null);

-- ----------------------------
-- Table structure for `persistent_logins`
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
INSERT INTO `persistent_logins` VALUES ('admin', 'BW37cCwkGgjELVz1PqBUsw==', '4McVCWHkVur0kAZC8yHU9Q==', '2019-04-13 15:33:32');
INSERT INTO `persistent_logins` VALUES ('admin', 'dk2dvpJ8rqSrJ5HPFO+H+w==', 'xZAxUi4aTX0Sg/bt0zQ9Mg==', '2019-04-13 15:31:20');
INSERT INTO `persistent_logins` VALUES ('user', 'ds0tzsbGO1fdRRmA1GvG2A==', '1OGfscwP3yeCGoFem9bYzw==', '2019-04-13 17:40:02');
INSERT INTO `persistent_logins` VALUES ('admin', 'hGkfAOIlZzYXMMFDES0IHw==', 'S1Oo82luEefGtRRTaFMPgg==', '2019-04-13 14:38:41');
INSERT INTO `persistent_logins` VALUES ('admin2', 'k7IK8zuvFBqoMt3eTx1IlQ==', 'f0frO9nVhAFYDCrkYWryUA==', '2019-01-10 14:23:21');
INSERT INTO `persistent_logins` VALUES ('李子健1', 'OCg0LQEaeCKUUdG7l6nORA==', '23OFrz97qMmoXgXx9F0+pw==', '2019-01-10 13:36:18');

-- ----------------------------
-- Table structure for `role`
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
-- Table structure for `user`
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
INSERT INTO `user` VALUES ('12', 'user', '123', null, null, null, '1');
