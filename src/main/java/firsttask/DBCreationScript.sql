DROP SCHEMA IF EXISTS `homework` ;
CREATE SCHEMA IF NOT EXISTS `homework` DEFAULT CHARACTER SET utf8 ;
USE `homework` ;

CREATE TABLE IF NOT EXISTS `Orders` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `Description` VARCHAR(100) NOT NULL,
  `Number` BIGINT NOT NULL,
  `End_date` VARCHAR(100), -- sorry but i could'n fiend DATE with such syntax as "12-MAR-2018"
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

DROP TABLE IF EXISTS `Order_lines` ;

CREATE TABLE IF NOT EXISTS `Order_lines` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `Number` BIGINT NOT NULL,
  `Item_ID` BIGINT NOT NULL,
  `Order_ID` BIGINT NOT NULL,
  `Quantity` BIGINT NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

DROP TABLE IF EXISTS `Items` ;

CREATE TABLE IF NOT EXISTS `Items` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `Description` VARCHAR(100) NOT NULL,
  `Weight` DOUBLE NOT NULL,
  `Price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`)
)

ENGINE = InnoDB
AUTO_INCREMENT = 1002;

INSERT INTO `homework`.`orders` (`id`, `Description`, `Number`, `End_date`) VALUES ('1', 'My first order ', '99998', '12-MAR-2018');
INSERT INTO `homework`.`orders` (`id`, `Description`, `Number`, `End_date`) VALUES ('2', 'My second order ', '99999', null);

INSERT INTO `homework`.`Order_lines` (`id`, `Number`, `Item_ID`, `Order_ID`, `Quantity`) VALUES ('1', '1', '2', '2', '1');
INSERT INTO `homework`.`Order_lines` (`id`, `Number`, `Item_ID`, `Order_ID`, `Quantity`) VALUES ('2', '2', '1', '2', '2');
INSERT INTO `homework`.`Order_lines` (`id`, `Number`, `Item_ID`, `Order_ID`, `Quantity`) VALUES ('3', '1', '1', '1', '1');
INSERT INTO `homework`.`Order_lines` (`id`, `Number`, `Item_ID`, `Order_ID`, `Quantity`) VALUES ('4', '2', '3', '1', '1');
INSERT INTO `homework`.`Order_lines` (`id`, `Number`, `Item_ID`, `Order_ID`, `Quantity`) VALUES ('5', '3', '2', '1', '2');

INSERT INTO `homework`.`items` (`id`, `Description`, `Weight`, `Price`) VALUES ('1', 'Mouse', '200', '10');
INSERT INTO `homework`.`items` (`id`, `Description`, `Weight`, `Price`) VALUES ('2', 'Keyboard', '500', '2');
INSERT INTO `homework`.`items` (`id`, `Description`, `Weight`, `Price`) VALUES ('3', 'Mobile phone', '300', '90');
