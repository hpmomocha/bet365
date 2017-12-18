CREATE TABLE `t_m_global_match` (
  `id` int(11) NOT NULL COMMENT '赛事ID',
  `gbl_match_name` varchar(45) NOT NULL COMMENT '全球赛事名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='全球赛事一览'