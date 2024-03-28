-- MySQL Script generated by MySQL Workbench
-- qua 20 mar 2024 21:55:53
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema banco_erp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema banco_erp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `banco_erp` ;
USE `banco_erp` ;

-- -----------------------------------------------------
-- Table `banco_erp`.`tb_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_erp`.`tb_usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_erp`.`tb_fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_erp`.`tb_fornecedor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(20) NOT NULL,
  `cnpj` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `status` TINYINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_erp`.`tb_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_erp`.`tb_produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `descricao` VARCHAR(200) NOT NULL,
  `criado_em` DATE NOT NULL,
  `atualizado_em` DATE NOT NULL,
  `quantidade_minima` DOUBLE NULL,
  `porcentagem_lucro` DOUBLE NULL,
  `perecivel` TINYINT NULL,
  `garantia` VARCHAR(45) NULL,
  `tipo_produto` CHAR(1) NULL,
  `status` TINYINT NULL,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_erp`.`tb_entrada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_erp`.`tb_entrada` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `quantidade` INT NOT NULL,
  `preco_custo` DOUBLE NOT NULL,
  `lote` VARCHAR(45) NOT NULL,
  `produto_id` INT NOT NULL,
  `validade` DATE NOT NULL,
  `fornecedor_id` INT NOT NULL,
  `status` TINYINT NULL,
  PRIMARY KEY (`id`, `fornecedor_id`, `produto_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fornecedor_id_idx` (`fornecedor_id` ASC) VISIBLE,
  INDEX `produto_id_idx` (`produto_id` ASC) VISIBLE,
  CONSTRAINT `fk_fornecedor_id_entrada`
    FOREIGN KEY (`fornecedor_id`)
    REFERENCES `banco_erp`.`tb_fornecedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_id_entrada`
    FOREIGN KEY (`produto_id`)
    REFERENCES `banco_erp`.`tb_produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_erp`.`tb_saida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_erp`.`tb_saida` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `produto_id` INT NOT NULL,
  `desconto` DOUBLE NOT NULL,
  `tipo_saida` VARCHAR(12) NOT NULL,
  `status` TINYINT NULL,
  PRIMARY KEY (`id`, `produto_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `produto_id_idx` (`produto_id` ASC) VISIBLE,
  CONSTRAINT `fk_produto_id_saida`
    FOREIGN KEY (`produto_id`)
    REFERENCES `banco_erp`.`tb_produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
