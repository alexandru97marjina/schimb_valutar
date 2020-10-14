# Create users table and insert data

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_name` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


INSERT INTO `users` (`id`, `created_at`, `first_name`, `last_name`, `updated_at`, `user_name`) VALUES
(1, '2020-10-14 17:08:08', 'Ion', 'Ionescu', '2020-10-14 17:08:08', 'oper1'),
(2, '2020-10-14 17:08:08', 'Petru', 'Petrescu', '2020-10-14 17:08:08', 'oper2');
