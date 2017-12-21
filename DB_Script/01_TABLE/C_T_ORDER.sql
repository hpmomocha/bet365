CREATE TABLE `t_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '投注单ID',
  `order_prpl` double DEFAULT NULL COMMENT '本金',
  `bet_tgt_matches` varchar(45) DEFAULT NULL COMMENT '投注对象比赛场次',
  `estm_bonus` double DEFAULT NULL COMMENT '预计奖金',
  `is_win` tinyint(4) DEFAULT NULL COMMENT '是否中奖',
  `is_closed` tinyint(4) DEFAULT NULL COMMENT '是否结算完成',
  `is_closed_manually` tinyint(4) DEFAULT NULL COMMENT '是否手动完成结算',
  `order_date` date NOT NULL COMMENT '投注日期',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`order_id`),
  KEY `fk_order_user_idx` (`user_id`),
  CONSTRAINT `fk_order_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8