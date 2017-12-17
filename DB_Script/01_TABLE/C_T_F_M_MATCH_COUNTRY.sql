CREATE TABLE `t_f_m_match_country` (
  `match_cy_id` int(11) NOT NULL COMMENT '赛事国家ID',
  `match_cy_name` varchar(45) NOT NULL COMMENT '赛事国家名',
  `cy_belongs_in_gbl_match_id` int(11) NOT NULL COMMENT '国家所属全球赛事ID',
  `cy_show_order` int(11) NOT NULL COMMENT '国家显示顺序',
  PRIMARY KEY (`match_cy_id`),
  KEY `fk_match_country_global_match_idx` (`cy_belongs_in_gbl_match_id`),
  CONSTRAINT `fk_match_country_global_match` FOREIGN KEY (`cy_belongs_in_gbl_match_id`) REFERENCES `t_f_m_global_match` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='足球赛事国家一览表'