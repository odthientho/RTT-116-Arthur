-- this is the left join syntax for 2 tables
SELECT  c.id as customer_id,  c.customer_name, o.id as order_id, o.status
FROM customers c
         LEFT JOIN orders o ON c.id = o.customer_id;

-- this is a regular query (this is an inner join)
SELECT  c.id as customer_id,  c.customer_name, o.id as order_id, o.status
FROM customers c, orders o
where c.id = o.customer_id
order by c.id;

-- this is the same regular query accept using the MySQL syntax 
-- this is the same as above accept using the inner join syntax from mysql
SELECT  c.id as customer_id,  c.customer_name, o.id as order_id, o.status
FROM customers c
         INNER JOIN orders o ON c.id = o.customer_id
order by c.id;

-- self join
select e.id, e.firstname, e.lastname, e.job_title, concat(concat(m.firstname, ' '), m.lastname) Manager, m.job_title
from employees e, employees m
where e.reports_to  = m.id;

-- when doing a self join you use the same table in the from 2 times
-- self referencing table
select e.id, e.lastname, e.firstname, e.job_title, m.id as manager_id, m.lastname as manager_lastname, m.firstname as manager_firstname, m.job_title
from employees e, employees m
where e.reports_to = m.id;

-- ======================= UNION =========================
-- does get used from time to time
-- main use is in reports or very complex queryies
-- union does not include duplicates - meaning after mering the result sets there are no duplicates
-- union all inludes duplicates

select * from customers where customer_name like 'A%'
union
select * from customers where customer_name like 'A%';

select phone from customers
where customer_name like 'A%'
union
select firstname from employees;