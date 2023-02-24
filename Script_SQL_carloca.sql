-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: carloca
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ALUGUEL`
--

DROP TABLE IF EXISTS `ALUGUEL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ALUGUEL` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ID_CARRO` int NOT NULL,
  `ID_CLIENTE` int NOT NULL,
  `data_retirada` date NOT NULL,
  `data_devolucao` date NOT NULL,
  `ID_Endereco_retirada` int NOT NULL,
  `ID_Endereco_devolucao` int NOT NULL,
  `quilometragem_rodada` float NOT NULL,
  `ativo` enum('S','N') NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_CARRO_idx` (`ID_CARRO`),
  KEY `ID_CLIENTE_idx` (`ID_CLIENTE`),
  KEY `ID_ENDERECO_RETIRADA_idx` (`ID_Endereco_retirada`),
  KEY `ID_ENDERECO_DEVOLUCAO_idx` (`ID_Endereco_devolucao`),
  CONSTRAINT `ID_CARRO` FOREIGN KEY (`ID_CARRO`) REFERENCES `CARROS` (`ID`),
  CONSTRAINT `ID_CLIENTE` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `CLIENTE` (`ID`),
  CONSTRAINT `ID_ENDERECO_DEVOLUCAO` FOREIGN KEY (`ID_Endereco_devolucao`) REFERENCES `ENDERECO_FILIAIS` (`ID`),
  CONSTRAINT `ID_ENDERECO_RETIRADA` FOREIGN KEY (`ID_Endereco_retirada`) REFERENCES `ENDERECO_FILIAIS` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ALUGUEL`
--

LOCK TABLES `ALUGUEL` WRITE;
/*!40000 ALTER TABLE `ALUGUEL` DISABLE KEYS */;
/*!40000 ALTER TABLE `ALUGUEL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CARROS`
--

DROP TABLE IF EXISTS `CARROS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CARROS` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `montadora` varchar(255) NOT NULL,
  `modelo` varchar(255) NOT NULL,
  `categoria` varchar(255) NOT NULL,
  `codigo_carro` int NOT NULL,
  `situacao` enum('disponivel','alugado') NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `codigo_carro_idx` (`codigo_carro`),
  CONSTRAINT `codigo_carro` FOREIGN KEY (`codigo_carro`) REFERENCES `INFO_CARROS` (`Codigo_carro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CARROS`
--

LOCK TABLES `CARROS` WRITE;
/*!40000 ALTER TABLE `CARROS` DISABLE KEYS */;
/*!40000 ALTER TABLE `CARROS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CLIENTE`
--

DROP TABLE IF EXISTS `CLIENTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CLIENTE` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `CPF` varchar(14) NOT NULL,
  `situacao` enum('ativo','inativo','inloca') NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLIENTE`
--

LOCK TABLES `CLIENTE` WRITE;
/*!40000 ALTER TABLE `CLIENTE` DISABLE KEYS */;
/*!40000 ALTER TABLE `CLIENTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ENDERECO_CLIENTES`
--

DROP TABLE IF EXISTS `ENDERECO_CLIENTES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ENDERECO_CLIENTES` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ID_CLIENTE` int NOT NULL,
  `logradouro` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `CEP` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CLIENTE_ENDERECO_idx` (`ID_CLIENTE`),
  CONSTRAINT `FK_CLIENTE_ENDERECO` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `CLIENTE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ENDERECO_CLIENTES`
--

LOCK TABLES `ENDERECO_CLIENTES` WRITE;
/*!40000 ALTER TABLE `ENDERECO_CLIENTES` DISABLE KEYS */;
/*!40000 ALTER TABLE `ENDERECO_CLIENTES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ENDERECO_FILIAIS`
--

DROP TABLE IF EXISTS `ENDERECO_FILIAIS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ENDERECO_FILIAIS` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `CEP` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ENDERECO_FILIAIS`
--

LOCK TABLES `ENDERECO_FILIAIS` WRITE;
/*!40000 ALTER TABLE `ENDERECO_FILIAIS` DISABLE KEYS */;
/*!40000 ALTER TABLE `ENDERECO_FILIAIS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `INFO_CARROS`
--

DROP TABLE IF EXISTS `INFO_CARROS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `INFO_CARROS` (
  `Codigo_carro` int NOT NULL,
  `placa` varchar(45) NOT NULL,
  `cor` enum('branco','preto','prata') NOT NULL,
  `chassi` int NOT NULL,
  `quilometragem` float NOT NULL,
  PRIMARY KEY (`Codigo_carro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `INFO_CARROS`
--

LOCK TABLES `INFO_CARROS` WRITE;
/*!40000 ALTER TABLE `INFO_CARROS` DISABLE KEYS */;
/*!40000 ALTER TABLE `INFO_CARROS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `REDES_SOCIAIS_CLIENTES`
--

DROP TABLE IF EXISTS `REDES_SOCIAIS_CLIENTES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `REDES_SOCIAIS_CLIENTES` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ID_CLIENTE` int NOT NULL,
  `endereco_rede_social` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CLIENTE_REDE_SOCIAL_idx` (`ID_CLIENTE`),
  CONSTRAINT `FK_CLIENTE_REDE_SOCIAL` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `CLIENTE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REDES_SOCIAIS_CLIENTES`
--

LOCK TABLES `REDES_SOCIAIS_CLIENTES` WRITE;
/*!40000 ALTER TABLE `REDES_SOCIAIS_CLIENTES` DISABLE KEYS */;
/*!40000 ALTER TABLE `REDES_SOCIAIS_CLIENTES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TELEFONES_CLIENTES`
--

DROP TABLE IF EXISTS `TELEFONES_CLIENTES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TELEFONES_CLIENTES` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ID_CLIENTE` int NOT NULL,
  `DDD` varchar(3) NOT NULL,
  `numero_telefone` varchar(9) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CLIENTE_TELEFONE_idx` (`ID_CLIENTE`),
  CONSTRAINT `FK_CLIENTE_TELEFONE` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `CLIENTE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TELEFONES_CLIENTES`
--

LOCK TABLES `TELEFONES_CLIENTES` WRITE;
/*!40000 ALTER TABLE `TELEFONES_CLIENTES` DISABLE KEYS */;
/*!40000 ALTER TABLE `TELEFONES_CLIENTES` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-24 11:18:20
