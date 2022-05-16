-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema jojodb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `jojodb` ;

-- -----------------------------------------------------
-- Schema jojodb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jojodb` DEFAULT CHARACTER SET utf8 ;
USE `jojodb` ;

-- -----------------------------------------------------
-- Table `jojo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jojo` ;

CREATE TABLE IF NOT EXISTS `jojo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `age` INT NULL,
  `height` VARCHAR(45) NULL,
  `weight` VARCHAR(45) NULL,
  `stand` VARCHAR(45) NULL,
  `image` VARCHAR(5000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS jojo@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'jojo'@'localhost' IDENTIFIED BY 'jojo';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'jojo'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `jojo`
-- -----------------------------------------------------
START TRANSACTION;
USE `jojodb`;
INSERT INTO `jojo` (`id`, `first_name`, `last_name`, `age`, `height`, `weight`, `stand`, `image`) VALUES (1, 'Jonathan', 'Joestar', 20, '6\'5', '227', 'Hamon', 'https://64.media.tumblr.com/092dad5f9020582055bf77b255617501/tumblr_nknppk7ql41sh11j9o1_500.png');
INSERT INTO `jojo` (`id`, `first_name`, `last_name`, `age`, `height`, `weight`, `stand`, `image`) VALUES (2, 'Joesph', 'Joestar', 18, '6\'5', '214', 'Hamon/Hermit Purple', 'https://www.kindpng.com/picc/m/116-1168519_transparent-jojo-menacing-png-joseph-joestar-battle-tendency.png');
INSERT INTO `jojo` (`id`, `first_name`, `last_name`, `age`, `height`, `weight`, `stand`, `image`) VALUES (3, 'Jotaro', 'Kujo', 17, '6\'4', '220', 'Star Platinum', 'https://static.jojowiki.com/images/6/69/latest/20201130220440/Jotaro_SC_Infobox_Manga.png');
INSERT INTO `jojo` (`id`, `first_name`, `last_name`, `age`, `height`, `weight`, `stand`, `image`) VALUES (4, 'Giorno', 'Giovanna', 15, '5\'8', '180', 'Gold Wind', 'https://static.jojowiki.com/images/thumb/4/4a/latest/20210422070411/Giorno_Giovanna_Infobox_Anime.png/400px-Giorno_Giovanna_Infobox_Anime.png');

COMMIT;

