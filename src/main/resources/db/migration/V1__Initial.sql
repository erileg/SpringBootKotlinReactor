CREATE TABLE IF NOT EXISTS `post` (
  `id` MEDIUMINT NOT NULL AUTO_INCREMENT,
  `version` MEDIUMINT NOT NULL,
  `content` varchar(4096) NULL,
  `user_name` varchar(255) NULL,
  `timestamp` timestamp NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
