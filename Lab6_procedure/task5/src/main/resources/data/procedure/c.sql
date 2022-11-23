#Створити пакет, який вставляє 10 стрічок у довільну таблицю БД у форматі < Noname+№>,
#наприклад: Noname5, Noname6, Noname7 і т.д.
CREATE DEFINER=`mysql`@`localhost` PROCEDURE `c`( )
begin
DECLARE i INT;
SET i=1;
label:LOOP
SET i = i+1;

INSERT INTO client(name, surname,phone_number,email,gender) values(concat('Noname',i),' ',' ',' ',' ');

IF i=10 THEN 
LEAVE label;
END IF;
END LOOP label; 
END