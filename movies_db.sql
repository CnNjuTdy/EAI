/*
 Navicat Premium Data Transfer

 Source Server         : localhost 2
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : movies_db

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 07/08/2017 15:27:35 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `douban_comment`
-- ----------------------------
DROP TABLE IF EXISTS `douban_comment`;
CREATE TABLE `douban_comment` (
  `id` int(11) NOT NULL,
  `movie_id` varchar(11) DEFAULT NULL,
  `score` double(20,0) DEFAULT NULL,
  `comment` varchar(2000) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `maoyan_comment`
-- ----------------------------
DROP TABLE IF EXISTS `maoyan_comment`;
CREATE TABLE `maoyan_comment` (
  `id` int(11) NOT NULL,
  `movie_id` varchar(11) DEFAULT NULL,
  `score` double(20,0) DEFAULT NULL,
  `comment` varchar(2000) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `movie`
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `id` int(11) NOT NULL,
  `maoyan_id` int(11) DEFAULT '-1',
  `douban_id` int(11) DEFAULT '-1',
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `movie`
-- ----------------------------
BEGIN;
INSERT INTO `movie` VALUES ('1', '246012', '161044', '加勒比海盗5：死无对证'), ('2', '247731', '151509', '神奇女侠'), ('4', '249895', '150686', '新木乃伊');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
