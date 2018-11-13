-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `salutis_centro` DEFAULT CHARACTER SET utf8 ;
USE `salutis_centro` ;

-- -----------------------------------------------------
-- Table `mydb`.`TIPO_USUARIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `salutis_centro`.`TIPO_USUARIO` (
  `id_tipo` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(20) NULL,
  PRIMARY KEY (`id_tipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ESPECIALIDAD`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `salutis_centro`.`ESPECIALIDAD` (
  `id_especialidad` INT NOT NULL AUTO_INCREMENT,
  `especialidad` VARCHAR(45) NULL,
  PRIMARY KEY (`id_especialidad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TERAPEUTA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `salutis_centro`.`TERAPEUTA` (
  `id_empleado` INT NOT NULL AUTO_INCREMENT,
  `dni` INT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `fecha_nacimiento` DATETIME NULL,
  `direccion` VARCHAR(100) NULL,
  `telefono` INT NULL,
  `email` VARCHAR(45) NULL,
  `tipo_usuario_id` INT NOT NULL,
  `especialidad_id` INT NOT NULL,
  PRIMARY KEY (`id_empleado`),
  INDEX `fk_terapeuta_tipo_usuario_idx` (`tipo_usuario_id` ASC) VISIBLE,
  INDEX `fk_terapeuta_especialidad_idx` (`especialidad_id` ASC) VISIBLE,
  CONSTRAINT `fk_terapeuta_tipo_usuario`
    FOREIGN KEY (`tipo_usuario_id`)
    REFERENCES `salutis_centro`.`TIPO_USUARIO` (`id_tipo`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_terapeuta_especialidad`
    FOREIGN KEY (`especialidad_id`)
    REFERENCES `salutis_centro`.`ESPECIALIDAD` (`id_especialidad`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PACIENTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `salutis_centro`.`PACIENTE` (
  `id_paciente` INT NOT NULL AUTO_INCREMENT,
  `dni` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATETIME NOT NULL,
  `edad` INT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `telefono` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `historial` VARCHAR(300) NULL,
  `historial_diario` VARCHAR(300) NULL,
  `motivo_consulta` VARCHAR(100) NOT NULL,
  `terapeuta_id` INT NOT NULL,
  PRIMARY KEY (`id_paciente`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `fk_paciente_terapeuta_idx` (`terapeuta_id` ASC) VISIBLE,
  CONSTRAINT `fk_paciente_terapeuta`
    FOREIGN KEY (`terapeuta_id`)
    REFERENCES `salutis_centro`.`TERAPEUTA` (`id_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DIAGNOSTICO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `salutis_centro`.`DIAGNOSTICO` (
  `id_diagnostico` INT NOT NULL AUTO_INCREMENT,
  `diagnostico` VARCHAR(100) NULL,
  `paciente_id` INT NOT NULL,
  PRIMARY KEY (`id_diagnostico`),
  INDEX `fk_diagnostico_paciente_idx` (`paciente_id` ASC) VISIBLE,
  CONSTRAINT `fk_diagnostico_paciente`
    FOREIGN KEY (`paciente_id`)
    REFERENCES `salutis_centro`.`PACIENTE` (`id_paciente`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CITA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `salutis_centro`.`CITA` (
  `id_cita` INT NOT NULL AUTO_INCREMENT,
  `fecha_cita` DATETIME NOT NULL,
  `paciente_id` INT NOT NULL,
  `terapeuta_id` INT NOT NULL,
  PRIMARY KEY (`id_cita`),
  INDEX `fk_cita_paciente` (`paciente_id` ASC) VISIBLE,
  INDEX `fk_cita_terapeuta_idx` (`terapeuta_id` ASC) VISIBLE,
  CONSTRAINT `fk_cita_paciente`
    FOREIGN KEY (`paciente_id`)
    REFERENCES `salutis_centro`.`PACIENTE` (`id_paciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cita_terapeuta`
    FOREIGN KEY (`terapeuta_id`)
    REFERENCES `salutis_centro`.`TERAPEUTA` (`id_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
