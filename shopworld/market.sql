-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: market
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `addressId` int NOT NULL AUTO_INCREMENT,
  `buildingName` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,
  `pincode` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `streetNo` varchar(50) NOT NULL,
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'Build','kalcutta','India','400057','asam','S01'),(2,'building','Mumbai','India','400072','Maharashtra','S01'),(3,'Building1','London','America','525000','USA','S023'),(4,'sdf','mumbai','India','40072','maha','sdfsd');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cartId` int NOT NULL AUTO_INCREMENT,
  `customer_customerId` int DEFAULT NULL,
  PRIMARY KEY (`cartId`),
  UNIQUE KEY `UK_o24cp6e4qgulav02a5hcpd08b` (`customer_customerId`),
  CONSTRAINT `FKrfae7ee5ta4r31r1n8lpnbwmt` FOREIGN KEY (`customer_customerId`) REFERENCES `customer` (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,2),(2,3),(8,4);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_product`
--

DROP TABLE IF EXISTS `cart_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_product` (
  `Cart_cartId` int NOT NULL,
  `productlist_productId` int NOT NULL,
  UNIQUE KEY `UK_fssg0ggyvtpfjq5cwghv7dxgq` (`productlist_productId`),
  KEY `FKee0rqrfct9o3voq221l2k5kbf` (`Cart_cartId`),
  CONSTRAINT `FKee0rqrfct9o3voq221l2k5kbf` FOREIGN KEY (`Cart_cartId`) REFERENCES `cart` (`cartId`),
  CONSTRAINT `FKs21g7ympkvw2uptf2hwrq7qj0` FOREIGN KEY (`productlist_productId`) REFERENCES `product` (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_product`
--

LOCK TABLES `cart_product` WRITE;
/*!40000 ALTER TABLE `cart_product` DISABLE KEYS */;
INSERT INTO `cart_product` VALUES (8,1),(8,2),(8,3);
/*!40000 ALTER TABLE `cart_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `catId` int NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(50) NOT NULL,
  PRIMARY KEY (`catId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Electronics'),(2,'Electronics'),(3,'fashion');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customerId` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `is_deleted` int NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `mobileNumber` varchar(12) NOT NULL,
  `password` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `address_addressId` int DEFAULT NULL,
  PRIMARY KEY (`customerId`),
  UNIQUE KEY `UK_lff31qpmftf6n3c1wtbytskdx` (`password`),
  UNIQUE KEY `UK_mufchskagt7e1w4ksmt9lum5l` (`username`),
  UNIQUE KEY `UK_j233nk0xoy7w616mawvlgnx08` (`address_addressId`),
  CONSTRAINT `FKiaq0v24tes5h9m5uv90m83vv4` FOREIGN KEY (`address_addressId`) REFERENCES `address` (`addressId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'ssd@','saru',1,'singha','000000000','queen','saru123',1),(2,'sk@123','salman',0,'khan','9022998239','king','salman123',2),(3,'sk@gam','sam',0,'jake','9898989089','kingsman','sam123',3),(4,'sd@','salman',0,'khan','9090090900','king123','S123',4);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderId` int NOT NULL AUTO_INCREMENT,
  `orderDate` date NOT NULL,
  `orderStatus` varchar(50) NOT NULL,
  `address_addressId` int DEFAULT NULL,
  `customer_customerId` int DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  UNIQUE KEY `UK_eesfr6ywnbhnlq7fu429lfmm9` (`address_addressId`),
  UNIQUE KEY `UK_c0kesnj1hw5fqq2oiu98f0r18` (`customer_customerId`),
  CONSTRAINT `FKef1cnbnpd35juxuld1dxnmq05` FOREIGN KEY (`customer_customerId`) REFERENCES `customer` (`customerId`),
  CONSTRAINT `FKkimj2bi26kxibj7rum5t0jgh3` FOREIGN KEY (`address_addressId`) REFERENCES `address` (`addressId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (2,'2022-02-02','Arrived',2,3);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_product`
--

DROP TABLE IF EXISTS `orders_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_product` (
  `Orders_orderId` int NOT NULL,
  `productList_productId` int NOT NULL,
  UNIQUE KEY `UK_sl3cw76l0lwn9w5q31kldbt67` (`productList_productId`),
  KEY `FKsxanwy05liv76oojtvaab4ux1` (`Orders_orderId`),
  CONSTRAINT `FK4nryrowrrj6saa47p930bysw8` FOREIGN KEY (`productList_productId`) REFERENCES `product` (`productId`),
  CONSTRAINT `FKsxanwy05liv76oojtvaab4ux1` FOREIGN KEY (`Orders_orderId`) REFERENCES `orders` (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_product`
--

LOCK TABLES `orders_product` WRITE;
/*!40000 ALTER TABLE `orders_product` DISABLE KEYS */;
INSERT INTO `orders_product` VALUES (2,1),(2,2),(2,3);
/*!40000 ALTER TABLE `orders_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `productId` int NOT NULL AUTO_INCREMENT,
  `Quantity` int NOT NULL,
  `color` varchar(50) NOT NULL,
  `dimension` varchar(50) NOT NULL,
  `manufacturer` varchar(50) NOT NULL,
  `price` double NOT NULL,
  `productName` varchar(50) NOT NULL,
  `specification` varchar(50) NOT NULL,
  `category_catId` int DEFAULT NULL,
  `cart_productId` int DEFAULT NULL,
  PRIMARY KEY (`productId`),
  UNIQUE KEY `UK_eji6irtyj6jb20cf6uelfdsc7` (`category_catId`),
  KEY `FK5fx4wltnxadrtva6gqr3t6ve2` (`cart_productId`),
  CONSTRAINT `FK5fx4wltnxadrtva6gqr3t6ve2` FOREIGN KEY (`cart_productId`) REFERENCES `cart` (`cartId`),
  CONSTRAINT `FKq721ldbu2w1s20m706yhe6687` FOREIGN KEY (`category_catId`) REFERENCES `category` (`catId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,4,'blue','5.6','Binod',50000,'mobile','Android',1,NULL),(2,13,'black','5.5','AntEsports',555,'mouse','gaming',2,NULL),(3,20,'Olivegreen','5.5','horn',600,'wallet','wildhorn',3,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-13  0:47:20
