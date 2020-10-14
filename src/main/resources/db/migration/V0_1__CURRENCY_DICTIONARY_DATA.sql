# Create currency_dictionaries table and insert data

CREATE TABLE IF NOT EXISTS `currency_dictionaries`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `currency_code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `currency_dictionaries` (`id`,  `currency_code`, `name`) VALUES
(1, 'EUR', 'Euro'),
(2, 'RUB', 'Rubla'),
(3, 'RON', 'Leu Romanesc'),
(4, 'USD', 'Dolar American');