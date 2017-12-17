CREATE TABLE `bet365`.`t_m_early_stage_bet_type` (
  `bet_type_id` INT NOT NULL COMMENT '投注类型ID',
  `bet_type_name` VARCHAR(45) NOT NULL COMMENT '投注类型名称',
  PRIMARY KEY (`bet_type_id`))
COMMENT = '早期投注类型一览表';