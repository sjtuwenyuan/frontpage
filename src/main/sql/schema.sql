CREATE DATABASE scekill;

USE seckill;

CREATE TABLE seckill (
  `seckill_id`  BIGINT       NOT NULL AUTO_INCREMENT
  COMMENT '商品库存id',
  `name`        VARCHAR(120) NOT NULL
  COMMENT '商品名称',
  `number`      INT          NOT NULL
  COMMENT '库存数量',
  `start_time`  TIMESTAMP    NOT NULL
  COMMENT '秒杀开启时间',
  `end_time`    TIMESTAMP    NOT NULL
  COMMENT '秒杀结束时间',
  `create_time` TIMESTAMP    NOT NULL DEFAULT current_timestamp
  COMMENT '创建时间',
  PRIMARY KEY (seckill_id),
  KEY idx_start_time(start_time),
  KEY idx_end_time(end_time),
  KEY idx_create_time(create_time)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARACTER SET = utf8
  COMMENT = '秒杀库存表';


INSERT INTO
  seckill (name, number, start_time, end_time)
VALUES
  ("1000元秒杀iphone6", 100, '2016-8-20 00:00:00', '2016-08-21 00:00:00'),
  ("1000元秒杀小米4", 100, '2016-8-20 00:00:00', '2016-08-21 00:00:00'),
  ("1000元秒杀ipad2", 100, '2016-8-20 00:00:00', '2016-08-21 00:00:00'),
  ("1000元秒杀macbook", 100, '2016-8-20 00:00:00', '2016-08-21 00:00:00');


CREATE TABLE success_killed (
  `seckill_id`  BIGINT    NOT NULL
  COMMENT '商品库存id',
  `user_phone`  BIGINT    NOT NULL
  COMMENT '用户手机号',
  `status`      TINYINT   NOT NULL DEFAULT -1
  COMMENT '状态标识: -1 无效, 0 成功, 1 已付款,',
  `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp
  COMMENT '创建时间',

  PRIMARY KEY (seckill_id,user_phone),
  KEY idx_create_time(create_time)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COMMENT = '秒杀成功明细表';
