CREATE SCHEMA IF NOT EXISTS `equipe2` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `equipe2` ;


CREATE TABLE IF NOT EXISTS `equipe2`.`cliente` (
  `id` INT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NULL,
  `rg` VARCHAR(20) NULL,
  `cpf` VARCHAR(20) NULL,
  `email` VARCHAR(60) NULL,
  `senha` VARCHAR(15) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `equipe2`.`filme` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(90) NULL,
  `genero` VARCHAR(40) NULL,
  `ano` VARCHAR(6) NULL,
  `estrelando` VARCHAR(120) NULL,
  `classificacao` VARCHAR(6) NULL,
  `direcao` VARCHAR(100) NULL,
  `duracao` VARCHAR(15) NULL,
  `sinopse` VARCHAR(300) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `equipe2`.`locacao` (
  `id` INT NOT NULL,
  `cliente_id` INT NOT NULL,
  `filme_id` INT NOT NULL,
  `data_locacao` VARCHAR(12) NULL,
  `data_entrega` VARCHAR(12) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Locacao_Cliente_idx` (`cliente_id` ASC),
  INDEX `fk_Locacao_Filme1_idx` (`filme_id` ASC),
  CONSTRAINT `fk_Locacao_Cliente`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `equipe2`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Locacao_Filme1`
    FOREIGN KEY (`filme_id`)
    REFERENCES `equipe2`.`filme` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `equipe2`.`reserva` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cliente_id` INT NOT NULL,
  `filme_id` INT NOT NULL,
  `data` VARCHAR(10) NULL,
  `reservacol` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_reserva_cliente1_idx` (`cliente_id` ASC),
  INDEX `fk_reserva_filme1_idx` (`filme_id` ASC),
  CONSTRAINT `fk_reserva_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `equipe2`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_filme1`
    FOREIGN KEY (`filme_id`)
    REFERENCES `equipe2`.`filme` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


