CREATE DATABASE IF NOT EXISTS carrental DEFAULT CHARACTER SET  'UTF8';
USE carrental;



CREATE TABLE IF NOT EXISTS carcategory (
	`id` INT NOT NULL auto_increment,
	`categoryname` VARCHAR(50) NOT NULL,
	`lastupdate` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
);




CREATE TABLE IF NOT EXISTS car(
	`id` INT NOT NULL auto_increment,
	`carname` VARCHAR(50) NOT NULL,
	`carcategory` INT,
	`licencenumber` VARCHAR(10) ,
	`lastupdate` TIMESTAMP  NOT NULL,
	PRIMARY KEY (`id`) USING BTREE,
	FOREIGN KEY (`carcategory`) REFERENCES carcategory(`id`)
		ON DELETE CASCADE
		ON UPDATE CASCADE

);


CREATE TABLE `carrental`  (
  `id` int(11) NOT NULL,
  `carid` int(11) NULL DEFAULT NULL,
  `beginat` timestamp(0) NULL DEFAULT NULL,
  `endat` timestamp(0) NULL DEFAULT NULL,
  `lastupdate` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
	FOREIGN KEY (`carid`) REFERENCES car(`id`)
		ON DELETE CASCADE
		ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


DELETE FROM carrental;
DELETE FROM car;
DELETE FROM carcategory;

--DECLARE carcategoryid INT;

INSERT INTO carcategory (categoryname,lastupdate) VALUES ('Toyota',NOW());
SET @carcategoryid=LAST_INSERT_ID();
INSERT INTO car(carname,carcategory,licencenumber,lastupdate)VALUES('Toyota Camry',@carcategoryid,'G:1234728',NOW());
INSERT INTO car(carname,carcategory,licencenumber,lastupdate)VALUES('Toyota Camry',@carcategoryid,'G:1234729',NOW());

INSERT INTO carcategory (categoryname,lastupdate) VALUES ('BMW',NOW());
SET @carcategoryid=LAST_INSERT_ID();
INSERT INTO car(carname,carcategory,licencenumber,lastupdate)VALUES('BMW 650',@carcategoryid,"G:2234729",NOW());
INSERT INTO car(carname,carcategory,licencenumber,lastupdate)VALUES('BMW 650',@carcategoryid,"G:2234723",NOW());

--SELECT LAST_INSERT_ID();
SELECT c.carname,c.licencenumber,cat.categoryname from car c
LEFT JOIN carcategory cat on c.carcategory = cat.id

