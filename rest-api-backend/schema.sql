CREATE SCHEMA dev_evertec AUTHORIZATION sa; 

CREATE TABLE `orders` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(80) NOT NULL,  
  `customer_email` varchar(120) NOT NULL,  
  `customer_mobile` varchar(40) NOT NULL,  
  `status` varchar(20) NOT NULL,  
  `created_at` DATE NOT NULL,
  `updated_at` DATE,  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
