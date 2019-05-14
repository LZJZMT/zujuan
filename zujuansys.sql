/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : zujuansys

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2019-05-14 15:34:26
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
-- Records of examination
-- ----------------------------
INSERT INTO `examination` VALUES ('31', '<p></p><p class=\"MsoNormal\"><span>设</span><span lang=\"EN-US\">R</span><span>，</span><span lang=\"EN-US\">S</span><span>是集合</span><span lang=\"EN-US\">A</span><span>上的关系，则下列说法正确的是（</span><span lang=\"EN-US\"><span>&nbsp;&nbsp;&nbsp; </span></span><span>）</span><span lang=\"EN-US\"><o:p></o:p></span></p>\n\n<p class=\"MsoNormal\"><span lang=\"EN-US\"><span>&nbsp; </span>A</span><span>．若</span><span lang=\"EN-US\">R</span><span>，</span><span lang=\"EN-US\">S </span><span>是自反的，</span><span> </span><span>则<img src=\"/image/155514669004395941.png\" alt=\"undefined\"></span><span>是自反的；</span><span lang=\"EN-US\"><o:p></o:p></span></p>\n\n<p class=\"MsoNormal\"><span lang=\"EN-US\"><span>&nbsp; </span>B</span><span>．若</span><span lang=\"EN-US\">R</span><span>，</span><span lang=\"EN-US\">S </span><span>是反自反的，</span><span> </span><span>则<img src=\"/image/155514669311168.png\" alt=\"undefined\"></span>是反自反的；</p>\n\n<p class=\"MsoNormal\"><span lang=\"EN-US\"><span>&nbsp; </span>C</span><span>．若</span><span lang=\"EN-US\">R</span><span>，</span><span lang=\"EN-US\">S </span><span>是对称的，</span><span> </span><span>则<img src=\"/image/15551466963469051.png\" alt=\"undefined\"></span>是对称的；</p>\n\n<p class=\"MsoNormal\"><span lang=\"EN-US\"><span>&nbsp; </span>D</span><span>．若</span><span lang=\"EN-US\">R</span><span>，</span><span lang=\"EN-US\">S </span><span>是传递的，</span><span> </span><span>则<img src=\"/image/155514669906748864.png\" alt=\"undefined\"></span>是传递的。</p><br><p></p>', '{}', 'A', '', '2', '1', '41');
INSERT INTO `examination` VALUES ('32', '<p></p><p class=\"MsoNormal\"><span>设</span><span lang=\"EN-US\">P</span><span>，</span><span lang=\"EN-US\">Q</span>Q&nbsp;的真值为<span lang=\"EN-US\">0</span>，<span lang=\"EN-US\">R</span>，<span lang=\"EN-US\">S</span>的真值为<span lang=\"EN-US\">1</span>，<span lang=\"EN-US\">R</span>，<span lang=\"EN-US\">S</span>的真值为<span lang=\"EN-US\">R</span>，<span lang=\"EN-US\">S</span>的真值为<span lang=\"EN-US\">R</span>，<span lang=\"EN-US\">S</span>的真值为<span lang=\"EN-US\">R</span>，<span lang=\"EN-US\">S</span>的真值为则<img src=\"/image/155513783128857463.png\" alt=\"undefined\">的真值为&nbsp;<span lang=\"EN-US\"><u>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</u></span></p><p class=\"MsoNormal\"><span lang=\"EN-US\"></span></p><br><p></p>', null, '122', '', '3', '2', '49');
INSERT INTO `examination` VALUES ('33', '<p><span>如下图所示的赋权图表示某七个城市<img src=\"/image/155513786421287723.png\" alt=\"undefined\"></span><span>及预先算出它们之间的一些直接通信线路造价，试给出一个设计方案，使得各城市之间能够通信而且总造价最小。</span></p><p><span><img src=\"/image/15551378803731011.png\" alt=\"undefined\"><br></span></p>', null, '预先算出它们之间的一些', '', '1', '4', '74');
INSERT INTO `examination` VALUES ('34', '<p><span lang=\"EN-US\">P</span><span>：你努力，</span><span lang=\"EN-US\">Q</span><span>：你失败。“除非你努力，否则你将失败”的翻译为</span><u><span lang=\"EN-US\">&nbsp; &nbsp; &nbsp;</span></u><span>；“虽然你努力了，但还是失败了”的翻译为</span><u><span lang=\"EN-US\">&nbsp; &nbsp; &nbsp;</span></u><span>。</span></p>', null, 'P>Q', '', '2', '2', '53');
INSERT INTO `examination` VALUES ('35', '<p></p><p class=\"MsoNormal\"><span>论域</span><span lang=\"EN-US\">D={1</span><span>，</span><span lang=\"EN-US\">2}</span><span>，指定谓词</span><span lang=\"EN-US\">P&nbsp;</span>则公式<img src=\"/image/155522218162255655.png\" alt=\"undefined\">真值为\n<u><span lang=\"EN-US\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></u>。</p><br><p></p>', '{}', '12', '', '3', '2', '39');
INSERT INTO `examination` VALUES ('37', '<p class=\"MsoNormal\"><span>设<img src=\"/image/155522226605962384.png\" alt=\"undefined\"></span><span>，则</span>\n<img src=\"/image/155522227189886754.png\" alt=\"undefined\"><span>有（</span><span lang=\"EN-US\">&nbsp;&nbsp;&nbsp;&nbsp; </span><span>）个元素。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p>\n\n<span lang=\"EN-US\">A</span><span>．</span><span lang=\"EN-US\">3</span><span>；</span><span lang=\"EN-US\">&nbsp;&nbsp;&nbsp;&nbsp; B</span><span>．</span><span lang=\"EN-US\">6</span><span>；</span><span lang=\"EN-US\">&nbsp;&nbsp; C</span><span>．</span><span lang=\"EN-US\">7</span><span>；</span><span lang=\"EN-US\">&nbsp;&nbsp;&nbsp; D</span><span>．</span><span lang=\"EN-US\">8 </span><span>。</span></p>', '{}', 'A', '', '1', '1', '45');
INSERT INTO `examination` VALUES ('38', '<p></p><p class=\"MsoNormal\"><span>设<img src=\"/image/155522229581540872.png\" alt=\"undefined\"></span><span>，</span><span lang=\"EN-US\">S</span><span>上关系</span><span lang=\"EN-US\">R</span><span>的关系图如下，</span>则<span lang=\"EN-US\">R</span>具有（<span lang=\"EN-US\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>）性质。</p><p class=\"MsoNormal\"><span><img src=\"/image/155522231278022250.png\" alt=\"undefined\"><br></span></p>\n\n<p class=\"MsoNormal\"><br></p><p class=\"MsoNormal\" style=\"text-align: left;\"><span lang=\"EN-US\">A</span><span>．自反性、对称性、传递性；&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span><span lang=\"EN-US\">B</span><span>．反自反性、反对称性；</span><span lang=\"EN-US\"><o:p></o:p></span></p><p></p><p class=\"MsoNormal\">\n\n<span lang=\"EN-US\">C</span><span>．反自反性、反对称性、传递性；&nbsp; &nbsp; &nbsp;&nbsp;</span><span lang=\"EN-US\">D</span><span>．自反性</span></p><p><br></p>', '{}', 'D', '', '3', '1', '55');
INSERT INTO `examination` VALUES ('40', '<p><p class=\"MsoNormal\"><span>下面偏序集（</span><span lang=\"EN-US\"><span>&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span>）能构成格。</span></p><p class=\"MsoNormal\"><img src=\"/image/15552226732587423.png\" alt=\"undefined\"><br></p></p>', '{}', 'A', '', '2', '1', '58');
INSERT INTO `examination` VALUES ('41', '<p><p class=\"MsoNormal\"><span>在如下的有向图中，从</span><span lang=\"EN-US\">V<sub>1</sub></span><span>到</span><span lang=\"EN-US\">V<sub>4</sub></span><span>长度为</span><span lang=\"EN-US\">3 </span><span>的道路有（</span><span lang=\"EN-US\"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span>）条。</span></p><p class=\"MsoNormal\"><span><img src=\"/image/155522271736773755.png\" alt=\"undefined\"><br></span></p>\n\n<p class=\"MsoNormal\"><span lang=\"EN-US\">A</span><span>．</span><span lang=\"EN-US\">1</span><span>；</span><span lang=\"EN-US\"><span>&nbsp;&nbsp;&nbsp;&nbsp; </span>B</span><span>．</span><span lang=\"EN-US\">2</span><span>；</span><span lang=\"EN-US\"><span>&nbsp;&nbsp;&nbsp;&nbsp; </span>C</span><span>．</span><span lang=\"EN-US\">3</span><span>；</span><span lang=\"EN-US\"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>D</span><span>．</span><span lang=\"EN-US\">4 </span><span>。</span><span lang=\"EN-US\"><o:p></o:p></span></p><br></p>', '{}', 'A', '', '1', '1', '68');
INSERT INTO `examination` VALUES ('42', '<p></p><p class=\"MsoNormal\"><!--[if !supportLists]--><span lang=\"EN-US\"><span>1、<span>&nbsp; </span></span></span><!--[endif]--><span>设</span><span lang=\"EN-US\"> f</span><span>，</span><span lang=\"EN-US\">g</span><span>是自然数集</span><span lang=\"EN-US\">N</span><span>上的函数，</span>则<img src=\"/image/155522274773176773.png\" alt=\"undefined\"><u><span lang=\"EN-US\">&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span></u>。</p><br><p></p>', null, '23', '', '4', '2', '51');
INSERT INTO `examination` VALUES ('44', '<p class=\"MsoNormal\"><span>谓词<img src=\"/image/155522283243878415.png\" alt=\"undefined\"></span><span>的前束范式为</span><u>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</u></p>', null, '12', '', '1', '2', '58');
INSERT INTO `examination` VALUES ('45', '<p></p><p class=\"MsoNormal\"><span>集合<img src=\"/image/155522315556833424.png\" alt=\"undefined\"></span></p>\n\n<p class=\"MsoNormal\"><span>1.证明</span><span lang=\"EN-US\">R</span><span>是</span><span lang=\"EN-US\">X</span><span>上的等价关系。</span> <span>（</span><span lang=\"EN-US\">10</span><span>分）</span><span lang=\"EN-US\"><o:p></o:p></span></p>\n\n<p class=\"MsoNormal\"><span>2.求出</span><span lang=\"EN-US\">X</span><span>关于</span><span lang=\"EN-US\">R</span><span>的商集。（</span><span lang=\"EN-US\">4</span><span>分）</span><span lang=\"EN-US\"><o:p></o:p></span></p><br><p></p>', null, '证明R是X上的等价关系。', '', '3', '4', '63');
INSERT INTO `examination` VALUES ('46', '<p style=\"text-align: left;\">集合集合集合集合集合集合集合集合集合集合集合集合集合集合集合集合集合集合集合集合集合集合集合集合集合集合集问题</p><p style=\"text-align: left;\">A.集合对的&nbsp; &nbsp; &nbsp; B.集合是什么</p><p style=\"text-align: left;\">C集合是集合&nbsp; &nbsp; &nbsp; D.集合是错的</p>', '{}', 'A', '', '3', '1', '40');
INSERT INTO `examination` VALUES ('47', '<p>集合集合集合集合集合集合集合集合集合集合集合集合集合集合集合集合集合集合_____</p>', null, '12', '', '2', '2', '39');
INSERT INTO `examination` VALUES ('48', '<p>什么是集合( )</p><p>A.集合对的&nbsp; &nbsp; &nbsp; B.集合是什么</p><p>C集合是集合&nbsp; &nbsp; &nbsp; D.集合是错的</p>', '{}', 'A', '', '1', '1', '41');
INSERT INTO `examination` VALUES ('49', '<p>下面偏序集（ ）能构成格。</p><p>A.<img src=\"/image/155522522571211858.png\" alt=\"undefined\">&nbsp; &nbsp; &nbsp; B.<img src=\"/image/155522524072490974.png\" alt=\"undefined\"><br></p><p>C.<img src=\"/image/1555225245922977.png\" alt=\"undefined\">&nbsp; &nbsp; &nbsp; D.<img src=\"/image/155522525495847654.png\" alt=\"undefined\"></p>', '{}', 'D', '', '2', '1', '40');
INSERT INTO `examination` VALUES ('50', '集合是对的还是错的___', null, 'X', '', '2', '3', '40');
INSERT INTO `examination` VALUES ('51', '集合可以加减，这句话对吗', null, 'X', '', '1', '3', '41');
INSERT INTO `examination` VALUES ('52', '<p class=\"MsoNormal\"><span><img src=\"/image/155522614391765080.png\" alt=\"undefined\">的主析取范式中含极小项的个数为（</span><span lang=\"EN-US\">&nbsp;&nbsp;&nbsp; </span><span>）。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p>\n\n<span lang=\"EN-US\">A </span><span>、</span><span lang=\"EN-US\">2</span><span>；</span><span lang=\"EN-US\">&nbsp; B</span><span>、</span><span lang=\"EN-US\"> 3</span><span>；</span><span lang=\"EN-US\">&nbsp;&nbsp; C</span><span>、</span><span lang=\"EN-US\">5</span><span>；</span><span lang=\"EN-US\">&nbsp;&nbsp; D</span><span>、</span><span lang=\"EN-US\">0&nbsp;</span></p>', '{}', 'A', '', '2', '1', '39');
INSERT INTO `examination` VALUES ('53', '<p><span>权数</span><span lang=\"EN-US\">1</span><span>，</span><span lang=\"EN-US\">4</span><span>，</span><span lang=\"EN-US\">9</span><span>，</span><span lang=\"EN-US\">16</span><span>，</span><span lang=\"EN-US\">25</span><span>，</span><span lang=\"EN-US\">36</span><span>，</span><span lang=\"EN-US\">49</span><span>，</span><span lang=\"EN-US\">64</span><span>，</span><span lang=\"EN-US\">81</span><span>，</span><span lang=\"EN-US\">100</span><span>构造一棵最优二叉树。</span></p>', null, '顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶', '', '2', '4', '80');
INSERT INTO `examination` VALUES ('54', '<p><span>所表达的子集是</span><span>所表达的子集是</span><span>所表达的子集是____</span></p>', null, '333', '', '2', '2', '80');
INSERT INTO `examination` VALUES ('55', '<p><span>啊啊啊的子集是</span><span>所表达的子集是</span><span>所表达的子集是？</span></p>', null, '√', '', '1', '3', '53');
INSERT INTO `examination` VALUES ('56', '<p><span>啊啊啊的子集是</span><span>所表达的子集是</span><span>所表达的子集是？</span></p>', null, '√', '', '1', '3', '53');
INSERT INTO `examination` VALUES ('57', '哈哈哈哈哈哈哈哈哈哈哈哈____', null, 'x', '', '1', '2', '79');
INSERT INTO `examination` VALUES ('59', 'qweweqweqwe<img src=\"/image/155749120533377895.png\" alt=\"undefined\">', '{}', 'A', '', '2', '1', '45');
INSERT INTO `examination` VALUES ('60', '驱蚊器恶趣味&nbsp;<img src=\"/image/155750045081671844.png\" alt=\"undefined\">', null, '七千万', '', '1', '2', '50');

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
-- Records of exam_basket
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_paper
-- ----------------------------
INSERT INTO `exam_paper` VALUES ('37', 'BS321293912', '离散数学试卷离散数学试卷', '100', '2019-04-13 20:28:17', '2019-04-23 00:00:00', '2019-04-25 00:00:00', '1.5', '2015计算机科学与技术', '/image/exampaper/离散数学试卷离散数学试卷530.doc', null, null, null, null, '12', '120');
INSERT INTO `exam_paper` VALUES ('39', '123', '123', '100', '2019-04-14 14:42:41', '2019-04-01 00:00:00', '2019-04-14 00:00:00', '2', '1231', '/image/exampaper/123742.doc', null, null, null, null, '12', '123');
INSERT INTO `exam_paper` VALUES ('40', 'BS2139123', '自动生成的试卷', '48', '2019-04-23 20:20:37', '2019-04-23 00:00:00', '2019-04-25 00:00:00', '2', '软件工程', '/image/exampaper/自动生成的试卷124.doc', null, null, null, null, '1', '120');
INSERT INTO `exam_paper` VALUES ('41', '12', '自动生成', '60', '2019-04-23 20:22:08', '2019-04-23 00:00:00', '2019-04-23 00:00:00', '2.4', '123', '/image/exampaper/自动生成446.doc', null, null, null, null, '1', '123');
INSERT INTO `exam_paper` VALUES ('42', 'eee', 'eee', '60', '2019-04-23 20:26:33', '2019-04-02 00:00:00', '2019-04-23 00:00:00', '1.8', 'ee', '/image/exampaper/eee959.doc', null, null, null, null, '1', '120');
INSERT INTO `exam_paper` VALUES ('43', 'qwe', 'qe', '36', '2019-04-23 20:29:36', '2019-04-05 00:00:00', '2019-04-23 20:29:36', '1.7', '12', '/image/exampaper/qe119.doc', null, null, null, null, '1', '120');
INSERT INTO `exam_paper` VALUES ('44', '123123', 'qw', '100', '2019-04-23 20:31:47', '2019-04-23 00:00:00', '2019-04-27 00:00:00', '2', '123', '/image/exampaper/qw44590.doc', null, null, null, null, '1', '12');
INSERT INTO `exam_paper` VALUES ('45', 'qwe', 'qwe', '100', '2019-04-23 20:32:16', '2019-04-01 00:00:00', '2019-04-23 20:32:16', '2', 'qwe', '/image/exampaper/qwe21958.doc', null, null, null, null, '1', '123');
INSERT INTO `exam_paper` VALUES ('47', 'BS21391392', '桂电离散数学试卷11111111', '100', '2019-04-23 20:59:38', '2019-04-23 00:00:00', '2019-04-25 00:00:00', '2.2', '软件工程', '/image/exampaper/桂电离散数学试卷1111111155153.doc', null, null, null, null, '1', '120');
INSERT INTO `exam_paper` VALUES ('49', 'qweqwe', 'qweqwe', '66', '2019-05-10 19:39:01', '2019-05-10 19:38:46', '2019-05-24 00:08:00', '2', 'qwe', '/image/exampaper/qweqwe65194.doc', null, null, null, null, '1', '120');
INSERT INTO `exam_paper` VALUES ('50', 'werwer', 'ederwe', '100', '2019-05-10 19:43:51', '2019-05-24 00:00:00', '2019-05-10 19:43:50', '2.2', 'werwer', '/image/exampaper/ederwe37854.doc', null, null, null, null, '1', '120');
INSERT INTO `exam_paper` VALUES ('51', 'werwer', 'reewrwer', '79', '2019-05-10 19:52:08', '2019-05-17 00:00:00', '2019-05-31 00:00:00', '2.3', 'werwer', '/image/exampaper/reewrwer9033.doc', null, null, null, null, '1', '120');
INSERT INTO `exam_paper` VALUES ('52', '234', '23', '100', '2019-05-10 19:56:10', '2019-05-17 00:00:00', '2019-05-11 00:00:00', '2', '234', '/image/exampaper/2376196.doc', null, null, null, null, '1', '12');
INSERT INTO `exam_paper` VALUES ('53', 'eqwe', 'qweqw', '100', '2019-05-10 19:58:04', '2019-05-31 00:00:00', '2019-05-10 19:57:24', '2', 'qwe', '/image/exampaper/qweqw93819.doc', null, null, null, null, '1', '122');
INSERT INTO `exam_paper` VALUES ('54', 'BS29139123', '桂林电子科技大学离散数学考试', '100', '2019-05-12 14:07:07', '2019-05-09 00:00:00', '2019-05-31 00:00:00', '2', '16级软件工程', '/image/exampaper/桂林电子科技大学离散数学考试18429.doc', null, null, null, null, '1', '120');

