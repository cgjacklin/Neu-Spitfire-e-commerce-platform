/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 50648
 Source Host           : 39.98.124.34:3306
 Source Schema         : dbs

 Target Server Type    : MySQL
 Target Server Version : 50648
 File Encoding         : 65001

 Date: 16/08/2020 09:53:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for brd_brand
-- ----------------------------
DROP TABLE IF EXISTS `brd_brand`;
CREATE TABLE `brd_brand`  (
  `BRD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MAN_ID` int(11) NULL DEFAULT NULL,
  `NAME_EN` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NAME_CN` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` date NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` date NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`BRD_ID`) USING BTREE,
  INDEX `brd_brand_ibfk_1`(`MAN_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of brd_brand
-- ----------------------------
INSERT INTO `brd_brand` VALUES (1, 2, 'Honor', NULL, '1', '2020-07-07', 'mvo', '2020-07-26', 0, 'http://39.98.124.34:8088/image/cd32822643464493a0fa0036a6893dde.jpg', NULL);
INSERT INTO `brd_brand` VALUES (2, 5, '543', NULL, '5', '2020-07-16', '5', '2020-07-16', 0, 'http://localhost:8088/image/b01466193b7e4d50aec07ce41c401bf2.JPG', NULL);
INSERT INTO `brd_brand` VALUES (4, 6, 'brand4_en', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `brd_brand` VALUES (14, 5, '36', NULL, '5', '2020-07-16', '5', '2020-07-16', 0, '', NULL);
INSERT INTO `brd_brand` VALUES (21, 1, '1', NULL, '1', '2020-07-17', '1', '2020-07-17', 0, '', NULL);
INSERT INTO `brd_brand` VALUES (25, 7, 'ewrwet', NULL, NULL, '2020-07-18', NULL, '2020-07-18', 0, '', NULL);
INSERT INTO `brd_brand` VALUES (26, 7, '24234', NULL, NULL, '2020-07-18', NULL, '2020-07-18', 0, '', NULL);
INSERT INTO `brd_brand` VALUES (27, 7, '565', NULL, NULL, '2020-07-18', NULL, '2020-07-18', 0, '', NULL);
INSERT INTO `brd_brand` VALUES (35, 2, 'Nova', NULL, '2', '2020-07-18', 'mvo', '2020-07-26', 0, 'http://39.98.124.34:8088/image/adf38b77f7b8403a8fa2ede00b2ee1b4.jpg', NULL);
INSERT INTO `brd_brand` VALUES (38, 2, 'Mate', NULL, '2', '2020-07-19', 'mvo', '2020-07-26', 0, 'http://39.98.124.34:8088/image/a54874834e0f48778584fd9b69a1cb9a.jpg', NULL);
INSERT INTO `brd_brand` VALUES (40, 6, 'brand4_en11', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `brd_brand` VALUES (41, 6, 'brand4_en111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for cdm_code_master
-- ----------------------------
DROP TABLE IF EXISTS `cdm_code_master`;
CREATE TABLE `cdm_code_master`  (
  `CDM_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE_TYPE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DESCRIPTION` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TYPE_CD` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CODE_VAL` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SEQ_NO` int(11) NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`CDM_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cdm_code_master
-- ----------------------------
INSERT INTO `cdm_code_master` VALUES (55, 'Gender', 'Gender-male', 'male', '0', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `cdm_code_master` VALUES (56, 'Gender', 'Gender-female', 'female', '1', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `cdm_code_master` VALUES (57, 'Role', 'Role-MVO', 'MVO', '1', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `cdm_code_master` VALUES (58, 'Role', 'Role-BVO', 'BVO', '2', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `cdm_code_master` VALUES (62, 'Store', 'Store-Type', 'ebay', '1', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `cdm_code_master` VALUES (63, 'Store', 'Store-Type', 'amzon', '2', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);

-- ----------------------------
-- Table structure for drp_dropship_price
-- ----------------------------
DROP TABLE IF EXISTS `drp_dropship_price`;
CREATE TABLE `drp_dropship_price`  (
  `DRP_ID` int(11) NOT NULL AUTO_INCREMENT,
  `OFP_ID` int(11) NULL DEFAULT NULL,
  `DSR_ID` int(11) NULL DEFAULT NULL,
  `WAR_ID` int(11) NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`DRP_ID`) USING BTREE,
  INDEX `OFP_ID`(`OFP_ID`) USING BTREE,
  INDEX `DSR_ID`(`DSR_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for dsr_dropshipper
-- ----------------------------
DROP TABLE IF EXISTS `dsr_dropshipper`;
CREATE TABLE `dsr_dropshipper`  (
  `DSR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` date NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` date NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REGISTER_DATE` date NULL DEFAULT NULL,
  PRIMARY KEY (`DSR_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dsr_dropshipper
-- ----------------------------
INSERT INTO `dsr_dropshipper` VALUES (1, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `dsr_dropshipper` VALUES (2, 'user4', NULL, NULL, NULL, NULL, 0, NULL, NULL, '2020-07-12');
INSERT INTO `dsr_dropshipper` VALUES (3, 'user4', NULL, NULL, NULL, NULL, 0, NULL, NULL, '2020-07-12');
INSERT INTO `dsr_dropshipper` VALUES (4, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, '2020-07-14');
INSERT INTO `dsr_dropshipper` VALUES (5, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, '2020-07-14');
INSERT INTO `dsr_dropshipper` VALUES (6, 'aaa', NULL, NULL, NULL, NULL, 0, NULL, NULL, '2020-07-16');
INSERT INTO `dsr_dropshipper` VALUES (7, '111', NULL, NULL, NULL, NULL, 0, NULL, NULL, '2020-07-16');
INSERT INTO `dsr_dropshipper` VALUES (8, '11', NULL, NULL, NULL, NULL, 0, NULL, NULL, '2020-07-16');
INSERT INTO `dsr_dropshipper` VALUES (9, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, '2020-07-16');
INSERT INTO `dsr_dropshipper` VALUES (10, 'bbvo', NULL, NULL, NULL, NULL, 0, NULL, NULL, '2020-07-18');
INSERT INTO `dsr_dropshipper` VALUES (11, '13', NULL, NULL, NULL, NULL, 0, NULL, NULL, '2020-07-18');
INSERT INTO `dsr_dropshipper` VALUES (12, '23232', NULL, NULL, NULL, NULL, 0, NULL, NULL, '2020-07-20');
INSERT INTO `dsr_dropshipper` VALUES (13, '432', NULL, NULL, NULL, NULL, 0, NULL, NULL, '2020-07-20');
INSERT INTO `dsr_dropshipper` VALUES (14, '5467', NULL, NULL, NULL, NULL, 0, NULL, NULL, '2020-07-20');
INSERT INTO `dsr_dropshipper` VALUES (15, 'bvotest', NULL, NULL, NULL, NULL, 0, NULL, NULL, '2020-07-22');
INSERT INTO `dsr_dropshipper` VALUES (16, 'LXH', NULL, NULL, NULL, NULL, 0, NULL, NULL, '2020-07-22');
INSERT INTO `dsr_dropshipper` VALUES (17, 'sss', NULL, NULL, NULL, NULL, 0, NULL, NULL, '2020-07-23');
INSERT INTO `dsr_dropshipper` VALUES (18, 'xiongyue', NULL, NULL, NULL, NULL, 0, NULL, NULL, '2020-07-23');
INSERT INTO `dsr_dropshipper` VALUES (19, 'xy', NULL, NULL, NULL, NULL, 0, NULL, NULL, '2020-07-23');

-- ----------------------------
-- Table structure for eba_ebay_authorization
-- ----------------------------
DROP TABLE IF EXISTS `eba_ebay_authorization`;
CREATE TABLE `eba_ebay_authorization`  (
  `EBA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STR_ID` int(11) NULL DEFAULT NULL,
  `APP_ID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SECRET_KEY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TOKEN` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXP_DATE` datetime(0) NULL DEFAULT NULL,
  `CANCLE_DATE` datetime(0) NULL DEFAULT NULL,
  `ACCOUNT_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`EBA_ID`) USING BTREE,
  INDEX `STR_ID`(`STR_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for goa_government_area
-- ----------------------------
DROP TABLE IF EXISTS `goa_government_area`;
CREATE TABLE `goa_government_area`  (
  `GOA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ZIP_CODE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STATE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STATE_SHORTHAND` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CITY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`GOA_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for img_image
-- ----------------------------
DROP TABLE IF EXISTS `img_image`;
CREATE TABLE `img_image`  (
  `IMG_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `WIDTH` int(11) NULL DEFAULT NULL,
  `HEIGHT` int(11) NULL DEFAULT NULL,
  `URI` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TYPE_CD` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ENTITY_ID` int(11) NULL DEFAULT NULL,
  `ENTITY_CD` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SEQ_NO` int(11) NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`IMG_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for man_manufacturer
-- ----------------------------
DROP TABLE IF EXISTS `man_manufacturer`;
CREATE TABLE `man_manufacturer`  (
  `MAN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME_EN` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NAME_CN` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GMC_REPORT_TYPE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GMC_REPORT_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DESCRIPTION` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` date NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` date NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MAN_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of man_manufacturer
-- ----------------------------
INSERT INTO `man_manufacturer` VALUES (1, '1', '1', '1', '1', '1', 'abc', '2020-07-03', 'abc', '2020-07-03', 0, NULL, NULL);
INSERT INTO `man_manufacturer` VALUES (2, 'Huawei', NULL, '1', '/huawei666', 'Leading provider of ICT solutions', NULL, '2020-07-14', NULL, '2020-07-22', 0, NULL, NULL);
INSERT INTO `man_manufacturer` VALUES (4, '123', NULL, '1', 'qqq', '123', NULL, '2020-07-14', NULL, '2020-07-14', 0, NULL, NULL);
INSERT INTO `man_manufacturer` VALUES (5, '5', NULL, '5', '5', '5', '5', '2020-07-16', '5', '2020-07-16', 0, NULL, NULL);
INSERT INTO `man_manufacturer` VALUES (6, 'qe', NULL, '2', '12', '1', '12', '2020-07-17', '12', '2020-07-17', 0, NULL, NULL);
INSERT INTO `man_manufacturer` VALUES (7, 'd', NULL, 'df', 'ere', 'fggf', NULL, '2020-07-18', NULL, '2020-07-18', 0, NULL, NULL);
INSERT INTO `man_manufacturer` VALUES (8, 'ewr', NULL, '7', 'bvcb', 'cxvb', NULL, '2020-07-18', NULL, '2020-07-18', 0, NULL, NULL);
INSERT INTO `man_manufacturer` VALUES (9, '123', NULL, '1', '123', '123', '789', '2020-07-23', '789', '2020-07-23', 0, NULL, NULL);
INSERT INTO `man_manufacturer` VALUES (10, '123', NULL, '1', '1', '123', '789', '2020-07-24', '789', '2020-07-24', 0, NULL, NULL);

-- ----------------------------
-- Table structure for mor_monitor_result
-- ----------------------------
DROP TABLE IF EXISTS `mor_monitor_result`;
CREATE TABLE `mor_monitor_result`  (
  `MOR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CLASS_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JSON_STRING` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATE_DATE` datetime(0) NULL DEFAULT NULL,
  `CREATE_BY` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `UPDATE_DATE` datetime(0) NULL DEFAULT NULL,
  `UPDATE_BY` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REMARK` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MOR_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for o_order
-- ----------------------------
DROP TABLE IF EXISTS `o_order`;
CREATE TABLE `o_order`  (
  `or_id` int(11) NOT NULL AUTO_INCREMENT,
  `DSR_ID` int(11) NULL DEFAULT NULL,
  `STR_ID` int(11) NULL DEFAULT NULL,
  `man_id` int(11) NULL DEFAULT NULL,
  `pro_id` int(11) NULL DEFAULT NULL,
  `ORDER_ID` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SALES_PRICE` decimal(8, 2) NULL DEFAULT NULL,
  `QTY` int(11) NULL DEFAULT NULL,
  `SKU_NO` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receive_name` varchar(46) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receive_address` varchar(47) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receive_phone` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tracking_company` varchar(49) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tracking_number` varchar(49) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sts_cd` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ORDER_CREATED_TIME` timestamp(0) NULL DEFAULT NULL,
  `PAID_TIME` timestamp(0) NULL DEFAULT NULL,
  `ship_time` timestamp(0) NULL DEFAULT NULL,
  `completed_time` timestamp(0) NULL DEFAULT NULL,
  `cancelled_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`or_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of o_order
-- ----------------------------
INSERT INTO `o_order` VALUES (1, 1, 1, 2, 76, 'AMAZON-10000', 2133.00, 2, '3', NULL, NULL, NULL, 'SF Express', '1233430630', '0', '2020-07-10 00:00:00', '2020-07-23 23:00:16', '2020-07-23 23:00:57', NULL, '2020-07-23 23:01:07');
INSERT INTO `o_order` VALUES (2, 1, 2, 2, 76, 'AMAZON-10012', 3333.00, 2, '1', '2', '2', NULL, '', '5850802397', '2', '2020-07-10 00:00:00', '2020-07-24 08:52:25', '2020-07-23 13:20:32', NULL, '2020-07-23 13:22:17');
INSERT INTO `o_order` VALUES (3, 1, 23, 2, 76, 'AMAZON-10022', 3333.00, 2, '3', NULL, NULL, NULL, 'SF Express', '5636871768', '0', '2020-07-10 00:00:00', '2020-07-15 11:02:03', '2020-07-20 10:44:18', NULL, '2020-07-23 20:28:57');
INSERT INTO `o_order` VALUES (4, 1, 2, 2, 76, 'AMAZON-10004', 2133.00, 1, '1', NULL, NULL, NULL, 'SF Express', '1666867842', '2', '2020-07-10 00:00:00', '2020-07-18 14:39:40', '2020-07-17 20:15:25', NULL, '2020-07-23 20:23:26');
INSERT INTO `o_order` VALUES (5, 1, 2, 2, 76, 'EBAY-10000', 2133.00, 1, '1', NULL, NULL, NULL, 'UPS', '5116280804', '0', '2020-07-10 00:00:00', '2020-07-18 14:21:09', '2020-07-18 17:46:53', NULL, '2020-07-18 17:48:21');
INSERT INTO `o_order` VALUES (6, 1, 2, 2, 77, 'EBAY-10040', 3333.00, 1, '1', NULL, NULL, NULL, 'SF Express', '2215607211', '2', '2020-07-10 00:00:00', '2020-07-23 20:20:31', '2020-07-17 19:27:08', NULL, '2020-07-23 20:23:31');
INSERT INTO `o_order` VALUES (7, 1, 2, 2, 77, 'EBAY-10300', 3333.00, 1, '1', NULL, NULL, NULL, 'SF Express', '6161916666', '4', '2020-07-10 00:00:00', '2020-07-23 17:20:24', '2020-07-23 20:20:36', NULL, '2020-07-23 20:23:37');
INSERT INTO `o_order` VALUES (8, 1, 2, 2, 77, 'EBAY-12300', 3333.00, 1, '1', NULL, NULL, NULL, 'SF Express', '9161218748', '3', '2020-07-10 00:00:00', '2020-07-23 20:23:01', '2020-07-23 20:28:46', NULL, '2020-07-23 20:23:39');
INSERT INTO `o_order` VALUES (14, 1, 2, 2, 77, 'EBAY-14000', 3333.00, 1, '1', '', '', '', NULL, NULL, '2', '2020-07-23 20:20:11', '2020-07-23 20:26:57', '2020-07-23 20:23:15', NULL, '2020-07-23 20:23:44');
INSERT INTO `o_order` VALUES (15, 1, 2, 2, 77, 'EBAY-10345', 3333.00, 1, '1', '', '', '', NULL, NULL, '1', '2020-07-23 08:20:15', '2020-07-23 20:23:08', '2020-07-23 20:23:18', NULL, '2020-07-23 20:23:47');
INSERT INTO `o_order` VALUES (17, 1, 2, 2, 76, 'AMAZON', 123.00, 1, '123', '唐麒森', '辽宁省沈阳市浑南区东北大学', '18604013195', NULL, NULL, '1', '2020-07-24 08:00:11', NULL, NULL, NULL, NULL);
INSERT INTO `o_order` VALUES (18, 1, 2, 2, 76, 'AMAZON', 123.00, 1, '123', '唐麒森', '辽宁省沈阳市浑南区东北大学', '18604013195', NULL, NULL, '1', '2020-07-24 09:03:02', NULL, NULL, NULL, NULL);
INSERT INTO `o_order` VALUES (19, 1, 2, 2, 76, 'AMAZON', 123.00, 1, '123', '唐麒森', '辽宁省沈阳市浑南区东北大学', '18604013195', NULL, NULL, '1', '2020-07-24 09:03:02', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for ofp_offer_price
-- ----------------------------
DROP TABLE IF EXISTS `ofp_offer_price`;
CREATE TABLE `ofp_offer_price`  (
  `OFP_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MAN_ID` int(11) NULL DEFAULT NULL,
  `EFFETIVE_START_DATE` timestamp(0) NULL DEFAULT NULL,
  `EFFECTIVE_END_DATE` timestamp(0) NULL DEFAULT NULL,
  `PRO_ID` int(11) NULL DEFAULT NULL,
  `PRICE` decimal(8, 2) NULL DEFAULT NULL,
  `TYPE_CD` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DSR_ID` int(11) NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PERIOD` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`OFP_ID`) USING BTREE,
  INDEX `MAN_ID`(`MAN_ID`) USING BTREE,
  INDEX `PRO_ID`(`PRO_ID`) USING BTREE,
  INDEX `DSR_ID`(`DSR_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for par_parameter
-- ----------------------------
DROP TABLE IF EXISTS `par_parameter`;
CREATE TABLE `par_parameter`  (
  `PAR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PARAM_CD` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PARAM_VALUE` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DESCRIPTION` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`PAR_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 90 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of par_parameter
-- ----------------------------
INSERT INTO `par_parameter` VALUES (87, 'STOCK_TIME', 'Stock-time', '7', 'admin', '2020-07-23 00:00:00', 'admin', '2020-07-23 00:00:00', 0, NULL, NULL);
INSERT INTO `par_parameter` VALUES (88, 'POUNDAGE', 'Withdraw fee', '0', 'admin', '2020-07-23 00:00:00', 'admin', '2020-07-23 00:00:00', 0, NULL, NULL);
INSERT INTO `par_parameter` VALUES (89, 'TIME', 'WORK DAY', '5', 'admin', '2020-07-24 00:00:00', 'admin', '2020-07-24 00:00:00', 0, NULL, NULL);

-- ----------------------------
-- Table structure for pck_package_info
-- ----------------------------
DROP TABLE IF EXISTS `pck_package_info`;
CREATE TABLE `pck_package_info`  (
  `PCK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `WAR_ID` int(11) NULL DEFAULT NULL,
  `PRO_ID` int(11) NULL DEFAULT NULL,
  `TYPE_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `WIDTH` decimal(7, 2) NULL DEFAULT NULL,
  `HEIGHT` decimal(7, 2) NULL DEFAULT NULL,
  `LENGTH` decimal(7, 2) NULL DEFAULT NULL,
  `WEIGHT` decimal(5, 2) NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EBAY_DESCRIPTION` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `AMAZON_DESCRIPTION` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`PCK_ID`) USING BTREE,
  INDEX `PRO_ID`(`PRO_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pck_package_info
-- ----------------------------
INSERT INTO `pck_package_info` VALUES (1, 1, 1, '1', 1.00, 1.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, 'Computer', NULL, 'pro1-ebay', 'pro1-amazon');
INSERT INTO `pck_package_info` VALUES (2, 1, 2, '1', 1.00, 2.00, 2.00, 3.00, '', NULL, NULL, NULL, NULL, 'Phone', NULL, '*pro2-ebay*', '**pro2-amazon**');
INSERT INTO `pck_package_info` VALUES (3, 1, 3, '1', 1.00, 1.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, 'Pad', NULL, 'pro3-ebay', 'pro3-amazon');
INSERT INTO `pck_package_info` VALUES (4, NULL, 4, NULL, 10.00, 10.00, 100.00, 100.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'eba.', 'am');
INSERT INTO `pck_package_info` VALUES (5, NULL, 5, NULL, 12.00, 2.00, 1.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '阿斯蒂芬', 'asdf');
INSERT INTO `pck_package_info` VALUES (6, NULL, 6, NULL, 234.00, 223.00, 423.00, 23.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '23', '3');
INSERT INTO `pck_package_info` VALUES (7, NULL, 7, NULL, 3.00, 3.00, 23.00, 3.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '**粗54534533体**', '*斜\n587\n667\n体\n*');
INSERT INTO `pck_package_info` VALUES (8, NULL, 8, NULL, 23.00, 23.00, 234.00, 23.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '23', '23');
INSERT INTO `pck_package_info` VALUES (9, NULL, 9, NULL, 5.00, 5.00, 5.00, 5.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '12345', '56789');
INSERT INTO `pck_package_info` VALUES (10, NULL, 10, NULL, 6.00, 6.00, 6.00, 6.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '**5435651 \n \n 235156\n465\n156156\n431355\n\n\n 345***', '2453');
INSERT INTO `pck_package_info` VALUES (11, NULL, 11, NULL, 5.00, 5.00, 5.00, 5.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '12\n345', '5**粗6766体**');
INSERT INTO `pck_package_info` VALUES (12, NULL, 12, NULL, 5.00, 5.00, 5.00, 5.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '543', '564');
INSERT INTO `pck_package_info` VALUES (13, NULL, 13, NULL, 12.00, 12.00, 12.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '1');
INSERT INTO `pck_package_info` VALUES (14, NULL, 14, NULL, 2.00, 2.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', '2');
INSERT INTO `pck_package_info` VALUES (15, NULL, 15, NULL, 3.00, 3.00, 23.00, 3.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '3', '3');
INSERT INTO `pck_package_info` VALUES (16, NULL, 16, NULL, 2.00, 2.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', '2');
INSERT INTO `pck_package_info` VALUES (17, NULL, 17, NULL, 1.00, 1.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '1');
INSERT INTO `pck_package_info` VALUES (18, NULL, 18, NULL, 1.00, 1.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '1');
INSERT INTO `pck_package_info` VALUES (19, NULL, 19, NULL, 2.00, 2.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', '2');
INSERT INTO `pck_package_info` VALUES (20, NULL, 20, NULL, 2.00, 2.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '312', '12');
INSERT INTO `pck_package_info` VALUES (21, NULL, 21, NULL, 2.00, 2.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '12', '21');
INSERT INTO `pck_package_info` VALUES (22, NULL, 22, NULL, 1.00, 1.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '222', '2');
INSERT INTO `pck_package_info` VALUES (23, NULL, 23, NULL, 3.00, 3.00, 3.00, 3.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '3', '3');
INSERT INTO `pck_package_info` VALUES (24, NULL, 24, NULL, 3.00, 3.00, 3.00, 3.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '3', '3');
INSERT INTO `pck_package_info` VALUES (25, NULL, 25, NULL, 2.00, 2.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', '2');
INSERT INTO `pck_package_info` VALUES (26, NULL, 26, NULL, 2.00, 2.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '23', '23');
INSERT INTO `pck_package_info` VALUES (27, NULL, 27, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '23', '23');
INSERT INTO `pck_package_info` VALUES (28, NULL, 28, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '23', '23');
INSERT INTO `pck_package_info` VALUES (29, NULL, 29, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '23', '423');
INSERT INTO `pck_package_info` VALUES (30, NULL, 30, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '3', '3');
INSERT INTO `pck_package_info` VALUES (31, NULL, 31, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '32', '3');
INSERT INTO `pck_package_info` VALUES (32, NULL, 32, NULL, 3.00, 3.00, 3.00, 3.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '23', '32');
INSERT INTO `pck_package_info` VALUES (33, NULL, 33, NULL, 3.00, 3.00, 23.00, 3.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '32', '23');
INSERT INTO `pck_package_info` VALUES (34, NULL, 34, NULL, 2.00, 2.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', '2');
INSERT INTO `pck_package_info` VALUES (35, NULL, 35, NULL, 3.00, 3.00, 3.00, 3.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '3', '3');
INSERT INTO `pck_package_info` VALUES (36, NULL, 36, NULL, 3.00, 3.00, 2.00, 3.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '23', '32');
INSERT INTO `pck_package_info` VALUES (37, NULL, 37, NULL, 2.00, 2.00, 12.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '12', '2');
INSERT INTO `pck_package_info` VALUES (38, NULL, 38, NULL, 3.00, 3.00, 3.00, 3.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '32', '23');
INSERT INTO `pck_package_info` VALUES (39, NULL, 39, NULL, 4.00, 4.00, 4.00, 4.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '32', '23');
INSERT INTO `pck_package_info` VALUES (40, NULL, 40, NULL, 3.00, 3.00, 3.00, 3.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '32', '23');
INSERT INTO `pck_package_info` VALUES (41, NULL, 41, NULL, 2.00, 2.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '12', '21');
INSERT INTO `pck_package_info` VALUES (42, NULL, 42, NULL, 123.00, 312.00, 123.00, 31.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '312', '12');
INSERT INTO `pck_package_info` VALUES (43, NULL, 43, NULL, 12.00, 312.00, 12.00, 12.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '12', '312');
INSERT INTO `pck_package_info` VALUES (44, NULL, 44, NULL, 123.00, 312.00, 123.00, 31.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '312', '12');
INSERT INTO `pck_package_info` VALUES (45, NULL, 45, NULL, 3.00, 3.00, 3.00, 3.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '23', '32');
INSERT INTO `pck_package_info` VALUES (46, NULL, 46, NULL, 123.00, 312.00, 123.00, 31.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '312', '12');
INSERT INTO `pck_package_info` VALUES (47, NULL, 47, NULL, 12.00, 312.00, 12.00, 12.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '12', '312');
INSERT INTO `pck_package_info` VALUES (48, NULL, 48, NULL, 22.00, 2.00, 21.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '12', '12');
INSERT INTO `pck_package_info` VALUES (49, NULL, 49, NULL, 3.00, 3.00, 3.00, 3.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '32', '23');
INSERT INTO `pck_package_info` VALUES (50, NULL, 50, NULL, 2.00, 2.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '23', '23');
INSERT INTO `pck_package_info` VALUES (51, NULL, 51, NULL, 4.00, 4.00, 23.00, 4.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '423', '42');
INSERT INTO `pck_package_info` VALUES (52, NULL, 52, NULL, 2.00, 2.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '423', '423');
INSERT INTO `pck_package_info` VALUES (53, NULL, 53, NULL, 1.00, 3.00, 3.00, 3.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '12', '12');
INSERT INTO `pck_package_info` VALUES (54, NULL, 54, NULL, 3.00, 4.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '23', '23');
INSERT INTO `pck_package_info` VALUES (55, NULL, 55, NULL, 1.00, 3.00, 3.00, 3.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '12', '12');
INSERT INTO `pck_package_info` VALUES (56, NULL, 56, NULL, 2.00, 4.00, 43.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '423', '423');
INSERT INTO `pck_package_info` VALUES (57, NULL, 57, NULL, 3.00, 4.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '23', '23');
INSERT INTO `pck_package_info` VALUES (58, NULL, 58, NULL, 2.00, 2.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '423', '423');
INSERT INTO `pck_package_info` VALUES (59, NULL, 59, NULL, 1.00, 11.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '31', '12');
INSERT INTO `pck_package_info` VALUES (60, NULL, 60, NULL, 1.00, 11.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '31', '12');
INSERT INTO `pck_package_info` VALUES (61, NULL, 61, NULL, 31.00, 3.00, 3.00, 3.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '12');
INSERT INTO `pck_package_info` VALUES (62, NULL, 62, NULL, 1.00, 2.00, 3.00, 21.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '31', '23');
INSERT INTO `pck_package_info` VALUES (63, NULL, 63, NULL, 423.00, 423.00, 42.00, 42.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '432', '423');
INSERT INTO `pck_package_info` VALUES (64, NULL, 64, NULL, 2.00, 2.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '121.', '312');
INSERT INTO `pck_package_info` VALUES (65, NULL, 65, NULL, 2.00, 2.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '312', '12');
INSERT INTO `pck_package_info` VALUES (66, NULL, 66, NULL, 2.00, 2.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '234', '423');
INSERT INTO `pck_package_info` VALUES (67, NULL, 67, NULL, 2.00, 2.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '312', '312312');
INSERT INTO `pck_package_info` VALUES (68, NULL, 68, NULL, 2.00, 2.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '312', '312');
INSERT INTO `pck_package_info` VALUES (69, NULL, 69, NULL, 2.00, 2.00, 2.00, 2.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '12', '233');
INSERT INTO `pck_package_info` VALUES (70, NULL, 70, NULL, 123.00, 12.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '***313***', '3121');
INSERT INTO `pck_package_info` VALUES (71, NULL, 71, NULL, 4.00, 4.00, 23.00, 4.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '423', '423');
INSERT INTO `pck_package_info` VALUES (72, NULL, 72, NULL, 423.00, 423.00, 234.00, 423.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '234', '23');
INSERT INTO `pck_package_info` VALUES (73, NULL, 73, NULL, 121.00, 45.00, 100.00, 787.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '**sdfshttp://localhost:8080/#/company**', 'fgfd\n\ncxvx\ngter');
INSERT INTO `pck_package_info` VALUES (74, NULL, 74, NULL, 121.00, 45.00, 100.00, 787.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '**sdfshttp://localhost:8080/#/company**', 'fgfd\n\ncxvx\ngter');
INSERT INTO `pck_package_info` VALUES (75, NULL, 75, NULL, 121.00, 45.00, 100.00, 787.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '**sdfshttp://localhost:8080/#/company**', 'fgfd\n\ncxvx\ngter');
INSERT INTO `pck_package_info` VALUES (76, NULL, 76, NULL, 1.00, 1.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '**huawei phone**', '**huawei phone**');
INSERT INTO `pck_package_info` VALUES (77, NULL, 77, NULL, 1.00, 1.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '**nova 5**\n\n*huawei*', '**nave**');
INSERT INTO `pck_package_info` VALUES (78, NULL, 78, NULL, 1.00, 1.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '123', '312');
INSERT INTO `pck_package_info` VALUES (79, NULL, 79, NULL, 1.00, 1.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '123', '312');
INSERT INTO `pck_package_info` VALUES (80, NULL, 80, NULL, 1.00, 1.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '123', '312');
INSERT INTO `pck_package_info` VALUES (81, NULL, 81, NULL, 12.00, 12.00, 12.00, 12.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '*mate 10*', '**mate 10**');
INSERT INTO `pck_package_info` VALUES (82, NULL, 82, NULL, 12.00, 12.00, 12.00, 12.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '*mate 9*', '**mate 9**');
INSERT INTO `pck_package_info` VALUES (83, NULL, 83, NULL, 12.00, 12.00, 12.00, 12.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '*matebook 11*', '**mate 11**');
INSERT INTO `pck_package_info` VALUES (84, NULL, 84, NULL, 11.00, 11.00, 11.00, 11.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '**hohrh**', '**fhfh**');
INSERT INTO `pck_package_info` VALUES (85, NULL, 85, NULL, 1.00, 1.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '**huawei phone**', '**huawei phone**');
INSERT INTO `pck_package_info` VALUES (86, NULL, 86, NULL, 11.00, 11.00, 11.00, 11.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '**hhh**', '*hhh*');
INSERT INTO `pck_package_info` VALUES (87, NULL, 87, NULL, 12.00, 12.00, 12.00, 11.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '**hshh**', '*ggdag*');

-- ----------------------------
-- Table structure for pdn_product_descrition
-- ----------------------------
DROP TABLE IF EXISTS `pdn_product_descrition`;
CREATE TABLE `pdn_product_descrition`  (
  `PDN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRO_ID` int(11) NULL DEFAULT NULL,
  `TYPE_CD` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DESCRITION` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`PDN_ID`) USING BTREE,
  INDEX `PRO_ID`(`PRO_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for prc_product_category
-- ----------------------------
DROP TABLE IF EXISTS `prc_product_category`;
CREATE TABLE `prc_product_category`  (
  `PRC_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRO_ID` int(11) NULL DEFAULT NULL,
  `CATEGORY_ID` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CATEGORY_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CATEGORY_PATH` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PLATEFORM_TYPE` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`PRC_ID`) USING BTREE,
  INDEX `PRO_ID`(`PRO_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for pro_product
-- ----------------------------
DROP TABLE IF EXISTS `pro_product`;
CREATE TABLE `pro_product`  (
  `PRO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SKU_CD` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BRD_ID` int(11) NULL DEFAULT NULL,
  `MAN_ID` int(11) NULL DEFAULT NULL,
  `TITLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `UPC` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EAN` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MODEL` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `WARRANTY_DAY` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `RETAIL_PRICE` decimal(10, 2) NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MININUM_RETAIL_PRICE` decimal(10, 2) NULL DEFAULT NULL,
  `REPLENISHMENT_PERIOD` int(11) NULL DEFAULT NULL,
  `KEY_WORDS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `WARRANTY` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `TIME_UNIT` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STOCKSETING` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`PRO_ID`) USING BTREE,
  INDEX `BRD_ID`(`BRD_ID`) USING BTREE,
  INDEX `MAN_ID`(`MAN_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 84 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pro_product
-- ----------------------------
INSERT INTO `pro_product` VALUES (76, '123', 1, 4, 'honor 20', '123', '123', '123', '12', 123.00, 'mvo', '2020-07-20 00:00:00', 'admin', '2020-07-26 00:00:00', 0, 'http://39.98.124.34:8088/image/95bd131329744ce696cfa78ec5b070b3.jpg', 'On shelf', NULL, 3, 'Phone', NULL, NULL, 0);
INSERT INTO `pro_product` VALUES (77, '123', 35, 4, 'nova Pro5', '123', '123', '123', '12', 123.00, 'mvo', '2020-07-22 00:00:00', 'admin', '2020-07-26 00:00:00', 0, 'http://39.98.124.34:8088/image/b5751982aad34a6199f08670d636010e.jpg', 'On shelf', NULL, 3, 'Phone', NULL, NULL, 0);
INSERT INTO `pro_product` VALUES (81, '111', 38, 4, 'mate 10', '111', '111', '111', '12', 1000.00, 'mvo', '2020-07-23 00:00:00', 'admin', '2020-07-26 00:00:00', 0, 'http://39.98.124.34:8088/image/a6a2e65529e04d768905814e85d4c3ff.jpg', 'On shelf', NULL, 10, 'Phone', NULL, NULL, 0);
INSERT INTO `pro_product` VALUES (83, '111', 38, 4, 'matebook', '111', '111', '111', '12', 1000.00, 'mvo', '2020-07-23 00:00:00', 'admin', '2020-07-26 00:00:00', 0, 'http://39.98.124.34:8088/image/91762f98d1414656bb525ddff931e32f.jpg', 'On shelf', NULL, 10, 'Computer', NULL, NULL, 0);

-- ----------------------------
-- Table structure for sal_sales_order_line_item
-- ----------------------------
DROP TABLE IF EXISTS `sal_sales_order_line_item`;
CREATE TABLE `sal_sales_order_line_item`  (
  `SAL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SAO_ID` int(11) NULL DEFAULT NULL,
  `PRO_ID` int(11) NULL DEFAULT NULL,
  `QTY` int(11) NULL DEFAULT NULL,
  `PRICE` decimal(8, 2) NULL DEFAULT NULL,
  `SOL_ID` int(11) NULL DEFAULT NULL,
  `TRACKING_NO` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `WSP_NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SAL_ID`) USING BTREE,
  INDEX `SAO_ID`(`SAO_ID`) USING BTREE,
  INDEX `SOL_ID`(`SOL_ID`) USING BTREE,
  INDEX `PRO_ID`(`PRO_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sao_sales_order
-- ----------------------------
DROP TABLE IF EXISTS `sao_sales_order`;
CREATE TABLE `sao_sales_order`  (
  `SAO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MAN_ID` int(11) NULL DEFAULT NULL,
  `WAR_ID` int(11) NULL DEFAULT NULL,
  `SYNC_DATE` timestamp(0) NULL DEFAULT NULL,
  `PAYMENT_DATE` timestamp(0) NULL DEFAULT NULL,
  `PUSH_DATE` timestamp(0) NULL DEFAULT NULL,
  `TRACK_NO_DATE` timestamp(0) NULL DEFAULT NULL,
  `FULFILLMENT_DATE` timestamp(0) NULL DEFAULT NULL,
  `SETTLEMENT_DATE` timestamp(0) NULL DEFAULT NULL,
  `PRODUCT_AMOUNT` decimal(8, 2) NULL DEFAULT NULL,
  `FREIGHT_COST` decimal(8, 2) NULL DEFAULT NULL,
  `HANDLING_FEE` decimal(8, 2) NULL DEFAULT NULL,
  `CUSTOMER_REMARK` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ORDER_NO` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ORDER_STS` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REFUND_STS` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DELIVERY_STS` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STO_ID` int(11) NULL DEFAULT NULL,
  `LAST_FREIGHT_COST` decimal(8, 2) NULL DEFAULT NULL,
  `CANCLE_TIME` timestamp(0) NULL DEFAULT NULL,
  `AUTO_PAY_STATUS` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BUYER_CHECKOUT_MESSAGE` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `AUTO_PAY_TIME` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SAO_ID`) USING BTREE,
  INDEX `MAN_ID`(`MAN_ID`) USING BTREE,
  INDEX `STO_ID`(`STO_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sdi_store_dropship_item
-- ----------------------------
DROP TABLE IF EXISTS `sdi_store_dropship_item`;
CREATE TABLE `sdi_store_dropship_item`  (
  `DIL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRO_ID` int(11) NULL DEFAULT NULL,
  `STR_ID` int(11) NULL DEFAULT NULL,
  `STORE_RETENTION` int(11) NULL DEFAULT NULL,
  `DROPSHIP_PRICE` decimal(10, 2) NULL DEFAULT NULL,
  `DROPSHIP_STATUS` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SHELF_STOCK` int(11) NULL DEFAULT NULL,
  `PREFER_DATE` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`DIL_ID`) USING BTREE,
  INDEX `PRO_ID`(`PRO_ID`) USING BTREE,
  INDEX `STR_ID`(`STR_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sequence
-- ----------------------------
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence`  (
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `current_value` int(11) NULL DEFAULT NULL,
  `increment` int(11) NULL DEFAULT NULL,
  `initial` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sha_shipping_address
-- ----------------------------
DROP TABLE IF EXISTS `sha_shipping_address`;
CREATE TABLE `sha_shipping_address`  (
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FAMILY_NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GIVEN_NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `COUNTRY_NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `COUNTRY_ISO_CD` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STATE_OR_PROVINCE_NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STATE_OR_PROVINCE_CD` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CITY_NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ADDRESS_LINE1` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ADDRESS_LINE2` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ADDRESS_LINE3` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `POSTAL_CD` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CONTACT_PHONE_NO` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EMAIL` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STO_ID` int(11) NULL DEFAULT NULL,
  `CARRIER_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `STO_ID`(`STO_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sol_store_order_line_item
-- ----------------------------
DROP TABLE IF EXISTS `sol_store_order_line_item`;
CREATE TABLE `sol_store_order_line_item`  (
  `SOL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ORDER_ITEM_ID` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STO_ID` int(11) NULL DEFAULT NULL,
  `SALES_PRICE` decimal(8, 2) NULL DEFAULT NULL,
  `QTY` int(11) NULL DEFAULT NULL,
  `SKU_NO` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BUYER_CHECKOUT_MESSAGE` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`SOL_ID`) USING BTREE,
  INDEX `STO_ID`(`STO_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for spa_specific_attribute
-- ----------------------------
DROP TABLE IF EXISTS `spa_specific_attribute`;
CREATE TABLE `spa_specific_attribute`  (
  `SPA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRO_ID` int(11) NULL DEFAULT NULL,
  `NAME_EN` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NAME_CN` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SEQ_NO` int(11) NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SPA_ID`) USING BTREE,
  INDEX `PRO_ID`(`PRO_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for spv_specific_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `spv_specific_attribute_value`;
CREATE TABLE `spv_specific_attribute_value`  (
  `SPV_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SPA_ID` int(11) NULL DEFAULT NULL,
  `NAME_EN` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NAME_CN` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SPV_ID`) USING BTREE,
  INDEX `SPA_ID`(`SPA_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sto_store_order
-- ----------------------------
DROP TABLE IF EXISTS `sto_store_order`;
CREATE TABLE `sto_store_order`  (
  `STO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STR_ID` int(11) NULL DEFAULT NULL,
  `ORDER_ID` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ORDER_CREATED_TIME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PAID_TIME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_MODIFIED_TIME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PLATEFORM_TYPE` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CANCEL_COMPLETE_DATE` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`STO_ID`) USING BTREE,
  INDEX `STR_ID`(`STR_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for str_store
-- ----------------------------
DROP TABLE IF EXISTS `str_store`;
CREATE TABLE `str_store`  (
  `STR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DSR_ID` int(11) NULL DEFAULT NULL,
  `PLATAEFORM_TYPE` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STORE_NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STORE_STS_CD` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`STR_ID`) USING BTREE,
  INDEX `DSR_ID`(`DSR_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of str_store
-- ----------------------------
INSERT INTO `str_store` VALUES (1, 4, '1', 'MrStore', '1', 'jack', NULL, 'jack', NULL, 1, '1', '1');
INSERT INTO `str_store` VALUES (2, 4, '2', 'MsStore', '2', 'rose', NULL, 'rose', NULL, 1, '1', '1');
INSERT INTO `str_store` VALUES (3, 4, '1', 'NewStore', '1', NULL, '2020-07-14 00:00:00', NULL, '2020-07-14 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (4, 4, '1', '11', '1', '3', '2020-07-16 00:00:00', '3', '2020-07-16 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (5, 4, '2', '12', '1', '3', '2020-07-16 00:00:00', '3', '2020-07-16 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (8, 4, '1', '1', '1', '2', '2020-07-16 00:00:00', '2', '2020-07-16 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (9, 4, '1', '2', '1', '2', '2020-07-17 00:00:00', '2', '2020-07-17 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (10, 4, '2', '1', '1', '2', '2020-07-17 00:00:00', '2', '2020-07-17 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (13, 6, '1', '1', '1', '12', '2020-07-17 00:00:00', '12', '2020-07-17 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (14, 6, '2', '1', '1', '12', '2020-07-17 00:00:00', '12', '2020-07-17 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (15, 6, '1', '13', '1', '12', '2020-07-17 00:00:00', '12', '2020-07-17 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (16, 6, '2', '3', '1', '12', '2020-07-17 00:00:00', '12', '2020-07-17 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (17, 8, '1', 'were', '1', NULL, '2020-07-18 00:00:00', NULL, '2020-07-18 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (18, 8, '2', '32423', '2', NULL, '2020-07-18 00:00:00', NULL, '2020-07-18 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (19, 8, '2', 'sdf', '0', NULL, '2020-07-18 00:00:00', NULL, '2020-07-18 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (20, 7, '1', 'wrt', '1', 'user5', '2020-07-18 00:00:00', 'user5', '2020-07-18 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (21, 4, '1', '1', '1', 'admin', '2020-07-18 00:00:00', 'admin', '2020-07-18 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (22, 4, '1', '1', '1', 'admin', '2020-07-18 00:00:00', 'admin', '2020-07-18 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (24, 16, '1', 'HuaWei', '1', 'LXH', '2020-07-22 00:00:00', 'LXH', '2020-07-22 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (26, 16, '2', 'Apple', '1', 'lxh', '2020-07-23 00:00:00', 'lxh', '2020-07-23 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (27, 16, '2', 'XiaoMi', '1', 'lxh', '2020-07-23 00:00:00', 'lxh', '2020-07-23 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (28, 16, '1', 'Dell', '1', 'lxh', '2020-07-23 00:00:00', 'lxh', '2020-07-23 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (29, 16, '1', 'HP', '1', 'lxh', '2020-07-23 00:00:00', 'lxh', '2020-07-23 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (30, 1, '1', 'HuaWei', '1', 'bvo', '2020-07-23 00:00:00', 'bvo', '2020-07-23 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (31, 1, '2', 'Apple', '1', 'bvo', '2020-07-23 00:00:00', 'bvo', '2020-07-23 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (32, 16, '1', 'HuaWei2', '1', 'LXH', '2020-07-24 00:00:00', 'LXH', '2020-07-24 00:00:00', 0, NULL, NULL);
INSERT INTO `str_store` VALUES (33, 16, '2', 'huawei23', '1', 'lxh', '2020-07-24 00:00:00', 'lxh', '2020-07-24 00:00:00', 0, NULL, NULL);

-- ----------------------------
-- Table structure for sys_andorra
-- ----------------------------
DROP TABLE IF EXISTS `sys_andorra`;
CREATE TABLE `sys_andorra`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adurl` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publisher` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addtime` datetime(0) NULL DEFAULT NULL,
  `uptime` datetime(0) NULL DEFAULT NULL,
  `starttime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `endtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tourl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `MENU_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MENU_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MENU_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PARENT_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MENU_ORDER` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MENU_ICON` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MENU_TYPE` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MENU_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 'Menu manage', '/menu', '0', '1', 'el-icon-notebook-2', '0');
INSERT INTO `sys_menu` VALUES (2, 'User manage', '/user', '0', '2', 'el-icon-user', '0');
INSERT INTO `sys_menu` VALUES (3, 'Parameter manage', '/param', '0', '3', 'el-icon-notebook-1', '0');
INSERT INTO `sys_menu` VALUES (4, 'Data dictionary', '/data', '0', '4', 'el-icon-collection', '0');
INSERT INTO `sys_menu` VALUES (5, 'Fund check', '/check', '0', '5', 'el-icon-document-checked', '0');
INSERT INTO `sys_menu` VALUES (6, 'Company info', '/company', '1', '6', 'el-icon-school', '1');
INSERT INTO `sys_menu` VALUES (7, 'Goods manage', '/goods', '1', '7', 'el-icon-goods', '1');
INSERT INTO `sys_menu` VALUES (8, 'Order manage', '/MVO/order', '1', '8', 'el-icon-s-order', '1');
INSERT INTO `sys_menu` VALUES (9, 'Wallet', '/MVO/wallet', '1', '9', 'el-icon-wallet', '1');
INSERT INTO `sys_menu` VALUES (10, 'Store manage', '/store', '2', '10', 'el-icon-house', '2');
INSERT INTO `sys_menu` VALUES (11, 'Goods list', '/goodslist', '2', '11', 'el-icon-goods', '2');
INSERT INTO `sys_menu` VALUES (12, 'Wish list', '/wishlist', '2', '12', 'el-icon-star-off', '2');
INSERT INTO `sys_menu` VALUES (13, 'Order manage', '/BVO/order', '2', '13', 'el-icon-s-order', '2');
INSERT INTO `sys_menu` VALUES (14, 'Wallet', '/BVO/wallet', '2', '14', 'el-icon-wallet', '2');

-- ----------------------------
-- Table structure for sys_menu_list
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_list`;
CREATE TABLE `sys_menu_list`  (
  `list_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `menu_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`list_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 127 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu_list
-- ----------------------------
INSERT INTO `sys_menu_list` VALUES (1, 3, 1);
INSERT INTO `sys_menu_list` VALUES (2, 3, 2);
INSERT INTO `sys_menu_list` VALUES (3, 3, 3);
INSERT INTO `sys_menu_list` VALUES (4, 3, 4);
INSERT INTO `sys_menu_list` VALUES (7, 3, 5);
INSERT INTO `sys_menu_list` VALUES (8, 3, 6);
INSERT INTO `sys_menu_list` VALUES (10, 3, 8);
INSERT INTO `sys_menu_list` VALUES (11, 3, 9);
INSERT INTO `sys_menu_list` VALUES (12, 3, 10);
INSERT INTO `sys_menu_list` VALUES (13, 3, 11);
INSERT INTO `sys_menu_list` VALUES (14, 3, 12);
INSERT INTO `sys_menu_list` VALUES (15, 3, 7);
INSERT INTO `sys_menu_list` VALUES (17, 3, 13);
INSERT INTO `sys_menu_list` VALUES (19, 3, 14);
INSERT INTO `sys_menu_list` VALUES (29, 2, 8);
INSERT INTO `sys_menu_list` VALUES (37, 2, 7);
INSERT INTO `sys_menu_list` VALUES (38, 2, 9);
INSERT INTO `sys_menu_list` VALUES (39, 6, 1);
INSERT INTO `sys_menu_list` VALUES (40, 6, 2);
INSERT INTO `sys_menu_list` VALUES (41, 6, 3);
INSERT INTO `sys_menu_list` VALUES (42, 6, 4);
INSERT INTO `sys_menu_list` VALUES (44, 6, 5);
INSERT INTO `sys_menu_list` VALUES (45, 6, 6);
INSERT INTO `sys_menu_list` VALUES (46, 6, 7);
INSERT INTO `sys_menu_list` VALUES (47, 6, 8);
INSERT INTO `sys_menu_list` VALUES (48, 6, 9);
INSERT INTO `sys_menu_list` VALUES (49, 6, 10);
INSERT INTO `sys_menu_list` VALUES (50, 6, 11);
INSERT INTO `sys_menu_list` VALUES (51, 6, 12);
INSERT INTO `sys_menu_list` VALUES (52, 6, 13);
INSERT INTO `sys_menu_list` VALUES (53, 6, 14);
INSERT INTO `sys_menu_list` VALUES (55, 21, 7);
INSERT INTO `sys_menu_list` VALUES (56, 19, 6);
INSERT INTO `sys_menu_list` VALUES (57, 19, 7);
INSERT INTO `sys_menu_list` VALUES (58, 19, 8);
INSERT INTO `sys_menu_list` VALUES (59, 19, 9);
INSERT INTO `sys_menu_list` VALUES (60, 20, 6);
INSERT INTO `sys_menu_list` VALUES (61, 20, 10);
INSERT INTO `sys_menu_list` VALUES (62, 20, 11);
INSERT INTO `sys_menu_list` VALUES (63, 20, 12);
INSERT INTO `sys_menu_list` VALUES (64, 20, 13);
INSERT INTO `sys_menu_list` VALUES (65, 20, 14);
INSERT INTO `sys_menu_list` VALUES (74, 2, 6);
INSERT INTO `sys_menu_list` VALUES (75, 1, 10);
INSERT INTO `sys_menu_list` VALUES (76, 1, 11);
INSERT INTO `sys_menu_list` VALUES (77, 1, 12);
INSERT INTO `sys_menu_list` VALUES (78, 1, 13);
INSERT INTO `sys_menu_list` VALUES (81, 1, 14);
INSERT INTO `sys_menu_list` VALUES (84, 7, 10);
INSERT INTO `sys_menu_list` VALUES (85, 7, 11);
INSERT INTO `sys_menu_list` VALUES (86, 7, 12);
INSERT INTO `sys_menu_list` VALUES (87, 7, 13);
INSERT INTO `sys_menu_list` VALUES (88, 7, 14);
INSERT INTO `sys_menu_list` VALUES (90, 36, 11);
INSERT INTO `sys_menu_list` VALUES (91, 36, 12);
INSERT INTO `sys_menu_list` VALUES (92, 36, 13);
INSERT INTO `sys_menu_list` VALUES (93, 36, 14);
INSERT INTO `sys_menu_list` VALUES (96, 37, 6);
INSERT INTO `sys_menu_list` VALUES (97, 37, 7);
INSERT INTO `sys_menu_list` VALUES (98, 37, 8);
INSERT INTO `sys_menu_list` VALUES (99, 37, 9);
INSERT INTO `sys_menu_list` VALUES (100, 38, 10);
INSERT INTO `sys_menu_list` VALUES (101, 40, 10);
INSERT INTO `sys_menu_list` VALUES (102, 40, 11);
INSERT INTO `sys_menu_list` VALUES (103, 40, 12);
INSERT INTO `sys_menu_list` VALUES (104, 40, 13);
INSERT INTO `sys_menu_list` VALUES (105, 40, 14);
INSERT INTO `sys_menu_list` VALUES (106, 41, 10);
INSERT INTO `sys_menu_list` VALUES (107, 41, 11);
INSERT INTO `sys_menu_list` VALUES (108, 41, 12);
INSERT INTO `sys_menu_list` VALUES (109, 41, 13);
INSERT INTO `sys_menu_list` VALUES (110, 41, 14);
INSERT INTO `sys_menu_list` VALUES (111, 44, 6);
INSERT INTO `sys_menu_list` VALUES (112, 44, 7);
INSERT INTO `sys_menu_list` VALUES (113, 44, 8);
INSERT INTO `sys_menu_list` VALUES (114, 44, 9);
INSERT INTO `sys_menu_list` VALUES (115, 45, 6);
INSERT INTO `sys_menu_list` VALUES (116, 45, 7);
INSERT INTO `sys_menu_list` VALUES (117, 45, 8);
INSERT INTO `sys_menu_list` VALUES (118, 45, 9);
INSERT INTO `sys_menu_list` VALUES (119, 46, 9);
INSERT INTO `sys_menu_list` VALUES (120, 46, 7);
INSERT INTO `sys_menu_list` VALUES (121, 46, 8);
INSERT INTO `sys_menu_list` VALUES (122, 46, 6);
INSERT INTO `sys_menu_list` VALUES (123, 47, 6);
INSERT INTO `sys_menu_list` VALUES (124, 47, 7);
INSERT INTO `sys_menu_list` VALUES (125, 47, 8);
INSERT INTO `sys_menu_list` VALUES (126, 47, 9);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `USER_ID` int(100) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `RIGHTS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ROLE_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_LOGIN` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IP` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STATUS` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BZ` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SKIN` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EMAIL` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NUMBER` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PHONE` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MAN_BUYER_ID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'bvo', 'bvo', 'bvo', '1', '2', '2020-07-20', '1', '1', '1', '1', '2772834827347@qq.com', '1', '197238473627', 1);
INSERT INTO `sys_user` VALUES (2, 'mvo', 'mvo', 'mvo', '2', '1', '2020-07-20', NULL, NULL, NULL, NULL, '1278387124@qq.com', NULL, '138493834727', 2);
INSERT INTO `sys_user` VALUES (3, 'admin', 'admin', 'admin', '3', '0', NULL, NULL, NULL, NULL, NULL, '1192185532@qq.com', NULL, '18604013195', 4);
INSERT INTO `sys_user` VALUES (6, 'user4', '1', '12', NULL, '1', NULL, NULL, NULL, NULL, NULL, '12@1.com', NULL, '12111121212', 6);
INSERT INTO `sys_user` VALUES (7, 'user5', 'string', 'user5name', NULL, '2', NULL, NULL, NULL, NULL, NULL, '123', NULL, '123', 7);
INSERT INTO `sys_user` VALUES (8, 'user6', 'string', 'user4', NULL, '2', NULL, NULL, NULL, NULL, NULL, '123', NULL, '123', 3);
INSERT INTO `sys_user` VALUES (20, '674567', '45645', '5467', NULL, '2', NULL, NULL, NULL, NULL, NULL, '674', NULL, '6745', 14);
INSERT INTO `sys_user` VALUES (27, '123', '123', '123', NULL, '1', NULL, NULL, NULL, NULL, NULL, '123', NULL, '123', 0);
INSERT INTO `sys_user` VALUES (35, 'bvotest', 'bvotest', 'bvotest', NULL, '2', NULL, NULL, NULL, NULL, NULL, '1223@qq.com', NULL, '13428168281', 15);
INSERT INTO `sys_user` VALUES (36, 'xinhui', 'lxh', 'lxh', NULL, '2', '2020-07-22', NULL, NULL, NULL, NULL, '20175431@qq.com', NULL, '18245430555', 16);
INSERT INTO `sys_user` VALUES (37, 'mvotest', 'mvotest', 'mvotest', NULL, '1', NULL, NULL, NULL, NULL, NULL, '1234123423@qq.com', NULL, '12343423212', 0);
INSERT INTO `sys_user` VALUES (38, 'a', '1', 'sss', NULL, '2', NULL, NULL, NULL, NULL, NULL, '222@11.com', NULL, '1', 17);
INSERT INTO `sys_user` VALUES (39, '12', '12', '21', NULL, '1', NULL, NULL, NULL, NULL, NULL, '21', NULL, '21', 0);
INSERT INTO `sys_user` VALUES (40, 'xiongyue', 'xiongyue', 'xiongyue', NULL, '2', NULL, NULL, NULL, NULL, NULL, '1024112@qq.com', NULL, '13428618611', 18);
INSERT INTO `sys_user` VALUES (41, 'xy', '1', 'xy', NULL, '2', NULL, NULL, NULL, NULL, NULL, '12314@qq.com', NULL, '1392812323', 19);
INSERT INTO `sys_user` VALUES (46, 'username', '1', 'new', NULL, '1', NULL, NULL, NULL, NULL, NULL, '12@qq.com', NULL, '1231231', 0);
INSERT INTO `sys_user` VALUES (47, '789', '789', '789', NULL, '1', NULL, NULL, NULL, NULL, NULL, '789', NULL, '789', 10);
INSERT INTO `sys_user` VALUES (48, 'usernew', '1', 'usernew', NULL, '1', NULL, NULL, NULL, NULL, NULL, '3121@qq.com', NULL, '102321923', 0);

-- ----------------------------
-- Table structure for ull_user_login_logout_log
-- ----------------------------
DROP TABLE IF EXISTS `ull_user_login_logout_log`;
CREATE TABLE `ull_user_login_logout_log`  (
  `ULL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TOKEN` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TERMINAL_TYPE` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `OPERATING_TYPE` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `OPERATING_DATE` timestamp(0) NULL DEFAULT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp(0) NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ULL_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for waa_wallet_account
-- ----------------------------
DROP TABLE IF EXISTS `waa_wallet_account`;
CREATE TABLE `waa_wallet_account`  (
  `BUYER_ID` int(11) NOT NULL,
  `ACCOUNT_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EMAIL` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PASSWORD` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ACTIVE_TIME` timestamp(0) NULL DEFAULT NULL,
  `IS_ACTIVE` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STATUS` tinyint(4) NULL DEFAULT NULL,
  `CREATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATE_TIME` date NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_TIME` date NULL DEFAULT NULL,
  `ACCOUNT_TYPE` int(11) NULL DEFAULT NULL,
  `HOLD_ORDER_TIME` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `AUTO_PAY_STATUS` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`BUYER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of waa_wallet_account
-- ----------------------------
INSERT INTO `waa_wallet_account` VALUES (1, '1', NULL, '1', '2020-07-15 10:25:33', 'Y', 0, NULL, NULL, '1', '2020-07-15', 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (2, '2', NULL, '2', '2020-07-15 14:28:15', 'Y', 0, NULL, NULL, '2', '2020-07-15', 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (6, '3', NULL, '222', NULL, 'Y', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (7, 'BVOWalletAccount', NULL, '1', '2020-07-22 13:58:41', 'N', 0, NULL, NULL, 'user5name', '2020-07-22', 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (13, '1', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (14, '1', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (15, '2', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (16, '2', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (17, '1', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (18, '2', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (19, '1223', NULL, '1234', '2020-07-18 17:25:37', 'Y', 0, NULL, NULL, NULL, '2020-07-18', 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (20, '456', NULL, '78', '2020-07-18 17:32:15', 'Y', 0, NULL, NULL, NULL, '2020-07-18', 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (21, '1', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (22, '2', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (23, 'MVO', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (24, 'MVO', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (25, '1', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (26, '2', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (27, '1', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (28, '2', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (29, '1', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (30, '1', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (31, '1', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (32, '2', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (33, '1', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (34, '2', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (35, '2', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (36, 'lxh', NULL, 'lxh', '2020-07-22 21:44:53', 'Y', 0, NULL, NULL, 'LXH', '2020-07-22', 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (37, '1', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (38, '2', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (40, 'xiongyue', NULL, '1', '2020-07-23 20:50:37', 'Y', 0, NULL, NULL, 'xiongyue', '2020-07-23', 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (41, '2', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (42, '1', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (43, '1', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (44, '1', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (45, '1', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (46, '1', NULL, '1', '2020-07-24 08:59:05', 'Y', 0, NULL, NULL, 'new', '2020-07-24', 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (47, '1', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (48, '1', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (49, '1', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `waa_wallet_account` VALUES (50, '1', NULL, NULL, NULL, 'N', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL);

-- ----------------------------
-- Table structure for waf_wallet_account_fund
-- ----------------------------
DROP TABLE IF EXISTS `waf_wallet_account_fund`;
CREATE TABLE `waf_wallet_account_fund`  (
  `BUYER_ID` int(11) NOT NULL,
  `AVAILABLE_MONEY` decimal(10, 2) NULL DEFAULT NULL,
  `DEPOSITING_MONEY` decimal(10, 2) NULL DEFAULT NULL,
  `WITHDRAWING_MONEY` decimal(10, 2) NULL DEFAULT NULL,
  `CREATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATE_TIME` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_TIME` timestamp(0) NULL DEFAULT NULL,
  `CURRENCY` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`BUYER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of waf_wallet_account_fund
-- ----------------------------
INSERT INTO `waf_wallet_account_fund` VALUES (1, 3334.00, 0.00, 0.00, '1', '2020-07-15 10:25:33', 'bvo', '2020-07-24 08:52:25', 'RMB');
INSERT INTO `waf_wallet_account_fund` VALUES (2, 13666.00, 0.00, 0.00, '2', '2020-07-15 14:28:15', 'admin', '2020-07-24 09:00:38', 'RMB');
INSERT INTO `waf_wallet_account_fund` VALUES (6, 8.00, NULL, NULL, NULL, NULL, NULL, '2020-07-18 14:39:40', NULL);
INSERT INTO `waf_wallet_account_fund` VALUES (7, 110.00, 0.00, 0.00, 'user5', '2020-07-16 17:43:09', 'user5', '2020-07-18 17:48:21', 'RMB');
INSERT INTO `waf_wallet_account_fund` VALUES (19, 0.00, 0.00, 0.00, NULL, '2020-07-18 17:25:37', NULL, '2020-07-18 17:25:50', 'RMB');
INSERT INTO `waf_wallet_account_fund` VALUES (20, 7909.00, 0.00, 0.00, NULL, '2020-07-18 17:32:15', 'admin', '2020-07-18 17:37:38', 'RMB');
INSERT INTO `waf_wallet_account_fund` VALUES (36, 100.00, 0.00, 0.00, 'LXH', '2020-07-22 21:44:53', 'admin', '2020-07-22 21:45:31', 'RMB');
INSERT INTO `waf_wallet_account_fund` VALUES (40, 0.00, 10000.00, 0.00, 'xiongyue', '2020-07-23 20:50:37', 'xiongyue', '2020-07-23 20:50:53', 'RMB');
INSERT INTO `waf_wallet_account_fund` VALUES (46, 0.00, 0.00, 0.00, 'new', '2020-07-24 08:59:05', 'new', '2020-07-24 08:59:05', 'RMB');

-- ----------------------------
-- Table structure for wit_wishlist
-- ----------------------------
DROP TABLE IF EXISTS `wit_wishlist`;
CREATE TABLE `wit_wishlist`  (
  `WIT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DSR_ID` int(11) NULL DEFAULT NULL,
  `PRO_ID` int(11) NOT NULL,
  `CREATED_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATION_DATE` date NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_DATE` date NULL DEFAULT NULL,
  `CALL_CNT` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STS_CD` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`WIT_ID`) USING BTREE,
  INDEX `PRO_ID`(`PRO_ID`) USING BTREE,
  INDEX `DSR_ID`(`DSR_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 80 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of wit_wishlist
-- ----------------------------
INSERT INTO `wit_wishlist` VALUES (76, 1, 81, 'bvo', '2020-07-24', 'bvo', '2020-07-24', 0, NULL, NULL);
INSERT INTO `wit_wishlist` VALUES (79, 1, 76, 'bvo', '2020-07-24', 'bvo', '2020-07-24', 0, NULL, NULL);

-- ----------------------------
-- Table structure for wta_wallet_transaction_aduit
-- ----------------------------
DROP TABLE IF EXISTS `wta_wallet_transaction_aduit`;
CREATE TABLE `wta_wallet_transaction_aduit`  (
  `TRANSACTION_AUDIT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BUYER_ID` int(11) NULL DEFAULT NULL,
  `TRANSACTION_ID` int(11) NULL DEFAULT NULL,
  `AVAILABLE_MONEY_BEFORE` decimal(10, 4) NULL DEFAULT NULL,
  `DEPOSITING_MONEY_BEFORE` decimal(10, 4) NULL DEFAULT NULL,
  `WITHDRAWING_MONEY_BEFORE` decimal(10, 4) NULL DEFAULT NULL,
  `OPERATE_MONEY` decimal(10, 4) NULL DEFAULT NULL,
  `OPERATE_TYPE` tinyint(4) NULL DEFAULT NULL,
  `AVAILABLE_MONEY_AFTER` decimal(10, 4) NULL DEFAULT NULL,
  `DEPOSITING_MONEY_AFTER` decimal(10, 4) NULL DEFAULT NULL,
  `WITHDRAWING_MONEY_AFTER` decimal(10, 4) NULL DEFAULT NULL,
  `OPERATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STATUS` tinyint(4) NULL DEFAULT NULL,
  `CREATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATE_TIME` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_TIME` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`TRANSACTION_AUDIT_ID`) USING BTREE,
  INDEX `BUYER_ID`(`BUYER_ID`) USING BTREE,
  INDEX `TRANSACTION_ID`(`TRANSACTION_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of wta_wallet_transaction_aduit
-- ----------------------------
INSERT INTO `wta_wallet_transaction_aduit` VALUES (45, 2, 123, 16000.0000, NULL, 6000.0000, 6000.0000, 2, 10000.0000, NULL, NULL, 'admin', 2, '2', '2020-07-23 21:10:05', 'admin', '2020-07-23 21:11:09');
INSERT INTO `wta_wallet_transaction_aduit` VALUES (46, 2, 124, 16000.0000, NULL, 11000.0000, 5000.0000, 2, 11000.0000, NULL, NULL, 'admin', 0, '2', '2020-07-23 21:10:15', 'admin', '2020-07-24 03:26:20');
INSERT INTO `wta_wallet_transaction_aduit` VALUES (47, 2, 130, 10000.0000, NULL, 6000.0000, 1000.0000, 2, 9000.0000, NULL, NULL, 'admin', 2, '2', '2020-07-24 03:11:54', 'admin', '2020-07-24 03:26:08');
INSERT INTO `wta_wallet_transaction_aduit` VALUES (48, 2, 136, 15666.0000, NULL, 2000.0000, 2000.0000, 2, 13666.0000, NULL, NULL, 'admin', 2, '2', '2020-07-24 08:59:41', 'admin', '2020-07-24 09:00:16');
INSERT INTO `wta_wallet_transaction_aduit` VALUES (49, 2, 137, 13666.0000, NULL, 2000.0000, 2000.0000, 2, 11666.0000, NULL, NULL, 'admin', 0, '2', '2020-07-24 09:00:27', 'admin', '2020-07-24 09:00:38');

-- ----------------------------
-- Table structure for wtr_wallet_transaction_record
-- ----------------------------
DROP TABLE IF EXISTS `wtr_wallet_transaction_record`;
CREATE TABLE `wtr_wallet_transaction_record`  (
  `TRANSACTION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BUYER_ID` int(11) NULL DEFAULT NULL,
  `BANK_CARD_ID` int(11) NULL DEFAULT NULL,
  `TRANSACTION_NUMBER` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TRANSACTION_TYPE` tinyint(4) NULL DEFAULT NULL,
  `ACCOUNT_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TRANSACTION_MONEY` decimal(10, 4) NULL DEFAULT NULL,
  `COMMISSION` decimal(10, 4) NULL DEFAULT NULL,
  `DISCOUNT_COMMISSION` decimal(10, 4) NULL DEFAULT NULL,
  `TRANSACTION_METHOD` tinyint(4) NULL DEFAULT NULL,
  `COMPLETE_TIME` timestamp(0) NULL DEFAULT NULL,
  `STATUS` tinyint(4) NULL DEFAULT NULL,
  `ACTUAL_MONEY` decimal(10, 4) NULL DEFAULT NULL,
  `ACTUAL_COMMISSION` decimal(10, 4) NULL DEFAULT NULL,
  `ACTUAL_DISCOUNT_COMMISSION` decimal(10, 4) NULL DEFAULT NULL,
  `BALANCE` decimal(10, 4) NULL DEFAULT NULL,
  `BUSINESS_ID` int(11) NULL DEFAULT NULL,
  `FINANCE_TYPE` tinyint(4) NULL DEFAULT NULL,
  `NOTE` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `OPERATOR_NAME` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `OPERATOR_IP` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATE_TIME` timestamp(0) NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LAST_UPDATE_TIME` timestamp(0) NULL DEFAULT NULL,
  `BANK_RECEIPT_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXCHANGE_RATE` decimal(10, 4) NULL DEFAULT NULL,
  `TRANSACTION_DESC` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FOREIGN_EXCHANGE_FEE` decimal(10, 4) NULL DEFAULT NULL,
  `WITHDRAW_FEE` decimal(10, 4) NULL DEFAULT NULL,
  PRIMARY KEY (`TRANSACTION_ID`) USING BTREE,
  INDEX `BUYER_ID`(`BUYER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 138 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of wtr_wallet_transaction_record
-- ----------------------------
INSERT INTO `wtr_wallet_transaction_record` VALUES (123, 2, 0, NULL, 2, '2', 6000.0000, NULL, NULL, 0, NULL, 2, NULL, NULL, NULL, NULL, 0, 0, NULL, 'admin', NULL, '2', '2020-07-23 21:10:05', 'admin', '2020-07-23 21:11:09', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `wtr_wallet_transaction_record` VALUES (124, 2, 0, NULL, 2, '2', 5000.0000, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, NULL, 0, 0, NULL, 'admin', NULL, '2', '2020-07-23 21:10:15', 'admin', '2020-07-24 03:26:20', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `wtr_wallet_transaction_record` VALUES (125, 1, 0, NULL, 3, '1', -4266.0000, NULL, NULL, 0, NULL, 2, NULL, NULL, NULL, NULL, 1, 0, NULL, NULL, NULL, '1', '2020-07-23 23:00:16', '1', '2020-07-23 23:00:16', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `wtr_wallet_transaction_record` VALUES (126, 2, 0, NULL, 3, '2', 4266.0000, NULL, NULL, 0, NULL, 2, NULL, NULL, NULL, NULL, 1, 0, NULL, NULL, NULL, '1', '2020-07-23 23:00:16', '1', '2020-07-23 23:00:16', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `wtr_wallet_transaction_record` VALUES (127, 1, 0, NULL, 3, '2', 4266.0000, NULL, NULL, 0, NULL, 2, NULL, NULL, NULL, NULL, 1, 0, NULL, NULL, NULL, '2', '2020-07-23 23:01:07', '2', '2020-07-23 23:01:07', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `wtr_wallet_transaction_record` VALUES (128, 2, 0, NULL, 3, '1', -4266.0000, NULL, NULL, 0, NULL, 2, NULL, NULL, NULL, NULL, 1, 0, NULL, NULL, NULL, '2', '2020-07-23 23:01:07', '2', '2020-07-23 23:01:07', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `wtr_wallet_transaction_record` VALUES (130, 2, 0, NULL, 2, '2', 1000.0000, NULL, NULL, 0, NULL, 2, NULL, NULL, NULL, NULL, 0, 0, NULL, 'admin', NULL, '2', '2020-07-24 03:11:54', 'admin', '2020-07-24 03:26:08', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `wtr_wallet_transaction_record` VALUES (133, 1, 0, NULL, 3, '1', -6666.0000, NULL, NULL, 0, NULL, 2, NULL, NULL, NULL, NULL, 2, 0, NULL, NULL, NULL, '1', '2020-07-24 08:52:25', '1', '2020-07-24 08:52:25', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `wtr_wallet_transaction_record` VALUES (134, 2, 0, NULL, 3, '2', 6666.0000, NULL, NULL, 0, NULL, 2, NULL, NULL, NULL, NULL, 2, 0, NULL, NULL, NULL, '1', '2020-07-24 08:52:25', '1', '2020-07-24 08:52:25', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `wtr_wallet_transaction_record` VALUES (136, 2, 0, NULL, 2, '2', 2000.0000, NULL, NULL, 0, NULL, 2, NULL, NULL, NULL, NULL, 0, 0, NULL, 'admin', NULL, '2', '2020-07-24 08:59:41', 'admin', '2020-07-24 09:00:16', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `wtr_wallet_transaction_record` VALUES (137, 2, 0, NULL, 2, '2', 2000.0000, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, NULL, 0, 0, NULL, 'admin', NULL, '2', '2020-07-24 09:00:27', 'admin', '2020-07-24 09:00:38', NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
