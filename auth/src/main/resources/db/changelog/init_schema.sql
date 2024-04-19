--liquibase formatted sql

--changeset SwpInit:1

CREATE TABLE IF NOT EXISTS `status_notification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `timestamp` varchar(20) NOT NULL, 
  `licensecheck` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
