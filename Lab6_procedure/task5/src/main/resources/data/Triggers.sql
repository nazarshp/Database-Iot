#g Створити таблицю-журнал, в якій вести логи зі штампом часу при модифікації даних для таблиці
CREATE DEFINER=`mysql`@`localhost` TRIGGER `client_AFTER_UPDATE` AFTER UPDATE ON `client` FOR EACH ROW BEGIN
SET time_zone = '+02:00';
insert into udating_logs values (OLD.id,NOW());
END

#f Створити таблицю-журнал, в якій вести логи зі штампом часу при видаленні даних для певної таблиці
CREATE DEFINER=`mysql`@`localhost` TRIGGER `client_AFTER_DELETE` AFTER DELETE ON `client` FOR EACH ROW BEGIN
SET time_zone = '+02:00';
insert into deleting_logs values (OLD.id,NOW());
END

#c Заборонити видалення стрічок з таблиці
CREATE DEFINER = CURRENT_USER TRIGGER `hotel_model`.`hotel_BEFORE_DELETE` BEFORE DELETE ON `hotel` FOR EACH ROW
BEGIN
SIGNAL SQLSTATE '45000';
SET MESSAGE_TEXT = 'Deleting denied';
END

#1Додати до БД 1 додаткову довільну таблицю і звязати з іншою існуючою таблицею звязком  1:M
#Однак для забезпечення цілісності значень використати тригери замість фізичного зовнішнього ключа

CREATE DEFINER=`mysql`@`localhost` TRIGGER `room_AFTER_INSERT` AFTER INSERT ON `room` FOR EACH ROW BEGIN
update rooms_on_floor set rooms_count= (select count(room.floor) from room where room.floor=rooms_on_floor.floor_number);
END

CREATE DEFINER=`mysql`@`localhost` TRIGGER `room_AFTER_DELETE` AFTER DELETE ON `room` FOR EACH ROW BEGIN
update rooms_on_floor set rooms_count= (select count(room.floor) from room where room.floor=rooms_on_floor.floor_number);
END

