/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : gy

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 27/04/2020 17:15:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fieid
-- ----------------------------
DROP TABLE IF EXISTS `fieid`;
CREATE TABLE `fieid` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '场地id',
  `name` varchar(255) DEFAULT NULL COMMENT '场地名称',
  `start_time` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '场地开放时间',
  `end_time` varchar(255) DEFAULT NULL COMMENT '场地结束时间',
  `status` int(1) DEFAULT '0' COMMENT '场地状态 0 可预约 1 不可预约',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fieid
-- ----------------------------
BEGIN;
INSERT INTO `fieid` VALUES (13, '太原中心体育馆', '08:00', '22:00', 0);
INSERT INTO `fieid` VALUES (14, '太原理工大体育馆', '04:59', '22:59', 0);
COMMIT;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '预约id',
  `user_id` int(10) DEFAULT NULL COMMENT '预约人id',
  `fieid` int(10) DEFAULT NULL COMMENT '场地id',
  `gy_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '预约日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
BEGIN;
INSERT INTO `order` VALUES (8, 5, 13, '2020-05-01');
INSERT INTO `order` VALUES (9, 6, 13, '2020-12-31');
INSERT INTO `order` VALUES (10, 7, 13, '2020-04-30');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `user_account` varchar(255) DEFAULT NULL COMMENT '用户账号',
  `user_pwd` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `user_type` int(1) DEFAULT '2' COMMENT '用户类型，1 管理员 2 用户',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (5, 'test', '1', '1', 2);
INSERT INTO `user` VALUES (6, 'admin', '12', '12', 1);
INSERT INTO `user` VALUES (7, '普通用户1', 'a', '1', 2);
INSERT INTO `user` VALUES (8, 'root', 'root', '1', 1);
INSERT INTO `user` VALUES (9, '超级用户', 'admin', 'admin', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
