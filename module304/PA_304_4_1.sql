-- Display the name, product line, and buy price of all products.
-- The output columns should display as: “Name,” “Product Line,” and “Buy Price.”
-- The output should display the most expensive items first.
select p.product_name Name, pl.product_line ProductLine, p.buy_price BuyPrice
from products p, productlines pl
where p.productline_id = pl.id
order by BuyPrice DESC;

-- Display the first name, last name, and city name of all customers from Germany.
-- The output columns should display as: “First Name,” “Last Name,” and “City.”
-- The output should be sorted by “Last Name” (ascending).
select contact_firstname, contact_lastname, city
from customers
where country = 'Germany'
order by contact_lastname asc;

-- Display each of the unique values of the status field in the orders table.
-- The output should be sorted alphabetically, ascending.
select DISTINCT orders.status
from orders
group by status
order by status asc;

-- Display all fields from the payments table for payments made on or after January 1, 2005.
-- The output should be sorted by the payment date from highest to lowest.
select *
from payments
where payment_date > '2005-01-01'
order by payment_date desc;

-- Display the last Name, first Name, email address,
-- and job title of all employees working out of the San Francisco office.
-- The output should be sorted by “Last Name.”
select e.lastname, e.firstname, e.email, o.city
from employees e, offices o
where o.id = e.office_id and o.city = 'San Francisco'
order by e.lastname;

-- Display the name, product line, scale, and vendor of all of the car products
-- both classic and vintage. The output should display all vintage cars first
-- (sorted alphabetically by name), and all classic cars last (also sorted alphabetically by name).
select p.product_name, pl.product_line, p.product_scale, p.product_vendor
from productlines pl, products p
where p.productline_id = pl.id
    and (LOWER(pl.product_line) like 'classic%'
           or LOWER(pl.product_line) like 'vintage%')
order by pl.product_line desc, p.product_name asc;