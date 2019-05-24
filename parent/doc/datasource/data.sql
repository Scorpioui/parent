/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : snow

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2019-05-23 15:49:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `sys_role_menu_id` varchar(32) NOT NULL COMMENT '主键ID',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色ID',
  `menu_id` varchar(32) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`sys_role_menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `dict_id` varchar(32) NOT NULL COMMENT '菜单ID',
  `value` varchar(100) DEFAULT NULL COMMENT '数据值',
  `label` varchar(100) DEFAULT NULL COMMENT '标签名',
  `type` varchar(50) DEFAULT NULL COMMENT '类型',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `sort` varchar(50) DEFAULT NULL COMMENT '排序',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` varchar(2) DEFAULT NULL COMMENT '删除标识：0：正常；1：已删除',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='数据字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_data`;
CREATE TABLE `sys_user_data` (
  `sys_user_data_id` varchar(32) NOT NULL COMMENT '用户数据权限关系ID',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `data_permissions_id` varchar(32) DEFAULT NULL COMMENT '数据权限ID',
  `del_flag` varchar(1) DEFAULT NULL COMMENT '激活标识：0：正常；1：已删除',
  PRIMARY KEY (`sys_user_data_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户数据权限关系表';

-- ----------------------------
-- Records of sys_user_data
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名称',
  `user_code` varchar(100) DEFAULT NULL COMMENT '登录名',
  `password` varchar(100) DEFAULT NULL COMMENT '登录密码',
  `office_id` varchar(32) DEFAULT NULL COMMENT '部门ID',
  `phone` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `photo` varchar(100) DEFAULT NULL COMMENT '用户头像',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` varchar(2) DEFAULT NULL COMMENT '删除标识：0：正常；1：已删除',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `sys_user_role_id` varchar(32) NOT NULL COMMENT '主键ID',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`sys_user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_office
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_office`;
CREATE TABLE `sys_user_office` (
  `sys_user_office_id` varchar(32) NOT NULL COMMENT '主键ID',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `office_id` varchar(32) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`sys_user_office_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='用户部门关系表';

-- ----------------------------
-- Records of sys_user_office
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` varchar(32) NOT NULL COMMENT '菜单表主键',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父级编号',
  `parent_ids` varchar(100) DEFAULT NULL COMMENT '所有父级编号',
  `menu_name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `menu_url` varchar(100) DEFAULT NULL COMMENT '菜单路径',
  `sort` varchar(100) DEFAULT NULL COMMENT '排序',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `permission` varchar(32) DEFAULT NULL COMMENT '权限标识',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` varchar(2) DEFAULT NULL COMMENT '删除标识：0：正常；1：已删除',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` varchar(32) NOT NULL COMMENT '角色ID',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `office_id` varchar(32) DEFAULT NULL COMMENT '所属机构',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` varchar(2) DEFAULT NULL COMMENT '删除标识：0：正常；1：已删除',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_office
-- ----------------------------
DROP TABLE IF EXISTS `sys_office`;
CREATE TABLE `sys_office` (
  `office_id` varchar(32) NOT NULL COMMENT '部门ID',
  `office_code` varchar(100) DEFAULT NULL COMMENT '部门编码',
  `office_name` varchar(100) DEFAULT NULL COMMENT '部门名称',
  `parent_office_id` varchar(32) DEFAULT NULL COMMENT '上级部门ID',
  `parent_office_ids` varchar(100) DEFAULT NULL COMMENT '所有上级ID',
  `office_level` varchar(30) DEFAULT NULL COMMENT '部门级别',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_user` varchar(100) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` varchar(2) DEFAULT NULL COMMENT '删除标识：0：正常；1：已删除',
  PRIMARY KEY (`office_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='部门表';

-- ----------------------------
-- Records of sys_office
-- ----------------------------
