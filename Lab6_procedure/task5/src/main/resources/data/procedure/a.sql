#Забезпечити параметризовану вставку нових значень у довільну таблицю
CREATE DEFINER=`mysql`@`localhost` PROCEDURE `a`(
aName varchar(45),
aSurname varchar(45),
aPhone_number varchar(12),
aEmail varchar(45),
aBirthDay date,
aGender varchar(25))
begin
insert into client(name,surname, phone_number,email, birthday, gender) values(aName, aSurname, aPhone_number, aEmail, aBirthDay, aGender);
END