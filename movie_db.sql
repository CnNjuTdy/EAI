/*
Navicat MySQL Data Transfer

Source Server         : default
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : movie_db

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-06-10 20:51:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cinema
-- ----------------------------
DROP TABLE IF EXISTS `cinema`;
CREATE TABLE `cinema` (
  `id` int(11) NOT NULL,
  `maoyan_id` int(11) DEFAULT NULL,
  `taobao_id` int(11) DEFAULT NULL,
  `gewala_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `price` double(11,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cinema
-- ----------------------------
INSERT INTO `cinema` VALUES ('1', '1166', '4641', '37986382', 'UME国际影城(玄武门店)', '鼓楼区中央路201号南京国际广场购物中心6楼北区（近童家巷）', '24');
INSERT INTO `cinema` VALUES ('2', '1175', '7901', '130349048', '金逸影城(大观店)', '鼓楼区建宁路300号大观天地MALL3楼', '23');
INSERT INTO `cinema` VALUES ('3', '1178', '4586', '37950090', '卢米埃影城(紫峰店)', '鼓楼区中山北路6号绿地中心紫峰购物广场5-6楼（近湖南路）', '24');
INSERT INTO `cinema` VALUES ('4', '1187', '5744', '37949064', '和平影视娱乐城', '鼓楼区中山北路110号', '29');

-- ----------------------------
-- Table structure for gewala_plan
-- ----------------------------
DROP TABLE IF EXISTS `gewala_plan`;
CREATE TABLE `gewala_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `m_id` int(11) DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  `m_name` varchar(255) DEFAULT NULL,
  `c_name` varchar(255) DEFAULT NULL,
  `start` varchar(255) DEFAULT NULL,
  `end` varchar(255) DEFAULT NULL,
  `th` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gewala_plan
-- ----------------------------

-- ----------------------------
-- Table structure for maoyan_plan
-- ----------------------------
DROP TABLE IF EXISTS `maoyan_plan`;
CREATE TABLE `maoyan_plan` (
  `id` varchar(255) NOT NULL,
  `m_id` int(11) DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  `m_name` varchar(255) DEFAULT NULL,
  `c_name` varchar(255) DEFAULT NULL,
  `start` varchar(255) DEFAULT NULL,
  `end` varchar(255) DEFAULT NULL,
  `th` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of maoyan_plan
-- ----------------------------

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `id` int(11) NOT NULL,
  `maoyan_id` int(11) DEFAULT '-1',
  `taobao_id` int(11) DEFAULT '-1',
  `gewala_id` int(11) DEFAULT '-1',
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `star` varchar(255) DEFAULT NULL,
  `3d` int(11) DEFAULT NULL,
  `imax` int(11) DEFAULT NULL,
  `imgUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES ('1', '246012', '161044', '323881505', '加勒比海盗5：死无对证', '亡灵要复仇，船长好发愁', '乔阿吉姆·罗恩尼,艾斯彭·山德伯格', '约翰尼·德普,哈维尔·巴登,布兰顿·思怀兹', '1', '1', 'http://p0.meituan.net/165.220/movie/ee5e691b425292f455c3eac5c628cfc7904509.png');
INSERT INTO `movie` VALUES ('2', '247731', '151509', '323881509', '神奇女侠', '神力女超人，救世又圈粉', '派蒂·杰金斯', '盖尔·加朵,克里斯·派恩,罗宾·怀特', '1', '1', 'http://p1.meituan.net/165.220/movie/f013c57e9506cd2e7c609397c8da04d9213647.jpg');
INSERT INTO `movie` VALUES ('4', '249895', '150686', '323881451', '新木乃伊', '阿汤又上阵，情迷古公主', '艾里克斯·库兹曼', '汤姆·克鲁斯,索菲亚·波多拉,罗素·克劳', '1', '1', 'http://p1.meituan.net/165.220/movie/4185bf22758d232e15c5bf52f89a7553867763.png');

-- ----------------------------
-- Table structure for taobao_plan
-- ----------------------------
DROP TABLE IF EXISTS `taobao_plan`;
CREATE TABLE `taobao_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `m_id` int(11) DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  `m_name` varchar(255) DEFAULT NULL,
  `c_name` varchar(255) DEFAULT NULL,
  `start` varchar(255) DEFAULT NULL,
  `end` varchar(255) DEFAULT NULL,
  `th` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of taobao_plan
-- ----------------------------
