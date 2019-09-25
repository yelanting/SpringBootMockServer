CREATE DATABASE IF NOT EXISTS `autotest_platform_mockserver`;
USE autotest_platform_mockserver;
DROP TABLE IF EXISTS `tb_global_param_config`;
CREATE TABLE IF NOT EXISTS `tb_global_param_config`
(
   `id` int (8) NOT NULL AUTO_INCREMENT,
   `param_key` varchar (100) NOT NULL,
   `param_value` varchar (100) DEFAULT NULL,
   `param_comment` varchar (100) DEFAULT NULL,
   `create_date` timestamp DEFAULT CURRENT_TIMESTAMP (),
   `update_date` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `deleted` varchar (11) NOT NULL DEFAULT '0' COMMENT '是否删除',
   `comments` varchar (200) DEFAULT NULL COMMENT '备注',
   PRIMARY KEY (`id`)
)
ENGINE = InnoDB CHARSET = utf8;
DROP TABLE IF EXISTS `tb_application_info`;
CREATE TABLE IF NOT EXISTS `tb_application_info`
(
   `id` int (8) NOT NULL AUTO_INCREMENT,
   `app_name` varchar (100) NOT NULL COMMENT 'app名称',
   `app_ename` varchar (100) DEFAULT NULL COMMENT 'app英文名称',
   `app_code` varchar (100) DEFAULT NULL COMMENT 'app编码',
   `base_url` varchar (100) DEFAULT NULL COMMENT '基础Url',
   `create_date` timestamp DEFAULT CURRENT_TIMESTAMP (),
   `update_date` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `create_user` VARCHAR (100) DEFAULT '' COMMENT '创建人',
   `update_user` VARCHAR (100) DEFAULT '' COMMENT '修改人',
   `deleted` varchar (11) NOT NULL DEFAULT '0' COMMENT '是否删除',
   `description` varchar (200) DEFAULT NULL COMMENT '备注',
   `default_app` TINYINT (8) DEFAULT NULL COMMENT '是否默认应用',
   PRIMARY KEY (`id`)
)
ENGINE = InnoDB CHARSET = utf8;
DROP TABLE IF EXISTS `tb_mock_api`;
CREATE TABLE IF NOT EXISTS `tb_mock_api`
(
   `id` int (8) NOT NULL AUTO_INCREMENT,
   `application_id` int (8) NOT NULL COMMENT '关联应用ID',
   `api_name` varchar (100) NOT NULL COMMENT 'api名称',
   `api_path` varchar (100) DEFAULT NULL COMMENT 'api路径',
   `api_params` varchar (20000) DEFAULT NULL COMMENT '请求参数',
   `request_method_type` varchar (100) DEFAULT NULL COMMENT '请求类型',
   `request_mime_type` varchar (100) DEFAULT NULL COMMENT '请求Mime类型',
   `expected_response` varchar (20000) DEFAULT NULL COMMENT '预期返回值',
   `create_date` timestamp DEFAULT CURRENT_TIMESTAMP (),
   `update_date` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `create_user` VARCHAR (100) DEFAULT '' COMMENT '创建人',
   `update_user` VARCHAR (100) DEFAULT '' COMMENT '修改人',
   `deleted` varchar (11) NOT NULL DEFAULT '0' COMMENT '是否删除',
   `description` varchar (200) DEFAULT NULL COMMENT '备注',
   PRIMARY KEY (`id`)
)
ENGINE = InnoDB CHARSET = utf8;