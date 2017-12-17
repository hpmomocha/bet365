CREATE TABLE `t_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '投注单ID',
  `order_prpl` double DEFAULT NULL COMMENT '本金',
  `bet_tgt_matches` varchar(45) DEFAULT NULL COMMENT '投注对象比赛场次',
  `estm_bonus` double DEFAULT NULL COMMENT '预计奖金',
  `is_win` tinyint(4) DEFAULT NULL COMMENT '是否中奖',
  `is_closed` tinyint(4) DEFAULT NULL COMMENT '是否结算完成',
  `is_closed_manually` tinyint(4) DEFAULT NULL COMMENT '是否手动完成结算',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8