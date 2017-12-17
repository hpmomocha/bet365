CREATE TABLE `bet365`.`t_f_m_bet_tgt_match` (
  `match_id` INT NOT NULL AUTO_INCREMENT COMMENT '赛事ID',
  `match_name` VARCHAR(45) NOT NULL COMMENT '赛事名称',
  `match_short_name` VARCHAR(45) NOT NULL COMMENT '赛事简称',
  `match_belongs_in_cy_id` INT NOT NULL COMMENT '赛事所属国家ID',
  `match_ssn_id` INT NOT NULL COMMENT '赛事赛季ID',
  PRIMARY KEY (`match_id`),
  INDEX `fk_bet_tgt_match_match_session_idx` (`match_ssn_id` ASC),
  INDEX `fk_bet_tgt_match_match_country_idx` (`match_belongs_in_cy_id` ASC),
  CONSTRAINT `fk_bet_tgt_match_match_session`
    FOREIGN KEY (`match_ssn_id`)
    REFERENCES `bet365`.`t_m_match_season` (`match_ssn_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bet_tgt_match_match_country`
    FOREIGN KEY (`match_belongs_in_cy_id`)
    REFERENCES `bet365`.`t_f_m_match_country` (`match_cy_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = '投注对象赛事一览表';
