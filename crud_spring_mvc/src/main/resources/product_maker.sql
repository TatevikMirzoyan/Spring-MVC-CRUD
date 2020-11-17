--1.Գտնել այն մատակարաներին, որոնք մատակարարում են համակարգիչներ:
select distinct maker
from product
where type = 'PC';

--2.Գտնել մատակարաներին և նրանց մատակարարած մոդելների քանակը:
select maker, count(model)
from product
group by product.maker;

--3.Գտնել որ մատակարը քանի տեսակի ապրանք է մատակարարում:
select maker, count(distinct type)
from product
group by product.maker;

--4.Գտնել laptop-ների միջին գինը:
select avg(price)
from laptop;

--5.Գտնել համակարգիչների կոդերը, մոդելները, արագությունները, գինը և մատակարարներին:
select code, pc.model, speed, price, maker
from pc
         left join product on product.model = pc.model;

--6.Գտնել գունավոր տպիչների կոդը, մոդելները,գինն ու մատակարարին: Կարգավորել կոդերը ըստ գնի նվազման կարգով
select code, printer.model, price, maker
from printer
         left join product on printer.model = product.model
where printer.color = 'y'
order by price DESC;

--7.Գտնել յուրաքանչյուր  մատակարարի մատակարարած համակարգիչների կոդերը, մոդելները, արագությունները, գինը:
-- Գտնել նաև այն մոդելները, որոնց մասին ինֆորմացիա PC-ում չկա:
select maker, code, pc.model, speed, price
from pc
         right join product p on p.model = pc.model
where p.type = 'PC';

--8.Գտնել յուրաքանչյուր  մատակարարի մատակարարած համակարգիչների միջին գները:
-- Այն մատակարարների համար, որոնց մատակարարած  համակարգիչների մասին ինֆորմացիա PC-ում չկա, միջին գին համարել 0-ն:
select maker, ifnull(avg(pc.price), 0)
from pc
         right join product on product.model = pc.model
where product.type = 'PC'
group by maker;

--9.Գտնել մատակարաներին, որոնք մատակարարում են և’ գունավոր տպիչ և’ PC:
select distinct maker
from product
where product.type = 'PC'
  and maker in (
    select maker
    from product
             left join printer
                       on product.model = printer.model
    where product.type = 'Printer'
      and printer.color = 'y');

--10.Գտնել մատակարաներին, որոնք մատակարարում են 500 և ավելի արագություն ունեցող laptop-ներ, բայց չեն արտադրում տպիչներ:
select distinct maker
from product
         inner join laptop l on product.model = l.model
where speed >= 500
  and maker not in (select maker from product where type = 'Printer');