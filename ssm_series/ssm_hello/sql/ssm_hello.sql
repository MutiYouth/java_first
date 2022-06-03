-- db config
DROP TABLE IF EXISTS `ssm_hello_user`;
CREATE TABLE `ssm_hello_user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                        `email` varchar(255) NOT NULL COMMENT '用户邮箱',
                        `username` varchar(255) NOT NULL COMMENT '用户昵称',
                        `role` varchar(255) NOT NULL COMMENT '用户身份',
                        `mobile` varchar(50) DEFAULT '' COMMENT '手机号码',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET='utf8';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `ssm_hello_user` VALUES ('1', 'murphy@qq.com', 'xjt', 'root', '15067180001');


DROP TABLE IF EXISTS `ssm_hello_world`;
create table ssm_hello_world
(
    uid int auto_increment primary key,
    username varchar(20) null
);
INSERT INTO `ssm_hello_world` VALUES (1, 'June');
INSERT INTO `ssm_hello_world` VALUES (2, 'ILoveJune');
