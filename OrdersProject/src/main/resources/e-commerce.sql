
-- DROP SCHEMA IF EXISTS `e-commerce` ;
-- CREATE SCHEMA IF NOT EXISTS `e-commerce`;
USE `e-commerce`;

CREATE TABLE IF NOT EXISTS `e-commerce`.`country`(
	`idCountry` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    CONSTRAINT pk_country PRIMARY KEY (`idCountry`)
);

INSERT INTO `e-commerce`.`country`(name) VALUES ('USA');
INSERT INTO `e-commerce`.`country`(name) VALUES ('Poland');
INSERT INTO `e-commerce`.`country`(name) VALUES ('Argentina');
INSERT INTO `e-commerce`.`country`(name) VALUES ('Brazil');
INSERT INTO `e-commerce`.`country`(name) VALUES ('Mexico');

CREATE TABLE IF NOT EXISTS `e-commerce`.`user` (
	`idUser` INT NOT NULL AUTO_INCREMENT,
    `firstName` VARCHAR(50) NOT NULL,
    `lastName` VARCHAR(50) NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    `address` VARCHAR(50) NOT NULL,
    `phoneNumber` VARCHAR(50) NOT NULL,
    `idCountry` INT NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (`idUser`),
    CONSTRAINT fk_user_country FOREIGN KEY (`idCountry`) REFERENCES `e-commerce`.`Country`(`idCountry`)
);

INSERT INTO `e-commerce`.`User`(firstName, lastName, email, address, phoneNumber, idCountry) VALUES ('Franco', 'Magne', 'francooo@gmail.com', 'My House 456', '1122334455', 3);
INSERT INTO `e-commerce`.`User`(firstName, lastName, email, address, phoneNumber, idCountry) VALUES ('Jane', 'Smith', 'jane.smith@outlook.com', '123 Main St', '3659678451', 2);
INSERT INTO `e-commerce`.`User`(firstName, lastName, email, address, phoneNumber, idCountry) VALUES ('Charlie', 'Park', 'park.charlie@gmail.com', '789 Oak St', '2899657844', 1);
INSERT INTO `e-commerce`.`User`(firstName, lastName, email, address, phoneNumber, idCountry) VALUES ('Ana', 'Martinez', 'ana.martinez@hotmail.com', '987 Pine St', '3369865541', 4);
INSERT INTO `e-commerce`.`User`(firstName, lastName, email, address, phoneNumber, idCountry) VALUES ('Luis', 'Perez', 'luis.perez@example.com', 'Av. Puebla 2564', '1457823104', 5);


CREATE TABLE IF NOT EXISTS `e-commerce`.`category` (
	`idCategory` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY (`idCategory`)
);

INSERT INTO `e-commerce`.`Category`(name) VALUES ('Electronics');
INSERT INTO `e-commerce`.`Category`(name) VALUES ('Clothing');
INSERT INTO `e-commerce`.`Category`(name) VALUES ('Books');
INSERT INTO `e-commerce`.`Category`(name) VALUES ('Toys');
INSERT INTO `e-commerce`.`Category`(name) VALUES ('Beauty & Health');
INSERT INTO `e-commerce`.`Category`(name) VALUES ('Sports & Outdoors');
INSERT INTO `e-commerce`.`Category`(name) VALUES ('Automotive');
INSERT INTO `e-commerce`.`Category`(name) VALUES ('Furniture');


CREATE TABLE IF NOT EXISTS `e-commerce`.`store` (
	`idStore` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `address` VARCHAR(50) NOT NULL,
    `reputation` INT NOT NULL CHECK (`reputation` BETWEEN 1 AND 100),
    `idCountry` INT NOT NULL,
    CONSTRAINT pk_store PRIMARY KEY (`idStore`),
    CONSTRAINT fk_store_country FOREIGN KEY (`idCountry`) REFERENCES `e-commerce`.`Country`(`idCountry`)
);

INSERT INTO `e-commerce`.`store` (name, address, reputation, idCountry) VALUES ("Just Sports", "Av. Sta. Fe 1955", 89, 3);

CREATE TABLE IF NOT EXISTS `e-commerce`.`product` (
	`idProduct` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `description` VARCHAR(50) NOT NULL,
    `price` DOUBLE NOT NULL CHECK (`price` > 0),
    `stock` INT NOT NULL CHECK (`stock` > 0),
    `idCategory` INT NOT NULL,
    `idStore` INT NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (`idProduct`),
    CONSTRAINT fk_product_category FOREIGN KEY (`idCategory`) REFERENCES `e-commerce`.`Category`(`idCategory`) ON DELETE CASCADE,
    CONSTRAINT fk_product_store FOREIGN KEY (`idStore`) REFERENCES `e-commerce`.`Store`(`idStore`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `e-commerce`.`payment` (
	`idPayment` INT NOT NULL AUTO_INCREMENT,
    `method` VARCHAR(50) NOT NULL,
    CONSTRAINT pk_payment PRIMARY KEY (`idPayment`)
);

INSERT INTO `e-commerce`.`Payment`(method) VALUES ('Cash');
INSERT INTO `e-commerce`.`Payment`(method) VALUES ('Credit Card');
INSERT INTO `e-commerce`.`Payment`(method) VALUES ('Debit Card');
INSERT INTO `e-commerce`.`Payment`(method) VALUES ('Bank Transfer');
INSERT INTO `e-commerce`.`Payment`(method) VALUES ('Cryptocurrency');

CREATE TABLE IF NOT EXISTS `e-commerce`.`order` (
    `idOrder` INT NOT NULL AUTO_INCREMENT,
    `idUser` INT NOT NULL,
    `totalPrice` DOUBLE NOT NULL,
    `orderDate` VARCHAR(50) NOT NULL,
    `idPayment` INT NOT NULL,
    `isPaid` BOOLEAN NOT NULL,
    CONSTRAINT pk_order PRIMARY KEY (`idOrder`),
    CONSTRAINT fk_order_user FOREIGN KEY (`idUser`) REFERENCES `e-commerce`.`User`(`idUser`) ON DELETE CASCADE,
    CONSTRAINT fk_order_payment FOREIGN KEY (`idPayment`) REFERENCES `e-commerce`.`Payment`(`idPayment`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `e-commerce`.`order_product` (
    `idOrder` INT NOT NULL,
    `idProduct` INT NOT NULL,
    `quantity` INT NOT NULL CHECK (`quantity` > 0),
    CONSTRAINT pk_order_product PRIMARY KEY (`idOrder`, `idProduct`),
    CONSTRAINT fk_order FOREIGN KEY (`idOrder`) REFERENCES `e-commerce`.`Order`(`idOrder`) ON DELETE CASCADE,
    CONSTRAINT fk_product FOREIGN KEY (`idProduct`) REFERENCES `e-commerce`.`Product`(`idProduct`) ON DELETE CASCADE
);






