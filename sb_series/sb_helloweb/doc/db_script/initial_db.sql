create database if not exists test_210216_springboot;
use test_210216_springboot;

DROP TABLE IF EXISTS `tsa_user`;
CREATE TABLE `tsa_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
--   `details` varchar(200) DEFAULT NULL COMMENT '描述',--
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;


INSERT INTO `tsa_user` VALUES (100, 'weng', '2019')