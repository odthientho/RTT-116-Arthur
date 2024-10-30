select * from employees;
select * from offices;
-- how many employees are in each office
-- i want to see the office name and the count of employees in that office
-- group by is called an aggregate function because we can makethings into groups
-- and ten find the information about that group
select office_id, count(*)
from employees
group by office_id;

select city, count(*)
from employees Emp
join offices Off on Emp.office_id = Off.id
group by city;

select o.city, e.office_id, count(*)
from employees e, offices o
where e.office_id = o.id
group by city;

-- i want to find the employees that has the most customers
select c.customer_name, e.firstname, e.lastname, count(*)
from customers c, employees e
where c.sales_rep_employee_id = e.id
group by c.sales_rep_employee_id
order by count(*) desc
limit 1;

-- I want to see a list of all customers for the san francisco office
select c.contact_firstname, c.contact_lastname, c.customer_name, o.city
from customers c, employees e, offices o
where c.sales_rep_employee_id = e.id and e.office_id = o.id and o.city='Boston';

-- I want to see all customers, the sale rep and office name
select c.contact_firstname, c.contact_lastname, c.customer_name, o.city
from customers c, employees e, offices o
where c.sales_rep_employee_id = e.id and e.office_id = o.id;

-- I want to see all customers that have made an order
-- I want to see customer name, office, employee name, and order date
select e.firstname, c.customer_name, o.city, ord.order_date
from customers c, offices o, employees e, orders ord
where c.sales_rep_employee_id = e.id and e.office_id = o.id and ord.customer_id = c.id
order by e.id, c.customer_name;

-- I want to see all products that have been orders
-- how many times each product has been ordered (different from quantity) -- distinct order details
-- i want to see the product that was order the most on top (order by desc)
-- order number, product name, and number of items this products was order
select *
from orderdetails;
select *
from products;
select orderdetails.product_id, count(*) NumberOfOrders, sum(orderdetails.quantity_ordered) TotalQuantity
from orderdetails
group by product_id
order by NumberOfOrders;
