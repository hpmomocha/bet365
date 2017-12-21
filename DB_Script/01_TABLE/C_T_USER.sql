CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `user_name` varchar(45) DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表'