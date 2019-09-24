CREATE DATABASE IF NOT EXISTS `autotest_platform_mockserver`;

USE autotest_platform_mockserver;

CREATE TABLE IF NOT EXISTS `sys_role` (
    `id` int(8) NOT NULL AUTO_INCREMENT,
    `role_name` varchar(100) NOT NULL,
    `role_cn_name` varchar(100) NOT NULL DEFAULT 'GUEST',
    `role_type` varchar(1000) DEFAULT NULL,
    `comments` varchar(200) DEFAULT NULL,
    `create_date` timestamp DEFAULT CURRENT_TIMESTAMP(),
    `update_date` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted` varchar(11) NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARSET = utf8;

