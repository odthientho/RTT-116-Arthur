select * from offices;
select * from employees;
-- i want to see the first and the last name of employee
select e.firstname, e.lastname, o.city from employees e, offices o
where e.office_id = o.id;
-- I want to see a list of customers for a particular employee
select * from customers where sales_rep_employee_id = 1504;
-- I want to see all customer with first name Cassidy
select * from customers where contact_lastname='Cassidy';
select * from customers where credit_limit > 10000;
-- I want to see all customers with firstname start with J
select * from customers where contact_firstname LIKE '%nn%';

-- select all customers
select * from customers;
-- insert information into a table offices
insert into offices (city, phone, address_line1, address_line2, state, country, postal_code, territory)
values ('Alpharetta', '714589', '792 Hello', 'Lawrence', 'GA', 'Vietnam', '30077', 'Hello');
-- select all from offices
select * from offices;
-- delete from offices where city is Alpharetta
delete from offices where city='Alpharetta';
delete from offices where id in (1, 2, 3, 4);
-- always update with a where clause
update offices set city = 'Lawrenceville' where id = '13';



