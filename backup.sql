-- MariaDB dump 10.17  Distrib 10.4.11-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: testdb
-- ------------------------------------------------------
-- Server version	10.4.11-MariaDB-1:10.4.11+maria~bionic-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `GiaoVien`
--

DROP TABLE IF EXISTS `GiaoVien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GiaoVien` (
  `MaGV` varchar(45) NOT NULL,
  `HoGV` varchar(45) DEFAULT NULL,
  `TenGV` varchar(45) DEFAULT NULL,
  `DonVi` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MaGV`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GiaoVien`
--

LOCK TABLES `GiaoVien` WRITE;
/*!40000 ALTER TABLE `GiaoVien` DISABLE KEYS */;
INSERT INTO `GiaoVien` VALUES ('GV1','Le','Manh','CNTT'),('GV2','Dao','VU','CO KHI'),('GV3','Dao','Huy','Tu Dong Hoa'),('GV4','nguyen','dung moi','cntt moi');
/*!40000 ALTER TABLE `GiaoVien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Lop`
--

DROP TABLE IF EXISTS `Lop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Lop` (
  `MaLop` varchar(45) NOT NULL,
  `MaMH` varchar(45) DEFAULT NULL,
  `NamHoc` int(11) DEFAULT NULL,
  `HocKy` int(11) DEFAULT NULL,
  `MaGV` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MaLop`),
  KEY `MaMH_idx` (`MaMH`),
  KEY `MaGV_idx` (`MaGV`),
  CONSTRAINT `MaGV` FOREIGN KEY (`MaGV`) REFERENCES `GiaoVien` (`MaGV`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `MaMH` FOREIGN KEY (`MaMH`) REFERENCES `MonHoc` (`MaMH`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Lop`
--

LOCK TABLES `Lop` WRITE;
/*!40000 ALTER TABLE `Lop` DISABLE KEYS */;
INSERT INTO `Lop` VALUES ('Lop1','1',2016,2,'GV1'),('Lop2','2',2017,1,'GV2'),('Lop3','3',2008,2,'GV3');
/*!40000 ALTER TABLE `Lop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MonHoc`
--

DROP TABLE IF EXISTS `MonHoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MonHoc` (
  `MaMH` varchar(45) NOT NULL,
  `TenMH` varchar(45) DEFAULT NULL,
  `SoTC` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaMH`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MonHoc`
--

LOCK TABLES `MonHoc` WRITE;
/*!40000 ALTER TABLE `MonHoc` DISABLE KEYS */;
INSERT INTO `MonHoc` VALUES ('1','mon hoc moi',5),('2','mon hoc 2',2),('3','mon hoc 3',4),('4','mon hoc 4',3),('5','Mon hoc 5 moi',4),('MH4','ly moi',6);
/*!40000 ALTER TABLE `MonHoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SinhVien`
--

DROP TABLE IF EXISTS `SinhVien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SinhVien` (
  `MaSV` varchar(45) NOT NULL,
  `HoSV` varchar(45) DEFAULT NULL,
  `TenSV` varchar(45) DEFAULT NULL,
  `NgaySinh` date DEFAULT NULL,
  `NoiSinh` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MaSV`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SinhVien`
--

LOCK TABLES `SinhVien` WRITE;
/*!40000 ALTER TABLE `SinhVien` DISABLE KEYS */;
INSERT INTO `SinhVien` VALUES ('SV1','Nguyen','Tung moi','1999-03-15','Hai Phong'),('SV2','Le','Manh','1999-05-11','thanh hoa'),('SV3','Hoang','Anh','1999-09-30','Binh Dinh'),('SV4','nguyen','dung moi','1999-06-30','hai phong');
/*!40000 ALTER TABLE `SinhVien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SinhVienLop`
--

DROP TABLE IF EXISTS `SinhVienLop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SinhVienLop` (
  `MaLop` varchar(45) DEFAULT NULL,
  `MaSV` varchar(45) DEFAULT NULL,
  `Diem` float DEFAULT NULL,
  KEY `MaLop_idx` (`MaLop`),
  KEY `MaSV_idx` (`MaSV`),
  CONSTRAINT `MaLop` FOREIGN KEY (`MaLop`) REFERENCES `Lop` (`MaLop`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `MaSV` FOREIGN KEY (`MaSV`) REFERENCES `SinhVien` (`MaSV`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SinhVienLop`
--

LOCK TABLES `SinhVienLop` WRITE;
/*!40000 ALTER TABLE `SinhVienLop` DISABLE KEYS */;
/*!40000 ALTER TABLE `SinhVienLop` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-05 17:12:01
