#Забезпечити реалізацію звязку М:М між 2ма таблицями, тобто вставити
#в стикувальну таблицю відповідну стрічку за реально-існуючими значеннями
#(напр. surname, name) в цих основних таблицях

CREATE DEFINER=`mysql`@`localhost` PROCEDURE `b`(areserved_id integer)
begin

declare room_id integer;
set room_id = (select room.id from room where reserved_id=areserved_id);

insert into new_table3 values(areserved_id, room_id);

END