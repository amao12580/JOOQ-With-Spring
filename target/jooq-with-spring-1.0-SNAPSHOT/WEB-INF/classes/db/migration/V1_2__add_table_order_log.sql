CREATE TABLE `order_log` (
`order_id`  int(11) NOT NULL ,
`status`  tinyint(2) NOT NULL ,
`change_time`  datetime NULL COMMENT '变化时间' ,
PRIMARY KEY (`order_id`)
)COMMENT='订单状态变化表';
