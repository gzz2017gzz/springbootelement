/*
Navicat MySQL Data Transfer

Source Server         : 测试副本(localhost)
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-08-17 14:21:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin_dept`
-- ----------------------------
DROP TABLE IF EXISTS `admin_dept`;
CREATE TABLE `admin_dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(20) DEFAULT NULL COMMENT '上级ID',
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `enable` tinyint(4) DEFAULT NULL COMMENT '可用标志',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='部门';

-- ----------------------------
-- Records of admin_dept
-- ----------------------------
INSERT INTO `admin_dept` VALUES ('1', '0', '总部', '1', '测试');
INSERT INTO `admin_dept` VALUES ('43', '1', '市场部', '1', '测试');
INSERT INTO `admin_dept` VALUES ('44', '1', '营销部', '1', '1');
INSERT INTO `admin_dept` VALUES ('46', '43', '市场调研部', '1', '测试');
INSERT INTO `admin_dept` VALUES ('47', '43', '市场宣传部', '0', '哈哈哈');
INSERT INTO `admin_dept` VALUES ('49', '1', '总部3', '1', null);
INSERT INTO `admin_dept` VALUES ('50', '49', '总部2', '1', null);
INSERT INTO `admin_dept` VALUES ('51', '50', '总部1', '1', null);

-- ----------------------------
-- Table structure for `admin_func`
-- ----------------------------
DROP TABLE IF EXISTS `admin_func`;
CREATE TABLE `admin_func` (
  `func_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型',
  `color` varchar(10) DEFAULT NULL COMMENT '颜色',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '父结点ID',
  `tip` varchar(50) DEFAULT NULL COMMENT '提示信息',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `url` varchar(100) DEFAULT NULL COMMENT '地址',
  `order_num` smallint(5) DEFAULT NULL COMMENT '排序编号',
  PRIMARY KEY (`func_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Records of admin_func
-- ----------------------------
INSERT INTO `admin_func` VALUES ('1', '1', '', 'el-icon-date', '系统菜单', '0', '系统设置', '', '1', '', '1');
INSERT INTO `admin_func` VALUES ('2', '1', '', 'el-icon-sold-out', '用户管理', '1', '用户管理', null, '1', '/adminSysUser', '2');
INSERT INTO `admin_func` VALUES ('3', '1', '', 'el-icon-date', '机构管理', '1', '部门管理', null, '1', '/adminDept', '3');
INSERT INTO `admin_func` VALUES ('4', '1', '', 'el-icon-phone', '角色管理', '1', '角色管理', null, '1', '/adminRole', '4');
INSERT INTO `admin_func` VALUES ('5', '1', '', 'el-icon-document', '菜单管理', '1', '菜单管理', null, '1', '/adminMenu', '5');

-- ----------------------------
-- Table structure for `admin_role`
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES ('1', '客服', '客服');
INSERT INTO `admin_role` VALUES ('6', '销售', '销售');
INSERT INTO `admin_role` VALUES ('7', '审核', '审核');
INSERT INTO `admin_role` VALUES ('8', '管理员', '管理员');

-- ----------------------------
-- Table structure for `admin_role_dept`
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_dept`;
CREATE TABLE `admin_role_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) DEFAULT NULL COMMENT '角色主键',
  `dept_id` int(11) DEFAULT NULL COMMENT '菜单主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='角色部门';

-- ----------------------------
-- Records of admin_role_dept
-- ----------------------------
INSERT INTO `admin_role_dept` VALUES ('13', '7', '1');
INSERT INTO `admin_role_dept` VALUES ('14', '7', '43');
INSERT INTO `admin_role_dept` VALUES ('15', '7', '46');
INSERT INTO `admin_role_dept` VALUES ('16', '7', '47');
INSERT INTO `admin_role_dept` VALUES ('17', '7', '44');
INSERT INTO `admin_role_dept` VALUES ('18', '7', '49');
INSERT INTO `admin_role_dept` VALUES ('19', '7', '50');
INSERT INTO `admin_role_dept` VALUES ('20', '7', '51');
INSERT INTO `admin_role_dept` VALUES ('51', '9', '43');
INSERT INTO `admin_role_dept` VALUES ('52', '9', '46');
INSERT INTO `admin_role_dept` VALUES ('53', '9', '47');
INSERT INTO `admin_role_dept` VALUES ('54', '9', '49');
INSERT INTO `admin_role_dept` VALUES ('55', '9', '50');
INSERT INTO `admin_role_dept` VALUES ('56', '9', '51');

-- ----------------------------
-- Table structure for `admin_role_func`
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_func`;
CREATE TABLE `admin_role_func` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) DEFAULT NULL COMMENT '角色主键',
  `user_id` int(11) DEFAULT NULL COMMENT '菜单主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8 COMMENT='角色菜单(功能权限)';

-- ----------------------------
-- Records of admin_role_func
-- ----------------------------
INSERT INTO `admin_role_func` VALUES ('29', '9', '199');
INSERT INTO `admin_role_func` VALUES ('30', '9', '200');
INSERT INTO `admin_role_func` VALUES ('31', '1', '1');
INSERT INTO `admin_role_func` VALUES ('32', '1', '2');
INSERT INTO `admin_role_func` VALUES ('33', '1', '3');
INSERT INTO `admin_role_func` VALUES ('34', '1', '4');
INSERT INTO `admin_role_func` VALUES ('35', '1', '209');
INSERT INTO `admin_role_func` VALUES ('36', '1', '210');
INSERT INTO `admin_role_func` VALUES ('37', '1', '211');
INSERT INTO `admin_role_func` VALUES ('38', '1', '212');
INSERT INTO `admin_role_func` VALUES ('39', '1', '213');
INSERT INTO `admin_role_func` VALUES ('40', '1', '214');
INSERT INTO `admin_role_func` VALUES ('41', '1', '215');
INSERT INTO `admin_role_func` VALUES ('42', '1', '216');
INSERT INTO `admin_role_func` VALUES ('43', '1', '217');
INSERT INTO `admin_role_func` VALUES ('44', '1', '218');
INSERT INTO `admin_role_func` VALUES ('45', '1', '219');
INSERT INTO `admin_role_func` VALUES ('46', '1', '220');
INSERT INTO `admin_role_func` VALUES ('47', '1', '221');
INSERT INTO `admin_role_func` VALUES ('48', '1', '222');
INSERT INTO `admin_role_func` VALUES ('49', '1', '223');
INSERT INTO `admin_role_func` VALUES ('50', '1', '224');
INSERT INTO `admin_role_func` VALUES ('51', '1', '225');
INSERT INTO `admin_role_func` VALUES ('52', '1', '226');
INSERT INTO `admin_role_func` VALUES ('53', '1', '227');
INSERT INTO `admin_role_func` VALUES ('54', '1', '228');
INSERT INTO `admin_role_func` VALUES ('55', '1', '229');
INSERT INTO `admin_role_func` VALUES ('56', '1', '230');
INSERT INTO `admin_role_func` VALUES ('57', '1', '231');
INSERT INTO `admin_role_func` VALUES ('58', '1', '232');
INSERT INTO `admin_role_func` VALUES ('59', '1', '233');
INSERT INTO `admin_role_func` VALUES ('60', '1', '234');
INSERT INTO `admin_role_func` VALUES ('61', '1', '235');
INSERT INTO `admin_role_func` VALUES ('62', '1', '236');
INSERT INTO `admin_role_func` VALUES ('63', '1', '237');
INSERT INTO `admin_role_func` VALUES ('64', '1', '238');
INSERT INTO `admin_role_func` VALUES ('65', '1', '239');
INSERT INTO `admin_role_func` VALUES ('66', '1', '240');
INSERT INTO `admin_role_func` VALUES ('67', '1', '241');
INSERT INTO `admin_role_func` VALUES ('68', '8', '1');
INSERT INTO `admin_role_func` VALUES ('69', '8', '2');
INSERT INTO `admin_role_func` VALUES ('70', '8', '3');
INSERT INTO `admin_role_func` VALUES ('71', '8', '4');
INSERT INTO `admin_role_func` VALUES ('72', '8', '209');
INSERT INTO `admin_role_func` VALUES ('73', '8', '210');
INSERT INTO `admin_role_func` VALUES ('74', '8', '211');
INSERT INTO `admin_role_func` VALUES ('75', '8', '212');
INSERT INTO `admin_role_func` VALUES ('76', '8', '213');
INSERT INTO `admin_role_func` VALUES ('77', '8', '214');
INSERT INTO `admin_role_func` VALUES ('78', '8', '215');
INSERT INTO `admin_role_func` VALUES ('79', '8', '216');
INSERT INTO `admin_role_func` VALUES ('80', '8', '217');
INSERT INTO `admin_role_func` VALUES ('81', '8', '218');
INSERT INTO `admin_role_func` VALUES ('82', '8', '219');
INSERT INTO `admin_role_func` VALUES ('83', '8', '220');
INSERT INTO `admin_role_func` VALUES ('84', '8', '221');
INSERT INTO `admin_role_func` VALUES ('85', '8', '222');
INSERT INTO `admin_role_func` VALUES ('86', '8', '223');
INSERT INTO `admin_role_func` VALUES ('87', '8', '224');
INSERT INTO `admin_role_func` VALUES ('88', '8', '225');
INSERT INTO `admin_role_func` VALUES ('89', '8', '226');
INSERT INTO `admin_role_func` VALUES ('90', '8', '227');
INSERT INTO `admin_role_func` VALUES ('91', '8', '228');
INSERT INTO `admin_role_func` VALUES ('92', '8', '229');
INSERT INTO `admin_role_func` VALUES ('93', '8', '230');
INSERT INTO `admin_role_func` VALUES ('94', '8', '231');
INSERT INTO `admin_role_func` VALUES ('95', '8', '232');
INSERT INTO `admin_role_func` VALUES ('96', '8', '233');
INSERT INTO `admin_role_func` VALUES ('97', '8', '234');
INSERT INTO `admin_role_func` VALUES ('98', '8', '235');
INSERT INTO `admin_role_func` VALUES ('99', '8', '236');
INSERT INTO `admin_role_func` VALUES ('100', '8', '237');
INSERT INTO `admin_role_func` VALUES ('101', '8', '238');
INSERT INTO `admin_role_func` VALUES ('102', '8', '239');
INSERT INTO `admin_role_func` VALUES ('103', '8', '240');
INSERT INTO `admin_role_func` VALUES ('104', '8', '241');
INSERT INTO `admin_role_func` VALUES ('105', '7', '1');
INSERT INTO `admin_role_func` VALUES ('106', '7', '2');
INSERT INTO `admin_role_func` VALUES ('107', '7', '3');
INSERT INTO `admin_role_func` VALUES ('108', '7', '4');
INSERT INTO `admin_role_func` VALUES ('109', '7', '209');
INSERT INTO `admin_role_func` VALUES ('110', '7', '210');
INSERT INTO `admin_role_func` VALUES ('111', '7', '211');
INSERT INTO `admin_role_func` VALUES ('112', '7', '212');
INSERT INTO `admin_role_func` VALUES ('113', '7', '213');
INSERT INTO `admin_role_func` VALUES ('114', '7', '214');
INSERT INTO `admin_role_func` VALUES ('115', '7', '215');
INSERT INTO `admin_role_func` VALUES ('116', '7', '216');
INSERT INTO `admin_role_func` VALUES ('117', '7', '217');
INSERT INTO `admin_role_func` VALUES ('118', '7', '218');
INSERT INTO `admin_role_func` VALUES ('119', '7', '219');
INSERT INTO `admin_role_func` VALUES ('120', '7', '220');
INSERT INTO `admin_role_func` VALUES ('121', '7', '221');
INSERT INTO `admin_role_func` VALUES ('122', '7', '222');
INSERT INTO `admin_role_func` VALUES ('123', '7', '223');
INSERT INTO `admin_role_func` VALUES ('124', '7', '224');
INSERT INTO `admin_role_func` VALUES ('125', '7', '225');
INSERT INTO `admin_role_func` VALUES ('126', '7', '226');
INSERT INTO `admin_role_func` VALUES ('127', '7', '227');
INSERT INTO `admin_role_func` VALUES ('128', '7', '228');
INSERT INTO `admin_role_func` VALUES ('129', '7', '229');
INSERT INTO `admin_role_func` VALUES ('130', '7', '230');
INSERT INTO `admin_role_func` VALUES ('131', '7', '231');
INSERT INTO `admin_role_func` VALUES ('132', '7', '232');
INSERT INTO `admin_role_func` VALUES ('133', '7', '233');
INSERT INTO `admin_role_func` VALUES ('134', '7', '234');
INSERT INTO `admin_role_func` VALUES ('135', '7', '235');
INSERT INTO `admin_role_func` VALUES ('136', '7', '236');
INSERT INTO `admin_role_func` VALUES ('137', '7', '237');
INSERT INTO `admin_role_func` VALUES ('138', '7', '238');
INSERT INTO `admin_role_func` VALUES ('139', '7', '239');
INSERT INTO `admin_role_func` VALUES ('140', '7', '240');
INSERT INTO `admin_role_func` VALUES ('141', '7', '241');

-- ----------------------------
-- Table structure for `admin_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `admin_sys_user`;
CREATE TABLE `admin_sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `password` varchar(100) DEFAULT NULL COMMENT '会员编号',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `department_id` int(11) DEFAULT NULL COMMENT '部门ID',
  `wechat` varchar(50) DEFAULT NULL COMMENT '微信号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of admin_sys_user
-- ----------------------------
INSERT INTO `admin_sys_user` VALUES ('1', '管理员', 'f63f4fbc9f8c85d409f2f59f2b9e12d5', '11111111111', '1', '1', '1', '', '');
INSERT INTO `admin_sys_user` VALUES ('2', '12312', 'f63f4fbc9f8c85d409f2f59f2b9e12d5', '32131231111', '2', '1', '43', '111', '1');
INSERT INTO `admin_sys_user` VALUES ('3', '马大哈', 'f63f4fbc9f8c85d409f2f59f2b9e12d5', '11111111112', '2', '1', '50', '22222222', '测试');
INSERT INTO `admin_sys_user` VALUES ('4', '王平', 'f63f4fbc9f8c85d409f2f59f2b9e12d5', '13641104698', '1', '1', '49', '13641104698', null);
INSERT INTO `admin_sys_user` VALUES ('5', '颖萍', 'f63f4fbc9f8c85d409f2f59f2b9e12d5', '15207894242', '2', '1', '49', '2222222222222', '111111111111111');
INSERT INTO `admin_sys_user` VALUES ('6', '皇甫蕴涵', 'f63f4fbc9f8c85d409f2f59f2b9e12d5', '17600401135', '2', '1', '47', '3333333333', null);

-- ----------------------------
-- Table structure for `admin_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_role`;
CREATE TABLE `admin_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户主键',
  `role_id` int(11) DEFAULT NULL COMMENT '角色主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=422 DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- ----------------------------
-- Records of admin_user_role
-- ----------------------------
INSERT INTO `admin_user_role` VALUES ('378', '4', '6');
INSERT INTO `admin_user_role` VALUES ('379', '4', '9');
INSERT INTO `admin_user_role` VALUES ('402', '1', '1');
INSERT INTO `admin_user_role` VALUES ('403', '1', '6');
INSERT INTO `admin_user_role` VALUES ('404', '1', '7');
INSERT INTO `admin_user_role` VALUES ('405', '1', '8');
INSERT INTO `admin_user_role` VALUES ('410', '2', '1');
INSERT INTO `admin_user_role` VALUES ('411', '2', '6');
INSERT INTO `admin_user_role` VALUES ('412', '2', '7');
INSERT INTO `admin_user_role` VALUES ('413', '2', '8');
INSERT INTO `admin_user_role` VALUES ('414', '3', '7');
INSERT INTO `admin_user_role` VALUES ('415', '3', '6');
INSERT INTO `admin_user_role` VALUES ('416', '3', '8');
INSERT INTO `admin_user_role` VALUES ('417', '3', '1');
INSERT INTO `admin_user_role` VALUES ('418', '5', '8');
INSERT INTO `admin_user_role` VALUES ('419', '5', '1');
INSERT INTO `admin_user_role` VALUES ('420', '5', '6');
INSERT INTO `admin_user_role` VALUES ('421', '5', '7');
