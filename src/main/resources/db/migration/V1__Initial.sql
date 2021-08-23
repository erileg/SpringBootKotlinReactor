CREATE TABLE IF NOT EXISTS `thing` (
  `key` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
  `value` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `reactive`.`thing` (`key`, `value`) VALUES ('key1', 'value1 💩');
INSERT INTO `reactive`.`thing` (`key`, `value`) VALUES ('key2', 'value2 👻');
INSERT INTO `reactive`.`thing` (`key`, `value`) VALUES ('key3', 'value3 👀');
