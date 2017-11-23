

USE `equipe2` ;

-- -----------------------------------------------------
-- Table `mydb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `equipe2`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NULL,
  `rg` VARCHAR(20) NULL,
  `cpf` VARCHAR(20) NULL,
  `telefone` VARCHAR(20) NULL,
  `celular` VARCHAR(20) NULL,
  `endereco` VARCHAR(70) NULL,
  `bairro` VARCHAR(50) NULL,
  `cidade` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`filme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `equipe2`.`filme` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(90) NULL,
  `genero` VARCHAR(40) NULL,
  `ano` VARCHAR(6) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`locacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `equipe2`.`locacao` (
  `pedido` INT NOT NULL AUTO_INCREMENT,
  `cliente_id` INT NOT NULL,
  `filme_id` INT NOT NULL,
  `data_locacao` VARCHAR(12) NULL,
  `data_entrega` VARCHAR(12) NULL,
  PRIMARY KEY (`pedido`),
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


