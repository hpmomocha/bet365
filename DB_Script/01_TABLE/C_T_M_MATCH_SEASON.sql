CREATE TABLE `t_m_match_season` (
  `match_ssn_id` int(11) NOT NULL COMMENT '赛事赛季ID',
  `match_ssn_name` varchar(45) NOT NULL COMMENT '赛事赛季名称',
  PRIMARY KEY (`match_ssn_id`),
  UNIQUE KEY `match_ssn_name_UNIQUE` (`match_ssn_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='赛事赛季一览表'