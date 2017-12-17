CREATE TABLE `t_m_early_stage_bet_type` (
  `bet_type_id` int(11) NOT NULL COMMENT '投注类型ID',
  `bet_type_name` varchar(45) NOT NULL COMMENT '投注类型名称',
  PRIMARY KEY (`bet_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='早期投注类型一览表'