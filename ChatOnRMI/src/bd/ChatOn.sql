SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

DROP TABLE IF EXISTS `mensagem`;
CREATE TABLE IF NOT EXISTS `mensagem` (
  `codMensagem` bigint(20) NOT NULL AUTO_INCREMENT,
  `txtMensagem` text NOT NULL,
  `datMensagem` timestamp NOT NULL,
  `codUsuario` bigint(20) NOT NULL,
  `codSala` bigint(20) NOT NULL,
  PRIMARY KEY (`codMensagem`),
  KEY `codUsuario` (`codUsuario`),
  KEY `codSala` (`codSala`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `sala`;
CREATE TABLE IF NOT EXISTS `sala` (
  `codSala` bigint(20) NOT NULL AUTO_INCREMENT,
  `senha` varchar(8) NOT NULL,
  PRIMARY KEY (`codSala`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `nomeUsuario` varchar(35) NOT NULL,
  `codUsuario` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`codUsuario`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;
