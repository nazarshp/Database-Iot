#1
select model, speed, hd, cd, price from pc
where (cd="12x" or cd="24x") and price < 600 order by speed Desc;

#2
select trip_no, ID_comp, plane, town_from, town_to, time_in from trip
WHERE hour(time_in) BETWEEN '17' AND '23' order by time_in;

#3
select trip_no, plane, name from trip as t1
left join Company as t2 on t2.ID_comp=t1.ID_comp
where t1.plane="Boeing";

#4
select count(maker) from product
where maker="A";

#5
select distinct maker from product
where maker in (select maker from product where type="Printer")
and type="Laptop";

#6
select place, CONCAT('ряд: ', left(place,1)) AS "Option 1",
              CONCAT('місце: ', right(place,1)) AS "Option 2" 
              from pass_in_trip;
              
#7
select cast(time_in as date) Date, count(*) from trip
where town_to="Moscow" group by date;

#8
select distinct maker, min(price) from product as t1
left join PC as t2 on t2.model = t1.model
where t1.type="PC" group by maker;

#9 
select trip_no, name, plane, town_from, town_to, 
(case 
when timediff(time_in , time_out) < 0 then timediff(time_out, time_in)
else timediff(time_in , time_out)
end )
as flight_time 
from trip as t1
left join Company as t2 on t2.ID_comp=t1.ID_comp;

#10
(select model, price from laptop)
union (select model, price from pc)
union (select model, price from printer)
order by model;

/*SELECT model, price FROM laptop
WHERE price = (SELECT MIN(price) FROM laptop order by model)
UNION
SELECT model, price
FROM PC
WHERE price = (SELECT  MIN(price) FROM pc order by model)
union
SELECT model, price
FROM Printer
WHERE price = (SELECT  MIN(price) FROM printer order by model);*/

#11 
/*БД «Комп. фірма». З таблички product витягнути maker які роблять всі типи */
select distinct maker from product
where type = 'Laptop' and  maker = 
any ( SELECT  maker FROM product WHERE type="PC" and maker = 
any ( SELECT  maker FROM product WHERE type="printer"));

#12
/*БД «Аеропорт». Вивести дані для таблиць Passenger та Pass_in_trip ім'я та місце пасажира*/
select name, place from passenger as t1
inner join Pass_in_trip as t2 on t2.ID_psg=t1.ID_psg;

#13 
/*БД «Комп. фірма». Посортувати по-ціні laptop, pc, printer і вивести price впорядку спадання*/
select "Laptop", price from laptop
union select "PC", price from pc
union select "Printer", price from printer order by price desc;

#14 
/*БД «Комп. фірма». Для таблиці Laptop вивести всю інформацію з ко-
ментарями в кожній комірці, наприклад, 'модель: 1121', 'ціна: 600,00'*/
select model, price, 
concat("модель: ", model, " ціна: ", price) as "option" from Laptop;

#15 /*БД «Аеропорт». Вивести прізвища які не починаються на букву "C" з таблиці Passenger*/
select name from passenger
where name not like '% C%';

#16 
/*БД «Комп. фірма». Вивести maker який випускає Laptop але не PC*/
select maker from product
where type = 'Laptop' and not maker = any ( SELECT  maker 
FROM product
WHERE type="PC" );

#17
/*БД «Комп. фірма». Знайдіть номери моделей та ціни всіх продуктів (будь-якого типу), що випущені виробником 'A'. 
Вивести: maker, model, type, price. */ 
select  t1.maker, t1.model, t1.type, t2.price from product as t1
inner join Laptop as t2 on t2.model=t1.model where maker="A"
union select  t3.maker, t3.model, t3.type, t4.price from product as t3
inner join PC as t4 on t4.model=t3.model where maker="A"
union select t5.maker, t5.model, t5.type, t6.price from product as t5
inner join Printer as t6 on t6.model=t5.model where maker="A";

#18
/*БД «Аеропорт». Вивести дані для таблиці Trip з об’єднаними зна- ченнями двох стовпців: 
 town_from та town_to, з додатковими комента- рями типу: 'from Rostov to Paris'.*/
select town_from, town_to, 
concat('from ', town_from, ' to ', town_to) as "option" from trip;

#19
/*БД «Аеропорт». Вивести номер рейсу, ім'я компанії, літак, ім'я пасажира і місце */
select  t1.trip_no, t4.name, plane, t3.name, place from trip as t1
left join Pass_in_trip as t2 on t2.trip_no = t1.trip_no
left join Passenger as t3 on t3.ID_psg = t2.ID_psg
left join Company as t4 on t4.ID_comp = t1.ID_comp;

#20
/*БД «Аеропорт». З таблиці Pass_in_trip вивести дати, коли були зайняті місця в першому ряді.*/
select date from pass_in_trip
where place like'1%';


                      
 

