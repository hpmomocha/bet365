CREATE TABLE `bet365`.`t_order_detail` (
  `order_id` INT NOT NULL COMMENT '投注单ID',
  `order_detail_id` INT NOT NULL COMMENT '详细投注单ID',
  `bet_tgt_match_id` INT NOT NULL COMMENT '投注对象赛事ID',
  `bet_tgt_team_id` INT NOT NULL COMMENT '投注对象球队ID',
  `bet_type_id` INT NOT NULL COMMENT '投注类型ID',
  `return_rate` DOUBLE NOT NULL COMMENT '返奖比率',
  `is_closed` TINYINT NULL COMMENT '是否结算完成',
  PRIMARY KEY (`order_id`, `order_detail_id`),
  INDEX `fk_order_detail_bet_tgt_match_idx` (`bet_tgt_match_id` ASC),
  INDEX `fk_order_detail_match_team_idx` (`bet_tgt_team_id` ASC),
  INDEX `fk_order_detail_early_stage_bet_type_idx` (`bet_type_id` ASC),
  CONSTRAINT `fk_order_detail_bet_tgt_match`
    FOREIGN KEY (`bet_tgt_match_id`)
    REFERENCES `bet365`.`t_f_m_bet_tgt_match` (`match_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_detail_match_team`
    FOREIGN KEY (`bet_tgt_team_id`)
    REFERENCES `bet365`.`t_f_m_match_team` (`team_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_detail_early_stage_bet_type`
    FOREIGN KEY (`bet_type_id`)
    REFERENCES `bet365`.`t_m_early_stage_bet_type` (`bet_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = '投注单详细情报';
