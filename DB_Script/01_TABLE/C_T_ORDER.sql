CREATE TABLE `bet365`.`t_order` (
  `order_id` INT NOT NULL AUTO_INCREMENT COMMENT '投注单ID',
  `order_prpl` DOUBLE NULL COMMENT '本金',
  `bet_tgt_matches` VARCHAR(45) NULL COMMENT '投注对象比赛场次',
  `estm_bonus` DOUBLE NULL COMMENT '预计奖金',
  `is_win` TINYINT NULL COMMENT '是否中奖',
  `is_closed` TINYINT NULL COMMENT '是否结算完成',
  `is_closed_manually` TINYINT NULL COMMENT '是否手动完成结算',
  PRIMARY KEY (`order_id`));