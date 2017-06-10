/*
Navicat MySQL Data Transfer

Source Server         : default
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : movie_db

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-06-10 15:47:29
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
-- Table structure for gewala_plan
-- ----------------------------
DROP TABLE IF EXISTS `gewala_plan`;
CREATE TABLE `gewala_plan` (
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
-- Table structure for taobao_plan
-- ----------------------------
DROP TABLE IF EXISTS `taobao_plan`;
CREATE TABLE `taobao_plan` (
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
