-- select all customers
select * from customers;
-- insert information into a table offices
insert into offices (city, phone, address_line1, address_line2, state, country, postal_code, territory)
values ('Alpharetta', '714589', '792 Hello', 'Lawrence', 'GA', 'Vietnam', '30077', 'Hello');
-- select all from offices
select * from offices;
-- delete from offices where city is Alpharetta
delete from offices where city='Alpharetta';

