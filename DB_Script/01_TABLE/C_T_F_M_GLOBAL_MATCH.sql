CREATE TABLE `bet365`.`t_f_m_global_match` (
  `id` INT NOT NULL COMMENT '赛事ID',
  `gbl_match_name` VARCHAR(45) NOT NULL COMMENT '全球赛事名称',
  PRIMARY KEY (`id`))
COMMENT = '全球赛事一览';
