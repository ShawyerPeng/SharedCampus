DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `user_id` INT(11) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,  # 用户ID，主键
    `user_name` VARCHAR(32) UNIQUE NOT NULL DEFAULT '',     # 用户名
    `user_pass` VARCHAR(32) NOT NULL DEFAULT '',            # 密码
    `realname` VARCHAR(16) DEFAULT '',                      # 真实姓名
    `gender` TINYINT(4) DEFAULT 0,                          # 性别（0：未知，1：男，2：女）
    `phone` VARCHAR(11) DEFAULT '',                         # 手机号码
    `email` VARCHAR(100) DEFAULT '',                        # 邮箱地址
    `alipay` VARCHAR(100) DEFAULT '',                       # 支付宝账号
    `iconimg` VARCHAR(120) DEFAULT '',                      # 头像url地址
    `info` VARCHAR(255) DEFAULT '',                         # 个人简介
    `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,                                # 账号创建时间
    `last_login` TIMESTAMP NOT NULL DEFAULT '1970-01-02 00:00:00' ON UPDATE CURRENT_TIMESTAMP,  # 账号最近登录时间
    `honesty` INT(4) NOT NULL DEFAULT 100,                  # 诚信值
    `balance` DOUBLE DEFAULT 0                              # 账户余额
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
    `task_id` INT(11) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,   # 任务ID，主键
    `publisher_id` INT(11) UNSIGNED NOT NULL,                       # 任务发布者
    `title` VARCHAR(32) NOT NULL DEFAULT '',                        # 任务标题
    `description` VARCHAR(255) NOT NULL DEFAULT '',                 # 任务描述
    `category` MEDIUMINT(8) NOT NULL DEFAULT 0,                     # 任务分类
    `price` DOUBLE NOT NULL DEFAULT 0.0,                            # 任务赏金
    `counts` MEDIUMINT(8) NOT NULL DEFAULT 0,                       # 任务人数
    `starttime` TIMESTAMP NOT NULL DEFAULT '1970-01-02 00:00:00',   # 任务起始时间
    `endtime` TIMESTAMP NOT NULL DEFAULT '1970-01-02 00:00:00',     # 任务终止时间
    `pic_url` VARCHAR(127) DEFAULT '',                              # 任务图片地址
    `pubtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,         # 任务发布时间
    `is_finished` TINYINT(4) NOT NULL DEFAULT 0,                    # 0：未完成，1：已完成
    CONSTRAINT `FK_PID` FOREIGN KEY (`publisher_id`) REFERENCES `user` (`user_id`)  ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='任务表';

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
    `comment_id` INT(11) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `task_id` INT(11) UNSIGNED NOT NULL,                            # 任务ID
    `from_uid` INT(11) UNSIGNED NOT NULL,                           # 留言人
    `to_uid` INT(11) UNSIGNED DEFAULT NULL,                         # 回复谁的留言（无回复则NULL）
    `content` VARCHAR(255) NOT NULL,                                # 留言内容
    `send_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP        # 留言时间
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='任务留言表';



DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
    `order_id` INT(11) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,   # 任务订单ID，主键
    `tid` INT(11) UNSIGNED DEFAULT NULL,                 # 任务ID
    `receiver_id` INT(11) UNSIGNED DEFAULT NULL,         # 任务接受者ID
    `price` DOUBLE DEFAULT NULL,                # 订单金额
    `task_status` TINYINT(4) DEFAULT NULL,      # 任务订单状态（订单生成、进行中、已完成、已取消、有纠纷）
    `comment_status` SMALLINT(2) DEFAULT NULL,  # 评价状态（买/卖家未评价1、买/卖家已评价2，如12表示买家未评价、卖家已评价）
    `comment_buyer` VARCHAR(255) DEFAULT NULL,  # 买家评论（任务发布者）
    `comment_seller` VARCHAR(255) DEFAULT NULL, # 卖家评论（任务接受者）
    `rate_buyer` TINYINT(4) DEFAULT 5,          # 买家评分（任务发布者）
    `rate_seller` TINYINT(4) DEFAULT 5,         # 卖家评分（任务接受者）
    CONSTRAINT `FK_ID` FOREIGN KEY (`tid`) REFERENCES `task` (`task_id`),
    CONSTRAINT `FK_RECEIVER` FOREIGN KEY (`receiver_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='任务订单表';



DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
    `message_id` INT(11) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `sender_id` INT(11) UNSIGNED NOT NULL,
    `receiver_id` INT(11) UNSIGNED NOT NULL,
    `content` VARCHAR(255) NOT NULL,
    `send_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP         # 私信消息发送时间
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='私信消息表';

DROP TABLE IF EXISTS `sysmessage`;
CREATE TABLE `sysmessage` (
    `sysmessage_id` INT(11) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `receiver_id` INT(11) UNSIGNED NOT NULL,
    `content` VARCHAR(255) NOT NULL,
    `send_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP         # 系统消息发送时间
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统消息表';

DROP TABLE IF EXISTS `taskmessage`;
CREATE TABLE `taskmessage` (
    `taskmessage_id` INT(11) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `receiver_id` INT(11) UNSIGNED NOT NULL,
    `content` VARCHAR(255) NOT NULL,
    `send_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP         # 任务消息发送时间
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='任务消息表';



DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
    `image_id` INT(11) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,     # 图片ID，主键
    `filename` VARCHAR(255) NOT NULL DEFAULT '',                # 图片名
    `pic_url` VARCHAR(255) NOT NULL DEFAULT '',                 # 图片存储相对地址
    `description` VARCHAR(255) DEFAULT ''                       # 图片描述
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='图片表';