-- ----------------------------
-- Table structure for exam_paper_format
-- ----------------------------
DROP TABLE IF EXISTS `exam_paper_format`;
CREATE TABLE `exam_paper_format` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author_id` bigint(20) DEFAULT NULL,
  `paper_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_paper_format
-- ----------------------------
INSERT INTO `exam_paper_format` VALUES ('1', '1', '48');
INSERT INTO `exam_paper_format` VALUES ('13', '1', '53');
INSERT INTO `exam_paper_format` VALUES ('14', '1', '52');
INSERT INTO `exam_paper_format` VALUES ('15', '1', '51');
INSERT INTO `exam_paper_format` VALUES ('16', '1', '54');

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
  CONSTRAINT `题目` FOREIGN KEY (`eid`) REFERENCES `examination` (`eid`) ON UPDATE CASCADE,
  CONSTRAINT `试卷` FOREIGN KEY (`pid`) REFERENCES `exam_paper` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pager_exam_r
-- ----------------------------
INSERT INTO `pager_exam_r` VALUES ('60', '31', '37', null);
INSERT INTO `pager_exam_r` VALUES ('61', '34', '37', null);
INSERT INTO `pager_exam_r` VALUES ('72', '31', '39', null);
INSERT INTO `pager_exam_r` VALUES ('73', '31', '40', '12');
INSERT INTO `pager_exam_r` VALUES ('74', '52', '40', '12');
INSERT INTO `pager_exam_r` VALUES ('75', '38', '40', '12');
INSERT INTO `pager_exam_r` VALUES ('76', '32', '40', '12');
INSERT INTO `pager_exam_r` VALUES ('77', '49', '41', '12');
INSERT INTO `pager_exam_r` VALUES ('78', '40', '41', '12');
INSERT INTO `pager_exam_r` VALUES ('79', '31', '41', '12');
INSERT INTO `pager_exam_r` VALUES ('80', '46', '41', '12');
INSERT INTO `pager_exam_r` VALUES ('81', '38', '41', '12');
INSERT INTO `pager_exam_r` VALUES ('82', '41', '42', '12');
INSERT INTO `pager_exam_r` VALUES ('83', '37', '42', '12');
INSERT INTO `pager_exam_r` VALUES ('84', '31', '42', '12');
INSERT INTO `pager_exam_r` VALUES ('85', '49', '42', '12');
INSERT INTO `pager_exam_r` VALUES ('86', '38', '42', '12');
INSERT INTO `pager_exam_r` VALUES ('87', '49', '43', '12');
INSERT INTO `pager_exam_r` VALUES ('88', '52', '43', '12');
INSERT INTO `pager_exam_r` VALUES ('89', '32', '43', '12');
INSERT INTO `pager_exam_r` VALUES ('90', '40', '44', null);
INSERT INTO `pager_exam_r` VALUES ('91', '31', '44', null);
INSERT INTO `pager_exam_r` VALUES ('92', '49', '44', null);
INSERT INTO `pager_exam_r` VALUES ('93', '32', '44', null);
INSERT INTO `pager_exam_r` VALUES ('94', '34', '44', null);
INSERT INTO `pager_exam_r` VALUES ('95', '54', '44', null);
INSERT INTO `pager_exam_r` VALUES ('96', '35', '44', null);
INSERT INTO `pager_exam_r` VALUES ('97', '31', '45', null);
INSERT INTO `pager_exam_r` VALUES ('103', '32', '47', '20');
INSERT INTO `pager_exam_r` VALUES ('104', '34', '47', '20');
INSERT INTO `pager_exam_r` VALUES ('105', '35', '47', '20');
INSERT INTO `pager_exam_r` VALUES ('106', '44', '47', '20');
INSERT INTO `pager_exam_r` VALUES ('107', '47', '47', '20');
INSERT INTO `pager_exam_r` VALUES ('116', '52', '49', '22');
INSERT INTO `pager_exam_r` VALUES ('117', '40', '49', '22');
INSERT INTO `pager_exam_r` VALUES ('118', '31', '49', '22');
INSERT INTO `pager_exam_r` VALUES ('119', '41', '50', null);
INSERT INTO `pager_exam_r` VALUES ('120', '40', '50', null);
INSERT INTO `pager_exam_r` VALUES ('121', '38', '50', null);
INSERT INTO `pager_exam_r` VALUES ('122', '32', '50', null);
INSERT INTO `pager_exam_r` VALUES ('123', '35', '51', '22');
INSERT INTO `pager_exam_r` VALUES ('124', '47', '51', '23');
INSERT INTO `pager_exam_r` VALUES ('125', '52', '51', '34');
INSERT INTO `pager_exam_r` VALUES ('126', '48', '52', null);
INSERT INTO `pager_exam_r` VALUES ('127', '31', '52', null);
INSERT INTO `pager_exam_r` VALUES ('128', '32', '52', null);
INSERT INTO `pager_exam_r` VALUES ('129', '31', '53', null);
INSERT INTO `pager_exam_r` VALUES ('130', '32', '53', null);
INSERT INTO `pager_exam_r` VALUES ('131', '33', '53', null);
INSERT INTO `pager_exam_r` VALUES ('132', '31', '54', null);

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
INSERT INTO `persistent_logins` VALUES ('admin', '1QojRq+VqPgbUgRY2uyuVg==', 'p1qQsXMHaflswuIRdny2NA==', '2019-04-23 21:02:50');
INSERT INTO `persistent_logins` VALUES ('admin2', 'k7IK8zuvFBqoMt3eTx1IlQ==', 'f0frO9nVhAFYDCrkYWryUA==', '2019-01-10 14:23:21');
INSERT INTO `persistent_logins` VALUES ('李子健1', 'OCg0LQEaeCKUUdG7l6nORA==', '23OFrz97qMmoXgXx9F0+pw==', '2019-01-10 13:36:18');
INSERT INTO `persistent_logins` VALUES ('1500330217', 'x05Boj8CMkVMUX48MKr4Rg==', 'BLjrDzb5GwNDV2O/oUOZsw==', '2019-05-14 11:16:11');

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
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('30', '1500330217', '李子健88', '66', '51');
INSERT INTO `score` VALUES ('31', '1500330218', '李子健12314', '15', '51');
INSERT INTO `score` VALUES ('32', '1500330217', '李子健88', '999', '53');
INSERT INTO `score` VALUES ('33', '1500330218', '李子健12314', '12315', '53');
INSERT INTO `score` VALUES ('34', '1500330217', '李子健88', '999', '52');
INSERT INTO `score` VALUES ('35', '1500330218', '李子健12314', '12315', '52');
INSERT INTO `score` VALUES ('36', '1500330219', '李12子健', '415.2', '52');
INSERT INTO `score` VALUES ('37', '1500330217', '李子健88', '65', '54');
INSERT INTO `score` VALUES ('38', '1500330218', '李子健12314', '66', '54');
INSERT INTO `score` VALUES ('39', '1500330219', '李12子健', '78', '54');
INSERT INTO `score` VALUES ('40', '1500330220', '李帅', '143', '54');
INSERT INTO `score` VALUES ('41', '6555664', '李子健111', '23', '53');
INSERT INTO `score` VALUES ('42', '1500330219', '李12子健', '15.2', '51');
INSERT INTO `score` VALUES ('43', '1500330219', '李12子健', '415.2', '53');

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1500330217', '123', '15676383609', '852533466@qq.com', '2019-01-09', '2');
INSERT INTO `user` VALUES ('2', 'admin2', '179013', null, '852533466@qq.com', '2019-01-09', '2');
INSERT INTO `user` VALUES ('6', 'admin3', 'qqqqqq', null, '852533466@qq.com', '2019-01-09', '2');
INSERT INTO `user` VALUES ('7', 'admin4', 'qqqqqq', null, '852533466@qq.com', '2019-01-09', '2');
INSERT INTO `user` VALUES ('8', 'admin5', 'qqqqqq', null, '852533466@qq.com', '2019-01-09', '2');
INSERT INTO `user` VALUES ('9', '李子健', 'qqqqqq', null, '852533466@qq.com', '2019-01-10', '2');
INSERT INTO `user` VALUES ('10', '李子健1', 'qqqq1234', null, '852533466@qq.com', '2019-01-10', '2');
INSERT INTO `user` VALUES ('11', 'adminadmin', 'qqqq1234', null, '852533466@qq.com', '2019-01-11', '2');
INSERT INTO `user` VALUES ('12', 'user', '123', null, null, null, '1');
INSERT INTO `user` VALUES ('13', 'admin', 'qqqq1234', null, '852533466@qq.com', '2019-05-13', '2');
