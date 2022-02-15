
CREATE TABLE `suburb_details` (
`suburb_id` int unsigned NOT NULL AUTO_INCREMENT,
`suburb_name` varchar(45) DEFAULT NULL,
`postcode` bigint DEFAULT NULL,
PRIMARY KEY (`suburb_id`),
UNIQUE KEY `suburb_id_UNIQUE` (`suburb_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='			';