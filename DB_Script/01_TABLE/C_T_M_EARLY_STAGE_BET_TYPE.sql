CREATE TABLE `t_m_early_stage_bet_type` (
  `bet_type_id` int(11) NOT NULL COMMENT '投注类型ID',
  `bet_type_name` varchar(45) NOT NULL COMMENT '投注类型名称',
  `bet_type_category` int(11) NOT NULL COMMENT '投注类型分类',
  PRIMARY KEY (`bet_type_id`),
  KEY `fk_early_stage_bet_type_match_category_idx` (`bet_type_category`),
  CONSTRAINT `fk_early_stage_bet_type_match_category` FOREIGN KEY (`bet_type_category`) REFERENCES `t_m_match_category` (`match_category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='早期投注类型一览表'