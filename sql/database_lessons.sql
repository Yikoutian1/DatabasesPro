/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : database_lessons

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 20/12/2023 17:03:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for company_benfitits
-- ----------------------------
DROP TABLE IF EXISTS `company_benfitits`;
CREATE TABLE `company_benfitits`  (
  `benefit_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '福利名称',
  `benefit_value` decimal(10, 2) NULL DEFAULT NULL COMMENT '福利值'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of company_benfitits
-- ----------------------------
INSERT INTO `company_benfitits` VALUES ('高温补贴', 500.00);
INSERT INTO `company_benfitits` VALUES ('全勤奖', 500.00);
INSERT INTO `company_benfitits` VALUES ('奖励1', 300.00);
INSERT INTO `company_benfitits` VALUES ('奖励2', 400.00);

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `dept_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '部门名称',
  `job_title` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '工作岗位名称',
  `job_salary` decimal(10, 2) NULL DEFAULT NULL COMMENT '工作岗位工资'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('高级管理层', '资深专家', 2500000.00);
INSERT INTO `dept` VALUES ('高级管理层', '总监', 2300000.00);
INSERT INTO `dept` VALUES ('普通员工', '前台助理', 100000.00);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `sex` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '1' COMMENT '性别: 1男性(默认) 0女性',
  `dept` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所在部门',
  `salary_jb` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '工资级别',
  `salary_dj` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '工资等级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000004 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, 'Calyee', '1', '高级管理层', '资深专家', 'P9');
INSERT INTO `employee` VALUES (2, 'Chen', '1', '高级管理层', '资深经理', 'P8');
INSERT INTO `employee` VALUES (1000000, '小梨', '0', '普通员工', '实习生', 'P3');
INSERT INTO `employee` VALUES (1000001, '小刘', '1', '普通员工', '实习生', 'P3');
INSERT INTO `employee` VALUES (1000002, '小罗', '1', '高级管理层', '高级专家', 'P8');
INSERT INTO `employee` VALUES (1000003, '小苹', '0', '高级管理层', '经理', 'P7');

-- ----------------------------
-- Table structure for experience
-- ----------------------------
DROP TABLE IF EXISTS `experience`;
CREATE TABLE `experience`  (
  `exp` int NULL DEFAULT NULL COMMENT '工龄',
  `sal_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '工资金额'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of experience
-- ----------------------------
INSERT INTO `experience` VALUES (0, 1000.00);
INSERT INTO `experience` VALUES (1, 5000.00);
INSERT INTO `experience` VALUES (2, 7000.00);
INSERT INTO `experience` VALUES (3, 10000.00);
INSERT INTO `experience` VALUES (4, 13000.00);
INSERT INTO `experience` VALUES (5, 15000.00);
INSERT INTO `experience` VALUES (6, 20000.00);
INSERT INTO `experience` VALUES (7, 25000.00);
INSERT INTO `experience` VALUES (8, 30000.00);
INSERT INTO `experience` VALUES (9, 40000.00);
INSERT INTO `experience` VALUES (10, 50000.00);
INSERT INTO `experience` VALUES (11, 60000.00);
INSERT INTO `experience` VALUES (12, 70000.00);

-- ----------------------------
-- Table structure for salary_info
-- ----------------------------
DROP TABLE IF EXISTS `salary_info`;
CREATE TABLE `salary_info`  (
  `emp_id` int NOT NULL,
  `emp_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '员工姓名',
  `base_salary` decimal(10, 2) NULL DEFAULT NULL COMMENT '员工基础工资',
  `job_salary` decimal(10, 2) NULL DEFAULT NULL COMMENT '员工岗位工资',
  `exp_salary` decimal(10, 2) NULL DEFAULT NULL COMMENT '员工工龄工资',
  `company_benefits` decimal(10, 2) NULL DEFAULT NULL COMMENT '公司福利',
  `net_salary` decimal(10, 2) NULL DEFAULT NULL COMMENT '员工实得工资',
  PRIMARY KEY (`emp_id`) USING BTREE,
  CONSTRAINT `sal_info_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of salary_info
-- ----------------------------
INSERT INTO `salary_info` VALUES (1, 'Calyee', 2300000.00, 100000.00, 100000.00, 60893.00, 3000893.00);
INSERT INTO `salary_info` VALUES (2, 'Chen', 2000000.00, 50000.00, 50000.00, 30893.00, 2400893.00);

-- ----------------------------
-- Table structure for salary_level
-- ----------------------------
DROP TABLE IF EXISTS `salary_level`;
CREATE TABLE `salary_level`  (
  `sal_grade` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '工资级别',
  `sal_amount` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '工资金额',
  `sal_job_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '工资级别对照工作名'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of salary_level
-- ----------------------------
INSERT INTO `salary_level` VALUES ('P9', '62-86k', '资深专家,总监');
INSERT INTO `salary_level` VALUES ('P8', '48-65k', '高级专家,资深经理');
INSERT INTO `salary_level` VALUES ('P7', '34-46k', '专家,经理');
INSERT INTO `salary_level` VALUES ('P6', '25-38k', '高级工程师,主管');
INSERT INTO `salary_level` VALUES ('P5', '20-25k', '中级工程师');
INSERT INTO `salary_level` VALUES ('P4', '15-20k', '初级工程师');
INSERT INTO `salary_level` VALUES ('P3', '7-10k', '实习生');
INSERT INTO `salary_level` VALUES ('Other', '7k以下', '其他');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `status` int NULL DEFAULT 1 COMMENT '状态: 1启用(默认) 0禁用',
  `role` int NULL DEFAULT 1 COMMENT '用户角色: 1:普通用户(默认) 0:管理员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'da80841b5ac14911af60d34af2642fe7$aaa29131ec6cb79c3fb67c6b749f7fa0', 1, 0);

SET FOREIGN_KEY_CHECKS = 1;
