CREATE DATABASE IF NOT EXISTS `mydb`;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `mydb`.`proyek`, `mydb`.`lokasi`, `mydb`.`proyek_lokasi`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE IF NOT EXISTS `mydb`.`proyek` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `nama_proyek` VARCHAR(255) NULL DEFAULT '-',
    `client` VARCHAR(255) NULL DEFAULT '-',
    `tgl_mulai` DATETIME(6) NOT NULL,
    `tgl_selesai` DATETIME(6) NOT NULL,
    `pimpinan_proyek` VARCHAR(255) NULL DEFAULT '-',
    `keterangan` TEXT NULL DEFAULT '-',
    `creatad_at` TIMESTAMP(6) NULL,
    `update_at` TIMESTAMP(6) NULL,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB;






CREATE TABLE IF NOT EXISTS `mydb`.`lokasi` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nama_lokasi` VARCHAR(255) NULL,
  `negara` VARCHAR(255) NULL,
  `provinsi` VARCHAR(255) NULL,
  `kota` VARCHAR(255) NULL,
  `created_at` TIMESTAMP(6) NULL,
  `update_at` TIMESTAMP(6) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `mydb`.`proyek_lokasi` (
  `proyek_id` INT NOT NULL,
  `lokasi_id` INT NOT NULL,
  INDEX `pronyek_id_foreign_key_idx` (`proyek_id` ASC) ,
  INDEX `lokasi_id_foreign_key_idx` (`lokasi_id` ASC),
  CONSTRAINT `pronyek_id_foreign_key`
    FOREIGN KEY (`proyek_id`)
    REFERENCES `mydb`.`proyek` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `lokasi_id_foreign_key`
    FOREIGN KEY (`lokasi_id`)
    REFERENCES `mydb`.`lokasi` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

