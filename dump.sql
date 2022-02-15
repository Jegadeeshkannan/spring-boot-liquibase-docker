CREATE TABLE `suburb_details` (
  `suburb_id` int unsigned NOT NULL AUTO_INCREMENT,
  `suburb_name` varchar(45) DEFAULT NULL,
  `postcode` bigint DEFAULT NULL,
  PRIMARY KEY (`suburb_id`),
  UNIQUE KEY `suburb_id_UNIQUE` (`suburb_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='			';

/*
-- Query: SELECT * FROM dev_schema.suburb_details
LIMIT 0, 1000

-- Date: 2022-02-10 07:20
*/
INSERT INTO `suburb_details_1` (`suburb_id`,`suburb_name`,`postcode`) VALUES (6,'Tambaram',600045);
INSERT INTO `suburb_details_1` (`suburb_id`,`suburb_name`,`postcode`) VALUES (7,'Chrompet',600044);
INSERT INTO `suburb_details_1` (`suburb_id`,`suburb_name`,`postcode`) VALUES (8,'Pallavaram',600043);
INSERT INTO `suburb_details_1` (`suburb_id`,`suburb_name`,`postcode`) VALUES (9,'Taramani',600042);
INSERT INTO `suburb_details_1` (`suburb_id`,`suburb_name`,`postcode`) VALUES (10,'Vandalur',600034);
INSERT INTO `suburb_details_1` (`suburb_id`,`suburb_name`,`postcode`) VALUES (11,'Guduvanchery',600035);
INSERT INTO `suburb_details_1` (`suburb_id`,`suburb_name`,`postcode`) VALUES (12,'Urappakkam',600032);
INSERT INTO `suburb_details_1` (`suburb_id`,`suburb_name`,`postcode`) VALUES (13,'Potheri',600031);
