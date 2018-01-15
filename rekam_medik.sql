/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 10.1.28-MariaDB : Database - rekam_medik
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*CREATE DATABASE /*!32312 IF NOT EXISTS`rekam_medik` /*!40100 DEFAULT CHARACTER SET latin1 */;

/*USE `rekam_medik`;*/

/*Table structure for table `data_dokter` */

DROP TABLE IF EXISTS `data_dokter`;

CREATE TABLE `data_dokter` (
  `ID_Dokter` varchar(12) NOT NULL,
  `Nama_Dokter` varchar(20) DEFAULT NULL,
  `Alamat_Dokter` varchar(50) DEFAULT NULL,
  `Riwayat_Pendidikan` varchar(30) DEFAULT NULL,
  `Nomor_Telepon` varchar(14) DEFAULT NULL,
  `value_dokter` int(1) DEFAULT NULL,
  PRIMARY KEY (`ID_Dokter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `data_dokter` */

insert  into `data_dokter`(`ID_Dokter`,`Nama_Dokter`,`Alamat_Dokter`,`Riwayat_Pendidikan`,`Nomor_Telepon`,`value_dokter`) values 
('','','','','',NULL);

/*Table structure for table `data_obat` */

DROP TABLE IF EXISTS `data_obat`;

CREATE TABLE `data_obat` (
  `Kode_Obat` varchar(12) NOT NULL,
  `Nama_Obat` varchar(30) DEFAULT NULL,
  `Jenis` varchar(30) DEFAULT NULL,
  `value_obat` int(1) DEFAULT NULL,
  PRIMARY KEY (`Kode_Obat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `data_obat` */

insert  into `data_obat`(`Kode_Obat`,`Nama_Obat`,`Jenis`,`value_obat`) values 
('','',NULL,NULL);

/*Table structure for table `data_pasien` */

DROP TABLE IF EXISTS `data_pasien`;

CREATE TABLE `data_pasien` (
  `ID_Pasien` varchar(12) NOT NULL,
  `Nama_Pasien` varchar(30) DEFAULT NULL,
  `Umur` varchar(3) DEFAULT NULL,
  `Alamat Pasien` varchar(40) DEFAULT NULL,
  `Pekerjaan` varchar(15) DEFAULT NULL,
  `Jenis_Kelamin` varchar(10) DEFAULT NULL,
  `Nomor_Telepon` varchar(14) DEFAULT NULL,
  `Status_Perkawinan` varchar(12) DEFAULT NULL,
  `Nomor_Telepon_Kerabat` varchar(14) DEFAULT NULL,
  `value_pasien` int(1) DEFAULT NULL,
  PRIMARY KEY (`ID_Pasien`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `data_pasien` */

insert  into `data_pasien`(`ID_Pasien`,`Nama_Pasien`,`Umur`,`Alamat Pasien`,`Pekerjaan`,`Jenis_Kelamin`,`Nomor_Telepon`,`Status_Perkawinan`,`Nomor_Telepon_Kerabat`,`value_pasien`) values 
('','','','','','','','','',NULL);

/*Table structure for table `data_rekam_medis` */

DROP TABLE IF EXISTS `data_rekam_medis`;

CREATE TABLE `data_rekam_medis` (
  `Nomor_RM` varchar(12) NOT NULL,
  `Nomor_Pasien` varchar(12) DEFAULT NULL,
  `ID_Dokter` varchar(12) DEFAULT NULL,
  `Tanggal_Berobat` date DEFAULT NULL,
  `Keluhan` varchar(100) DEFAULT NULL,
  `Diagnosa` varchar(100) DEFAULT NULL,
  `Tindakan` varchar(50) DEFAULT NULL,
  `Kode_Obat` varchar(12) DEFAULT NULL,
  `ID_User` varchar(12) DEFAULT NULL,
  `value` int(1) DEFAULT NULL,
  PRIMARY KEY (`Nomor_RM`),
  KEY `Id Dokter` (`ID_Dokter`),
  KEY `Kode Obat` (`Kode_Obat`),
  KEY `Nomor Pasien` (`Nomor_Pasien`),
  KEY `ID User` (`ID_User`),
  CONSTRAINT `data_rekam_medis_ibfk_1` FOREIGN KEY (`Id_Dokter`) REFERENCES `data_dokter` (`ID_Dokter`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `data_rekam_medis_ibfk_2` FOREIGN KEY (`Kode_Obat`) REFERENCES `data_obat` (`Kode_Obat`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `data_rekam_medis_ibfk_3` FOREIGN KEY (`Nomor_Pasien`) REFERENCES `data_pasien` (`ID_Pasien`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `data_rekam_medis_ibfk_4` FOREIGN KEY (`ID_User`) REFERENCES `user` (`ID_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `data_rekam_medis` */

insert  into `data_rekam_medis`(`Nomor_RM`,`Nomor_Pasien`,`ID_Dokter`,`Tanggal_Berobat`,`Keluhan`,`Diagnosa`,`Tindakan`,`Kode_Obat`,`ID_User`,`value`) values 
('','','','0000-00-00','','','','',NULL,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `ID_user` varchar(11) NOT NULL,
  `Nama_User` varchar(20) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`ID_user`,`Nama_User`,`Password`) values 
('','','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
