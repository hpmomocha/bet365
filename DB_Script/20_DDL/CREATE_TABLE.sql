CREATE TABLE `bet365`.`t_f_m_global_match` (
  `id` INT NOT NULL COMMENT '赛事ID',
  `gbl_match_name` VARCHAR(45) NOT NULL COMMENT '全球赛事名称',
  PRIMARY KEY (`id`))
COMMENT = '全球赛事一览';

CREATE TABLE `bet365`.`t_m_early_stage_bet_type` (
  `bet_type_id` INT NOT NULL COMMENT '投注类型ID',
  `bet_type_name` VARCHAR(45) NOT NULL COMMENT '投注类型名称',
  PRIMARY KEY (`bet_type_id`))
COMMENT = '早期投注类型一览表';

CREATE TABLE `bet365`.`t_m_match_season` (
  `match_ssn_id` INT NOT NULL COMMENT '赛事赛季ID',
  `match_ssn_name` VARCHAR(45) NOT NULL COMMENT '赛事赛季名称',
  PRIMARY KEY (`match_ssn_id`),
  UNIQUE INDEX `match_ssn_name_UNIQUE` (`match_ssn_name` ASC))
COMMENT = '赛事赛季一览表';

CREATE TABLE `bet365`.`t_f_m_match_country` (
  `match_cy_id` INT NOT NULL COMMENT '赛事国家ID',
  `match_cy_name` VARCHAR(45) NOT NULL COMMENT '赛事国家名',
  `cy_belongs_in_gbl_match_id` INT NOT NULL COMMENT '国家所属全球赛事ID',
  `cy_show_order` INT NOT NULL COMMENT '国家显示顺序',
  PRIMARY KEY (`match_cy_id`),
  INDEX `fk_match_country_global_match_idx` (`cy_belongs_in_gbl_match_id` ASC),
  CONSTRAINT `fk_match_country_global_match`
    FOREIGN KEY (`cy_belongs_in_gbl_match_id`)
    REFERENCES `bet365`.`t_f_m_global_match` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = '足球赛事国家一览表';

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

CREATE TABLE `bet365`.`t_order` (
  `order_id` INT NOT NULL AUTO_INCREMENT COMMENT '投注单ID',
  `order_prpl` DOUBLE NULL COMMENT '本金',
  `bet_tgt_matches` VARCHAR(45) NULL COMMENT '投注对象比赛场次',
  `estm_bonus` DOUBLE NULL COMMENT '预计奖金',
  `is_win` TINYINT NULL COMMENT '是否中奖',
  `is_closed` TINYINT NULL COMMENT '是否结算完成',
  `is_closed_manually` TINYINT NULL COMMENT '是否手动完成结算',
  PRIMARY KEY (`order_id`));

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

