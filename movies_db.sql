/*
Navicat MySQL Data Transfer

Source Server         : default
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : movie_db

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-07-08 21:52:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_id` varchar(11) CHARACTER SET utf8mb4 DEFAULT NULL,
  `score` double(20,0) DEFAULT NULL,
  `comment` varchar(2000) CHARACTER SET utf8mb4 DEFAULT NULL,
  `preScore` double(11,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7292 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `id` int(11) NOT NULL,
  `maoyan_id` int(11) DEFAULT '-1',
  `douban_id` int(11) DEFAULT '-1',
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
