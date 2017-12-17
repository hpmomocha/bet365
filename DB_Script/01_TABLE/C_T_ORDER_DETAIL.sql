CREATE TABLE `t_order_detail` (
  `order_id` int(11) NOT NULL COMMENT '投注单ID',
  `order_detail_id` int(11) NOT NULL COMMENT '详细投注单ID',
  `bet_tgt_match_id` int(11) NOT NULL COMMENT '投注对象赛事ID',
  `match_ssn_id` int(11) NOT NULL COMMENT '赛事赛季ID',
  `bet_tgt_team_id` int(11) NOT NULL COMMENT '投注对象球队ID',
  `bet_type_id` int(11) NOT NULL COMMENT '投注类型ID',
  `return_rate` double NOT NULL COMMENT '返奖比率',
  `is_closed` tinyint(4) DEFAULT NULL COMMENT '是否结算完成',
  PRIMARY KEY (`order_id`,`order_detail_id`),
  KEY `fk_order_detail_bet_tgt_match_idx` (`bet_tgt_match_id`),
  KEY `fk_order_detail_match_team_idx` (`bet_tgt_team_id`),
  KEY `fk_order_detail_early_stage_bet_type_idx` (`bet_type_id`),
  KEY `fk_order_detail_match_season_idx` (`match_ssn_id`),
  CONSTRAINT `fk_order_detail_bet_tgt_match` FOREIGN KEY (`bet_tgt_match_id`) REFERENCES `t_f_m_bet_tgt_match` (`match_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_detail_early_stage_bet_type` FOREIGN KEY (`bet_type_id`) REFERENCES `t_m_early_stage_bet_type` (`bet_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_detail_match_season` FOREIGN KEY (`match_ssn_id`) REFERENCES `t_m_match_season` (`match_ssn_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_detail_match_team` FOREIGN KEY (`bet_tgt_team_id`) REFERENCES `t_f_m_match_team` (`team_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投注单详细情报'