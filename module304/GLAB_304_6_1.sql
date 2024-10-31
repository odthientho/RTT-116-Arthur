-- Write a query to display each customer’s name (as “Customer Name”),
-- along with the name of the employee who is responsible for that customer’s orders.
-- The employee name should be in a single “Sales Rep” column, formatted as “lastName, firstName.”
-- The output should be sorted alphabetically by customer name.
select c.customer_name, concat(e.firstname, e.lastname) SalesRep
from customers c, employees e
where c.sales_rep_employee_id = e.id
order by customer_name;

-- To determine which products are the most popular with our customers.
-- For each product, list the total quantity ordered,
-- along with the total sale generated (total quantity ordered * priceEach) for that product.
-- The column headers should be “Product Name,” “Total # Ordered,” and “Total Sale.”
-- List the products by “Total Sale” descending.
select p.product_name, sum(od.quantity_ordered) TotalOrdered, sum(od.quantity_ordered * od.price_each) TotalSale
from products p, orderdetails od
where p.id = od.product_id
group by p.product_name
order by  TotalSale desc;

-- Write a query that lists order status and the number of orders with that status.
-- Column headers should be “Order Status” and “Total Orders.” Sort alphabetically by status.
select o.status, count(o.id)
from orders o
group by o.status
order by o.status asc;

-- Write a query to list, for each product line, the total number of products
-- sold from that product line. The first column should be “Product Line”
-- and the second should be “total Sold.” Order by the second column, descending.
select pl.product_line ProductLine, count(p.id) TotalSold
from productlines pl, products p
where pl.id = p.productline_id
group by pl.product_line
order by 2 desc;

-- Write a query to output the month (January, February, etc.), 4-digit year,
-- and total sales for each month. The first column should be labeled ‘Month,’
-- the second column should be labeled ‘Year,’ and the third column should be labeled ‘Payments Received.’
-- Values in the third column should be formatted as numbers with two decimals (e.g., 694,292.68).
select MONTHNAME(o.order_date) month, YEAR(o.order_date) year, format(sum(od.price_each*od.quantity_ordered),2) TotalSale
from orders o, orderdetails od
where o.id = od.order_id
group by month, year;