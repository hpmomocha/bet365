CREATE TABLE `bet365`.`t_m_match_season` (
  `match_ssn_id` INT NOT NULL COMMENT '赛事赛季ID',
  `match_ssn_name` VARCHAR(45) NOT NULL COMMENT '赛事赛季名称',
  PRIMARY KEY (`match_ssn_id`),
  UNIQUE INDEX `match_ssn_name_UNIQUE` (`match_ssn_name` ASC))
COMMENT = '赛事赛季一览表';