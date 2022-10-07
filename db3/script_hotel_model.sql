-- -----------------------------------------------------
-- Schema hotel_model
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `hotel_model` ;

-- -----------------------------------------------------
-- Schema hotel_model
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hotel_model` DEFAULT CHARACTER SET utf8 ;
USE `hotel_model` ;

-- -----------------------------------------------------
-- Table `hotel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel` ;

CREATE TABLE IF NOT EXISTS `hotel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(12) NOT NULL,
  `hotel_code` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `client` ;

CREATE TABLE IF NOT EXISTS `client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(12) NOT NULL,
  `email` VARCHAR(45) NULL,
  `birthday` DATE NULL,
  `gender` VARCHAR(25) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `review`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `review` ;

CREATE TABLE IF NOT EXISTS `review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `raiting` VARCHAR(45) NULL,
  `description` VARCHAR(200) NULL,
  `date` DATE NOT NULL,
  `client_id` INT NOT NULL,
  `hotel_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location` ;

CREATE TABLE IF NOT EXISTS `location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `hotel_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `reserved`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `reserved` ;

CREATE TABLE IF NOT EXISTS `reserved` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `from_date` DATE NOT NULL,
  `to_date` DATE NOT NULL,
  `client_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `payment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `payment` ;

CREATE TABLE IF NOT EXISTS `payment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `suma` FLOAT NOT NULL,
  `reserved_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `room`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `room` ;

