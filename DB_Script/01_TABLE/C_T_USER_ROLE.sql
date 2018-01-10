CREATE TABLE `t_user_role` (
  `user_role_id` int(11) NOT NULL COMMENT '用户权限ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `user_role` varchar(45) NOT NULL COMMENT '用户权限',
  PRIMARY KEY (`user_role_id`),
  KEY `fk_user_role_user_idx` (`user_id`),
  CONSTRAINT `fk_user_role_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限表'