-- Product line with different names of products order by product line and product name
select l.product_line, p.product_name
from productlines l, products p
where l.id = p.productline_id
order by l.product_line, p.product_name;

-- I want to see the order number, the product name, and the quantity ordered
-- order by the order number (descending), then the product name (ascending) ,
-- then the quantity ordered ( fewest first)
select o.order_id, p.product_name, o.quantity_ordered
from orderdetails o, products p
where o.product_id = p.id
order by o.quantity_ordered desc, p.product_name, o.quantity_ordered;

-- I want to see all payments made by customers.
-- The result should show the customer name, the check number, payment date, and the amount.
-- I want the result set ordered by the customer name (ascending),
-- the payment date ( descending  newest first)
select c.customer_name, p.check_number, p.payment_date, p.amount
from payments p, customers c
where p.customer_id = c.id
order by c.customer_name , payment_date desc;

-- I want to see the orders and all products in that order - order number and product name
-- order by the order number ascending and the product name descending.
select o.order_id order_number, p.product_name
from orderdetails o, products p
where o.product_id = p.id
order by o.order_id, p.product_name desc;

-- I want to see the number of products in each order -
-- I want to see the order id and the count of each product in that order ... order by count(*) desc
select o.order_id, p.product_name, count(*) NumOfProduct
from orderdetails o, products p
where o.product_id = p.id
group by p.product_name;

select order_id, sum(quantity_ordered)
from orderdetails
group by order_id;

-- I want to see the customer that has made most payments (group by customer_id)
select c.customer_name, sum(p.amount) total
from customers c
join payments p on c.id = p.customer_id
group by c.customer_name
order by total desc;

-- I want to see the office that has  the most orders (group by office_id)
select o.city, count(*) TotalOrder
from offices o, employees e, customers c, orders ord
where o.id = e.office_id and e.id = c.sales_rep_employee_id and c.id = ord.customer_id
group by o.city
order by TotalOrder;

-- I want to see the order that has the most products ( group by order_id)

-- BONUS .... I want to see the total quantity ordered for each order ...
-- we have not learned this yet .. but it group by the order_id and sum(quanity_ordered)

-- I want to see the employee first name and last name and the customer name
-- ordered by the customer name

-- I want to see the count of all orders by office

select * from orders where customer_id in (select id from customers where customer_name like 'A%');

-- which office is most profitable?
select o.city, sum((od.price_each-p.buy_price)*od.quantity_ordered) profit
from offices o, employees e, customers c, orders ord, orderdetails od, products p
where o.id = e.office_id and c.sales_rep_employee_id = e.id and ord.customer_id = c.id and od.order_id = ord.id and od.product_id = p.id
group by o.city
order by profit desc;

-- which product did we sell the most of ? I would like to see the number of orders
-- the total amount sold, and the product name
select p.product_name, Count(*) NumOfOrder, Max(o.quantity_ordered*o.price_each) Total
from products p, orderdetails o
where p.id = o.product_id;

-- which product generated the most profit by year.
-- In the result I want to see the year, the product name, and the total profit.
-- order by year desc, profit desc
select p.product_name,
       YEAR(o.order_date)                                       year,
       sum(od.quantity_ordered * (od.price_each - p.buy_price)) totalprofit
from products p,
     orderdetails od,
     orders o
where p.id = od.product_id
  and od.order_id = o.id
group by p.product_name, YEAR(o.order_date)
order by YEAR(o.order_date), totalprofit desc;