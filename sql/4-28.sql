
-- 4-28 update sql
ALTER TABLE fieid ADD COLUMN img_url varchar(225) DEFAULT null comment '场地图片';
ALTER TABLE `order` ADD COLUMN start_time varchar(225) DEFAULT null comment '预约场地开始时间';
ALTER TABLE `order` ADD COLUMN end_time varchar(225) DEFAULT null comment '预约场地结束时间';