CREATE TABLE IF NOT EXISTS `room` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `hotel_id` INT NOT NULL,
  `number` VARCHAR(1000) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `floor` INT NULL,
  `reserved_id` INT NOT NULL,
  `price` DECIMAL(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- INSERT STATEMENTS
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Table `hotel_model`.`hotel`
-- -----------------------------------------------------
INSERT INTO  hotel ( name, phone, hotel_code ) VALUES 
('Zora', '380990967835', 001),
('Opera', '380960962130', 002),
('Hilton', '380991967838', 003),
('Nemo', '380990730837', 004),
('Leopolis', '380921967633', 005),
('Panorama', '380980467732', 006),
('Citadel', '380990367831', 007),
('Ribas', '380960977834', 008),
('Emili', '380980967809', 009),
('Radisson', '380920967826', 010);
-- -----------------------------------------------------
-- Table `hotel_model`.`client`
-- -----------------------------------------------------
INSERT INTO  client ( name, surname, phone_number, email, gender ) VALUES 
('Nazar', 'Shpak', '380990967830', 'nazar@gmail.com', 'M'),
('Petro', 'Koshnir', '380980767837', 'petya@gmail.com', 'M'),
('Max', 'Lepkiy', '380960167835', 'maxik@gmail.com', 'M'),
('Andriy', 'Babych', '380920967432', 'andrik@gmail.com', 'M'),
('Vasyl', 'Mudryk', '380990667435', 'vasyka@gmail.com', 'M'),
('Oleg', 'Konoplia', '380983960832', 'oleg_1@gmail.com', 'M'),
('Nazar', 'Vasyl', '380965967835', 'vas_naz@gmail.com', 'M'),
('Roman', 'Stepanenko', '380924967833', 'romchik@gmail.com', 'M'),
('Borys', 'Jhonson', '380997931830', 'borik@gmail.com', 'M'),
('Bill', 'Clinton', '380991957025', 'bill@gmail.com', 'M');
-- -----------------------------------------------------
-- Table `hotel_model`.`review`
-- -----------------------------------------------------
INSERT INTO  review ( raiting, description, date, client_id, hotel_id ) VALUES 
('5', 'Convenient location of the hotel, 
 excellent breakfast.', '2022-08-01', 1, 2),
('3', 'We spent several nights here between trips. 
 We will return again and again.', '2022-08-01', 2, 1),
('3', 'We were greeted hospitably, we stopped in with pleasure.  
 Excellent service and polite employees.', '2022-08-01', 7, 8),
('5', 'I liked everything, it is clean, tidy, 
 everything you need for a good rest is there', '2022-08-01', 9, 2),
('4', 'Excellent location of the hotel and very tasty 
 cuisine in the restaurant on the first floor.', '2022-08-01', 3, 9),
('4', 'I liked the atmosphere of the room', '2022-08-01', 6, 7),
('3', 'very cozy!', '2022-08-01', 5, 6),
('4', 'Always clean, delicious cuisine.', '2022-08-01', 4, 5),
('3', 'Modern interior, friendly staff.', '2022-08-01', 3, 4),
('4', 'Liked very much.', '2022-07-15', 2, 3);
-- -----------------------------------------------------
-- Table `hotel_model`.`location`
-- -----------------------------------------------------
INSERT INTO  location ( city, street, hotel_id ) VALUES 
('Lviv', 'Schevchenka', 1),
('Odesa', 'Zhukovsky', 2),
('Warsaw', 'Ratuszowa', 3),
('Ternopil', 'Bandery', 4),
('Wroclaw', 'Grodzka', 5),
('Dnipro', 'Franka', 6),
('Kharkiv', 'Schevchenka', 7),
('Lublin', 'Lwowska', 8),
('Katowice', 'Ordona', 9),
('Kyiv', 'Lypinsky', 10);
-- -----------------------------------------------------
-- Table `hotel_model`.`reserved`
-- -----------------------------------------------------
INSERT INTO  reserved ( from_date, to_date, client_id ) VALUES 
('2021-09-01', '2021-09-05', 1),
('2022-10-02', '2022-10-03', 2),
('2020-08-01', '2020-08-10', 3),
('2020-08-04', '2020-08-20', 4),
('2022-03-15', '2022-03-22', 5),
('2022-08-18', '2022-08-27', 6),
('2021-08-05', '2021-08-07', 7),
('2022-05-13', '2022-05-16', 8),
('2021-07-01', '2021-07-08', 9),
('2022-04-09', '2022-04-11', 10);
-- -----------------------------------------------------
-- Table `hotel_model`.`payment`
-- -----------------------------------------------------
INSERT INTO  payment ( date, suma, reserved_id ) VALUES 
('2022-04-09', 5000, 10),
('2021-07-01', 1500, 9),
('2022-05-13', 3000, 8),
('2021-08-05', 8000, 7),
('2022-08-18', 9000, 6),
('2022-03-15', 4500, 5),
('2020-08-04', 7000, 4),
('2020-08-01', 2000, 3),
('2022-10-02', 3500, 2),
('2021-09-01', 6000, 1);
-- -----------------------------------------------------
-- Table `hotel_model`.`room`
-- -----------------------------------------------------
INSERT INTO  room (number, type, floor, price, hotel_id, reserved_id ) VALUES 
(50, 'Standart', 20, 1500, 2, 1),
(24, 'Standart', 10, 2000, 1, 9),
(7, 'Standart', 2, 3000, 3, 10),
(18, 'Standart', 6, 500, 5, 5),
(3, 'Standart', 1, 800, 7, 2),
(15, 'Standart', 5, 900, 6, 8),
(32, 'Standart', 12, 1600, 9, 4),
(40, 'Standart', 18, 2100, 8, 7),
(27, 'Standart', 11, 4000, 10, 6),
(1, 'Standart', 1, 2000, 4, 3);


ALTER TABLE review
ADD CONSTRAINT FK_review_hotel
FOREIGN KEY (hotel_id)
REFERENCES hotel (id),
ADD CONSTRAINT FK_review_client
FOREIGN KEY (client_id)
REFERENCES client (id);

ALTER TABLE reserved
ADD CONSTRAINT FK_reserved_client
FOREIGN KEY (client_id)
REFERENCES client (id);

ALTER TABLE payment
ADD CONSTRAINT FK_payment_reserved
FOREIGN KEY (reserved_id)
REFERENCES reserved (id);

ALTER TABLE location
ADD CONSTRAINT FK_location_hotel
FOREIGN KEY (hotel_id)
REFERENCES hotel (id);

ALTER TABLE room
ADD CONSTRAINT FK_room_hotel
FOREIGN KEY (hotel_id)
REFERENCES hotel (id),
ADD CONSTRAINT FK_room_reserved
FOREIGN KEY (reserved_id)
REFERENCES reserved (id);

ALTER TABLE hotel ADD INDEX (id);
ALTER TABLE client ADD INDEX (id);

 -- SHOW INDEX FROM hotel;
 -- SHOW INDEX FROM room;
 -- SHOW INDEX FROM client;

