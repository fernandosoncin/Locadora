

USE `equipe2` ;

-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `equipe2`.`Cliente` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(60) NULL,
  `Rg` VARCHAR(20) NULL,
  `Cpf` VARCHAR(20) NULL,
  `Telefone` VARCHAR(20) NULL,
  `Celular` VARCHAR(20) NULL,
  `Endereco` VARCHAR(70) NULL,
  `Bairro` VARCHAR(50) NULL,
  `Cidade` VARCHAR(45) NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Filme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `equipe2`.`Filme` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Titulo` VARCHAR(90) NULL,
  `Genero` VARCHAR(40) NULL,
  `Ano` VARCHAR(6) NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Locacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `equipe2`.`Locacao` (
  `Pedido` INT NOT NULL AUTO_INCREMENT,
  `Cliente_Id` INT NOT NULL,
  `Filme_Id` INT NOT NULL,
  `Data_Locacao` VARCHAR(12) NULL,
  `Data_Entrega` VARCHAR(12) NULL,
  PRIMARY KEY (`Pedido`),
  INDEX `fk_Locacao_Cliente_idx` (`Cliente_Id` ASC),
  INDEX `fk_Locacao_Filme1_idx` (`Filme_Id` ASC),
  CONSTRAINT `fk_Locacao_Cliente`
    FOREIGN KEY (`Cliente_Id`)
    REFERENCES `equipe2`.`Cliente` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Locacao_Filme1`
    FOREIGN KEY (`Filme_Id`)
    REFERENCES `equipe2`.`Filme` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
