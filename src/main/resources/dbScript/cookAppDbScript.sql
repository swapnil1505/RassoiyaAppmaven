// Added By Naimish -> In Role Table 
INSERT INTO `role` (`role_id`, `role_name`, `role_type`, `created_date`, `last_updated_date`, `created_by`, `modified_by`) VALUES (1, 'SUPER_ADMIN', 1, '2020-07-26 18:17:02', '2020-07-26 18:17:04', 'SYSTEM', 'SYSTEM');
INSERT INTO `role` (`role_id`, `role_name`, `role_type`, `created_date`, `last_updated_date`, `created_by`, `modified_by`) VALUES (2, 'ADMIN', 2, '2020-07-26 18:20:35', '2020-07-26 18:20:36', 'SYSTEM', 'SYSTEM');
INSERT INTO `role` (`role_id`, `role_name`, `role_type`, `created_date`, `last_updated_date`, `created_by`, `modified_by`) VALUES (3, 'COOK', 3, '2020-07-26 18:21:13', '2020-07-26 18:21:14', 'SYSTEM', 'SYSTEM');
INSERT INTO `role` (`role_id`, `role_name`, `role_type`, `created_date`, `last_updated_date`, `created_by`, `modified_by`) VALUES (4, 'CUSTOMER', 4, '2020-07-26 18:21:13', '2020-07-26 18:21:14', 'SYSTEM', 'SYSTEM');


ALTER TABLE `person`
	CHANGE COLUMN `middlename` `middlename` VARCHAR(45) NULL COLLATE AFTER `firstname`,
	CHANGE COLUMN `lastname` `lastname` VARCHAR(45) NULL COLLATE AFTER `middlename`,
	CHANGE COLUMN `email` `email` VARCHAR(45) NULL COLLATE AFTER `lastname`,
	CHANGE COLUMN `govt_id_type` `govt_id_type` VARCHAR(45) NULL COLLATE AFTER `mobile_no`,
	CHANGE COLUMN `govt_id_no` `govt_id_no` VARCHAR(45) NULL COLLATE AFTER `govt_id_type`;

ALTER TABLE `address`
	CHANGE COLUMN `address_line1` `address_line1` VARCHAR(100) NOT NULL COLLATE  AFTER `address_id`,
	CHANGE COLUMN `address_line2` `address_line2` VARCHAR(100) NULL COLLATE  AFTER `address_line1`,
	CHANGE COLUMN `district` `district` VARCHAR(45) NULL COLLATE  AFTER `address_line2`,
	CHANGE COLUMN `pincode` `pincode` VARCHAR(45) NOT NULL COLLATE  AFTER `district`,
	CHANGE COLUMN `address_type` `address_type` VARCHAR(45) NULL COLLATE  AFTER `pincode`,
	CHANGE COLUMN `geo_location` `geo_location` VARCHAR(45) NULL COLLATE  AFTER `address_type`;
	
ALTER TABLE `address`
	CHANGE COLUMN `city_id` `city_id` INT(11) NULL AFTER `geo_location`,
	CHANGE COLUMN `state_id` `state_id` INT(11) NULL AFTER `city_id`;
	
INSERT INTO `rasoiyya`.`country` (`country_id`, `name`, `created_date`, `last_updated_date`, `created_by`, `modified_by`) VALUES ('1', 'India', '2020-07-26 19:55:16', '2020-07-26 19:55:17', 'SYSTEM', 'SYSTEM');

INSERT INTO `rasoiyya`.`state` (`state_id`, `name`, `country_id_fk`, `created_date`, `last_updated_date`, `created_by`, `modified_by`) VALUES ('1', 'Odisha', '1', '2020-07-26 19:56:22', '2020-07-26 19:56:23', 'SYSTEM', 'SYSTEM');

INSERT INTO `rasoiyya`.`city` (`city_id`, `name`, `state_id`, `created_date`, `last_updated_date`, `created_by`, `modified_by`) VALUES ('1', 'BBSR', '1', '2020-07-26 19:57:20', '2020-07-26 19:57:21', 'SYSTEM', 'SYSTEM');
	
CREATE TABLE `user_address` (
	`user_address_id` INT(11) NOT NULL AUTO_INCREMENT,
	`user_login_id` INT(11) NULL DEFAULT NULL,
	`address_id` INT(11) NULL DEFAULT NULL,
	`is_current_address` VARCHAR(10) NULL DEFAULT NULL ,
	`created_by` VARCHAR(50) NULL DEFAULT NULL ,
	`modified_by` VARCHAR(50) NULL DEFAULT NULL ,
	`modified_date` DATETIME NULL DEFAULT NULL,
	`created_date` DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (`user_address_id`) USING BTREE,
	INDEX `USER_LOGIN_FK` (`user_login_id`) USING BTREE,
	INDEX `ADDRESS_FK` (`address_id`) USING BTREE,
	CONSTRAINT `USER_LOGIN_FK` FOREIGN KEY (`user_login_id`) REFERENCES `rasoiyya`.`user_login` (`user_id`) ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT `ADDRESS_FK` FOREIGN KEY (`address_id`) REFERENCES `rasoiyya`.`address` (`address_id`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
ENGINE=InnoDB
;

CREATE TABLE `rasoiyya_api_logs` (
	`api_logs_id` INT(11) NOT NULL AUTO_INCREMENT,
	`user_id` INT(11) NULL DEFAULT NULL,
	`service_name` VARCHAR(50) NULL DEFAULT NULL ,
	`requested_data` VARCHAR(2000) NULL DEFAULT NULL ,
	`responsed_data` VARCHAR(2000) NULL DEFAULT NULL ,
	`status` VARCHAR(10) NULL DEFAULT NULL ,
	`msguid` VARCHAR(100) NULL DEFAULT NULL ,
	`login_ip` VARCHAR(50) NULL DEFAULT NULL ,
	`request_time` DATETIME NULL DEFAULT NULL,
	`response_time` DATETIME NULL DEFAULT NULL,
	`created_by` VARCHAR(50) NULL DEFAULT NULL ,
	`modified_by` VARCHAR(50) NULL DEFAULT NULL ,
	PRIMARY KEY (`api_logs_id`) USING BTREE
)
ENGINE=InnoDB
;

// Added By Manish - OAuth 2.0  
create table if not exists  oauth_client_details (
  client_id varchar(255) not null,
  client_secret varchar(255) not null,
  web_server_redirect_uri varchar(2048) default null,
  scope varchar(255) default null,
  access_token_validity int(11) default null,
  refresh_token_validity int(11) default null,
  resource_ids varchar(1024) default null,
  authorized_grant_types varchar(1024) default null,
  authorities varchar(1024) default null,
  additional_information varchar(4096) default null,
  autoapprove varchar(255) default null,
  primary key (client_id)
) engine=innodb ;

INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, additional_information) VALUES ('mobile', '{bcrypt}$2a$10$gPhlXZfms0EpNHX0.HHptOhoFD1AoxSr/yUIdTqA8vtjeP4zi0DDu', 'http://localhost:8080/code', 'READ,WRITE', '3600', '10000', 'admin,cook,customer', 'authorization_code,password,refresh_token,implicit', '{}');