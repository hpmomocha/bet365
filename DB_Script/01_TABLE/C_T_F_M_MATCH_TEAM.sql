CREATE TABLE `bet365`.`t_f_m_match_team` (
  `team_id` INT NOT NULL COMMENT '球队ID',
  `match_id` INT NOT NULL COMMENT '赛事ID',
  `match_ssn_id` INT NOT NULL COMMENT '赛事赛季ID',
  `team_name` VARCHAR(45) NOT NULL COMMENT '球队名',
  `team_short_name` VARCHAR(45) NOT NULL COMMENT '球队名简称',
  PRIMARY KEY (`team_id`),
  INDEX `fk_match_team_bet_tgt_match_idx` (`match_id` ASC),
  INDEX `fk_match_team_match_session_idx` (`match_ssn_id` ASC),
  CONSTRAINT `fk_match_team_bet_tgt_match`
    FOREIGN KEY (`match_id`)
    REFERENCES `bet365`.`t_f_m_bet_tgt_match` (`match_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_match_team_match_session`
    FOREIGN KEY (`match_ssn_id`)
    REFERENCES `bet365`.`t_m_match_season` (`match_ssn_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = '赛季球队一览';
