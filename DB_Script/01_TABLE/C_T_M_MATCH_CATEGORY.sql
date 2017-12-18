CREATE TABLE `t_m_match_category` (
  `match_category_id` int(11) NOT NULL COMMENT '赛事分类ID',
  `match_category_name` varchar(45) NOT NULL COMMENT '赛事分类名称',
  PRIMARY KEY (`match_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='赛事分类一览'