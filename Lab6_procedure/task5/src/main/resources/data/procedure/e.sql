#Написати 1 процедуру із курсором для виконання однієї із наступних задач:
#Використовуючи курсор, забезпечити динамічне створення 2х таблиць з іменами що містять штамп часу,
#структура таблиць ідентична будь-якій структурі таблиці БД. Після чого випадковим чином пострічково
#скопіювати стрічки із батьківської таблиці або в одну, або в іншу додаткові таблиці.
#Повторний запуск процедури знову створює нові аналогічні таблиці, в яких випадковим чином знову
#будуть розкинуті дані з батьківської таблиці.

CREATE DEFINER=`mysql`@`localhost` PROCEDURE `e`()
begin

DECLARE done INT DEFAULT 0;
DECLARE testId INTEGER;
DECLARE testName, testSurname, testEmail varchar(45);
DECLARE testPhoneNubmer varchar(25);
DECLARE testDate date;
DECLARE testGender varchar(25);
DECLARE cursor_name CURSOR FOR SELECT * FROM client;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

 create table new_table1(
 id integer,
 name varchar(45),
 surname varchar(45),
 phone_number varchar(12),
 email varchar(45),
 birthday date,
 gender varchar(25)
 );
 
  create table new_table2(
 id integer,
 name varchar(45),
 surname varchar(45),
 phone_number varchar(12),
 email varchar(45),
 birthday date,
 gender varchar(25)
 );

 
 
OPEN cursor_name;

label: LOOP

FETCH cursor_name INTO testId,  testName, testSurname, testEmail, testPhoneNubmer, testDate, testGender;

IF (rand()*(2-1)+1)=1 THEN 
INSERT INTO new_table1 VALUES( testId,  testName, testSurname, testEmail, testPhoneNubmer, testDate, testGender);
ELSE 
INSERT INTO new_table2 VALUES( testId,  testName, testSurname, testEmail, testPhoneNubmer, testDate, testGender);
IF done = 1 THEN LEAVE label;
CLOSE cursor_name;
END IF;

END IF;